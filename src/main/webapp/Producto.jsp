<%-- 
    Document   : Producto
    Created on : 12 sept 2024, 11:19:59
    Author     : katfu
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Gestión de Productos</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-6">
                <div class="card-body">
                    <form action="Controlador" method="POST">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" name="txtNombre" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Precio</label>
                            <input type="text" name="txtPrecio" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Stock</label>
                            <input type="text" name="txtStock" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" name="txtEstado" class="form-control" required>
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                            <th>Stock</th>
                            <th>Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="producto" items="${productos}">
                            <tr>
                                <td>${producto.idProducto}</td>
                                <td>${producto.nombres}</td>
                                <td>${producto.precio}</td>
                                <td>${producto.stock}</td>
                                <td>${producto.estado}</td>
                                <td>
                                    <a href="Controlador?menu=Producto&accion=Editar&id=${producto.idProducto}" class="btn btn-warning">Editar</a>
                                    <a href="Controlador?menu=Producto&accion=Eliminar&id=${producto.idProducto}" class="btn btn-danger">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div> 
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
