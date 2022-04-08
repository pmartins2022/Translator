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

    public boolean validaIdioma (Idioma idioma){
        boolean flag = false;


        return flag;
    }

    public boolean guardaIdioma (Idioma idioma){
        boolean flag = false;
        if(validaIdioma(idioma)){

        }

        return flag;
    }

    public Translator getInstance()
    {
        return instance;
    }


}
