package com.example.silvermon;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DowonYoon on 2017-07-11.
 */

@IgnoreExtraProperties
public class FirebasePost {
    public String  addr;
    public String major;
    public String name;
    public Long age;
    public String gender;

    public FirebasePost(){
        // Default constructor required for calls to DataSnapshot.getValue(FirebasePost.class)
    }

    public FirebasePost(String name, String addr, Long age, String gender,String major) {
        this.name= name;
        this.addr = addr;
        this.age = age;
        this.gender = gender;
        this.major = major;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("name", name);
        result.put("age", age);
        result.put("addr", addr);
        result.put("major",major);
        result.put("gender", gender);
        return result;
    }
}