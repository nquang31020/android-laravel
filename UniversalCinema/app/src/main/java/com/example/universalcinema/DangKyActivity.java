package com.example.universalcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class DangKyActivity extends AppCompatActivity
{
    EditText hoTen, matKhau;
    EditText soDienThoai, mEmail;
    EditText mDate;
    Button dangKy;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        hoTen = (EditText) findViewById(R.id.hoTen);
        soDienThoai = (EditText) findViewById(R.id.soDienThoai);
        mEmail = (EditText) findViewById(R.id.email);
        matKhau = (EditText) findViewById(R.id.matKhau);
        mDate = findViewById(R.id.ngaySinh);
        mDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNgaySinh();
            }
        });

        dangKy = (Button) findViewById(R.id.btnDangKy);
        db = new Database(this);
        dangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDangKy();
            }
        });
    }
    public void etNgaySinh(){
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(DangKyActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month+1;
                String date = day+ "/"+month+ "/"+year;
                mDate.setText(date);
            }
        },year,month,day);
        datePickerDialog.show();
    }
    public void btnDangKy(){
        String user = hoTen.getText().toString();
        String phone = soDienThoai.getText().toString();
        String email = mEmail.getText().toString();
        String pass = matKhau.getText().toString();
        String birthday = mDate.getText().toString();
        if(user.isEmpty() || user.length() <= 8){
            showError(hoTen,"Tên người dùng không hợp lệ!");
        }
        else if(phone.isEmpty() || phone.length() <10){
            showError(soDienThoai,"Số điện thoại không hợp lệ!");
        }
        else if(pass.isEmpty() || pass.length() <= 8){
            showError(matKhau,"Mật khẩu phải có từ 8 ký tự trở lên!");
        }
        else if(email.isEmpty() || !email.contains("@")){
            showError(mEmail,"Email không hợp lệ!");
        }
        else if(birthday.isEmpty()){
            showError(mDate,"Ngày sinh không được để trống!");
        }
        else{
            boolean kiemTraUser = db.kiemTraUserName(user);
            if(kiemTraUser==false){
                boolean insert = db.insertData(user,pass,email,phone,birthday);
                if(insert){
                    Toast.makeText(this, "Dang ky thanh cong", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(DangKyActivity.this,DangNhapActivity.class));
                }
                else{
                    Toast.makeText(this, "Dang ky khong thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(this, "Ten tai khoan da ton tai", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public static void showError(EditText editText,String notification){
        editText.setError(notification);
        editText.requestFocus();
    }
}