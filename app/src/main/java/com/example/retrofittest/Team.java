package com.example.retrofittest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Team {
    @SerializedName("idTeam")
    private String idTeam;

    @SerializedName("strTeam")
    private String strTeam;

    @SerializedName("strStadium")
    private String strStadium;

    @SerializedName("strTeamBadge")
    private String strTeamBadge;

    // Getters and setters
    public String getIdTeam() { return idTeam; }
    public void setIdTeam(String idTeam) { this.idTeam = idTeam; }

    public String getStrTeam() { return strTeam; }
    public void setStrTeam(String strTeam) { this.strTeam = strTeam; }

    public String getStrStadium() { return strStadium; }
    public void setStrStadium(String strStadium) { this.strStadium = strStadium; }

    public String getStrTeamBadge() { return strTeamBadge; }
    public void setStrTeamBadge(String strTeamBadge) { this.strTeamBadge = strTeamBadge; }
}

