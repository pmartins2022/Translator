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
        try
        {
            return translator.contarPalavras();
        }
        catch (SQLException e)
        {
            System.out.println("ERRO: "+e.getMessage());
        }

        return -1;
    }
}