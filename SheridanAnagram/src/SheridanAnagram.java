import java.util.Scanner;

public class SheridanAnagram {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String s1,s2;
			System.out.print("Welcome to the Anagram Checker! \n");
			while(true) {
				System.out.print("Please enter your first word: ");
				s1=sc.next();
				if(isValid(s1))
					break;
				else
					System.out.println("Invalid input. Please try again.");
			}
			while(true) {
				System.out.print("Please enter your second word: ");
				s2=sc.next();
				if(isValid(s2))
					break;
				else
					System.out.println("Invalid input. Please try again.");
			}
			if(isAnagram(s1, s2))
				System.out.println(s1+" and "+s2+" are anagrams.");
			else
				System.out.println(s1+" and "+s2+" are not anagrams.");
		}
	}
	private static boolean isValid(String str) {
		for(int i=0;i<str.length();i++)
			if(!Character.isLetter((str.charAt(0))))
					return false;
		return true;
	}
	private static boolean isAnagram(String w1, String w2) {
		w1=w1.toLowerCase();
		w2=w2.toLowerCase();
		StringBuffer sb = new StringBuffer(w2);
		for(int i=0;i<w1.length();i++) {
			if(sb.indexOf(w1.charAt(i)+"")!=-1) {
				sb.deleteCharAt(sb.indexOf(w1.charAt(i)+""));
			}
			else {
				return false;
			}
				
		}
		return (sb.length()==0);
	}
}