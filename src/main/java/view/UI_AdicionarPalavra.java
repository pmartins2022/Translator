package view;

import Controller.Controller_AdicionarPalavra;

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

            if (contr.adicionarPalavraPT(palavra))
            {
                System.out.println("Palavra adicionada na BD");
            }
            else
            {
                System.out.println("Problema a adicionar a palavra na BD");
                return;
            }


            int linguagens = contr.countLinguagens();

            if (linguagens == 1)
            {
                System.out.println("Nao existem mais linguagens para traduzir.");
                return;
            }
            else
            {
                System.out.println("Total linguagens: "+linguagens);
                try
                {
                    int palavraID = contr.pesquisarPalavraID(palavra);

                    if (palavraID < 0)
                    {
                        System.out.println("Nao encontrou palavra na tabela");
                        return;
                    }

                    ResultSet rs = contr.getLinguagens();

                    //passar pelo PT
                    rs.next();

                    while (rs.next())
                    {
                        int lingID = rs.getInt(1);
                        System.out.println("Escrever traducao para linguagem " + rs.getString(2));
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