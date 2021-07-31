package com.Demoproject.Utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.aventstack.extentreports.model.Log;

public class LoggerUtil {
	public static Logger Log = Logger.getLogger(Log.class.getName());

	public static void info(String msg) {
		Log.info(msg);
	}

	public static void warn(String msg) {
		Log.warn(msg);
	}

	public static void debug(String msg) {
		Log.debug(msg);
	}

	public static void error(String msg) {
		Log.error(msg);
	}

}
