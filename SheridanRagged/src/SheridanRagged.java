/* Sheridan Ragged
 * This Program is designed to create a simple ragged array based on user input
 * Dr. Reco Knowles
 * 24 September 2023
 */

import java.util.Scanner;

public class SheridanRagged {
    public static void main(String[] args) {
        int array[][] = new int[5][];
        
        try (Scanner scan = new Scanner(System.in)) {
			int size, sum, min, max;
			
			System.out.print("Welcome to the ragged array generator!\n");
			
			for(int i = 0;i<array.length;i++){
			    System.out.print("Enter size of array "+(i+1)+": ");
			    
			    size = scan.nextInt();

			    if(size>0) {
			        System.out.println("Enter "+size+" numbers");
			        
			        array[i] = new int[size];

			        for (int j = 0; j < size; j++) {
			            array[i][j] = scan.nextInt();
			        }

			        sum = array[i][0];
			        min = array[i][0];
			        max = array[i][0];

			        for (int j = 1; j < size; j++) {
			            sum += array[i][j];
			           
			            if(min > array[i][j]){
			                min = array[i][j];
			            }
			            
			            if(max < array[i][j]){
			                max = array[i][j];
			            }
			        }

			        System.out.println("Sum of row "+(i+1)+" is "+sum);
			        System.out.println("Minimum of row "+(i+1)+" is "+min);
			        System.out.println("Maximum of row "+(i+1)+" is "+max);
			    }
			}
		}
    }
}