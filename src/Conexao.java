import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexao {

	public static String status = "Não conectou...";
	
	public Conexao(){}
	//Metodo que conecta com o banco
	public static java.sql.Connection getConexaoMySQL() {
		 
        Connection connection = null;
        
        try {
        	 
        	// Carregando o JDBC Driver padrão
        	String driverName = "com.mysql.jdbc.Driver";                        
        	Class.forName(driverName);
        	
        	String serverName = "localhost";    //caminho do servidor do BD
            String mydatabase = "bancodedados";        //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root";        //nome de um usuário de seu BD      
            String password = "";      //sua senha de acesso
     
            connection = DriverManager.getConnection(url, username, password);
           
            if (connection != null) {
            	 
                status = ("STATUS--->Conectado com sucesso!");
                
                
            } else {
     
                status = ("STATUS--->Não foi possivel realizar conexão");
     
            }
  
            return connection;
        }
        catch (ClassNotFoundException e) {  //Driver não encontrado
        	 
        	JOptionPane.showMessageDialog(null, "O driver expecificado nao foi encontrado.");
 
            return null;
 
        } catch (SQLException e) {
 
        		//Não conseguindo se conectar ao banco
        	JOptionPane.showMessageDialog(null, "Nao foi possivel conectar ao Banco de Dados.");
 
            return null;
 
        }
    }
	//Mostra o status da conexao com o banco
	public static String statusConection() {
		 
        return status;
 
    }
	
   //Método que fecha sua conexão//
    public static boolean FecharConexao() {
 
        try {
 
            Conexao.getConexaoMySQL().close();
 
            return true;
 
        } catch (SQLException e) {
 
            return false;
 
        }
 
    }
 
   //Método que reinicia sua conexão//
    public static java.sql.Connection ReiniciarConexao() {
 
        FecharConexao();
 
        return Conexao.getConexaoMySQL();
 
    }
}
