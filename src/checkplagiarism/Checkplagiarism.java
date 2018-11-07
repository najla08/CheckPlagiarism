/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkplagiarism;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;


/**
 *
 * @author najla
 */
public class Checkplagiarism {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
       
        List<String> x = new ArrayList<String>();
        List<String> y = new ArrayList<String>();
            try{
                
    File file1 = new File("/Users/najla/Desktop/LCS.java");
    File file2 = new File("/Users/najla/Desktop/LCSP.java");

    Scanner input = new Scanner(file1); 
    Scanner input2 = new Scanner(file2); 

 
    while (input.hasNext()) {
      String word  = input.next();
      x.add(word);
    
    }
        while (input2.hasNext()) {
      String word  = input2.next();
      y.add(word);
    
    }
    
       
            }catch(FileNotFoundException error)
       {
           System.out.println("The specified file not found" + error);
        }
        catch(IOException ioe)
        {
            System.out.println("I/O Exception: " + ioe); 
        }
       
       // System.out.print(y.get(0));
              //  System.out.print(x.size());

        int c[][]=new int[x.size()+1][y.size()+1];

        
        for(int i=0;i<=x.size();i++){
             c[i][0]=0;
        }
        for(int i=0;i<=y.size();i++){
             c[0][i]=0;
        }
        for(int i=1; i<=x.size();i++){
            for(int j=1; j<=y.size();j++){
                
                if(x.get(i-1).equals(y.get(j-1)) ){
                    c[i][j]=c[i-1][j-1]+1;
                }else if(c[i-1][j]>=c[i][j-1]) {
                    
                    c[i][j]=c[i-1][j];
                }else{
                    c[i][j]=c[i][j-1];
                }
            
            }//end inner loop
                }//end outer loop
                    double pl=c[x.size()][y.size()];
                    double p=(pl/y.size())*100;
                       System.out.println(String.format( "%.2f", p )+"%" );
                       
                       
        // TODO code application logic here
    }
    
}
