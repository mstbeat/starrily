package starrily.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class Dropdown implements Serializable {

	/** シリアルバージョンUID. */
	private static final long serialVersionUID = 1L;
	/** ドロップダウン ナンバー */
	private int itemNumber;
	/** ドロップダウン 名前*/
	private String itemName;
	/** ドロップダウン コード*/
	private String itemCode;


}
