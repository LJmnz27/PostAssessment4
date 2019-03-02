package com.rusili.assessment4post.list.rv;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rusili.assessment4post.list.MainNavigator;
import com.rusili.assessment4post.R;
import com.rusili.assessment4post.list.model.Animal;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {
    // These fields can all be final IF they're being instantiated in the constructor
    private final List<Animal> animals;
    private final MainNavigator navigator;

    // Pass in interface through adapter constructor if viewholder needs to change fragments or activities.
    // Save it as a field to pass into the viewholder's constructor later on.
    public AnimalAdapter(@Nullable List<Animal> animals,
                         @NonNull MainNavigator navigator) {
        this.animals = animals;
        this.navigator = navigator;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.animal_itemview, viewGroup, false);
        return new AnimalViewHolder(view, navigator);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder animalViewHolder, int i) {
        // Pass in model instead of specific properties of said model.
        animalViewHolder.onBind(animals.get(i));
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }
}
