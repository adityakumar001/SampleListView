package com.emptyfruits.com.samplelistview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.emptyfruits.com.samplelistview.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Human[] population;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        population = new Human[15];
        setPopulation();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.sampleList.setAdapter(new MyAdapter(this, R.layout.my_list_item, population));


    }

    private void setPopulation() {
        Random random = new Random();
        for (int i = 0; i < population.length; i++) {
            population[i] = new Human("abcd" + random.nextInt(100),
                    String.valueOf(random.nextInt(100)),
                    "abc@abc" + random.nextInt(100));
        }
    }

}
