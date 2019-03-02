package com.rusili.assessment4post.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.rusili.assessment4post.R;
import com.rusili.assessment4post.list.MainActivity;

public class SecondActivity extends AppCompatActivity implements DetailFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final Intent intent = getIntent();
        final String name = intent.getStringExtra(MainActivity.NAME_KEY);
        final String image = intent.getStringExtra(MainActivity.IMAGE_KEY);
        final String wiki = intent.getStringExtra(MainActivity.WIKI_KEY);

        // Pass in data from activity to fragment through static method.
        final DetailFragment detailFragment = DetailFragment.newInstance(name, image, wiki);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .commit();
    }

    @Override
    public void onFragmentInteraction(@Nullable String website) {
        final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
        startActivity(intent);
    }
}
