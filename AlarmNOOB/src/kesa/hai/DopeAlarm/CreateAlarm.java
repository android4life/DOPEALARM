package kesa.hai.DopeAlarm;

import java.util.Calendar;

import kesa.hai.DopeAlarm.Alarm.Alarm;
import kesa.hai.DopeAlarm.Alarm.AlarmList;
import kesa.hai.DopeAlarm.Alarm.ListOfAlarms;
import kesa.hai.DopeAlarm.Settings.FileIO;
import kesa.hai.DopeAlarm.Settings.SaveData;
import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class CreateAlarm extends Activity {

	protected static final int TIME_DIALOG_ID = 1;
	public int hourSelected, minuteSelected;
	private int mHour, mMinute;
	private String name;
	TextView curtime, enterLabel;
	EditText label;
	Button time, save;
	FileIO files;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clock);
		files = new FileIO(this);
		final Calendar c = Calendar.getInstance();

		label = (EditText) findViewById(R.id.etLabel);
		label.setFocusable(true);
		enterLabel = (TextView) findViewById(R.id.tvName);

		mHour = c.get(Calendar.HOUR_OF_DAY);
		mMinute = c.get(Calendar.MINUTE);

		time = (Button) findViewById(R.id.time);
		curtime = (TextView) findViewById(R.id.textView1);

		save = (Button) findViewById(R.id.saveButton);
		save.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				name = label.getText().toString();
				Alarm alarm = new Alarm(1, name, hourSelected, minuteSelected, true);
				ListOfAlarms.add(alarm);
				SaveData.save(files);
				Intent i = new Intent(CreateAlarm.this, AlarmList.class);
				startActivity(i);
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
