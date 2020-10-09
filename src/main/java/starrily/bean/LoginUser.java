package starrily.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginUser implements Serializable {

	/** シリアルバージョンUID. */
	private static final long serialVersionUID = 8444619492973941168L;

	/** ユーザーメールアドレス */
	private String userMail;
}
