package com.example.a1.lab3_alterdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Alterdialog();
    }
    public void Alterdialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        final AlertDialog dialog = builder.create();
        View dialogView = View.inflate(MainActivity.this, R.layout.activity_main, null);
        dialog.setView(dialogView);
        dialog.show();
    }

}
