package kesa.hai.DopeAlarm.Alarm;

public class Alarm {
	private int ALARM_NUMBER;
	private int TIME_HOUR;
	private int TIME_MINUTE;
	private boolean on;
	private String name;

	public Alarm(int num, String name, int hour, int minute, boolean on) {
		this.TIME_HOUR = hour;
		this.TIME_MINUTE = minute;
		this.on = on;
		this.ALARM_NUMBER = num;
		this.name = name;
	}

	public void setTIME_MINUTE(int tIME_MINUTE) {
		TIME_MINUTE = tIME_MINUTE;
	}

	public void setTIME_HOUR(int tIME_HOUR) {
		TIME_HOUR = tIME_HOUR;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public int getTIME_HOUR() {
		return TIME_HOUR;
	}

	public int getTIME_MINUTE() {
		return TIME_MINUTE;
	}

	public boolean isOn() {
		return on;
	}

	public int getALARM_NUMBER() {
		return ALARM_NUMBER;
	}

	public void setALARM_NUMBER(int aLARM_NUMBER) {
		ALARM_NUMBER = aLARM_NUMBER;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
