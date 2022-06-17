<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Document</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/ingresar.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
    <div class="contact_form">

        <div class="formulario">      
          <h1><center>Agregar Genero</center></h1>
            <h3><center>Undergroud Record Lavel</center></h3>
            <c:forEach var="genero" items="${listaGeneroEdit}">
                <form method="post" action="genero?accion=editGenero&idGenero=${genero.getidGenero()}">         
                    <p>
                        <div class="content-input">
                            <label>Nombre del Genero</label>
                                <span class="obligatorio">*</span>
                            <input type="text" name="nombreGenero" id="nombreGenero" required="obligatorio value="${genero.getnombreGenero()}">
                        </div>
                    </p>                          
                  
                    <button type="submit" class="submitBtn" name="accion" value="editGenero&idGenero=${genero.getidGenero()}">Guardar</button>                       
              </form>
            </c:forEach>
        </div>  
      </div>
</body>
</html>
