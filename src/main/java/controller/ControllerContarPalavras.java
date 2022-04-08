package controller;

import model.Translator;

public class ControllerContarPalavras
{
    Translator translator;
    public ControllerContarPalavras ()
    {
        translator = Translator.getInstance();
    }
}