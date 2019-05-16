package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class OfferRegisterAcitivity extends AppCompatActivity {
    private Button buttonCertifyLicense;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_register);
        buttonCertifyLicense= (Button) findViewById(R.id.buttonCertifyLicense);
        buttonCertifyLicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CertifiyLicenseActivity.class);
                startActivity(i);
            }
        });

    }
    public void onClick(View view){}

}
