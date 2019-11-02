$(document).ready(function(){
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
            beforeSend: function () {
                $('.cadastrar').slideToggle();
            }, success: function (resposta) {
                $('.logado').show(3000);
            }
        });


        return false;
    })
});