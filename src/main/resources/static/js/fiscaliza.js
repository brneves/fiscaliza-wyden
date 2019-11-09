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

    //POPULAR OS PONTOS NO MAPA
    // function populaMapa(longitude, latitude, icone, descricao) {
    //     console.log(longitude, latitude, icone, descricao);
    //     L.marker([latitude, longitude], {icon: icone}).bindPopup(descricao).addTo(map);
    // }
    
    // /CADASTRO DE OCORRÊNCIA


    //GERANDO MAPA
    var map = L.map('map').setView([-2.5522755, -44.2434229], 11);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);

    var LeafIcon = L.Icon.extend({
        options: {
            shadowUrl: '../img/sombra.png',
            iconSize:     [75, 100],
            shadowSize:   [50, 64],
            iconAnchor:   [22, 94],
            shadowAnchor: [4, 62],
            popupAnchor:  [-3, -76]
        }
    });

    var onibus = new LeafIcon({iconUrl: '../img/onibus.png'}),
        acessibilidade = new LeafIcon({iconUrl: '../img/acessibilidade.png'}),
        buraco = new LeafIcon({iconUrl: '../img/buraco.png'}),
        semaforo = new LeafIcon({iconUrl: '../img/semaforo.png'});

        L.marker([-2.5004603, -44.276314199999995], {icon: onibus}).bindPopup("Parada de ônibus com defeito.").addTo(map);
        L.marker([-2.502297, -44.270685], {icon: semaforo}).bindPopup("Semáforo com defeito, apagado.").addTo(map);
        L.marker([-2.506978, -44.265632], {icon: acessibilidade}).bindPopup("Falta de acessibilidade na rua.").addTo(map);

    //BUSCA OCORRÊNCIAS
    // L.marker([])
    $.ajax({
        type: "GET",
        url: "/ocorrencias",
        success: function (ocorrencias) {
            ocorrencias.forEach(function (ocorrencia, indice) {
                // console.log(ocorrencia);
                // L.marker([ocorrencia.latitude, ocorrencia.longitude], {icon: ocorrencia.problema.icone}).bindPopup(ocorrencia.descricao).addTo(map);
            })
        }
    });
    // $.get("http://localhost:8080/ocorrencias", function (data) {
    //     console.log(data);
    //     $.each(data, function (i, d) {
    //         console.log(d.latitude, d.longitude, d.problema.icone, d.descricao);
    //         L.marker([d.latitude, d.longitude], {icon: d.problema.icone}).bindPopup(d.descricao).addTo(map);
    //     })
    // });

});