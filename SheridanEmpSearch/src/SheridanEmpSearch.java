/* SheridanEmpSearch
 * This program is designed to enter names and IDs of employees and use a HashMap to store that data. Then, the program can search for the corresponding name or ID when prompted.
 * Dr Reco Knowles
 * 24 September 2023
 */
import java.util.HashMap;
import java.util.Scanner;

public class SheridanEmpSearch {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			HashMap<String, String> data=new HashMap<>(); 
			
			int count=0;
			
			String name="";
			
			String id="";
			
			while(count<10 && !id.equals("ZZZ")){ 
				System.out.print("Enter Employee ID. All Employee IDs are five(5) characters long and begin with the letter B (Ex. B1234).\n"); //User Input: ID
				
				id=sc.nextLine();
				
				if(id.equals("ZZZ")){ //Sentinel
					break;
				}
				
				if(id.length()>5 || !id.startsWith("B")){ 
					System.out.println("That is not a valid ID.");
					
					break;
				}
				
				System.out.print("Enter Employee Name: "); //User Input: Name
				
				name=sc.nextLine();
				
				data.put(id, name);
				
				count++; 
			}
			id="";
			
			System.out.println("Employee Search:");
			
			while(!id.equals("ZZZ")){ 
				System.out.print("Enter an ID number: "); 
				
				id=sc.nextLine();
				
				if(id.equals("ZZZ")){
					break;
				}
				
				if(!data.containsKey(id)){ 
					System.out.println("This ID does not exist.");
				}
				
				else{ 
					System.out.println("Employee Name: "+data.get(id));
				}
			}
		}
	}
}
