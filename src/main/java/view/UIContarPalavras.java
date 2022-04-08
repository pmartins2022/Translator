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

    public void run () throws SQLException
    {

        System.out.printf ("\nSao %d palavras!", _controller.contarPalavras ());
    }

}
