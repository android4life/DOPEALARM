package kesa.hai.DopeAlarm;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	TextView clockView;
	Calendar c;
	Timer timer;
	TimerTask timerTask;
	Handler handler = new Handler();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		clockView = (TextView) findViewById(R.id.tvClock);
		clockView.setText("NO");
		c = Calendar.getInstance();
		handler.post(updateTextRunnable);
	}

	Runnable updateTextRunnable = new Runnable() {

		public void run() {
			c = Calendar.getInstance();
			if (String.valueOf(c.get(Calendar.MINUTE)).length() > 1) {
				clockView.setText(String.valueOf(c.get(Calendar.HOUR_OF_DAY)) + ":" + String.valueOf(c.get(Calendar.MINUTE)));
			} else {
				System.out.println("BOOM");
				clockView.setText(String.valueOf(c.get(Calendar.HOUR_OF_DAY)) + ":" + "0" + String.valueOf(c.get(Calendar.MINUTE)));
			}
			handler.postDelayed(this, 1000);
		}
	};

}
