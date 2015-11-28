package br.com.thocha.controle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.thocha.dao.jdbc.UsuarioConexao;
import br.com.thocha.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author charl
 */
@WebServlet(name = "ControleUsuarios", urlPatterns = {"/ControleUsuarios"})
public class ControleUsuarios extends HttpServlet {

    private static String userLogin;
    private boolean userErro = false;

    private Usuario newUser;
    private UsuarioConexao userConexao;

    private static final Logger LOG = Logger.getLogger(ControleUsuarios.class.getName());

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
            out.println("<title>Servlet ControleUsuarios</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControleUsuarios at " + request.getContextPath() + "</h1>");
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

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        String paginaRequest = null, login, senhaAcesso;

        userConexao = new UsuarioConexao();

        if (action.equals("login")) {

            login = request.getParameter("login");
            senhaAcesso = request.getParameter("senhaP1");

//            newUser.setUserLogin(login);
//            newUser.setSenhaLogin(senhaAcesso);
            try {
                if (userConexao.buscarUserLogin(login, senhaAcesso)) {
                    userLogin = userConexao.retornaUserLogin(login);
                    newUser = new Usuario();
                    newUser = userConexao.retornaCadastroUser(userLogin);

                    userErro = false;
                    paginaRequest = "produtosThoCha.jsp";
                } else {
                    userErro = true;
                    paginaRequest = "index.jsp";
                }
//                session.setAttribute("userErroM", userErro);
            } catch (SQLException ex) {
                out.println("Não foi possivel encontrar o usuario!");
            }

        } else {

            if (action.equals("cadastrar")) {

                String dataNascimento = (request.getParameter("dia") + "/" + request.getParameter("mes") + "/" + request.getParameter("ano"));

                newUser = new Usuario();
                newUser.setNome(request.getParameter("nome"));
                newUser.setSobrenome(request.getParameter("sobrenome"));
                newUser.setEmail(request.getParameter("email"));
                newUser.setSenha(request.getParameter("senha"));
                newUser.setConfirmeSenha(request.getParameter("confirmeSenha"));
                newUser.setDataNascimento(dataNascimento);
                newUser.setSexo(request.getParameter("sexo"));
                newUser.setCelular(request.getParameter("celular"));

                try {
                    userLogin = newUser.getNome();
                    userConexao.inserir(newUser);
                    paginaRequest = "produtosThoCha.jsp";
                    session.setAttribute("userLogin", userLogin);
                } catch (SQLException ex) {
                    out.println("Não foi possivel salvar!");
                }

            } else {
                if (action.equals("opcaoConfiguracao")) {

                    newUser = new Usuario();
                    newUser.setNome(request.getParameter("nome"));
                    newUser.setSobrenome(request.getParameter("sobrenome"));
                    newUser.setEmail(request.getParameter("email"));
                    newUser.setSenha(request.getParameter("senhaAtual"));
                    newUser.setNovaSenha(request.getParameter("newSenha"));
                    newUser.setDataNascimento(request.getParameter("dataUser"));
                    newUser.setSexo(request.getParameter("sexo"));
                    newUser.setCelular(request.getParameter("celular"));

                    try {
                        userLogin = newUser.getNome();
                        userConexao.updateCadastroUser(newUser, userLogin);
                        newUser = userConexao.retornaCadastroUser(userLogin);
                        paginaRequest = "produtosThoCha.jsp";
                    } catch (SQLException ex) {
                        out.println("Não foi possivel salvar!");
                    }

                }else{
                    if(action.equals("excluirUser")){
                        
                        try {
                            String user = request.getParameter("loginP6");
                            String senhaUser = request.getParameter("senhaP6");
                            
                            userConexao.deletarCadastroUser(userLogin, user, senhaUser);
                        
                        
                        paginaRequest = "index.jsp";
                        
                    } catch (SQLException ex) {
                        out.println("Não foi possivel salvar!");
                    }
                        
                    }
                }
            }
        }

        session.setAttribute("userLogin", userLogin);
        session.setAttribute("opcaoNome", newUser.getNome());
        session.setAttribute("opcaoSobrenome", newUser.getSobrenome());
        session.setAttribute("opcaoEmail", newUser.getEmail());
        session.setAttribute("opcaoData", newUser.getDataNascimento());
        session.setAttribute("opcaoSexo", newUser.getSexo());
        session.setAttribute("opcaoCelular", newUser.getCelular());

        response.sendRedirect(paginaRequest);

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
