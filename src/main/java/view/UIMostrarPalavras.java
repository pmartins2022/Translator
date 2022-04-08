package view;

import controller.ControllerMostrarPalavras;
import model.Translator;

import java.util.Scanner;

public class UIMostrarPalavras
{
    Translator _translator;
    Scanner lerTeclado = new Scanner (System.in);
    ControllerMostrarPalavras _controller;

    public UIMostrarPalavras (Translator _translator)
    {
        this._translator = _translator;
        _controller = new ControllerMostrarPalavras ();
    }

//    public int mostrarPalavras()
//    {
//        return _controller.mostrarPalavras();
//    }

}
