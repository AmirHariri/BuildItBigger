package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.android.androidjokelibrary.DisplayJokeActivity;
import com.example.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
/**
 * Created by Amir on 11/5/2017.
 */
public class JokesEndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once

           MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver*/
/*
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    //my ip :192.168.2.21
                    .setRootUrl("https://192.168.2.21:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });*/

            myApiService = builder.build();
        }

        context = params[0];
        //String name = params[0].second;

        try {

            // return myApiService.sayHi("test").execute().getData();
            return myApiService.getJoke().execute().getData();

        } catch (IOException e) {
            return e.getMessage();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }


    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context,DisplayJokeActivity.class);
        intent.putExtra("JOKE",result);
        context.startActivity(intent);

        // Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }
}
