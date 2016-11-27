import java.io.IOException;
import java.net.Socket;

class Client{

  public Client() throws IOException{
    ic.runListener();
  }

  private IncomingClient ic = new IncomingClient();
  Socket client;
  String serverName = "192.168.43.34";
  int port=4444;

  class IncomingClient{
    public void runListener(){
      try{
        System.out.println("Connecting to server:"+serverName+" Port:"+port);
        client = new Socket(serverName,port);
        System.out.println("Connected to: "+client.getRemoteSocketAddress());
        }catch(Exception e){
          e.printStackTrace();
        }
      }
    }

    public static void main(String [] args) throws IOException{
      new Client();
    }
}
