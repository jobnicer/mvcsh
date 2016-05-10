package test;

import org.apache.log4j.Logger;

public class LogTest {

	final static Logger logger = Logger.getLogger(LogTest.class);
	public static void main(String[] args) {
		try {
//			int a = 0;
//			float b = 3/a;
//			System.out.println(b);
			System.out.println();
		} catch (Exception e) {
//			e.printStackTrace();
			logger.error(e);
		}
	}
}
