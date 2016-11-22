import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
    public void runSender(){
      try{
        // while(true){
          // server = serverSocket.accept();
          System.out.println("Computers connected...");
          Runtime rt = Runtime.getRuntime();
          Process proc = new ProcessBuilder("~/LeDankCloud-FR/src/WannaSeeCuteCats.sh").start();
          proc.destroy() ;
        // }
      }catch(Exception e){
        // e.printStackTrace();
      }
    }
  }
  public static void main (String args[]) throws IOException{
    new Server();
  }
}
