<%-- 
    Document   : Clientes
    Created on : 12 sept 2024, 11:20:24
    Author     : katfu
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Gestión de Clientes</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-6">
                <div class="card-body">
                    <form action="Controlador" method="POST">
                        <div class="form-group">
                            <label>DNI</label>
                            <input type="text" name="txtDni" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" name="txtNombres" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Dirección</label>
                            <input type="text" name="txtDireccion" class="form-control" required>
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
                            <th>DNI</th>
                            <th>Nombres</th>
                            <th>Dirección</th>
                            <th>Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cliente" items="${clientes}">
                            <tr>
                                <td>${cliente.idCliente}</td>
                                <td>${cliente.dnic}</td>
                                <td>${cliente.nombresc}</td>
                                <td>${cliente.direccion}</td>
                                <td>${cliente.estadoc}</td>
                                <td>
                                    <a href="Controlador?menu=Cliente&accion=Editar&id=${cliente.idCliente}" class="btn btn-warning">Editar</a>
                                    <a href="Controlador?menu=Cliente&accion=Eliminar&id=${cliente.idCliente}" class="btn btn-danger">Eliminar</a>
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
