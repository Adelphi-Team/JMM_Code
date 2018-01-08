import java.util.*;
public class Determinant {
    //Method for the determinant
    public int determinant(int[][] arr) {
        int result = 0;
        //if the array is 1 then you have the determinant as the 0,0 position
        if (arr.length == 1) {
            result = arr[0][0];
            return result;
        }
        //if the array is 2 then you have our basic ad-cb
        if (arr.length == 2) {
            result = arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0];
            return result;
        }
        //This is for anything that is bigger than a 2 by 2
        //The n by n matrix determination
        for (int i = 0; i < arr[0].length; i++) {
            int temp[][] = new int[arr.length - 1][arr[0].length - 1];
            for (int j = 1; j < arr.length; j++) {
                for (int k = 0; k < arr[0].length; k++) {
                    if (k < i) {
                        temp[j - 1][k] = arr[j][k];
                    } else if (k > i) {
                        temp[j - 1][k - 1] = arr[j][k];
                    }
                }
            }
            result += arr[0][i] * Math.pow(-1, (int) i) * determinant(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number for the size of n for an n*n matrix: ");
        int n = in.nextInt();
        int[][] array = new int[n][n];
        for( int i = 0 ; i < array.length ; i++ ) { 
           for ( int j = 0 ; j < array[i].length ; j++ ) { 
              array[i][j] = random.nextInt(11);
           }
        }
        for( int[] a : array ) { 
            System.out.println( Arrays.toString( a ));
        }
        Determinant d = new Determinant();
        //get the determinate of the array that we plugged in
        int result = d.determinant(array);
        System.out.println(result);
    }
}
