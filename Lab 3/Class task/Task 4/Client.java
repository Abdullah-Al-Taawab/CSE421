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
             DataOutputStream output= new DataOutputStream(s.getOutputStream());
            PrintWriter writer=new PrintWriter(output,true);
            
           Scanner sc=new Scanner(System.in);
           while(true){
               System.out.println("choose from add,subtract,multiply = ");
               String user_input=sc.nextLine();
               if(user_input.equalsIgnoreCase("add") || user_input.equalsIgnoreCase("subtract") || user_input.equalsIgnoreCase("multiply") ){
               writer.println(user_input);
               System.out.println("num1 = ");
               int user_num1=sc.nextInt();
               writer.println(user_num1);
               System.out.println("num2 = ");
               int user_num2=sc.nextInt();
               writer.println(user_num2);
               }
               else{
                   System.out.println("Response from server = " + " Wrong input");
                   break;
                   
               }
               
               String from_server=input.readLine();
               
               System.out.println("Response from server = " + from_server);
   
                
               break;
           }  
           s.close(); 
            
        }
        
        catch (Exception e){
            System.out.println(e);
        } 
        
    }
    
}
