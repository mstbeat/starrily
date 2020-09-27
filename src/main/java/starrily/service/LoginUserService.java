package starrily.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import starrily.bean.UserInformation;
import starrily.mapper.starrilydb.LoginUserMapper;

/**
 * ユーザーのサービスクラス.
 * @author tateyahajime
 * @version 1.0.0
 */
@Service
public class LoginUserService {

	/**
	 * LoginUserMapperのインスタンス化
	 */
	@Autowired
	LoginUserMapper loginUserMapper;

	/**
	 * 全てのユーザー情報取得.
	 * @return 全てのユーザー情報
	 */
	public List<UserInformation> userInformationList() {
		return loginUserMapper.userInformationList();
	}

	/**
	 * ユーザー情報検索.
	 * @param userInformation 検索したい情報
	 * @return ユーザー情報
	 */
	public List<UserInformation> searchUserInfo(UserInformation userInformation) {
		return loginUserMapper.searchUserInfo(userInformation);
	}
}
