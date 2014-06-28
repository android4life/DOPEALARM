package kesa.hai.DopeAlarm;

import java.util.ArrayList;

public class ListOfAlarms {
	public static ArrayList<Alarm> alarms = new ArrayList<Alarm>();

	public static void add(Alarm alarm) {
		alarms.add(alarm);
	}

}
