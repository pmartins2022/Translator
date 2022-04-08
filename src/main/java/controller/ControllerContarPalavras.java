package controller;

import model.Translator;

import java.sql.SQLException;

public class ControllerContarPalavras
{
    Translator _translator;
    public ControllerContarPalavras (Translator _translator)
    {
        this._translator=_translator;
    }

    public int contarPalavras () throws SQLException
    {
        return _translator.contarPalavras();
    }
}