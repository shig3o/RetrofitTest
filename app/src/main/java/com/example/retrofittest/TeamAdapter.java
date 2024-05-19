package com.example.retrofittest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.retrofittest.Team;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private List<Team> teamList;

    public TeamAdapter(List<Team> teamList) {
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false);
        return new TeamViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = teamList.get(position);
        holder.teamNameTextView.setText(team.getStrTeam());
        holder.teamStadiumTextView.setText(team.getStrStadium());
        // Use Picasso or Glide to load image from URL
        Picasso.get().load(team.getStrTeamBadge()).into(holder.teamBadgeImageView);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder {
        public ImageView teamBadgeImageView;
        public TextView teamNameTextView;
        public TextView teamStadiumTextView;

        public TeamViewHolder(View view) {
            super(view);
            teamBadgeImageView = view.findViewById(R.id.teamBadge);
            teamNameTextView = view.findViewById(R.id.teamName);
            teamStadiumTextView = view.findViewById(R.id.teamStadium);
        }
    }
}
