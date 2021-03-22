/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import dao.ProdutoDao;
import entidade.Produto;
import java.io.IOException;
import java.io.PrintWriter;
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
public class AlterarProduto extends HttpServlet {

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
            out.println("<title>Servlet AlterarProduto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlterarProduto at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException 
    {
//        Long cpf =Long.parseLong(request.getParameter("cpf"));
        // buscar variavel nome do jsp com request
        String nome = request.getParameter("nome");
//        String statusAlt = null;
//        statusAlt = request.getParameter("status");
//        if(statusAlt =="Ativo")
//            statusAlt = "Inativo";
//        else
//            statusAlt = "Ativo";
//        Produto statusAlte = new Produto(statusAlt); 
//        statusAlte.setStatusAlt(statusAlt);
        Produto produto = ProdutoDao.getProduto(nome);
        request.setAttribute("produto",produto);  
        // mostrar na tela o request
        RequestDispatcher rd =
                getServletContext().getRequestDispatcher("/alterarProduto.jsp");
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
            throws ServletException, IOException 
    {
        String nome = request.getParameter("nome");        
        String nomeExtenso = request.getParameter("nomeExtenso");        
        String qtdEstoqueStr = request.getParameter("qtdEstoque");        
//        converter string para int e double        
        int qtdEstoque = Integer.parseInt(qtdEstoqueStr);  
        
        String selectedvalue  =  request.getParameter("jobCat");
        
//        Criar informacoes recebidas em uma lista e adicionar para a classe produto
        Produto produtojsp = new Produto(nome,nomeExtenso,qtdEstoque);
        try {
            ProdutoDao.atualizarProduto(produtojsp);
//            redirecionar para uma pagina de confirmação
            response.sendRedirect("index.jsp");
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
