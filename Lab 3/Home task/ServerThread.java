/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserverbasic;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
/**
 *
 * @author Asus
 */
public class ServerThread extends Thread{
    
    Socket s;
    ServerThread(Socket s){
        
        this.s=s;
    }

    
    
    @Override
    public void run(){
        
        try {
            InputStreamReader reader= null;
            
            DataOutputStream output= new DataOutputStream(s.getOutputStream());
            PrintWriter writer=new PrintWriter(output,true);
            reader = new InputStreamReader(new DataInputStream(s.getInputStream()));
            BufferedReader input= new BufferedReader(reader);
            
            String a="";
            String from_clint=input.readLine();
            for(int i=0;i<from_clint.length();i++){
            int character=from_clint.charAt(i);
            a=a+" " + Integer.toString(character);
  
  }
             writer.println(a);
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                
                
           
        }
   
    
    
    
    
}

