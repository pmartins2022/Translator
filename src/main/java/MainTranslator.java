import model.DBConnectionHandlerProj;
import model.Translator;
import view.MenuTranslator;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MainTranslator
{
    public static void main(String[] args)
    {
        Translator tl = new Translator(iniciarConexaoBD());
        MenuTranslator.Iniciar();
    }

    private static DBConnectionHandlerProj iniciarConexaoBD()
    {
        try {
            String jdbcUrl = "jdbc:oracle:thin:@vsrvbd1.dei.isep.ipp.pt:1521/pdborcl";

            String username = "UPSKILL_BD_TURMA2_10";
            String password = "qwerty";

            DBConnectionHandlerProj conexaoBD = new DBConnectionHandlerProj(jdbcUrl, username, password);

            System.out.println("\nEstabelecer a ligação à BD...");
            conexaoBD.openConnection();

            System.out.println("\t... Ligação obtida.");


            return conexaoBD;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
}
