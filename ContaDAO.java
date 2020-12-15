package sb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class ContaDAO {
	
	public int registerConta(Conta conta) throws ClassNotFoundException {
        String INSERIR_CONTA_SQL = "INSERT INTO conta" +
            "  (numero, agencia, tipoConta, limite, cartao, nomeTitular) VALUES " +
            " (?, ?, ?, ?,?,?);";

        int resultConta = 0;
        //estabelecendo a conexão
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/sistema_bancario?useSSL=false", "root", "admin");

            
            PreparedStatement preparedStatement = connection.prepareStatement(INSERIR_CONTA_SQL)) {
            
            preparedStatement.setString(1, conta.getNumero());
            preparedStatement.setString(2, conta.getAgencia());
            preparedStatement.setString(3, conta.getTipoConta());
            preparedStatement.setString(4, conta.getLimite());
            preparedStatement.setString(5, conta.getCartao());
            preparedStatement.setString(6, conta.getNomeTitular());
            

            //System.out.println(preparedStatement); pra testar o código
            
            resultConta = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            
            printSQLException(e);
        }
        return resultConta;
    }
	
	public List < Conta > selectAllContas() throws Exception {

        List < Conta > conta = new ArrayList < > ();
        // estabelecendo a conexão
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/sistema_bancario?useSSL=false", "root", "admin");

            
            PreparedStatement preparedStatement = connection.prepareStatement("select * from conta");) {
        	
            //System.out.println(preparedStatement); pra testar o código
            
            ResultSet rs = preparedStatement.executeQuery();

            // processando o ResultSet.
            while (rs.next()) {
                String numero = rs.getString("numero");
                String agencia = rs.getString("agencia");
                String tipoConta = rs.getString("tipoConta");
                String limite = rs.getString("limite");
                String cartao = rs.getString("cartao");
                String nomeTitular = rs.getString("nomeTitular");
                conta.add(new Conta(numero, agencia, tipoConta, limite, cartao, nomeTitular));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return conta;
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
