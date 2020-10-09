package starrily.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.sf.jasperreports.engine.JRException;
import starrily.commonProcessing.SkillsheetDownloadExcel;
import starrily.commonProcessing.SkillsheetDownloadPdf;

/**
 * スキルシートダウンロードクラス.
 *
 * @author yamamoto
 * @version 1.0.0
 */
@Controller
public class SkillsheetDownloadController {

	/** AutowireCapableBeanFactoryを取得(自動配線) */
	@Autowired
	AutowireCapableBeanFactory beanFactory;

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	/**
	 * スキルシートダウンロード画面を表示.
	 *
	 * @param userId ユーザーID
	 * @param model webページで利用するデータを管理するためのクラス。
	 * @return スキルシートダウンロード画面に返す。
	 */
	@PostMapping("/skillsheet_download")
	public String skillsheetDownload(@RequestParam(name = "userId") int userId, Model model) {

		model.addAttribute("userId", userId);

		return "skillsheet_download";
	}

	/**
	 *  フルネーム,イニシャルPDFダウンロード処理.
	 *
	 * @param flg ヘッダーのスキルシート参照か一覧画面からきたのかの判定
	 * @param response リクエストヘッダ情報
	 * @param model webページで利用するデータを管理するためのクラス
	 * @throws FileNotFoundException ファイルが見つからない場合の例外
	 * @throws IOException 出力処理に関わる例外
	 * @throws JRException 帳票定義体に関わる例外
	 */
	@PostMapping("/fullname_pdf_download")
	public void fullNamePdfExport(@RequestParam(name = "flg") int flg, HttpServletResponse response, Model model)
			throws FileNotFoundException, IOException, JRException {
		// ヘッダーからスキルシート参照画面にきた時のセッションに保持したユーザーID
		int LoginUserId = (int) session.getAttribute("Login");

		// 1指名(フルネーム)が押されたら,2指名(イニシャル)が押されたら。
		if (flg == 1) {
			// ユーザーIDを受け取る。
			int userId = Integer.parseInt(request.getParameter("userId"));
			SkillsheetDownloadPdf SkillDownload = new SkillsheetDownloadPdf();
			beanFactory.autowireBean(SkillDownload);
			int number = 1;
			SkillDownload.fullNamePdfExport(response, model, userId, number);
		} else if (flg == 2) {
			SkillsheetDownloadPdf SkillsheetDownload = new SkillsheetDownloadPdf();
			beanFactory.autowireBean(SkillsheetDownload);
			int number = 2;
			SkillsheetDownload.fullNamePdfExport(response, model, LoginUserId, number);
		}
	}

	/**
	 * フルネーム,イニシャルExcelダウンロード処理.
	 *
	 * @param flg ヘッダーのスキルシート参照か一覧画面からきたのかの判定
	 * @param response リクエストヘッダ情報
	 * @param model webページで利用するデータを管理するためのクラス
	 * @throws JRException 帳票定義体に関わる例外
	 * @throws IOException 出力処理に関わる例外
	 */
	@PostMapping("/fullname_excel_download")
	public void fullNameExcelExport(@RequestParam(name = "flg") int flg, HttpServletResponse response,
			Model model)
			throws JRException, IOException {

		// ヘッダーからスキルシート参照画面にきた時のセッションに保持したユーザーID
		int LoginUserId = (int) session.getAttribute("Login");
		// 1指名(フルネーム)が押されたら,2指名(イニシャル)が押されたら。
		if (flg == 1) {
			// ユーザーIDを受け取る。
			int userId = Integer.parseInt(request.getParameter("userId"));
			SkillsheetDownloadExcel SkillDownload = new SkillsheetDownloadExcel();
			beanFactory.autowireBean(SkillDownload);
			int number = 1;
			SkillDownload.fullNameExcel(response, model, userId, number);
		} else if (flg == 2) {
			SkillsheetDownloadExcel SkillsheetDownload = new SkillsheetDownloadExcel();
			beanFactory.autowireBean(SkillsheetDownload);
			int number = 2;
			SkillsheetDownload.fullNameExcel(response, model, LoginUserId, number);
		}
	}
}
