package com.softcloud.softapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.softcloud.model.HealthStoneApi;
import com.softcloud.model.base.AllCardsModel;
import com.softcloud.softapp.base.HealthStone100Application;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        retrofit = HealthStone100Application.getAppComponent().retrofit();
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener((v) -> postRequest());
    }

    private void postRequest() {
        Flowable<AllCardsModel> flowable = retrofit.create(HealthStoneApi.class)
                //.getAllCards("1", "true", "1", "", "1", "zhCN");
                .getAllCards("1", "3", "zhCN");
        flowable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<AllCardsModel>() {
            @Override
            public void accept(AllCardsModel allCardsModel) throws Exception {
                Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Toast.makeText(MainActivity.this, "fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
