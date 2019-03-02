package com.rusili.assessment4post.list.rv;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rusili.assessment4post.list.MainNavigator;
import com.rusili.assessment4post.R;
import com.rusili.assessment4post.list.model.Animal;
import com.squareup.picasso.Picasso;

class AnimalViewHolder extends RecyclerView.ViewHolder {
    private final MainNavigator navigator;

    // Pass in interface if changing fragments or activities.
    // Save it as a field for onBind.
    AnimalViewHolder(@NonNull View itemView,
                     @NonNull MainNavigator navigator) {
        super(itemView);
        this.navigator = navigator;
    }

    void onBind(@Nullable final Animal animal) {
        ((TextView) itemView.findViewById(R.id.keno_name)).setText(animal.getAnimal());
        Picasso.get()
                .load(animal.getImage())
                .into(((ImageView) itemView.findViewById(R.id.keno_thingy)));

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.toSecondActivity(animal);
            }
        });
    }
}
