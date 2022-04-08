package model;

public class Translator
{
    public static Translator instance = null;

    public Translator()
    {
        if (instance == null)
        {
            instance = this;
        }
    }

    public Idioma criarIdioma (String nome){
        Idioma idioma = new Idioma(nome);
        return idioma;
    }

    public boolean guardaIdioma (Idioma idioma){
        boolean flag = false;
        
    }

    public Translator getInstance()
    {
        return instance;
    }
}
