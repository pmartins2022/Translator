package Controller;

import model.Idioma;
import model.Translator;

public class ControllerCriarIdioma {

    public void criarIdioma (String nome){

        Translator.instance.criarIdioma(nome);

    }
}
