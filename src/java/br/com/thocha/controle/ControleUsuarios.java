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

        Usuario newUser = new Usuario();
        userConexao = new UsuarioConexao();

        if (action.equals("login")) {

            login = request.getParameter("login");
            senhaAcesso = request.getParameter("senhaP1");

            newUser.setUserLogin(login);
            newUser.setSenhaLogin(senhaAcesso);

            try {
                if (userConexao.buscarUser(newUser)) {
                    userLogin = userConexao.retornaUserLogin(login);
                    session.setAttribute("userLogin", userLogin);

                    userErro = false;

                    paginaRequest = "produtosThoCha.jsp";
                } else {
                    userErro = true;

                    paginaRequest = "index.jsp";
                }
                session.setAttribute("userErroM", userErro);
            } catch (SQLException ex) {
                out.println("Não foi possivel encontrar o usuario!");
            }

        } else {

            String nome = request.getParameter("nome");
            String sobrenome = request.getParameter("sobrenome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String confirmeSenha = request.getParameter("confirmeSenha");
            String dataNascimento = (request.getParameter("dia") + "/" + request.getParameter("mes") + "/" + request.getParameter("ano"));
            String sexo = request.getParameter("sexo");
            String celular = request.getParameter("celular");

            newUser.setNome(nome);
            newUser.setSobrenome(sobrenome);
            newUser.setEmail(email);
            newUser.setSenha(senha);
            newUser.setConfirmeSenha(confirmeSenha);
            newUser.setDataNascimento(dataNascimento);
            newUser.setSexo(sexo);
            newUser.setCelular(celular);

            if (action.equals("cadastrar")) {
                try {
                    userLogin = newUser.getNome();
                    userConexao.inserir(newUser);
                    paginaRequest = "produtosThoCha.jsp";
                    session.setAttribute("userLogin", userLogin);
                } catch (SQLException ex) {
                    out.println("Não foi possivel salvar!");
                }
            }
        }

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
