package starrily.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import starrily.service.StarrilyService;

/**
 * ログイン画面のコントローラー
 *
 * @author PDA s.lee
 *
 */
@Controller
public class LoginController {

	/** StarrilyServiceを自動的にDIする */
	@Autowired
	StarrilyService starrilyService;

	/**
	 * 最初に接続、ログアウトするときに処理するメソッド
	 *
	 * @return  ログイン画面へ遷移する。
	 */
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	/**
	 * 認証が成功した際のメソッド
	 * @param request HTTPサーブレットのためのリクエストの情報
	 * @return エンジニア検索画面へリダイレクトする。
	 */
//	@GetMapping("success")
//	public String loginProccess(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		SecurityContext securityContext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
//		org.springframework.security.core.Authentication authentication = securityContext.getAuthentication();
//		String userMail = authentication.getName();
//		UserInformation user = starrilyService.getUserId(userMail);
//		int userRole = starrilyService.getUserRole(user.getUserId());
//		session.setAttribute("userId", user.getUserId());
//		session.setAttribute("userRole", userRole);
//		return "redirect:/engineer_search";
//	}
}
