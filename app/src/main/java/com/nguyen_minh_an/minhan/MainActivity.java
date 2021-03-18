package com.nguyen_minh_an.minhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAdd ,btnSearch;
    EditText edUsername,edEmail, edPhone;
    RadioGroup rgGender;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edUsername = findViewById(R.id.edUsername);
        edEmail = findViewById(R.id.edEmail);
        edPhone = findViewById(R.id.edPhone);
        btnAdd = findViewById(R.id.btnAdd);
        rgGender = findViewById(R.id.grGender);
        btnSearch = findViewById(R.id.btnSearch);
        db = AppDatabase.getAppDatabase(this);

        btnAdd.setOnClickListener(this::onClick);
        btnSearch.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAdd:
                if (validate()) {
                    addUser();
                    Toast.makeText(this, "Thành công", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnSearch:
                goSearch();
                break;
            default:
                break;
        }
    }
    private void goSearch(){
        Intent intent = new Intent(this,SearchActivity.class);
        startActivity(intent);
    }
    private boolean validate() {
        String mes = null;
        if (edUsername.getText().toString().trim().isEmpty()) {
            mes = "Chưa nhập username";
        }
        if (edEmail.getText().toString().isEmpty()) {
            mes = "Chưa nhập Email";
        }
        if (edPhone.getText().toString().trim().isEmpty()) {
            mes = "Chưa nhập số điện thoại";
        }
        if (rgGender.getCheckedRadioButtonId() == -1) {
            mes = "Bạn chưa chọn giới tính";
        }
        if (mes != null) {
            Toast.makeText(this, mes, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private void addUser(){
        User user = new User();
        user.username = edUsername.getText().toString();
        user.useremail = edEmail.getText().toString();
        user.userphone = edPhone.getText().toString();
        user.gender = CheckGender();
        db.userDao().insertUser(user);
    }
    public String CheckGender(){
        int idChecked = rgGender.getCheckedRadioButtonId();
        if(idChecked == R.id.Male){
            return "Male";
        }
        return  "Female";
    }


}