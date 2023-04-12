package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity; import android.os.Bundle; import android.view.View; import android.widget.AdapterView; import android.widget.ArrayAdapter; import android.widget.Button; import android.widget.EditText; import android.widget.ListView; import android.widget.Toast;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    // make a reference to buttons Button btn_add, btn_view; EditText et_name, et_age; ListView lv_StudentList; ArrayAdapter studentArrayAdapter; DataBaseHelper dataBaseHelper;
    Button btn_add;
    EditText et_name;
    EditText et_age;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   // on create, give value btn_add = findViewById(R.id.btn_add); btn_view = findViewById(R.id.btn_view);
         btn_add = findViewById(R.id.btn_add);
         et_age= findViewById(R.id.et_age);
         et_name = findViewById(R.id.et_name);

         btn_add.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 StudentMod studentMod;
                 try {
                     studentMod = new StudentMod(-1, et_name.getText().toString(), Integer.parseInt(et_age.getText().toString()));
                     Toast.makeText(MainActivity.this, studentMod.toString(), Toast.LENGTH_SHORT).show();
                 }
                 catch (Exception e){
                     Toast.makeText(MainActivity.this, "Error creating student", Toast.LENGTH_SHORT).show();
                     studentMod = new StudentMod(-1, "error", 0);
                 }

                 DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                 boolean success = dataBaseHelper.addOne(studentMod);
                 Toast.makeText(MainActivity.this, "Success= " + success , Toast.LENGTH_SHORT).show();
             }


         });
         }
    }