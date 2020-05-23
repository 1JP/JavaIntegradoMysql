import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Manipulacao {
	//Todas as variaveis estao privadas onde so a classe tem acesso a elas
	private String sql = "", nome, apelido, cpf, sexo, dataNascimento, estado, email, cidade, telefone,
			   celular, usuario, senha, nomeProduto, nomeFornecedor, entrada;
	private int cep; 
	private float preco;
		
	public Manipulacao(){}
	//Metodo de Manipulacao de Impressao dos bancos
	public void Imprimir(String tabela) throws SQLException{
		
		ResultSet rs;
		PreparedStatement stmt;
		Connection connection;
		String sql;
		
		Conexao conn = new Conexao();
		JTextArea saida = new JTextArea(10, 40); // HEIGHT X WIDTH
        JScrollPane scroll = new JScrollPane(saida);
        
		connection = conn.getConexaoMySQL();
		sql = "SELECT * FROM "+ tabela + ";";	
		stmt = connection.prepareStatement(sql);
		rs = stmt.executeQuery();
		ResultSetMetaData col = rs.getMetaData();
		
		while(rs.next()){
			
			for(int i = 1; i < col.getColumnCount()+1; i++){
			
				saida.append("| " + col.getColumnName(i) +": ");
				saida.append(rs.getString(col.getColumnName(i)));
				
			}
			
			saida.append("\n");
		}
		
		JOptionPane.showMessageDialog(null, scroll, "Tabela " + tabela,
        		JOptionPane.INFORMATION_MESSAGE);
		
	}
	//Metodo de Manipulacao de Insercao dos bancos
	public void Inserir(String tabela) throws SQLException{
		
		String consulta;
		Statement stmt;
		ResultSet rs;
		
		Conexao conn = new Conexao();
		Tabelas tb = new Tabelas();
		Connection connection = conn.getConexaoMySQL();
		
		switch(tabela){
			
			case "funcionarios":
				
				entrada = JOptionPane.showInputDialog("Nome: ");
				nome = entrada;
				entrada = JOptionPane.showInputDialog("Apelido: ");
				apelido = entrada;
				entrada = JOptionPane.showInputDialog("Cpf: ");
				cpf = entrada;
				entrada = JOptionPane.showInputDialog("Sexo: ");
				sexo = entrada;
				entrada = JOptionPane.showInputDialog("Data de Nascimento: ");
				dataNascimento = entrada;
				entrada = JOptionPane.showInputDialog("Estado: ");
				estado = entrada;
				entrada = JOptionPane.showInputDialog("Email: ");
				email = entrada;
				entrada = JOptionPane.showInputDialog("Cidade: ");
				cidade = entrada;
				entrada = JOptionPane.showInputDialog("CEP: ");
				cep = Integer.parseInt(entrada);
				entrada = JOptionPane.showInputDialog("Telefone: ");
				telefone = entrada;
				entrada = JOptionPane.showInputDialog("Celular: ");
				celular = entrada;
				entrada = JOptionPane.showInputDialog("Usuario: ");
				usuario = entrada;
				entrada = JOptionPane.showInputDialog("Senha: ");
				senha = entrada;
				
				tb.setNome(nome);
				tb.setApelido(apelido);
				tb.setCpf(cpf);
				tb.setSexo(sexo);
				tb.setDataNascimento(dataNascimento);
				tb.setEstado(estado);
				tb.setEmail(email);
				tb.setCidade(cidade);
				tb.setCep(cep);
				tb.setTelefone(telefone);
				tb.setCelular(celular);
				
				consulta = "SELECT * FROM funcionarios WHERE usuario = '"+ usuario + "';";
				stmt = connection.prepareStatement(consulta);
				rs = stmt.executeQuery(consulta);
				
				if(rs.next()){
					
					JOptionPane.showMessageDialog(null, "Login ja existe!");
					System.exit(0);
					
				}else{
					
					tb.setUsuario(usuario);
					
				}
				
				tb.setSenha(senha);
				
				sql = "INSERT INTO funcionarios (nome, apelido, cpf, sexo, dataNascimento, "
						 							+ "estado, email, cidade, cep, telefone, celular, "
						 							+ "usuario, senha) VALUES ('" +tb.getNome() + "', '"
						 							+ tb.getApelido() + "','" + tb.getCpf() + "','"
						 							+ tb.getSexo() + "','" + tb.getDataNascimento() + "', '"
						 							+ tb.getEstado() + "','" + tb.getEmail() +"','"
						 							+ tb.getCidade() + "'," + tb.getCep() + ",'"
						 							+ tb.getTelefone() + "','" + tb.getCelular() + "','"
						 							+ tb.getUsuario() + "','" + tb.getSenha() + "');";
				try{
					
					stmt = connection.createStatement();
					stmt.execute(sql);
					JOptionPane.showMessageDialog(null, "Funcionario cadastrado");
	                stmt.close();
	                
				}catch (SQLException u) { 
					
					JOptionPane.showMessageDialog(null, "Funcionario não cadastrado");
                    throw new RuntimeException(u);      
                }   
				break;
				
			case "clientes":
				
				entrada = JOptionPane.showInputDialog("Nome: ");
				nome = entrada;
				entrada = JOptionPane.showInputDialog("Apelido: ");
				apelido = entrada;
				entrada = JOptionPane.showInputDialog("Cpf: ");
				cpf = entrada;
				entrada = JOptionPane.showInputDialog("Sexo: ");
				sexo = entrada;
				entrada = JOptionPane.showInputDialog("Data de Nascimento: ");
				dataNascimento = entrada;
				entrada = JOptionPane.showInputDialog("Estado: ");
				estado = entrada;
				entrada = JOptionPane.showInputDialog("Email: ");
				email = entrada;
				entrada = JOptionPane.showInputDialog("Cidade: ");
				cidade = entrada;
				entrada = JOptionPane.showInputDialog("CEP: ");
				cep = Integer.parseInt(entrada);
				entrada = JOptionPane.showInputDialog("Telefone: ");
				telefone = entrada;
				entrada = JOptionPane.showInputDialog("Celular: ");
				celular = entrada;
				
				consulta = "SELECT * FROM funcionarios WHERE usuario = '"+ nome + "';";
				stmt = connection.prepareStatement(consulta);
				rs = stmt.executeQuery(consulta);
				
				if(rs.next()){
					
					JOptionPane.showMessageDialog(null, "Ja existe o cadastro do cliente!");
					System.exit(0);
					
				}else{
					
					tb.setUsuario(nome);
					
				}
				tb.setApelido(apelido);
				tb.setCpf(cpf);
				tb.setSexo(sexo);
				tb.setDataNascimento(dataNascimento);
				tb.setEstado(estado);
				tb.setEmail(email);
				tb.setCidade(cidade);
				tb.setCep(cep);
				tb.setTelefone(telefone);
				tb.setCelular(celular);
				sql = "INSERT INTO clientes (nome, apelido, cpf, sexo, dataNascimento, "
													+ "estado, email, cidade, cep, telefone, celular, "
													+ "usuario, senha) VALUES ('" +tb.getNome() + "', '"
													+ tb.getApelido() + "','" + tb.getCpf() + "','"
													+ tb.getSexo() + "','" + tb.getDataNascimento() + "', '"
													+ tb.getEstado() + "','" + tb.getEmail() +"','"
													+ tb.getCidade() + "'," + tb.getCep() + ",'"
													+ tb.getTelefone() + "','" + tb.getCelular()+ "');";
				try{
					
					stmt = connection.createStatement();
					stmt.execute(sql);  
					JOptionPane.showMessageDialog(null, "Cliente cadastrado");
	                stmt.close();
	                
				}catch (SQLException u) {
					
					JOptionPane.showMessageDialog(null, "Cliente não cadastrado");
                    throw new RuntimeException(u);      
                } 
                
				break;
				
			case "estoque":
				
				entrada = JOptionPane.showInputDialog("Produto: ");
				nomeProduto = entrada;
				entrada = JOptionPane.showInputDialog("Fornecedor: ");
				nomeFornecedor = entrada;
				entrada = JOptionPane.showInputDialog("Preco: ");
				preco = Float.parseFloat(entrada);
				
				tb.setNomeProduto(nomeProduto);
				tb.setNomeFornecedor(nomeFornecedor);
				tb.setPreco(preco);
				
				sql = "INSERT INTO estoque (nomeProduto, nomeFornecedores, preco) VALUES ('" +tb.getNomeProduto() + "', '"
																						  + tb.getNomeFornecedor() + "'," + tb.getPreco()+ ");";
				
				try{
					
					stmt = connection.createStatement();
					stmt.execute(sql);
					JOptionPane.showMessageDialog(null, "Produto registrado no estoque");
	                stmt.close();
	                
				}catch (SQLException u) {
					
					JOptionPane.showMessageDialog(null, "Produto não cadastrado");
                    throw new RuntimeException(u);      
                }
                
				break;
				
		}
		
	}
	//Metodo de Manipulacao de Exclucao dos bancos
	public void Excluir(String tabela) throws SQLException{
		
		String consulta;
		Statement stmt;
		ResultSet rs;
		int delet, id;
		
		Conexao conn = new Conexao();
		Tabelas tb = new Tabelas();
		Connection connection = conn.getConexaoMySQL();
		
		tb.setTabela(tabela);
		
		switch(tb.getTabela()){
		
			case "funcionarios":
				
				entrada = JOptionPane.showInputDialog("Usuario: ");
				usuario = entrada;
				tb.setUsuario(usuario);
				
				sql = "DELETE FROM funcionarios WHERE usuario = '"+ tb.getUsuario() +"';";
				stmt = connection.createStatement();
				delet = stmt.executeUpdate(sql);
				
				consulta = "SELECT * FROM funcionarios WHERE usuario = '"+ tb.getUsuario() +"';";
				stmt = connection.createStatement();
				rs = stmt.executeQuery(consulta);
				
				if(rs.next()){
					
					JOptionPane.showMessageDialog(null, "Login removido!");
					System.exit(0);
					
				}else{
					
					JOptionPane.showMessageDialog(null, "Login ainda cadastrado!");
					System.exit(0);
					
				}
				
				break;
			
			case "clientes":
				
				entrada = JOptionPane.showInputDialog("ID: ");
				id = Integer.parseInt(entrada);
				
				sql = "DELETE FROM clientes WHERE id = "+ id +";";
				stmt = connection.createStatement();
				delet = stmt.executeUpdate(sql);
				
				consulta = "SELECT * FROM clientes WHERE id = "+ id +";";
				stmt = connection.createStatement();
				rs = stmt.executeQuery(consulta);
				
				if(rs.next()){
					
					JOptionPane.showMessageDialog(null, "Cliente removido!");
					System.exit(0);
					
				}else{
					
					JOptionPane.showMessageDialog(null, "Cliente ainda cadastrado!");
					System.exit(0);
					
				}
				
				break;
		
			case "estoque":
				
				entrada = JOptionPane.showInputDialog("ID: ");
				id = Integer.parseInt(entrada);
				
				sql = "DELETE FROM estoque WHERE id = "+ id +";";
				stmt = connection.createStatement();
				delet = stmt.executeUpdate(sql);
				
				consulta = "SELECT * FROM clientes WHERE id = "+ id +";";
				stmt = connection.createStatement();
				rs = stmt.executeQuery(consulta);
				
				if(rs.next()){
					
					JOptionPane.showMessageDialog(null, "Produto removido!");
					System.exit(0);
					
				}else{
					
					JOptionPane.showMessageDialog(null, "Produto ainda cadastrado!");
					System.exit(0);
					
				}
				
				break;
		}
	}
	//Metodo de Manipulacao de Aleracao dos bancos
	public void Alterar(String tabela) throws SQLException{
		
		String consulta;
		Statement stmt;
		ResultSet rs;
		int id, alter;
		
		Conexao conn = new Conexao();
		Tabelas tb = new Tabelas();
		Menus menu = new Menus();
		
		Connection connection = conn.getConexaoMySQL();
		tb.setTabela(tabela);
		
		switch(tb.getTabela()){
			
			case "funcionarios":
				
				while(menu.MenuFuncionarios() <= 13){
					
					switch(menu.MenuFuncionarios()){
				
						case 1:
						
							entrada = JOptionPane.showInputDialog("Novo Nome do funcionario: ");
							nome = entrada;
							entrada = JOptionPane.showInputDialog("Usuario do funcionario: ");
							usuario = entrada;
						
							tb.setNome(nome);
							tb.setUsuario(usuario);
						
							stmt = connection.createStatement();
							sql = "UPDATE funcionarios SET nome = '"+ tb.getNome()
									+ "' WHERE usuario = '"+tb.getUsuario()+"';";
							alter = stmt.executeUpdate(sql);
						
							consulta = "SELECT * FROM funcionarios WHERE nome = '"+ tb.getNome() +"';";
							stmt = connection.createStatement();
							rs = stmt.executeQuery(consulta);
						
							if(rs.next()){
							
								JOptionPane.showMessageDialog(null, "Nome Alterado com sucesso!");
								System.exit(0);
							
							}else{
							
								JOptionPane.showMessageDialog(null, "Nome ainda é o mesmo!");
								System.exit(0);
							
							}
						
							break;
						
						case 2:
						
							entrada = JOptionPane.showInputDialog("Novo apelido do funcionario: ");
							apelido = entrada;
							entrada = JOptionPane.showInputDialog("Usuario do funcionario: ");
							usuario = entrada;
						
							tb.setApelido(apelido);
							tb.setUsuario(usuario);
						
							stmt = connection.createStatement();
							sql = "UPDATE funcionarios SET apelido = '"+ tb.getApelido()
									+ "' WHERE usuario = '"+tb.getUsuario()+"';";
							alter = stmt.executeUpdate(sql);
						
							consulta = "SELECT * FROM funcionarios WHERE apelido = '"+ tb.getApelido() +"';";
							stmt = connection.createStatement();
							rs = stmt.executeQuery(consulta);
						
							if(rs.next()){
							
								JOptionPane.showMessageDialog(null, "Apelido Alterado com sucesso!");
								System.exit(0);
							
							}else{
							
								JOptionPane.showMessageDialog(null, "Apelido ainda o mesmo!");
								System.exit(0);
							
							}
						
							break;
					
							case 3:
						
								entrada = JOptionPane.showInputDialog("Novo CPF do funcionario: ");
								cpf = entrada;
								entrada = JOptionPane.showInputDialog("Usuario do funcionario: ");
								usuario = entrada;
						
								tb.setCpf(cpf);
								tb.setUsuario(usuario);
						
								stmt = connection.createStatement();
								sql = "UPDATE funcionarios SET cpf = '"+ tb.getCpf()
										+ "' WHERE usuario = '"+tb.getUsuario()+"';";
								alter = stmt.executeUpdate(sql);
						
								consulta = "SELECT * FROM funcionarios WHERE cpf = '"+ tb.getCpf() +"';";
								stmt = connection.createStatement();
								rs = stmt.executeQuery(consulta);
						
								if(rs.next()){
							
									JOptionPane.showMessageDialog(null, "CPF Alterado com sucesso!");
									System.exit(0);
							
								}else{
							
									JOptionPane.showMessageDialog(null, "CPF ainda o mesmo!");
									System.exit(0);
							
								}
						
								break;
							case 4:
						
								entrada = JOptionPane.showInputDialog("Novo Sexo do funcionario: ");
								sexo = entrada;
								entrada = JOptionPane.showInputDialog("Usuario do funcionario: ");
								usuario = entrada;
							
								tb.setSexo(sexo);
								tb.setUsuario(usuario);
						
								stmt = connection.createStatement();
								sql = "UPDATE funcionarios SET sexo = '"+ tb.getSexo()
										+ "' WHERE usuario = '"+tb.getUsuario()+"';";
								alter = stmt.executeUpdate(sql);
						
								consulta = "SELECT * FROM funcionarios WHERE sexo = '"+ tb.getSexo() +"';";
								stmt = connection.createStatement();
								rs = stmt.executeQuery(consulta);
						
								if(rs.next()){
							
									JOptionPane.showMessageDialog(null, "Sexo Alterado com sucesso!");
									System.exit(0);
							
								}else{
							
									JOptionPane.showMessageDialog(null, "Sexo ainda o mesmo!");
									System.exit(0);
							
								}
						
								break;
							
							case 5:
						
								entrada = JOptionPane.showInputDialog("Nova Data de nascimento do funcionario: ");
								dataNascimento = entrada;
								entrada = JOptionPane.showInputDialog("Usuario do funcionario: ");
								usuario = entrada;
						
								tb.setDataNascimento(dataNascimento);
								tb.setUsuario(usuario);
						
								stmt = connection.createStatement();
								sql = "UPDATE funcionarios SET dataNascimento = '"+ tb.getDataNascimento()
										+ "' WHERE usuario = '"+tb.getUsuario()+"';";
								alter = stmt.executeUpdate(sql);
						
								consulta = "SELECT * FROM funcionarios WHERE dataNascimento = '"+ tb.getDataNascimento() +"';";
								stmt = connection.createStatement();
								rs = stmt.executeQuery(consulta);
						
								if(rs.next()){
							
									JOptionPane.showMessageDialog(null, "Data de Nascimeto Alterado com sucesso!");
									System.exit(0);
							
								}else{
								
									JOptionPane.showMessageDialog(null, "Data de Nascimento ainda a mesmo!");
									System.exit(0);
							
								}
						
								break;
						
							case 6:
						
								entrada = JOptionPane.showInputDialog("Novo Estado onde funcionario mora: ");
								estado = entrada;
								entrada = JOptionPane.showInputDialog("Usuario do funcionario: ");
								usuario = entrada;
						
								tb.setEstado(estado);
								tb.setUsuario(usuario);
						
								stmt = connection.createStatement();
								sql = "UPDATE funcionarios SET estado = '"+ tb.getEstado()
										+ "' WHERE usuario = '"+tb.getUsuario()+"';";
								alter = stmt.executeUpdate(sql);
						
								consulta = "SELECT * FROM funcionarios WHERE estado = '"+ tb.getEstado() +"';";
								stmt = connection.createStatement();
								rs = stmt.executeQuery(consulta);
							
								if(rs.next()){
							
									JOptionPane.showMessageDialog(null, "Estado Alterado com sucesso!");
									System.exit(0);
							
								}else{
							
									JOptionPane.showMessageDialog(null, "Estado ainda a mesmo!");
									System.exit(0);
							
								}
						
								break;
							
							case 7:
						
								entrada = JOptionPane.showInputDialog("Novo email do funcionario: ");
								email = entrada;
								entrada = JOptionPane.showInputDialog("Usuario do funcionario: ");
								usuario = entrada;
						
								tb.setEmail(email);
								tb.setUsuario(usuario);
								
								stmt = connection.createStatement();
								sql = "UPDATE funcionarios SET email = '"+ tb.getEmail()
										+ "' WHERE usuario = '"+tb.getUsuario()+"';";
								alter = stmt.executeUpdate(sql);
						
								consulta = "SELECT * FROM funcionarios WHERE email = '"+ tb.getEmail() +"';";
								stmt = connection.createStatement();
								rs = stmt.executeQuery(consulta);
						
								if(rs.next()){
							
									JOptionPane.showMessageDialog(null, "Email Alterado com sucesso!");
									System.exit(0);
							
								}else{
							
									JOptionPane.showMessageDialog(null, "Email ainda a mesmo!");
									System.exit(0);
							
								}
						
								break;
					
								case 8:
						
									entrada = JOptionPane.showInputDialog("Nova Cidade do funcionario: ");
									cidade = entrada;
									entrada = JOptionPane.showInputDialog("Usuario do funcionario: ");
									usuario = entrada;
						
									tb.setCidade(cidade);
									tb.setUsuario(usuario);
						
									stmt = connection.createStatement();
									sql = "UPDATE funcionarios SET cidade = '"+ tb.getCidade()
											+ "' WHERE usuario = '"+tb.getUsuario()+"';";
									alter = stmt.executeUpdate(sql);
									
									consulta = "SELECT * FROM funcionarios WHERE cidade = '"+ tb.getCidade() +"';";
									stmt = connection.createStatement();
									rs = stmt.executeQuery(consulta);
						
									if(rs.next()){
							
										JOptionPane.showMessageDialog(null, "Cidade Alterado com sucesso!");
										System.exit(0);
							
									}else{
							
										JOptionPane.showMessageDialog(null, "Cidade ainda a mesmo!");
										System.exit(0);
							
									}
						
									break;
				
								case 9:
						
									entrada = JOptionPane.showInputDialog("Novo CEP do funcionario: ");
									cep = Integer.parseInt(entrada);
									entrada = JOptionPane.showInputDialog("Usuario do funcionario: ");
									usuario = entrada;
						
									tb.setCep(cep);
									tb.setUsuario(usuario);
						
									stmt = connection.createStatement();
									sql = "UPDATE funcionarios SET cep = "+ tb.getCep()
											+ " WHERE usuario = '"+tb.getUsuario()+"';";
									alter = stmt.executeUpdate(sql);
						
									consulta = "SELECT * FROM funcionarios WHERE cep = "+ tb.getCep() +";";
									stmt = connection.createStatement();
									rs = stmt.executeQuery(consulta);
						
									if(rs.next()){
							
										JOptionPane.showMessageDialog(null, "CEP Alterado com sucesso!");
										System.exit(0);
							
									}else{
							
										JOptionPane.showMessageDialog(null, "CEP ainda a mesmo!");
										System.exit(0);
							
									}
						
									break;
						
								case 10:
						
									entrada = JOptionPane.showInputDialog("Novo n° de telefone do funcionario: ");
									telefone = entrada;
									entrada = JOptionPane.showInputDialog("Usuario do funcionario: ");
									usuario = entrada;
						
									tb.setTelefone(telefone);
									tb.setUsuario(usuario);
						
									stmt = connection.createStatement();
									sql = "UPDATE funcionarios SET telefone = '"+ tb.getTelefone()
											+ "' WHERE usuario = '"+tb.getUsuario()+"';";
									alter = stmt.executeUpdate(sql);
						
									consulta = "SELECT * FROM funcionarios WHERE telefone = "+ tb.getTelefone() +";";
									stmt = connection.createStatement();
									rs = stmt.executeQuery(consulta);
						
									if(rs.next()){
							
										JOptionPane.showMessageDialog(null, "N° de Telefone Alterado com sucesso!");
										System.exit(0);
								
									}else{
							
										JOptionPane.showMessageDialog(null, "N° de Telefone ainda a mesmo!");
										System.exit(0);
							
									}
									
									break;
						
								case 11:
						
									entrada = JOptionPane.showInputDialog("Novo n° de celular do funcionario: ");
									celular = entrada;
									entrada = JOptionPane.showInputDialog("Usuario do funcionario: ");
									usuario = entrada;
						
									tb.setCelular(celular);
									tb.setUsuario(usuario);
						
									stmt = connection.createStatement();
									sql = "UPDATE funcionarios SET celular = '"+ tb.getCelular()
											+ "' WHERE usuario = '"+tb.getUsuario()+"';";
									alter = stmt.executeUpdate(sql);
						
									consulta = "SELECT * FROM funcionarios WHERE celular = '"+ tb.getCelular() +"';";
									stmt = connection.createStatement();
									rs = stmt.executeQuery(consulta);
						
									if(rs.next()){
							
										JOptionPane.showMessageDialog(null, "N° de celular Alterado com sucesso!");
										System.exit(0);
							
									}else{
							
										JOptionPane.showMessageDialog(null, "N° de celular ainda a mesmo!");
										System.exit(0);
							
									}
						
									break;
					
								case 12:
						
									entrada = JOptionPane.showInputDialog("Novo usuario do funcionario: ");
									usuario = entrada;
									entrada = JOptionPane.showInputDialog("Usuario do funcionario: ");
									usuario = entrada;
						
									tb.setUsuario(usuario);
									tb.setUsuario(usuario);
						
									stmt = connection.createStatement();
									sql = "UPDATE funcionarios SET cidade = '"+ tb.getUsuario()
											+ "' WHERE usuario = '"+tb.getUsuario()+"';";
									alter = stmt.executeUpdate(sql);
						
									consulta = "SELECT * FROM funcionarios WHERE cidade = '"+ tb.getUsuario() +"';";
									stmt = connection.createStatement();
									rs = stmt.executeQuery(consulta);
						
									if(rs.next()){
							
										JOptionPane.showMessageDialog(null, "Usuario Alterado com sucesso!");
										System.exit(0);
							
									}else{
							
										JOptionPane.showMessageDialog(null, "Usuario ainda é o mesmo!");
										System.exit(0);
							
									}
						
									break;
						
								case 13:
						
									entrada = JOptionPane.showInputDialog("Nova senha do funcionario: ");
									senha = entrada;
									entrada = JOptionPane.showInputDialog("Usuario do funcionario: ");
									usuario = entrada;
						
									tb.setSenha(senha);
									tb.setUsuario(usuario);
						
									stmt = connection.createStatement();
									sql = "UPDATE funcionarios SET senha = '"+ tb.getSenha()
											+ "' WHERE usuario = '"+tb.getUsuario()+"';";
									alter = stmt.executeUpdate(sql);
						
									consulta = "SELECT * FROM funcionarios WHERE senha = '"+ tb.getSenha() +"';";
									stmt = connection.createStatement();
									rs = stmt.executeQuery(consulta);
						
									if(rs.next()){
							
										JOptionPane.showMessageDialog(null, "Senha Alterado com sucesso!");
										System.exit(0);
							
									}else{
										
										JOptionPane.showMessageDialog(null, "Senha ainda a mesmo!");
										System.exit(0);
							
									}
						
									break;
						
								default:
									JOptionPane.showMessageDialog(null, "OPCAO INCORRETA!");
						
									while(menu.MenuFuncionarios() == 0){
							
										menu.MenuFuncionarios();
							
									}
									System.exit(0);
									break;
					}//Switch dos menus
				}//While do menu dos funcionarios
			
				break;
				
			case "clientes":
				
				while(menu.MenuClientes() <= 10){
					
					switch(menu.MenuClientes()){
					
						case 1:
							
							entrada = JOptionPane.showInputDialog("Novo Nome do cliente: ");
							nome = entrada;
							entrada = JOptionPane.showInputDialog("ID do cliente: ");
							id = Integer.parseInt(entrada);
						
							tb.setNome(nome);
						
							stmt = connection.createStatement();
							sql = "UPDATE clientes SET nome = '"+ tb.getNome()
									+ "' WHERE id = "+ id +";";
							alter = stmt.executeUpdate(sql);
						
							consulta = "SELECT * FROM clientes WHERE nome = '"+ tb.getNome() +"';";
							stmt = connection.createStatement();
							rs = stmt.executeQuery(consulta);
						
							if(rs.next()){
							
								JOptionPane.showMessageDialog(null, "Nome Alterado com sucesso!");
								System.exit(0);
							
							}else{
							
								JOptionPane.showMessageDialog(null, "Nome ainda o mesmo!");
								System.exit(0);
							
							}
							
							break;
						
						case 2:
							
							entrada = JOptionPane.showInputDialog("Novo CPF do cliente: ");
							cpf = entrada;
							entrada = JOptionPane.showInputDialog("ID do cliente: ");
							id = Integer.parseInt(entrada);
						
							tb.setCpf(nome);
						
							stmt = connection.createStatement();
							sql = "UPDATE clientes SET cpf = '"+ tb.getCpf()
									+ "' WHERE id = "+ id +";";
							alter = stmt.executeUpdate(sql);
						
							consulta = "SELECT * FROM clientes WHERE cpf = '"+ tb.getCpf() +"';";
							stmt = connection.createStatement();
							rs = stmt.executeQuery(consulta);
						
							if(rs.next()){
							
								JOptionPane.showMessageDialog(null, "Cpf Alterado com sucesso!");
								System.exit(0);
							
							}else{
							
								JOptionPane.showMessageDialog(null, "Cpf ainda o mesmo!");
								System.exit(0);
							
							}
							
							break;
							
						case 3:
							
							entrada = JOptionPane.showInputDialog("Novo Sexo do cliente: ");
							sexo = entrada;
							entrada = JOptionPane.showInputDialog("ID do cliente: ");
							id = Integer.parseInt(entrada);
						
							tb.setSexo(sexo);
						
							stmt = connection.createStatement();
							sql = "UPDATE clientes SET sexo = '"+ tb.getSexo()
									+ "' WHERE id = "+ id +";";
							alter = stmt.executeUpdate(sql);
						
							consulta = "SELECT * FROM clientes WHERE sexo = '"+ tb.getSexo() +"';";
							stmt = connection.createStatement();
							rs = stmt.executeQuery(consulta);
						
							if(rs.next()){
							
								JOptionPane.showMessageDialog(null, "Sexo Alterado com sucesso!");
								System.exit(0);
							
							}else{
							
								JOptionPane.showMessageDialog(null, "Sexo ainda o mesmo!");
								System.exit(0);
							
							}
							
							break;
							
						case 4:
							
							entrada = JOptionPane.showInputDialog("Nova Data de nascimento do cliente: ");
							dataNascimento = entrada;
							entrada = JOptionPane.showInputDialog("ID do cliente: ");
							id = Integer.parseInt(entrada);
						
							tb.setSexo(sexo);
						
							stmt = connection.createStatement();
							sql = "UPDATE clientes SET dataNascimento = '"+ tb.getDataNascimento()
									+ "' WHERE id = "+ id +";";
							alter = stmt.executeUpdate(sql);
						
							consulta = "SELECT * FROM clientes WHERE dataNascimento = '"+ tb.getDataNascimento() +"';";
							stmt = connection.createStatement();
							rs = stmt.executeQuery(consulta);
						
							if(rs.next()){
							
								JOptionPane.showMessageDialog(null, "Data de nascimento Alterado com sucesso!");
								System.exit(0);
							
							}else{
							
								JOptionPane.showMessageDialog(null, "Data de nascimento ainda a mesmo!");
								System.exit(0);
							
							}
							
							break;
							
						case 5:
							
							entrada = JOptionPane.showInputDialog("Novo Estado onde cliente mora: ");
							estado = entrada;
							entrada = JOptionPane.showInputDialog("ID do cliente: ");
							id = Integer.parseInt(entrada);
						
							tb.setEstado(estado);
						
							stmt = connection.createStatement();
							sql = "UPDATE clientes SET estado = '"+ tb.getEstado()
									+ "' WHERE id = "+ id +";";
							alter = stmt.executeUpdate(sql);
						
							consulta = "SELECT * FROM clientes WHERE estado = '"+ tb.getEstado() +"';";
							stmt = connection.createStatement();
							rs = stmt.executeQuery(consulta);
						
							if(rs.next()){
							
								JOptionPane.showMessageDialog(null, "Estado Alterado com sucesso!");
								System.exit(0);
							
							}else{
							
								JOptionPane.showMessageDialog(null, "Estado ainda o mesmo!");
								System.exit(0);
							
							}
							
							break;
							
						case 6:
							
							entrada = JOptionPane.showInputDialog("Novo email do cliente: ");
							email = entrada;
							entrada = JOptionPane.showInputDialog("ID do cliente: ");
							id = Integer.parseInt(entrada);
						
							tb.setEmail(email);
						
							stmt = connection.createStatement();
							sql = "UPDATE clientes SET email = '"+ tb.getEmail()
									+ "' WHERE id = "+ id +";";
							alter = stmt.executeUpdate(sql);
						
							consulta = "SELECT * FROM clientes WHERE email = '"+ tb.getEmail() +"';";
							stmt = connection.createStatement();
							rs = stmt.executeQuery(consulta);
						
							if(rs.next()){
							
								JOptionPane.showMessageDialog(null, "Email Alterado com sucesso!");
								System.exit(0);
							
							}else{
							
								JOptionPane.showMessageDialog(null, "Email ainda o mesmo!");
								System.exit(0);
							
							}
							
							break;
							
						case 7:
							
							entrada = JOptionPane.showInputDialog("Novo cidade onde cliente mora: ");
							cidade = entrada;
							entrada = JOptionPane.showInputDialog("ID do cliente: ");
							id = Integer.parseInt(entrada);
						
							tb.setCidade(estado);
						
							stmt = connection.createStatement();
							sql = "UPDATE clientes SET cidade = '"+ tb.getCidade()
									+ "' WHERE id = "+ id +";";
							alter = stmt.executeUpdate(sql);
						
							consulta = "SELECT * FROM clientes WHERE cidade = '"+ tb.getCidade() +"';";
							stmt = connection.createStatement();
							rs = stmt.executeQuery(consulta);
						
							if(rs.next()){
							
								JOptionPane.showMessageDialog(null, "Estado Alterado com sucesso!");
								System.exit(0);
							
							}else{
							
								JOptionPane.showMessageDialog(null, "Estado ainda o mesmo!");
								System.exit(0);
							
							}
							
							break;
							
						case 8:
							
							entrada = JOptionPane.showInputDialog("Novo CEP do cliente: ");
							cep = Integer.parseInt(entrada);
							entrada = JOptionPane.showInputDialog("ID do cliente: ");
							id = Integer.parseInt(entrada);
						
							tb.setCep(cep);
						
							stmt = connection.createStatement();
							sql = "UPDATE clientes SET cep = "+ tb.getCep()
									+ " WHERE id = "+ id +";";
							alter = stmt.executeUpdate(sql);
						
							consulta = "SELECT * FROM clientes WHERE cep = "+ tb.getCep() +";";
							stmt = connection.createStatement();
							rs = stmt.executeQuery(consulta);
						
							if(rs.next()){
							
								JOptionPane.showMessageDialog(null, "Estado Alterado com sucesso!");
								System.exit(0);
							
							}else{
							
								JOptionPane.showMessageDialog(null, "Estado ainda o mesmo!");
								System.exit(0);
							
							}
							break;
							
						case 9:
							
							entrada = JOptionPane.showInputDialog("Novo n° de telefone do cliente: ");
							telefone = entrada;
							entrada = JOptionPane.showInputDialog("ID do cliente: ");
							id = Integer.parseInt(entrada);
						
							tb.setCidade(estado);
						
							stmt = connection.createStatement();
							sql = "UPDATE clientes SET telefone = '"+ tb.getTelefone()
									+ "' WHERE id = "+ id +";";
							alter = stmt.executeUpdate(sql);
						
							consulta = "SELECT * FROM clientes WHERE telefone = '"+ tb.getTelefone() +"';";
							stmt = connection.createStatement();
							rs = stmt.executeQuery(consulta);
						
							if(rs.next()){
							
								JOptionPane.showMessageDialog(null, "N° do telefone Alterado com sucesso!");
								System.exit(0);
							
							}else{
							
								JOptionPane.showMessageDialog(null, "N° do telefone ainda o mesmo!");
								System.exit(0);
							
							}
							
							break;
							
						case 10:
							
							entrada = JOptionPane.showInputDialog("Novo n° de celular do cliente: ");
							celular = entrada;
							entrada = JOptionPane.showInputDialog("ID do cliente: ");
							id = Integer.parseInt(entrada);
						
							tb.setCelular(celular);
						
							stmt = connection.createStatement();
							sql = "UPDATE clientes SET celular = '"+ tb.getCelular()
									+ "' WHERE id = "+ id +";";
							alter = stmt.executeUpdate(sql);
						
							consulta = "SELECT * FROM clientes WHERE celular = '"+ tb.getCelular() +"';";
							stmt = connection.createStatement();
							rs = stmt.executeQuery(consulta);
						
							if(rs.next()){
							
								JOptionPane.showMessageDialog(null, "N° de celular Alterado com sucesso!");
								System.exit(0);
							
							}else{
							
								JOptionPane.showMessageDialog(null, "N° de celular ainda o mesmo!");
								System.exit(0);
							
							}
							
							break;
							
						default:
							
							JOptionPane.showMessageDialog(null, "OPCAO INCORRETA!");
							
							while(menu.MenuClientes() == 0){
					
								menu.MenuClientes();
					
							}
							System.exit(0);
							break;	
							
					}//Switch da tabela dos cliente
				}//While do menus dos Clientes
				
				break;
				
			case "estoque":
				while(menu.MenuEstoque() <= 3){
					switch(menu.MenuEstoque()){
					
						case 1:
						
							entrada = JOptionPane.showInputDialog("Novo nome do produto: ");
							nomeProduto = entrada;
							entrada = JOptionPane.showInputDialog("ID do produto: ");
							id = Integer.parseInt(entrada);
						
							tb.setNomeProduto(nomeProduto);
					
							stmt = connection.createStatement();
							sql = "UPDATE estoque SET nomeProduto = '"+ tb.getNomeProduto()
									+ "' WHERE id = "+ id +";";
							alter = stmt.executeUpdate(sql);
					
							consulta = "SELECT * FROM estoque WHERE nomeProduto = '"+ tb.getNomeProduto() +"';";
							stmt = connection.createStatement();
							rs = stmt.executeQuery(consulta);
					
							if(rs.next()){
						
								JOptionPane.showMessageDialog(null, "Nome do produto Alterado com sucesso!");
								System.exit(0);
						
							}else{
						
								JOptionPane.showMessageDialog(null, "Nome do produto ainda o mesmo!");
								System.exit(0);
						
							}
							
							break;
							
						case 2:
							
							entrada = JOptionPane.showInputDialog("Novo nome do fornecedor: ");
							nomeFornecedor = entrada;
							entrada = JOptionPane.showInputDialog("ID do produto: ");
							id = Integer.parseInt(entrada);
						
							tb.setNomeFornecedor(nomeFornecedor);
					
							stmt = connection.createStatement();
							sql = "UPDATE estoque SET nomeFornecedores = '"+ tb.getNomeFornecedor()
									+ "' WHERE id = "+ id +";";
							alter = stmt.executeUpdate(sql);
					
							consulta = "SELECT * FROM estoque WHERE nomeFornecedores = '"+ tb.getNomeFornecedor() +"';";
							stmt = connection.createStatement();
							rs = stmt.executeQuery(consulta);
					
							if(rs.next()){
						
								JOptionPane.showMessageDialog(null, "Nome do fornecedor Alterado com sucesso!!");
								System.exit(0);
						
							}else{
						
								JOptionPane.showMessageDialog(null, "Nome do fornecedor ainda o mesmo!");
								System.exit(0);
						
							}
							
							break;
							
						case 3:
							
							entrada = JOptionPane.showInputDialog("Novo preco do produto: ");
							preco = Float.parseFloat(entrada);
							entrada = JOptionPane.showInputDialog("ID do produto: ");
							id = Integer.parseInt(entrada);
						
							tb.setPreco(preco);
					
							stmt = connection.createStatement();
							sql = "UPDATE estoque SET preco = " + tb.getPreco()
									+ " WHERE id = "+ id +";";
							alter = stmt.executeUpdate(sql);
					
							consulta = "SELECT * FROM estoque WHERE preco = "+ tb.getPreco() +";";
							stmt = connection.createStatement();
							rs = stmt.executeQuery(consulta);
					
							if(rs.next()){
						
								JOptionPane.showMessageDialog(null, "Preco Alterado com sucesso!");
								System.exit(0);
						
							}else{
						
								JOptionPane.showMessageDialog(null, "Preco ainda é o mesmo!");
								System.exit(0);
						
							}
							break;
							
						default:
							
							JOptionPane.showMessageDialog(null, "OPCAO INCORRETA!");
							
							if(menu.MenuEstoque() == 0){
								
								menu.MenuEstoque();
								
							}
							
							System.exit(0);
							break;
					}		
				}
				
				break;
					
		}//Switch de todas as tabelas
	}
	//Metodo de Manipulacao de Consulta dos bancos
	public void Consultar(String tabela) throws SQLException{
		
		String consulta;
		Statement stmt;
		ResultSet rs;
		int id;
		
		Conexao conn = new Conexao();
		Tabelas tb = new Tabelas();
		JTextArea saida = new JTextArea(10, 40); // HEIGHT X WIDTH
        JScrollPane scroll = new JScrollPane(saida);
		Connection connection = conn.getConexaoMySQL();
		ResultSetMetaData col;
		
		switch(tabela){
		
			case "funcionarios":
				
				entrada = JOptionPane.showInputDialog("Nome para consulta: ");
				nome = entrada;
				tb.setNome(nome);
				
				consulta = "SELECT * FROM funcionarios WHERE nome = '"+ tb.getNome() +"';";
				stmt = connection.createStatement();
				rs = stmt.executeQuery(consulta);
				col = rs.getMetaData();
				
				while(rs.next()){
					
					for(int i = 1; i < col.getColumnCount()+1; i++){
					
						saida.append("| " + col.getColumnName(i) +": ");
						saida.append(rs.getString(col.getColumnName(i)));
						
					}
					
					saida.append("\n");
				}
				
				JOptionPane.showMessageDialog(null, scroll, "Tabela " + tabela,
		        		JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case "clientes":
				
				entrada = JOptionPane.showInputDialog("Nome para consulta: ");
				nome = entrada;
				tb.setNome(nome);
				
				consulta = "SELECT * FROM clientes WHERE nome = '"+ tb.getNome() +"';";
				stmt = connection.createStatement();
				rs = stmt.executeQuery(consulta);
				col = rs.getMetaData();
				
				while(rs.next()){
					
					for(int i = 1; i < col.getColumnCount()+1; i++){
					
						saida.append("| " + col.getColumnName(i) +": ");
						saida.append(rs.getString(col.getColumnName(i)));
						
					}
					
					saida.append("\n");
				}
				
				JOptionPane.showMessageDialog(null, scroll, "Tabela " + tabela,
		        		JOptionPane.INFORMATION_MESSAGE);
				
				break;
				
			case "estoque":
				
				entrada = JOptionPane.showInputDialog("Deseja consultar produto ou fornecedor? ");
				String consultaEstoque = entrada;
				
				if(consultaEstoque.equals("produto")){
					
					entrada = JOptionPane.showInputDialog("Nome do produto para consulta: ");
					nomeProduto = entrada;
					tb.setNomeProduto(nomeProduto);
				
					consulta = "SELECT * FROM estoque WHERE nomeProduto = '"+ tb.getNomeProduto() +"';";
					stmt = connection.createStatement();
					rs = stmt.executeQuery(consulta);
					col = rs.getMetaData();
					
					while(rs.next()){
						
						for(int i = 1; i < col.getColumnCount()+1; i++){
						
							saida.append("| " + col.getColumnName(i) +": ");
							saida.append(rs.getString(col.getColumnName(i)));
							
						}
						
						saida.append("\n");
					}
					
					JOptionPane.showMessageDialog(null, scroll, "Tabela " + tabela,
			        		JOptionPane.INFORMATION_MESSAGE);
					
				}else if(consultaEstoque.equals("fornecedor")){
					
					entrada = JOptionPane.showInputDialog("Nome do fornecedor: ");
					nomeFornecedor = entrada;
					tb.setNomeFornecedor(nomeFornecedor);
					
					consulta = "SELECT * FROM estoque WHERE nomeFornecedores = '"+ tb.getNomeFornecedor() +"';";
					stmt = connection.createStatement();
					rs = stmt.executeQuery(consulta);
					col = rs.getMetaData();
					
					while(rs.next()){
						
						for(int i = 1; i < col.getColumnCount()+1; i++){
						
							saida.append("| " + col.getColumnName(i) +": ");
							saida.append(rs.getString(col.getColumnName(i)));
							
						}
						
						saida.append("\n");
					}
					
					JOptionPane.showMessageDialog(null, scroll, "Tabela " + tabela,
			        		JOptionPane.INFORMATION_MESSAGE);
				}
				
				break;
					
		}
	}
	
}
