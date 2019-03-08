package shixun.lj.bw.okhttp;

import android.util.Log;

import java.io.IOException;
import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/*
  name:刘江
  data:2019     单例  懒汉式
*/public class Okhttputils {
    public static Okhttputils okhttputils = null;

    public Okhttputils() {
    }

    public static Okhttputils getinstance() {
        if (okhttputils == null) {
            synchronized (Okhttputils.class) {
                if (okhttputils == null) {
                    okhttputils = new Okhttputils();
                }
            }
        }
        return okhttputils;
    }

    public static OkHttpClient okHttpClient = null;

    public static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.i("aaaa", message);
                }
            });
            okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request().newBuilder().addHeader("source", "android").build();
                            return chain.proceed(request);
                        }
                    }).build();
        }
        return okHttpClient;
    }

    //封装get方法
    public static void doget(String url, Callback callback) {
        Request request = new Request.Builder().url(url).build();
        getOkHttpClient().newCall(request).enqueue(callback);
    }

    //封装post
    public static void dopost(String url, Map<String, String> list, Callback callback) {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : list.keySet()) {
            builder.add(key, list.get(key));
        }
        FormBody build = builder.build();
        Request request = new Request.Builder().post(build).url(url).build();
        getOkHttpClient().newCall(request).enqueue(callback);
    }


}
