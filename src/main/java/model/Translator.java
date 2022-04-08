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

            return rs.next();
        }
        catch (SQLException e)
        {
            System.out.println("Problema na base de dados: "+e);
            return false;
        }
    }

    public int getPalavraID(String palavra)
    {
        try
        {
            ResultSet rs = Translator.getInstance().getConexaoBD().pesquisarPalavraID(palavra);

            rs.next();

            return rs.getInt(1);
        }
        catch (SQLException e)
        {
            System.out.println("Problema na base de dados: "+e);
            return -1;
        }
    }

    public ResultSet getLinguagens()
    {
        try
        {
            ResultSet rs = Translator.getInstance().getConexaoBD().getLinguagens();
            return rs;
        }
        catch (SQLException e)
        {
            System.out.println("Problema na base de dados: "+e);
            return null;
        }
    }

    public int countLinguagens()
    {
        try
        {
            ResultSet rs = Translator.getInstance().getConexaoBD().countLinguagens();
            rs.next();
            return rs.getInt(1);
        }
        catch (SQLException e)
        {
            System.out.println("Problema na base de dados: "+e);
            return 0;
        }
    }


    public boolean adicionarPalavraTraduzida(int pid, int lid, String pl)
    {
        try
        {
            Translator.getInstance().getConexaoBD().adicionarPalavraTraduzida(pid, lid, pl);
            return true;
        }
        catch (SQLException e)
        {
            return false;
        }
    }

    public boolean adicionarPalavraPT(String pt)
    {
        try
        {
            Translator.getInstance().getConexaoBD().adicionarPalavraPT(pt);
            return true;
        }
        catch (SQLException e)
        {
            System.out.println("ERRO: "+e.getMessage());
            return false;
        }
    }
    public String mostrarPalavras () throws SQLException
    {
        ResultSet r = conexaoBD.mostrarPalavras ();
        r.next();
        return r.getString (3);
    }

    public int contarPalavras () throws SQLException
    {
        ResultSet r = conexaoBD.contarPalavras ();
        r.next();
        return r.getInt (1);
    }
}
