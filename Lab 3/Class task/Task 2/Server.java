/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserverbasic;

import java.io.*;
import java.net.*;
import java.util.Date;

public class Server {
    public static void main(String [] args){
        try{
            while(true){
            ServerSocket ss=new ServerSocket(8888);
            System.out.println("Server Initiated");
            Socket s= ss.accept();
            System.out.println("Client Connected");
            DataOutputStream output= new DataOutputStream(s.getOutputStream());
            PrintWriter writer=new PrintWriter(output,true);
            InputStreamReader reader= new InputStreamReader(new DataInputStream(s.getInputStream()));
            BufferedReader input= new BufferedReader(reader);
            while(true){
                String from_clint=input.readLine();
                if(from_clint.equalsIgnoreCase("end game")){
                    writer.println("end game");
                    break;  
                    
                }
                else{
                    writer.println(from_clint);
                }
                
                
            }
            
        ss.close();

            
            
            } 
        }
        catch(Exception e){System.out.println(e);}
    }
    
}
