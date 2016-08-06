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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Button main_activity_php_button;
    private Button main_activity_nodejs_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_activity_php_button = (Button) findViewById(R.id.main_activity_xutil_php_button);
        main_activity_nodejs_button = (Button) findViewById(R.id.main_activity_xutil_nodejs_button);
        main_activity_php_button.setOnClickListener(this);
        main_activity_nodejs_button.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        HttpUtils http = new HttpUtils();
        switch (v.getId())
        {
            case R.id.main_activity_xutil_php_button:
                http.send(HttpRequest.HttpMethod.GET,
                        "http://tapi.test.tuoguibao.com/basicapi.php?ac=1002&mobile=18562172800&password=123456",
                        new RequestCallBack<String>() {
                            @Override
                            public void onLoading(long total, long current, boolean isUploading) {

                            }

                            @Override
                            public void onSuccess(ResponseInfo<String> responseInfo) {
                                Log.d(TAG, responseInfo.result);
//                                Toast.makeText(MainActivity.this, responseInfo.result
//                                        , Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onStart() {
                            }

                            @Override
                            public void onFailure(HttpException error, String msg) {
                                Log.d(TAG, "onFailure: ");
                            }
                        });
                break;
            case R.id.main_activity_xutil_nodejs_button:
                //服务器地址应使用IP地址
                http.send(HttpRequest.HttpMethod.GET, "http://192.3.19.27:8080/?ac=1002",
                        new RequestCallBack<String>() {
                            @Override
                            public void onLoading(long total, long current, boolean isUploading) {
                                super.onLoading(total, current, isUploading);
                            }

                            @Override
                            public void onSuccess(ResponseInfo<String> responseInfo) {
                                Log.d(TAG, "onSuccess: "+responseInfo.result);
//                                Toast.makeText(MainActivity.this,responseInfo.result,Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onStart() {
                                super.onStart();
                            }

                            @Override
                            public void onFailure(HttpException e, String s) {
                                Log.d(TAG, "onFailure: ");
//                                Toast.makeText(MainActivity.this, "onFailuer:", Toast.LENGTH_SHORT).show();
                            }
                        }
                );
        }
    }
}
