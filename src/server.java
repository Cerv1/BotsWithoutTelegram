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
          // Process proc = new ProcessBuilder("/home/cervi/tg/bin/telegram-cli","-N").start();
          Process proc = new ProcessBuilder("/home/cervi/LeDankCloud-FR/src/WannaSeeCuteCats.sh","-N").start();
          // contact_search ImageBot; msg ImageBot /get cat; load_file 2; quit; exit"
          // Process proc = rt.exec("ls -la");
          InputStream in = proc.getInputStream();
          OutputStream out = proc.getOutputStream();
          InputStream err = proc.getErrorStream();
          Scanner s = new Scanner(in).useDelimiter("\\A");
          String result = s.hasNext() ? s.next() : "";
          System.out.println(result);
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
