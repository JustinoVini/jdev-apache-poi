package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi2 {

	public static void main(String[] args) throws IOException {
		FileInputStream entrada = new FileInputStream(
				new File("C:\\Desenvolvimento\\ws-sts\\jdev-apache-poi\\src\\arquivos\\arquivo_excel.xls"));
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); // prepara a entrada do arquivo para ser lido
		
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0); // pega a primeira planilha no nosso arquivo xl
		
		/*Percorrendo as linhas*/
		Iterator<Row> linhaIterator = planilha.iterator();
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while (linhaIterator.hasNext()) { /*Enquanto ter linhas no xl, ele vai entrar e pegar a linha*/
			
			Row linha = linhaIterator.next(); /*Dados da pessoa na linha*/
			
			Iterator<Cell> celulas = linha.iterator();
			
			Pessoa pessoa = new Pessoa();
			
			while (celulas.hasNext()) { /*Percorre as celulas*/
				Cell cell = celulas.next();
				
				switch (cell.getColumnIndex()) {
				case 0:
					pessoa.setNome(cell.getStringCellValue());
					break;
				case 1: 
					pessoa.setEmail(cell.getStringCellValue());
					break;
				case 2: 
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
				default:
					break;
				}
			} // fim das celulas da linha
			
			pessoas.add(pessoa);
			
		}
		
		entrada.close();
		
		for (Pessoa pessoa : pessoas) { 
			System.out.println(pessoa);
		}
		
		System.out.println("Foi");
	}

}
