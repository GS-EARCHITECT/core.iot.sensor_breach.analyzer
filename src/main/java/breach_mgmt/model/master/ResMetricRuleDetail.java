package breach_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the IOT_RESRULES_DETAILS database table.
 * 
 */
@Entity
@Table(name = "IOT_RESRULES_DETAILS")
public class ResMetricRuleDetail implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESMETRICRULEDET_SEQ")
	@SequenceGenerator(name = "RESMETRICRULEDET_SEQ", sequenceName = "RESMETRICRULEDET_SEQ", allocationSize = 1)
	@Column(name = "RES_RULE_LINE_SEQ_NO")
	private Long resRuleLineSeqNo;

	@Column(name = "CUSTOM_METHOD_NAME")
	private String customMethodName;

	@Column(name = "CUSTOM_PROGRAM_NAME")
	private String customProgramName;

	@Column(name = "FULLPATH")
	private String fullpath;

	@Column(name = "IOT_RULE_SEQ_NO")
	private Long iotRuleSeqNo;

	@Column(name = "RESMEASURE_SEQ_NO")
	private Long resmeasureSeqNo;

	public ResMetricRuleDetail() {
	}

	public Long getResMetricRuleLineSeqNo() {
		return this.resRuleLineSeqNo;
	}

	public void setResMetricRuleLineSeqNo(Long resRuleLineSeqNo) {
		this.resRuleLineSeqNo = resRuleLineSeqNo;
	}

	public String getCustomMethodName() {
		return this.customMethodName;
	}

	public void setCustomMethodName(String customMethodName) {
		this.customMethodName = customMethodName;
	}

	public String getCustomProgramName() {
		return this.customProgramName;
	}

	public void setCustomProgramName(String customProgramName) {
		this.customProgramName = customProgramName;
	}

	public String getFullpath() {
		return this.fullpath;
	}

	public void setFullpath(String fullpath) {
		this.fullpath = fullpath;
	}

	public Long getRuleSeqNo() {
		return this.iotRuleSeqNo;
	}

	public void setRuleSeqNo(Long iotRuleSeqNo) {
		this.iotRuleSeqNo = iotRuleSeqNo;
	}

	public Long getResmeasureSeqNo() {
		return this.resmeasureSeqNo;
	}

	public void setResmeasureSeqNo(Long resmeasureSeqNo) {
		this.resmeasureSeqNo = resmeasureSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iotRuleSeqNo == null) ? 0 : iotRuleSeqNo.hashCode());
		result = prime * result + ((resRuleLineSeqNo == null) ? 0 : resRuleLineSeqNo.hashCode());
		result = prime * result + ((resmeasureSeqNo == null) ? 0 : resmeasureSeqNo.hashCode());
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
		ResMetricRuleDetail other = (ResMetricRuleDetail) obj;
		if (iotRuleSeqNo == null) {
			if (other.iotRuleSeqNo != null)
				return false;
		} else if (!iotRuleSeqNo.equals(other.iotRuleSeqNo))
			return false;
		if (resRuleLineSeqNo == null) {
			if (other.resRuleLineSeqNo != null)
				return false;
		} else if (!resRuleLineSeqNo.equals(other.resRuleLineSeqNo))
			return false;
		if (resmeasureSeqNo == null) {
			if (other.resmeasureSeqNo != null)
				return false;
		} else if (!resmeasureSeqNo.equals(other.resmeasureSeqNo))
			return false;
		return true;
	}

	public ResMetricRuleDetail(Long resRuleLineSeqNo, String customMethodName, String customProgramName, String fullpath,
			Long iotRuleSeqNo, Long resmeasureSeqNo) {
		super();
		this.resRuleLineSeqNo = resRuleLineSeqNo;
		this.customMethodName = customMethodName;
		this.customProgramName = customProgramName;
		this.fullpath = fullpath;
		this.iotRuleSeqNo = iotRuleSeqNo;
		this.resmeasureSeqNo = resmeasureSeqNo;
	}

}