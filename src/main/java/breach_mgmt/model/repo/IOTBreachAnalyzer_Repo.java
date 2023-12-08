package breach_mgmt.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import breach_mgmt.model.master.IOTAssetReading;

@Transactional(propagation=Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
@Repository("iotBreachAnalyzerRepo")
public interface IOTBreachAnalyzer_Repo extends JpaRepository<IOTAssetReading, Long> 
{
	@Query(value = "select * from IOT_ASSET_READINGS where upper(trim(doneflag)) <> 'Y' order by READING_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<IOTAssetReading> getReadingsNotDone();
	
	@Query(value = "select * from IOT_ASSET_READINGS where upper(trim(processedflag)) <> 'Y' order by READING_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<IOTAssetReading> getReadingsNotProcessed();
		
	@Modifying
	@Query(value = "update IOT_ASSET_READINGS set doneflag = 'Y' where reading_seq_no = :reading_seq_no", nativeQuery = true)
	void setDoneFlag(@Param("reading_seq_no") Long reading_seq_no);
	
	
}