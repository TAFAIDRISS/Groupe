package com.FiCallibCallib.callibvideoibfake.Video;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.FiCallibCallib.callibvideoibfake.R;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.controls.Facing;
import java.util.ArrayList;
import java.util.Random;

public class AdapterViedo extends RecyclerView.Adapter<AdapterViedo.VideoHolder> {

    ArrayList<Videomodel> videoList;

    Context context;
    boolean isplay = true;
    boolean switsh;

    public AdapterViedo(ArrayList<Videomodel> videoList, Context context) {
        this.videoList = videoList;
        this.context = context;
    }


    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.item_videoview, parent, false);
        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoHolder holder, int position) {

        holder.setVideoData(videoList.get(position));

        holder.switshCamera.setOnClickListener(View -> {

            if (isplay) {
                holder.camera.open();
                holder.camera.setFacing(Facing.BACK);
                holder.switshCamera.setImageResource(R.drawable.ic_camera);
                isplay = false;
            } else {
                holder.camera.open();
                holder.camera.setFacing(Facing.FRONT);
                holder.switshCamera.setImageResource(R.drawable.ic_camera_switsh);
                isplay = true;
            }

        });
        holder.switshMute.setOnClickListener(View -> {

            if (switsh == true) {

                holder.switshMute.setImageResource(R.drawable.ic_mute);
                switsh = false;
            } else {
                holder.switshMute.setImageResource(R.drawable.ic_vocal);
                switsh = true;
            }

        });
        holder.cashCamera.setOnClickListener(View -> {
            if (switsh == true) {
                holder.camera.open();
                holder.cashCamera.setImageResource(R.drawable.ic_videocalling);
                holder.camera.setVisibility(android.view.View.VISIBLE);
                switsh = false;
            } else {

                holder.cashCamera.setImageResource(R.drawable.ic_cmera_cashed);
                holder.camera.setVisibility(android.view.View.GONE);
                switsh = true;
            }
        });

        holder.finishCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }


    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public class VideoHolder extends RecyclerView.ViewHolder {

        ProgressBar progressBar;
        VideoView videoView;
        private CameraView camera, cameraFull;
        TextView titlee;
        ImageView switshCamera, switshMute, cashCamera, finishCall;

        public VideoHolder(@NonNull View itemView) {
            super(itemView);

            videoView = itemView.findViewById(R.id.videoview);

            progressBar = itemView.findViewById(R.id.progress);

            camera = itemView.findViewById(R.id.camera);
            cameraFull = itemView.findViewById(R.id.camerFullscreen);

            titlee = itemView.findViewById(R.id.tv_conecting);

            switshCamera = itemView.findViewById(R.id.switch_camera);
            switshMute = itemView.findViewById(R.id.mute_sound);
            cashCamera = itemView.findViewById(R.id.camer_cashcamera);
            finishCall = itemView.findViewById(R.id.call_end);
        }

        public void setVideoData(Videomodel video) {

            videoView.setVideoPath(video.getVideourl());
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            titlee.setVisibility(View.GONE);
                            progressBar.setVisibility(View.GONE);
                            mediaPlayer.start();
                            camera.open();

                        }
                    }, 3000);
                }
            });
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });

        }
    }
}

   /* private void generatRandom() {
        Random random = new Random();
        int randomint = random.nextInt(videoList.size());
        while (list_rand.size() != videoList.size()) {
            if (list_rand.contains(randomint)) {
                generatRandom();
            } else {
                list_rand.add(randomint);
            }

        }


    }
}

    */


