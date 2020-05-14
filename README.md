# LAB3实验报告

## 实验要求：

1、Android ListView的用法

2、创建自定义布局的AlertDialog

3、使用XML定义菜单

4、创建上下文操作模式(ActionMode)的上下文菜单

## 实验过程

### 1、Android ListView的用法

代码：

animal_item.xml:
```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/animal_name"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginLeft="10dp" />

    <ImageView
        android:id="@+id/animal_image"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginLeft="270dp"
        />
</LinearLayout>
```

activity_main.xml:

```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/animal_name"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginLeft="10dp" />

    <ImageView
        android:id="@+id/animal_image"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginLeft="270dp"
        />
</LinearLayout>
```

AnimalAdapter.java:

```java
package com.example.a1.lab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AnimalAdapter extends ArrayAdapter {
    private  final int resourceId;

    public AnimalAdapter(Context context, int textViewResourceId, List<Animal> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Animal animal = (Animal) getItem(position); // 获取当前项的Animal实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
        ImageView animalImage = (ImageView) view.findViewById(R.id.animal_image);//获取该布局内的图片视图
        TextView animalName = (TextView) view.findViewById(R.id.animal_name);//获取该布局内的文本视图
        animalImage.setImageResource(animal.getImageId());//为图片视图设置图片资源
        animalName.setText(animal.getName());//为文本视图设置文本内容
        return view;
    }
}
```

Animal.java:

```java
package com.example.a1.lab3;


public class Animal {
    private String name;
    private int imageId;

    public Animal(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
```

android_ListView.java:

```java
package com.example.a1.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.util.Log;
import android.view.View;
import android.widget.SimpleAdapter;





public class android_ListView extends AppCompatActivity{
    private List<Animal> animalList = new ArrayList<Animal>();
    //private TextView textView;
    private static final String TAG = "myTag";
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAnimals(); // 初始化动物数据
        AnimalAdapter adapter = new AnimalAdapter(android_ListView.this, R.layout.animal_item, animalList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        Toast toast = Toast.makeText(getApplicationContext(), "lion", Toast.LENGTH_LONG);
        toast.show();
    }
    private void initAnimals() {
        Animal lion = new Animal("Lion", R.drawable.lion_pic);
        animalList.add(lion);
        Animal tiger = new Animal("Tiger", R.drawable.tiger_pic);
        animalList.add(tiger);
        Animal monkey = new Animal("Monkey", R.drawable.monkey_pic);
        animalList.add(monkey);
        Animal dog = new Animal("Dog", R.drawable.dog_pic);
        animalList.add(dog);
        Animal cat = new Animal("Cat", R.drawable.cat_pic);
        animalList.add(cat);
        Animal elephant = new Animal("Elephant", R.drawable.elephant_pic);
        animalList.add(elephant);
    }
}
```

运行结果：

