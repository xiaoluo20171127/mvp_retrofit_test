package com.coocaa.mvptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.coocaa.mvptest.model.HotKey;
import com.coocaa.mvptest.presenter.DataPresenter;
import com.coocaa.mvptest.presenter.IDataPresenter;
import com.coocaa.mvptest.view.IDataView;

public class MainActivity extends AppCompatActivity implements IDataView {
    IDataPresenter mIDataPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mIDataPresenter = new DataPresenter(this);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIDataPresenter.download();
            }
        });
        Button showData = findViewById(R.id.showDataBtn);
        showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIDataPresenter.showData();
            }
        });
    }

    @Override
    public void download() {
        Toast.makeText(this, "download", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void downloadSuccess() {
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void downloadFail(String msg) {

    }

    @Override
    public void showData(HotKey hotKey) {
        TextView dataView = findViewById(R.id.dataView);
        if(hotKey!=null){
            dataView.setText(hotKey.getData().get(0).getName());
        }
    }
}
