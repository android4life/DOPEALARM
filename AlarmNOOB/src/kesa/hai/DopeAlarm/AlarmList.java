package kesa.hai.DopeAlarm;

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
				Intent i = new Intent(AlarmList.this, Clock.class);
				startActivity(i);
			}
		});
	}

}
