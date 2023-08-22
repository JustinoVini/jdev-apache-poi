package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiEditando {

	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Desenvolvimento\\ws-sts\\jdev-apache-poi\\src\\arquivos\\arquivo_excel.xls");

		FileInputStream entrada = new FileInputStream(file);

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); /* Prepara a entrada */
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0);

		Iterator<Row> linhaIterator = planilha.iterator();

		while (linhaIterator.hasNext()) { /* Enquanto tiver linha */
			Row linha = linhaIterator.next(); /* Dados da pessoa da linha */

			int numeroCelulas = linha.getPhysicalNumberOfCells(); /* Quantidade de celula */

			Cell cell = linha.createCell(numeroCelulas); /* Cria nova celula na linha */
			cell.setCellValue("5.487,20");
		}

		entrada.close();

		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);
		saida.flush();
		saida.close();
		
		JOptionPane.showMessageDialog(null, "Saída atualizada!");
		
	}

}
