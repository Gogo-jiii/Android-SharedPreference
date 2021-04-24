package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPref sharedPref = SharedPref.getInstance(this);

        sharedPref.write("string", "a", SharedPref.DATA_TYPE_STRING);
        sharedPref.write("int", 1, SharedPref.DATA_TYPE_INT);
        sharedPref.write("float", 2.0f, SharedPref.DATA_TYPE_FLOAT);
        sharedPref.write("long", 3L, SharedPref.DATA_TYPE_LONG);
        sharedPref.write("boolean", true, SharedPref.DATA_TYPE_BOOLEAN);

        Log.d("TAG", String.valueOf(sharedPref.read("string", SharedPref.DATA_TYPE_STRING).getPrefString()));
        Log.d("TAG", String.valueOf(sharedPref.read("int", SharedPref.DATA_TYPE_INT).getPrefInt()));
        Log.d("TAG", String.valueOf(sharedPref.read("float", SharedPref.DATA_TYPE_FLOAT).getPrefFloat()));
        Log.d("TAG", String.valueOf(sharedPref.read("long", SharedPref.DATA_TYPE_LONG).getPrefLong()));
        Log.d("TAG", String.valueOf(sharedPref.read("boolean", SharedPref.DATA_TYPE_BOOLEAN).isPrefBoolean()));

        Set<String> stringSet = new HashSet<>();
        stringSet.add("a");
        stringSet.add("b");
        stringSet.add("c");

        sharedPref.write("set", stringSet, SharedPref.DATA_TYPE_SET);
        Log.d("TAG",
                String.valueOf(sharedPref.read("set", SharedPref.DATA_TYPE_SET).getPrefSet()));

    }
}