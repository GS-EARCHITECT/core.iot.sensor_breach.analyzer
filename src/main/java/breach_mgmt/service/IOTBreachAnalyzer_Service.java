package breach_mgmt.service;

import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import breach_mgmt.model.master.IOTAssetReading;
import breach_mgmt.model.repo.IOTBreachAnalyzer_Repo;
import breach_mgmt.model.repo.IOTSensorReading_Repo;

@Service("IOTBreachAnalyzerServ")
public class IOTBreachAnalyzer_Service 
{
	private static final Logger logger = LoggerFactory.getLogger(IOTBreachAnalyzer_Service.class);

	@Autowired
	private IOTBreachAnalyzer_Repo iotBreachAnalyzerRepo;
	
	@Autowired
	private IOTAnalyzeReading_Service iotAnalyzeReadingServ;
	
	@Autowired
	private	IOTSensorReading_Repo iotSensorReadingRepo;
	
	@Scheduled(fixedRate = 3000)
	public void inputReading() 
	{
		CopyOnWriteArrayList<IOTAssetReading> iotAssetReadings = iotBreachAnalyzerRepo.getReadingsNotDone();

		if (iotAssetReadings != null && iotAssetReadings.size() > 0) {
			logger.info("running for size :" + iotAssetReadings.size());

			for (int i = 0; i < iotAssetReadings.size(); i++) 
			{
			iotAnalyzeReadingServ.analyzeReading(iotAssetReadings.get(i));
			iotSensorReadingRepo.setDoneFlag(iotAssetReadings.get(i).getReadingSeqNo());
			}
		}
		return;

	}

}