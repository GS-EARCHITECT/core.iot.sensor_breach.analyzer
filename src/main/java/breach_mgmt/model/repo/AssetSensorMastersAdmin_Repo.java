package breach_mgmt.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import breach_mgmt.model.master.AssetSensorMaster;

@Transactional(propagation=Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
@Repository("assetSensorMastersAdminRepo")
public interface AssetSensorMastersAdmin_Repo extends JpaRepository<AssetSensorMaster, Long> 
{}