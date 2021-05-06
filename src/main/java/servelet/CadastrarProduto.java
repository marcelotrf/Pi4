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
public class CadastrarProduto extends HttpServlet {

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
            out.println("<title>Servlet CadastrarProduto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastrarProduto at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException 
//            jsp cadastrar produto, metodo post para um formulario, jsp pega informacao digitada nos campos
//            <form action="CadastrarProduto"method="POST">
    {
        request.setCharacterEncoding("UTF-8");
        String nome = request.getParameter("nome");
        String nomeExtenso = request.getParameter("nomeExtenso");
        String qtdEstrelaStr = request.getParameter("qtdEstrela");
        String status = request.getParameter("status");
        String qtdEstoqueStr = request.getParameter("qtdEstoque");
        String precoStr = request.getParameter("preco");
//        converter string para int e double
        int qtdEstrela = Integer.parseInt(qtdEstrelaStr);
        int qtdEstoque = Integer.parseInt(qtdEstoqueStr);
        double preco = Double.parseDouble(precoStr);                
        
//        Criar informacoes recebidas em uma lista e adicionar para a classe produto
        Produto produtojsp = new Produto(nome,nomeExtenso,qtdEstrela,status,qtdEstoque,preco);
        try {
            ProdutoDao.addProduto(produtojsp);
//            redirecionar para uma pagina de confirmação
//            response.sendRedirect("index.jsp");
           /////////// //teste para cadastrar imagem
            request.setAttribute("nome", nome);
//            response.sendRedirect("index.jsp");
//            testando
//             RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("cadastrarImagensOfi.jsp");
//             requestDispatcher.forward(request, response);
//                    fim do teste
            RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarImagensOfi.jsp");
        dispatcher.forward(request, response);
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
