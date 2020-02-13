/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author octaviano
 */
public class Proveedor {
    
     /*Variables de intancia*/
    private String rfc;
    private String nombre;
    private String primerAp;
    private String segundoAp;
    private String direccion;
    private String telefono;
    private String empresa;
    
     /*Constructores*/
    public Proveedor(String rfc, String nombre, String primerAp, String segundoAp, String direccion, String telefono, String empresa) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.primerAp = primerAp;
        this.segundoAp = segundoAp;
        this.direccion = direccion;
        this.telefono = telefono;
        this.empresa = empresa;
    }

    public Proveedor() {
    }
    
     /*Getter y Setter*/
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerAp() {
        return primerAp;
    }

    public void setPrimerAp(String primerAp) {
        this.primerAp = primerAp;
    }

    public String getSegundoAp() {
        return segundoAp;
    }

    public void setSegundoAp(String segundoAp) {
        this.segundoAp = segundoAp;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    
}
