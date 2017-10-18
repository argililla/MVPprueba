package com.example.felixargila.mvpprueba.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.felixargila.mvpprueba.R;
import com.example.felixargila.mvpprueba.presenter.MainPresenter;
import com.example.felixargila.mvpprueba.presenter.MainPresenterImp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements MainView{

    private MainPresenter presenter;
    @BindView(R.id.btn) Button btn;
    //private Button btn;
    @BindView(R.id.tv1) TextView tv1;
    //private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenterImp(this);

        ButterKnife.bind(this);

        //btn = (Button)findViewById(R.id.btn);
        //tv1 = (TextView)findViewById(tv1);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText(presenter.cambiarTexto());
            }
        });


    }
}
