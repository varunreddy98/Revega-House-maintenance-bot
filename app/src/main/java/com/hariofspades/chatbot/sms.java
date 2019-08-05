package com.hariofspades.chatbot;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class sms extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    Button sendBtn;
    String phoneNo;
    String message;
    EditText txtphoneNo;
    EditText txtMessage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        Intent intent=getIntent();
        String type=intent.getStringExtra("type");
        int bil=900;
        phoneNo="";
        String message="";
        if(type.equals("rent"))
        {
            message=Login.name+" paid the rent of "+bil;
        }
        else {

           message = Login.usname+" requires ur service\nFlat no.301";
        }

        String number="9515767545";
//        Toast.makeText(getApplicationContext(),number.toString() ,
//                Toast.LENGTH_LONG).show();
//        sendBtn = (Button) findViewById(R.id.btnSendSMS);
//        txtphoneNo = (EditText) findViewById(R.id.editText);
////        txtMessage = (EditText) findViewById(R.id.editText2);
//        Toast.makeText(this,"use this only when you really need a help",Toast.LENGTH_LONG).show();
//        sendBtn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                sendSMSMessage();
//
//            }
//        });

        sendSMSMessage(number.toString(),message.toString());
    }

    protected void sendSMSMessage(String phoneNo,String message) {
           this.message=message;
           this.phoneNo=phoneNo;

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
        else
        {
            if(!phoneNo.toString().equals("")) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNo, null, message, null, null);
//                Toast.makeText(getApplicationContext(), "SMS sent.",
//                        Toast.LENGTH_LONG).show();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this,"please do enter phone number",Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        Toast.makeText(this,"here",Toast.LENGTH_LONG).show();
        switch (requestCode) {

            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(!phoneNo.toString().equals("")) {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(phoneNo, null, message, null, null);
                        //Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Intent intent=new Intent(this,MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                      // Toast.makeText(this,"please do enter phone  number",Toast.LENGTH_LONG).show();
                    }
                } else {
//                  Toast.makeText(getApplicationContext(),
//                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }
}