package MyTools;


import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.example.mydetermination.R;

public class My_Find_Button extends LinearLayout {
    private TextView textViewleft;
    private TextView textViewright;
    private RelativeLayout relativeLayout;
    private RelativeLayout relativeLayout1;

    private int Click_Left=0;
    private int Click_Right=1;
    private ViewPager viewPager;

    public My_Find_Button(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.find_button, this);

        textViewleft = findViewById(R.id.textView3);
        textViewright = findViewById(R.id.textView4);

        relativeLayout=findViewById(R.id.relativeLayout1);
        relativeLayout1=findViewById(R.id.relativeLayout2);


        viewPager=findViewById(R.id.viewpager);

        relativeLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Action(Click_Left,false);
            }
        });

        relativeLayout1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Action(Click_Right,false);
            }
        });
        relativeLayout.setBackgroundColor(Color.parseColor("#E8F8FF"));

    }

    public void begin(ViewPager viewPager1){
        viewPager=viewPager1;
    }

    //k来确定是否为初始加载进入
    public void Action(int i,boolean k){
        if(i==Click_Left){
            if(!k)viewPager.setCurrentItem(0,true);
            relativeLayout.setBackgroundColor(Color.parseColor("#E8F8FF"));
            relativeLayout1.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }else if(i==Click_Right){
            if(!k)viewPager.setCurrentItem(1,true);
            relativeLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            relativeLayout1.setBackgroundColor(Color.parseColor("#E8F8FF"));

        }
    }



}
