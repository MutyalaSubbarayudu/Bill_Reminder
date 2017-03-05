package com.example.subbu.databasetodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {



    DbHelper dbHelper;
    ListView lst;
    EditText txt;
    Button add;
    ArrayList<String> list=new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper=new DbHelper(this);
        lst=(ListView)findViewById(R.id.list);
        txt=(EditText)findViewById(R.id.editText);
        add=(Button)findViewById(R.id.button);

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);

        lst.setAdapter(adapter);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {


                Intent i =new Intent(MainActivity.this,MainActivity2.class);

                i.putExtra("val",list.get(pos));
                startActivity(i);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               addlist();
            }
        });

        loadList();



    }
    public void addlist() {
        String task = String.valueOf(txt.getText());
        if (!task.isEmpty() && task.length() > 0) {
            dbHelper.insertTask(task);
            loadList();
        } else {
            Toast.makeText(getApplicationContext(), "Nothing to Add !", Toast.LENGTH_SHORT).show();
        }
    }
    private void loadList() {
        ArrayList<String> taskLists=dbHelper.getTaskList();
        adapter.clear();
        adapter.addAll(taskLists);
        adapter.notifyDataSetChanged();
    }



}
