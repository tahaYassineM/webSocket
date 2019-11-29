/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author Moslih
 */
public class TestTriByInsertion {
    public static String tri_insertion(String message) 
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
    
    public static String TriSelect (String message ) {
        
        String table[] = message.split(",");
        int n = table.length-1;
        for ( int i = 1; i <= n-1; i++)
         { // recommence une sous-suite 
           int m = i; // i est l'indice de l'élément frontière ai = table[ i ]
           for ( int j = i+1; j <= n; j++)   // (ai+1, a2, ... , an) 
              if (Integer.parseInt(table[ j ]) < Integer.parseInt(table[ m ])) // aj est le nouveau minimum partiel
                  m = j ; // indice mémorisé
           //on échange les positions de ai et de aj :
              String temp = table[ m ];
               table[ m ] = table[ i ];
               table[ i ] = temp;
        }
        
        StringBuilder builder = new StringBuilder();
        
        for(String s : table)
            builder.append(s + ",");
        
        return builder + "";
    }
    
    public static String tri_bulle(String message)
   {  
        String tab[] = message.split(",");
        int taille = tab.length;  
        String tmp = "";  
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
                        }
 
                }
        }
        
        StringBuilder builder = new StringBuilder();
        
        for(String s : tab)
            builder.append(s + ",");
        
        return builder + "";
   }
       
    public static void main(String[] args) {
        //System.out.println(tri_insertion("1,15,10,5,4,2"));
        
        
        System.out.println(tri_bulle("11,1,15,10,5,4,2"));
    }
}
