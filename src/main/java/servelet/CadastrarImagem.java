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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class CadastrarImagem extends HttpServlet {

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
            out.println("<title>Servlet CadastrarImagem</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastrarImagem at " + request.getContextPath() + "</h1>");
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
//        String nome = request.getParameter("nome");
//teste
        String nome = "Maquina de lavar";
        String nomeImg = request.getParameter("nomeImg");
//        Imagem imagemjsp = new Imagem(nome,nomeImg);

//        try {
//            ImagemDao.addImagem(imagemjsp);
//        } catch (SQLException ex) {
//            Logger.getLogger(CadastrarImagem.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(CadastrarImagem.class.getName()).log(Level.SEVERE, null, ex);
//        }

        List<Imagem> listaImagens = ImagemDao.getImagem(nome);
//        Tipo, variavel, nome lista
        String checkBox = "<input type=\"checkbox\" name=\"imagem\" value=\"C\">Imagem 1";
//        for (Imagem listaImagen : listaImagens) 
//        {
//            nome = listaImagen.getNomeImagem();
//            if (nome != null) 
//            {
//                request.setAttribute("cBox", checkBox);
//            }
//                nomeImg=listaImagen.getNomeImagem();
//                request.setAttribute("imagem", nomeImg);            
//        }
        request.setAttribute("nome", nome);
        request.setAttribute("cBox", checkBox);
        request.setAttribute("listaimagens", listaImagens);

//        "<img class="thumbnail" src="img/Lavadora de Roupas Ex1.jpg">"
//        ou
//                Lavadora de Roupas Ex1.jpg
//        if (nomeImg != null) {
//            request.setAttribute("cBox", checkBox);
//        }
//        request.setAttribute("img", nomeImg);
//        request.setAttribute("produto", produto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarImagens2.jsp");
        dispatcher.forward(request, response);

//        String skill[] = request.getParameterValues("skill");
//        String img = null;
//        for (int i = 0; i < skill.length; i++) {
////            escolher se vai ter a imagem e mostrar no jsp
//            if (skill[i].equals("IMG_4594.JPG")) {
//                img = skill[i];
////                    img = "<img id=featured src=\"IMG_4594.JPG\">";
//            }
////            else
////                img= "<h1>Texto digitado: não tem imagem </h1>";
//
//        }
//
////        lista que passa valores para jsp
//        List<String> listaSkills = new ArrayList();
////comando para adicionar o vetor dentro da lista
//        listaSkills.addAll(Arrays.asList(skill));
////valor entre aspas jsp, valor servlet
//        request.setAttribute("listaJSP", listaSkills);
//        request.setAttribute("imagem", img);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("resultado.jsp");
//        dispatcher.forward(request, response);

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
        String nome = "Maquina de lavar3";
        String nomeImg = request.getParameter("nomeImg");
        Imagem imagemjsp = new Imagem(nome,nomeImg);

        try {
            ImagemDao.addImagem(imagemjsp);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarImagem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarImagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarImagens.jsp");
        dispatcher.forward(request, response);
        
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
