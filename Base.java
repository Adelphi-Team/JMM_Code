import java.io.*;
import java.util.*;
/**
 * base.java
 * 
 * This program takes our original text and finds the frequency of the characters
 */
public class Base
{
  public static void main(String[]args)throws FileNotFoundException, IOException{
     FileReader fr = new FileReader("finalBeatlesSongs.txt"); 
     BufferedReader br = new BufferedReader(fr); 
     String line;
     String s = "";
     while((line = br.readLine()) != null)
     { 
        s += line;
     } 
     fr.close();
     
     //creating an array for charcter objects to allow for use of a large amount of data
     Character[] charObjectArray = s.chars().mapToObj(c -> (char)c).toArray(Character[]::new);;
     
     String str_Test = Arrays.toString(charObjectArray);
     int k;
     double i = str_Test.length();
     char ch;
     float average;
        
     for(char c='A'; c<='z'; c++)
        {
            k = 0;
            for(int j = 1; j < i-1; j++)
            {
                ch = str_Test.charAt(j);
                if(ch == c)
                {
                    k++;
                }
            }
             if(k>0)
            {
             average = (float)k/(148950);
             System.out.println("The character " + c + " has occurred for " + k + " time(s) " + average + " the percentage of this is " + (average*100) + "%" );
            }
     }
    }
}
