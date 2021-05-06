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
import java.sql.SQLException;
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
public class CadastrarUsuario extends HttpServlet {

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
            out.println("<title>Servlet CadastrarUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastrarUsuario at " + request.getContextPath() + "</h1>");
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
     /////////////////////   teste//////////////////////////
     String email = request.getParameter("email");
     boolean emailFuncionario = UsuarioDao.verificaEmail(email);
//     aqui existe email
     if(emailFuncionario==true)
        {
//            por enquanto passando email
//             request.setAttribute("nome", username); 
            RequestDispatcher rd =
//            getServletContext().getRequestDispatcher("/index.jsp");
//            teste nav bar
            getServletContext().getRequestDispatcher("/indexAdiministrador.jsp");
            
            

//fim do teste nav bar


            rd.forward(request, response); 

        }
        else
        {
//            dispensar no final
//            RequestDispatcher rd =
//            getServletContext().getRequestDispatcher("/cadastrarProduto.jsp");
//            rd.forward(request, response); 
        
     ///////////////////// fim  teste//////////////////////////
        String nome = request.getParameter("nome");
//        String email = request.getParameter("email");
        String tipo = request.getParameter("tipo");
//        String cpfStr = request.getParameter("cpf");
//        Long cpf = Long.parseLong(cpfStr);
        String senha = request.getParameter("senha");
//         status pode ser Ativado ou Desativado
        String status = "Ativado";
//        String enc  = new String(encrypt(data.getBytes())); 
        senha  = new String(UsuarioDao.encripitar(senha.getBytes())); 
         
            
                
        Usuario usuario = new Usuario(nome,senha,tipo,email,status);
        try {
            UsuarioDao.addUsuario(usuario);
//            UsuarioDao.addCliente(cliente);
            response.sendRedirect("login.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
//            Utils.mostrarTelaErro(ex, request, response);
    }
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
