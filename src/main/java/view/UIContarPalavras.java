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

    public int contarPalavras() throws SQLException
    {
        return _controller.contarPalavras();
    }

}
