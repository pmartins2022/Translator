package model;

public class Idioma {

    String nome;

    public Idioma (String nome){
        this.nome=nome;
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return nome;
=======
        return "" + nome;
>>>>>>> 3bfedc58b6479e872cb6c6803d5b2c10da92ed34
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Idioma)) return false;
        Idioma idioma = (Idioma) o;
        return nome.equalsIgnoreCase(idioma.nome);
    }
}
