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

public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();

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

                    break;

                case "Editar":

                    break;

                case "Eliminar":

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

                    break;

                case "Editar":

                    break;

                case "Eliminar":

                    break;
                default:
                    throw new AssertionError();
            }
        }
        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    // Listar todos los productos
                    List<Producto> lista = pdao.listar();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("Producto.jsp").forward(request, response);
                    break;
                case "Agregar":

                    break;

                case "Editar":

                    break;

                case "Eliminar":

                    break;
                default:
                    throw new AssertionError();
            }
        }
        if (menu.equals("NuevaVenta")) {
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
