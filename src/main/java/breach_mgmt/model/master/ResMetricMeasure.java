package breach_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the _RESMETRIC_MEASURES database table.
 * 
 */
@Entity
@Table(name = "IOT_RESMETRIC_MEASURES")
public class ResMetricMeasure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESMETRIC_SEQUENCE")
	@SequenceGenerator(name = "RESMETRIC_SEQUENCE", sequenceName = "RESMETRIC_SEQUENCE", allocationSize = 1)
	@Column(name = "RESMEASURE_SEQ_NO")
	private Long resmeasureSeqNo;

	@Column(name = "FIELD_SEQ_NO")
	private Long fieldSeqNo;

	@Column(name = "RESOURCE_SEQ_NO")
	private Long resourceSeqNo;

	@Column(name = "UOM_SEQ_NO")
	private Long uomSeqNo;

	public ResMetricMeasure() {
	}

	public Long getResmeasureSeqNo() {
		return this.resmeasureSeqNo;
	}

	public void setResmeasureSeqNo(Long resmeasureSeqNo) {
		this.resmeasureSeqNo = resmeasureSeqNo;
	}

	public Long getFieldSeqNo() {
		return this.fieldSeqNo;
	}

	public void setFieldSeqNo(Long fieldSeqNo) {
		this.fieldSeqNo = fieldSeqNo;
	}

	public Long getResourceSeqNo() {
		return this.resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public Long getUomSeqNo() {
		return this.uomSeqNo;
	}

	public void setUomSeqNo(Long uomSeqNo) {
		this.uomSeqNo = uomSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((resmeasureSeqNo == null) ? 0 : resmeasureSeqNo.hashCode());
		result = prime * result + ((resourceSeqNo == null) ? 0 : resourceSeqNo.hashCode());
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
		ResMetricMeasure other = (ResMetricMeasure) obj;
		if (resmeasureSeqNo == null) {
			if (other.resmeasureSeqNo != null)
				return false;
		} else if (!resmeasureSeqNo.equals(other.resmeasureSeqNo))
			return false;
		if (resourceSeqNo == null) {
			if (other.resourceSeqNo != null)
				return false;
		} else if (!resourceSeqNo.equals(other.resourceSeqNo))
			return false;
		return true;
	}

	public ResMetricMeasure(Long resmeasureSeqNo, Long fieldSeqNo, Long resourceSeqNo, Long uomSeqNo) {
		super();
		this.resmeasureSeqNo = resmeasureSeqNo;
		this.fieldSeqNo = fieldSeqNo;
		this.resourceSeqNo = resourceSeqNo;
		this.uomSeqNo = uomSeqNo;
	}

}