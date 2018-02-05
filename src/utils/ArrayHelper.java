package utils;

/**
 * Created by sergei.kostin on 12/22/17.
 */
public class ArrayHelper {

    public static void printArrayWithIndexes(int[] array){
        System.out.print("|");
        for(int i = 0; i < array.length; i++){
            System.out.printf(" %2d |" , i );
        }

        System.out.println();
        System.out.print("|");
        for(int i = 0; i < array.length; i++){
            System.out.printf(" %2d |" , array[i] );
        }
        System.out.println();
    }

    public static  void print2DCharArray(char[][] arr){

        for(int row = 0; row < arr.length; row++){
            System.out.print("|");
            for(int col = 0; col < arr[0].length; col++){
                System.out.printf("%s|", arr[row][col]);
            }
            System.out.println();
        }
    }

    public static  void print2DIntArray(int[][] arr){

        for(int row = 0; row < arr.length; row++){
            System.out.print("|");
            for(int col = 0; col < arr[0].length; col++){
                System.out.printf("%2d|", arr[row][col]);
            }
            System.out.println();
        }
    }

}
