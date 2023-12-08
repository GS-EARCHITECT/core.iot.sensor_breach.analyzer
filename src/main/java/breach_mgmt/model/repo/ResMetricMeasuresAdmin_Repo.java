package breach_mgmt.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import breach_mgmt.model.master.ResMetricMeasure;

@Repository("iotResMetricMeasuresAdminRepo")
public interface ResMetricMeasuresAdmin_Repo extends JpaRepository<ResMetricMeasure, Long> 
{
	@Query(value = "select * from IOT_RESMETRIC_MEASURES b where b.RESOURCE_SEQ_NO in :resSeqNoList orderby RESMEASURE_SEQ_NO", nativeQuery = true)
	public CopyOnWriteArrayList<ResMetricMeasure> getSelectMeasuresByResources(@Param("resSeqNoList") CopyOnWriteArrayList<Long> resSeqNoList);
	
	@Query(value = "select * from IOT_RESMETRIC_MEASURES b where b.RESOURCE_SEQ_NO in :resSeqNo orderby RESMEASURE_SEQ_NO", nativeQuery = true)
	public CopyOnWriteArrayList<ResMetricMeasure> getSelectMeasuresByResource(@Param("resSeqNo") Long resSeqNo);
		
}