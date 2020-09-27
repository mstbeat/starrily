package starrily.mapper.starrilydb;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import starrily.bean.Dropdown;
import starrily.bean.SkillSheet;
import starrily.bean.UserInformation;

/**
 * StarrilyのDBに接続するMapperクラス.
 * @author T.Osawa
 * @version 1.0.0
 */
@Transactional(transactionManager = "txManagerstarrilydb")
@Mapper
public interface StarrilyMapper {

	/**
	* ドロップダウン情報取得.
	* @param itemNumber ドロップダウンのitem_numberの値
	* @return スキルシートbeanクラス
	*/
	public List<Dropdown> getDropdownInfo(int itemNumber);

	/**
	* 基本情報更新.
	* @param skillSheet スキルシートbeanクラス
	* @return スキルシートbeanクラス
	*/
	public int updateBasicInformation(SkillSheet skillSheet);

	/**
	* 権限取得.
	* @param userId ユーザーID
	* @return 権限情報
	*/
	public int getUserRole(int userId);

	/**
	 * DB情報検索.
	 * @param SkillSheet スキルシートbeanクラス
	 * @return DB情報
	 */
	public List<SkillSheet> searchProjectDB(SkillSheet skillSheet);

	/**
	 * FW/NW情報検索.
	 * @param skillSheet スキルシートbeanクラス
	 * @return FW/NW情報
	 */
	public List<SkillSheet> searchProjectFWNW(SkillSheet skillSheet);

	/**
	 * OS情報検索.
	 * @param skillSheet スキルシートbeanクラス
	 * @return OS情報
	 */
	public List<SkillSheet> searchProjectOS(SkillSheet skillSheet);

	/**
	 * 言語情報検索.
	 * @param skillSheet スキルシートbeanクラス
	 * @return 言語情報
	 */
	public List<SkillSheet> searchProjectLang(SkillSheet skillSheet);

	/**
	 * その他情報検索.
	 * @param skillSheet スキルシートbeanクラス
	 * @return その他情報
	 */
	public List<SkillSheet> searchProjectOther(SkillSheet skillSheet);

	/**
	 * 案件基本情報取得.
	 * @param skillSheet スキルシートbeanクラス
	 * @return 案件基本情報
	 */
	public List<SkillSheet> searchProject(SkillSheet skillSheet);

	/**
	 * 基本情報取得.
	 * @param userId ユーザーID
	 * @return 基本情報
	 */
	public SkillSheet getSkillSheetBasic(int userId);

	/**
	 * 案件基本情報取得.
	 * @param userId ユーザーID
	 * @return 案件基本情報
	 */
	public List<SkillSheet> getProjectAll(int userId);

	/**
	 * 案件基本取得.
	 * @param skillSheet スキルシートbeanクラス
	 * @return 案件基本
	 */
	public List<SkillSheet> getProject(SkillSheet skillSheet);

	/**
	 * DB情報取得.
	 * @param careerId 経歴ID
	 * @return DB情報
	 */
	public List<SkillSheet> getProjectDB(int careerId);

	/**
	 * FW/NW情報取得.
	 * @param careerId 経歴ID
	 * @return FW/NW情報
	 */
	public List<SkillSheet> getProjectFwNw(int careerId);

	/**
	 * OS情報取得.
	 * @param careerId 経歴ID
	 * @return OS情報
	 */
	public List<SkillSheet> getProjectOS(int careerId);

	/**
	 * 言語情報取得.
	 * @param careerId 経歴ID
	 * @return 言語情報
	 */
	public List<SkillSheet> getProjectLang(int careerId);

	/**
	 * その他情報取得.
	 * @param careerId 経歴ID
	 * @return その他情報
	 */
	public List<SkillSheet> getProjectOther(int careerId);

	/**
	 * 基本情報登録.
	 * @param skillSheet スキルシートbeanクラス
	 */
	public void insertBasicInformation(SkillSheet skillSheet);

	/**
	 * 案件基本情報更新.
	 * @param skillSheet スキルシートbeanクラス
	 */
	public void updateProject(SkillSheet skillSheet);

	/**
	 * 案件基本情報登録.
	 * @param skillSheet スキルシートbeanクラス
	 */
	public void insertProject(SkillSheet skillSheet);

	/**
	 * DB情報登録.
	 * @param skillSheet スキルシートbeanクラス
	 */
	public void insertProjectDB(SkillSheet skillSheet);

	/**
	 * FW/NW情報登録.
	 * @param skillSheet スキルシートbeanクラス
	 */
	public void insertProjectFWNW(SkillSheet skillSheet);

	/**
	 * OS情報登録.
	 * @param skillSheet スキルシートbeanクラス
	 */
	public void insertProjectOS(SkillSheet skillSheet);

	/**
	 * 言語情報登録.
	 * @param skillSheet スキルシートbeanクラス
	 */
	public void insertProjectLang(SkillSheet skillSheet);

	/**
	 * その他情報登録.
	 * @param skillSheet スキルシートbeanクラス
	 */
	public void insertProjectOther(SkillSheet skillSheet);

	/**
	 * 案件経歴情報削除.
	 * @param skillSheet スキルシートbeanクラス
	 */
	public void deleteProjectItems(SkillSheet skillSheet);

	/**
	 * 案件削除.
	 * @param skillSheet スキルシートbeanクラス
	 */
	public void deleteSkillSheetProject(SkillSheet skillSheet);

	/**
	 * ユーザー情報登録.
	 * @param userInformation ユーザー情報beanクラス
	 */
	public void insertUserInformation(UserInformation userInformation);

	/**
	 * ユーザー情報更新.
	 * @param userInformation ユーザー情報beanクラス
	 */
	public int updateUserInformation(UserInformation userInformation);

	/**
	 * ユーザー情報削除.
	 * @param userInformation ユーザー情報beanクラス
	 */
	public void deleteUserInformation(UserInformation userInformation);

	/**
	 * スキルプルダウンDB情報取得.
	 * @return スキルシートbeanクラス
	 */
	public List<SkillSheet> getPulldownProjectDB();

	/**
	 * スキルプルダウンFW/NW情報取得.
	 * @return スキルシートbeanクラス
	 */
	public List<SkillSheet> getPulldownProjectFWNW();

	/**
	 * スキルプルダウンOS情報取得.
	 * @return スキルシートbeanクラス
	 */
	public List<SkillSheet> getPulldownProjectOS();

	/**
	 * スキルプルダウン言語情報取得.
	 * @return スキルシートbeanクラス
	 */
	public List<SkillSheet> getPulldownProjectLang();

	/**
	 * スキルプルダウンその他情報取得.
	 * @return スキルシートbeanクラス
	 */
	public List<SkillSheet> getPulldownProjectOther();

	/**
	 * ユーザー情報ユーザーID取得
	 * @param userMail ログインユーザーメールアドレス
	 * @return ユーザー情報beanクラス
	 */
	public UserInformation getUserId(String userMail);

	/**
	 * ユーザー情報取得
	 * @param userId ユーザーID
	 * @return ユーザー情報beanクラス
	 */
	public UserInformation getUserInformation(int userId);

	/**
	 * 全ユーザーを検索.
	 * @return スキルシートbeanクラス
	 */
	public List<UserInformation> searchAllUser();

	/**
	 * ユーザーを検索.
	 * @return スキルシートbeanクラス
	 */
	public UserInformation searchUserIndividual(int userId);

	/**
	 * 権限情報更新.
	 * @param userInformation ユーザー情報
	 * @return 更新件数
	 */
	public int updateUserRole(UserInformation userInformation);



}
