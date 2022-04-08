package controller;

import model.Translator;

import java.sql.SQLException;

public class ControllerMostrarPalavras
{
    Translator translator;
    public ControllerMostrarPalavras ()
    {
        translator = Translator.getInstance();
    }

    public String mostrarPalavras() throws SQLException
    {
        return translator.mostrarPalavras();
    }

}