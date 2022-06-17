package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.GeneroDao;
import model.GeneroVo;

public class Genero extends HttpServlet{

    GeneroDao rdao=new GeneroDao();
    GeneroVo rvo=new GeneroVo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       System.out.println("Entro al Doget");
       String accion=req.getParameter("accion");

       switch (accion){
           case "abrirForm":
           abrirForm(req,resp);
           break;

           case "listar":
           listar(req,resp);
           break;

           case "eliminar":
           eliminar(req, resp);
           break;

           case "cambiarestad":
           cambiarestad(req, resp);
           break;

           case "abrirFormedit":
           abrirFormedit(req,resp);
           break;

       }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entro al Dopost");
        String accion=req.getParameter("accion");

        switch(accion){
            case "addGenero":
                addGenero(req,resp);
            break;
            case "updategenero":
                updategenero(req,resp);
            break;
        }
    }

    //---------------------------Abrir Formulario de agregar---------------------------------------------

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp){
        try{
            req.getRequestDispatcher("views/genero/addGenero.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }
    
    //---------------------------Agregar Genero---------------------------------------------


    private void addGenero (HttpServletRequest req, HttpServletResponse resp){
        GeneroDao rdao=new GeneroDao();
        GeneroVo rvo=new GeneroVo();
        System.out.println("agregando genero...");
        if(req.getParameter("nombreGenero")!=null){
            rvo.setnombreGenero(req.getParameter("nombreGenero"));
        }
        if(req.getParameter("chkestado")!=null){
            rvo.setestadoGenero(true);
        }else{
            rvo.setestadoGenero(false);
        }
        try {
            rdao.registrar(rvo);
            resp.sendRedirect("genero?accion=listar");
            System.out.println("Registro insertado correctamente");
        } catch (Exception e) {
            req.setAttribute("msje","no se pudo registrar el genero"+e.getMessage());
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    //---------------------------Listar Generos---------------------------------------------


    private void listar (HttpServletRequest req, HttpServletResponse resp){
        GeneroDao rdao=new GeneroDao();
        GeneroVo rvo=new GeneroVo();
        System.out.println("listando genero");
        try {
            List<GeneroVo> genero=rdao.listar();
            req.setAttribute("generos", genero);
            req.getRequestDispatcher("views/genero/listGenero.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Error en listar los datos"+e.getMessage().toString());
        }
    }

    //---------------------------Eliminar Genero---------------------------------------------

    private void eliminar(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("eliminando genero");
        if(req.getParameter("id")!=null){
            rvo.setidGenero(Integer.parseInt(req.getParameter("id")));
        }
        try {
            rdao.eliminarGenero(rvo.getidGenero());
            resp.sendRedirect("genero?accion=listar");
            System.out.println("Genero eliminado");
        } catch (Exception e) {
            req.setAttribute("msje", "No se pudo eliminar el genero"+e.getMessage());
            System.out.println("No se pudo eliminar el genero"+e.getMessage());
        }finally{

        }
    }
    
    //--------------------------Cambiar Estado---------------------------------------------
    private void cambiarestad(HttpServletRequest req, HttpServletResponse resp){
        GeneroDao rdao=new GeneroDao();
        GeneroVo rvo=new GeneroVo();
        System.out.println("entro a cambiar estado");
        if (req.getParameter("id")!=null) {
            rvo.setidGenero(Integer.parseInt(req.getParameter("id")));
        }
        System.out.println(req.getParameter("estado"));
        boolean estado = Boolean.valueOf(req.getParameter("estado"));
        if (req.getParameter("estado") != null && estado) {
            rvo.setestadoGenero( false);
        } else {
            rvo.setestadoGenero( true);
        }
        try {
            rdao.CambiarEst(rvo);
            resp.sendRedirect("genero?accion=listar");
            System.out.println("Estado actualizado correctamente");
        } catch (Exception e) {
            req.setAttribute("msje", "No se ha actualizado el estado"+e.getMessage());
            System.out.println("No se se ha actualizado el estado"+e.getMessage().toString());
        }
    }


    //---------------------------Abrir Formulario de editar---------------------------------------------

    private void abrirFormedit(HttpServletRequest req, HttpServletResponse resp){
        GeneroDao rdao=new GeneroDao();
        GeneroVo rvo=new GeneroVo();
        System.out.println("entro a abrir el formulario editar");
        if (req.getParameter("id")!=null){
            rvo.setidGenero(Integer.parseInt(req.getParameter("id")));
        }
        try {
            List<GeneroVo> genero=rdao.listarEG(rvo);
            req.setAttribute("listaGeneroEdit", genero);
            req.getRequestDispatcher("views/genero/editGenero.jsp").forward(req, resp);

            System.out.println("SE LISTO CORRECTAMENTE");
        } catch (Exception e) {
            System.out.println("ERROR PROBLEMAS AL LISTAR LOS DATOS "+e.getMessage().toString());
        }
    }

    //---------------------------Editar Genero---------------------------------------------

    private void updategenero(HttpServletRequest req, HttpServletResponse resp){
        GeneroDao rdao=new GeneroDao();
        GeneroVo rvo=new GeneroVo();
        System.out.println("editando genero...");
        if (req.getParameter("idGenero")!=null) {
            rvo.setidGenero(Integer.parseInt(req.getParameter("idGenero")));
        }
        if (req.getParameter("nombreGenero" )!=null) {
            rvo.setnombreGenero(req.getParameter("nombreGenero"));
        }
        try {
            rdao.actualizar(rvo);
            resp.sendRedirect("genero?accion=listar");
            System.out.println("Registro se ha actualizado correctamente");

        } catch (Exception e) {
            req.setAttribute("MENSAJE", "NO SE PUDO ACTUALIZAR  "+e.getMessage());
            System.out.println("ERROR EN LA INSERCION DEL REGISTRO "+e.getMessage().toString());
        }
    }



}
