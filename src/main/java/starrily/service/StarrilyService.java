package starrily.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import starrily.bean.Dropdown;
import starrily.bean.SkillSheet;
import starrily.bean.UserInformation;
import starrily.mapper.starrilydb.StarrilyMapper;

/**
 * Serviceクラス.
 * @author yu.yamamoto
 * @version 1.0.0
 */
@Service
public class StarrilyService {

	@Autowired
	StarrilyMapper starrilyMapper;

	/**
	* ドロップダウン情報.
	* @param itemNumber ドロップダウンテーブルのitem_numberの値
	* @return スキルシートbeanクラス
	*/
	public List<Dropdown> getDropdownInfo(int itemNumber) {
		return starrilyMapper.getDropdownInfo(itemNumber);
	}

	/**
	* 基本情報更新.
	* @param skillSheet スキルシートbeanクラス
	* @return スキルシートbeanクラス
	*/
	@Transactional
	public int updateBasicInformation(SkillSheet skillSheet) {
		return starrilyMapper.updateBasicInformation(skillSheet);
	}

	/**
	 * 権限情報取得.
	 * @param userId ユーザーId
	 * @return 権限情報
	 */
	public int getUserRole(int userId) {
		return starrilyMapper.getUserRole(userId);
	}

	/**
	 * DB情報検索.
	 * @param skillSheet スキルシートbeanクラス
	 * @return DB情報
	 */
	public List<SkillSheet> searchProjectDB(SkillSheet skillSheet) {
		return starrilyMapper.searchProjectDB(skillSheet);
	}

	/**
	 * FW/NW情報検索.
	 * @param skillSheet スキルシートbeanクラス
	 * @return FW/NW情報
	 */
	public List<SkillSheet> searchProjectFWNW(SkillSheet skillSheet) {
		return starrilyMapper.searchProjectFWNW(skillSheet);
	}

	/**
	 * OS情報検索.
	 * @param skillSheet スキルシートbeanクラス
	 * @return OS情報
	 */
	public List<SkillSheet> searchProjectOS(SkillSheet skillSheet) {
		return starrilyMapper.searchProjectOS(skillSheet);
	}

	/**
	 * 言語情報検索.
	 * @param skillSheet スキルシートbeanクラス
	 * @return 言語情報
	 */
	public List<SkillSheet> searchProjectLang(SkillSheet skillSheet) {
		return starrilyMapper.searchProjectLang(skillSheet);
	}

	/**
	 * その他情報検索.
	 * @param skillSheet スキルシートbeanクラス
	 * @return その他情報
	 */
	public List<SkillSheet> searchProjectOther(SkillSheet skillSheet) {
		return starrilyMapper.searchProjectOther(skillSheet);
	}

	/**
	 * 案件基本情報取得.
	 * @param skillSheet スキルシートbeanクラス
	 * @return 案件基本情報
	 */
	public List<SkillSheet> searchProject(SkillSheet skillSheet) {
		return starrilyMapper.searchProject(skillSheet);
	}

	/**
	 * 基本情報取得.
	 * @param userId ユーザーID
	 * @return 基本情報
	 */
	public SkillSheet getSkillSheetBasic(int userId) {
		return starrilyMapper.getSkillSheetBasic(userId);
	}

	/**
	 * 案件基本情報取得.
	 * @param userId ユーザーID
	 * @return 案件基本情報
	 */
	public List<SkillSheet> getProjectAll(int userId) {
		return starrilyMapper.getProjectAll(userId);
	}

	/**
	 * 案件基本取得.
	 * @param skillSheet スキルシートbeanクラス
	 * @return 案件基本
	 */
	public List<SkillSheet> getProject(SkillSheet skillSheet) {
		return starrilyMapper.getProject(skillSheet);
	}

	/**
	 * DB情報取得.
	 * @param careerId 経歴ID
	 * @return DB情報
	 */
	public List<SkillSheet> getProjectDB(int careerId) {
		return starrilyMapper.getProjectDB(careerId);
	}

	/**
	 * FW/NW情報取得.
	 * @param careerId 経歴ID
	 * @return FW/NW情報
	 */
	public List<SkillSheet> getProjectFwNw(int careerId) {
		return starrilyMapper.getProjectFwNw(careerId);
	}

	/**
	 * OS情報取得.
	 * @param careerId 経歴ID
	 * @return OS情報
	 */
	public List<SkillSheet> getProjectOS(int careerId) {
		return starrilyMapper.getProjectOS(careerId);

	}

	/**
	 * 言語情報取得.
	 * @param careerId 経歴ID
	 * @return 言語情報
	 */
	public List<SkillSheet> getProjectLang(int careerId) {
		return starrilyMapper.getProjectLang(careerId);
	}

	/**
	 * その他情報取得.
	 * @param careerId 経歴ID
	 * @return その他情報
	 */
	public List<SkillSheet> getProjectOther(int careerId) {
		return starrilyMapper.getProjectOther(careerId);
	}

	/**
	 * 基本情報登録.
	 * @param skillSheet スキルシートbeanクラス
	 */
	public void insertBasicInformation(SkillSheet skillSheet) {
		starrilyMapper.insertBasicInformation(skillSheet);
	}

