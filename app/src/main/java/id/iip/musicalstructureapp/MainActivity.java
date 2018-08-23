package id.iip.musicalstructureapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Song> songs;
    private ListView lv;
    private Button btn;
    private int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null && savedInstanceState.containsKey("position")){
            selectedPosition = savedInstanceState.getInt("position");
        }

        lv = (ListView)findViewById(R.id.list_view);

        init();
        lv.setAdapter(new ArrayAdapter<Song>(this, android.R.layout.simple_list_item_1, songs){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = null;

                if (view == null){
                    view = LayoutInflater.from(MainActivity.this).inflate(android.R.layout.simple_list_item_2, parent, false);
                }

                TextView songName = (TextView)view.findViewById(android.R.id.text1);
                songName.setText(songs.get(position).songName);

                TextView artistName = (TextView)view.findViewById(android.R.id.text2);
                artistName.setText(songs.get(position).artistName);

                return view;
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedPosition = i;

            }
        });

        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("data", songs.get(selectedPosition));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", selectedPosition);
    }

    private void init(){
        songs = new ArrayList<Song>();
        songs.add(new Song("song a", "artist a"));
        songs.add(new Song("song b", "artist b"));
        songs.add(new Song("song c", "artist c"));
        songs.add(new Song("song d", "artist d"));
        songs.add(new Song("song e", "artist e"));
        songs.add(new Song("song f", "artist f"));
        songs.add(new Song("song g", "artist g"));
        songs.add(new Song("song h", "artist h"));
        songs.add(new Song("song i", "artist i"));
        songs.add(new Song("song j", "artist j"));
    }
}
