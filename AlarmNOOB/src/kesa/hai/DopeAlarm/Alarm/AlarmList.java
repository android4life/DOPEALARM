package kesa.hai.DopeAlarm.Alarm;

import kesa.hai.DopeAlarm.CreateAlarm;
import kesa.hai.DopeAlarm.R;
import kesa.hai.DopeAlarm.Settings.FileIO;
import kesa.hai.DopeAlarm.Settings.SaveData;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AlarmList extends Activity {
	Button createNew;
	FileIO files;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_alarmlist);
		files = new FileIO(this);
		SaveData.load(files);
		initiateEverything();
	}

	private void initiateEverything() {
		createNew = (Button) findViewById(R.id.bNewAlarm);
		createNew.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent i = new Intent(AlarmList.this, CreateAlarm.class);
				startActivity(i);
			}
		});
	}

}
