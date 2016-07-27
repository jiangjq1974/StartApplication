package com.example.lsx.startapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button xutilbutton = (Button) findViewById(R.id.main_activity_xutil_button);
        xutilbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpUtils http = new HttpUtils();
                http.send(HttpRequest.HttpMethod.GET,
                        "http://tapi.test.tuoguibao.com/basicapi.php?ac=1002&mobile=18562172800&password=123456",
                        new RequestCallBack<String>() {
                            @Override
                            public void onLoading(long total, long current, boolean isUploading) {

                            }

                            @Override
                            public void onSuccess(ResponseInfo<String> responseInfo) {
                                Log.d(TAG, responseInfo.result);
                                Toast.makeText(MainActivity.this, responseInfo.result
                                        , Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onStart() {
                            }

                            @Override
                            public void onFailure(HttpException error, String msg) {
                                Log.d(TAG, "onFailure: ");
                            }
                        });
            }
        });
    }
}
