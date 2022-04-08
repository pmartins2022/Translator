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
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM PALAVRA WHERE DENOMINACAO = '?'");
        ps.setString(0,pl);
        return ps.executeQuery();
    }

    public ResultSet adicionarPalavra() throws SQLException
    {
        return null;
    }

	public ResultSet getChefeProjetosNum() throws SQLException
    {
        Statement s = connection.createStatement();
        return s.executeQuery("SELECT idChefe, COUNT(codProjeto) FROM Projeto GROUP BY (idChefe)");
    }

    public ResultSet getChefeProjetosNum(int chefe) throws SQLException
    {
        Statement s = connection.createStatement();
        return s.executeQuery("SELECT idChefe, COUNT(codProjeto) FROM Projeto GROUP BY (idChefe) HAVING idChefe="+chefe);
    }

    public ResultSet getTotalHorasProjeto() throws SQLException
    {
        PreparedStatement ps = connection.prepareStatement("SELECT projetoEmpregado.codProjeto, SUM(projetoEmpregado.nHoras) FROM projetoEmpregado GROUP BY projetoEmpregado.codProjeto");
        return ps.executeQuery();
    }

    public ResultSet getTotalHorasProjeto(int p) throws SQLException
    {
        PreparedStatement ps = connection.prepareStatement("SELECT projetoEmpregado.codProjeto, SUM(projetoEmpregado.nHoras) FROM projetoEmpregado WHERE projetoEmpregado.codProjeto = ? GROUP BY projetoEmpregado.codProjeto");
        ps.setInt(1,p);
        return ps.executeQuery();
    }

    public ResultSet getProjInfoHorasPagar() throws SQLException
    {
        Statement s = connection.createStatement();
        return s.executeQuery("SELECT p1.codProjeto, (SELECT p2.id FROM projetoEmpregado p2 WHERE p2.nHoras = (SELECT MAX(p3.nHoras) FROM projetoEmpregado p3 WHERE p3.codProjeto = p1.codProjeto)), (SELECT p2.id FROM projetoEmpregado p2 WHERE p2.nHoras = (SELECT MIN(p3.nHoras) FROM projetoEmpregado p3 WHERE p3.codProjeto = p1.codProjeto)), MAX((SELECT empregado.salarioHora FROM empregado WHERE empregado.id = p1.id)*p1.nHoras), MIN((SELECT empregado.salarioHora FROM empregado WHERE empregado.id = p1.id)*p1.nHoras) FROM projetoEmpregado p1 GROUP BY p1.codProjeto");
    }
    public ResultSet pesquisarLingua(Idioma idioma) throws SQLException
    {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM LINGUA WHERE DENOMINACAO = '?'");
        ps.setString(0, idioma.getNome());
        return ps.executeQuery();
    }

    public ResultSet adicionarLingua(Idioma idioma) throws SQLException
    {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO LINGUA '?'");
        ps.setString(0, idioma.getNome());
        return ps.executeQuery();
    }
}