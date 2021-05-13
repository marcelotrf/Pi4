/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import dao.CarrinhoDao;
import dao.ImagemDao;
import dao.ProdutoDao;
import entidade.CarrinhoE;
import entidade.Imagem;
import entidade.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class Carrinho extends HttpServlet {

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
            out.println("<title>Servlet Carrinho</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Carrinho at " + request.getContextPath() + "</h1>");
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

        request.setCharacterEncoding("UTF-8");
//        utilizou o nome abaixo para o nao logado
//        String nome = request.getParameter("nome");
// utliziou o nome abaixo para o logado tentar usar essse
        String nome = request.getParameter("nomeProduto");
        String email = request.getParameter("email");
        Produto produto = ProdutoDao.getProduto(nome);
        List<Imagem> listaImagens = ImagemDao.getImagem(nome);
        Imagem imagens = listaImagens.get(0);
        request.setAttribute("produtoI", imagens);

        ///////// verificar se produo ja esta no carrinho/////////////////
        boolean existeCarrinho = CarrinhoDao.verificaProdutoCarrinho(nome);
//     aqui existe produto no carrinho, deve adicionar +1 na quantidade
        if (existeCarrinho == true) {
            // quantidade produto carrinho ka soma  +1 
            CarrinhoE quantidadeB = CarrinhoDao.QuantidadePCarrinho(nome);
            int quantidade = quantidadeB.getQuantidade();
            try {
                CarrinhoDao.Add1Produto(nome, quantidade);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Carrinho.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Carrinho.class.getName()).log(Level.SEVERE, null, ex);
            }

            /////////// talvez nao precise
//            request.setAttribute("produto", produto);
//            RequestDispatcher rd
//                    = getServletContext().getRequestDispatcher("/carrinho.jsp");
//
//            rd.forward(request, response);
        } else {

            ////////////// criar carrinho teste banco////////////////////
            String nomeComprador = "JoadoTeste";
            int quantidade = 1;
            String statusOrdem = "Aberto";
            CarrinhoE carrinho = new CarrinhoE(nomeComprador, produto.getNome(), quantidade, produto.getPreco(), statusOrdem, imagens.getNomeImagem());
            try {
                CarrinhoDao.CriarCarrinho(carrinho);
//            UsuarioDao.addCliente(cliente);
//                response.sendRedirect("login.jsp");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Carrinho.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Carrinho.class.getName()).log(Level.SEVERE, null, ex);
//            Utils.mostrarTelaErro(ex, request, response);
            }

            //////////// fim teste //////////////////
//         List<Produto> listaProdutos = ProdutoDao.getProduto();
            //             utilizar metodo request  para armazenar a lista em request  
//        Produto statusALte = new Produto(statusAlt);
//        statusALte.setStatusAlt(statusAlt);
//        listaProdutos.add(statusALte);
//        request.setAttribute("listaProdutos", listaProdutos);        
//     apagar   String nome = "joao";
//     apagara   request.setAttribute("ativar", nome);   
//        Dispacher vai apresentar o request na pagina jsp
//        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/listarProduto.jsp");
//        requestDispatcher.forward(request, response); 
//  teste para mostrar semrep/////////
//            request.setAttribute("produto", carrinho);
//            // mostrar na tela o request
//            RequestDispatcher rd
//                    = getServletContext().getRequestDispatcher("/carrinho.jsp");
//            rd.forward(request, response);
        }
        // aducuonar para lista percorrer somebte aberto o status
        List<CarrinhoE> listaCarrinho = CarrinhoDao.getProdutoCarrinho();
        // teste para por o valor total deu ruim///
//        CarrinhoE quantidadeB = CarrinhoDao.QuantidadePCarrinho(nome);
//        double valorTotal = (double) quantidadeB.getQuantidade() * listaCarrinho.get;

        //// fim teste
        // pegar o ultimo valor final da lista
        CarrinhoE valorFinalL = listaCarrinho.get(listaCarrinho.size() - 1);
        double valorFinal = valorFinalL.getValorFinal();

        request.setAttribute("listaCarrinho", listaCarrinho);
        request.setAttribute("valorFinal", valorFinal);
        // mostrar na tela o request
        
//        verifica se comprador esta logado
        
        if(email!=null)
        {
            request.setAttribute("email", email); 
            RequestDispatcher rd
                    = getServletContext().getRequestDispatcher("/carrinhoLogado.jsp");
            rd.forward(request, response);

        }
        else{
        RequestDispatcher rd
                = getServletContext().getRequestDispatcher("/carrinho.jsp");
        rd.forward(request, response);
                }
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
        String nome = request.getParameter("nome");
        String quantidadeStr = request.getParameter("quantidade");
        String cepStr = request.getParameter("cep");

        int cep = 0;
        if (cepStr != null) {
            cep = Integer.parseInt(cepStr);
            cep = CarrinhoDao.CalculoFrete(cep);
        }

//        cep=cep+1;
        int quantidade;
        if (quantidadeStr != null) {
            quantidade = Integer.parseInt(quantidadeStr);

            try {
                CarrinhoDao.Add1Produto(nome, quantidade);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Carrinho.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Carrinho.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        List<CarrinhoE> listaCarrinho = CarrinhoDao.getProdutoCarrinho();
//        teste
        CarrinhoE valorFinalL = listaCarrinho.get(listaCarrinho.size() - 1);
        double valorFinal = valorFinalL.getValorFinal();
        valorFinal = (double) valorFinal + cep;

        request.setAttribute("valorFinal", valorFinal);
        request.setAttribute("listaCarrinho", listaCarrinho);
        request.setAttribute("valorFrete", cep);
        // mostrar na tela o request
        RequestDispatcher rd
                = getServletContext().getRequestDispatcher("/carrinho.jsp");
        rd.forward(request, response);
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
