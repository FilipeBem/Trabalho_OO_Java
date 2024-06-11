package cadastro;


import org.example.*;
import java.util.List;
import java.util.ArrayList;


public class Biblioteca {
    private List<Livro> acervo;

    // Construtor
    public Biblioteca() {
        this.acervo = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro)  {
        acervo.add(livro);
        Connector conn = new Connector();
        LivroDAO li = new LivroDAO(conn.getConector());
        li.adicionarLivro(livro);
    }

    public void removerLivro(Livro livro) {
        acervo.remove(livro);
    }

    public Livro buscarLivro(String titulo) {
        for (Livro livro : acervo) {
            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }
        return null;
    }
}