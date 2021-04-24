package com.example.sharedpreference;

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

        SharedPreferenceManager sharedPreferenceManager =
                SharedPreferenceManager.getInstance(this);

        sharedPreferenceManager.write("string", "a", SharedPreferenceManager.DATA_TYPE_STRING);
        sharedPreferenceManager.write("int", 1, SharedPreferenceManager.DATA_TYPE_INT);
        sharedPreferenceManager.write("float", 2.0f, SharedPreferenceManager.DATA_TYPE_FLOAT);
        sharedPreferenceManager.write("long", 3L, SharedPreferenceManager.DATA_TYPE_LONG);
        sharedPreferenceManager.write("boolean", true, SharedPreferenceManager.DATA_TYPE_BOOLEAN);

        Log.d("TAG", String.valueOf(sharedPreferenceManager.read("string", SharedPreferenceManager.DATA_TYPE_STRING).getPrefString()));
        Log.d("TAG", String.valueOf(sharedPreferenceManager.read("int", SharedPreferenceManager.DATA_TYPE_INT).getPrefInt()));
        Log.d("TAG", String.valueOf(sharedPreferenceManager.read("float", SharedPreferenceManager.DATA_TYPE_FLOAT).getPrefFloat()));
        Log.d("TAG", String.valueOf(sharedPreferenceManager.read("long", SharedPreferenceManager.DATA_TYPE_LONG).getPrefLong()));
        Log.d("TAG", String.valueOf(sharedPreferenceManager.read("boolean", SharedPreferenceManager.DATA_TYPE_BOOLEAN).isPrefBoolean()));

        Set<String> stringSet = new HashSet<>();
        stringSet.add("a");
        stringSet.add("b");
        stringSet.add("c");

        sharedPreferenceManager.write("set", stringSet, SharedPreferenceManager.DATA_TYPE_SET);
        Log.d("TAG",
                String.valueOf(sharedPreferenceManager.
                        read("set", SharedPreferenceManager.DATA_TYPE_SET).getPrefSet()));

    }
}