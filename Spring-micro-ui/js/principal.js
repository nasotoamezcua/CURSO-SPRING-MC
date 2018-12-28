$(document).ready(function () {
    var id = sessionStorage.getItem("id");        
	let token = sessionStorage.getItem("k");
	

	$('#loadingDiv').show();
    $.ajax({
        type: "GET",
        url:  "http://localhost:8099/micro-client/persona/leer/" + id,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
		async: true,
		headers: {
				"Authorization": "Bearer " + token
				},
        success: function (models) {
            var nombre_completo = models.nombre_completo;
            var pais = models.pais;
            var bio = models.bio;
            var foto = models.fotoURL;

            var headerName = $('[id$=headerName');
            var lblPais = $('[id$=lblPais');
            var lblBio = $('[id$=lblBio');
            $("#lblFoto").attr("src", foto);

            headerName.html(nombre_completo);
            lblPais.html(pais);
            lblBio.html(bio);
        },
		complete: function(){
			$('#loadingDiv').hide();
		},

        error: function (XMLHttpRequest, textStatus, errorThrown) {
            toastr.error("Request: " + XMLHttpRequest.toString() + "\n\nStatus: " + textStatus + "\n\nError: " + errorThrown);
        }
    });

    $.ajax({
        type: "GET",
        url: "http://localhost:8099/micro-client/habilidad/listar/" + id, //+ "?access_token=" + token, //"https://mito-zuul-sp.herokuapp.com/micro-client/habilidad/listar/" + id,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
		async: true,
		headers: {
				"Authorization": "Bearer " + token
				},
        success: function (models) {
            for (var i = 0; i < models.length; i++) {                      
                
                var exp = models[i].experiencia;
                var span;

                if(exp === "A"){
                    span = $('<span />').addClass('label label-success').html(models[i].nombre); 
                }else if(exp === "B"){
                    span = $('<span />').addClass('label label-info').html(models[i].nombre); 
                }else if(exp === "R"){
                    span = $('<span />').addClass('label label-warning').html(models[i].nombre); 
                }
                
                $("#lstHabilidades").append(span);
            }            
        },
		complete: function(){
			$('#loadingDiv').hide();
		},

        error: function (XMLHttpRequest, textStatus, errorThrown) {
            toastr.error("Request: " + XMLHttpRequest.toString() + "\n\nStatus: " + textStatus + "\n\nError: " + errorThrown);
        }
    });

    $("#btnCerrar").click(function () {
        sessionStorage.clear();
        window.location.href = "./index.html"
    });

    $(document).on('click', "#btnEnviar", function (e) {        
        $.ajax({
            type: "GET",
            url: "https://mito-zuul-sp.herokuapp.com/node-client/getURL",
            async: false,
            dataType: "text",
            success: function (data) {
                if (data == 'no_data') {
                    toastr.warning("No existe una constancia generada");
                } else {
                    window.open(
                        data
                    );
                }
            },

            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log("Request: " + XMLHttpRequest.toString() + "\n\nStatus: " + textStatus + "\n\nError: " + errorThrown);
            }
        });
    });

});