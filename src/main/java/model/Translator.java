package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Translator
{
    public static Translator instance = null;

    private DBConnectionHandlerProj conexaoBD;

    public Translator(DBConnectionHandlerProj conexaoBD)
    {
        if (instance == null)
        {
            instance = this;
        }else return;

        this.conexaoBD = conexaoBD;
    }

    public Idioma criarIdioma (String nome){
        Idioma idioma = new Idioma(nome);
        return idioma;
    }

    public boolean validaIdioma (Idioma idioma){
        boolean flag = false;
        try
        {
            ResultSet rs = Translator.getInstance().getConexaoBD().pesquisarLingua(idioma.getIdioma());

            flag = true;
        }
        catch (SQLException e)
        {
            System.out.println("Problema na base de dados: "+e);
            flag = false;
        }

        return flag;
    }

    public boolean guardaIdioma (Idioma idioma){
        boolean flag = false;
        if(validaIdioma(idioma)){


        }

        return flag;
    }

    public static Translator getInstance()
    {
        return instance;
    }

    public DBConnectionHandlerProj getConexaoBD()
    {
        return conexaoBD;
    }

    public void closeDBConnection()
    {
        String mensagem = conexaoBD.closeAll();
        if (!mensagem.isEmpty())
            System.out.println(mensagem);
        System.out.println("\nTerminada a ligação à BD.");
        conexaoBD.closeAll();
    }

    public boolean pesquisarPalavraBD(String palavra)
    {
        try
        {
            ResultSet rs = Translator.getInstance().getConexaoBD().pesquisarPalavra(palavra);

            return true;
        }
        catch (SQLException e)
        {
            System.out.println("Problema na base de dados: "+e);
            return false;
        }
    }

    public String mostrarPalavras () throws SQLException
    {
        return conexaoBD.mostrarPalavras ().getString (3);
    }

    public int contarPalavras () throws SQLException
    {
        return conexaoBD.contarPalavras ().getInt (0);
    }
}
