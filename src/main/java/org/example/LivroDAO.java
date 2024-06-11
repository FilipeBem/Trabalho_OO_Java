package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import cadastro.*;

public class LivroDAO {
    private Connection connection;

    public LivroDAO(Connection connection) {
        this.connection = connection;
    }

    public void adicionarLivro(Livro livro) {
        try {
            String query = "INSERT INTO livros (titulo, sinopse, editora, genero, preco_tabela, custo) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, livro.getTitulo());
            statement.setString(2, livro.getSinopse());
            statement.setString(3, livro.getEditora());
            statement.setString(4, livro.getGenero());
            statement.setDouble(5, livro.getPrecoTabela());
            statement.setDouble(6, livro.getCusto());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Livro buscarLivro(String titulo) {
        Livro livro = null;
        try {
            String query = "SELECT * FROM livros WHERE titulo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, titulo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                livro = new Livro(resultSet.getString("titulo"), resultSet.getString("sinopse"),
                        resultSet.getString("editora"), resultSet.getString("genero"),
                        resultSet.getDouble("preco_tabela"), resultSet.getDouble("custo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livro;
    }

    public void removerLivro(Livro livro) {
        try {
            String query = "DELETE FROM livros WHERE titulo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, livro.getTitulo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}