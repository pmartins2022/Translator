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
        try
        {
            return translator.mostrarPalavras();
        }
        catch (SQLException e)
        {
            System.out.println("ERRO: "+e.getMessage());
        }
        return null;
    }

}