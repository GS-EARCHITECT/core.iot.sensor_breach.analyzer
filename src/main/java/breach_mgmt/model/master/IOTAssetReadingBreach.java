package breach_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the IOT_ASSETREADING_BREACH database table.
 * 
 */
@Entity
@Table(name = "IOT_ASSETREADING_BREACH")
public class IOTAssetReadingBreach implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IOTAssetReadingBreachPK id;

	@Column(name = "BREACH_BADCTR")
	private Float breach_badctr;

	@Column(name = "ACTUAL_BADCTR")
	private Float actual_badctr;

	@Column(name = "COMMAND_STRING")
	private String commandString;

	@Column(name = "GOODCTR")
	private String goodctr;

	@Column(name = "BREACH_PARAMS")
	private String breachParams;

	public IOTAssetReadingBreach() {
	}

	public IOTAssetReadingBreachPK getId() {
		return this.id;
	}

	public void setId(IOTAssetReadingBreachPK id) {
		this.id = id;
	}

	public String getGoodctr() {
		return this.goodctr;
	}

	public void setGoodctr(String goodctr) {
		this.goodctr = goodctr;
	}

	public Float getBreach_badctr() {
		return breach_badctr;
	}

	public void setBreach_badctr(Float breach_badctr) {
		this.breach_badctr = breach_badctr;
	}

	public Float getActual_badctr() {
		return actual_badctr;
	}

	public void setActual_badctr(Float actual_badctr) {
		this.actual_badctr = actual_badctr;
	}

	public String getBreachParams() {
		return breachParams;
	}

	public void setBreachParams(String breachParams) {
		this.breachParams = breachParams;
	}

	public String getCommandString() {
		return commandString;
	}

	public void setCommandString(String commandString) {
		this.commandString = commandString;
	}

	public IOTAssetReadingBreach(IOTAssetReadingBreachPK id, Float breach_badctr, Float actual_badctr,
			String commandString, String goodctr, String breachParams) {
		super();
		this.id = id;
		this.breach_badctr = breach_badctr;
		this.actual_badctr = actual_badctr;
		this.commandString = commandString;
		this.goodctr = goodctr;
		this.breachParams = breachParams;
	}

}