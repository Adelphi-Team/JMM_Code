import java.io.*;
import java.util.*;
public class FourEncryption
{
  public static void main(String[]args)throws FileNotFoundException, IOException{
       FileReader fr = new FileReader("finalBeatlesSongs2.txt"); 
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
     for(int m =0; m<charObjectArray.length; m++){
          System.out.print(charObjectArray[m]+" ");
        }
      System.out.println();
     //creating an array for the alphabet (will be useful later)
     char [] alp = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
     //encryption matrix
     int[]arr={7,9,4,3};
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
      //prints the array holding the numeric values (for testing purposes)
      for(int m =0; m<num.length; m++){
          System.out.print(num[m]+" ");
        }
      System.out.println();

      //creating a new array to hold the multiplied numbers BEFORE mod 26 
      int[] en = new int[num.length];    
      for(int k = 0; k<num.length; k+=4){
          int [] temparr = {num[k], num[k+1], num[k+2], num[k+3]};
          int x = (4*num[k]) + (5*num[k+1]) + (3*num[k+2]) + (10*num[k+3]) ;
          int y = (5*num[k]) + (5*num[k+1]) +(5*num[k+2] + (6*num[k+3]));
          int z = (3*num[k]) + (5*num[k+1]) +(4*num[k+2]) + (8*num[k+3]);
          int h = (3*num[k]) + (5*num[k+1]) +(9*num[k+2]) + (3*num[k+3]);
         en[k] = x;
         en[k+1] = y;
         en[k+2] = z;
         en[k+3] =h;
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
        String str_Test = Arrays.toString(enAlp);
        System.out.println(" ");
        int ci, k, l=0;
        double i;
        String str, str1;
        char c, ch;
        float  average;
        i=str_Test.length();
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
             if(k>0)
            {
             average = (float)k/(148952);
                System.out.println("The character " + c + " has occurred for " + k + " time(s) " + average + " the percentage of this is " + (average*100) + "%" );
            }
     }
    }
}
