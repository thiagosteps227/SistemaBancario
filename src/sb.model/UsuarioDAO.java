package sb.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;



public class UsuarioDAO {

    public int registerUsuario(Usuario usuario) throws ClassNotFoundException {
        
    	String INSERIR_USUARIO_SQL = "INSERT INTO usuario" +
            "  (nome, tipoPessoa, numDoc, score) VALUES " +
            " (?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/sistema_bancario?useSSL=false", "root", "admin");

            
            PreparedStatement preparedStatement = connection.prepareStatement(INSERIR_USUARIO_SQL)) {
            
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getTipoPessoa());
            preparedStatement.setString(3, usuario.getNumDoc());
            preparedStatement.setString(4, usuario.getScore());
            

            //System.out.println(preparedStatement);pra testar o código
            
            result = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            
            printSQLException(e);
        }
        return result;
    }
    
    
    
    public List < Usuario > selectAllUsers() throws Exception {

        
        List < Usuario > usuario = new ArrayList < > ();
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/sistema_bancario?useSSL=false", "root", "admin");

            
            PreparedStatement preparedStatement = connection.prepareStatement("select * from usuario");) {
        	
            //System.out.println(preparedStatement); pra testar o código
            
            ResultSet rs = preparedStatement.executeQuery();

            
            while (rs.next()) {
                String nome = rs.getString("nome");
                String tipoPessoa = rs.getString("tipoPessoa");
                String numDoc = rs.getString("numDoc");
                String score = rs.getString("score");
                usuario.add(new Usuario(nome, tipoPessoa, numDoc, score));
            }
            
            preparedStatement.close();
            connection.close();
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        
        
        return usuario;
    }
    //tratamento de erros
    private static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
