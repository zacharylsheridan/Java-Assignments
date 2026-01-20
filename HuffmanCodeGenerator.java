/**
 * A program that test the PQueueADT implementation by using
 * it to generate Huffman binary codes for a set of 
 * character-frequency pairs.
 * @author Duncan, Sheridan
 * @see SymData, PQueueAPI, PQueue
 * <pre>
 * Date: 9-28-2024
 * Course: csc 3102
 * Programming Project: 1
 * Instructor: Dr. Duncan
 * </pre>
 */
import java.util.Comparator;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;

public class HuffmanCodeGenerator
{
   /**
    * Generates a table with a list of codewords
    * @param codeList the list of codes 
    * @return an array list sorted by symbols in ascending order
    */
   public static ArrayList<SymData>  genTable(ArrayList<SymData> codeList) throws PQueueException
   {
      PQueue<SymData> pq = new PQueue<>((a, b) -> Character.compare(a.getSymb(), b.getSymb()));
      for (SymData code : codeList) {
         pq.insert(code);
      }
      ArrayList<SymData> sortedList = new ArrayList<>();
      while (!pq.isEmpty()) {
         sortedList.add(pq.remove());
      }
      return sortedList;
   }
   /**
    * Generates Huffman codes given the root of a Huffman Tree
    * @param root the root of a Huffman Tree
    * @return an ArrayList containing SymData objects 
    */
   public static ArrayList<SymData>  genHuffCodes(SymData root) throws PQueueException
   {
      ArrayList<SymData> huffCodes = new ArrayList<>();
      ArrayList<SymData> s = new ArrayList<>();
      s.add(root);
      while (!s.isEmpty()) {
         SymData node = s.remove(0);
         // If left child, assign the code and add to the stack
         if (node.getLeft() != null) {
            node.getLeft().setCode(node.getCode() + "0");
            s.add(node.getLeft());
         }
         // If right child, assign the code and add to the stack
         if (node.getRight() != null) {
            node.getRight().setCode(node.getCode() + "1");
            s.add(node.getRight());
         }
         // If leaf node, add it to the list of Huffman codes
         if (node.getLeft() == null && node.getRight() == null) {
            huffCodes.add(node);
         }
      }
      return huffCodes;
   }
   /**
    * Generates a binary Huffman Tree 
    * @param huffForest a forest of SymData objects
    * @return a reference to the root of the Huffman tree 
    */
   public static SymData  genHuffTree(PQueue<SymData> huffForest) throws PQueueException
   {
      while (huffForest.size() > 1) {
         SymData left = huffForest.remove(); // Get the left node
         SymData right = huffForest.remove(); // Get the right node
         // Create parent node with combined frequency
         SymData combined = new SymData('\0', left.getFreq() + right.getFreq(), "", left, right);
         huffForest.insert(combined); // Insert the new parent node
      }

      return huffForest.remove(); // Return the root of the tree
   }
   public static void main(String[] args) throws IOException
   {
      try {
         if (args.length != 1) {
            System.out.println("Invalid number of command line arguments");
            System.exit(1);
         }
         // Reading the file and inserting symbol-frequency pairs into the priority queue
         PQueue<SymData> pq = new PQueue<>((a, b) -> {
            if (a.getFreq() != b.getFreq()) {
               return Integer.compare(a.getFreq(), b.getFreq());
            } else {
               return Character.compare(a.getSymb(), b.getSymb());
            }
         });
         Scanner scanner = new Scanner(new FileReader(args[0]));
         while (scanner.hasNext()) {
            char symbol = scanner.next().charAt(0);
            int frequency = scanner.nextInt();
            pq.insert(new SymData(symbol, frequency, "", null, null)); // Insert into priority queue
         }
         scanner.close();
         // Generate Huffman tree
         SymData huffTreeRoot = genHuffTree(pq);
         // Generate Huffman codes
         ArrayList<SymData> huffCodes = genHuffCodes(huffTreeRoot);
         // Generate table and print result
         ArrayList<SymData> sortedTable = genTable(huffCodes);
         System.out.printf("%-10s %-10s %-10s%n", "Symbol", "Frequency", "Codeword");
         for (SymData sd : sortedTable) {
            System.out.printf("%-10c %-10d %-10s%n", sd.getSymb(), sd.getFreq(), sd.getCode());
         }
      }
      catch (PQueueException e) {
         System.out.println(e.getMessage());
      }
	}
}
