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
public class AlterarComprador extends HttpServlet {

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
            out.println("<title>Servlet AlterarComprador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlterarComprador at " + request.getContextPath() + "</h1>");
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
        // buscar variavel nome do jsp com request
        String email = request.getParameter("email");
//        String cpf = request.getParameter("cpf");
      
        Comprador usuario = CompradorDao.getComprador(email);
        request.setAttribute("comprador",usuario);  
        String cpf = usuario.getCpf();
        
        //         listar endereco entrega
        List<Comprador> listaEndereco = CompradorDao.getEnderecoE(cpf);
        request.setAttribute("listaEnderecoE",listaEndereco);
        
        // mostrar na tela o request
        RequestDispatcher rd =
                getServletContext().getRequestDispatcher("/cadastrarComprador.jsp");
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
        String nome = request.getParameter("nome");  
        String senha = request.getParameter("senha"); 
        String tipo = request.getParameter("tipo"); 
        String email = request.getParameter("email");        
        String cpf = request.getParameter("cpf");        
        String logradouro = request.getParameter("logradouro");        
        String bairro = request.getParameter("bairro");        
        String cidade = request.getParameter("cidade");        
        String uf = request.getParameter("uf");        
               
              
        
//        Criar informacoes recebidas em uma lista e adicionar para a classe produto
        Comprador comprador = new Comprador(nome,senha,email,cpf,logradouro,bairro,cidade,uf);        
         
        try {
            CompradorDao.atualizarComprador(comprador);
//            redirecionar para uma pagina de confirmação
            request.setAttribute("nome",email); 
           RequestDispatcher rd = getServletContext().getRequestDispatcher("/paginaPrincipalLogado.jsp");
           rd.forward(request, response); 
//            response.sendRedirect("cadastrarImagens4.jsp");
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
