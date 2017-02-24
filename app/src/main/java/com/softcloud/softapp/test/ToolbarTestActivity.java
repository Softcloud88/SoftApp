package com.softcloud.softapp.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import com.softcloud.softapp.R;

/**
 * Created by Softcloud{https://github.com/Softcloud88} on 2017/2/24.
 */

public class ToolbarTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toolbar);
        setupToolbar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("TestTitle");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbar.setNavigationIcon(R.mipmap.ic_launcher);

        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_search:
                    Toast.makeText(ToolbarTestActivity.this, "Search !", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_notifications:
                    Toast.makeText(ToolbarTestActivity.this, "Notificationa !", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_settings:
                    Toast.makeText(ToolbarTestActivity.this, "Settings !", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        });

        toolbar.setNavigationOnClickListener(v -> Toast.makeText(ToolbarTestActivity.this, "nav !", Toast.LENGTH_SHORT).show());
    }
}
