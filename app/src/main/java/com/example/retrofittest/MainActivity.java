package com.example.retrofittest;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofittest.Team;
import com.example.retrofittest.TeamsResponse;
import com.example.retrofittest.ApiClient;
import com.example.retrofittest.SportsDbApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TeamAdapter teamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadTeams();
    }

    private void loadTeams() {
        SportsDbApi apiService = ApiClient.getRetrofitInstance().create(SportsDbApi.class);
        Call<TeamsResponse> call = apiService.getAllTeams();
        call.enqueue(new Callback<TeamsResponse>() {
            @Override
            public void onResponse(Call<TeamsResponse> call, Response<TeamsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Team> teams = response.body().getTeams();
                    teamAdapter = new TeamAdapter(teams);
                    recyclerView.setAdapter(teamAdapter);
                }
            }

            @Override
            public void onFailure(Call<TeamsResponse> call, Throwable t) {
                // Handle error
            }
        });
    }
}