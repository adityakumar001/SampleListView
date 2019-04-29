package com.emptyfruits.com.samplelistview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.emptyfruits.com.samplelistview.databinding.MyListItemBinding;

public class MyAdapter extends ArrayAdapter<Human> {
    private Human[] population;
    private Context context;

    @Override
    public Human getItem(int position) {
        return population[position];
    }

    MyAdapter(Context context, int resource, Human[] population) {
        super(context, resource, population);
        this.context = context;
        this.population = population;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyListItemBinding listItemBinding = DataBindingUtil.getBinding(convertView);
        if (listItemBinding == null) {
            listItemBinding = DataBindingUtil
                    .inflate(LayoutInflater.from(context), R.layout.my_list_item, parent,
                            false);
        }
        listItemBinding.age.setText(population[position].getAge());
        listItemBinding.name.setText(population[position].getName());
        listItemBinding.email.setText(population[position].getEmail());
        return listItemBinding.getRoot();
    }

}
