package com.hsblabs.mailchimp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MailChimp extends AppCompatActivity {

    EditText et;
    Button bt;
    private APIService mAPIService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_chimp);
        et = (EditText) findViewById(R.id.editText);
        mAPIService = ApiUtils.getAPIService();
        bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 sendPOST(et.getText().toString());
            }
        });
    }
    void sendPOST(String email){
        mAPIService.savePost(email, "subscribed").enqueue(new Callback<Members>() {

            @Override
            public void onResponse(Call<Members> call, Response<Members> response) {
                Toast.makeText(MailChimp.this,"Added",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Members> call, Throwable t) {
                Toast.makeText(MailChimp.this,"Error",Toast.LENGTH_LONG).show();

            }
        });
    }
}
