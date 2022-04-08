package Controller;

import model.Translator;

public class Controller_AdicionarPalavra
{
    public boolean pesquisarPalavra(String s)
    {
        return Translator.getInstance().pesquisarPalavraBD(s);
    }
}
