package com.example.mytaskhistoryapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private TextView title;
    private TextView taskId;
    private TextView history;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

        history = (TextView) findViewById(R.id.textView);
        history.setText("");

        title = (TextView) findViewById(R.id.textView2);
        title.setText("" + this.getLocalClassName());

        taskId = (TextView) findViewById(R.id.textView3);
        taskId.setText("" + this.getTaskId());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void onClick(View view) {
        String text = ((Button)view).getText().toString();
        Intent intent = new Intent(this, MainActivity.class);

        switch (text) {
            case "standard" :
//                intent.setFlags(DEFAULT_KEYS_DIALER);
                taskId.setText("" + this.getTaskId());
                imageView.setBackgroundColor(Color.MAGENTA);
                break;
            case "singleTop" :
//                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                taskId.setText("" + this.getTaskId());
                imageView.setBackgroundColor(Color.GREEN);
                break;
            case "singleTask" :
                taskId.setText("" + this.getTaskId());
                imageView.setBackgroundColor(Color.BLUE);
                break;
            case "singleInstance" :
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                taskId.setText("" + this.getTaskId());
                imageView.setBackgroundColor(Color.RED);
                break;
        }

        startActivity(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        history.setText(history.getText() + "\r\n" + "onNewIntent");
    }

    @Override
    protected void onStart() {
        super.onStart();
        history.setText(history.getText() + "\r\n" + "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        history.setText(history.getText() + "\r\n" + "onResume");
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        history.setText(history.getText() + "\r\n" + "onPostCreate");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        history.setText(history.getText() + "\r\n" + "onPostResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        history.setText(history.getText() + "\r\n" + "onSaveInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        history.setText(history.getText() + "\r\n" + "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        history.setText(history.getText() + "\r\n" + "onStop");
    }

}
