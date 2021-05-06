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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
//            fetch form data
            Part part = request.getPart("nomeImg");
            String fileName = part.getSubmittedFileName();
            out.println(fileName);

            String path = getServletContext().getRealPath("/" + "img" + File.separator + fileName);

            InputStream is = part.getInputStream();

            boolean succs = uploadFile(is, path);
            if (succs) {
                out.println("File Upladed to this directory: " + path);
            } else {
                out.println("error");
            }

        }
    }

    public boolean uploadFile(InputStream is, String path) {
        boolean test = false;
        try {
            byte[] byt = new byte[is.available()];
            is.read();
            OutputStream fops = new FileOutputStream(path);
            fops.write(byt);
            fops.flush();
            fops.close();

            test = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
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
//teste
//        String nome = "Maquina de lavar";
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
//        String checkBox = "<input type=\"checkbox\" name=\"imagem\" value=\"C\">Imagem 1";
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
//        request.setAttribute("cBox", checkBox);
        request.setAttribute("listaimagens", listaImagens);

//        "<img class="thumbnail" src="img/Lavadora de Roupas Ex1.jpg">"
//        ou
//                Lavadora de Roupas Ex1.jpg
//        if (nomeImg != null) {
//            request.setAttribute("cBox", checkBox);
//        }
//        request.setAttribute("img", nomeImg);
//        request.setAttribute("produto", produto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarImagensOfi.jsp");
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
            throws ServletException, IOException {
//        String nome = "Maquina de lavar3";
//        String nomeImg = request.getParameter("nomeImg");

        String nomeImg2 = request.getParameter("file-name");
        String nomeImg3 = request.getParameter("nomeImg3");
        
        ///teste pegar nome produto

        String nomeProduto = request.getParameter("nomeP");

//        InputStream isFoto = request.getPart("nomeImg").getInputStream();
//        Part filePart = request.getPart("nomeImg"); // Retrieves <input type="file" name="nomeImg">
//        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
//        InputStream fileContent = filePart.getInputStream();
//        Imagem imagemjsp = new Imagem(nome,nomeImg);
        Part part = request.getPart("nomeImg");
//        String fileName = part.getSubmittedFileName();
//        out.println(fileName);
//        request.setAttribute("imgU", fileName);

        /////////////teste
        Part filePart = request.getPart("nomeImg"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();
        ///// rotina do banco
        String nome = "Maquina de lavar3";
//String nomeI = "img/Lavadora de Roupas Ex2.jpg4";
        if (ImagemDao.VerificaImagem(nomeProduto, fileName)) {
            nome = "Imagem existe";
        } else {
            nome = "Salvou no banco";
            //////// teste  gravar banco
            Imagem imagemjsp = new Imagem(nomeProduto, fileName);

            try {
                ImagemDao.addImagem(imagemjsp);
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarImagem.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CadastrarImagem.class.getName()).log(Level.SEVERE, null, ex);
            }
//////////////fim do teste
        }
        request.setAttribute("imgU3", nomeProduto);
////fim da rotina
        request.setAttribute("imgU", fileName);
        request.setAttribute("imgU2", fileContent);
        request.setAttribute("imgU4", nome);
        //tentativa 1
//        request.setAttribute("imgU3", nomeProduto);
//        
        ///////fim teste

        /////////////teste
//        List<Part> fileParts = (List<Part>) request.getParts();
//        request.setAttribute("imgU3", fileParts);
//                
//        for (Part filePart : fileParts) {
//        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
//        InputStream fileContent = filePart.getInputStream();
//        request.setAttribute("imgU", fileName);
//        request.setAttribute("imgU2", fileContent);
//        }
        ///////fim teste
//        Part part = request.getPart("nomeImg");
//        String fileName = part.getSubmittedFileName();
        ///  out.println(fileName);
//        String path = getServletContext().getRealPath("/" + "img" + File.separator + fileName);
//
//        InputStream is = part.getInputStream();
//
//        boolean succs = uploadFile(is, path);
//        if (succs) {
//            //        out.println("File Upladed to this directory: " + path);
//        } else {
//            //      out.println("error");
//        }
//        try {
//            ImagemDao.addImagem(imagemjsp);
//        } catch (SQLException ex) {
//            Logger.getLogger(CadastrarImagem.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(CadastrarImagem.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        request.setAttribute("imgU", isFoto);
//        request.setAttribute("imgU2", nomeImg2);
//        request.setAttribute("imgU3", nomeImg3);
//        request.setAttribute("imgU", path);
/////////////teste no banco de dados
//String nome = "Maquina de lavar3";
//String nomeI = "img/Lavadora de Roupas Ex2.jpg4";
//if(ImagemDao.VerificaImagem(nome, nomeI))
//    nome = "deucerto";
//else
//    nome = "deuerrado";
//request.setAttribute("imgU3", nome);
///////////////fim teste banco
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
