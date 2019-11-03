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
    })
    // /BUSCAR PROBLEMAS

    // CADASTRO DE OCORRÊNCIA
    var ocorrencia = {};
    $('.ocorrencia').submit(function(){
        ocorrencia.usuario_id = $("#usuario_id").val();
        ocorrencia.problemas_id = $("#problema_id").val();
        ocorrencia.latitude = $("#latitude").val();
        ocorrencia.longitude = $("#longitude").val();
        ocorrencia.descricao = $("#descricao").val();
        ocorrencia.data_cadastro = $("#descricao").val();
        var ocorrenciaObj = JSON.stringify(ocorrencia);

        $.ajax({
            url: "http://localhost:8080/ocorrencias",
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
                    id: 'foo',
                    name: 'usuario_id',
                    value: resposta
                }).appendTo('form#ocorrencia');
                $('.logado').show(3000);
            }
        });
        return false;
    })

    // /CADASTRO DE OCORRÊNCIA
});