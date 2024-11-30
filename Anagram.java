
/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent", "listen"));  // true
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true
	
		System.out.println(preProcess("What? No way!!!"));
	
		System.out.print("silent and ");
		System.out.print(randomAnagram("silent"));
		System.out.println(" are anagrams.");
	
		String str = "1234567";
		Boolean pass = true;
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}
	 

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code
		str1 = preProcess(str1);
		str2 = preProcess(str2);

		if(str1.length() != str2.length()){
			return false;
		}

		for (int i = 0; i < str1.length(); i++){
			char c = str1.charAt(i);
			int count1 = 0; 
			int count2 = 0;
			for (int n = 0; n < str1.length(); n++) {
				if (str1.charAt(n) == c) {
					count1++;
				}
				if (str2.charAt(n) == c) {
					count2++;
				}
			}
			
		if (count1 != count2) {
			return false;
		}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase(); // המרת כל האותיות לאותיות קטנות
		String newstr = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ((c >= 'a' && c <= 'z') || c == ' ') { // שמירת אותיות ורווחים בלבד
				newstr += c;
			}
		}
		return newstr;
	}
	
	
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		str = preProcess(str);
		String nstr = "";
		int size = str.length();
		for (int n = 0; n < size; n++) {
			double a = (Math.random() * str.length());
			int r = (int) a;
			nstr = nstr + str.charAt(r);
			str = str.substring(0, r) + str.substring(r + 1);
		}
		return nstr;
	}	
	
}