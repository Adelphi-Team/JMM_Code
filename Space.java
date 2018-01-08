import java.io.*;
import java.util.Scanner;
/**
 * Space.java
 * 
 * This program is used to read in a file of text and remove all unwanted 
 * characters and spaces. Also, the program counts the number of words
 * inputed from the file.
 */
public class Space{
   public static void main (String[]args) throws FileNotFoundException, IOException{
   // First count the number of words in a file
    File file = new File("beatles.txt");
    try(Scanner sc = new Scanner(new FileInputStream(file))){
     int count=0;
     while(sc.hasNext()){
        sc.next();
        count++;
     }
    System.out.println("Number of words: " + count);
   }
   
    FileReader fr = new FileReader("beatles.txt"); 
    BufferedReader br = new BufferedReader(fr); 
    FileWriter fw = new FileWriter("nospaces.txt"); 
    String line;
    // Next, remove all unwanted characters and spaces, and also change all letters to lowercase
    while((line = br.readLine()) != null)
    { 
        line=line.replaceAll(" ", "");
        line = line.replaceAll("[()&!#+-=?:;,.$%'\"]", "");
        line = line.replaceAll("[0-9]", "");
        line = line.toLowerCase();
        fw.write(line);
    } 
    fr.close();
    fw.close();
 }
}
