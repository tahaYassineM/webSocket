import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/serverEndpoint")
public class Server {

    @OnOpen
    public void handleOpen(Session userSession) {
        System.out.println("client is connected ...");
    }

    @OnMessage
    public String handleMessage(String message, Session userSession) throws IOException {
        System.out.println("Message received from client : " + message);
        
        String tab[] = message.split(",");
              int taille = tab.length;  
              String tmp = "";
        StringBuilder builder = new StringBuilder();
        
        for(int i=0; i < taille; i++) 
        {
                for(int j=1; j < (taille-i); j++)
                {  
                        if(Integer.parseInt(tab[j-1]) > Integer.parseInt(tab[j]))
                        {
                                //echanges des elements
                                tmp = tab[j-1];  
                                tab[j-1] = tab[j];  
                                tab[j] = tmp;  
                                
                                builder.delete(0, builder.length());

                        for(String str : tab)
                            builder.append(str+ ",");
    
                        userSession.getBasicRemote().sendText(builder + "\n");
                        }
                        
                }
        }
                    
            for(String str : tab)
                builder.append(str+ ",");
        
        return builder + "";
    }

    private String tri_insertion(String message) 
     {  
        String tab[] = message.split(",");
              int taille = tab.length;  
              int k = 0;
            for(String str : tab)
                System.out.println("tab[" + (k++) + "]= " + str );
              for (int i = 1; i < taille; i++)
              { 
                   int index = Integer.parseInt(tab[i]);  
                   int j = i-1;  
                
                   while ( ( Integer.parseInt(tab[j]) > index ) && (j > -1) ) 
                   {
                        tab[j+1] = tab[j];  
                        j--;  
                   }  
                   tab[j+1] = index + ""; 
            }  
              
            StringBuilder builder = new StringBuilder();
            
            for(String str : tab)
                builder.append(str+ ",");
        
        return builder + "";
     }
    @OnClose
    public void handleClose() {
        System.out.println("client is disconnected...");
    }

    @OnError
    public void handleError(Throwable t) {
    }
}
