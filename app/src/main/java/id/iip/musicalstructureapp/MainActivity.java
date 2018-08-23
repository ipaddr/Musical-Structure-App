package id.iip.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> musics;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.list_view);

        init();
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, musics));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, musics.get(i), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("data", musics.get(i));
                startActivity(intent);
            }
        });
    }

    private void init(){
        musics = new ArrayList<String>();
        musics.add("song a");
        musics.add("song b");
        musics.add("song c");
        musics.add("song d");
        musics.add("song e");
        musics.add("song f");
        musics.add("song g");
        musics.add("song h");
        musics.add("song i");
        musics.add("song j");
    }
}
