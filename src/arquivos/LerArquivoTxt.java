package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoTxt {

	public static void main(String[] args) throws FileNotFoundException {

		/* Fazendo a instancia da classe de leitura de arquivos do java */
		FileInputStream entradaArquivo = new FileInputStream(
				new File("C:\\Desenvolvimento\\ws-sts\\jdev-apache-poi\\src\\arquivos\\arquivo.txt"));

		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8"); // entrada do arquivo e a codificação

		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		while (lerArquivo.hasNext()) {

			String linha = lerArquivo.nextLine();

			if (linha != null && linha.isEmpty()) { // removendo linhas em branco.

				String[] dados = linha.split("\\;");

				Pessoa pessoa = new Pessoa();

				pessoa.setNome(dados[0]);
				pessoa.setEmail(dados[1]);
				pessoa.setIdade(Integer.parseInt(dados[2]));

				pessoas.add(pessoa);
			}
		}
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoas);
		}

	}

}
