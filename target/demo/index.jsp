<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<!-- Created By CodingNepal -->
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Underground Record Lavel</title>
      <link rel="stylesheet" href="assets/css/style.css">
      <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
   </head>
   <body>
      <div class="btn">
         <span class="fas fa-bars"></span>
      </div>
      <nav class="sidebar">
         <div class="text">
            Menu
         </div>
         <ul>
            <li class="active"><a href="#">Inicio</a></li>
            <li>
               <a href="#" class="feat-btn">Generos
               <span class="fas fa-caret-down first"></span>
               </a>
               <ul class="feat-show">
                <a href="genero?accion=listar">Listar Generos</a>
                <a href="genero?accion=abrirForm">Ingresar Generos</a>  
               </ul>
            </li>
            <li>
               <a href="#" class="serv-btn">Disquera
               <span class="fas fa-caret-down second"></span>
               </a>
               <ul class="serv-show">
                  <li><a href="#">Listar Diquera</a></li>
                  <li><a href="#">Ingresar Disquera</a></li>
               </ul>
            </li>
         </ul>
      </nav>
      <div class="content">
         <div class="header">
            Underground
         </div>
         <p>
            Recor Lavel
         </p>
      </div>
      <script>
         $('.btn').click(function(){
           $(this).toggleClass("click");
           $('.sidebar').toggleClass("show");
         });
           $('.feat-btn').click(function(){
             $('nav ul .feat-show').toggleClass("show");
             $('nav ul .first').toggleClass("rotate");
           });
           $('.serv-btn').click(function(){
             $('nav ul .serv-show').toggleClass("show1");
             $('nav ul .second').toggleClass("rotate");
           });
           $('nav ul li').click(function(){
             $(this).addClass("active").siblings().removeClass("active");
           });
      </script>
   </body>
</html>

