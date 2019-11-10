$(document).ready(function(){
    // CADASTRO
    var usuario = {};
    $('.cadastro').submit(function(){
        usuario.nome = $("#nome").val();
        usuario.email = $("#email").val();
        usuario.senha = $("#senha").val();
        var usuarioObj = JSON.stringify(usuario);

        $.ajax({
            url: "http://localhost:8080/usuarios",
            data: usuarioObj,
            type: "POST",
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            async: true,
            beforeSend: function () {
                $('.cadastrar').slideToggle();
            }, success: function (resposta) {
                $('<input>').attr({
                    type: 'hidden',
                    id: 'usuario_id',
                    name: 'usuario_id',
                    value: resposta
                }).appendTo('form#ocorrencia');
                $('.logado').show(3000);
            }
        });
        return false;
    })
    // /CADASTRO

    // GEOLOCALIZAÇÃO
    var mensagem = document.getElementById("mensagem")
    if(!('geolocation' in navigator)){
        $('#mensagem').addClass('alert-warning');
        $('#mensagem').innerHTML("O seu navegador não suporta Geolocalização");
    } else {
        navigator.geolocation.getCurrentPosition(function (position) {
            var latitude = position.coords.latitude;
            var longitude = position.coords.longitude;

            $('#latitude').val(latitude);
            $('#longitude').val(longitude);
        })
    }
    // /GEOLOCALIZAÇÃO

    // BUSCAR PROBLEMAS
    $.get("http://localhost:8080/problemas", function (data) {
        var selectProblema = $('#problema_id');
        $.each(data, function (i, d) {
            $('<option>').val(d.id).text(d.problema).appendTo(selectProblema);
        });
    });
    // /BUSCAR PROBLEMAS

    // CADASTRO DE OCORRÊNCIA
    var ocorrencia = {};
    $('#ocorrencia').submit(function(){

        var dataAtual = new Date();

        var ocorrencia = {
            usuario: {
                "id": $("#usuario_id").val()
            },
            problema: {
                "id": $("#problema_id").val()
            },
            latitude: $("#latitude").val(),
            longitude: $("#longitude").val(),
            descricao: $("#descricao").val(),
            dataCadastro:  dataAtual.getDate() + "/" + (dataAtual.getMonth() + 1) + "/" + dataAtual.getFullYear(),
            status: 0
        }
        var ocorrenciaObj = JSON.stringify(ocorrencia);

        $.ajax({
            url: "http://localhost:8080/ocorrencias",
            data: ocorrenciaObj,
            type: "POST",
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            async: true,
            beforeSend: function () {
                $('#modal').modal('hide');
            }, success: function (resposta) {
                $("#sucesso").show();
                $("#sucesso").html("Ocorrência cadastrada com sucesso!");
            }
        });
        return false;
    })
    
    // /CADASTRO DE OCORRÊNCIA

    // //BUSCA OCORRÊNCIAS E MONTA ARRAY COM LOCALIZAÇÕES
    locais = [];
    $.ajax({
        type: "GET",
        url: "/ocorrencias",
        success: function (ocorrencias) {

            var i = 0;
            ocorrencias.forEach(function (ocorrencia, indice) {
                locais[i] = [ocorrencia.latitude, ocorrencia.longitude, ocorrencia.problema.icone, ocorrencia.descricao]
                i++;
            })
        },
    });


    //GERANDO O MAPA
    var map;
    var centerPos = new google.maps.LatLng(-2.5522755, -44.2434229);
    var zoomLevel = 12;
    function initialize() {
        var mapOptions = {
            center: centerPos,
            zoom: zoomLevel
        };
        map = new google.maps.Map( document.getElementById("mapa"), mapOptions );

        for (i = 0; i < locais.length; i++) {

            // var conteudoMapa = '<h2>' + locais[i][3] + '<h2>' + '<p><small><strong>Latitude:</strong> ' + locais[i][0] + '</small></p>' + '<p><small><strong>Longitude: </strong>' + locais[i][[1]] + '</small></p>'

            // var infoJanela = new google.maps.InfoWindow({ content: conteudoMapa });

            marker = new google.maps.Marker({
                position: new google.maps.LatLng(locais[i][0], locais[i][1]),
                title: locais[i][3],
                map: map,
                icon: locais[i][2]
            });

            // marker.addListener('click', function () {
            //     infoJanela.open(map, marker);
            // })
        }

    }
    google.maps.event.addDomListener(window, 'load', initialize);
});