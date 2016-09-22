public class StringTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		wordEnds("abcXY123XYijk", "XY");
		wordEnds("XY123XY", "XY");
		wordEnds("XY1XY", "XY");
	}

	/*
	 * Given a string, return a string where for every char in the original,
	 * there are two chars.
	 * 
	 * doubleChar("The") → "TThhee" doubleChar("AAbb") → "AAAAbbbb"
	 * doubleChar("Hi-There") → "HHii--TThheerree"
	 */
	public String doubleChar(String str) {
		String newString = new String();
		for (int i = 0; i < str.length(); i++) {
			newString += str.charAt(i);
			newString += str.charAt(i);
		}
		return newString;
	}

	/*
	 * Return the number of times that the string "hi" appears anywhere in the
	 * given string.
	 * 
	 * countHi("abc hi ho") → 1 countHi("ABChi hi") → 2 countHi("hihi") → 2
	 */
	public int countHi(String str) {
		return (str.length() - str.replace("hi", "").length()) / "hi".length();
	}

	/*
	 * Given two strings, word and a separator sep, return a big string made of
	 * count occurrences of the word, separated by the separator string.
	 * 
	 * repeatSeparator("Word", "X", 3) → "WordXWordXWord"
	 * repeatSeparator("This", "And", 2) → "ThisAndThis" repeatSeparator("This",
	 * "And", 1) → "This"
	 */

	public String repeatSeparator(String word, String sep, int count) {
		String returnString = word;
		if (count == 0)
			return "";
		for (int i = 0; i < count - 1; i++) {
			returnString += sep + word;
		}
		return returnString;
	}

	/*
	 * Look for patterns like "zip" and "zap" in the string -- length-3,
	 * starting with 'z' and ending with 'p'. Return a string where for all such
	 * words, the middle letter is gone, so "zipXzap" yields "zpXzp".
	 * 
	 * zipZap("zipXzap") → "zpXzp" zipZap("zopzop") → "zpzp" zipZap("zzzopzop")
	 * → "zzzpzp"
	 */
	public String zipZap(String str) {
		return str.replaceAll("z(.)p", "zp");
	}

	/*
	 * Return true if the string "cat" and "dog" appear the same number of times
	 * in the given string.
	 * 
	 * catDog("catdog") → true catDog("catcat") → false catDog("1cat1cadodog") →
	 * true
	 */
	public boolean catDog(String str) {
		return (str.length() - str.replaceAll("cat", "").length() == str
				.length() - str.replaceAll("dog", "").length());
	}

	/*
	 * Return the number of times that the string "code" appears anywhere in the
	 * given string, except we'll accept any letter for the 'd', so "cope" and
	 * "cooe" count.
	 * 
	 * countCode("aaacodebbb") → 1 countCode("codexxcode") → 2
	 * countCode("cozexxcope") → 2
	 */

	public int countCode(String str) {
		int WORD_LENGTH = 4; // co(.)e - (.) is a wildcard
		return str.length() == 0 ? 0 : (str.length() - str.replaceAll("co(.)e",
				"").length())
				/ WORD_LENGTH;
	}

	/*
	 * Given two strings, return true if either of the strings appears at the
	 * very end of the other string, ignoring upper/lower case differences (in
	 * other words, the computation should not be "case sensitive"). Note:
	 * str.toLowerCase() returns the lowercase version of a string.
	 * 
	 * endOther("Hiabc", "abc") → true endOther("AbC", "HiaBc") → true
	 * endOther("abc", "abXabc") → true
	 */
	public boolean endOther(String a, String b) {
		return (a.toLowerCase().endsWith(b.toLowerCase()) || b.toLowerCase()
				.endsWith(a.toLowerCase()));
	}

	/*
	 * Return true if the given string contains an appearance of "xyz" where the
	 * xyz is not directly preceeded by a period (.). So "xxyz" counts but
	 * "x.xyz" does not.
	 * 
	 * xyzThere("abcxyz") → true xyzThere("abc.xyz") → false xyzThere("xyz.abc")
	 * → true
	 */
	public boolean xyzThere(String str) {
		int xyz = (str.length() - str.replace("xyz", "").length())
				/ "xyz".length();
		int dotxyz = (str.length() - str.replace(".xyz", "").length())
				/ ".xyz".length();
		return xyz > dotxyz;
	}

	/*
	 * Return true if the given string contains a "bob" string, but where the
	 * middle 'o' char can be any char.
	 * 
	 * bobThere("abcbob") → true bobThere("b9b") → true bobThere("bac") → false
	 */
	public boolean bobThere(String str) {
		return ((str.length() - str.replaceAll("b(.)b", "").length()) / "bob"
				.length()) >= 1;
	}

	/*
	 * We'll say that a String is xy-balanced if for all the 'x' chars in the
	 * string, there exists a 'y' char somewhere later in the string. So "xxy"
	 * is balanced, but "xyx" is not. One 'y' can balance multiple 'x's. Return
	 * true if the given string is xy-balanced.
	 * 
	 * xyBalance("aaxbby") → true xyBalance("aaxbb") → false xyBalance("yaaxbb")
	 * → false
	 */
	public boolean xyBalance(String str) {
		return (!str.contains("x") && !str.contains("y"))
				|| str.lastIndexOf('x') < str.lastIndexOf('y');
	}

	/*
	 * Given a string and an int n, return a string made of n repetitions of the
	 * last n characters of the string. You may assume that n is between 0 and
	 * the length of the string, inclusive.
	 * 
	 * repeatEnd("Hello", 3) → "llollollo" repeatEnd("Hello", 2) → "lolo"
	 * repeatEnd("Hello", 1) → "o"
	 */
	public String repeatEnd(String str, int n) {
		String repeatedLastChars = "";
		for (int i = 0; i < n; i++)
			repeatedLastChars += "" + str.substring(str.length() - n);
		return repeatedLastChars;
	}

	/*
	 * Given a string and an int n, return a string made of the first n
	 * characters of the string, followed by the first n-1 characters of the
	 * string, and so on. You may assume that n is between 0 and the length of
	 * the string, inclusive (i.e. n >= 0 and n <= str.length()).
	 * 
	 * repeatFront("Chocolate", 4) → "ChocChoChC" repeatFront("Chocolate", 3) →
	 * "ChoChC" repeatFront("Ice Cream", 2) → "IcI"
	 */
	public String repeatFront(String str, int n) {
		String returnString = "";
		for (int i = n + 1; i > 0; i--)
			returnString += "" + str.substring(0, i - 1);
		return returnString;
	}

	/*
	 * Given a string, consider the prefix string made of the first N chars of
	 * the string. Does that prefix string appear somewhere else in the string?
	 * Assume that the string is not empty and that N is in the range
	 * 1..str.length().
	 * 
	 * prefixAgain("abXYabc", 1) → true prefixAgain("abXYabc", 2) → true
	 * prefixAgain("abXYabc", 3) → false
	 */

	public boolean prefixAgain(String str, int n) {
		return str.replaceAll(str.substring(0, n), "").length() < str
				.replaceFirst(str.substring(0, n), "").length();
	}

	/*
	 * A sandwich is two pieces of bread with something in between. Return the
	 * string that is between the first and last appearance of "bread" in the
	 * given string, or return the empty string "" if there are not two pieces
	 * of bread.
	 * 
	 * getSandwich("breadjambread") → "jam" getSandwich("xxbreadjambreadyy") →
	 * "jam" getSandwich("xxbreadyy") → ""
	 */

	public String getSandwich(String str) {
		return str.indexOf("bread") == str.lastIndexOf("bread") ? "" : str
				.substring(str.indexOf("bread") + 5, str.lastIndexOf("bread"));
	}

	/*
	 * Given a string, compute a new string by moving the first char to come
	 * after the next two chars, so "abc" yields "bca". Repeat this process for
	 * each subsequent group of 3 chars, so "abcdef" yields "bcaefd". Ignore any
	 * group of fewer than 3 chars at the end.
	 * 
	 * oneTwo("abc") → "bca" oneTwo("tca") → "cat" oneTwo("tcagdo") → "catdog"
	 */

	public String oneTwo(String str) {
		String returnString = "";
		for (int i = 0; i < str.length() - 2; i += 3) {
			returnString += "" + str.charAt(i + 1) + "" + str.charAt(i + 2)
					+ "" + str.charAt(i);
		}
		return returnString;
	}

	/*
	 * Return a version of the given string, where for every star (*) in the
	 * string the star and the chars immediately to its left and right are gone.
	 * So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
	 * 
	 * starOut("ab*cd") → "ad" starOut("ab**cd") → "ad" starOut("sm*eilly") →
	 * "silly"
	 */

	public String starOut(String str) {
		String returnString = "";
		for (int i = 0; i < str.length(); i++) {
			if (i == 0 && str.charAt(i) != '*')
				returnString += str.charAt(i);
			if (i > 0 && str.charAt(i) != '*' && str.charAt(i - 1) != '*')
				returnString += str.charAt(i);
			if (i > 0 && str.charAt(i) == '*' && str.charAt(i - 1) != '*')
				returnString = returnString.substring(0,
						returnString.length() - 1);
		}
		return returnString;
	}

	/*
	 * Given a string and a non-empty word string, return a string made of each
	 * char just before and just after every appearance of the word in the
	 * string. Ignore cases where there is no char before or after the word, and
	 * a char may be included twice if it is between two words.
	 * 
	 * wordEnds("abcXY123XYijk", "XY") → "c13i" wordEnds("XY123XY", "XY") → "13"
	 * wordEnds("XY1XY", "XY") → "11"
	 */

	public static String wordEnds(String str, String word) {
		String returnString = "";
		int position = str.indexOf(word);
		while (position != -1) {
			if (position != 0)
				returnString += str.charAt(position - 1);
			if (position + word.length() == str.length())
				break;
			returnString += str.charAt(position + word.length());
			position = str.indexOf(word, position + 1);
		}
		return returnString;
	}

}
