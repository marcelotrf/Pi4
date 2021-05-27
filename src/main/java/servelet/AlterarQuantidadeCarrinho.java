/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import dao.CarrinhoDao;
import entidade.CarrinhoE;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marce
 */
public class AlterarQuantidadeCarrinho extends HttpServlet {

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
            out.println("<title>Servlet AlterarQuantidadeCarrinho</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlterarQuantidadeCarrinho at " + request.getContextPath() + "</h1>");
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
        String nome = request.getParameter("nome");
        String quantidadeStr = request.getParameter("quantidade");
        int quantidade = Integer.parseInt(quantidadeStr);

        List<CarrinhoE> listaCarrinho = CarrinhoDao.getProdutoCarrinho();

        request.setAttribute("listaCarrinho", listaCarrinho);
        // mostrar na tela o request
        RequestDispatcher rd
                = getServletContext().getRequestDispatcher("/carrinho.jsp");
        rd.forward(request, response);

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
        String teste = "teste";
        String email = request.getParameter("email");
//        int numeroOrdem = CarrinhoDao.getNumeroOrdem();
//tentar com lista
//        List<CarrinhoE> listaCarrinho = CarrinhoDao.getNumeroOrdem();
//        CarrinhoE valorFinalL = listaCarrinho.get(listaCarrinho.size() - 1);
//        int numeroOrdem = valorFinalL.getNumeroOrdem();
//        numeroOrdem++;
//////////// fim teste
        int numeroOrdem = CarrinhoDao.getNumeroOrdem();
//        numeroOrdem++;

        try {
            CarrinhoDao.ConcluirOrdem(numeroOrdem);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlterarQuantidadeCarrinho.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AlterarQuantidadeCarrinho.class.getName()).log(Level.SEVERE, null, ex);
        }
//        try {
//            CarrinhoDao.ConcluirOrdemFechar();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(AlterarQuantidadeCarrinho.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(AlterarQuantidadeCarrinho.class.getName()).log(Level.SEVERE, null, ex);
//        }
        //criar metodo para buscar numero pedido
//        int numeroOrdem = 1;
        request.setAttribute("pedido", numeroOrdem);
        RequestDispatcher rd
                = getServletContext().getRequestDispatcher("/numeroPedido.jsp");
        rd.forward(request, response);
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
