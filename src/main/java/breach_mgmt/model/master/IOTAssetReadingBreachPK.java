package breach_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the IOT_ASSETREADING_BREACH database table.
 * 
 */
@Embeddable
public class IOTAssetReadingBreachPK implements Serializable 
{
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "RES_RULE_LINE_SEQ_NO")
	private Long resRuleLineSeqNo;

	@Column(name = "SENSOR_ASSET_SEQ_NO")
	private Long sensorAssetSeqNo;

	public IOTAssetReadingBreachPK() {
	}

	public Long getResRuleLineSeqNo() {
		return this.resRuleLineSeqNo;
	}

	public void setResRuleLineSeqNo(Long resRuleLineSeqNo) {
		this.resRuleLineSeqNo = resRuleLineSeqNo;
	}

	public Long getSensorAssetSeqNo() {
		return this.sensorAssetSeqNo;
	}

	public void setSensorAssetSeqNo(Long sensorAssetSeqNo) {
		this.sensorAssetSeqNo = sensorAssetSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof IOTAssetReadingBreachPK)) {
			return false;
		}
		IOTAssetReadingBreachPK castOther = (IOTAssetReadingBreachPK) other;
		return (this.resRuleLineSeqNo == castOther.resRuleLineSeqNo)
				&& (this.sensorAssetSeqNo == castOther.sensorAssetSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.resRuleLineSeqNo ^ (this.resRuleLineSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.sensorAssetSeqNo ^ (this.sensorAssetSeqNo >>> 32)));

		return hash;
	}

	public IOTAssetReadingBreachPK(Long resRuleLineSeqNo, Long sensorAssetSeqNo) {
		super();
		this.resRuleLineSeqNo = resRuleLineSeqNo;
		this.sensorAssetSeqNo = sensorAssetSeqNo;
	}

}