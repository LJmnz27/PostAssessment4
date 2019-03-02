package com.rusili.assessment4post;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.rusili.assessment4post.controller.AnimalAdapter;
import com.rusili.assessment4post.model.Animal;
import com.rusili.assessment4post.model.EchinodermResponse;
import com.rusili.assessment4post.network.EchinodermsService;
import com.rusili.assessment4post.network.RetrofitSingleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements MainNavigator {
    public static final String TAG = MainActivity.class.getSimpleName();

    public static final String NAME_KEY = "name key";
    public static final String IMAGE_KEY = "image key";
    public static final String WIKI_KEY = "wiki key";

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();

        retrofitEchinodermCall();
    }

    private void setViews() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void retrofitEchinodermCall() {
        final MainNavigator navigator = this;

        final Retrofit retrofit = RetrofitSingleton.getInstance();
        final EchinodermsService service = retrofit.create(EchinodermsService.class);
        service.getMessage().enqueue(new Callback<EchinodermResponse>() {
            @Override
            public void onResponse(Call<EchinodermResponse> call, Response<EchinodermResponse> response) {
                Log.d(TAG, "onResponse: " + response.body().getMessage().get(0).getAnimal());

                final AnimalAdapter adapter = new AnimalAdapter(response.body().getMessage(), navigator);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<EchinodermResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    @Override
    public void toSecondActivity(@Nullable Animal animal) {
        final Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(NAME_KEY, animal.getAnimal());
        intent.putExtra(IMAGE_KEY, animal.getImage());
        intent.putExtra(WIKI_KEY, animal.getWiki());
        startActivity(intent);
    }
}
