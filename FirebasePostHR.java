package com.example.silvermon;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class FirebasePostHR {
    public String pnum;
    public String  name;
    public String age;
    public String addr;
    public String gender;
    public String major;
    public FirebasePostHR(){

    }
    public FirebasePostHR(String pnum, String name, String age , String addr,String gender, String major){
        this.pnum =pnum;
        this.name = name;
        this.age = age;
        this.addr =addr;
        this.gender =gender;
        this.major = major;
    }
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("pnum",pnum);
        result.put("gender", gender);
        result.put("name", name);
        result.put("age", age);
        result.put("addr", addr);
        result.put("major",major);
        return result;
    }

}
