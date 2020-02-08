package MyTools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mydetermination.R;

import java.util.ArrayList;
import java.util.List;

public class Second_item_Adapter extends ArrayAdapter<second_item> {
    private int newResourceId;
    public Second_item_Adapter(Context context, int resourceId, List<second_item> second_itemList){
        super(context, resourceId, second_itemList);
        newResourceId = resourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        second_item second_item=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(newResourceId,parent,false);

        TextView textView_name=view.findViewById(R.id.textView5);
        TextView textView_kind=view.findViewById(R.id.textView6);
        TextView textView_time=view.findViewById(R.id.textView8);

        textView_name.setText(second_item.getSecond_item_name());
        textView_kind.setText(second_item.getSecond_item_kind());
        textView_time.setText(second_item.getSecond_item_time());
        return view;
    }
}
