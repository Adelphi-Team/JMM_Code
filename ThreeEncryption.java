import java.io.*;
import java.util.*;
public class ThreeEncryption
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
     //prints the original passage
     for(int m =0; m<charObjectArray.length; m++){
          System.out.print(charObjectArray[m]+" ");
        }
      System.out.println();
     //creating an array for the alphabet (will be useful later)
     char [] alp = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
     
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

      /**
        * Letter values to encrypted values using matrix multiplication
        * Then computes mod26 of the values
        * Matrix:
        * 1 8 3
        * 8 1 9
        * 9 2 6
        */
       
      int[] en = new int[num.length];    
      for(int k = 0; k<num.length; k+=3){
          int [] temparr = {num[k], num[k+1], num[k+2]};
          int x = (1*num[k]) + (8*num[k+1]) + (3*num[k+2]);
          int y = (8*num[k]) + (1*num[k+1]) +(9*num[k+2]);
          int z = (9*num[k]) + (2*num[k+1]) +(6*num[k+2]);
          en[k] = x;
          en[k+1] = y;
          en[k+2] = z;
            }



      //prints this array (for testing purposes)
      for(int m = 0; m < en.length; m++){
            System.out.print(en[m]+" ");
      }
      System.out.println();
     //apply mod 26 to entire array and store it back into the same slot 
      for(int g = 0; g<en.length; g++){
          en[g] = en[g]%26;
      }
      //prints this array (for testing purposes)    
      for(int m = 0; m < en.length; m++){
            System.out.print(en[m] +" ");
      }
      System.out.println();
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

    String str_Test = Arrays.toString(enAlp);
    System.out.println(" ");

    /**
      * Computing the frequency and percentage of each character 
      */
     
    int k;
    double i = str_Test.length();
    char c, ch;
    float average;
        for(c='A'; c<='z'; c++)
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
             if(k>0){
             average = (float)k/(148950);
                 System.out.println("The character " + c + " has occurred for " + k + " time(s) " + average + " the percentage of this is " + (average*100) + "%" );
            }
     }
    }
}
