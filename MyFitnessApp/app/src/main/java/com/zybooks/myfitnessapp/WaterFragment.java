package com.zybooks.myfitnessapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WaterFragment extends Fragment {

    private static final String PREFS_NAME = "water_tracker_prefs";
    private static final String KEY_WATER_CONSUMED = "water_consumed";

    private int waterGoal = 8; // glasses of water per day
    private int waterConsumed;
    private TextView currentWaterText;
    private ProgressBar waterProgressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_water, container, false);

        TextView dailyWaterGoalText = view.findViewById(R.id.daily_water_goal);
        currentWaterText = view.findViewById(R.id.current_water);
        waterProgressBar = view.findViewById(R.id.water_progress_bar);
        Button addWaterButton = view.findViewById(R.id.add_water_button);

        // Set up initial values and load saved data
        dailyWaterGoalText.setText("Daily Water Goal: " + waterGoal + " glasses");
        updateWaterDisplay();

        // Add water button click listener
        addWaterButton.setOnClickListener(v -> addWater(1)); // Adding 1 glass of water

        return view;
    }

    private void addWater(int glasses) {
        if (waterConsumed < waterGoal) { // Ensure we don't exceed the goal
            waterConsumed += glasses;// Save the updated count
            updateWaterDisplay();
        }
    }

    private void updateWaterDisplay() {
        currentWaterText.setText("Water Consumed: " + waterConsumed + " glasses");
        waterProgressBar.setProgress(waterConsumed); // Update the progress bar
    }

}