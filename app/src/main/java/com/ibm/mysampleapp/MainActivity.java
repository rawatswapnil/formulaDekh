package com.ibm.mysampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.ibm.mobilefirstplatform.clientsdk.android.core.api.BMSClient;




import com.cloudant.sync.datastore.Datastore;
import com.cloudant.sync.datastore.DatastoreManager;
import com.cloudant.sync.datastore.DatastoreNotCreatedException;



public class MainActivity extends AppCompatActivity 
{ 
    
    private java.net.URI cloudantUri;
    private Datastore ds;
    private DatastoreManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        // Core SDK must be initialized to interact with Bluemix Mobile services.
        BMSClient.getInstance().initialize(getApplicationContext(), BMSClient.REGION_GERMANY);

        

        

        

        

        

        

        // Create a DatastoreManager using application internal storage path
        java.io.File path = getApplicationContext().getDir("datastores", android.content.Context.MODE_PRIVATE);
        manager = DatastoreManager.getInstance(path);

        try {
            cloudantUri = new java.net.URI(getApplicationContext().getResources().getString(R.string.cloudantUrl) + "/your_db_name");
            // Create the Datastore object you'll use in all of your Cloudant operations:
            ds = manager.openDatastore("my_datastore");

            // At this point, you may wish to create pull and push replicators for bi-directional sync.  It is up
            // to you, the developer, to program the interaction between the Cloudant database and the mobile application.
            // A simple example follows.  The example does not include a countdown latch, does not show how to
            // subscribe to sync events, and ignores sync errors.

            // Create and run the pull replicator
            //com.cloudant.sync.replication.Replicator pullReplicator = com.cloudant.sync.replication.ReplicatorBuilder.pull().from(cloudantUri).to(ds).build();
            //pullReplicator.start();
            // Create and run the push replicator
            //com.cloudant.sync.replication.Replicator pushReplicator = com.cloudant.sync.replication.ReplicatorBuilder.push().to(cloudantUri).from(ds).build();
            //pushReplicator.start();

        } catch (java.net.URISyntaxException e) {
            android.util.Log.e("TAG", e.getMessage(), e);
        } catch (DatastoreNotCreatedException e) {
            android.util.Log.e("TAG", e.getMessage(), e);
        }

        
                
        
    }
    

    @Override
    public void onResume() {
        super.onResume();
        
        
        
    }

    @Override
    public void onPause() {
        super.onPause();
        
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

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void phyClick(View view) {
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }

    public void chemClick(View view) {
        Intent i = new Intent(this, Main3Activity.class);
        startActivity(i);
    }

    public void mathClick(View view) {
        Intent i = new Intent(this, Main4Activity.class);
        startActivity(i);
    }
}
