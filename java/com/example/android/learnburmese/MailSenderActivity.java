package com.example.android.learnburmese;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by SherlockHolmes on 2016/10/9.
 */
public class MailSenderActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        final Button send = (Button) this.findViewById(R.id.send);
        final EditText userid = (EditText) this.findViewById(R.id.userid);
        final EditText password = (EditText) this.findViewById(R.id.password);
        final EditText from = (EditText) this.findViewById(R.id.from);
        final EditText to = (EditText) this.findViewById(R.id.to);
        final EditText subject = (EditText) this.findViewById(R.id.subject);
        final EditText body = (EditText) this.findViewById(R.id.body);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.suggestion_fragment);
        GMailSender sender = new GMailSender("account", "password");
        try
        {
            sender.sendMail("title", "content", "sender", "reciever");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}