package shixun.lj.bw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.library.AutoFlowLayout;
import com.example.library.FlowAdapter;

import java.util.ArrayList;

import shixun.lj.bw.myview.Myline;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> list;
    private AutoFlowLayout layout;
    private Button bt1;
    private Myline myline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myline = findViewById(R.id.myline);
        bt1 = findViewById(R.id.bt1);
        layout = findViewById(R.id.layout);
        Button gouwu = findViewById(R.id.gouwu);
        list = new ArrayList<>();

        myline.setOnclick(new Myline.onclick() {
            @Override
            public void onclick(String text) {
                list.add(text);
                addd(list);
            }


        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = myline.findViewById(R.id.ed1);
                editText.getText().clear();
                list.clear();
                layout.removeAllViews();
            }
        });
        //购物车
        gouwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Showactivity.class));
                finish();
            }
        });


    }

    public void addd(final ArrayList<String> list) {
        layout.setAdapter(new FlowAdapter(list) {
            @Override
            public View getView(int i) {
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.iteam, null, false);
                TextView t1 = view.findViewById(R.id.it1);
                t1.setText(list.get(i));
                list.clear();
                return view;
            }
        });
    }

}
