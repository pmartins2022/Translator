package view;
import controller.ControllerContarPalavras;

import java.sql.SQLException;

public class UIContarPalavras
{
    ControllerContarPalavras _controller;

    public UIContarPalavras ()
    {
        _controller = new ControllerContarPalavras ();
    }

    public void run ()
    {
        int nPalavras = 0;
        try
        {
            nPalavras = _controller.contarPalavras();
            System.out.printf ("\nSao %d palavras!", _controller.contarPalavras ());
        }
        catch (SQLException e)
        {
            System.out.println("Problema a contar as palavras.");
        }
    }

}
