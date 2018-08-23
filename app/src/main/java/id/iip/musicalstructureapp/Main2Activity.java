package id.iip.musicalstructureapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    private String song;
    private TextView tvSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        if (getIntent() != null && getIntent().hasExtra("data")){
            song = getIntent().getStringExtra("data");
        }

        tvSong = (TextView)findViewById(R.id.song);
        if (song != null & !TextUtils.isEmpty(song)){
            tvSong.setText(song);
        }
    }
}
