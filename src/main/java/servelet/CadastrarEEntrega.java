/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import dao.CompradorDao;
import entidade.Comprador;
import java.io.IOException;
import java.io.PrintWriter;
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
public class CadastrarEEntrega extends HttpServlet {

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
            out.println("<title>Servlet CadastrarEEntrega</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastrarEEntrega at " + request.getContextPath() + "</h1>");
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
        String email = request.getParameter("email");
//        String cpf = request.getParameter("cpf");
        Comprador comprador = CompradorDao.getComprador(email);
        String cpf = comprador.getCpf();
        request.setAttribute("cpf", cpf);
//        teste apgar
request.setAttribute("email", email);
//fim teste
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarEEntrega.jsp");
        dispatcher.forward(request, response);
        
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
//        String nome = request.getParameter("nome");  
//        String senha = request.getParameter("senha"); 
//        String tipo = request.getParameter("tipo"); 
        String email = request.getParameter("email");        
        String cpf = request.getParameter("cpf");        
        String logradouro = request.getParameter("logradouro");        
        String bairro = request.getParameter("bairro");        
        String cidade = request.getParameter("cidade");        
        String uf = request.getParameter("uf");            
        
//        Criar informacoes recebidas em uma lista e adicionar para a classe produto
        Comprador enderecoEntrega = new Comprador(cpf,logradouro,bairro,cidade,uf);        
        try {
            CompradorDao.addEnderecoEntrega(enderecoEntrega);
//            redirecionar para uma pagina de confirmação
//            response.sendRedirect("index.jsp");
           /////////// //teste para cadastrar imagem
            request.setAttribute("email", email);
//            response.sendRedirect("index.jsp");
//nao sei pq            RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarImagensOfi.jsp");
//            RequestDispatcher dispatcher = request.getRequestDispatcher("AlterarComprador");
//voltar para tela do cadastro comprador
//        RequestDispatcher dispatcher = request.getRequestDispatcher("AlterarComprador");
//        dispatcher.forward(request, response);
        // teeste para retornar a tela de cadastro comprador
        Comprador usuario = CompradorDao.getComprador(email);
        request.setAttribute("comprador",usuario);  
//        String cpf = usuario.getCpf();
        
        List<Comprador> listaEndereco = CompradorDao.getEnderecoE(cpf);
        request.setAttribute("listaEnderecoE",listaEndereco);
        
        // mostrar na tela o request
        RequestDispatcher rd =
                getServletContext().getRequestDispatcher("/cadastrarComprador.jsp");
        rd.forward(request, response);  
        
        ////////////fim do teste
        
        } catch (Exception ex) {
            Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
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
