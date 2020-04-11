package com.example.spendingmanagerv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText txtBalance;
    EditText txtDate, txtPrice, txtActivity, txtHistory;
    Button btnAdd, btnSpent;
    ListView dateList, amountList, activityList;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static String Balance = "balance";
    SharedPreferences sharedpreferences;
    double saveBalance = 100.00;

    final ArrayList<String> listDate =new ArrayList<String>();
    final ArrayList<String> listAmount =new ArrayList<String>();
    final ArrayList<String> listActivity =new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtBalance = findViewById(R.id.txtBalance);
        txtDate = findViewById(R.id.txtDate);
        txtPrice = findViewById(R.id.txtPrice);
        txtActivity = findViewById(R.id.txtActivity);
        dateList = findViewById(R.id.dateList);
        amountList = findViewById(R.id.amountList);
        activityList = findViewById(R.id.activityList);

        btnAdd = findViewById(R.id.btnAdd);
        btnSpent = findViewById(R.id.btnSpent);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        final ArrayAdapter< String > adapter1 = new ArrayAdapter <>
                (MainActivity.this, android.R.layout.simple_list_item_1,
                        listDate);

        final ArrayAdapter< String > adapter2 = new ArrayAdapter <>
                (MainActivity.this, android.R.layout.simple_list_item_1,
                        listAmount);

        final ArrayAdapter< String > adapter3 = new ArrayAdapter <>
                (MainActivity.this, android.R.layout.simple_list_item_1,
                        listActivity);

        dateList.setAdapter(adapter1);
        amountList.setAdapter(adapter2);
        activityList.setAdapter(adapter3);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amount = Double.parseDouble(txtPrice.getText().toString());
                double newBalance = Double.parseDouble(txtBalance.getText().toString());
                newBalance = newBalance + amount;
                String value = Double.valueOf(newBalance).toString();
                String strDate = txtDate.getText().toString();
                String strPrice = txtPrice.getText().toString();
                String strActivity = txtActivity.getText().toString();
                //String strHistory = txtHistory.getText().toString();
                //String newLine = "Added $" + strPrice+ " on " + strDate + " from " + strActivity;
                //String strUpdate = strHistory + "\n" + newLine;
                saveBalance = newBalance;
                MainActivity.this.txtBalance.setText(value);

                listDate.add(strDate);
                adapter1.notifyDataSetChanged();

                listAmount.add(strPrice);
                adapter2.notifyDataSetChanged();

                listActivity.add(strActivity);
                adapter3.notifyDataSetChanged();

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Balance, value);
                editor.commit();
            }
        });

        btnSpent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amount = Double.parseDouble(txtPrice.getText().toString());
                double newBalance = Double.parseDouble(txtBalance.getText().toString());
                newBalance = newBalance - amount;
                String value = Double.valueOf(newBalance).toString();
                String strDate = txtDate.getText().toString();
                String strPrice = "-" + txtPrice.getText().toString();
                String strActivity = txtActivity.getText().toString();
                //String newLine = "Spent $" + strPrice + " on " + strDate + " for " + strActivity;
                //String strUpdate = strHistory + "\n" + newLine;
                MainActivity.this.txtBalance.setText(value);
                saveBalance = newBalance;

                listDate.add(strDate);
                adapter1.notifyDataSetChanged();

                listAmount.add(strPrice);
                adapter2.notifyDataSetChanged();

                listActivity.add(strActivity);
                adapter3.notifyDataSetChanged();


                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Balance, value);
                editor.commit();
            }
        });


    }

    @Override
    protected void onResume()
    {

        super.onResume();
        String value = Double.valueOf(saveBalance).toString();
        MainActivity.this.txtBalance.setText(value);

    }

    @Override
    protected void onPause()
    {
        super.onPause();

        // Creating a shared pref object
        // with a file name "MySharedPref" in private mode
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        double value = Double.parseDouble(txtBalance.getText().toString());
        saveBalance = value;
        editor.putString("balance", Balance);

        editor.commit();
    }

}