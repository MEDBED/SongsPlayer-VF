package com.geek_iit.www.songsplayer_vf;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;
import java.util.ArrayList;


public class Player extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MediaPlayer mp;
        ArrayList<File> MySongs;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        MySongs = (ArrayList) b.getParcelableArrayList("songlist");
        int position=b.getInt("pos",0);

        Uri u =Uri.parse(MySongs.get(position).toString());
        mp=MediaPlayer.create(getApplicationContext(),u);
        mp.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_player, menu);
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
