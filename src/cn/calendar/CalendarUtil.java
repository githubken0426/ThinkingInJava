package cn.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {

	public static void test() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:mm ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		// 设置时间
		// calendar.set(Calendar.HOUR_OF_DAY, 10);
		// 增加或减少时间
		calendar.add(Calendar.HOUR_OF_DAY, -12);
		System.out.println(format.format(calendar.getTime()));
	}
}
