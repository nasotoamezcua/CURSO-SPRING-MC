<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Persona</title>
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
              crossorigin="anonymous">

    </head>
    <body>
        <form:form action="registrar" method="post" modelAttribute="command">
            <div class="form-group">
                <fieldset>
                    <div>
                        <label for="id">Persona ID</label> 
                        <form:input path="id" type="text" class="form-control"
                                    readonly="true"
                               placeholder="Persona ID" />
                    </div>
                    <div>
                        <label for="nombres">Nombres</label> 
                        <form:input path="nombres" type="text" class="form-control"                               
                               placeholder="Nombres" />
                    </div>
                    <div>
                        <label for="apellidos">Apellidos</label> 
                        <form:input path="apellidos" type="text" class="form-control"                               
                               placeholder="Apellidos" />
                    </div>

                    <div>
                        <input type="submit" class="btn-primary" value="Aceptar" />
                    </div>
                </fieldset>
            </div>
        </form:form>                                       
    </body>
</html>