package com.rusili.assessment4post.detail;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.rusili.assessment4post.R;
import com.squareup.picasso.Picasso;

public class DetailFragment extends Fragment {
    private static final String NAME_KEY = "name";
    private static final String IMAGE_KEY = "image";
    private static final String WIKI_KEY = "wiki";

    private OnFragmentInteractionListener listener;

    private String animalName;
    private String animalImage;
    private String animalwebsite;

    // Pass in data to Fragment through static method parameters.
    static DetailFragment newInstance(@Nullable String name,
                                             @Nullable String image,
                                             @Nullable String wiki) {
        final DetailFragment detailFragment = new DetailFragment();
        final Bundle args = new Bundle();
        args.putString(NAME_KEY, name);
        args.putString(IMAGE_KEY, image);
        args.putString(WIKI_KEY, wiki);
        detailFragment.setArguments(args);

        return detailFragment;
    }

    // Get interface/listener from parent Activity in onAttach, cast it from Context to listener class
    // and save it as a field.
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new ClassCastException(context.toString() + "must implement this interface");
        }
    }

    // Retrieve passed in data in OnCreate
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            animalName = getArguments().getString(NAME_KEY);
            animalImage = getArguments().getString(IMAGE_KEY);
            animalwebsite = getArguments().getString(WIKI_KEY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView nameTextView = view.findViewById(R.id.detail_animal_name);
        final ImageView animalImageView = view.findViewById(R.id.detail_animal_image);
        final Button showWebsiteButton = view.findViewById(R.id.detail_website_button);

        nameTextView.setText(animalName);
        Picasso.get().load(animalImage)
                .into(animalImageView);
        showWebsiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentInteraction(animalwebsite);
            }
        });
    }

    // Nullify listener on detach or you will get memory leaks!
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    interface OnFragmentInteractionListener {
        void onFragmentInteraction(String website);
    }
}
