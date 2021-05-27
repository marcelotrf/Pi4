/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import dao.CarrinhoDao;
import dao.CompradorDao;
import entidade.CarrinhoE;
import entidade.Comprador;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marce
 */
public class VisualizarDetalhesPedido extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VisualizarDetalhesPedido</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VisualizarDetalhesPedido at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String numeroOrdemStr = request.getParameter("numeroOrdem");
//        String statusOrdem;

//        converter string para int 
        int numeroOrdem = Integer.parseInt(numeroOrdemStr);
        String nome = request.getParameter("email");

//        Comprador comprador = CompradorDao.getComprador(nome);
//        String nomeComprador = comprador.getNome();
        // falta adicionar endereco de entrega e forma de pagamento
        List<CarrinhoE> listaPedidos = CarrinhoDao.getPedidoCarrinho(numeroOrdem);
        
        /////////////////valor final/////////////////////////////
        CarrinhoE valorFinalL = listaPedidos.get(listaPedidos.size() - 1);
        double valorFinal = valorFinalL.getValorFinal();
        // teste para limitar 2 casas decimais
        DecimalFormat df = new DecimalFormat("0.##");
        String valorFinalS = df.format(valorFinal);        

        request.setAttribute("valorFinal", valorFinalS);
        /////////////////////////// fim valor final ////////////////////////////////////////////

        request.setAttribute("listaPedidos", listaPedidos);
        // email comprador
        request.setAttribute("nome", nome);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/visualizarDetalhesPedido.jsp");
        requestDispatcher.forward(request, response);
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
