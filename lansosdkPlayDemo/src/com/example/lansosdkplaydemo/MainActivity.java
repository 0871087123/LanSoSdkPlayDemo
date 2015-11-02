/*****************************************************************************
 * Email:support@lansongtech.com
 * MainActivity.java
 * 
 * 这个程序仅仅是演示版本，仅是功能上的呈现，不保证性能和适用性。如正好满足您的项目，我们深感荣幸。
 * 我们有更专业稳定强大的发行版本，期待和您进一步的合作。
 *  
 *Email: support@lansongtech.com 
 * 
 * 
 * 
 *****************************************************************************/
package com.example.lansosdkplaydemo;


import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class MainActivity extends Activity {

	private String path="";
	 
	//such as:		path = "/storage/sdcard1/chongchukabuer.mp4";
//	path = "/storage/sdcard1/chongchukabuer.mp4";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        

		 Thread.setDefaultUncaughtExceptionHandler(new snoCrashHandler());
        setContentView(R.layout.activity_main);
       
       
       
        
        findViewById(R.id.id_main_allcodec_btn).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
					if (path == "") {
						Toast.makeText(MainActivity.this, 
								"Please set a variable path (must be stored on sdcard) at MainActivity.java", Toast.LENGTH_LONG).show();
						return ;
					}
					Uri uri1=Uri.fromFile(new File(path));
					//Uri uri1=Uri.parse("http://devimages.apple.com/iphone/samples/bipbop/bipbopall.m3u8");
					
					
			        Intent intent = new Intent(MainActivity.this, VideoPlayerActivity.class);
			        intent.putExtra(VideoPlayerActivity.PLAY_LOCATION, uri1);
			        intent.putExtra(VideoPlayerActivity.PLAY_IS_SOFTWARE_CODEC, false);
			        startActivity(intent);
			}
		});
        
        findViewById(R.id.id_main_software_btn).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
					if (path == "") {
						Toast.makeText(MainActivity.this, 
								"Please set a variable path (must be stored on sdcard) at MainActivity.java", Toast.LENGTH_LONG).show();
						return ;
					}
					Uri uri1=Uri.fromFile(new File(path));
					
			        Intent intent = new Intent(MainActivity.this, VideoPlayerActivity.class);
			        intent.putExtra(VideoPlayerActivity.PLAY_LOCATION, uri1);
			        intent.putExtra(VideoPlayerActivity.PLAY_IS_SOFTWARE_CODEC, true);  //<------------only here is different
			        startActivity(intent);
			        
			}
		});
        
    }
}
