package shixun.lj.bw.model;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import shixun.lj.bw.bean.Datass;
import shixun.lj.bw.okhttp.Okhttputils;

/*
  name:刘江
  data:2019
*/public class Showmodle {
    String url = "http://172.17.8.100/ks/product/getCarts?uid=51";
    String url1 = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=高跟鞋&page=1&count=7";

    public interface onclick {
        void onclick(List<Datass.ResultBean> list);
    }

    onclick onclick;

    public void setOnclick(Showmodle.onclick onclick) {
        this.onclick = onclick;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    String obj = (String) msg.obj;
                    Gson gson = new Gson();
                    Datass datass = gson.fromJson(obj, Datass.class);
                    List<Datass.ResultBean> result = datass.getResult();
                    onclick.onclick(result);
            }
        }
    };

    public void showdata() {
        Okhttputils.getinstance().doget(url1, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Message message = new Message();
                message.what = 1;
                message.obj = string;
                handler.sendMessage(message);

            }
        });
    }
}
