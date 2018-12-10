
package model;

import javax.swing.JOptionPane;

public class ModelCsv2 {

    private String nombre = "";
    private String correo = "";
    private String path = "C:\\Users\\DELL\\Documents\\NetBeansProjects\\No entragrados\\base.csv";
    private int contador;

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public String separarCadena(String nom, String ape){
        String cadena = "";
        cadena = nom + "," + ape;
        return cadena;
    }
    
    public void primerRegistro(String cadena) {
        String separar = cadena;
        String[] saltoLinea = separar.split("\n");
        String[] sep_coma = saltoLinea[0].split(",");
        this.setNombre(sep_coma[0]);
        this.setCorreo(sep_coma[1]);
        
    } 
    
    public void ultimoRegistro(String cadena) {
        String separar = cadena;
        String[] saltoLinea = separar.split("\n");
        int i = (saltoLinea.length - 1);
        String[] sep_coma = saltoLinea[i].split(",");
        this.setNombre(sep_coma[0]);
        this.setCorreo(sep_coma[1]);
        System.out.println(i);
        
    }
    
    public void sigultRegistro(String cadena, int contador){
        try{
        String separar = cadena;
        String[] saltoLinea = separar.split("\n");
        String[] sep_coma = saltoLinea[contador].split(",");
        int i = (saltoLinea.length - 1);
        this.setNombre(sep_coma[0]);
        this.setCorreo(sep_coma[1]);
        } catch(Exception err){
            System.err.println("error "+err.getMessage());
            JOptionPane.showMessageDialog(null, "Error Model: " + err.getMessage());
        }
    }
}
