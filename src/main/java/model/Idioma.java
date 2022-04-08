package model;

public class Idioma {

    String nome;
    Idioma idioma;

    public Idioma (String nome){
        this.nome=nome;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "" + idioma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Idioma)) return false;
        Idioma idioma = (Idioma) o;
        return getIdioma().equals(idioma.getIdioma());
    }
}
