package th.part_12_exception.chapter_04;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggerException extends Exception {
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger("LoggerException");

	public LoggerException() {
		StringWriter writer = new StringWriter();
		printStackTrace(new PrintWriter(writer));
		logger.severe(writer.toString());
	}
}
