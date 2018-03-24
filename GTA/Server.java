



import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;



public class Server { 
    
    public static final int BASE_PORT = 1600;     
    
    private ServerSocket serverSocket; 
    
    public Server(int socket) throws IOException { 
	serverSocket = new ServerSocket(socket); 
	// create a new server socket 
    }

    public void server_loop() throws IOException { 
	while(true) { 
	    Socket socket = serverSocket.accept(); 	    
	    try { 
		handle(socket); 
	    } catch (IOException e) { 
		System.out.println(e); 
	    } finally { 
		socket.close();
	    }
	}
    }

    private void handle(Socket socket) throws IOException { 
	
	BufferedReader in = new 
	    BufferedReader(new InputStreamReader(socket.getInputStream()));
	PrintWriter out = new 
	    PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
	String line; 
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b= a.getLocation();
        
        
        boolean shift=false;
        boolean ctrl=false;
        boolean alt=false;
        boolean up=false;
        boolean left=false;
        boolean down=false;
        boolean right=false;
        int mouseX=(int)b.getX();
        int mouseY=(int)b.getY();
        int currentX=0;
        int currentY=0;
        
	for(line = in.readLine(); 
	    line != null && !line.equals("quit"); 
	    line = in.readLine()) { 
	    System.out.println(line); 
		          try {
                Robot robot = new Robot();
                if(line.split(",")[0].equals("mouse")){
                    try{
                        float f1= Float.parseFloat(line.split(",")[1]);
                        float f2= Float.parseFloat(line.split(",")[2]);
                        currentX=mouseX+(int)(100*f1);
                        currentY=mouseY+(int)(40*f2);
                        robot.mouseMove(currentX,currentY);
                    }catch(Exception e){
                    }
                    
                    
                }else{
                    switch (line) {
                    case "shift": if(shift){
                                        robot.keyRelease(KeyEvent.VK_SHIFT);shift=false;
                                    }else{
                                        robot.keyPress(KeyEvent.VK_SHIFT);shift=true;
                                    }
                                  break;
                    case "ctrl": if(ctrl){
                                        robot.keyRelease(KeyEvent.VK_CONTROL);ctrl=false;
                                    }else{
                                        robot.keyPress(KeyEvent.VK_CONTROL);ctrl=true;
                                    }
                                  break;               
                    case "space": robot.keyPress(KeyEvent.VK_SPACE);
                    				try {
							            Thread.sleep(300);
							        } catch (InterruptedException e) {
							            e.printStackTrace();
							        }
                                  robot.keyRelease(KeyEvent.VK_SPACE);
                                  break;
                    case "F": robot.keyPress(KeyEvent.VK_F);
                    				try {
							            Thread.sleep(300);
							        } catch (InterruptedException e) {
							            e.printStackTrace();
							        }
                                  robot.keyRelease(KeyEvent.VK_F);
                                  break;
                    case "click": robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                    				try {
							            Thread.sleep(300);
							        } catch (InterruptedException e) {
							            e.printStackTrace();
							        }
                                  robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
                                  break; 
                    case "up": if(up){
                                        robot.keyRelease(KeyEvent.VK_W);up=false;
                                    }else{
                                        robot.keyPress(KeyEvent.VK_W);up=true;
                                    }
                                  break; 
                    case "down": if(down){
                                        robot.keyRelease(KeyEvent.VK_S);down=false;
                                    }else{
                                        robot.keyPress(KeyEvent.VK_S);down=true;
                                    }
                                  break;
                    case "V":   robot.keyPress(KeyEvent.VK_V);
                    				try {
							            Thread.sleep(300);
							        } catch (InterruptedException e) {
							            e.printStackTrace();
							        }
                                  robot.keyRelease(KeyEvent.VK_V);
                                  break;  
                    case "left":  if(!left){
                    				robot.keyPress(KeyEvent.VK_A);
                    				left=true;
                    			  }else{
                    			  	robot.keyRelease(KeyEvent.VK_A);
                    			  	left=false;
                    			  }
                                  break;
                    case "right": if(!right){
                    				robot.keyPress(KeyEvent.VK_D);
                    				right=true;
                    			  }else{
                    			  	robot.keyRelease(KeyEvent.VK_D);
                    				right=false;
                    			  }
                                  break;
                    case "CENTER":mouseX=currentX;
                    			  mouseY=currentY;
                                  break;              
                    case "Rclick":   robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                    				try {
							            Thread.sleep(300);
							        } catch (InterruptedException e) {
							            e.printStackTrace();
							        }
                                  robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
                                  break; 
                                  
                                  
                     case "lawyer":  robot.keyPress(KeyEvent.VK_T);
                    		try {
                                    Thread.sleep(300);
				} catch (InterruptedException e) {
                                    e.printStackTrace();
				}
                                  robot.keyRelease(KeyEvent.VK_T);
                                  break;  
                                  
                }
                }
                

            } catch (AWTException aWTException) {
            }
	} 
    }

    public static void main(String [] args) throws IOException { 
	Server server = new Server(BASE_PORT);
	server.server_loop(); 
    }
}
	    
    
	