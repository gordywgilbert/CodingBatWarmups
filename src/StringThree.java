public class StringThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given a string, count the number of words ending in 'y' or 'z' -- so the
	 * 'y' in "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow"
	 * (not case sensitive). We'll say that a y or z is at the end of a word if
	 * there is not an alphabetic letter immediately following it. (Note:
	 * Character.isLetter(char) tests if a char is an alphabetic letter.)
	 * 
	 * countYZ("fez day") → 2 countYZ("day fez") → 2 countYZ("day fyyyz") → 2
	 */

	public int countYZ(String str) {
		int count = 0; // initialize count to 0
		for (int i = 0; i < str.length(); i++) { // iterate through the string
			if (str.toLowerCase().charAt(i) == 'y'
					|| str.toLowerCase().charAt(i) == 'z') { // see if the
				if (i < str.length() - 1
						&& !Character.isLetter(str.charAt(i + 1))) {
					count++; // the next character isnt a letter
				} else if (i == str.length() - 1) {
					count++; // the next character is the end of the string
				}
			}
		}
		return count;
	}

	/*
	 * Given two strings, base and remove, return a version of the base string
	 * where all instances of the remove string have been removed (not case
	 * sensitive). You may assume that the remove string is length 1 or more.
	 * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves
	 * "x".
	 * 
	 * withoutString("Hello there", "llo") → "He there"
	 * withoutString("Hello there", "e") → "Hllo thr"
	 * withoutString("Hello there", "x") → "Hello there"
	 */

	public String withoutString(String base, String remove) {
		return base.replaceAll("(?i)" + remove, "");
	}

	/*
	 * Given a string, return true if the number of appearances of "is" anywhere
	 * in the string is equal to the number of appearances of "not" anywhere in
	 * the string (case sensitive).
	 * 
	 * equalIsNot("This is not") → false equalIsNot("This is notnot") → true
	 * equalIsNot("noisxxnotyynotxisi") → true
	 */

	public boolean equalIsNot(String str) {
		// return StringUtils.countMatches(str,"is") ==
		// StringUtils.countMatches(str,"not");
		int countIs = 0, countNot = 0;
		String isRemoved = str.replaceAll("is", "-");
		String notRemoved = str.replaceAll("not", "-");
		for (int i = 0; i < isRemoved.length(); i++) {
			if (isRemoved.charAt(i) == '-')
				countIs++;
		}
		for (int i = 0; i < notRemoved.length(); i++) {
			if (notRemoved.charAt(i) == '-')
				countNot++;
		}
		return countIs == countNot;
	}

	/*
	 * We'll say that a lowercase 'g' in a string is "happy" if there is another
	 * 'g' immediately to its left or right. Return true if all the g's in the
	 * given string are happy.
	 * 
	 * gHappy("xxggxx") → true gHappy("xxgxx") → false gHappy("xxggyygxx") →
	 * false
	 */

	public boolean gHappy(String str) {
		if (str.length() == 1)
			return false;
		if (str.length() == 0)
			return true;
		for (int i = 1; i < str.length() - 1; i++) {
			if (str.charAt(i) == 'g') {
				if (i >= 1
						&& (str.charAt(i - 1) != 'g' && str.charAt(i + 1) != 'g'))
					return false;
			}
		}
		if (str.charAt(str.length() - 1) == 'g'
				&& str.charAt(str.length() - 2) != 'g')
			return false;
		return true;
	}

	/*
	 * We'll say that a "triple" in a string is a char appearing three times in
	 * a row. Return the number of triples in the given string. The triples may
	 * overlap.
	 * 
	 * countTriple("abcXXXabc") → 1 countTriple("xxxabyyyycd") → 3
	 * countTriple("a") → 0
	 */

	public int countTriple(String str) {
		int tripleCount = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.length() > i + 2) {
				if (str.charAt(i) == str.charAt(i + 1)
						&& str.charAt(i) == str.charAt(i + 2))
					tripleCount++;
			}
		}
		return tripleCount;
	}

	/*
	 * Given a string, return the sum of the digits 0-9 that appear in the
	 * string, ignoring all other characters. Return 0 if there are no digits in
	 * the string. (Note: Character.isDigit(char) tests if a char is one of the
	 * chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an
	 * int.)
	 * 
	 * sumDigits("aa1bc2d3") → 6 sumDigits("aa11b33") → 8 sumDigits("Chocolate")
	 * → 0
	 */

	public int sumDigits(String str) {
		int total = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i)))
				total += Integer.parseInt(str.charAt(i) + "");
		}
		return total;
	}

	/*
	 * Given a string, return the longest substring that appears at both the
	 * beginning and end of the string without overlapping. For example,
	 * sameEnds("abXab") is "ab".
	 * 
	 * sameEnds("abXYab") → "ab" sameEnds("xx") → "x" sameEnds("xxx") → "x"
	 */

	public String sameEnds(String string) {
		int e = string.length() - 1; /* end of string */
		int b = string.length() / 2; /* where to start looking for a match */

		while (--b >= 0) { /* ran off the front yet? */

			/*
			 * Starting just below the center of the string, look for a
			 * character which matches the final character
			 */
			for (; b >= 0; --b) {
				if (string.charAt(e) == string.charAt(b))
					break;
			}

			/*
			 * found a match to the final character (a possible starting point)
			 * compare characters backwards until no match or all matched (temp
			 * vars ee and bb walk backwards from e and b respectively)
			 * 
			 * "|f|r|o|b|o|z|z|Q|Q|Q|f|r|o|b|o|z|z|" ^ ^ | | <--bb b <--ee e
			 */
			for (int ee = e, bb = b; bb >= 0; --bb, --ee) {
				if (string.charAt(bb) != string.charAt(ee))
					break; /* no match */
				if (bb == 0)
					return string.substring(0, b + 1); /* victory! */
			}
		}
		return new String(""); /* nothing matched */
	}

	/*
	 * Given a string, look for a mirror image (backwards) string at both the
	 * beginning and end of the given string. In other words, zero or more
	 * characters at the very begining of the given string, and at the very end
	 * of the string in reverse order (possibly overlapping). For example, the
	 * string "abXYZba" has the mirror end "ab".
	 * 
	 * mirrorEnds("abXYZba") → "ab" mirrorEnds("abca") → "a" mirrorEnds("aba") →
	 * "aba"
	 */
	public String mirrorEnds(String string) {
		String returnString = "";
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == string.charAt(string.length() - 1 - i)) {
				returnString += string.substring(i, i + 1);
			} else {
				break;
			}
		}
		return returnString;
	}

	/*
	 * Given a string, return the length of the largest "block" in the string. A
	 * block is a run of adjacent chars that are the same.
	 * 
	 * maxBlock("hoopla") → 2 maxBlock("abbCCCddBBBxx") → 3 maxBlock("") → 0
	 */

	public int maxBlock(String str) {
	    if(str.length() == 0)
	        return 0;
	          
	    int largest = 0;
	    int current = 1;
	                
	    for(int i = 1; i < str.length(); i++) {
	        if(str.charAt(i) != str.charAt(i-1)) {
	            if(current > largest)
	                largest = current;
	            current = 1;
	        } else {
	            current++;
	        }
	    }
	                                                            
	    return Math.max(largest, current);
	}

}
