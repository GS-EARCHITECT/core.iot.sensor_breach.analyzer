package breach_mgmt.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import breach_mgmt.model.master.AssetSensorMaster;
import breach_mgmt.model.master.IOTAssetReading;
import breach_mgmt.model.master.IOTAssetReadingBreachPK;
import breach_mgmt.model.master.ResMetricMeasure;
import breach_mgmt.model.master.ResMetricRuleDetail;
import breach_mgmt.model.repo.AssetSensorMastersAdmin_Repo;
import breach_mgmt.model.repo.IOTBreachProcessor_Repo;
import breach_mgmt.model.repo.ResMetricMeasuresAdmin_Repo;
import breach_mgmt.model.repo.ResMetricRuleDetailsAdmin_Repo;

@Service("iotAnalyzeReadingServ")
public class IOTAnalyzeReading_Service {
	private static final Logger logger = LoggerFactory.getLogger(IOTAnalyzeReading_Service.class);

	@Autowired
	private AssetSensorMastersAdmin_Repo assetSensorMastersAdminRepo;

	@Autowired
	private ResMetricMeasuresAdmin_Repo iotResMetricMeasuresAdminRepo;

	@Autowired
	private IOTBreachProcessor_Repo iotBreachProcessorRepo;

	@Autowired
	private ResMetricRuleDetailsAdmin_Repo iotResMetricRuleDetailsAdminRepo;

	@Async
	public synchronized void analyzeReading(IOTAssetReading iotAssetReading) {
		Optional<AssetSensorMaster> assetSensorMaster = assetSensorMastersAdminRepo
				.findById(iotAssetReading.getSensorAssetSeqNo());
		CopyOnWriteArrayList<ResMetricMeasure> resMeasuresList = null;

		if (assetSensorMaster.get() != null) {
			resMeasuresList = iotResMetricMeasuresAdminRepo
					.getSelectMeasuresByResource(assetSensorMaster.get().getResourceSeqNo());
			CopyOnWriteArrayList<ResMetricRuleDetail> ruleSeqList = null;

			for (int i = 0; i < resMeasuresList.size(); i++) {
				ruleSeqList = iotResMetricRuleDetailsAdminRepo
						.getSelectMetricRulesByResMeasure(resMeasuresList.get(i).getResmeasureSeqNo());

				processRules(ruleSeqList, iotAssetReading);
			}
		}
		return;
	}

	@Async
	public synchronized void processRules(CopyOnWriteArrayList<ResMetricRuleDetail> ruleSeqList,
			IOTAssetReading iotAssetReading) {
		String methodName = "";
		String className = "";
		Method method = null;
		Class<?> classRef = null;
		Object instance = null;
		Integer badCtrFlag = 0;
		String paramString = null;
		IOTAssetReadingBreachPK iotAssetReadingBreachPK = null;

		for (int i = 0; i < ruleSeqList.size(); i++) {
			className = ruleSeqList.get(i).getCustomProgramName().trim();
			methodName = ruleSeqList.get(i).getCustomMethodName().trim();
			paramString = iotBreachProcessorRepo.getParamString(ruleSeqList.get(i).getResMetricRuleLineSeqNo(),
					iotAssetReading.getSensorAssetSeqNo());

			try {
				classRef = Class.forName(className);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				instance = classRef.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				method = classRef.getDeclaredMethod(methodName, IOTAssetReading.class, String.class);
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				Object value = method.invoke(instance, iotAssetReading, paramString);
				badCtrFlag = (Integer) value;

				if (badCtrFlag > 0) {
					iotAssetReadingBreachPK = new IOTAssetReadingBreachPK();
					iotAssetReadingBreachPK.setResRuleLineSeqNo(ruleSeqList.get(i).getResMetricRuleLineSeqNo());
					iotAssetReadingBreachPK.setSensorAssetSeqNo(iotAssetReading.getSensorAssetSeqNo());

					if (iotBreachProcessorRepo.existsById(iotAssetReadingBreachPK)) {
						iotBreachProcessorRepo.incBadCtr(ruleSeqList.get(i).getResMetricRuleLineSeqNo(),
								iotAssetReading.getSensorAssetSeqNo());
					} else {
						iotBreachProcessorRepo.initBadCtr(ruleSeqList.get(i).getResMetricRuleLineSeqNo(),
								iotAssetReading.getSensorAssetSeqNo());
					}
				}

			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return;
	}

}