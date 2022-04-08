package controller;

import model.Translator;

public class ControllerMostrarPalavras
{
    Translator _translator;
    public ControllerMostrarPalavras (Translator _translator)
    {
        this._translator=_translator;
    }

    public String mostrarPalavras()
    {
        return _translator.mostrarPalavras();
    }

}