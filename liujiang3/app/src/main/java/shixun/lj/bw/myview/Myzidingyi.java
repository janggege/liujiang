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
*/public class Myzidingyi extends LinearLayout implements View.OnClickListener {
    int sum = 1;
    private EditText e1;

    public Myzidingyi(Context context) {
        super(context);
    }

    public Myzidingyi(Context context, AttributeSet attrs) {
        super(context, attrs);
        initview(context);
    }


    public Myzidingyi(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initview(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.zidingyi, null, false);
        addView(view);
        view.findViewById(R.id.cb1).setOnClickListener(this);
        view.findViewById(R.id.cb2).setOnClickListener(this);
        e1 = view.findViewById(R.id.ce1);
        e1.setText(sum + "");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cb1:
                sum++;
                e1.setText(sum + "");
                onclick.onclick();
                break;
            case R.id.cb2:
                if (sum > 1) {
                    sum--;
                    e1.setText(sum + "");
                    onclick.onclick();
                }
                break;
        }

    }

    public interface onclick {
        void onclick();
    }

    onclick onclick;

    public void setOnclick(Myzidingyi.onclick onclick) {
        this.onclick = onclick;
    }
}
