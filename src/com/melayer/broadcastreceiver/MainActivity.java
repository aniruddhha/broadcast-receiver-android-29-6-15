package com.melayer.broadcastreceiver;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

	private Button btnSendBroadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_WALLPAPER_CHANGED);
        
        registerReceiver(new WallReceiver(), filter);

        btnSendBroadcast = (Button) findViewById(R.id.btnSend);
        btnSendBroadcast.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent();
				intent.setAction("com.my.broadcast");
				sendBroadcast(intent);
				
				//sendStickyBroadcast(intent);
			}
		});
    }
}
