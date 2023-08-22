package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {
	
	public static void main(String[] args) throws IOException {
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("pessoa1@gmail.com");
		pessoa1.setIdade(10);
		pessoa1.setNome("Pessoa 1");
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setIdade(20);
		pessoa2.setNome("Pessoa 2");
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setIdade(30);
		pessoa3.setNome("Pessoa 3");
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		/* instanciando a classe arquivo */
		File arquivo = new File("C:\\Desenvolvimento\\ws-sts\\jdev-apache-poi\\src\\arquivos\\arquivo.txt");
	
		if (!arquivo.exists()) {
			arquivo.createNewFile(); // cria o arquivo se não existir
		}
		
		FileWriter escreveArquivo = new FileWriter(arquivo);
		
		/*for (int i = 1; i <= 10; i++) {
			escreveArquivo.write("Texto da minha linha " + i + "\n"); // escreve o conteudo
		}*/
		
		for (Pessoa p : pessoas) {
			escreveArquivo.write(p.getNome() + ";" + p.getEmail() + ";" + p.getIdade() + "\n");
		}
		
		escreveArquivo.flush(); // persistindo as alterações
		
		escreveArquivo.close(); // fechando
		
	}
	
}
