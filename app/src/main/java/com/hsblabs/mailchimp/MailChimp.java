package com.hsblabs.mailchimp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import rsg.mailchimp.api.MailChimpApiException;
import rsg.mailchimp.api.lists.ListMethods;

import static java.security.AccessController.getContext;

public class MailChimp extends AppCompatActivity {

    EditText et;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_chimp);
        et = (EditText) findViewById(R.id.editText);
        bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable run = new Runnable() {
                    public void run() {
                        if (et.getText() != null && et.getText().toString().trim().length() > 0) {
                            addToList(et.getText().toString());
                        }
                    }
                };
                (new Thread(run)).start();
            }
        });
    }
    private void addToList(String emailAddy) {

        ListMethods listMethods = new ListMethods("28689164390c8ddf980de203ed9842d7-us15");
        String message = "Signup successful!";
        try {
            listMethods.listSubscribe("667bd894f3", emailAddy);
        } catch (MailChimpApiException e) {
            Log.e("MailChimp", "Exception subscribing person: " + e.getMessage());
            message = "Signup failed: " + e.getMessage();
        } finally {
            showResult(message);
        }

    }
    private void showResult(final String message) {
        Runnable run = new Runnable() {
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(MailChimp.this);
                builder.setMessage(message).setPositiveButton("OK", new Dialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        };
        MailChimp.this.runOnUiThread(run);
    }
}
