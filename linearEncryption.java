import java.io.*;
import java.util.*;
/**
 * linearEncryption.java
 * 
 * This program runs through our passage and encrypts it using the linear encryption technique
 */

public class linearEncryption
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
     
    Character[] charObjectArray = s.chars().mapToObj(c -> (char)c).toArray(Character[]::new);;
    for (int i = 0; i < charObjectArray.length; i++){
      System.out.print(charObjectArray[i]);
     }
     
    //prints the original passage
    for(int m =0; m<charObjectArray.length; m++){
          System.out.print(charObjectArray[m]+" ");
        }
    System.out.println();
    
    //creating an array for the alphabet
    char [] alp = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    
    /**
     * Passage to values
     * Simply checking id the number corresponds with the inde of the alphabet array
     * and storing that number in our new array
     */
    //creating a new matrix to store numeric values for the passage 
    int []num = new int[charObjectArray.length];
    //turns passage into number for corresponding character
    for(int j =0; j<charObjectArray.length; j++){
             for(int i = 0; i< alp.length; i++){
               if(charObjectArray[j] == alp[i]){
                   num[j] = i;
               }
            }
        }
    //prints the array holding the numeric values
    for(int m =0; m<num.length; m++){
          System.out.print(num[m]+" ");
        }
    System.out.println();
    
    /**
     * Passage to encrypted values
     * Using the formula: 
     * encrypted letter = 15x+3mod26
     */
    //creating a new array to hold the multiplied numbers BEFORE mod 26
    int[] en = new int[num.length];
    for(int k = 0; k<num.length; k+=1){
          int x = (15*num[k]) + 3;
          en[k] = x;
            }
    //apply mod 26 to entire array and store it back into the same slot 
    for(int g = 0; g<en.length; g++){
          en[g] = en[g]%26;
      }
    //prints this array (for testing purposes)    
    for(int m = 0; m < en.length; m++){
            System.out.print(en[m] +" ");
     }
    System.out.println();
    
    /**
     * Encrypted values to encrypted letters
     * Again searching through the alphabet array for the index and storing that letter in our new array
     */
      //creating a new array to hold the newly encrypted letters
      char [] enAlp = new char[en.length];  
      //uses the numbers in the array to find what letter they would be encrypted
      for(int m =0; m<en.length; m++){
             for(int n = 0; n< alp.length; n++){
               if(en[m] == n){
                   enAlp[m] = alp[n];
               }
            }
        }
      //prints this array (for testing purposes)
      for(int m = 0; m < enAlp.length; m++){
           System.out.print(enAlp[m] + " ");
          }
      System.out.println();

      /**
        * Computing the frequency and percentage of each character 
        */
      String str_Test = Arrays.toString(enAlp);
      int k;
      double i = str_Test.length();
      char ch;
      float average;
        for(char c='A'; c<='z'; c++)
        {
            k=0;
            for(int j=1; j<i-1; j++)
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
