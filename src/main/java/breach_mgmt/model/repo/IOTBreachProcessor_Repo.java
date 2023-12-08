package breach_mgmt.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import breach_mgmt.model.master.IOTAssetReadingBreach;
import breach_mgmt.model.master.IOTAssetReadingBreachPK;

@Transactional(propagation=Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
@Repository("iotBreachProcessorRepo")
public interface IOTBreachProcessor_Repo extends JpaRepository<IOTAssetReadingBreach, IOTAssetReadingBreachPK> 
{
	@Modifying
	@Query(value = "update IOT_ASSETREADING_BREACH set actual_badctr = actual_badctr where ( RES_RULE_LINE_SEQ_NO = :resRuleLineSeqNo and SENSOR_ASSET_SEQ_NO = :sensorAssetSeqNo)", nativeQuery = true)
	void incBadCtr(@Param("resRuleLineSeqNo") Long resRuleLineSeqNo, @Param("sensorAssetSeqNo") Long sensorAssetSeqNo);

	@Modifying
	@Query(value = "update IOT_ASSETREADING_BREACH set actual_badctr = 0 where ( RES_RULE_LINE_SEQ_NO = :resRuleLineSeqNo and SENSOR_ASSET_SEQ_NO = :sensorAssetSeqNo)", nativeQuery = true)
	void initBadCtr(@Param("resRuleLineSeqNo") Long resRuleLineSeqNo, @Param("sensorAssetSeqNo") Long sensorAssetSeqNo);

	@Query(value = "select breach_params from IOT_ASSETREADING_BREACH where ( RES_RULE_LINE_SEQ_NO = :resRuleLineSeqNo and SENSOR_ASSET_SEQ_NO = :sensorAssetSeqNo)", nativeQuery = true)
	String getParamString(@Param("resRuleLineSeqNo") Long resRuleLineSeqNo, @Param("sensorAssetSeqNo") Long sensorAssetSeqNo);	

	@Query(value = "select * from IOT_ASSETREADING_BREACH where actual_badctr > 0 orderby ", nativeQuery = true)
	String getBadCtrs();	

}