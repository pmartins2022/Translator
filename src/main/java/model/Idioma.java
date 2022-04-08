package model;

public class Idioma {

    String nome;

    public Idioma (String nome){
        this.nome=nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "model.Idioma: " + nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Idioma)) return false;
        Idioma idioma = (Idioma) o;
        return getNome().equals(idioma.getNome());
    }
}
