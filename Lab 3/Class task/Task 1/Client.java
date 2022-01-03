/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserverbasic;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String [] args){
        try{
            Socket s =new Socket("localhost",8888);
            InputStreamReader reader= new InputStreamReader(new DataInputStream(s.getInputStream()));
            BufferedReader input= new BufferedReader(reader);
            
            System.out.println(input.readLine());
            
            
            s.close();
            
            
            
        }
        
        catch (Exception e){
            System.out.println(e);
        } 
        
    }
    
}
