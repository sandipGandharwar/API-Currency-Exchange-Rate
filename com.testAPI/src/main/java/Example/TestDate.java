package Example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calobj = Calendar.getInstance();
		df.format(calobj.getTime());
		calobj.add(Calendar.DAY_OF_YEAR, 1);
//	    Date tomorrow = calobj.getTime();
		System.out.println(df.format(calobj.getTime()));


	}

}
