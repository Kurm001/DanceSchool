package assistant.genuinecoder.s_assistant.main.music;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import assistant.genuinecoder.s_assistant.R;

//created by Sean Jordan
public class musicActivity extends AppCompatActivity {

    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_layout);
        //Related to the media player
        final MediaPlayer myMediaPlayer = MediaPlayer.create(musicActivity.this, R.raw.thillana);
        //Button related to play btn
        Button myButtonOne = (Button) findViewById(R.id.songButton);
        myButtonOne.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                myMediaPlayer.start();

            }
        });
        //Button related to stop btn
        Button myButtonTwo = (Button) findViewById(R.id.stopSong);
        myButtonTwo.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                myMediaPlayer.pause();

            }
        });
    }
}
