package com.hariofspades.chatbot;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Environment;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import org.alicebot.ab.AIMLProcessor;
import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.Graphmaster;
import org.alicebot.ab.MagicBooleans;
import org.alicebot.ab.MagicStrings;
import org.alicebot.ab.PCAIMLProcessorExtension;
import org.alicebot.ab.Timer;
import com.hariofspades.chatbot.Adapter.ChatMessageAdapter;
import com.hariofspades.chatbot.Pojo.ChatMessage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener {
    boolean check_payment=false;
    String text="hi";
    private TextToSpeech tts;
    private final int SPLASH_DISPLAY_LENGTH = 2000;
    private ListView mListView;
    private FloatingActionButton mButtonSend;
    private EditText mEditTextMessage;
    private ImageView mImageView;
    public Bot bot;
    public static Chat chat;
    public static ChatMessageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tts = new TextToSpeech(this, this);
        mListView = (ListView) findViewById(R.id.listView);
       mButtonSend = (FloatingActionButton) findViewById(R.id.btn_send);
        mEditTextMessage = (EditText) findViewById(R.id.et_message);
        mImageView = (ImageView) findViewById(R.id.iv_image);
        mAdapter = new ChatMessageAdapter(this, new ArrayList<ChatMessage>());
        mListView.setAdapter(mAdapter);
        mimicOtherMessage("Hi!");
        mimicOtherMessage("ReVega at your service");
        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mEditTextMessage.getText().toString();
                //bot
                message = message.toLowerCase();
                call(message);
            }

    });

    }

    void call(String message)
    {   int bil=0;
        String response="";
        if (TextUtils.isEmpty(message)) {
            return;
        }
        sendMessage(message);
        //String resp,s;
        if(message.equals("yes") && check_payment==true)
        {
            check_payment=false;
            Intent in=new Intent(MainActivity.this,CheckOutActivity.class);
            startActivity(in);
        }
        if(message.equals("no") && check_payment==true) {

            response="ok! How else can i assist you?";
            mimicOtherMessage(response);
            check_payment=false;
            return;
        }

        ArrayList<String> a=new ArrayList<>();
        a.add("hello");
        a.add("hey");
        a.add("hi");
        a.add("hola");
        a.add("wsup");
        a.add("yo");
        a.add("howdy");
        a.add("hey hi");
        a.add("yo");
        a.add("revega");
        a.add("hi revega");
        a.add("bonjour");
        a.add("hello revega");
        ArrayList<String> t1=new ArrayList<>();
        t1.add("i want services");
        t1.add("service");
        t1.add("hi!i want the service");
        t1.add("hi!i want services");
        t1.add("what can you do?");
        t1.add("what are the services provided by you");
        t1.add("what are the services provided");
        t1.add("what are services");
        t1.add("please provide with the services");
        t1.add("services");
        t1.add("i need services");
        t1.add("what can you do?");
        t1.add("what can you do for me?");
        t1.add("how can you help me?");

        // array[c++]=new Response(t1,"Here are the services provided by me! \n Utility bill \n Pay Rent \n Laundry\n Car wash \n Electrician\n Plumber\n how can i help u?");
        ArrayList<String> t2=new ArrayList<>();
        t2.add("utility bill");
        t2.add("i need utility bill Service");
        t2.add("i want utility bill Service");
        t2.add("utility bill Service");
        t2.add("pay utility bill");
        t2.add("i want to pay utility bill");
        t2.add("pay the utility bill");
        String st="";
        ArrayList<String> t3=new ArrayList<>();
        t3.add("rent");
        t3.add("rent service");
        t3.add("due rent");
        t3.add("what is my rent for this month?");
        t3.add("what is the due rent?");
        t3.add("what is my due rent");
        t3.add("what is my due rent?");
        t3.add("pay rent");
        t3.add("what is the due rent");
        t3.add("i want to pay rent");
        t3.add("pay my rent");
        t3.add("pay the rent");
        ArrayList<String> t4=new ArrayList<>();
        t4.add("laundry");
        t4.add("i need laundry service");
        t4.add("i want laundry service");
        t4.add("laundry service");
        t4.add("i want to pay laundry");
        t4.add("pay for laundry");
        t4.add("pay for my laundry ");
        t4.add("pay for the laundry");
        t4.add("pay laundry");
        t4.add("laundry payment");


        ArrayList<String> t5=new ArrayList<>();
        t5.add("car wash");
        t5.add("i want car wash");
        t5.add("i need car wash");
        t5.add("i want a car wash");
        t5.add("i require car wash");
        t5.add("i want a car wash today");
        t5.add("i want car wash today");
        t5.add("i want a car wash tommorrow");
        t5.add("i want car wash today");
        t5.add("i need a car wash today");
        t5.add("i need a car wash tommorrow");

        t5.add("car wash service");
        t5.add("i want to pay for car wash service");
        t5.add("i require car wash service");
        t5.add("pay for car wash");
        t5.add("pay for my car wash");


        ArrayList<String> t6=new ArrayList<>();
        t6.add("Electrician");
        t6.add("i want an electrician today");
        t6.add("i want an electrician ");
        t6.add("i want electrician");
        t6.add("electrician");
        t6.add("i a electrician");
        t6.add("i want an electrician tommorrow");
        t6.add("i want an electician day after tommorrow");
        t6.add("i need an electrician");
        t6.add("i require an electrician");

        t6.add("i require electrician");
        t6.add("i need electrician Service");
        t6.add("i want electrician Service");
        t6.add("electrician service");
        t6.add("pay for electrician");
        t6.add("pay for electrician Service");
        t6.add("pay for my electrician service");
        t6.add("electrician payment");
        t6.add("pay for electrician");


        ArrayList<String> t7=new ArrayList<>();
        t7.add("plumber");
        t7.add("i need plumber");
        t7.add("plumber service");
        t7.add("plumber required");
        t7.add("i need plumber service");
        t7.add("i require a plumber");
        t7.add("i need a plumber");
        t7.add("i need a plumber today");
        t7.add("can you get me a plumber?");
        t7.add("can you get me a plumber");
        t7.add("can you get me plumber service?");
        t7.add("can you get me plumber?");
        t7.add("can you get me plumber");
        t7.add("i require plumber service");
        t7.add("i want a plumber ");
        t7.add("i want a plumber tommorrow");
        t7.add("i need a plumber tommorrow");
        t7.add("i require a plumber tommorrow");
        t7.add("i require a plumber today");
        t7.add("pay for plumber");
        t7.add("pay for plumber service");
        t7.add("plumber payment");
        t7.add("pay for my plumber service");
        if(a.contains(message))
        {
//
//                   Random rand=new Random();
//                    int n=rand.nextInt(7);
//                    response=a.get(n);
            mimicOtherMessage("How can i help you today?");
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    mimicOtherMessage("Here are some of the cool things that I can do!");
                    mimicOtherMessage("I can pay your rent and utility bill  ");
                    mimicOtherMessage("I can book you a car wash or a laundry session! ");
                    mimicOtherMessage("I can even help you book an electrician or a plumber! ;) ");
                }
            }, SPLASH_DISPLAY_LENGTH);

        }
        else if(t1.contains(message)){
            mimicOtherMessage("How can i help you today? :)");
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    mimicOtherMessage("Here are some of the cool things that I can do!");
                    mimicOtherMessage("I can pay your rent and utility bill :> ");
                    mimicOtherMessage("I can book you a car wash or a laundry session! ");
                    mimicOtherMessage("I can even help you book an electrician or a plumber! ");
                }
            }, SPLASH_DISPLAY_LENGTH);
        }
        else if(t2.contains(message)||t3.contains(message)||t4.contains(message)||t5.contains(message)||t6.contains(message)||t7.contains(message))
        {
            if(t3.indexOf(message)>=0) {
                st="rent";
                 bil= (int) Math.round(Math.random() * ((12000 - 7000) + 1)+7000);
                response = "you have due amount of " + bil;
                mimicOtherMessage(response);
                mimicOtherMessage("Do you want to pay?");
                check_payment=true;
            }
            else if(t2.indexOf(message)>=4||t5.indexOf(message)>=13)
            {    if(t2.contains(message))
            {
                st="utility";
            }
            else{st="carwash";}
               bil= (int) Math.round(Math.random() * ((1200 - 700) + 1)+100);
                response = "you have due amount of " + bil;
                mimicOtherMessage(response);
                mimicOtherMessage("Do you want to pay?");
                check_payment=true;
            }
            else if(t4.indexOf(message)>=4||t6.indexOf(message)>=14)
            {
                if(t4.contains(message))
                {
                    st="laundry";
                }
                else{st="electrician";}
                bil= (int) Math.round(Math.random() * ((1200 - 700) + 1)+100);
                response = "you have due amount of " + bil;
                mimicOtherMessage(response);
                mimicOtherMessage("Do you want to pay?");
                check_payment=true;
            }
            else if(t7.indexOf(message)>=20)
            {
                st="plumber";
                 bil= (int) Math.round(Math.random() * ((12000 - 7000) + 1)+100);
                response = "you have due amount of " + bil;
                mimicOtherMessage(response);
                mimicOtherMessage("Do you want to pay?");
                check_payment=true;
            }
            else if(t4.indexOf(message)>=0) {
                st="laundry";
                response = "your request has been processed expect the laundary service guy to knock your door";
                mimicOtherMessage(response);
                Intent i=new Intent(MainActivity.this,sms.class);
                i.putExtra("type",st);
                startActivity(i);
            }
            else if(t5.indexOf(message)>=0) {
                st="carwash";
                response = "your request has been processed expect the professional to knock your door";
                mimicOtherMessage(response);
                Intent i=new Intent(MainActivity.this,sms.class);
                i.putExtra("type",st);
                startActivity(i);

            }
            else if(t6.indexOf(message)>=0) {
                st="electrician";
                response = "your request has been processed expect the professional to knock your door";
                mimicOtherMessage(response);
                Intent i=new Intent(MainActivity.this,sms.class);
                i.putExtra("type",st);
                startActivity(i);
            }
            else if(t7.indexOf(message)>=0) {
                st="plumber";
                response = "your request has been processed expect the plumber to knock your door";
                mimicOtherMessage(response);
                Intent i=new Intent(MainActivity.this,sms.class);
                i.putExtra("type",st);
                startActivity(i);
            }

        }
        else
        {


            ArrayList<String> keywords=new ArrayList<>();
            keywords.add("utility");
            keywords.add("rent");
            keywords.add("laundry");
            keywords.add("car wash");
            keywords.add("carwash");
            keywords.add("electrician");
            keywords.add("plumber");
            keywords.add("pay");
            keywords.add("bill");
            int c=0;
            //keywords.add("utility bill");
            //keywords.add("");
//            //keywords.add("");
//            String s=message;
//            String yy="";
//            int c=0;
//            for(int i=0;i<keywords.size();i++) {
//                //System.out.println(s+" "+keywords.size());
//                String lookup=keywords.get(i);
//                Pattern p = Pattern.compile(lookup);
//                Matcher m = p.matcher(s);
//                if(m.find()){
//                    // System.out.println(" "+lookup);
//                    c++;
//                    yy=lookup;
//                    break;
//                }
//            }
            if(c>0)
            {

                c=0;
            }
            else {
                response = "Sorry i can't answer that";
                mimicOtherMessage(response);
            }
        }


        mEditTextMessage.setText("");
        mListView.setSelection(mAdapter.getCount() - 1);
    }


    private void sendMessage(String message) {
        ChatMessage chatMessage = new ChatMessage(message, true, false);
        mAdapter.add(chatMessage);

        //mimicOtherMessage(message);
    }

    private void mimicOtherMessage(String message) {
        text=message.toString();
        ChatMessage chatMessage = new ChatMessage(message, false, false);
        mAdapter.add(chatMessage);
        speak();
    }
    private void sendMessage() {
        ChatMessage chatMessage = new ChatMessage(null, true, true);
        mAdapter.add(chatMessage);
        mimicOtherMessage();
    }

    private void mimicOtherMessage() {
        ChatMessage chatMessage = new ChatMessage(null, false, true);
        mAdapter.add(chatMessage);
    }


    @Override
    public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                //btn.setEnabled(true);
                speak();
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }

    }

    private void speak() {
        String text1 = text.toString();
        //Toast.makeText(this,text1,Toast.LENGTH_SHORT).show();
        tts.speak(text1, TextToSpeech.QUEUE_FLUSH, null);
        //Toast.makeText(this,text1,Toast.LENGTH_SHORT).show();
    }


}
