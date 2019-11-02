$(document).ready(function(){
    var usuario = {};
    $('.cadastro').submit(function(){
        var form = $(this);
        usuario.nome = $("#nome").val();
        usuario.email = $("#email").val();
        usuario.senha = $("#senha").val();
        var usuarioObj = JSON.stringify(usuario);
        // var data = $(this).serialize();
        // var data = JSON.stringify(data);

        console.log(usuarioObj, form);

        $.ajax({
            url: "http://localhost:8080/usuarios",
            data: usuarioObj,
            type: "POST",
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            beforeSend: function () {
                $('.cadastro').slideToggle();
            }, success: function () {
                alert("sucesso");
            }, error: function (error) {
                alert(error);
            }
        });


        return false;
    })
});