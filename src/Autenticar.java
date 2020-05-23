import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Autenticar extends Conexao{

	public Autenticar(){}
	//Metodo para verificar se existe ou nao o funcionario
	public void verificar(String user, String pass) throws SQLException{
		
		String entrada, tabela;
		PreparedStatement stmt;
		ResultSet rs;
		
		Conexao conn = new Conexao();
		Manipulacao mp = new Manipulacao();
		Menus menu = new Menus();
		Connection connection = conn.getConexaoMySQL();
			
		String sql = "SELECT * FROM funcionarios WHERE usuario = '"+user+
				      "' AND senha = '"+ pass +"';";
			
		stmt = connection.prepareStatement(sql);
		rs = stmt.executeQuery();
			
		if(rs.next()){//Verifica se existe funcionario
				
			if((rs.getString("usuario").equals(user)) && (rs.getString("senha").equals(pass))){//Compara qual funcionario esta logando
					
				JOptionPane.showMessageDialog(null, "BEM-VIDA A SIMULAÇÃO");
				
				if(user.equals("admin") && pass.equals(pass)){//Compara se o funcionario logado é o admin
					
					entrada = JOptionPane.showInputDialog("Tabela que deseja manipular: ");
					tabela = entrada;
					//Verifica se a tabela existe
					if(!tabela.equals("funcionarios") && !tabela.equals("clientes") && !tabela.equals("estoque")){
						
						JOptionPane.showMessageDialog(null, "TABELA NAO EXISTE");
						System.exit(0);
						
					}else{
						
						switch(menu.menuPrincipal()){
						
							case 1:
								mp.Imprimir(tabela);
								mp.Inserir(tabela);
								mp.Imprimir(tabela);
								break;
							
							case 2:
								mp.Imprimir(tabela);
								mp.Alterar(tabela);
								mp.Imprimir(tabela);
								break;
								
							case 3:
								mp.Imprimir(tabela);
								mp.Excluir(tabela);
								mp.Imprimir(tabela);
								break;
								
							case 4:
								mp.Imprimir(tabela);
								mp.Consultar(tabela);
								break;
						}
					}
					
				}else{//Funcionarios nao administrativos
					
					entrada = JOptionPane.showInputDialog("Tabela que deseja manipular: ");
					tabela = entrada;
					
					if(!tabela.equals("funcionarios") && !tabela.equals("clientes") && !tabela.equals("estoque")){
						
						JOptionPane.showMessageDialog(null, "TABELA NAO EXISTE");
						System.exit(0);
						
					}else if(tabela.equals("funcionarios")){//Nao permite o acesso
						
						JOptionPane.showMessageDialog(null, "VOCE NAO TEM PERMISSAO ADMINISTRADOR");
						System.exit(0);
						
					}else{
						
						switch(menu.menuPrincipal()){
						
							case 1:
								mp.Imprimir(tabela);
								mp.Inserir(tabela);
								mp.Imprimir(tabela);
								break;
							
							case 2:
								mp.Imprimir(tabela);
								mp.Alterar(tabela);
								mp.Imprimir(tabela);
								break;
								
							case 3:
								mp.Imprimir(tabela);
								mp.Excluir(tabela);
								mp.Imprimir(tabela);
								break;
							
							case 4:
								mp.Imprimir(tabela);
								mp.Consultar(tabela);
								break;
								
							default:
								
								JOptionPane.showMessageDialog(null, "VOCE ESCOLHEU OPCAO INCORRETA, TENTE DE NOVO");
								menu.menuPrincipal();
								System.exit(0);
								break;
								
								
						}
					}
					
				}
					
			}
			
		}else{//Funcionario nao existe
			
			JOptionPane.showMessageDialog(null, "Não existe esse funcionario");
			System.exit(0);
			
		}
		
	}
	
}
