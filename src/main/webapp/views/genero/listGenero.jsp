<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
            <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
            <title>Listar Genero</title>
        </head>

        <body style="margin: 10px 20px 30px 30px;">

            <h1><center>LISTA GENEROS</center></h1>
            <hr>
            <h4>¿Quieres ingresar nuevos generos?</h4>
            <a class="btn btn-dark" href="index.jsp" role="button">Regresar</a>
            <a class="btn btn-info" href="genero?accion=abrirForm" role="button">Agregar Genero</a>
            <hr>
            
            <table class="table table-striped">
                <tr>
                    <th scope="col">Id Genero</th>
                    <th scope="col">Nombre Genero</th>
                    <th scope="col">Estado Genero</th>
                    <th scope="col">Acciones</th>
                </tr>

                <c:forEach var="genero" items="${generos}">

                    <tr>
                        <td>${genero.getidGenero()}</td>
                        <td>${genero.getnombreGenero()}</td>
                        <c:if test="${genero.getestadoGenero() == true}">
                            <td>Activo</td>
                        </c:if>
                        <c:if test="${genero.getestadoGenero() == false}">
                            <td>Inactivo</td>
                        </c:if>
                        <td>
                            <!---->
                            <c:if test="${genero.getestadoGenero() == true}">
                                <a genero="button" class="btn btn-outline-danger" href="genero?accion=CambiarEstado&id=${genero.getidGenero()}&&estado=${genero.getestadoGenero()}">Inactivar</a>
                            </c:if>
                            <c:if test="${genero.getestadoGenero() == false}">
                                <a genero="button" class="btn btn-outline-success" href="genero?accion=CambiarEstado&id=${genero.getidGenero()}&&estado=${genero.getestadoGenero()}">Activar</a>
                            </c:if>
                            <!---->
                            <a genero="button" class="btn btn-warning" name="accion" href="genero?accion=EditarGenerovista&id=${genero.getidGenero()}">EDITAR</a>
                            <!---->
                            <a genero="button" class="btn btn-danger" name="accion" href="genero?accion=eliminar&id=${genero.getidGenero()}">ELIMINAR</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
            <%@include file="footer.jsp" %>