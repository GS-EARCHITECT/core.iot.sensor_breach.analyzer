package breach_mgmt.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import breach_mgmt.model.master.ResMetricRuleDetail;

@Repository("iotResMetricRuleDetailsAdminRepo")
public interface ResMetricRuleDetailsAdmin_Repo extends JpaRepository<ResMetricRuleDetail, Long> 
{
@Query(value = "select * from IOT_RESRULES_DETAILS b where b.RESMEASURE_SEQ_NO = :resMeasureSeqNo orderby IOT_RULE_SEQ_NO", nativeQuery = true)
public CopyOnWriteArrayList<ResMetricRuleDetail> getSelectMetricRulesByResMeasure(@Param("resMeasureSeqNo") Long resMeasureSeqNo);
	
}