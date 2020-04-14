package com.example.sqlapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelperClass myDb;
    EditText idEdit,nameEdit,surnameEdit,marksEdit;
    Button addDataButton, viewButton,updateButton,deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelperClass(this);

        idEdit = findViewById(R.id.edit4);
        nameEdit = findViewById(R.id.edit1);
        surnameEdit = findViewById(R.id.edit2);
        marksEdit = findViewById(R.id.edit3);
        addDataButton = findViewById(R.id.button);
        viewButton = findViewById(R.id.buttonData);
        updateButton = findViewById(R.id.buttonUpdate);
        deleteButton = findViewById(R.id.buttonDelete);
        addData();
        viewAll();
        UpdateData();
        deleteData();
    }

    public void addData(){
        addDataButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(nameEdit.getText().toString(),
                                surnameEdit.getText().toString(),
                                marksEdit.getText().toString());

                        if (isInserted == true)
                            Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll(){
        viewButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount()==0)
                        {//show message
                            showMessage("ERROR","No data found");
                            return;}
                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("Id :"+res.getString(0)+"\n");
                            buffer.append("NAME :"+res.getString(1)+"\n");
                            buffer.append("SURNAME :"+res.getString(2)+"\n");
                            buffer.append("MARKS :"+res.getString(3)+"\n\n");
                        }
                        //show all data
                        showMessage("Data",buffer.toString());

                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void UpdateData(){
        updateButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdated = myDb.updateData(idEdit.getText().toString(),nameEdit.getText().toString(),
                                surnameEdit.getText().toString(),marksEdit.getText().toString());
                        if (isUpdated==true)
                            Toast.makeText(MainActivity.this,"Data updated",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void deleteData(){
        deleteButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(idEdit.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(MainActivity.this,"Data deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
