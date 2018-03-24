package com.comlu.digitalthings.GTA;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class MainActivity extends ActionBarActivity {

    Socket socket;
    static BufferedReader in;
    static PrintWriter out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edit=((EditText)findViewById(R.id.editText));


        final Button connect=(Button)findViewById(R.id.btn);
        TextView msgtxt=(TextView)findViewById(R.id.textView2);


        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try{
                            String ip=edit.getText().toString();
                            socket=new Socket(ip,1600);
                            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                            out.flush();
                            Intent in = new Intent(getApplicationContext(),FirstPage.class);
                            startActivity(in);
                            out.print("Connected" + "\n");

                        }catch(IOException e){
                        }catch(Exception e){
                        }
                    }

                });
                t.start();
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
         //   return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    private void print(String line){
    }


}
