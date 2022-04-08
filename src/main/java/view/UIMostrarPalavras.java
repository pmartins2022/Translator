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

    public void run() throws SQLException
    {
        System.out.println (_controller.mostrarPalavras ());
    }

}
