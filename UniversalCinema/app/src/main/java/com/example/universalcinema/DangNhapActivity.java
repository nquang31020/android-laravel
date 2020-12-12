package com.example.universalcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.universalcinema.DangKyActivity.showError;

public class DangNhapActivity extends AppCompatActivity
{
    EditText email,matKhau;
    Button dangNhap;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        email = (EditText) findViewById(R.id.email);
        matKhau = (EditText) findViewById(R.id.matKhau);
        dangNhap = (Button) findViewById(R.id.btnDangNhap);
        db = new Database(this);
        dangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDangNhap();
            }
        });
    }
    public void btnDangNhap(){
        String mEmail=email.getText().toString();
        String mMatKhau=matKhau.getText().toString();

        if(mEmail.isEmpty() || !mEmail.contains("@")){
            showError(email,"Email không hợp lệ!");
        }
        else if(mMatKhau.isEmpty() || mMatKhau.length() <= 8){
            showError(matKhau,"Mật khẩu phải có từ 8 ký tự trở lên!");
        }
        else{
            boolean kiemTra = db.KiemTraTaiKhoanMatKhau(mEmail,mMatKhau);
            if(kiemTra){
                Toast.makeText(this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DangNhapActivity.this,MainActivity.class));
            }else{
                Toast.makeText(this, "Loi roi", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void dangKy(View view) {
        startActivity(new Intent(DangNhapActivity.this, DangKyActivity.class));
    }
}