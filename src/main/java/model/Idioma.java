package model;

public class Idioma {

    String nome;

    public Idioma (String nome){
        this.nome=nome;
    }

    @Override
    public String toString()
    {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Idioma)) return false;
        Idioma idioma = (Idioma) o;
        return nome.equalsIgnoreCase(idioma.nome);
    }
}
