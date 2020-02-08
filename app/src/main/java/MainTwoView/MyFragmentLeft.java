package MainTwoView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mydetermination.Main2Activity;
import com.example.mydetermination.MainActivity;
import com.example.mydetermination.R;

import java.io.File;


public class MyFragmentLeft extends Fragment {
    //关于体态检测按钮
    private Button check_button;
    private View.OnClickListener onClickListener;

    public void introduction(View.OnClickListener onClickListener){
        this.onClickListener=onClickListener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //布局文件转成View
        //参数1：Fragment需要加载的布局文件
        //参数2：加载layout的父ViewGroup
        //参数3：是否返回父ViewGroup对象，false为不
        View view = inflater.inflate(R.layout.first_view,container,false);

        Button button=view.findViewById(R.id.button);
        button.setOnClickListener(onClickListener);

        return view;
    }



}
