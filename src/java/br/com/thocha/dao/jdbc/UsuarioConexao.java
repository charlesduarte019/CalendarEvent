package br.com.thocha.dao.jdbc;

import br.com.thocha.modelo.Usuario;
import com.sun.org.apache.xerces.internal.util.FeatureState;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioConexao {

    public void inserir(Usuario user) throws SQLException {
        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement preparedStatement = null;
        String inserirSQL = "INSERT INTO APIS.USUARIO"
                + "(NOME, SOBRENOME, EMAIL, SENHA, DATANASCIMENTO, SEXO, CELULAR) VALUES"
                + "(?,?,?,?,?,?,?)";

        try {
            preparedStatement = con.prepareStatement(inserirSQL);
            preparedStatement.setString(1, user.getNome());
            preparedStatement.setString(2, user.getSobrenome());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getSenha());
            preparedStatement.setString(5, user.getDataNascimento());
            preparedStatement.setString(6, user.getSexo());
            preparedStatement.setString(7, user.getCelular());

            preparedStatement.executeUpdate();
            //LOG.info("Registro adicionado");
        } catch (Exception e) {
            //LOG.info("pal no codgo!");
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public boolean buscarUserLogin(String login, String senha) throws SQLException {
        Connection con = new ConnectionFactory().getConnection();

        try {
            Statement estado = con.createStatement();
            ResultSet resultado = estado.executeQuery("SELECT email, senha FROM apis.usuario WHERE email = '" + login + "'");

            while (resultado.next()) {
                if (resultado.getString("email").equals(login) && resultado.getString("senha").equals(senha)) {
                    return true;
                }
            }
            return false;

        } catch (Exception e) {

        }
        return false;
    }

    public String retornaUserLogin(String login) throws SQLException {
        Connection con = new ConnectionFactory().getConnection();

        try {
            Statement estado = con.createStatement();
            ResultSet resultado = estado.executeQuery("SELECT nome, email FROM apis.usuario WHERE email = '" + login + "'");

            while (resultado.next()) {
                if (resultado.getString("email").equals(login)) {
                    return resultado.getString("nome");
                }
            }
            return null;

        } catch (Exception e) {

        }
        return null;
    }

    public Usuario retornaCadastroUser(String user) {
        Connection con = new ConnectionFactory().getConnection();
        Usuario userReturn = new Usuario();

        try {
            Statement estado = con.createStatement();
            ResultSet resultado = estado.executeQuery("SELECT nome, sobrenome, email, datanascimento, sexo, celular  FROM apis.usuario WHERE nome = '" + user + "'");

            while (resultado.next()) {
                if (resultado.getString("nome").equals(user)) {
                    userReturn.setNome(user);
                    userReturn.setSobrenome(resultado.getString("sobrenome"));
                    userReturn.setEmail(resultado.getString("email"));
                    userReturn.setDataNascimento(resultado.getString("datanascimento"));
                    userReturn.setSexo(resultado.getString("sexo"));
                    userReturn.setCelular(resultado.getString("celular"));

                    return userReturn;
                }
            }

        } catch (Exception e) {

        }

        return userReturn;
    }

    public void updateCadastroUser(Usuario user, String login) throws SQLException {
        Connection con = new ConnectionFactory().getConnection();

        String nome = user.getNome();
        String sobrenome = user.getSobrenome();
        String email = user.getEmail();
        String senhaAtual = user.getSenha();
        String novaSenha = user.getNovaSenha();
        String data = user.getDataNascimento();
        String sexo = user.getSexo();
        String celular = user.getCelular();

        try {
            Statement estado = con.createStatement();
            if (novaSenha.equals("")) {
                estado.executeQuery("UPDATE apis.usuario SET nome = '" + nome + "', sobrenome = '" + sobrenome + "', email = '" + email + "', datanascimento = '" + data + "', sexo = '" + sexo + "', celular = '" + celular + "' WHERE nome = '" + login + "' AND senha = '" + senhaAtual + "'");
            } else {
                estado.executeQuery("UPDATE apis.usuario SET nome = '" + nome + "', sobrenome = '" + sobrenome + "', email = '" + email + "', senha = '" + novaSenha + "', datanascimento = '" + data + "', sexo = '" + sexo + "', celular = '" + celular + "' WHERE nome = '" + login + "' AND senha = '" + senhaAtual + "'");
            }

        } catch (Exception e) {

        }

    }

    public void deletarCadastroUser(String user, String email, String senha) throws SQLException {
        Connection con = new ConnectionFactory().getConnection();

        try {
            Statement estado = con.createStatement();
            estado.executeQuery("DELETE FROM apis.usuario WHERE nome = '" + user + "' AND email = '" + email + "' AND senha = '" + senha + "'");

        } catch (Exception e) {

        }
    }

}
