import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
      e.printStackTrace();
    }
  }
  class OutgoingClient{
    public void runSender(){
      try{
        server = serverSocket.accept();
        System.out.println("Computers connected...");
      }catch(Exception e){
        e.printStackTrace();
      }
    }
  }
  public static void main (String args[]) throws IOException{
  new Server();
  }
}
