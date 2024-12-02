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

public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Producto buscar (int id) {
        Producto prod = new Producto();
        String sql="select * from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                prod.setIdProducto(rs.getInt(1));
                prod.setNombres(rs.getString(2));
                prod.setPrecio(rs.getString(3));
                prod.setStock(rs.getString(4));
                prod.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return prod;
    }
    public int actualizarstock( int IdProducto, int stock) {
        String sql="update producto set Stock=? where IdProducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, IdProducto);
            ps.executeUpdate();
        } catch (Exception e){
        }
        return r;
    }

    // Método para validar un producto por su id y nombre
    /*public Producto validar(int idProducto, String nombre) {
        Producto prod = new Producto();
        String sql = "select * from producto where IdProducto=? and Nombres=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ps.setString(2, nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                prod.setIdProducto(rs.getInt("IdProducto"));
                prod.setNombres(rs.getString("Nombres"));
                prod.setPrecio(rs.getString("Precio"));
                prod.setStock(rs.getString("Stock"));
                prod.setEstado(rs.getString("Estado"));
            }
        } catch (Exception e) {
        }
        return prod;
    }*/

    // Método para listar todos los productos
    public List<Producto> listar() {
        String sql = "select * from producto";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setIdProducto(rs.getInt(1));
                prod.setNombres(rs.getString(2));
                prod.setPrecio(rs.getString(3));
                prod.setStock(rs.getString(4));
                prod.setEstado(rs.getString(5));
                lista.add(prod);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    // Método para agregar un nuevo producto
    public int agregar(Producto prod) {
        String sql = "insert into producto(Nombres, Precio, Stock, Estado) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getNombres());
            ps.setString(2, prod.getPrecio());
            ps.setString(3, prod.getStock());
            ps.setString(4, prod.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    // Método para listar un producto por su ID
    public Producto listarId(int idProducto) {
        Producto prod = new Producto();
        String sql = "select * from producto where IdProducto=" + idProducto;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                prod.setIdProducto(rs.getInt(1));
                prod.setNombres(rs.getString(2));
                prod.setPrecio(rs.getString(3));
                prod.setStock(rs.getString(4));
                prod.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return prod;
    }

    // Método para actualizar un producto
    public int actualizar(Producto prod) {
        String sql = "update producto set Nombres=?, Precio=?, Stock=?, Estado=? where IdProducto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getNombres());
            ps.setString(2, prod.getPrecio());
            ps.setString(3, prod.getStock());
            ps.setString(4, prod.getEstado());
            ps.setInt(5, prod.getIdProducto());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    // Método para eliminar un producto por su ID
    public void delete(int idProducto) {
        String sql = "delete from producto where IdProducto=" + idProducto;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
