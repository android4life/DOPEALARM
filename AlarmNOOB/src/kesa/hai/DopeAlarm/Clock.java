package kesa.hai.DopeAlarm;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class Clock extends Activity {

	protected static final int TIME_DIALOG_ID = 1;
	public int hourSelected, minuteSelected;
	private int mHour, mMinute;
	TextView curtime;
	Button time, save;
	FileIO files;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clock);
		files = new FileIO(this);
		SaveData.save(files);
		SaveData.load(files);
		final Calendar c = Calendar.getInstance();

		mHour = c.get(Calendar.HOUR_OF_DAY);
		mMinute = c.get(Calendar.MINUTE);

		time = (Button) findViewById(R.id.time);
		curtime = (TextView) findViewById(R.id.textView1);

		save = (Button) findViewById(R.id.saveButton);
		save.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Alarm alarm = new Alarm(1, hourSelected, minuteSelected, true);
				ListOfAlarms.add(alarm);
				System.out.println("ArrayList: " + ListOfAlarms.alarms.size() + " " + ListOfAlarms.alarms.get(0).getTIME_HOUR() + " " + ListOfAlarms.alarms.get(0).getTIME_MINUTE());
			}
		});

		time.setOnClickListener(new OnClickListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {

				showDialog(TIME_DIALOG_ID);

			}

		});

	}

	private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int hourOfDay, int min) {
			hourSelected = hourOfDay;
			minuteSelected = min;
			curtime.setText("Time selected :" + mHour + "-" + mMinute);
		}
	};

	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case TIME_DIALOG_ID:
			return new TimePickerDialog(this, mTimeSetListener, mHour, mMinute, false);

		}
		return null;
	}

}
