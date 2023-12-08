package breach_mgmt.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import breach_mgmt.model.master.IOTAssetReading;

@Repository("iotSensorReadingRepo")
public interface IOTSensorReading_Repo extends JpaRepository<IOTAssetReading, Long> 
{
	@Modifying
	@Query(value = "update IOT_ASSET_READINGS set doneflag = 'Y' where reading_seq_no = :reading_seq_no", nativeQuery = true)
	void setDoneFlag(@Param("reading_seq_no") Long reading_seq_no);
	
}