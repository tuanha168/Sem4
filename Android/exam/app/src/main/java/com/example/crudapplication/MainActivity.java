package com.example.crudapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, phone, email;
    RadioGroup gender;
    Button insert, search;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        gender = findViewById(R.id.gender);
        insert = findViewById(R.id.btnInsert);
        search = findViewById(R.id.btnSearch);
        DB = new DBHelper(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String phoneTXT = phone.getText().toString();
                Integer genderTXT = gender.getCheckedRadioButtonId();
                String emailTXT = email.getText().toString();
                System.out.println(genderTXT);
                if (nameTXT.isEmpty() || phoneTXT.isEmpty() || genderTXT == -1 || emailTXT.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    return;
                }

                Boolean checkInsertData = DB.insertuserdata(nameTXT, emailTXT, phoneTXT, genderTXT);
                if (checkInsertData)
                    Toast.makeText(MainActivity.this, "Customer Added", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if (res.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "Customer not Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Name :" + res.getString(0) + "\n");
                    buffer.append("Email Address :" + res.getString(1) + "\n\n");
                    buffer.append("Phone Number :" + res.getString(2) + "\n");
                    buffer.append("Gender :" + res.getString(3) + "\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Customer Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}