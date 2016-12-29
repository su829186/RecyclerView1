package zzr.com.pop;

import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void first(View view) {
        Button button=new Button(this);
        button.setText("测试");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "内容区", Toast.LENGTH_SHORT).show();
            }
        });
        //窗口
        PopupWindow win=new PopupWindow(button,200,100);
        win.setOutsideTouchable(true);

        //显示在view的下方
        win.showAsDropDown(view);
    }

    public void bottom(View view) {
        View item = View.inflate(this,R.layout.bottom,null);
        int width = getResources().getDisplayMetrics().widthPixels;
        PopupWindow win=new PopupWindow(item,width,50,true);
        win.setAnimationStyle(R.style.bottom_anmi);
        win.setBackgroundDrawable(new BitmapDrawable());




        View inflate = View.inflate(this, R.layout.activity_main, null);

        win.showAtLocation(inflate, Gravity.BOTTOM,0,0);
    }
}
