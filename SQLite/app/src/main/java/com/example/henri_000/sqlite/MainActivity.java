package com.example.henri_000.sqlite;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private TextView text;
    private Button addButton;
    private Button deleteButton;
    private EditText inputText;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView)findViewById(R.id.textView);
        addButton = (Button)findViewById(R.id.addButton);
        deleteButton = (Button)findViewById(R.id.deleteButton);
        inputText = (EditText)findViewById(R.id.editText);

        dbManager = new DBManager(this, null);
        printDatabase();
    }

    public void onAddClick(View view){
        String productName = inputText.getText().toString();
        dbManager.addProduct(new Product(productName));
        printDatabase();
    }

    public void onDeleteClick(View view){
        String productName = inputText.getText().toString();
        dbManager.delete(productName);
        printDatabase();
    }

    public void printDatabase(){
        text.setText(dbManager.printTable(dbManager.TABLE_NAME));
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
