package com.softcloud.softapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.softcloud.model.HealthStoneApi;
import com.softcloud.model.base.AllCardsModel;
import com.softcloud.softapp.base.HealthStone100Application;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);

        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_search:
                    Toast.makeText(MainActivity.this, "Search !", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_notifications:
                    Toast.makeText(MainActivity.this, "Notificationa !", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_settings:
                    Toast.makeText(MainActivity.this, "Settings !", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        });
        toolbar.setNavigationOnClickListener(v -> Toast.makeText(MainActivity.this, "nav !", Toast.LENGTH_SHORT).show());
    }

    private void init() {
        retrofit = HealthStone100Application.getAppComponent().retrofit();
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener((v) -> postRequest());
    }

    private void postRequest() {
        retrofit.create(HealthStoneApi.class)
                //.getAllCards("1", "true", "1", "", "1", "zhCN");
                .getAllCards("1", "3", "zhCN")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<AllCardsModel>() {
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
