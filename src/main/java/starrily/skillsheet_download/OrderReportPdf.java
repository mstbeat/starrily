package starrily.skillsheet_download;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import starrily.bean.SkillSheet;

/**
 * スキルシートダウンロード(PDF出力処理)クラス。
 *
 * @author kikuchi
 * @version 1.0.0
 *
 */
public class OrderReportPdf {

	/**
	 *帳票定義体をPDFに整形するメソッドです。
	 *
	 * @param param 帳票定義体へセットするテキストフィールドの値
	 * @param data 帳票定義体へセットするフィールドの値
	 * @return PDFに整形した帳票をバイト型で返します
	 * @throws IOException ファイルが見つからない場合の例外
	 * @throws FileNotFoundException 出力処理に関わる例外
	 * @throws JRException 帳票定義体に関わる例外
	 */
	public byte[] orderReportPdf(HashMap<String, Object> param, List<SkillSheet> data)
			throws FileNotFoundException, IOException, JRException {

		File jrxmlFile = new File("src/main/resources/reports/skillsheet_fullNamelPdf.jrxml");
		InputStream input = new FileInputStream(jrxmlFile);
		JasperReport jasperReport = JasperCompileManager.compileReport(input);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, dataSource);

		return JasperExportManager.exportReportToPdf(jasperPrint);

	}

//	/**
//	 *帳票定義体をPDFに整形するメソッドです。
//	 *
//	 * @param param 帳票定義体へセットするテキストフィールドの値
//	 * @param data 帳票定義体へセットするフィールドの値
//	 * @return PDFに整形した帳票をバイト型で返します
//	 * @throws IOException ファイルが見つからない場合の例外
//	 * @throws FileNotFoundException 出力処理に関わる例外
//	 * @throws JRException 帳票定義体に関わる例外
//	 */
//	public byte[] orderReportPd(HashMap<String, Object> param, List<SkillSheet> data)
//			throws FileNotFoundException, IOException, JRException {
//
//		File jrxmlFile = new File("src/main/resources/reports/skillsheet_initialPdf.jrxml");
//		InputStream input = new FileInputStream(jrxmlFile);
//		JasperReport jasperReport = JasperCompileManager.compileReport(input);
//		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
//
//		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, dataSource);
//
//		return JasperExportManager.exportReportToPdf(jasperPrint);
//
//	}

}
