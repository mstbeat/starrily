//package starrily;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import starrily.service.UserDetailsAuthenticationProviderService;
//
///**
// * セキュリティ機能を設定するクラス
// * @author taniryuki
// * @version 1.0.0
// */
//@Configuration
//@EnableWebSecurity
//public class WebSecuriyConfig extends WebSecurityConfigurerAdapter {
//
//	/**
//	 * 静的リソースを認可処理の対象から除外するメソッド
//	 * @param web ean のリストに Filter リクエストを委譲
//	 */
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers(
//				"/img/**",
//				"/css/**",
//				"/js/**");
//	}
//
//	/**
//	 * 認証・認可の情報、画面遷移のURL・パラメータを取得するname属性の値を設定するメソッド
//	 * @param http 特定のhttpリクエストに対してWebベースのセキュリティを構成
//	 * @throws Exception 例外
//	 */
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http
//				.authorizeRequests()
//				.anyRequest()
//				.authenticated()
//				.and()
//				.formLogin()
//				.loginPage("/login")
//				.permitAll()
//				.loginProcessingUrl("/login")
//				.failureUrl("http://157.7.211.250:9090/login")
//				.usernameParameter("userId")
//				.passwordParameter("password")
//				.defaultSuccessUrl("/success");
//	}
//
//	/**
//	 * 認証時に利用するソースを定義する設定メソッド
//	 * @param auth AuthenticationProviderの追加を構築するAuthenticationManagerBuilder型クラスの引数
//	 * @throws Exception 例外
//	 */
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(getAuthenticationProvider());
//	}
//
//	/**
//	 * AuthenticationProvider型の認証サービスクラスを返すメソッド
//	 * @return 認証サービスクラスを返す
//	 */
//	@Bean
//	public AuthenticationProvider getAuthenticationProvider() {
//		return new UserDetailsAuthenticationProviderService();
//	}
//}