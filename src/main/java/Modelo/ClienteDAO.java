/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    // Método para validar un cliente por su id y DNI
    public Cliente validar(int idCliente, String dni) {
        Cliente cli = new Cliente();
        String sql = "select * from cliente where IdCliente=? and Dni=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ps.setString(2, dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setIdCliente(rs.getInt("IdCliente"));
                cli.setDnic(rs.getString("Dni"));
                cli.setNombresc(rs.getString("Nombres"));
                cli.setDireccion(rs.getString("Direccion"));
                cli.setEstadoc(rs.getString("Estado"));
            }
        } catch (Exception e) {
        }
        return cli;
    }

    // Método para listar todos los clientes
    public List<Cliente> listar() {
        String sql = "select * from cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setIdCliente(rs.getInt(1));
                cli.setDnic(rs.getString(2));
                cli.setNombresc(rs.getString(3));
                cli.setDireccion(rs.getString(4));
                cli.setEstadoc(rs.getString(5));
                lista.add(cli);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    // Método para agregar un nuevo cliente
    public int agregar(Cliente cli) {
        String sql = "insert into cliente(Dni, Nombres, Direccion, Estado) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDnic());
            ps.setString(2, cli.getNombresc());
            ps.setString(3, cli.getDireccion());
            ps.setString(4, cli.getEstadoc());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    // Método para listar un cliente por su ID
    public Cliente listarId(int idCliente) {
        Cliente cli = new Cliente();
        String sql = "select * from cliente where IdCliente=" + idCliente;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setIdCliente(rs.getInt(1));
                cli.setDnic(rs.getString(2));
                cli.setNombresc(rs.getString(3));
                cli.setDireccion(rs.getString(4));
                cli.setEstadoc(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return cli;
    }

    // Método para actualizar un cliente
    public int actualizar(Cliente cli) {
        String sql = "update cliente set Dni=?, Nombres=?, Direccion=?, Estado=? where IdCliente=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDnic());
            ps.setString(2, cli.getNombresc());
            ps.setString(3, cli.getDireccion());
            ps.setString(4, cli.getEstadoc());
            ps.setInt(5, cli.getIdCliente());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    // Método para eliminar un cliente por su ID
    public void delete(int idCliente) {
        String sql = "delete from cliente where IdCliente=" + idCliente;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
