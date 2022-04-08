package view;

import controller.Controller_AdicionarPalavra;

import java.util.Scanner;

public class UI_AdicionarPalavra
{
    private Controller_AdicionarPalavra contr;

    public UI_AdicionarPalavra()
    {
        contr = new Controller_AdicionarPalavra();
    }

    public void run()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Escreva a palavra em Portugues: ");

        String palavra = sc.nextLine();

        if (contr.pesquisarPalavra(palavra))
        {
            System.out.println("Essa palavra ja existe na BD");
        }
        else
        {
            System.out.println("Palavra nao existe na BD");
        }
    }
}
