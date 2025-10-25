package com.example.musicprank;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.media.MediaPlayer;

public class MainActivity extends Activity {
    
    private MediaPlayer mediaPlayer;
    private Button btnPlay;
    private TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnPlay = findViewById(R.id.btnPlay);
        txtMessage = findViewById(R.id.txtMessage);
        
        mediaPlayer = MediaPlayer.create(this, R.raw.song);
        
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic();
            }
        });
    }
    
    private void playMusic() {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            txtMessage.setText("🎵 Это шутка! 🎵\nРасслабься!");
            btnPlay.setText("Музыка играет!");
            btnPlay.setEnabled(false);
        }
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}
