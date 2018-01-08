import java.io.*;
import java.util.*;
public class FiveEncryption
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
      for(int k = 0; k<num.length; k+=5){
          int [] temparr = {num[k], num[k+1], num[k+2], num[k+3], num[k+4]};
          int x = (6*num[k]) + (1*num[k+1]) + (8*num[k+2]) + (6*num[k+3])+ (5*num[k+4]) ;
          int y = (3*num[k]) + (4*num[k+1]) +(4*num[k+2] + (8*num[k+3]) + (5*num[k+4]));
          int z = (4*num[k]) + (7*num[k+1]) +(2*num[k+2]) + (2*num[k+3])+ (8*num[k+4]);
          int h = (8*num[k]) + (5*num[k+1]) +(3*num[k+2]) + (2*num[k+3])+ (2*num[k+4]);
          int t = (8*num[k]) + (1*num[k+1]) +(3*num[k+2]) + (3*num[k+3]) + (2*num[k+4]);
         en[k] = x;
         en[k+1] = y;
         en[k+2] = z;
         en[k+3] =h;
         en[k+4] =t;
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


    int ci, j, k, l=0;

    double i;
    String str, str1;
    char c, ch;
    float  average;
    i=str_Test.length();
        for(c='A'; c<='z'; c++)
        {
            k=0;
            for(j=1; j<i-1; j++)
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
