package com.comlu.digitalthings.GTA;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class FirstPage extends ActionBarActivity {




    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);



        Button GO=(Button)findViewById(R.id.GO);
        Button jump=(Button)findViewById(R.id.jump);
        Button F=(Button)findViewById(R.id.F);
        Button E=(Button)findViewById(R.id.E);
        Button attack=(Button)findViewById(R.id.attack);
        Button Reverse=(Button)findViewById(R.id.Reverse);
        Button Rclick=(Button)findViewById(R.id.Rclick);
        Button V=(Button)findViewById(R.id.V);
        Button SHIFT=(Button)findViewById(R.id.SHIFT);
        Button ctrl=(Button)findViewById(R.id.ctrl);
        Button lawyer=(Button)findViewById(R.id.lawyer);
        Button turtle=(Button)findViewById(R.id.turtle);
        Button painkiller=(Button)findViewById(R.id.painkiller);
        Button toolup=(Button)findViewById(R.id.toolup);
        Button LEFT=(Button)findViewById(R.id.LEFT);
        Button RIGHT=(Button)findViewById(R.id.RIGHT);
        Button CENTER=(Button)findViewById(R.id.CENTER);

        SensorManager sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        Sensor accerero= sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if(accerero==null){
            Log.e("","Accelerometer Sensor is not available");
            finish();
        }

        SensorEventListener acceleroEventListener= new SensorEventListener() {
            @Override
            public void onSensorChanged(final SensorEvent event) {
                Sensor mySensor = event.sensor;
                if(mySensor.getType()== Sensor.TYPE_ACCELEROMETER){
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try{
                                MainActivity.out.print("mouse,"+event.values[1] +","+event.values[0]+ "\n");
                                MainActivity. out.flush();
                            }catch(Exception e){
                            }

                        }
                    });
                    t.start();
                    System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh" + event.values[1]);
                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        sensorManager.registerListener(acceleroEventListener,accerero,SensorManager.SENSOR_DELAY_NORMAL);


        GO.setOnClickListener(new View.OnClickListener() {
            boolean isGO = false;

            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            MainActivity.out.print("up" + "\n");
                            MainActivity.out.flush();
                            isGO = (isGO == true) ? false : true;
                            ((Button) findViewById(R.id.GO)).setTextColor(isGO ? Color.RED : Color.BLACK);
                        } catch (Exception e) {
                        }

                    }

                });
                t.start();
            }

        });

        Reverse.setOnClickListener(new View.OnClickListener() {
            boolean isReverse=false;
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            MainActivity.out.print("down" + "\n");
                            MainActivity.out.flush();
                            isReverse=(isReverse==true)?false:true;
                            ((Button)findViewById(R.id.Reverse)).setTextColor(isReverse ? Color.RED : Color.BLACK);
                        }catch(Exception e){
                        }
                    }

                });
                t.start();
            }
        });

        SHIFT.setOnClickListener(new View.OnClickListener() {
            boolean isSHIFT=false;
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            MainActivity.out.print("shift" + "\n");
                            MainActivity.out.flush();
                            isSHIFT=(isSHIFT==true)?false:true;
                            ((Button)findViewById(R.id.SHIFT)).setTextColor(isSHIFT ? Color.RED : Color.BLACK);
                        }catch(Exception e){
                        }
                    }

                });
                t.start();
            }
        });

        ctrl.setOnClickListener(new View.OnClickListener() {
            boolean isctrl=false;
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            MainActivity.out.print("ctrl" + "\n");
                            MainActivity.out.flush();
                            isctrl=(isctrl==true)?false:true;
                            ((Button)findViewById(R.id.ctrl)).setTextColor(isctrl ? Color.RED : Color.BLACK);
                        }catch(Exception e){
                        }
                    }

                });
                t.start();
            }
        });

        LEFT.setOnClickListener(new View.OnClickListener() {
            boolean isLEFT=false;
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            MainActivity.out.print("left" + "\n");
                            MainActivity.out.flush();
                            isLEFT=(isLEFT==true)?false:true;
                            ((Button)findViewById(R.id.LEFT)).setTextColor(isLEFT ? Color.RED : Color.BLACK);
                        }catch(Exception e){
                        }
                    }

                });
                t.start();
            }
        });

        RIGHT.setOnClickListener(new View.OnClickListener() {
            boolean isRIGHT=false;
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            MainActivity.out.print("right" + "\n");
                            MainActivity.out.flush();
                            isRIGHT=(isRIGHT==true)?false:true;
                            ((Button)findViewById(R.id.RIGHT)).setTextColor(isRIGHT ? Color.RED : Color.BLACK);
                        }catch(Exception e){
                        }
                    }

                });
                t.start();
            }
        });

        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            MainActivity.out.print("space" + "\n");
                            MainActivity.out.flush();
                        }catch(Exception e){
                        }
                    }

                });
                t.start();
            }
        });

        F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            MainActivity.out.print("F" + "\n");
                            MainActivity.out.flush();
                        }catch(Exception e){
                        }
                    }

                });
                t.start();
            }
        });
        E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            MainActivity.out.print("E" + "\n");
                            MainActivity.out.flush();
                        }catch(Exception e){
                        }
                    }

                });
                t.start();
            }
        });

        attack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            MainActivity.out.print("click" + "\n");
                            MainActivity.out.flush();
                        } catch (Exception e) {
                        }
                    }

                });
                t.start();
            }
        });

        CENTER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            MainActivity.out.print("CENTER" + "\n");
                            MainActivity.out.flush();
                        } catch (Exception e) {
                        }
                    }

                });
                t.start();
            }
        });

        V.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            MainActivity.out.print("V" + "\n");
                            MainActivity.out.flush();
                        } catch (Exception e) {
                        }
                    }

                });
                t.start();
            }
        });

        Rclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            MainActivity.out.print("Rclick" + "\n");
                            MainActivity.out.flush();
                        }catch(Exception e){
                        }
                    }

                });
                t.start();
            }
        });


        lawyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            MainActivity.out.print("lawyer" + "\n");
                            MainActivity.out.flush();
                        }catch(Exception e){
                        }
                    }

                });
                t.start();
            }
        });
        turtle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            MainActivity.out.print("turtle" + "\n");
                            MainActivity.out.flush();
                        }catch(Exception e){
                        }
                    }

                });
                t.start();
            }
        });
        painkiller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            MainActivity.out.print("painkiller" + "\n");
                            MainActivity.out.flush();
                        }catch(Exception e){
                        }
                    }

                });
                t.start();
            }
        });

        toolup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            MainActivity.out.print("toolup" + "\n");
                            MainActivity.out.flush();
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
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            //return true;
        //}

        return super.onOptionsItemSelected(item);
    }

}

