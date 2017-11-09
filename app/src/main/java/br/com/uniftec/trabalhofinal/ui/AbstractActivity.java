package br.com.uniftec.trabalhofinal.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import br.com.uniftec.trabalhofinal.R;

/**
 * Created by Fin on 08/11/2017.
 */

public abstract class AbstractActivity extends AppCompatActivity{

    protected ActionBar actionBar;
    public String title;

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        setupView();

    }

    protected abstract void setupView();


    protected abstract int getLayoutRes();
}
