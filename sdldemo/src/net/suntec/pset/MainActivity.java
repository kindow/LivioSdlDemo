package net.suntec.pset;

import java.util.logging.Logger;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.livio.sdl.SdlService;
import com.livio.sdl.adapters.SdlMessageAdapter;

public class MainActivity extends Activity {
	Logger logger = Logger.getLogger(MainActivity.class.getName());
	private ListView lv_messageLog;
	private TextView tv_connectionStatus;

	// message log data adapter
	private SdlMessageAdapter listViewAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		SdlService.setDebug(true);
		// 界面信息初始化，如连接状态，按钮内容等.
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		// set up the "Send Message" button
		findViewById(R.id.main_btn_sendMessage).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						logger.info("click message btn");
					}
				});

		lv_messageLog = (ListView) findViewById(R.id.main_commandLogList);
		listViewAdapter = new SdlMessageAdapter(this);
		lv_messageLog.setAdapter(listViewAdapter);

		tv_connectionStatus = (TextView) findViewById(R.id.main_connStatus);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
