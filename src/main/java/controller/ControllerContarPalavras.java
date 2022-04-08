package controller;

import model.Translator;

import java.sql.SQLException;

public class ControllerContarPalavras
{
    Translator translator;
    public ControllerContarPalavras ()
    {
        translator = Translator.getInstance();
    }

    public int contarPalavras () throws SQLException
    {
        return translator.contarPalavras();
    }
}