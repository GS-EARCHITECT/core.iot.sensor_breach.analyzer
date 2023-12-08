package breach_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the IOT_ASSET_READINGS database table.
 * 
 */
@Entity
@Table(name = "IOT_ASSET_READINGS")
public class IOTAssetReading implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 977215784950570440L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "READING_SEQUENCE_NO")
	@SequenceGenerator(name = "READING_SEQUENCE_NO", sequenceName = "READING_SEQUENCE_NO", allocationSize = 1)
	@Column(name = "READING_SEQ_NO")
	private Long readingSeqNo;

	@Column(name = "ASSET_SEQ_NO")
	private Long assetSeqNo;

	@Column(name = "ON_DTTM")
	private Timestamp onDttm;

	@Column(name = "READING")
	private Float reading;

	@Column(name = "SENSOR_ASSET_SEQ_NO")
	private Long sensorAssetSeqNo;

	@Column(name = "RESMEASURE_SEQ_NO")
	private Long resMeasureSeqNo;

	public IOTAssetReading() {
	}

	public Long getReadingSeqNo() {
		return this.readingSeqNo;
	}

	public void setReadingSeqNo(Long readingSeqNo) {
		this.readingSeqNo = readingSeqNo;
	}

	public Long getAssetSeqNo() {
		return this.assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public Timestamp getOnDttm() {
		return this.onDttm;
	}

	public void setOnDttm(Timestamp onDttm) {
		this.onDttm = onDttm;
	}

	public Float getReading() {
		return this.reading;
	}

	public void setReading(Float reading) {
		this.reading = reading;
	}

	public Long getSensorAssetSeqNo() {
		return this.sensorAssetSeqNo;
	}

	public void setSensorAssetSeqNo(Long sensorAssetSeqNo) {
		this.sensorAssetSeqNo = sensorAssetSeqNo;
	}

	public Long getResMeasureSeqNo() {
		return resMeasureSeqNo;
	}

	public void setResMeasureSeqNo(Long resMeasureSeqNo) {
		this.resMeasureSeqNo = resMeasureSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetSeqNo == null) ? 0 : assetSeqNo.hashCode());
		result = prime * result + ((resMeasureSeqNo == null) ? 0 : resMeasureSeqNo.hashCode());
		result = prime * result + ((sensorAssetSeqNo == null) ? 0 : sensorAssetSeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IOTAssetReading other = (IOTAssetReading) obj;
		if (assetSeqNo == null) {
			if (other.assetSeqNo != null)
				return false;
		} else if (!assetSeqNo.equals(other.assetSeqNo))
			return false;
		if (resMeasureSeqNo == null) {
			if (other.resMeasureSeqNo != null)
				return false;
		} else if (!resMeasureSeqNo.equals(other.resMeasureSeqNo))
			return false;
		if (sensorAssetSeqNo == null) {
			if (other.sensorAssetSeqNo != null)
				return false;
		} else if (!sensorAssetSeqNo.equals(other.sensorAssetSeqNo))
			return false;
		return true;
	}

	public IOTAssetReading(Long readingSeqNo, Long assetSeqNo, Timestamp onDttm, Float reading, Long sensorAssetSeqNo,
			Long resMeasureSeqNo) {
		super();
		this.readingSeqNo = readingSeqNo;
		this.assetSeqNo = assetSeqNo;
		this.onDttm = onDttm;
		this.reading = reading;
		this.sensorAssetSeqNo = sensorAssetSeqNo;
		this.resMeasureSeqNo = resMeasureSeqNo;
	}

}