![picture](https://github.com/BoomHeart/Android_LAB3/blob/master/LAB3/1.png)

### 2、创建自定义布局的AlertDialog

代码：

activity_main.xml:

```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#169ee5"
        android:gravity="center"
        android:text="Android App"
        android:textColor="@android:color/white"
        android:textSize="20sp" />

    <EditText
        android:id="@+id/et_name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Username"
        android:textSize="18sp" />

    <EditText
        android:id="@+id/et_pwd"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Password"
        android:inputType="textPassword"
        android:textSize="18sp" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="5dp"
        android:orientation="horizontal"
        android:paddingLeft="5dp"
        android:paddingRight="5dp">

        <Button
            android:id="@+id/btn_cancel"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginRight="10dp"
            android:layout_weight="1"
            android:background="#169ee5"
            android:text="Cancel"
            android:textColor="@android:color/white"
            android:textSize="16sp" />

        <Button
            android:id="@+id/btn_login"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:background="#169ee5"
            android:text="sign in"
            android:textColor="@android:color/white"
            android:textSize="16sp" />
    </LinearLayout>
</LinearLayout>
```

MainActivity.java:

```java
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
```
运行结果：

![picture](https://github.com/BoomHeart/Android_LAB3/blob/master/LAB3_alterdialog/2.png)

### 3、使用XML定义菜单

代码:

menu_1.xml:

```java
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:title="字体大小"
           android:id="@+id/men_1"/>
    <item android:title="普通菜单项"
        android:id="@+id/men_2"/>
    <item android:title="字体颜色"
        android:id="@+id/men_3"/>
</menu>
```

activity_main.xml:

```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent">
    <TextView
        android:id="@+id/tx_test"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="测试文字"
        android:textSize="100dp"
        android:textColor="#7CFC00"/>
</LinearLayout>
```

MainActivity:

```java
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
```

运行结果：

![pic](https://github.com/BoomHeart/Android_LAB3/blob/master/LAB3_XML/1.png)
![pic](https://github.com/BoomHeart/Android_LAB3/blob/master/LAB3_XML/2.png)
![pic](https://github.com/BoomHeart/Android_LAB3/blob/master/LAB3_XML/3.png)
![pic](https://github.com/BoomHeart/Android_LAB3/blob/master/LAB3_XML/4.png)
![pic](https://github.com/BoomHeart/Android_LAB3/blob/master/LAB3_XML/5.png)
![pic](https://github.com/BoomHeart/Android_LAB3/blob/master/LAB3_XML/6.png)
![pic](https://github.com/BoomHeart/Android_LAB3/blob/master/LAB3_XML/7.png)

### 4、创建上下文操作模式(ActionMode)的上下文菜单

代码：

context_menu.xml:

```java
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:android="http://schemas.android.com/apk/res/android" >

    <item
        android:id="@+id/item_delete"
        android:icon="@android:drawable/ic_menu_delete"
        android:title="Delete"
        android:titleCondensed="Delete"
        app:showAsAction="ifRoom|withText">
    </item>

</menu>
```

row_list_item.xml:

```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:layout_gravity="center_vertical"
    android:padding="5dp"
    android:background="@android:color/background_light">

    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@mipmap/ic_launcher_round" />

    <TextView
        android:id="@+id/textView1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="17sp"
        android:layout_marginLeft="10dp"
        android:text="Test"
        android:textStyle="bold" />

</LinearLayout>
```
activity_main.xml:

```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ListView
        android:id="@android:id/list"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_centerVertical="true"
        android:choiceMode="multipleChoice">
    </ListView>
</LinearLayout>
```
MainActivity:

```java
package com.example.a1.lab3_actionmode;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;
import java.util.Set;
public class MainActivity extends ListActivity {

    private String[] data = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten"};
    private SelectionAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new SelectionAdapter(this,
                R.layout.row_list_item, R.id.textView1, data);
        setListAdapter(mAdapter);
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        getListView().setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            private int nr = 0;

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                mAdapter.clearSelection();
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {

                nr = 0;
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.context_menu, menu);
                return true;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.item_delete:
                        nr = 0;
                        mAdapter.clearSelection();
                        mode.finish();
                }
                return false;
            }

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {

                if (checked) {
                    nr++;
                    mAdapter.setNewSelection(position, checked);
                } else {
                    nr--;
                    mAdapter.removeSelection(position);
                }
                mode.setTitle(nr + " selected");

            }
        });

        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int position, long arg3) {


                getListView().setItemChecked(position, !mAdapter.isPositionChecked(position));
                return false;
            }
        });
    }

    private class SelectionAdapter extends ArrayAdapter<String> {

        private HashMap<Integer, Boolean> mSelection = new HashMap<Integer, Boolean>();

        public SelectionAdapter(Context context, int resource,
                                int textViewResourceId, String[] objects) {
            super(context, resource, textViewResourceId, objects);
        }

        public void setNewSelection(int position, boolean value) {
            mSelection.put(position, value);
            notifyDataSetChanged();
        }

        public boolean isPositionChecked(int position) {
            Boolean result = mSelection.get(position);
            return result == null ? false : result;
        }

        public Set<Integer> getCurrentCheckedPosition() {
            return mSelection.keySet();
        }

        public void removeSelection(int position) {
            mSelection.remove(position);
            notifyDataSetChanged();
        }

        public void clearSelection() {
            mSelection = new HashMap<Integer, Boolean>();
            notifyDataSetChanged();
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = super.getView(position, convertView, parent);
            v.setBackgroundColor(getResources().getColor(android.R.color.background_light));

            if (mSelection.get(position) != null) {
                v.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
            }
            return v;
        }
    }
  }
  ```
  
  运行结果：
  
  ![pic](https://github.com/BoomHeart/Android_LAB3/blob/master/LAB3_ActionMode/1.png)
