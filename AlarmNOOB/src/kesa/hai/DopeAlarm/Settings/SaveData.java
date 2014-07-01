package kesa.hai.DopeAlarm.Settings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import kesa.hai.DopeAlarm.Alarm.Alarm;
import kesa.hai.DopeAlarm.Alarm.ListOfAlarms;

public class SaveData {
	private static int numberOfAlarms;
	private static int alarmNumber;
	private static int alarmHour;
	private static int alarmMinute;
	private static boolean on;
	private static String name;

	public static void load(FileIO files) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(files.readFile(".alarmInfo")));
			ListOfAlarms.alarms.clear();
			numberOfAlarms = Integer.parseInt(in.readLine());
			for (int i = 0; i < numberOfAlarms; i++) {
				alarmNumber = Integer.parseInt(in.readLine());
				alarmHour = Integer.parseInt(in.readLine());
				alarmMinute = Integer.parseInt(in.readLine());
				on = Boolean.parseBoolean(in.readLine());
				name = in.readLine();
				Alarm alarm = new Alarm(alarmNumber, name, alarmHour, alarmMinute, on);
				ListOfAlarms.alarms.add(alarm);
				alarm = null;
			}
		} catch (IOException e) {

		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void save(FileIO files) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(files.writeFile(".alarmInfo")));
			out.write(ListOfAlarms.alarms.size());
			for (int i = 0; i < ListOfAlarms.alarms.size(); i++) {
				Alarm alarm = ListOfAlarms.alarms.get(i);
				out.write(alarm.getALARM_NUMBER());
				out.write("\n");
				out.write(alarm.getTIME_HOUR());
				out.write("\n");
				out.write(alarm.getTIME_MINUTE());
				out.write("\n");
				out.write(String.valueOf(alarm.isOn()));
				out.write("\n");
				out.write(alarm.getName());
				out.write("\n");

			}

		} catch (IOException e) {

		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
