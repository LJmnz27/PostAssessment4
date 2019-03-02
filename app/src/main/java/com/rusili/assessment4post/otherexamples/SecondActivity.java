package com.rusili.assessment4post.otherexamples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private static final String INTENT_KEY = "someKey";

    public static void startWith(@NonNull Activity origin,
                                 @Nullable String extra) {
        Intent toSecondActivity = new Intent(origin, SecondActivity.class);
        toSecondActivity.putExtra(INTENT_KEY, extra);
        origin.startActivity(toSecondActivity);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getIntent().getStringExtra(INTENT_KEY);
    }
}
