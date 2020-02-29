package com.example.stickynote;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Button btnSave;
    EditText txtContent;
    ListView noteList;
    // TagMapModel map = new TagMapModel();
    final ArrayList<String> list =new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteList = findViewById(R.id.noteList);
        txtContent = findViewById(R.id.txtContent);
        btnSave = findViewById(R.id.btnSave);

        final ArrayAdapter < String > adapter = new ArrayAdapter <>
                (MainActivity.this, android.R.layout.simple_list_item_1,
                        list);

        noteList.setAdapter(adapter);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoteModel note = new NoteModel();

                note.content = txtContent.getText().toString();

                SharedPreferences pref = getPreferences(0);
                SharedPreferences.Editor editor = pref.edit();

                String json = note.toJson();
                Log.i("note.json", json);

                list.add(txtContent.getText().toString());
                adapter.notifyDataSetChanged();
                editor.commit();
            }
        });


        noteList.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                txtContent.setText(list.get(position));

            }
        });

    }
}
