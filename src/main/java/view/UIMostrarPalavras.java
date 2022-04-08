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

    public String mostrarPalavras() throws SQLException
    {
        return _controller.mostrarPalavras();
    }

}
