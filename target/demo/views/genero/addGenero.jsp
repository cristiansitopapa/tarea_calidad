<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Simple Login 01</title>
        <link rel="stylesheet" href="assets/css/ingresar.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css">

    </head>

    <body>
        <div class="contact_form">

            <div class="formulario">      
              <h1><center>Agregar Genero</center></h1>
                <h3><center>Undergroud Record Lavel</center></h3>
                <form method="post" action="genero?accion=addGenero" id="form">         
                        <p>
                            <div class="form">
                                <label for="nombreGenero">Nombre Genero</label>
                                    <span class="obligatorio">*</span>
                                <input type="text" name="nombreGenero" id="nombreGenero" required="obligatorio"><span class="barra"></span>
                            </div>
                        </p>
                      
                        <p>
                            <div class="form-check">
                                <input type="checkbox" name="chkestado" id="estadoGenero" checked class="form-check-input">
                                <label for="estadoGenero"> Activo</label>
                            </div>
                        </p>                            
                      
                        <button type="submit" name="control" value="addGenero">Enviar</button>                            
                  </form>
            </div>  
          </div>
    <%@include file="footer.jsp" %>