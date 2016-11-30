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
          server = serverSocket.accept();
          System.out.println("Computers connected...");
          String target = new String("/home/cervi/BotsWithoutTelegram/src/image_getter.sh");
          DataInputStream input = new DataInputStream(server.getInputStream());
          target+=" ";
          target+=input.readUTF();
          System.out.println("TARGET: "+target );
          Runtime rt = Runtime.getRuntime();
          Process proc = rt.exec(target);
          proc.waitFor();

          FileInputStream image = new FileInputStream("/home/cervi/.telegram-cli/downloads/image");
          DataOutputStream output = new DataOutputStream(server.getOutputStream());
          int i;
          System.out.println("Sending image...");
          while((i=image.read())>-1){
            output.write(i);
          }
          image.close();
          output.close();
          server.close();

          cleanAll();

      }catch(Exception e){
        // e.printStackTrace();
      }
    }
  }
  public static void main (String args[]) throws IOException{
    new Server();
  }
}
