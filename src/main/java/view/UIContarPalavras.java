package view;

import controller.ControllerContarPalavras;
import model.Translator;

import java.util.Scanner;

public class UIContarPalavras
{
    Translator _translator;
    Scanner lerTeclado = new Scanner (System.in);
    ControllerContarPalavras _controller;

    public UIContarPalavras (Translator _translator)
    {
        this._translator = _translator;
        _controller = new ControllerContarPalavras (_translator);
    }

    public int contarPalavras()
    {
        return _controller.contarPalavras();
    }

}
