package controller;

import model.Translator;

import java.sql.ResultSet;

public class Controller_AdicionarPalavra
{
    public boolean pesquisarPalavra(String s)
    {
        return Translator.getInstance().pesquisarPalavraBD(s);
    }

    public int pesquisarPalavraID(String s)
    {
        return Translator.getInstance().getPalavraID(s);
    }

    public boolean adicionarPalavraPT(String s)
    {
        return Translator.getInstance().adicionarPalavraPT(s);
    }

    public ResultSet getLinguagens()
    {
        return Translator.getInstance().getLinguagens();
    }

    public int countLinguagens()
    {
        return Translator.getInstance().countLinguagens();
    }

    public boolean adicionarPalavraTraduzida(int palavraID, int lingID, String palavra)
    {
        return Translator.getInstance().adicionarPalavraTraduzida(palavraID,lingID,palavra);
    }
}
