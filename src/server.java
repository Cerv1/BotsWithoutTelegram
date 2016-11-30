import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Object;
import java.io.*;
import java.util.*;

class Server{
  private OutgoingClient os = new OutgoingClient();
  private ServerSocket serverSocket;
  Socket server;

  public Server() throws IOException{
    try{
      System.out.println("Creating Socket...");
      serverSocket = new ServerSocket(4444);
      System.out.println("Socket created...");
      os.runSender();
    }catch(Exception e){
      // e.printStackTrace();
    }
  }
  class OutgoingClient{

    // Delete all files and folder in path dirPath
    public void cleanAll(){
      String dirPath = "/home/cervi/.telegram-cli/downloads/";
      File dir = new File(dirPath);
      File[] files = dir.listFiles();
      for(File aFile : files){
        aFile.delete();
      }

      boolean deleted = dir.delete();
      if(deleted)
        System.out.println("Images removed...");
      else
        System.out.println("Couldn't clean...");
    }

    public void runSender(){
      try{
        while(true){      // Server is always up!
          server = serverSocket.accept();   //Accept incoming connection
          System.out.println("Computers connected...");

          // Path to our script wich executes telegram-cli and lua script
          String target = new String("/home/cervi/BotsWithoutTelegram/src/image_getter.sh ");

          // Read primitive Java data types
          DataInputStream input = new DataInputStream(server.getInputStream());

          // Conversion of raw data type into string
          String object = input.readUTF();
          target+=object;
          System.out.print("Gotta find a... "+object!);
          System.out.println("       I'M ON IT!");

          // Returns the runtime object associated with this application
          Runtime rt = Runtime.getRuntime();

          // Create a subprocess wich executes target
          Process proc = rt.exec(target);

          // Wait for it
          proc.waitFor();

          // We get input bytes from image
          FileInputStream image = new FileInputStream("/home/cervi/.telegram-cli/downloads/image");

          // Write primitive Java data types
          DataOutputStream output = new DataOutputStream(server.getOutputStream());
          int i;
          System.out.println("Sending image...");

          // Write image in output
          while((i=image.read())>-1){
            output.write(i);
          }

          // Close all
          image.close();
          output.close();
          server.close();

          // Delete received images
          cleanAll();
        }
      }catch(Exception e){
        // e.printStackTrace();
      }
    }
  }
  public static void main (String args[]) throws IOException{
    new Server();
  }
}
