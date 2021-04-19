package com.mrhi2020.ex93youtubeplayer;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.youtube.player.YouTubePlayerFragment;

public class PageFragment extends Fragment {

    YouTubePlayerFragment youTubePlayerFragment;
    String videoId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentManager fm= getChildFragmentManager();

    }

    @Override
    public void onResume() {
        super.onResume();

        ((SecondActivity)getActivity()).getSupportActionBar().setTitle(videoId);
    }
}
