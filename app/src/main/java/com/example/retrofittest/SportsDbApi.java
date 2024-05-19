package com.example.retrofittest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SportsDbApi {
    @GET("search_all_teams.php?l=English%20Premier%20League")
    Call<TeamsResponse> getAllTeams();
}
