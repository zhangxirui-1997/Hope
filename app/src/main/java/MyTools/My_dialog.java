package MyTools;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mydetermination.R;

public class My_dialog extends Dialog {
    private View mLayout;
    private My_dialog mDialog;

    //主要逻辑判断，1、进行名字判断，2、进行图片处理
    private void main_action(){

    }



    private My_dialog(Context context,int themeResId){
        super(context,themeResId);
    }
    private My_dialog(Context context){
        super(context);
    }

    public static class Builder{
        private Context context;
        private View contentView;
        private Button button;
        private EditText editText;
        private String string;
        private View.OnClickListener positiveButtonClickListener;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setContentView(View v) {
            this.contentView = v;
            return this;
        }

        public void setClick(View.OnClickListener onClickListener){
            this.positiveButtonClickListener=onClickListener;
        }

        public My_dialog create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // instantiate the dialog with the custom Theme
            final My_dialog dialog = new My_dialog(context);
            View layout = inflater.inflate(R.layout.my_dialog, null);
            dialog.addContentView(layout, new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            dialog.setContentView(layout);

            button=layout.findViewById(R.id.button7);
            button.setOnClickListener(positiveButtonClickListener);
            editText=layout.findViewById(R.id.editText);
            return dialog;
        }

        public String getedittext_string(){

            String s=editText.getText().toString();
            if(s.equals("")||s==null){
                s="ERROR";
            }
            return s;
        }
    }


}
