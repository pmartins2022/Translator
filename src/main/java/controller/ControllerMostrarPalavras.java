package controller;

import model.Translator;

import java.sql.SQLException;

public class ControllerMostrarPalavras
{
    Translator _translator;
    public ControllerMostrarPalavras (Translator _translator)
    {
        this._translator=_translator;
    }

    public String mostrarPalavras() throws SQLException
    {
        return _translator.mostrarPalavras();
    }

}