	/**
	 * 案件基本情報更新.
	 * @param skillSheet スキルシートbeanクラス
	 */
	public void updateProject(SkillSheet skillSheet) {
		starrilyMapper.updateProject(skillSheet);
	}

	/**
	 * 案件基本情報登録.
	 * @param skillSheet スキルシートbeanクラス
	 */
	public void insertProject(SkillSheet skillSheet) {
		starrilyMapper.insertProject(skillSheet);
	}

	/**
	 * DB情報登録.
	 * @param skillSheet スキルシートbeanクラス
	 */
	public void insertProjectDB(SkillSheet skillSheet) {
		starrilyMapper.insertProjectDB(skillSheet);
	}

	/**
	 * FW/NW情報登録.
	 * @param skillSheet スキルシートbeanクラス
	 */
	public void insertProjectFWNW(SkillSheet skillSheet) {
		starrilyMapper.insertProjectFWNW(skillSheet);
	}

	/**
	 * OS情報登録.
	 * @param skillSheet スキルシートbeanクラス
	 */
	public void insertProjectOS(SkillSheet skillSheet) {
		starrilyMapper.insertProjectOS(skillSheet);
	}

	/**
	 * 言語情報登録.
	 * @param skillSheet スキルシートbeanクラス
	 */
	public void insertProjectLang(SkillSheet skillSheet) {
		starrilyMapper.insertProjectLang(skillSheet);
	}

	/**
	 * その他情報登録.
	 * @param skillSheet スキルシートbeanクラス
	 */
	public void insertProjectOther(SkillSheet skillSheet) {
		starrilyMapper.insertProjectOther(skillSheet);
	}

	/**
	 * 案件経歴情報削除.
	 * @param skillSheet スキルシートbeanクラス
	 */
	public void deleteProjectItems(SkillSheet skillSheet) {
		starrilyMapper.deleteProjectItems(skillSheet);
	}

	/**
	 * 案件削除.
	 * @param skillSheet スキルシートbeanクラス
	 */
	@Transactional
	public void deleteSkillSheetProject(SkillSheet skillSheet) {
		starrilyMapper.deleteSkillSheetProject(skillSheet);
	}

	/**
	 * ユーザー情報登録.
	 * @param userInformation ユーザー情報beanクラス
	 */
	public void insertUserInformation(UserInformation userInformation) {
		starrilyMapper.insertUserInformation(userInformation);
	}

	/**
	 * ユーザー情報更新.
	 * @param userInformation ユーザー情報beanクラス
	 */
	public int updateUserInformation(UserInformation userInformation) {
		return starrilyMapper.updateUserInformation(userInformation);
	}

	/**
	 * ユーザー情報削除.
	 * @param userInformation ユーザー情報beanクラス
	 */
	public void deleteUserInformation(UserInformation userInformation) {
		starrilyMapper.deleteUserInformation(userInformation);
	}

	/**
	 * スキルプルダウンDB情報取得.
	 * @return スキルシートbeanクラス
	 */
	public List<SkillSheet> getPulldownProjectDB() {
		return starrilyMapper.getPulldownProjectDB();
	}

	/**
	 * スキルプルダウンFW/NW情報取得.
	 * @return スキルシートbeanクラス
	 */
	public List<SkillSheet> getPulldownProjectFWNW() {
		return starrilyMapper.getPulldownProjectFWNW();
	}

	/**
	 * スキルプルダウンOS情報取得.
	 * @return スキルシートbeanクラス
	 */
	public List<SkillSheet> getPulldownProjectOS() {
		return starrilyMapper.getPulldownProjectOS();
	}

	/**
	 * スキルプルダウン言語情報取得.
	 * @return スキルシートbeanクラス
	 */
	public List<SkillSheet> getPulldownProjectLang() {
		return starrilyMapper.getPulldownProjectLang();
	}

	/**
	 * スキルプルダウンその他情報取得.
	 * @return スキルシートbeanクラス
	 */
	public List<SkillSheet> getPulldownProjectOther() {
		return starrilyMapper.getPulldownProjectOther();
	}

	/**
	 * ユーザー情報ユーザーID取得
	 * @param userMail ログインユーザーメールアドレス
	 * @return ユーザー情報beanクラス
	 */
	public UserInformation getUserId(String userMail) {
		return starrilyMapper.getUserId(userMail);
	}

	/**
	 * ユーザー情報取得
	 * @param userId ユーザーID
	 * @return ユーザー情報beanクラス
	 */
	public UserInformation getUserInformation(int userId) {
		return starrilyMapper.getUserInformation(userId);
	}


	public UserInformation searchUserIndividual(int userId) {
		// TODO 自動生成されたメソッド・スタブ
		return starrilyMapper.searchUserIndividual(userId);
	}

	/**
	 * 全ユーザーを検索.
	 * @return スキルシートbeanクラス
	 */
	public List<UserInformation> searchAllUser() {
		return starrilyMapper.searchAllUser();
	}

	/**
	 * 権限情報更新.
	 * @param userInformation ユーザー情報
	 * @return 更新件数
	 */
	public int updateUserRole(UserInformation userInformation) {
		return starrilyMapper.updateUserRole(userInformation);
	}



}
