package zzr.com.mylayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    public void jump(View view) {
        Intent intent=null;
        switch (view.getId()){
            case R.id.coordinator:
                intent=new Intent(this,MainActivity.class);
                break;
            case R.id.collapse:
                intent=new Intent(this,CollapseActivity.class);
                break;

        }
        startActivity(intent);
    }
}
