import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.*;

public class main {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		
		String usuario, senha;//Variaveis string para login e senha
		JLabel label, label1;//Variaveis para o label
		
		Funcionarios funcionario = new Funcionarios();//Instancia da classe Funcionarios
		Autenticar autenticar = new Autenticar();//Instancia da classe Autenticar
		Tabelas tb = new Tabelas();//Instancia da classe tabelas
		JTextField jtf = new JTextField();//Instancia da classe JTextField
		JPasswordField jpf = new JPasswordField();//Instancia da classe JPasswordField
		
		label1 = new JLabel("Digite o usuario:");
		label = new JLabel("Digite a senha:");
		
		JOptionPane.showConfirmDialog(null,new Object[]{label1, jtf}, 
				"Usuario",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);//Lugar onde o usuario digita o seu usuario
		JOptionPane.showConfirmDialog(null,new Object[]{label, jpf}, 
				"Senha",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);//Lugar onde o usuario digita o sua senha
		
		usuario = new String(jtf.getText());//variavel par armazena o usuario digitado
		senha = new String(jpf.getPassword());//variavel par armazena o senha digitado
		
		funcionario.setUsuario(usuario);//metodo set para pegar o conteudo do usuario
		funcionario.setSenha(senha);//metodo set para pegar o conteudo da senha
		
		autenticar.verificar(funcionario.getUsuario(),//chamando o metodo verificar para saber se o funcionario esta no banco
				    funcionario.getSenha());
		
		System.exit(0);//matar o processo JOptionPane
		
	}
}
