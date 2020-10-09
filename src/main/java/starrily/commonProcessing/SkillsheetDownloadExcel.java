package starrily.commonProcessing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import starrily.bean.SkillSheet;
import starrily.service.StarrilyService;

/**
 * スキルシートダウンロードクラス.
 *
 * @author yamamoto
 * @version 1.0.0
 */
public class SkillsheetDownloadExcel {

	@Autowired
	private StarrilyService starrilyService;

	/**
	 * Excelダウンロード処理.
	 *
	 * @param response リクエストヘッダ情報
	 * @param model webページで利用するデータを管理するためのクラス
	 * @param id ヘッダーのスキルシート参照画面と一覧画面からきたのかの判定
	 * @param number 指名(フルネーム)か指名(イニシャル)がの判定
	 * @throws FileNotFoundException ファイルが見つからない場合の例外
	 * @throws IOException 出力処理に関わる例外
	 * @throws JRException 帳票定義体に関わる例外
	 */
	public void fullNameExcel(HttpServletResponse response, Model model, int id, int number)
			throws FileNotFoundException, IOException, JRException {

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("Title", "職務・技術経歴書");

		// 基本情報をとる
		SkillSheet fields = starrilyService.getSkillSheetBasic(id);
		// 案件基本情報を取得
		List<SkillSheet> projectAllList = starrilyService.getProjectAll(id);

		if (number == 1) {
			for (SkillSheet forProject : projectAllList) {
				forProject.setUserName(fields.getUserName());
				forProject.setUserPhonetic(fields.getUserPhonetic());
				forProject.setUserAppeal(fields.getUserAppeal());
				forProject.setUserSex(fields.getUserSex());
				forProject.setUserAge(fields.getUserAge());
				forProject.setUserBirthday(fields.getUserBirthday());
				forProject.setUserAppeal(fields.getUserAppeal());
				forProject.setUserAddress(fields.getUserAddress());
				forProject.setUserFinalEducation(fields.getUserFinalEducation());
				forProject.setUserStation(fields.getUserStation());
				forProject.setUserStationLine(fields.getUserStationLine());
				forProject.setUserRemarks(fields.getUserRemarks());
				forProject.setUserCertification(fields.getUserCertification());
			}
		} else if (number == 2) {
			for (SkillSheet forProject : projectAllList) {
				forProject.setUserInitialName(fields.getUserInitialName());
				forProject.setUserName(null);
				forProject.setUserPhonetic("");
				forProject.setUserAppeal(fields.getUserAppeal());
				forProject.setUserSex(fields.getUserSex());
				forProject.setUserAge(fields.getUserAge());
				forProject.setUserBirthday(fields.getUserBirthday());
				forProject.setUserAppeal(fields.getUserAppeal());
				forProject.setUserAddress(fields.getUserAddress());
				forProject.setUserFinalEducation(fields.getUserFinalEducation());
				forProject.setUserStation(fields.getUserStation());
				forProject.setUserStationLine(fields.getUserStationLine());
				forProject.setUserRemarks(fields.getUserRemarks());
				forProject.setUserCertification(fields.getUserCertification());
			}
		}
		for (SkillSheet forProjectAll : projectAllList) {
			// DBの情報を取得
			// userIdで同じ数字があった場合、CareerIdの情報のDBを取ってくる
			List<SkillSheet> projectDbList = starrilyService.getProjectDB(forProjectAll.getCareerId());

			String projectDb = "";

			for (SkillSheet forDb : projectDbList) {

				String db = null;

				if (forDb.getDbVer() != null) {
					db = forDb.getDb() + forDb.getDbVer();
				} else {
					db = forDb.getDb();
				}
				projectDb = projectDb + db + "\n";
			}
			forProjectAll.setAllDb(projectDb);

			// フレームワークの情報を取
			List<SkillSheet> projectFwNwList = starrilyService.getProjectFwNw(forProjectAll.getCareerId());

			String projectFwNw = "";

			for (SkillSheet ForFwNw : projectFwNwList) {

				String FwNw = null;

				if (ForFwNw.getFwNwVer() != null) {
					FwNw = ForFwNw.getFwNw() + ForFwNw.getFwNwVer();
				} else {
					FwNw = ForFwNw.getFwNw();
				}
				projectFwNw = projectFwNw + FwNw + "\n";
			}
			forProjectAll.setAllFwNw(projectFwNw);

			// OSの情報を取得
			List<SkillSheet> projectOsList = starrilyService.getProjectOS(forProjectAll.getCareerId());

			String projectOs = "";

			for (SkillSheet ForOs : projectOsList) {

				String Os = null;

				if (ForOs.getOsVer() != null) {
					Os = ForOs.getOs() + ForOs.getOsVer();
				} else {
					Os = ForOs.getOs();
				}
				projectOs = projectOs + Os + "\n";
			}
			forProjectAll.setAllOs(projectOs);

			// 言語の情報を取得
			List<SkillSheet> projectLangList = starrilyService.getProjectLang(forProjectAll.getCareerId());

			String projectLang = "";

			for (SkillSheet ForProjectLang : projectLangList) {

				String language = null;

				if (ForProjectLang.getOsVer() != null) {
					language = ForProjectLang.getLanguage() + ForProjectLang.getLanguageVer();
				} else {
					language = ForProjectLang.getLanguage();
				}
				projectLang = projectLang + language + "\n";
			}
			forProjectAll.setAllLang(projectLang);

			// その他の情報を取得
			List<SkillSheet> projectOtherList = starrilyService.getProjectOther(forProjectAll.getCareerId());

			String projectOther = "";

			for (SkillSheet ForProjectOther : projectOtherList) {

				String other = null;

				if (ForProjectOther.getOsVer() != null) {
					other = ForProjectOther.getOther() + ForProjectOther.getOtherVer();
				} else {
					other = ForProjectOther.getOther();
				}
				projectOther = projectOther + other + "\n";
			}
			forProjectAll.setAllOther(projectOther);
		}

		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition",
				"attachment; filename=" + URLEncoder
						.encode(fields.getUserName().concat(fields.getUserStation()) + "駅" + ".xlsx", "UTF-8"));
		response.setCharacterEncoding("UTF-8");

		File jrxmlFile = new File("src/main/resources/reports/skillsheet_fullNamelExcel.jrxml");
		InputStream input = new FileInputStream(jrxmlFile);
		JasperReport jasperReport = JasperCompileManager.compileReport(input);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(projectAllList);

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

		//エクセルの各種設定はここで行います。
		SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
		configuration.setOnePagePerSheet(true);
		configuration.setDetectCellType(true);

		OutputStream os = null;
		os = response.getOutputStream();

		JRXlsxExporter exporter = new JRXlsxExporter();
		exporter.setConfiguration(configuration);
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(os));
		exporter.exportReport();
		os.flush();
		os.close();
	}
}
