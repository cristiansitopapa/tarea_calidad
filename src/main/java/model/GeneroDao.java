package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroDao {
    //atributos
    Connection con; //objeto para la conexión
    PreparedStatement ps; //objeto para las sentencias preparadas
    ResultSet rs; //objeto para almacenar los resultados de las consultas 
    String sql=null; //variable para almacenar las sentencias de SQL 
    int r;

    //----------------------Insertar Genero----------------------
    public int registrar(GeneroVo genero) throws  SQLException{
        sql="INSERT INTO genero (nombreGenero,estadoGenero) values(?,?)";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, genero.getnombreGenero());
            ps.setBoolean(2, genero.getestadoGenero());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("se registro el genero correctamente");
        }catch(Exception e){
            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return r;
    }

    //----------------------Listar Generos----------------------
    public List<GeneroVo> listar() throws Exception{

        List<GeneroVo> generos=new ArrayList<>();
        sql="SELECT * FROM genero";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            rs=ps.executeQuery();
            while(rs.next()){
                GeneroVo r=new GeneroVo();
                r.setidGenero(rs.getInt("idGenero"));
                r.setnombreGenero(rs.getString("nombreGenero"));
                r.setestadoGenero(rs.getBoolean("estadoGenero"));
                generos.add(r);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("No hay generos definidos"+e.getMessage());
        }finally{
            con.close();
        }
        return generos;
    }

    //----------------------Eliminar Genero----------------------
    public void eliminarGenero(int idGenero)throws SQLException{
        sql="DELETE FROM genero WHERE idGenero="+idGenero;
        System.out.println(sql);
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.executeUpdate(sql);
            ps.close();
            System.out.println("se elimino correctametne el genero");
        } catch (Exception e) {
            System.out.println("Error en la eliminación del rol"+e.getMessage());
        }
        finally{
            con.close();
        }
    }

    //----------------------Cambiar Estado Genero----------------------
    public int CambiarEst(GeneroVo gene) throws SQLException{
        sql = "UPDATE genero SET estadoGenero = "+ (gene.getestadoGenero() == true ? "1" : "0")+ " WHERE idGenero = " + gene.getidGenero();        
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println("Se puede actualizar estado");
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();

            System.out.println("Exito al actualizar estado");
        } catch (Exception e) {
            System.out.println("ERROR EN ACTUALIZAR"+e.getMessage().toString());
        } finally{
            con.close();//cerrando la conexion
        }
        
        return r;
    }

    //----------------------Listar Genero editado----------------------
    public List<GeneroVo> listarEG(GeneroVo gene) throws Exception{
        
        List<GeneroVo> listaGeneroEdit=new ArrayList<>();
        sql="SELECT * FROM genero WHERE idGenero = "+gene.getidGenero();
        System.out.println("se pueden listar datos");
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                GeneroVo z=new GeneroVo();//crear un nuevo objeto
                z.setidGenero(rs.getInt("idGenero"));
                z.setnombreGenero(rs.getString("nombreGenero"));
                listaGeneroEdit.add(z);
            }
            ps.close();
            System.out.println(" CONSULTA EXITOSA ");
        } catch (Exception e) {
            System.out.println(" ERROR EN LA CONSULTA "+e.getMessage());
        } finally{
            con.close();
        }
        return listaGeneroEdit;
    }

    //----------------------Actualizar Genero----------------------
    public int actualizar(GeneroVo gene) throws SQLException{
        System.out.println("Entro al dao actualizar");
        sql = "UPDATE genero SET nombreGenero = '"+gene.getnombreGenero()+"' WHERE idGenero = '"+gene.getidGenero()+"'";//sentencia sql
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println("Se pueden actualizar datos");
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
                
        }finally{
            con.close();
        }
        return r; 
    }


}
