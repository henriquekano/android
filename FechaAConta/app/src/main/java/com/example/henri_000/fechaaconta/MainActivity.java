package com.example.henri_000.fechaaconta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.henri_000.fechaaconta.db.ItemOpenDatabaseHelper;
import com.example.henri_000.fechaaconta.model.Item;
import com.j256.ormlite.dao.Dao;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OrmLiteDao;
import org.androidannotations.annotations.ViewById;

import java.sql.SQLException;
import java.util.List;

@EActivity
public class MainActivity extends AppCompatActivity {

    @ViewById(value = R.id.editText)
    EditText editText;

    @ViewById(value = R.id.textView)
    TextView text;

    @OrmLiteDao(helper = ItemOpenDatabaseHelper.class)
    Dao<Item, Long> dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            if(!((CustomApplication)getApplication()).checkLogin()){
                //Intent intent = new Intent(this, LoginActivity.class);
                //startActivity(intent);
                LoginActivity_.intent(this).start();
            }else{
                setContentView(R.layout.activity_main);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Click(R.id.addButton)
    public void onAddGroupClick(View view){

        //editText = (EditText)findViewById(R.id.editText);

        //ItemOpenDatabaseHelper dbHelper = new ItemOpenDatabaseHelper(this);
        try {
            //dao = dbHelper.getItemDAO();
            dao.create(new Item(editText.getText().toString(), 1.1f));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Click(R.id.showButton)
    public void onShowGroupClick(View view){
        //text = (TextView)findViewById(R.id.textView);
        try {
            List<Item> items = dao.queryForAll();
            String a = "";
            for(Item item : items){
                a += item.get_name() + "\n";
            }
            text.setText(a);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
