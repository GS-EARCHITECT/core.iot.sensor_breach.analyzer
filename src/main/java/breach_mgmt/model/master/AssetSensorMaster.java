package breach_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the IOT_ASSETSENSOR_MASTER database table.
 * 
 */
@Entity
@Table(name="IOT_ASSETSENSOR_MASTER")
public class AssetSensorMaster implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SENSOR_ASSET_SEQUENCE")
	@SequenceGenerator(name = "SENSOR_ASSET_SEQUENCE", sequenceName = "SENSOR_ASSET_SEQUENCE", allocationSize = 1)
	@Column(name="SENSOR_ASSET_SEQ_NO")
	private Long sensorAssetSeqNo;

	@Column(name="SENSOR_RESOURCE_SEQ_NO")
	private Long sensorResourceSeqNo;
	
	@Column(name="ASSET_SEQ_NO")
	private Long assetSeqNo;

	@Column(name="RESOURCE_SEQ_NO")
	private Long resourceSeqNo;
		
	@Column(name="LOCATION_SEQ_NO")
	private Long locationSeqNo;

	@Column(name="SENSOR_LOCATION_SEQ_NO")
	private Long sensorLocationSeqNo;

	public AssetSensorMaster() {
	}

	public Long getSensorAssetSeqNo() {
		return this.sensorAssetSeqNo;
	}

	public void setSensorAssetSeqNo(Long sensorAssetSeqNo) {
		this.sensorAssetSeqNo = sensorAssetSeqNo;
	}

	public Long getAssetSeqNo() {
		return this.assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public Long getLocationSeqNo() {
		return this.locationSeqNo;
	}

	public void setLocationSeqNo(Long locationSeqNo) {
		this.locationSeqNo = locationSeqNo;
	}

	public Long getSensorLocationSeqNo() {
		return this.sensorLocationSeqNo;
	}

	public void setSensorLocationSeqNo(Long sensorLocationSeqNo) {
		this.sensorLocationSeqNo = sensorLocationSeqNo;
	}

	public Long getSensorResourceSeqNo() {
		return sensorResourceSeqNo;
	}

	public void setSensorResourceSeqNo(Long sensorResourceSeqNo) {
		this.sensorResourceSeqNo = sensorResourceSeqNo;
	}

	public Long getResourceSeqNo() {
		return resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetSeqNo == null) ? 0 : assetSeqNo.hashCode());
		result = prime * result + ((resourceSeqNo == null) ? 0 : resourceSeqNo.hashCode());
		result = prime * result + ((sensorAssetSeqNo == null) ? 0 : sensorAssetSeqNo.hashCode());
		result = prime * result + ((sensorResourceSeqNo == null) ? 0 : sensorResourceSeqNo.hashCode());
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
		AssetSensorMaster other = (AssetSensorMaster) obj;
		if (assetSeqNo == null) {
			if (other.assetSeqNo != null)
				return false;
		} else if (!assetSeqNo.equals(other.assetSeqNo))
			return false;
		if (resourceSeqNo == null) {
			if (other.resourceSeqNo != null)
				return false;
		} else if (!resourceSeqNo.equals(other.resourceSeqNo))
			return false;
		if (sensorAssetSeqNo == null) {
			if (other.sensorAssetSeqNo != null)
				return false;
		} else if (!sensorAssetSeqNo.equals(other.sensorAssetSeqNo))
			return false;
		if (sensorResourceSeqNo == null) {
			if (other.sensorResourceSeqNo != null)
				return false;
		} else if (!sensorResourceSeqNo.equals(other.sensorResourceSeqNo))
			return false;
		return true;
	}

	public AssetSensorMaster(Long sensorAssetSeqNo, Long sensorResourceSeqNo, Long assetSeqNo, Long resourceSeqNo,
			Long locationSeqNo, Long sensorLocationSeqNo) {
		super();
		this.sensorAssetSeqNo = sensorAssetSeqNo;
		this.sensorResourceSeqNo = sensorResourceSeqNo;
		this.assetSeqNo = assetSeqNo;
		this.resourceSeqNo = resourceSeqNo;
		this.locationSeqNo = locationSeqNo;
		this.sensorLocationSeqNo = sensorLocationSeqNo;
	}


	
	
}