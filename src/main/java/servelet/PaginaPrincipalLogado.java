/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import dao.ImagemDao;
import dao.ProdutoDao;
import entidade.Imagem;
import entidade.Produto;
import java.io.IOException;
import java.io.PrintWriter;
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
public class PaginaPrincipalLogado extends HttpServlet {

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
            out.println("<title>Servlet PaginaPrincipalLogado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PaginaPrincipalLogado at " + request.getContextPath() + "</h1>");
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
        // pegar dados do servelet dopost
         String nomeT = (String) request.getAttribute("nome");
         request.setAttribute("nome",nomeT); 
//        String nome2 = request.getParameter("nome");
//        String nome3 = request.getParameter("nome");
//        String nome4 = request.getParameter("nome");
//        String nome5 = request.getParameter("nome");
//        String nome6 = request.getParameter("nome");
//        String nome7 = request.getParameter("nome");
//        String nome8 = request.getParameter("nome");
        String nome = "novo";
        String nome2 = "teste";
        String nome3 = "cadastro de teste";
        String nome4 = "nome novo";
        String nome5 = "testando";
        String nome6 = "status";
//        String nome7 = "qualqeur";
        String nome7 = "test7";
//        String nome8 = "a";Segunda tentativa
        String nome8 = "Segunda tentativa";
        
        
        Produto produto = ProdutoDao.getProdutoPP(nome);
        request.setAttribute("produto",produto); 
        Produto produto2 = ProdutoDao.getProdutoPP(nome2);
        request.setAttribute("produto2",produto2);
        Produto produto3 = ProdutoDao.getProdutoPP(nome3);
        request.setAttribute("produto3",produto3);
        Produto produto4 = ProdutoDao.getProdutoPP(nome4);
        request.setAttribute("produto4",produto4);
        Produto produto5 = ProdutoDao.getProdutoPP(nome5);
        request.setAttribute("produto5",produto5);
        Produto produto6 = ProdutoDao.getProdutoPP(nome6);
        request.setAttribute("produto6",produto6);
        Produto produto7 = ProdutoDao.getProdutoPP(nome7);
        request.setAttribute("produto7",produto7);
        Produto produto8 = ProdutoDao.getProdutoPP(nome8);
        //teste para imagem//
        List<Imagem> listaImagens = ImagemDao.getImagem(nome8);
        Imagem imagens = listaImagens.get(0);
//        request.setAttribute("listaimagens", listaImagens);
        request.setAttribute("produtoI8",imagens);
        ///fim teste ////
        
        listaImagens = ImagemDao.getImagem(nome7);
        imagens = listaImagens.get(0);
        request.setAttribute("produtoI7",imagens);
        
        
        request.setAttribute("produto8",produto8);
        request.setAttribute("produto8Nome",nome8);       
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);
//        List<Produto> listaProdutos = ProdutoDao.getProduto();;
        //             utilizar metodo request  para armazenar a lista em request  
       
        
//        Produto statusALte = new Produto(statusAlt);
//        statusALte.setStatusAlt(statusAlt);
//        listaProdutos.add(statusALte);        
//        request.setAttribute("listaProdutos", listaProdutos);        
//     apagar   String nome = "joao";
//     apagara   request.setAttribute("ativar", nome);   
        
                
//        Dispacher vai apresentar o request na pagina jsp
//        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/paginaPrincipal.jsp");
//        requestDispatcher.forward(request, response);  
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
