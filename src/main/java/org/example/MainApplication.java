package org.example;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import cadastro.*;

public class MainApplication extends Application {

    private Biblioteca biblioteca;

    @Override
    public void start(Stage primaryStage) {
        // Inicializar a biblioteca
        biblioteca = new Biblioteca();

        // Criar os componentes da interface
        Label tituloLabel = new Label("Título do Livro:");
        TextField tituloField = new TextField();

        Label sinopseLabel = new Label("Sinopse:");
        TextArea sinopseField = new TextArea();
        sinopseField.setPromptText("Digite a sinopse do livro aqui...");
        sinopseField.setWrapText(true);

        Label editoraLabel = new Label("Editora:");
        TextField editoraField = new TextField();

        Label generoLabel = new Label("Gênero:");
        TextField generoField = new TextField();

        Label precoTabelaLabel = new Label("Preço de Tabela:");
        TextField precoTabelaField = new TextField();

        Label custoLabel = new Label("Custo:");
        TextField custoField = new TextField();

        Button cadastrarButton = new Button("Cadastrar");
        Button atualizarButton = new Button("Atualizar");
        Button excluirButton = new Button("Excluir");

        // Criar o layout da interface
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        Insets insets = new Insets(10, 0, 0, 20);
        grid.setPadding(insets);

        grid.add(tituloLabel, 0, 0);
        grid.add(tituloField, 1, 0);

        grid.add(sinopseLabel, 0, 1);
        grid.add(sinopseField, 1, 1);

        grid.add(editoraLabel, 0, 2);
        grid.add(editoraField, 1, 2);

        grid.add(generoLabel, 0, 3);
        grid.add(generoField, 1, 3);

        grid.add(precoTabelaLabel, 0, 4);
        grid.add(precoTabelaField, 1, 4);

        grid.add(custoLabel, 0, 5);
        grid.add(custoField, 1, 5);

        grid.add(cadastrarButton, 0, 6);
        GridPane.setMargin(cadastrarButton, new Insets(0, 10, 0, 0));

        grid.add(atualizarButton, 1, 6);
        GridPane.setMargin(atualizarButton, new Insets(0, 10, 0, 50));

        grid.add(excluirButton, 2, 6);
        GridPane.setMargin(excluirButton, new Insets(0, 0, 0, -500));

        // Criar a cena e exibir a janela
        Scene scene = new Scene(grid, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cadastro de Livros");
        primaryStage.show();

        // Adicionar os listeners aos botões
        cadastrarButton.setOnAction(event -> {
            int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar o livro?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirmacao == JOptionPane.YES_OPTION) {
                try {
                    String titulo = tituloField.getText();
                    String sinopse = sinopseField.getText();
                    String editora = editoraField.getText();
                    String genero = generoField.getText();
                    double precoTabela = Double.parseDouble(precoTabelaField.getText());
                    double custo = Double.parseDouble(custoField.getText());

                    Livro livro = new Livro(titulo, sinopse, editora, genero, precoTabela, custo);
                    biblioteca.adicionarLivro(livro);

                    // Limpar os campos após o cadastro
                    tituloField.clear();
                    sinopseField.clear();
                    editoraField.clear();
                    generoField.clear();
                    precoTabelaField.clear();
                    custoField.clear();
                } catch (NumberFormatException e) {
                    // Tratar exceção de formato de número inválido
                    e.printStackTrace();
                }
            }
        });

        atualizarButton.setOnAction(event -> {
            int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja atualizar o livro?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirmacao == JOptionPane.YES_OPTION) {
                try {
                    String titulo = tituloField.getText();
                    String sinopse = sinopseField.getText();
                    String editora = editoraField.getText();
                    String genero = generoField.getText();
                    double precoTabela = Double.parseDouble(precoTabelaField.getText());
                    double custo = Double.parseDouble(custoField.getText());

                    Livro livro = biblioteca.buscarLivro(titulo);
                    if (livro != null) {
                        livro.setSinopse(sinopse);
                        livro.setEditora(editora);
                        livro.setGenero(genero);
                        livro.setPrecoTabela(precoTabela);
                        livro.setCusto(custo);
                    }
                } catch (NumberFormatException e) {
                    // Tratar exceção de formato de número inválido
                    e.printStackTrace();
                }
            }
        });

        excluirButton.setOnAction(event -> {
            int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja excluir o livro?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirmacao == JOptionPane.YES_OPTION) {
                String titulo = tituloField.getText();
                Livro livro = biblioteca.buscarLivro(titulo);
                if (livro != null) {
                    biblioteca.removerLivro(livro);
                }
            }
        });
    }


}