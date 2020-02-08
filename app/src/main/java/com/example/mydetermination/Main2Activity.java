package com.example.mydetermination;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.litepal.LitePal;

import java.io.File;
import java.io.IOException;
import java.util.List;

import litepal_class.Body_Point;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class Main2Activity extends AppCompatActivity {

    //https://www.cnblogs.com/guanxinjing/p/10940049.html
    private ImageView imageViewleft;
    private ImageView imagerViewright;
    private Button button;
    private String TAG = "Main2Activity";
    private boolean judgeleft=false;
    private boolean judgeright=false;
    private AlertDialog alertDialog=null;
    private AlertDialog.Builder builder;

    private ProgressDialog progressDialog;
    private AlertDialog.Builder progressbuilder;

    private static String s;
    private EditText editText;
    private String nameText="";

    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent();
            intent.setClass(Main2Activity.this,CameraActivity.class);

            if(v.getId()==R.id.imageView3){
                intent.putExtra("judge",0);
            }else if(v.getId()==R.id.imageView4){
                intent.putExtra("judge",1);
            }
            startActivity(intent);
        }
    };



    public void uploadImage(){

        int i=LitePal.count(Body_Point.class);
        String url="http://192.168.1.100:8085/test/testtest";
        Log.d("Main2Activity.java","1111111111准备进行网络链接"+url);
        File file_zhengmianzhao=new File("/storage/emulated/0/Android/data/com.example.mydetermination/cache/zhengmianzhao"+i+".jpg");
        File file_ceshenzhao=new File("/storage/emulated/0/Android/data/com.example.mydetermination/cache/ceshenzhao"+i+".jpg");

        //创建OkHttpClient对象
        OkHttpClient client = new OkHttpClient();

        /*//创建RequestBody
        RequestBody body=new FormBody.Builder()
                .add("name","你好")
                .add("dog","小范")
                .build();*/

        MultipartBody.Builder builder=new MultipartBody.Builder().setType(MultipartBody.FORM);
        builder.addFormDataPart("zhengmian",file_zhengmianzhao.getName(),
                RequestBody.create(file_ceshenzhao, MediaType.parse("image/jpeg")));
        builder.addFormDataPart("ceshenzhao",file_ceshenzhao.getName(),
                RequestBody.create(file_ceshenzhao,MediaType.parse("image/jpeg")));

        MultipartBody multipartBody=builder.build();

        //创建Request
        //Log.d("Main2Activity.class","11111111标记点1");
        Request request = new Request.Builder()
                .url(url)//访问连接
                .post(multipartBody)
                .build();
        //创建Call对象
        Call call = client.newCall(request);
        //通过execute()方法获得请求响应的Response对象
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("Main2Activity.java","1111111111失败了失败了");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("Main2Activity.java","1111111111"+response.body().string());
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }

    private void init(){
        imageViewleft=findViewById(R.id.imageView3);
        imagerViewright=findViewById(R.id.imageView4);
        button=findViewById(R.id.button3);
        imageViewleft.setOnClickListener(onClickListener);
        imagerViewright.setOnClickListener(onClickListener);
        editText=findViewById(R.id.editText2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameText=editText.getText().toString();
                if(judgeleft&&judgeright&&!nameText.equals("")){
                    //进行照片传输
                    uploadImage();


                }else if(!judgeright||!judgeleft){
                    builder=new AlertDialog.Builder(Main2Activity.this);
                    builder.setTitle("注意");
                    builder.setMessage("请拍摄正面全身照和侧面全身照");
                    builder.setPositiveButton("确定",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            alertDialog.cancel();
                        }
                    });
                    alertDialog=builder.create();
                    alertDialog.show();
                }else if(nameText.equals("")){
                    builder=new AlertDialog.Builder(Main2Activity.this);
                    builder.setTitle("注意");
                    builder.setMessage("请填写您的姓名");
                    builder.setPositiveButton("确定",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            alertDialog.cancel();
                        }
                    });
                    alertDialog=builder.create();
                    alertDialog.show();
                }
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        readTwoImages();
    }

    private void readTwoImages(){

        List<Body_Point> k=LitePal.findAll(Body_Point.class);
        int i=k.size();

        if(fileIsExists("/storage/emulated/0/Android/data/com.example.mydetermination/cache/zhengmianzhao"+i+".jpg")){
            readImg("/storage/emulated/0/Android/data/com.example.mydetermination/cache/zhengmianzhao"+i+".jpg",0);
            Log.d(TAG,"11111111正面照片获取成功");
            judgeleft=true;
        }else{
            Log.d(TAG,"11111111正面照片获取失败");
        }
        if(fileIsExists("/storage/emulated/0/Android/data/com.example.mydetermination/cache/ceshenzhao"+i+".jpg")){
            readImg("/storage/emulated/0/Android/data/com.example.mydetermination/cache/ceshenzhao"+i+".jpg",1);
            Log.d(TAG,"11111111侧面照片获取成功");
            judgeright=true;
        }else{
            Log.d(TAG,"11111111侧面照片获取失败");
        }

    }

    public void readImg(String strFile,int judge1) {
        Bitmap bitmap = BitmapFactory.decodeFile(strFile);
        if(judge1==0){
            imageViewleft.setImageBitmap(bitmap);
        }else if(judge1==1){
            imagerViewright.setImageBitmap(bitmap);
        }

    }

    //判断文件是否存在
    public boolean fileIsExists(String strFile) {
        try {
            File f = new File(strFile);
            if (!f.exists()) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
