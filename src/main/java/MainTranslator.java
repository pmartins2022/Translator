import java.sql.SQLException;

public class MainTranslator
{
    public static void main(String[] args)
    {
        iniciarConexaoBD();
    }

    private static void iniciarConexaoBD()
    {
        DBConnectionHandlerProj dbConnHandler = null;

        try {
            String jdbcUrl = "jdbc:oracle:thin:@vsrvbd1.dei.isep.ipp.pt:1521/pdborcl";

            String username = "UPSKILL_BD_TURMA2_10";
            String password = "qwerty";

            dbConnHandler = new DBConnectionHandlerProj(jdbcUrl, username, password);

            System.out.println("\nEstabelecer a ligação à BD...");
            dbConnHandler.openConnection();

            System.out.println("\t... Ligação obtida.");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            String mensagem = dbConnHandler.closeAll();
            if (!mensagem.isEmpty())
                System.out.println(mensagem);
            System.out.println("\nTerminada a ligação à BD.");
            dbConnHandler.closeAll();
        }
    }
}
