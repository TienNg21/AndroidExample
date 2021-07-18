package vn.tien.androidexample;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    String msg = "Android : ";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(msg, "The onCreate() event");

        //Service
        findViewById(R.id.buttonStartService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(v);
            }
        });
        findViewById(R.id.buttonStopService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(v);
            }
        });

        //Broadcast Receiver
        findViewById(R.id.buttonBroadcastIntent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                broadcastIntent(v);
            }
        });
        //Content Provider
        findViewById(R.id.buttonAddName).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAddName(v);
            }
        });
        findViewById(R.id.buttonRetriveStudent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickRetrieveStudents(v);
            }
        });
    }

    /**
     * Called when the activity is about to become visible.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event");
    }

    /**
     * Called when the activity has become visible.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event");
    }

    /**
     * Called when another activity is taking focus.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event");
    }

    /**
     * Called when the activity is no longer visible.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event");
    }

    /**
     * Called just before the activity is destroyed.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }

    /** Service */
    public void startService(View view) {
        startService(new Intent(getBaseContext(), MyService.class));
    }

    // Method to stop the service
    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), MyService.class));
    }

    /** BroadcastReceiver */
    public void broadcastIntent(View view){
        Log.e("ok", "ok");
        Intent intent = new Intent(this, MyBroadcastReceiver.class);
        intent.setAction("vn.tien.CUSTOM_INTENT"); sendBroadcast(intent);
    }

    /** Content Provider*/
    public void onClickAddName(View view) {
        // Add a new student record
        ContentValues values = new ContentValues();
        values.put(MyContentProvider.NAME,
                ((EditText)findViewById(R.id.edittextAddName)).getText().toString());

        values.put(MyContentProvider.GRADE,
                ((EditText)findViewById(R.id.edittextAddGrade)).getText().toString());

        Uri uri = getContentResolver().insert(
                MyContentProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(),"URI: " + uri.toString() + "\n Total Student: " + uri.getPathSegments().get(1) , Toast.LENGTH_LONG).show();
    }
    public void onClickRetrieveStudents(View view) {
        // Retrieve student records
        String URL = "content://vn.tien.AndroidExample.MyContentProvider";

        Uri students = Uri.parse(URL);
        Cursor c = managedQuery(students, null, null, null, "name");

        if (c.moveToFirst()) {
            do{
                Toast.makeText(this, "Index: " +
                        c.getString(c.getColumnIndex(MyContentProvider._ID)) +
                                "\nName: " +  c.getString(c.getColumnIndex(MyContentProvider.NAME)) +
                                "\nGrade: " + c.getString(c.getColumnIndex(MyContentProvider.GRADE)),
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }
    }
}