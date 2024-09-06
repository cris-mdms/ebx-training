package module;

import com.orchestranetworks.service.LoggingCategory;

public class ModuleLogger {
	private static LoggingCategory moduleLogger;

	public static LoggingCategory getModuleLogger() {
		return moduleLogger;
	}

	public static void setModuleLogger(LoggingCategory moduleLogger) {
		ModuleLogger.moduleLogger = moduleLogger;
	}
	
}
