package br.com.thocha.dao.jdbc;

import br.com.thocha.modelo.Usuario;
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

    public boolean buscarUser(Usuario user) throws SQLException {
        System.out.println("Este é o metodo buscarUser");
        Connection con = new ConnectionFactory().getConnection();

        try {
            Statement estado = con.createStatement();
            ResultSet resultado = estado.executeQuery("SELECT email, senha FROM apis.usuario WHERE email = '" + user.getUserLogin() + "'");

            while (resultado.next()) {
                if (resultado.getString("email").equals(user.getUserLogin()) && resultado.getString("senha").equals(user.getSenhaLogin())) {
                    return true;
                }
            }
            return false;

        } catch (Exception e) {

        }
        return false;
    }
    
    public String retornaUserLogin(String login) throws SQLException {
        System.out.println("Este é o metodo buscarUser");
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
    
}
