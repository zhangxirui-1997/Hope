package MainTwoView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mydetermination.R;


public class MyFragmentRight extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //布局文件转成View
        //参数1：Fragment需要加载的布局文件
        //参数2：加载layout的父ViewGroup
        //参数3：是否返回父ViewGroup对象，false为不
        View view = inflater.inflate(R.layout.second_view,container,false);
        return view;
    }
}