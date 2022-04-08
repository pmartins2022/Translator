package controller;

import model.Translator;

public class ControllerMostrarPalavras
{
    Translator translator;
    public ControllerMostrarPalavras ()
    {
        translator = Translator.getInstance();
    }

    public String mostrarPalavras()
    {
        return translator.mostrarPalavras();
    }

}