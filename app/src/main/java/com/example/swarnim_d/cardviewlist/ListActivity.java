package com.example.swarnim_d.cardviewlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public String[] flowerNameArray = {"Rose", "Jasmine", "Lilly", "Sunflower", "Aster", "Tulip", "Lotus", "Sakura"};
    public String[] flowerDescArray = {"Rose is red", "Jasmine is white", "Lilly is yellow", "Sunflower is orange", "Aster is purple", "Tulips are pink", "Lotus is white", "Sakura is colourful"};
    int[] flowerImageArray = {R.drawable.rose,R.drawable.lilly,R.drawable.rose,R.drawable.lilly,R.drawable.rose,R.drawable.lilly,R.drawable.rose,R.drawable.lilly};
    ArrayList<FlowerModel> arrayListModel = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        for(int i=0;i<flowerNameArray.length;i++) {
            FlowerModel flowerModel = new FlowerModel();
            flowerModel.setmText(flowerNameArray[i]);
            flowerModel.setmDescription(flowerDescArray[i]);
            flowerModel.setmImage(flowerImageArray[i]);
            arrayListModel.add(flowerModel);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);// recycler view size do not change according to the size of content

        //creating Layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //Creating and setting Adapter
        mAdapter = new RecyclerViewAdapter(arrayListModel);
        mRecyclerView.setAdapter(mAdapter);



    }
}
