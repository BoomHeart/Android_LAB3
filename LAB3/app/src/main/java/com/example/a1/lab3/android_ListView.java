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




