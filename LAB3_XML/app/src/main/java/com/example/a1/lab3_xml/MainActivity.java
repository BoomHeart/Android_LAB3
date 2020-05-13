package com.example.a1.lab3_xml;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.app.Dialog;

public class MainActivity extends AppCompatActivity {
    private int checkedItem=0;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tx_test);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.men_1:
            {
                singleChoiceDialog();
                break;
            }
            case R.id.men_2:
            {
                Toast.makeText(MainActivity.this,"普通菜单项",Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.men_3:
            {
                singleChoiceDialog_1();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void singleChoiceDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);

        final String[] Items={" ","10号字","16号字","20号字"};
        builder.setSingleChoiceItems(Items,0,new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               // Toast.makeText(getApplicationContext(), "你选择了" + Items[which], Toast.LENGTH_SHORT).show();
                checkedItem= which;}
        }).
                setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (checkedItem)
                        {
                            case 1:{textView.setTextSize(10);break;}
                            case 2:{textView.setTextSize(16);break;}
                            case 3:{textView.setTextSize(20);break;}
                        }
                    }
                }).
                setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { }
                }).create();
        builder.show();
    }

    public void singleChoiceDialog_1() {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);

        final String[] Items={" ","红色","黑色"};
        builder.setSingleChoiceItems(Items,0,new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Toast.makeText(getApplicationContext(), "你选择了" + Items[which], Toast.LENGTH_SHORT).show();
                checkedItem= which;}
        }).
                setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (checkedItem)
                        {
                            case 1:{textView.setTextColor(Color.RED);break;}
                            case 2:{textView.setTextColor(Color.BLACK);break;}
                        }
                    }
                }).
                setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { }
                }).create();
        builder.show();
    }
}
