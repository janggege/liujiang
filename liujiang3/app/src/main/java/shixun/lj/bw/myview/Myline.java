package shixun.lj.bw.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import shixun.lj.bw.R;

/*
  name:刘江
  data:2019
*/public class Myline extends LinearLayout implements View.OnClickListener {

    private EditText ed1;


    public Myline(Context context) {
        super(context);
    }

    public Myline(Context context, AttributeSet attrs) {
        super(context, attrs);
        initview(context);
    }


    public Myline(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initview(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.myline, null, false);
        addView(view);
        ed1 = view.findViewById(R.id.ed1);
        view.findViewById(R.id.t1).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.t1:
                String s = ed1.getText().toString();
                onclick.onclick(s);
                break;

        }

    }
    public interface  onclick{
        void onclick(String text);
    }
    onclick onclick;

    public void setOnclick(Myline.onclick onclick) {
        this.onclick = onclick;
    }
}
