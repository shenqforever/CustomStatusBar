package contract;

import android.content.Context;

import com.google.gson.GsonBuilder;

import api.ApiService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sq719 on 2018/3/14.
 *
 */

public class RetrofitHelper {
    private Context mContext;
    private static RetrofitHelper instance = null;
    private Retrofit mRetrofit = null;
    OkHttpClient client = new OkHttpClient();
    GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());

    public static RetrofitHelper getInstance(Context context) {
        if (instance != null) {
            instance = new RetrofitHelper(context);
        }
        return instance;
    }
    private RetrofitHelper(Context mContext){
        mContext = mContext;
        resetApp();
    }

    private void resetApp() {
        mRetrofit=new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public ApiService getServer(){
        return mRetrofit.create(ApiService.class);
    }
}
