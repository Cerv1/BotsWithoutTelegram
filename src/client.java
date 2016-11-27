import java.io.*;
import java.util.*;
import java.lang.*;
import java.net.Socket;
import javax.imageio.*;
import javax.swing.*;

class Client{

  public Client() throws IOException{
    ic.runListener();
  }

  private IncomingClient ic = new IncomingClient();
  Socket client;
  String serverName = "192.168.1.37";
  int port=4444;

  class IncomingClient{
    public void runListener(){
      try{
        System.out.println("Connecting to server:"+serverName+" Port:"+port);
        client = new Socket(serverName,port);
        System.out.println("Connected to: "+client.getRemoteSocketAddress());
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        Console console = System.console();
        String target = console.readLine("You want an image about... ");
        output.writeUTF(target);
        output.flush();
        DataInputStream input = new DataInputStream(client.getInputStream());
        FileOutputStream image = new FileOutputStream("/home/adri/Descargas/Telegram-CLI/socket-image.jpg");
        int i;
        while((i = input.read()) > -1){
          image.write(i);
        }
        image.flush();
        image.close();
        input.close();
        client.close();
      }catch(Exception e){
        e.printStackTrace();
      }
    }
  }

    public static void main(String [] args) throws IOException{
      new Client();
    }
}
