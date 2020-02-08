package com.example.mydetermination;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import MainTwoView.MyAdapter;
import MainTwoView.MyFragmentLeft;
import MainTwoView.MyFragmentRight;
import MainTwoView.NoScrollViewPager;
import MyTools.My_Find_Button;
import MyTools.Second_item_Adapter;
import MyTools.second_item;
import litepal_class.Body_Point;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;


public class MainActivity extends AppCompatActivity {
    String[] permissions={Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.CAMERA};
    private List<Fragment> listFragment;//声明List，存放Fagment  左右
    private NoScrollViewPager viewPager;//声明主页面的viewpager
    private My_Find_Button my_find_button;

    //关于右侧view的item
    private ListView listView;
    private List<second_item> second_items=new ArrayList<>();

    //关于体态检测按钮
    private Button check_button;
    private TextView textView;

    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            List<Body_Point> k=LitePal.findAll(Body_Point.class);
            int i=k.size();
            deleteFile("/storage/emulated/0/Android/data/com.example.mydetermination/cache/zhengmianzhao"+i+".jpg");
            deleteFile("/storage/emulated/0/Android/data/com.example.mydetermination/cache/ceshenzhao"+i+".jpg");

            requestPower();
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,Main2Activity.class);
            startActivity(intent);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPower();
        init();
        LitePal.initialize(this);
    }

    //初始化页面
    public void init(){
        //先把两个View设置好
        listFragment=new ArrayList<Fragment>();
        MyFragmentLeft myFragmentLeft=new MyFragmentLeft();
        myFragmentLeft.introduction(onClickListener);
        listFragment.add(myFragmentLeft);
        listFragment.add(new MyFragmentRight());
        //实例化适配器
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(),listFragment,null);
        //实例化ViewPager
        viewPager = (NoScrollViewPager) findViewById(R.id.viewpager);
        //为viewPager加载适配器
        viewPager.setAdapter(myAdapter);
        //加载监听事件
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                if(position==1){
                    init_second();
                }else if(position==0){
                    //init_first();
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //设置缓存页数
        viewPager.setOffscreenPageLimit(1);
        //viewPager.setCurrentItem(1,true);

        //再把底下设置好
        my_find_button=findViewById(R.id.findthisbutton);
        my_find_button.begin(viewPager);
        /*
        * button控制viewpage已经实现
        * 现在试图在NoScrollViewPager中写监听函数，减少在activity_main中裸奔
        * */
        viewPager.beginthis(my_find_button);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                my_find_button.Action(position,false);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setCurrentItem(0,true);


    }

    //初始化右侧界面
    public void init_second(){
        textView=findViewById(R.id.textView7);
        List<Body_Point> body_points=LitePal.findAll(Body_Point.class);
        if(body_points.size()==0){
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    init_second();
                }
            });
            return;
        }else{
            textView.setVisibility(View.GONE);
        }

        for(Body_Point b:body_points){
            second_item aa=new second_item();
            aa.setSecond_item_id(b.getBody_points_ID());
            aa.setSecond_item_name(b.getBname());
            aa.setSecond_item_time(b.getBtime());
            aa.setSecond_item_kind("体态检测");
            second_items.add(aa);
        }

        listView=findViewById(R.id.second_listitem);

        Second_item_Adapter second_item_adapter=new Second_item_Adapter(this,R.layout.second_view_item,second_items);
        listView.setAdapter(second_item_adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent();
                intent.putExtra("idthis",position);
                intent.setClass(MainActivity.this,Record_card.class);
                startActivity(intent);
            }
        });
    }

    //权限接口
    public void requestPower(){
        //判断权限是否具备接口
        //判断是否已经赋予权限
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PERMISSION_GRANTED||ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)
                != PERMISSION_GRANTED){
            //如果应用之前请求过此权限但用户拒绝了请求，此方法将返回true
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)||
                    ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)){
                //这里写对话框之类的项向用户解释为什么要申请权限
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("注意");
                builder.setMessage("我们需要获取手机权限进行拍照和存储，否则可能无法正常使用");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ActivityCompat.requestPermissions(MainActivity.this,permissions,1);
                            }
                        });
                AlertDialog dialog=builder.create();
                dialog.show();


            }else{
                //申请权限，字符串数组内是一个或多个要申请的权限，1是申请权限结果返回的参数
                ActivityCompat.requestPermissions(this,permissions,1);
            }

        }
    }
    //权限回调接口
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //请求权限回调接口
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PERMISSION_GRANTED) {
                    Toast.makeText(this, "" + "权限" + permissions[i] + "申请成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "" + "权限" + permissions[i] + "申请失败", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    //判断是否有网络链接
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 删除单个文件
     * @param   filePath    被删除文件的文件名
     * @return 文件删除成功返回true，否则返回false
     */
    public boolean deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }
}
