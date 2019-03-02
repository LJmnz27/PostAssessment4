package com.rusili.assessment4post.controller;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rusili.assessment4post.MainNavigator;
import com.rusili.assessment4post.R;
import com.rusili.assessment4post.model.Animal;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {
    private final List<Animal> animals;
    private final MainNavigator navigator;

    public AnimalAdapter(@Nullable List<Animal> animals,
                         @NonNull MainNavigator navigator) {
        this.animals = animals;
        this.navigator = navigator;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.animal_itemview, viewGroup, false);
        return new AnimalViewHolder(view, navigator);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder animalViewHolder, int i) {
        animalViewHolder.onBind(animals.get(i));
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }
}
