package dam.invisere.gtidic.udl.cat.myevents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = this.getSharedPreferences("numEvents", Context.MODE_PRIVATE);
        preferences.edit().putInt("numEvents", 0).apply();
    }
}