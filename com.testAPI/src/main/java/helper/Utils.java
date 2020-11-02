package helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {
	
	public static String currentDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calobj = Calendar.getInstance();
		System.out.println(df.format(calobj.getTime()));
		return df.format(calobj.getTime());
	}
	
	public static String tomorrowDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calobj = Calendar.getInstance();
		df.format(calobj.getTime());
		calobj.add(Calendar.DAY_OF_YEAR, 1);
		System.out.println(df.format(calobj.getTime()));
		return df.format(calobj.getTime());
	}

}
