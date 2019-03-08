package shixun.lj.bw.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import shixun.lj.bw.R;
import shixun.lj.bw.bean.Datass;

/*
  name:刘江
  data:2019
*/public class Myadapter extends RecyclerView.Adapter<Myadapter.Myviewholder> {
    List<Datass.ResultBean> list;
    Context context;

    public Myadapter(List<Datass.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.iteam1, null, false);
        Myviewholder myviewholder = new Myviewholder(view);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder myviewholder, int i) {
        myviewholder.textView.setText(list.get(i).getCommodityName().substring(0, 4));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        myviewholder.recyclerView2.setLayoutManager(linearLayoutManager);
        Myadapter2 myadapter2 = new Myadapter2(list, context);
        myviewholder.recyclerView2.setAdapter(myadapter2);




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Myviewholder extends RecyclerView.ViewHolder {

        private final TextView textView;
        private final RecyclerView recyclerView2;
        private final CheckBox checkBox;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.it2);
            recyclerView2 = itemView.findViewById(R.id.recy2);
            checkBox = itemView.findViewById(R.id.checkbox2);
        }
    }
    public void  checked1(){

    }
    public void  checked2(){

    }
}
