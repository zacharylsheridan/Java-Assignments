/**
 * A program to profile derangement algorithms, a naive implementation
 * and a fast version of the algorithm
 * !n = n!(1/0! - 1/1! + 1/2! - 1/3! + 1/4! + ... 1/n!)
 * @author William Duncan, Zachary Sheridan
 * @see Derangement.java
 * <pre>
 * Date: 9-9-2024
 * Course: CSC 3102 Section 1
 * Project # 0
 * Instructor: Dr. Duncan
 * </pre>
 */
 
import java.util.Scanner;
public class DerangeProfiler
{
   public static void main(String[] args)
   {
       Scanner input = new Scanner(System.in); // Creating a scanner object
       System.out.println("Welcome to the Derangement Profiler!\nPlease input two non-negative integers and the program will calculate the number of derangements for each size!");
       int x = input.nextInt();
       int y = input.nextInt();
       System.out.printf("Using Fast Derangement:\n!" + x + " = " + Derangement.fastDerange(x) + "\n!" + y + " = " + Derangement.fastDerange(y) + "\n");
       System.out.printf("Using Naive Derangement:\n!" + x + " = " + Derangement.naiveDerange(x) + "\n!" + y + " = " + Derangement.naiveDerange(y) + "\n");
       //NOTE: Everything here on in wasn't specified in the doc but it helped me manage the graph and it was a fun exercise in searching the Internet for answers
       //WEBSITE I USED: https://www.tutorialspoint.com/java/lang/system_nanotime.htm
       System.out.printf("%-10s%-20s%-15s%-20s%-15s\n", "n", "!n (naive)", "Time(ns)", "!n (fast)", "Time(ns)");
       for (int n = 20; n <= 160; n += 20) {
           long startNaive = System.nanoTime();
           double naiveResult = Derangement.naiveDerange(n);
           long endNaive = System.nanoTime();
           long naiveTime = endNaive - startNaive;

           long startFast = System.nanoTime();
           double fastResult = Derangement.fastDerange(n);
           long endFast = System.nanoTime();
           long fastTime = endFast - startFast;

           System.out.printf("%-10d%-20.6e%-15d%-20.6e%-15d\n", n, naiveResult, naiveTime, fastResult, fastTime);
       }
       input.close();
   }
}
