package Controller;

import model.Idioma;
import model.Translator;

public class ControllerCriarIdioma {

    public Translator translator;
    public ControllerCriarIdioma () {this.translator=translator;}


    public boolean criarIdioma (String nome){
        boolean flag = false;
        Idioma idioma =Translator.instance.criarIdioma(nome);
        translator.validaIdioma(idioma);
        flag = true;
        return flag;
    }

}
