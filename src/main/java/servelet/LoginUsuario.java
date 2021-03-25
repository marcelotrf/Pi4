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
public class LoginUsuario extends HttpServlet {

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
            out.println("<title>Servlet LoginUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginUsuario at " + request.getContextPath() + "</h1>");
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
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException 
//    {
//        String username = request.getParameter("email");
//String senha = request.getParameter("senha");
//
//
////RequestDispatcher rd = null;
//
////Usuario user = new Usuario();
////user.setNome(username);
////user.setSenha(senha);
//
//
//boolean usuario = UsuarioDao.verificaUsuario(username,senha);
//
////try {
//if(usuario==true)
//{
//    RequestDispatcher rd =
//                getServletContext().getRequestDispatcher("/index.jsp");
//        rd.forward(request, response); 
//////Caso login e senha estejam corretos...
////if(username.equals("usuario") && senha.equals("pass")){
////
////HttpSession session = request.getSession(true);
////
////session.setAttribute("usuario",username);
////session.setAttribute("pass",senha);
////
////out.println("Bem vindo."+ username +"."); //Mostra na tela que foi logado com sucesso
////
////session.putValue("loginUsuario", session.getAttribute("usuario")); //Grava a session com o Login
////session.putValue("senhaUsuario", session.getAttribute("pass")); //Grava a session com a Senha
////
//////out.println("<script>document.location.href='tela_download.jsp';</script>"); //Exibe um código javascript para redireionar ao painel
////request.setAttribute("msg", username);
////request.getRequestDispatcher("tela_download.jsp").forward(request, response);
////
////}
/////*request.setAttribute("msg", usuario);
////rd=request.getRequestDispatcher("tela_download.jsp");
////rd.forward(request,response);*/
//}
//else
//{
//    RequestDispatcher rd =
//                getServletContext().getRequestDispatcher("/cadastrarProduto.jsp");
//        rd.forward(request, response); 
//        
////request.setAttribute("msg", "Usuário ou Senha inválidos");
////rd=request.getRequestDispatcher("index_login.jsp");
////rd.forward(request,response);
//
////Se estiverem incorretos...
//// out.println("Login ou senha inválidos. <a href='java script:back()'>Voltar</a>"); //Exibe na tela e pede para voltar
//}
////} catch (Exception ex) {
////Logger.getLogger(Logar.class.getName()).log(Level.SEVERE, null, ex);
////}
//}
    //}

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
        String username = request.getParameter("nome");
        String senha = request.getParameter("senha");
        boolean usuario = UsuarioDao.verificaUsuario(username,senha);
//        Usuario usuario = UsuarioDao.ver
        
        if(usuario==true)
        {
            RequestDispatcher rd =
            getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response); 

        }
        else
        {
            RequestDispatcher rd =
            getServletContext().getRequestDispatcher("/cadastrarProduto.jsp");
            rd.forward(request, response); 
        }
    }
}
