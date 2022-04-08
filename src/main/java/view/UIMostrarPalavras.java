package view;
import controller.ControllerMostrarPalavras;

import java.sql.SQLException;

public class UIMostrarPalavras
{
    ControllerMostrarPalavras _controller;

    public UIMostrarPalavras ()
    {
        _controller = new ControllerMostrarPalavras ();
    }

    public void run()
    {
        try
        {
            System.out.println (_controller.mostrarPalavras ());
        }
        catch (SQLException e)
        {
            System.out.println("Problema a mostrar as palavras");
        }
    }

}
