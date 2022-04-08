package view;
import controller.ControllerMostrarPalavras;

public class UIMostrarPalavras
{
    ControllerMostrarPalavras _controller;

    public UIMostrarPalavras ()
    {
        _controller = new ControllerMostrarPalavras ();
    }

    public String mostrarPalavras()
    {
        return _controller.mostrarPalavras();
    }

}
