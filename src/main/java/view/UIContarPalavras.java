package view;
import controller.ControllerContarPalavras;

public class UIContarPalavras
{
    ControllerContarPalavras _controller;

    public UIContarPalavras ()
    {
        _controller = new ControllerContarPalavras ();
    }

    public int contarPalavras()
    {
        return _controller.contarPalavras();
    }

}
