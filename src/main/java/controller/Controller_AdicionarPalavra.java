package controller;

import model.MainTranslator;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller_AdicionarPalavra
{
    public boolean pesquisarPalavraBD(String palavra)
    {
        try
        {
            ResultSet rs = MainTranslator.conexaoBD.pesquisarPalavra(palavra);

            int number = 0;
            while(rs.next())
            {
                number++;
            }

            return number == 1;
        }
        catch (SQLException e)
        {
            System.out.println("Problema na base de dados: "+e);
            return false;
        }
    }
}
