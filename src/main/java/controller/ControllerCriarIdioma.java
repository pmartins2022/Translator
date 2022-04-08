package controller;

import model.Idioma;
import model.Translator;

public class ControllerCriarIdioma {

    public Translator translator;
    public ControllerCriarIdioma () {translator = Translator.getInstance();}


    public boolean criarIdioma (String nome){
        boolean flag = false;
        Idioma idioma =translator.criarIdioma(nome);
        translator.guardaIdioma(idioma);
        flag = true;
        return flag;
    }

}
