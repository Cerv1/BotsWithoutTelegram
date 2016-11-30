import java.io.*;
import java.util.*;
import java.lang.*;
import java.net.Socket;
import javax.imageio.*;
import javax.swing.*;

class Client{    //client side. the one who asks for a pic and receives it

  public Client() throws IOException{
    ic.runListener();   //start looking for a pic
  }

  private IncomingClient ic = new IncomingClient();
  Socket client;
  String serverName = "25.22.48.56";    //server IP direction
  int port = 4444;    //server authorized port

  class IncomingClient{

    public String chooseMessage(){
      String option = "";
      Console console = System.console();
      option = console.readLine("\nHi! Tell me what you want your image to be about: ");
      return option;
    }

    public void cleanAll(){
      String dirPath = "/home/adri/Descargas/Telegram-CLI/";
      File dir = new File(dirPath);
      File[] files = dir.listFiles();
      for(File aFile : files)
        aFile.delete();

      boolean deleted = dir.delete();
      if(deleted)
        System.out.println("Images removed...");
      else
        System.out.println("Couldn't clean...");
    }

    public void runListener(){
      try{
        System.out.println("Connecting to server: "+serverName+"; Port: "+port);    //
        client = new Socket(serverName,port);                                       //  connection with server
        System.out.println("Connected to: "+client.getRemoteSocketAddress());       //

        //type of object to contain the received image
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        String message = chooseMessage();
        output.writeUTF(message);   //choose theme related image
        output.flush();             //
        DataInputStream input = new DataInputStream(client.getInputStream());
        FileOutputStream file = new FileOutputStream("/home/adri/Descargas/Telegram-CLI/socket-image.jpg");

        int i;
        while((i = input.read()) > -1)
          file.write(i);    //burn received image to file

        file.flush();     //
        file.close();     //
        input.close();    //
        client.close();   //closing files, input and socket

        Thread.sleep(1000);   //giving time to eog process to load the image
        String target = "eog /home/adri/Descargas/Telegram-CLI/socket-image.jpg";
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec(target);
        proc.waitFor();

      }catch(Exception e){
        e.printStackTrace();
      }
    }
  }

    public static void main(String [] args) throws IOException{
      new Client();
    }
}
