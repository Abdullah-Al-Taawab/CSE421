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
            String today=new Date().toString();
            
            writer.println(today);
            
            
            ss.close();
            
            }
        }
        catch(Exception e){System.out.println(e);}
    }
    
}
