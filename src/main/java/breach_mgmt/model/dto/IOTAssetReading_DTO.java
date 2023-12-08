package breach_mgmt.model.dto;

import java.io.Serializable;

public class IOTAssetReading_DTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2775278482981932188L;
	private Long readingSeqNo;
	private Long assetSeqNo;
	private String onDttm;
	private Float reading;
	private Long sensorAssetSeqNo;

	public Long getReadingSeqNo() {
		return readingSeqNo;
	}

	public void setReadingSeqNo(Long readingSeqNo) {
		this.readingSeqNo = readingSeqNo;
	}

	public Long getAssetSeqNo() {
		return assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public String getOnDttm() {
		return onDttm;
	}

	public void setOnDttm(String onDttm) {
		this.onDttm = onDttm;
	}

	public Float getReading() {
		return reading;
	}

	public void setReading(Float reading) {
		this.reading = reading;
	}

	public Long getSensorAssetSeqNo() {
		return sensorAssetSeqNo;
	}

	public void setSensorAssetSeqNo(Long sensorAssetSeqNo) {
		this.sensorAssetSeqNo = sensorAssetSeqNo;
	}

	public IOTAssetReading_DTO(Long readingSeqNo, Long assetSeqNo, String onDttm, Float reading,
			Long sensorAssetSeqNo) {
		super();
		this.readingSeqNo = readingSeqNo;
		this.assetSeqNo = assetSeqNo;
		this.onDttm = onDttm;
		this.reading = reading;
		this.sensorAssetSeqNo = sensorAssetSeqNo;
	}

	public IOTAssetReading_DTO() {
		super();
	}

}