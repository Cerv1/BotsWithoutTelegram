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
  String serverName = "192.168.1.107";
  int port=4444;

  class IncomingClient{

    // public String chooseOption(){
      // String option = "0";
      // while(option!="1" || option!="2"){
      //   System.out.println("\nWelcome! I'm a nice server, this is what I can do: \n");
      //   System.out.println("\t\t[1]: Show an image.");
      //   System.out.println("\t\t[2]: Show a GIF.");
      //   // System.out.println("\t\t[3]: I'm just thinking...");
      //   Console console = System.console();
      //   option = console.readLine("\nWatchu wanna do? --> ");
      // }
      // return option;
    // }

    public String chooseMessage(){
      String option = "";
      Console console = System.console();
      option = console.readLine("\nFine! Now tell me what you want your image/GIF to be about: ");
      return option;
    }

    public void runListener(){
      try{
        // chooseOption();
        System.out.println("Connecting to server:"+serverName+" Port:"+port);
        client = new Socket(serverName,port);
        System.out.println("Connected to: "+client.getRemoteSocketAddress());
        // while(true){
          DataOutputStream output = new DataOutputStream(client.getOutputStream());

          // String option = chooseOption();
          String message = chooseMessage();
          // if(option == "1"){
          //   output.writeUTF(message);
          //   output.flush();
          //   DataInputStream input = new DataInputStream(client.getInputStream());
          //   FileOutputStream image = new FileOutputStream("/home/cervi/Descargas/Telegram-CLI/socket-image.jpg");
          //   int i;
          //   while((i = input.read()) > -1)
          //     image.write(i);
          //   image.flush();
          //   image.close();
          //   input.close();
          // }
          // else if(option == "2"){
            output.writeUTF(message);
            output.flush();
            DataInputStream input = new DataInputStream(client.getInputStream());
            FileOutputStream file = new FileOutputStream("/home/cervi/Descargas/Telegram-CLI/socket-image.jpg");
            int i;
            while((i = input.read()) > -1)
              file.write(i);
            file.flush();
            file.close();
            input.close();

            System.out.println("Image received.");

          // }
          client.close();
        // }
      }catch(Exception e){
        e.printStackTrace();
      }
    }
  }

    public static void main(String [] args) throws IOException{
      new Client();
    }
}
