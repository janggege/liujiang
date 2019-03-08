package shixun.lj.bw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.List;

import shixun.lj.bw.adapter.Myadapter;
import shixun.lj.bw.bean.Datass;
import shixun.lj.bw.presenter.Showpresenter;
import shixun.lj.bw.view.Showview;

public class Showactivity extends AppCompatActivity implements Showview {

    private RecyclerView recyclerView;
    private Showpresenter showpresenter;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showactivity);
        recyclerView = findViewById(R.id.recy);
        checkBox = findViewById(R.id.c1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Showactivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        showpresenter = new Showpresenter(Showactivity.this);
        showpresenter.show();
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {

                } else {

                }
            }
        });

    }


    @Override
    public void Showview(List<Datass.ResultBean> list) {
        Myadapter myadapter = new Myadapter(list, Showactivity.this);
        recyclerView.setAdapter(myadapter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        showpresenter.detachview();
    }
}
