function showPassword() {
    
        var key_attr = $('#key').attr('type');
    
        if (key_attr != 'text') {
    
            $('.checkbox').addClass('show');
            $('#key').attr('type', 'text');
    
        } else {
    
            $('.checkbox').removeClass('show');
            $('#key').attr('type', 'password');
    
        }
    
    }
	
		    
    $(document).ready(function () {
        $("#btn-login").click(function () {
			let usuario = document.getElementById("txtUsuario").value;   
			let clave = document.getElementById("txtClave").value;   
            let correo = document.getElementById("email").value; 
			
			let body = {
				"grant_type":"password",
				//"client_id":"acme",
				"username": usuario,
				"password": clave				
				}
				
			//comentado porque Zuul lo provee
			//let encoded = window.btoa("acme:secret");	
			//console.log(encoded);			
		
			$.ajax({
					type: "POST",
					url:  "http://localhost:8099/uaa/oauth/token",
					contentType: "application/x-www-form-urlencoded",
					dataType: "json",				
					//comentado porque Zuul lo provee
					/*headers: {
						"Authorization": "Basic " + encoded					
					},*/
					data: body,
					success: function (data) {						
						console.log(data);
						token = data.access_token;
						sessionStorage.setItem("k", token);	

						$.ajax({
							type: "GET",
							url:  "http://localhost:8099/micro-client/persona/leerCorreo/" + correo + "?access_token=" + token, //"https://mito-zuul-sp.herokuapp.com/micro-client/persona/leerCorreo/" + correo,
							contentType: "application/json; charset=utf-8",
							dataType: "json",				
							success: function (data) {                
							
								if(data > 0){
									sessionStorage.setItem("id", data);
									window.location.href = "./principal.html";
								}else{
									toastr.warning("Credenciales incorrectas");
								}
							},									
						});
					},
	
					error: function (XMLHttpRequest, textStatus, errorThrown) {
						toastr.error("Request: " + XMLHttpRequest.toString() + "\n\nStatus: " + textStatus + "\n\nError: " + errorThrown);
					}
				});	            
        });
    });