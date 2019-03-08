package shixun.lj.bw.presenter;

import java.lang.ref.WeakReference;
import java.util.List;

import shixun.lj.bw.Showactivity;
import shixun.lj.bw.bean.Datass;
import shixun.lj.bw.model.Showmodle;
import shixun.lj.bw.view.Showview;

/*
  name:刘江
  data:2019
*/public class Showpresenter<T> {

    private final Showmodle showmodle;
    private WeakReference<T> tWeakReference;
    private final Showview showview1;

    public Showpresenter(Showview showview) {
        showmodle = new Showmodle();
        showview1 = showview;
    }

    public void show() {
        showmodle.showdata();
        showmodle.setOnclick(new Showmodle.onclick() {
            @Override
            public void onclick(List<Datass.ResultBean> list) {
                showview1.Showview(list);
            }
        });
    }

    public void attachview(T t) {
        tWeakReference = new WeakReference<>(t);
    }

    public void detachview() {
        if (tWeakReference != null) {
            tWeakReference.clear();
            tWeakReference = null;
        }
    }

}
