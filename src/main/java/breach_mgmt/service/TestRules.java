package breach_mgmt.service;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import breach_mgmt.model.master.IOTAssetReading;

public class TestRules {
	private static final Logger logger = LoggerFactory.getLogger(TestRules.class);

	// Flat Discount
	public float R1() {
		logger.info("gaurav");

		return 0;
	}

	// Slab Discount
	public float R2() {
		logger.info("ajay");
		return 1;
	}

	// Min Amount
	public float R3() {
		logger.info("dan");
		return 3;
	}

	// Check Less Than
	public Integer lessThan(IOTAssetReading iotAssetReading, String paramListString) {
		Float reading = iotAssetReading.getReading();
		Integer retVal = 0;
		CopyOnWriteArrayList<String> paramList = (CopyOnWriteArrayList<String>) Arrays
				.asList(paramListString.split(","));

		if (reading >= Float.parseFloat(paramList.get(0))) {
			retVal = 1;
		}

		return retVal;
	}

	// More than
	public Integer moreThan(IOTAssetReading iotAssetReading, String paramListString) {
		Float reading = iotAssetReading.getReading();
		Integer retVal = 0;
		CopyOnWriteArrayList<String> paramList = (CopyOnWriteArrayList<String>) Arrays
				.asList(paramListString.split(","));

		if (reading <= Float.parseFloat(paramList.get(0))) {
			retVal = 1;
		}

		return retVal;
	}

	// Exactly
	public Integer equalTo(IOTAssetReading iotAssetReading, String paramListString) {
		Float reading = iotAssetReading.getReading();
		Integer retVal = 0;
		CopyOnWriteArrayList<String> paramList = (CopyOnWriteArrayList<String>) Arrays
				.asList(paramListString.split(","));

		if (reading != Float.parseFloat(paramList.get(0))) {
			retVal = 1;
		}

		return retVal;
	}

	// Between
	public Integer between(IOTAssetReading iotAssetReading, String paramListString) {
		Float reading = iotAssetReading.getReading();
		Integer retVal = 0;
		CopyOnWriteArrayList<String> paramList = (CopyOnWriteArrayList<String>) Arrays
				.asList(paramListString.split(","));

		if (!((reading > Float.parseFloat(paramList.get(0))) && (reading < Float.parseFloat(paramList.get(1))))) {
			retVal = 1;
		}

		return retVal;
	}

	// White List
	public Integer whiteList(IOTAssetReading iotAssetReading, String paramListString) {
		Float reading = iotAssetReading.getReading();
		Integer retVal = 0;
		CopyOnWriteArrayList<Float> numList = null;

		CopyOnWriteArrayList<String> paramList = (CopyOnWriteArrayList<String>) Arrays
				.asList(paramListString.split(","));

		if (paramList.size() > 0) {
			numList = new CopyOnWriteArrayList<Float>();
			for (int i = 0; i < paramList.size(); i++) {
				numList.add(Float.parseFloat(paramList.get(i)));
			}
			if (!numList.contains(reading)) {
				retVal = 1;
			}
		}
		return retVal;
	}

	// Forbidden List
	public Integer blackList(IOTAssetReading iotAssetReading, String paramListString) {
		Float reading = iotAssetReading.getReading();
		Integer retVal = 0;
		CopyOnWriteArrayList<Float> numList = null;

		CopyOnWriteArrayList<String> paramList = (CopyOnWriteArrayList<String>) Arrays
				.asList(paramListString.split(","));

		if (paramList.size() > 0) {
			numList = new CopyOnWriteArrayList<Float>();
			for (int i = 0; i < paramList.size(); i++) {
				numList.add(Float.parseFloat(paramList.get(i)));
			}
			if (numList.contains(reading)) {
				retVal = 1;
			}
		}
		return retVal;
	}

}
