import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Menus {

	public Menus(){}
	//Metodo para as manipulacoes da tabela funcionarios
	public int MenuFuncionarios(){
		
		int opcao = 0;//variavel da opcao
		
		String [] itens = {"nome - 1", "apelido - 2", "cpf - 3", "sexo - 4", "dataNascimento - 5", 
				           "estado - 6", "email - 7","cidade - 8", "CEP - 9" ,"telefone - 10","celular - 11",
				           "usuario - 12", "senha - 13"};//Array de strings das colunas do banco
		String entrada;//variavel para pegar as informacoes que o usuario digitar
		
		JTextArea saida = new JTextArea(10, 35); // HEIGHT X WIDTH
        JScrollPane scroll = new JScrollPane(saida);//Instacia da Classe JScrollPane para a criacao do quadro
        											//onde o usuario vai ver as inforções
        
        saida.append("\t" + "OPÇÕES"+ " \n");//Titudo dentro do quadro criado
        
        for(String item:itens){//for para pegar todo o Array e colocar as informoes dentro do quadro
        	
        	saida.append(item + "\n");//injetando o conteudo
        	
        }
        
        JOptionPane.showMessageDialog(null, scroll, "MENU DE OPÇÕES PARA TABELA FUNCIONARIOS", //titulo do quadro
				JOptionPane.INFORMATION_MESSAGE);
        
        entrada = JOptionPane.showInputDialog("opcao: ");
		opcao = Integer.parseInt(entrada);
		
		while(opcao <= 13){//se o usuario escolher uma opcao menor ou igual que 13 
						  //a funcao retorna a opcao que o usuario digitou
    		
    		return opcao;
    		
    	}
		
    	return 0;//se o usuario escolher uma opcao maior que 13 
    			//a funcao retorna a opcao 0
		
	}
	//Mesmo procedimento do Metodo MenuFuncionarios, so que agr esse menu é do banco cliente
	public int MenuClientes(){
		
		int opcao = 0;
		
		String [] itens = {"nome - 1", "cpf - 2", "sexo - 3", "dataNascimento - 4", "estado - 5",
							"email - 6","cidade - 7", "CEP - 8" ,"telefone - 9","celular - 10"};
		String entrada;
		
		JTextArea saida = new JTextArea(10, 20); // HEIGHT X WIDTH
        JScrollPane scroll = new JScrollPane(saida);
        
        saida.append("\t" + "OPÇÕES"+ " \n");
        
        for(String item:itens){
        	
        	saida.append(item + "\n");
        	
        }
        
        JOptionPane.showMessageDialog(null, scroll, "MENU DE OPÇÕES PARA CLIENTES", 
				JOptionPane.INFORMATION_MESSAGE);
        
        entrada = JOptionPane.showInputDialog("opcao: ");
		opcao = Integer.parseInt(entrada);
		
		while(opcao <= 10){//se o usuario escolher uma opcao menor ou igual que 10 
						  //a funcao retorna a opcao que o usuario digitou
    		
    		return opcao;
    		
    	}
		
    	return 0;//se o usuario escolher uma opcao maior que 10 
		  		//a funcao retorna a opcao 0
	}
	//Mesmo procedimento ddo Metodo MenuFuncionarios, so que agr esse menu é do banco estoque
	
	public int MenuEstoque(){
		
		int opcao = 0;
		
		String [] itens = {"nome do produto - 1", "nome do fornecedor - 2", "preco - 3"};
		String entrada;
		
		JTextArea saida = new JTextArea(10, 20); // HEIGHT X WIDTH
        JScrollPane scroll = new JScrollPane(saida);
        
        saida.append("\t" + "OPÇÕES"+ " \n");
        
        for(String item:itens){
        	
        	saida.append(item + "\n");
        	
        }
        
        JOptionPane.showMessageDialog(null, scroll, "MENU DE OPÇÕES DO ESTOQUE", 
				JOptionPane.INFORMATION_MESSAGE);
        
        entrada = JOptionPane.showInputDialog("opcao: ");
    	opcao = Integer.parseInt(entrada);
        
    	while(opcao <= 3){//se o usuario escolher uma opcao menor ou igual que 3 
						 //a funcao retorna a opcao 0
    		
    		return opcao;
    		
    	}
		
    	return 0;//se o usuario escolher uma opcao maior que 13 
		//a funcao retorna a opcao 0
    	
	}
	//Mesmo procedimento ddo Metodo MenuFuncionarios, so que agr esse menu

	public int menuPrincipal(){
		
		int opcao = 0;
		String entrada;
		
		JTextArea saida = new JTextArea(10, 20); // HEIGHT X WIDTH
        JScrollPane scroll = new JScrollPane(saida);
        
        saida.append("\t" + "OPÇÕES"+ " \n");
        
        saida.append(" Inserir - 1 "+"\n Alterar - 2"+"\n Excluir - 3"+"\n Consultar - 4"+"\n");
        
        JOptionPane.showMessageDialog(null, scroll, "MENU DE MANIPULACOES DAS TABELA", 
				JOptionPane.INFORMATION_MESSAGE);
        
        entrada = JOptionPane.showInputDialog("Manipulcao que desaja fazer: ");
		opcao = Integer.parseInt(entrada);
		
		while(opcao <= 4){//se o usuario escolher uma opcao menor ou igual que 4 
			//a funcao retorna a opcao 0
    		
    		return opcao;
    		
    	}
		
    	return 0;//se o usuario escolher uma opcao maior que 4 
		//a funcao retorna a opcao 0
		
	}
}
