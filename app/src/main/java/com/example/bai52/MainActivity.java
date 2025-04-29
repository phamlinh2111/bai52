package com.example.bai52;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListAdapter fruitArrayAdapter;
    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Danh sách trái cây");

        listView = findViewById(R.id.listView);
        List<Fruit> fruitList = new ArrayList<>();
        List<String[]> fruitDataList = readData();
        for (String[] fruitData : fruitDataList) {
            String fruitImg = fruitData[0];
            String fruitName = fruitData[1];
            String calories = fruitData[2];

            int fruitImgResId = getResources().getIdentifier(fruitImg, "drawable", getPackageName());

            Fruit fruit = new Fruit(fruitImgResId, fruitName, calories);
            fruitList.add(fruit);
        }

        fruitArrayAdapter = new ListAdapter(getApplicationContext(), fruitList);
        listView.setAdapter(fruitArrayAdapter);
    }

    public List<String[]> readData() {
        List<String[]> resultList = new ArrayList<>();

        resultList.add(new String[]{"orange", "Orange", "47 Calories"});
        resultList.add(new String[]{"cherry", "Cherry", "50 Calories"});
        resultList.add(new String[]{"banana", "Banana", "89 Calories"});
        resultList.add(new String[]{"apple", "Apple", "52 Calories"});
        resultList.add(new String[]{"kiwi", "Kiwi", "61 Calories"});
        resultList.add(new String[]{"pear", "Pear", "57 Calories"});
        resultList.add(new String[]{"strawberry", "Strawberry", "33 Calories"});
        resultList.add(new String[]{"lemon", "Lemon", "29 Calories"});
        resultList.add(new String[]{"peach", "Peach", "39 Calories"});
        resultList.add(new String[]{"apricot", "Apricot", "48 Calories"});
        resultList.add(new String[]{"mango", "Mango", "60 Calories"});

        return resultList;
    }
}
