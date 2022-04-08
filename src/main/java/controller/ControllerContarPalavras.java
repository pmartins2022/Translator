package controller;

import model.Translator;

public class ControllerContarPalavras
{
    Translator _translator;
    public ControllerContarPalavras (Translator _translator)
    {
        this._translator=_translator;
    }

    public int contarPalavras ()
    {
        return _translator.contarPalavras();
    }
}