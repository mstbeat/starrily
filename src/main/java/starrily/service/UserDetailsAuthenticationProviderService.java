//package starrily.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import starrily.bean.LoginUser;
//import starrily.bean.UserInformation;
//import starrily.mapper.starrilydb.LoginUserMapper;
//import starrily.mapper.starrilydb.StarrilyMapper;
//
///**
// * ユーザー認証を行うServiceクラス.
// * @author taniryuki
// * @version 1.0.0
// */
//@Service
//public class UserDetailsAuthenticationProviderService extends AbstractUserDetailsAuthenticationProvider {
//
//	/**  認証の偽のパスワード */
//	private static final String DUMMY_PASSWORD = "DUMMY_PASSWORD";
//
//	/**  ユーザーの権限 */
//	private static List<GrantedAuthority> authUser;
//
//	/** LoginUserMapperを自動的にDIする */
//	@Autowired
//	private LoginUserMapper loginUserMapper;
//
//	/** StarrilyMapperを自動的にDIする */
//	@Autowired
//	private StarrilyMapper starrilyMapper;
//
//	/**
//	 * DB認証を行うメソッド
//	 * @param userId ユーザーメールアドレス
//	 * @param authentication ユーザー名とパスワードを簡単に提示するために設計されたAuthentication実装
//	 * @throws AuthenticationException 認証エラーが発生した場合の例外
//	 * @return UserDetailsの実装(User)を返す
//	 */
//	@Override
//	protected UserDetails retrieveUser(String userId, UsernamePasswordAuthenticationToken authentication)
//			throws AuthenticationException {
//
//		LoginUser user = loginUserMapper.findUser(userId);
//
//		if (user == null) {
//			throw new UsernameNotFoundException("User" + userId + "was not found in the database");
//		}
//
//		UserInformation loginUserId = starrilyMapper.getUserId(userId);
//		int userRole = starrilyMapper.getUserRole(loginUserId.getUserId());
//		authUser = AuthorityUtils.createAuthorityList(String.valueOf(userRole));
//
//		return new User(userId, DUMMY_PASSWORD, authUser);
//	}
//
//	/**
//	 * 追加の認証をするメソッド
//	 * @param userDetails ユーザー情報
//	 * @param authentication ユーザー名とパスワードを簡単に提示するために設計されたAuthentication実装
//	 * @throws AuthenticationException 認証エラーが発生した場合の例外
//	 */
//	@Override
//	protected void additionalAuthenticationChecks(org.springframework.security.core.userdetails.UserDetails userDetails,
//			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
//	}
//}
