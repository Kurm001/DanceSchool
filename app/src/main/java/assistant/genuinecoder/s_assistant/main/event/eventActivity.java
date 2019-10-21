package assistant.genuinecoder.s_assistant.main.event;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import assistant.genuinecoder.s_assistant.R;
import assistant.genuinecoder.s_assistant.main.Login.Login;

public class eventActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter adapter;
    ArrayList<String> subs;
    ArrayList<String> event;
    ArrayList<String> times;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        subs = new ArrayList<>();
        times = new ArrayList<>();
        event = new ArrayList<>();
        listView = (ListView) findViewById(R.id.eventList);
        loadSchedules();
    }

    private void loadSchedules() {
        subs.clear();
        times.clear();
        String qu = "SELECT * FROM SCHEDULE";
        Cursor cursor = Login.handler.execQuery(qu);
        if (cursor == null || cursor.getCount() == 0) {
            Toast.makeText(getBaseContext(), "No events Available", Toast.LENGTH_LONG).show();
        } else {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                event.add(cursor.getString(1));
                subs.add(cursor.getString(1) + "\nfor " + cursor.getString(0) + "\nat " + cursor.getString(2) + " : " + cursor.getString(3));
                times.add(cursor.getString(2));
                cursor.moveToNext();
            }
        }
        adapter = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, subs);
        listView.setAdapter(adapter);
    }

    public void refresh(MenuItem item) {
        loadSchedules();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.scheduler_menu, menu);
        return true;
    }
}
