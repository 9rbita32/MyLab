<%-- 
    Document   : Empleado
    Created on : 12 sept 2024, 11:22:08
    Author     : katfu
--%>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="CSS/Riv.css" rel="stylesheet">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="CSS/Riv.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
            <!-- col-sm-6 -->
            <div class="card">
                <div class="card-body">
                    <form action="Controlador?menu=Empleado" method="post">
                        <div class="form-group">
                            <label>Dni</label>
                            <input type="text" value="${empleado.getDni()}" name="txtDni" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${empleado.getNom()}" name="txtNombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Telefono</label>
                            <input type="text" value="${empleado.getTel()}" name="txtTel" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${empleado.getEstado()}" name="txtEstado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" value="${empleado.getUser()}" name="txtUser" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
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
                            <th>Teléfono</th>
                            <th>Estado</th>
                            <th>Usuario</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="empleado" items="${empleados}">
                            <tr>
                                <td>${empleado.id}</td>
                                <td>${empleado.dni}</td>
                                <td>${empleado.nom}</td>
                                <td>${empleado.tel}</td>
                                <td>${empleado.estado}</td>
                                <td>${empleado.user}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Empleado&accion=Editar&id=${empleado.getId()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Empleado&accion=Delete&id=${empleado.getId()}" >Delete</a>
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