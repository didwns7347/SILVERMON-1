package com.example.silvermon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class SeekerRegisterActivity extends AppCompatActivity {
    private  FirebaseAuth mAuth = FirebaseAuth.getInstance();
    final FirebaseUser user = mAuth.getCurrentUser(); // 구직자 아이디 입력 위함
    EditText Sname; // 구직자 이름
    EditText Spnum;//구직자 폰번호
    EditText Saddr;//구지가 주소
    EditText Sgender;//구직자 성별
    EditText Sage;//구직자 나이
    EditText Smajor;//구직자의 전문분야

    String ID = user.getEmail().toString();//파이어 베이스 데이터는 특수문자 입력불가
    int idx = ID.indexOf("@");
    int idx1 = ID.indexOf(".");
    String temp1 =ID.substring(0,idx);
    String temp2 = ID.substring(idx+1,idx1);
    String temp3 = ID.substring(idx1+1);
    String   id= temp1+temp2+temp3;//@이랑 . 자르고 문자열 합쳤음

    Button submitbutton;
    String pnum,name,addr,gender,age,major;
    private DatabaseReference mPostReference;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeker_register);
        // 버튼 입력텍스트를 activity_seeker_register에 입력받은 값들로 초기화한다.
        submitbutton = (Button)findViewById(R.id.buttonSeekerRegister);


        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sname = (EditText)findViewById(R.id.Seekername);
                Sage= (EditText)findViewById(R.id.Seekerage);
                Saddr = (EditText)findViewById(R.id.Seekeraddress);
                Sgender = (EditText)findViewById(R.id.Seekergender);
                Spnum= (EditText)findViewById(R.id.Seekerpnumber);
                Smajor =(EditText)findViewById(R.id.Seekermajor);

                name = Sname.getText().toString();// trim은 공백 제거 메소드인듯
                pnum = Spnum.getText().toString();
                addr = Saddr.getText().toString();
                gender = Sgender.getText().toString();
                age = Sgender.getText().toString();
                major  = Smajor.getText().toString();

                postFirebaseDatabase(true);//파이어베이스에 데이터 올리기
                Intent i = new Intent(getApplicationContext(), TestActivity.class);
                startActivity(i);

            }
        });
    }

    //데이터베이스에 삽입하는 함수
    public void postFirebaseDatabase(boolean add){
        mPostReference = FirebaseDatabase.getInstance().getReference();
        Map<String, Object> childUpdates = new HashMap<>();
        Map<String, Object> postValues = null;
        if(add){
            FirebasePostHR post = new FirebasePostHR(pnum,name,age, addr, gender,major);
            postValues = post.toMap();//post로  생서된 정보를 map값으로 변경
        }
        childUpdates.put("/worker_list/" + id, postValues);
        mPostReference.updateChildren(childUpdates);//데이터 삽입
    }
}