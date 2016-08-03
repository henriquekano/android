package com.example.henri_000.overflowmenu;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.mainLayout);
        switch(item.getItemId()){
            case R.id.menuRed:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                layout.setBackgroundColor(Color.RED);
                break;
            case R.id.menuGreen:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                layout.setBackgroundColor(Color.GREEN);
                break;
            case R.id.menuBlue:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                layout.setBackgroundColor(Color.BLUE);
                break;
            default:
                super.onOptionsItemSelected(item);
        }

        return true;
    }
}
