package model;

public class GeneroVo {

    private int idGenero;
    private String nombreGenero;
    private boolean estadoGenero;
    
    public GeneroVo(){

    }
    public GeneroVo(int idGenero, String nombreGenero, Boolean estadoGenero){
        
        this.idGenero=idGenero;
        this.nombreGenero=nombreGenero;
        this.estadoGenero=estadoGenero;
    }

    public int getidGenero(){
        return idGenero;
    }

    public void setidGenero(int idGenero){
        this.idGenero=idGenero;
    }

    public String getnombreGenero(){
        return nombreGenero;
    }
    public void setnombreGenero(String nombreGenero){
        this.nombreGenero=nombreGenero;
    }

    public boolean getestadoGenero(){
        return estadoGenero;
    }
    public void setestadoGenero(Boolean estadoGenero){
        this.estadoGenero=estadoGenero;
    }

}
