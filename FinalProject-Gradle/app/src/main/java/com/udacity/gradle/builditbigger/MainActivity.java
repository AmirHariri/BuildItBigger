package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.TellJoke;


public class MainActivity extends AppCompatActivity {
    public TellJoke joke;
    String newJoke;
    ProgressBar spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.GONE);
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

    @Override
    protected void onStart() {
        super.onStart();
        spinner.setVisibility(View.GONE);
    }

    public void tellJoke(View view) {
        spinner.setVisibility(View.VISIBLE);
        new JokesEndpointsAsyncTask().execute(this);

        /*
        Random rand = new Random();
        int  jokeNumber = rand.nextInt(3);
        joke = new TellJoke();
        newJoke = joke.tellAJoke(jokeNumber);
        Intent telljokeIntent = new Intent(this, DisplayJokeActivity.class);
        telljokeIntent.putExtra("JOKE",newJoke);
        startActivity(telljokeIntent);*/

        //Toast.makeText(this, newJoke, Toast.LENGTH_SHORT).show();
    }


}
