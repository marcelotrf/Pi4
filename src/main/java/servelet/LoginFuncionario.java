/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import dao.UsuarioDao;
import entidade.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marce
 */
public class LoginFuncionario extends HttpServlet {

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
            out.println("<title>Servlet LoginFuncionario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginFuncionario at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException {
        String username = request.getParameter("email");
        String senha = request.getParameter("senha");
        // encryptar para ver se bate no banco
        senha = new String(UsuarioDao.encripitar(senha.getBytes()));

        // aplicando decryptador se quiser saber a senha
//        senha  = new String(UsuarioDao.descripitar(senha.getBytes())); 
        boolean usuario = UsuarioDao.verificaUsuario(username, senha);
//        Usuario usuario = UsuarioDao.ver
        // primeiro decryptar senha///
//     teste apagatr   String data = "hello world";        
        // new String cast de byte para string
//        String enc  = new String(encrypt(data.getBytes()));        
//        String enc  = new String(encrypt(data.getBytes()));        
//        String dec  = new String(decrypt(enc.getBytes())); 
        // apagar teste

        if (usuario == true) {

//            por enquanto passando email
            request.setAttribute("nome", username);
/////////////////////teste para pegar tipo do usuario //////////////////////////////
            Usuario tipo = UsuarioDao.getTipoUsuario(username);
            // se o usuario for admministrador vai para tela indexadmin senao vai para estoquista
            if (tipo.getTipo().equals("Administrador")) {
                RequestDispatcher rd
                        = //            getServletContext().getRequestDispatcher("/index.jsp");
                        //            teste nav bar
                        getServletContext().getRequestDispatcher("/indexAdministrador.jsp");

//fim do teste nav bar
                rd.forward(request, response);

            } else {
                RequestDispatcher rd
                        = //            getServletContext().getRequestDispatcher("/index.jsp");
                        //            teste nav bar
                        getServletContext().getRequestDispatcher("/indexEstoquista.jsp");

//fim do teste nav bar
                rd.forward(request, response);

//////////////////////fim do teste /////////////////////////////////
//            request.setAttribute("nome", username);
                // teste quando for usuario normal
//            RequestDispatcher rd =
////            getServletContext().getRequestDispatcher("/index.jsp");
////            teste nav bar
//            getServletContext().getRequestDispatcher("/cadastrarImagens4.jsp");
                // levar funcionario para indexAdministrador//
//                RequestDispatcher rd
//                        = //            getServletContext().getRequestDispatcher("/index.jsp");
//                        //            teste nav bar
//                        getServletContext().getRequestDispatcher("/indexAdministrador.jsp");
//
////fim do teste nav bar
//                rd.forward(request, response);
            }
        } else {
            RequestDispatcher rd
                    = getServletContext().getRequestDispatcher("/cadastrarProduto.jsp");
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
