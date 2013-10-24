package changeexplorer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

//import br.com.estec.persistencia.CD;
//import br.com.estec.persistencia.dao.CDDAO;

public class GravarExcel {

	public void expExcel(String nomeArquivo) {

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet firstSheet = workbook.createSheet("Aba1");

		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(new File("testExcel"));

			// Este trecho obtem uma lista de objetos do tipo CD

			// do banco de dados através de um DAO e itera sobre a lista

			// criando linhas e colunas em um arquivo Excel com o conteúdo

			// dos objetos.

			// CDDAO dao = new CDDAO();
			// List&lt;CD&gt; lista = dao.obter();

			int i = 0;

			// for (CD cd : lista) {
			HSSFRow row = firstSheet.createRow(i);
			row.createCell(0).setCellValue("id");
			row.createCell(1).setCellValue("nome");
			row.createCell(2).setCellValue("ano");

			i++;

			// } // fim do for

			workbook.write(fos);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao exportar arquivo");
		} finally {
			try {
				fos.flush();
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	} // fim do metodo exp

}