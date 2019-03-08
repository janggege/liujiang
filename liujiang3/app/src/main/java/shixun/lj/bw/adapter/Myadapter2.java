package shixun.lj.bw.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import shixun.lj.bw.R;
import shixun.lj.bw.bean.Datass;
import shixun.lj.bw.myview.Myzidingyi;

/*
  name:刘江
  data:2019
*/public class Myadapter2 extends RecyclerView.Adapter<Myadapter2.myviewholder> {
    List<Datass.ResultBean> list1;
    Context context;

    public Myadapter2(List<Datass.ResultBean> list1, Context context) {
        this.list1 = list1;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.iteam2, null, false);
        myviewholder myviewholder = new myviewholder(view);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder myviewholder, int i) {
        Glide.with(context).load(list1.get(i).getMasterPic()).into(myviewholder.imageView);
        myviewholder.t1.setText(list1.get(i).getCommodityName().substring(0, 5));
        myviewholder.t2.setText(list1.get(i).getPrice() + "");
        myviewholder.my.setOnclick(new Myzidingyi.onclick() {
            @Override
            public void onclick() {
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView t1;
        private final TextView t2;
        private final Myzidingyi my;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            t1 = itemView.findViewById(R.id.text1);
            t2 = itemView.findViewById(R.id.text2);
            my = itemView.findViewById(R.id.zidingyi);

        }
    }
}
