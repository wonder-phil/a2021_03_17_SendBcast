package me.pgb.a2021_03_17a_sendcustombcast;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button sendBroadCastButton;
    private EditText broadcastMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sendBroadCastButton = findViewById(R.id.send_broadcast_button);
        broadcastMessage = findViewById(R.id.broadcast_text);

        sendBroadCastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bText = broadcastMessage.getText().toString();
                Intent intent = new Intent("me.pgb.a2021_03_16a_breceiver.SEND_MESSAGE");
                intent.putExtra("me.pgb.a2021_03_16a_breceiver.SEND_MESSAGE", bText);
                sendBroadcast(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}