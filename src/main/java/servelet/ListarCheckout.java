/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import dao.CarrinhoDao;
import dao.CompradorDao;
import dao.ImagemDao;
import dao.ProdutoDao;
import entidade.CarrinhoE;
import entidade.Comprador;
import entidade.Imagem;
import entidade.Produto;
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
public class ListarCheckout extends HttpServlet {

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
            out.println("<title>Servlet ListarCheckout</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListarCheckout at " + request.getContextPath() + "</h1>");
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

        request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        // procurar nome comprador
        Comprador comprador = CompradorDao.getComprador(email);
        // adicionar nome na lista do carrinho em aberto
        try {
            CarrinhoDao.AddNomeComprador(comprador.getNome());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListarCheckout.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListarCheckout.class.getName()).log(Level.SEVERE, null, ex);
        }

        // adicionar lista percorrer somente aberto o status
        List<CarrinhoE> listaCarrinho = CarrinhoDao.getProdutoCarrinho();

        CarrinhoE valorFinalL = listaCarrinho.get(listaCarrinho.size() - 1);
        double valorFinal = valorFinalL.getValorFinal();

        request.setAttribute("comprador", comprador);
        request.setAttribute("listaCarrinho", listaCarrinho);
        request.setAttribute("valorFinal", valorFinal);

//            request.setAttribute("email", email);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/checkout.jsp");
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
        request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        //receber tipo pagamento
        String pagamento = request.getParameter("pagamento");
        
        ////////////////////// endereco entrega/////////////////////////
        String logradouro = request.getParameter("logradouro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String cep = request.getParameter("cep");
        request.setAttribute("logradouro", logradouro);
        request.setAttribute("cidade", cidade);
        request.setAttribute("uf", uf);
        request.setAttribute("cep", cep);        
        //////////////// fim endereco entrega////////////////////
        
        // procurar nome comprador
        Comprador comprador = CompradorDao.getComprador(email);            

        // adicionar lista percorrer somente aberto o status
        List<CarrinhoE> listaCarrinho = CarrinhoDao.getProdutoCarrinho();

        CarrinhoE valorFinalL = listaCarrinho.get(listaCarrinho.size() - 1);
        double valorFinal = valorFinalL.getValorFinal();

        request.setAttribute("comprador", comprador);
        request.setAttribute("listaCarrinho", listaCarrinho);
        request.setAttribute("valorFinal", valorFinal);

//            request.setAttribute("email", email);
        if(pagamento.equals("boleto"))
        {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/boletoFinalizar.jsp");
            rd.forward(request, response);            
        }
        else
        {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/cartaoCreditoFinalizar.jsp");
            rd.forward(request, response); 
        }
            
        
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
