package com.InfoTrip;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by GaryC on 3/30/2016.
 */
public class VideoFragment extends Fragment {
    public static final String TAG = VideoFragment.class.getSimpleName();

    VideoView vidView;
    MediaController vidControl;
    ProgressDialog progressDialog;
    int position = 0;

    public static VideoFragment newInstance() {
        Bundle args = new Bundle();
        VideoFragment fragment = new VideoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) {
            position = savedInstanceState.getInt("Position");
        }
//        Intent intent = new Intent(getActivity(), VideoIntentService.class);
//        getActivity().startService(intent);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_video, container, false);
        if(vidControl == null) {
            vidControl = new MediaController(getActivity());
        }
        vidView = (VideoView) view.findViewById(R.id.vid_view);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle(R.string.tv_vid_progress_title);
        progressDialog.setMessage(getString(R.string.vid_progress_loading));
        progressDialog.setCancelable(false);
        progressDialog.show();
        try {
            vidView.setMediaController(vidControl);
            vidView.setVideoURI(parseVideoUri());
            vidControl.setAnchorView(vidView);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        vidView.requestFocus();
        vidView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                progressDialog.dismiss();
                vidView.seekTo(position);
                if(position == 0) {
                    vidView.start();
                } else {
                    vidView.pause();
                }
            }
        });

        vidView.start();
        return view;
    }

    public Uri parseVideoUri() {
        String vidAddress = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
        String vidAddress1 = "http://www.androidbegin.com/tutorial/AndroidCommercial.3gp";
        return Uri.parse(vidAddress1);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Position", vidView.getCurrentPosition());
        vidView.pause();
    }

}
