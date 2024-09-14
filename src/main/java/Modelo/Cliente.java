/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

public class Cliente {
    
    int idCliente;
    String dnic;
    String nombresc;
    String direccion;
    String estadoc;

    
    public Cliente() {
    }

   
    public Cliente(int idCliente, String dnic, String nombresc, String direccion, String estadoc) {
        this.idCliente = idCliente;
        this.dnic = dnic;
        this.nombresc = nombresc;
        this.direccion = direccion;
        this.estadoc = estadoc;
    }

    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDnic() {
        return dnic;
    }

    public void setDnic(String dnic) {
        this.dnic = dnic;
    }

    public String getNombresc() {
        return nombresc;
    }

    public void setNombresc(String nombresc) {
        this.nombresc = nombresc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstadoc() {
        return estadoc;
    }

    public void setEstadoc(String estadoc) {
        this.estadoc = estadoc;
    }
}
