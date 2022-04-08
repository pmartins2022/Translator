package view;

import controller.Controller_AdicionarPalavra;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UI_AdicionarPalavra
{
    private final Controller_AdicionarPalavra contr;

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



            if (contr.countLinguagens() == 1)
            {
                System.out.println("Nao existem mais linguagens para traduzir.");
            }
            else
            {
                try
                {
                    int palavraID = contr.pesquisarPalavraID(palavra);

                    ResultSet rs = contr.getLinguagens();

                    while (rs.next())
                    {
                        int lingID = rs.getInt(0);
                        System.out.println("Escrever traducao para linguagem " + rs.getString(1));
                        String trad = sc.nextLine();

                        if (contr.adicionarPalavraTraduzida(palavraID,lingID,trad))
                        {
                            System.out.println("Traducao adicionada com sucesso.");
                        }
                        else
                        {
                            System.out.println("Problema a adicionar traducao");
                        }
                    }
                }
                catch (SQLException e)
                {
                    System.out.println("Problema na base de dados: "+e);
                }
            }
        }
    }
}