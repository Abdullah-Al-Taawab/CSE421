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
        
        InputStreamReader reader= null;
        try {
            DataOutputStream output= new DataOutputStream(s.getOutputStream());
            PrintWriter writer=new PrintWriter(output,true);
            reader = new InputStreamReader(new DataInputStream(s.getInputStream()));
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
                
                
                
            }   } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   
    
    
    
    
}
}

}
