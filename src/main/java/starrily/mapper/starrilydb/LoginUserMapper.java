package starrily.mapper.starrilydb;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import starrily.bean.LoginUser;
import starrily.bean.UserInformation;

/**
 * ユーザー認証の為、DBに接続するMapperクラス.
 * @author taniryuki
 * @version 1.0.0
 */
@Mapper
public interface LoginUserMapper {

	/**
	 * ユーザー情報取得
	 * @param userId 入力されたメールアドレス
	 * @return ログインユーザーbeanクラス
	 */
	LoginUser findUser(String userId);

	/**
	 * 全てのユーザー情報取得.
	 * @return UserInformationのbeanクラス
	 */
	public List<UserInformation> userInformationList();

	/**
	 * ユーザー情報検索.
	 * @param userInformationのbeanクラス
	 * @return 検索したユーザー情報
	 */
	public List<UserInformation> searchUserInfo(UserInformation userInformation);



}
