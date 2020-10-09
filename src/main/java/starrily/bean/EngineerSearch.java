package starrily.bean;

import lombok.Data;

@Data
public class EngineerSearch {

	private String[] item;

	private String[] detail;

	private String[] ver;

	private Integer[] years;

	private String industry;

	private String position;

	private String[] chargePhase;

	private UserInformation userInformation;

}
