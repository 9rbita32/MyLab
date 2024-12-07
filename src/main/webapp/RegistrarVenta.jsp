<%-- 
    Document   : RegistrarVenta
    Created on : 12 sept 2024, 11:21:13
    Author     : katfu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="CSS/Riv.css" rel="stylesheet">
        <title>registro de venta</title>
        <style>
            @media print {
                .parte01, .btn, .accion {
                    display: none;
                }
            }
        </style>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-lg-5 parte01">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="post">
                        <div class="card-body">
                        <div class="form-group">
                            <label>Datos del Cliente</label>
                        </div>                    
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex"> 
                                <input type="text" name="codigocliente" value="${cli.getDnic()}" class="form-control" placeholder="Codigo">
                                <button type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">Buscar</button>
                            </div>
                            <div class="col-sm-6"> 
                                <input type="text" name="nombrescliente" value="${cli.getNombresc()}" class="form-control" placeholder="datos cliente">
                            </div>   
                        </div> 
                        <div class="form-group">
                            <label>Datos Producto</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex"> 
                                <input type="text" name="codigoproducto" value="${prod.getIdProducto()}" class="form-control" placeholder="Codigo">
                                <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">Buscar</button>
                            </div>
                            <div class="col-sm-6"> 
                                <input type="text" name="nomproducto" value="${prod.getNombres()}" placeholder="Datos Producto" class="form-control">
                            </div>
                            
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex"> 
                                <input type="text" name="precio" value="${prod.getPrecio()}" class="form-control" placeholder="s/0.00">
                            </div>
                            <div class="col-sm-3">
                                <input type="number" name="cant" value="1" placeholder="" class="form-control">
                            </div>
                            <div class="col-sm-3"> 
                                <input type="text" name="stock" value="${prod.getStock()}" class="form-control" placeholder="stock">
                            </div>
                        </div>
                            <div class="form-group">
                                <div class="col-sm-3">
                                    <button type="submit" name="accion" value="Agregar" class="btn btn-outline-primary">Agregar Producto</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col sm-5 ml-auto">
                            <label>NumeroSerie</label>
                            <input type="text" name="NroSerie" value="${nserie}" class="form-control">
                        </div>
                        <br>
                        <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Nro</th>
                                        <th>Codigo</th>
                                        <th>Descripcion</th>
                                        <th>Precio</th>
                                        <th>Cantidad</th>
                                        <th>Subtotal</th>
                                        <th class="accion">Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getIdproducto()}</td>
                                        <td>${list.getDescripcionp()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <td>${list.getCantidad()}</td>
                                        <td>${list.getSubtotal()}</td>   
                                        <td>
                                            <a href="#" class="btn btn-warning">Editar</a>
                                            <a href="#" class="btn btn-danger">Delete</a>
                                        </td> 
                                    </tr> 
                                </c:forEach>
                                       
                                </tbody>
                            </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar Venta</a>
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger" >
                        </div>
                        <div class="col-sm-4 ml-auto">
                            <input type="text" name="textTotal" value="s/. ${totalpagar}0" class="form-control" >
                        </div>
                        
                    </div>
                </div>
            </div>
        </div> 

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>