package com.comlu.digitalthings.GTA;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Hishan Indrajith on 10/26/2017.
 */
public class ThreadClass extends Thread {
    static EditText iptxt,msgtxt;
    Button addbtn,connectbtn;
    PrintWriter out;
    Socket socket ;

    public ThreadClass(EditText iptxt,EditText msgtxt, Button addbtn, Button connectbtn) {
        this.iptxt=iptxt;
        this.msgtxt=msgtxt;
        this.addbtn =addbtn;
        this.connectbtn=connectbtn;
    }



    public void startThread(){

        start();
    }

    @Override
    public void run() {
        connectbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ip=iptxt.getText().toString();
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            socket = new Socket(ip, 1600);
                            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

                        }catch (Exception e){
                        }
                    }
                });
                t.start();

            }
        });

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    out.println(msgtxt.getText().toString());
                    out.flush();
                    msgtxt.setText("");
                } catch (NullPointerException e) {
                    iptxt.setText("Not connected");
                }
            }
        });
    }



}
