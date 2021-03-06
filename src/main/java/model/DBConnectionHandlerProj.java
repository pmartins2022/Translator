package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.pool.OracleDataSource;

public class DBConnectionHandlerProj
{

    private String jdbcUrl;
    private String username;
    private String password;

    private Connection connection;
    private PreparedStatement prepStmt;
    private Statement stmt;
    private ResultSet rSet;

    public DBConnectionHandlerProj(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;

        connection = null;
        prepStmt = null;
        rSet = null;
        stmt = null;
    }

    public void openConnection() throws SQLException {
        OracleDataSource ds = new OracleDataSource();
        ds.setURL(jdbcUrl);
        connection = ds.getConnection(username, password);
    }

    public String closeAll() {

        StringBuilder message = new StringBuilder("");

        if (rSet != null) {
            try {
                rSet.close();
            } catch (SQLException ex) {
                message.append(ex.getMessage());
                message.append("\n");
            }
            rSet = null;
        }

        if (prepStmt != null) {
            try {
                prepStmt.close();
            } catch (SQLException ex) {
                message.append(ex.getMessage());
                message.append("\n");
            }
            prepStmt = null;
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                message.append(ex.getMessage());
                message.append("\n");
            }
            stmt = null;
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                message.append(ex.getMessage());
                message.append("\n");
            }
            connection = null;
        }
        return message.toString();
    }

    public ResultSet pesquisarPalavra(String pl) throws SQLException
    {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM PALAVRA WHERE DENOMINACAO = ?");
        ps.setString(1,pl);
        return ps.executeQuery();
    }

    public ResultSet pesquisarPalavraID(String pl) throws SQLException
    {
        PreparedStatement ps = connection.prepareStatement("SELECT ID_PALAVRA FROM PALAVRA WHERE DENOMINACAO = ?");
        ps.setString(1,pl);
        return ps.executeQuery();
    }

    public ResultSet getLinguagens() throws SQLException
    {
        Statement s = connection.createStatement();
        return s.executeQuery("SELECT * FROM LINGUA");
    }

    public ResultSet countLinguagens() throws SQLException
    {
        Statement s = connection.createStatement();
        return s.executeQuery("SELECT COUNT(ID) FROM LINGUA");
    }

    public ResultSet adicionarPalavraTraduzida(int palavraID, int lingID, String palavra) throws SQLException
    {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO TRADUCAO VALUES (?,?,?)");
        ps.setInt(1,lingID);
        ps.setInt(2,palavraID);
        ps.setString(3,palavra);

        return ps.executeQuery();
    }

    public ResultSet adicionarPalavraPT(String s) throws SQLException
    {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO PALAVRA (DENOMINACAO, LINGUA) VALUES (?,1)");
        ps.setString(1,s);
        return ps.executeQuery();
    }

    public ResultSet pesquisarLingua(Idioma idioma) throws SQLException
    {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM LINGUA WHERE DENOMINACAO = '?'");
        ps.setString(1, idioma.toString());
        return ps.executeQuery();
    }

    public ResultSet adicionarLingua(Idioma idioma) throws SQLException
    {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO LINGUA '?'");
        ps.setString(1, idioma.toString());
        return ps.executeQuery();
    }

    public ResultSet contarPalavras () throws SQLException
    {
        PreparedStatement ps = connection.prepareStatement("SELECT count(id_palavra) from palavra");
        return ps.executeQuery();
    }

    public ResultSet mostrarPalavras () throws SQLException
    {
        PreparedStatement ps = connection.prepareStatement("SELECT * from traducao");
        return ps.executeQuery();
    }
}