package cadastro;

public class Livro {
    private String titulo;
    private String sinopse;
    private String editora;
    private String genero;
    private double precoTabela;
    private double custo;
    private boolean disponivel;

    // Construtor
    public Livro(String titulo, String sinopse, String editora, String genero, double precoTabela, double custo) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.editora = editora;
        this.genero = genero;
        this.precoTabela = precoTabela;
        this.custo = custo;
        this.disponivel = true;
    }

    // Getters and Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPrecoTabela() {
        return precoTabela;
    }

    public void setPrecoTabela(double precoTabela) {
        this.precoTabela = precoTabela;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}