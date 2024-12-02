package Controlador;


import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import java.util.List;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;


public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    int ide;
    int idc;
    int idp;


    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;



    Producto prod = new Producto();
    ProductoDAO pdao = new ProductoDAO();

    Cliente cli = new Cliente();
    ClienteDAO cdao = new ClienteDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
            //request.getRequestDispatcher("Empleado.jsp").forward(request, response);
            switch (accion) {
                case "Listar":
                    List<Empleado> lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    request.getRequestDispatcher("Empleado.jsp").forward(request, response);
                    break;

                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTel");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUser");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;

                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String tel1 = request.getParameter("txtTel");
                    String est1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUser");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        if (menu.equals("Clientes")) {
            //request.getRequestDispatcher("Clientes.jsp").forward(request, response);
            switch (accion) {
                case "Listar":
                    List<Cliente> lista = cdao.listar();
                    request.setAttribute("clientes", lista);
                    request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                    break;

                case "Agregar":
                    String dnic = request.getParameter("txtDni");
                    String nombresc = request.getParameter("txtNombres");
                    String direccion = request.getParameter("txtDireccion");
                    String estadoc = request.getParameter("txtEstado");
                    cli.setDnic(dnic);
                    cli.setNombresc(nombresc);
                    cli.setDireccion(direccion);
                    cli.setEstadoc(estadoc);
                    cdao.agregar(cli);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);

                    break;

                case "Editar":
                    idc = Integer.parseInt(request.getParameter("id"));
                    Cliente c = cdao.listarId(idc);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);

                    break;

                case "Actualizar":
                    String dnic1 = request.getParameter("txtDni");
                    String nombresc1 = request.getParameter("txtNombres");
                    String direccion1 = request.getParameter("txtDireccion");
                    String estadoc1 = request.getParameter("txtEstado");
                    cli.setDnic(dnic1);
                    cli.setNombresc(nombresc1);
                    cli.setDireccion(direccion1);
                    cli.setEstadoc(estadoc1);
                    cli.setIdCliente(idc);
                    cdao.actualizar(cli);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    idc = Integer.parseInt(request.getParameter("id"));
                    cdao.delete(idc);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);

                    break;
                default:
                    throw new AssertionError();
            }
        }
        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List<Producto> lista = pdao.listar();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("Producto.jsp").forward(request, response);
                    break;

                case "Agregar":
                    String nombres = request.getParameter("txtNombre");
                    String preciop = request.getParameter("txtPrecio");
                    String stock = request.getParameter("txtStock");
                    String estado = request.getParameter("txtEstado");
                    prod.setNombres(nombres);
                    prod.setPrecio(preciop);
                    prod.setStock(stock);
                    prod.setEstado(estado);

                    pdao.agregar(prod);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;

                case "Editar":
                    idp = Integer.parseInt(request.getParameter("id"));
                    Producto p = pdao.listarId(idp);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String nombres1 = request.getParameter("txtNombre");
                    String precio1 = request.getParameter("txtPrecio");
                    String stock1 = request.getParameter("txtStock");
                    String estado1 = request.getParameter("txtEstado");

                    prod.setIdProducto(idp);
                    prod.setNombres(nombres1);
                    prod.setPrecio(precio1);
                    prod.setStock(stock1);
                    prod.setEstado(estado1);

                    pdao.actualizar(prod);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    idp = Integer.parseInt(request.getParameter("id"));
                    pdao.delete(idp);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;

                default:
                    throw new AssertionError();
            }
        }

        if (menu.equals("NuevaVenta")) {
           
            switch (accion) {
                case "BuscarCliente":
                    String dni = request.getParameter("codigocliente");
                    cli.setDnic(dni);
                    cli = cdao.buscar(dni);
                    request.setAttribute("cli", cli);
                    break;
                case "BuscarProducto":
                    int id = Integer.parseInt(request.getParameter("codigoproducto"));
                    prod = pdao.listarId(id);
                    request.setAttribute("cli", cli);
                    request.setAttribute("prod", prod);
                    
                    request.setAttribute("totalpagar", totalPagar);
                    break;
                case "Agregar":
                   
                    break;
                case "GenerarVenta":
                    //Actualización del Stock
                    
                    break;
                default:
                   
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                //throw new AssertionError();
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
        /*switch (accion) {
            case "Principal":
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
                break;

            case "Producto":
                request.getRequestDispatcher("Producto.jsp").forward(request, response);
                break;

            case "Clientes":
                request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                break;

            case "Empleado":
                request.getRequestDispatcher("Empleado.jsp").forward(request, response);
                break;

            case "RegistrarVenta":
                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }*/

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
