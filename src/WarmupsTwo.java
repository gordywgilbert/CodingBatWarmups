public class WarmupsTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * stringMatch("abc", "abc"); stringX("xxHxix"); stringX("abxxxcd");
		 * stringX("xabxxxcdx");
		 * 
		 * System.out.println("altPairs(kitten)" + altPairs("kitten"));
		 * System.out.println("altPairs(Chocolate)" + altPairs("Chocolate"));
		 * System.out.println("altPairs(CodingHorror)" +
		 * altPairs("CodingHorror")); altPairs("kitten"); altPairs("Chocolate");
		 * altPairs("CodingHorror");
		 */
		hasBad("xbad");
	}

	/*
	 * Given a string and a non-negative int n, return a larger string that is n
	 * copies of the original string.
	 * 
	 * stringTimes("Hi", 2) → "HiHi" stringTimes("Hi", 3) → "HiHiHi"
	 * stringTimes("Hi", 1) → "Hi"
	 */
	public String stringTimes(String str, int n) {
		String tempString = "";
		for (int i = 0; i < n; i++) {
			tempString += str;
		}
		return tempString;
	}

	/*
	 * Given a string and a non-negative int n, we'll say that the front of the
	 * string is the first 3 chars, or whatever is there if the string is less
	 * than length 3. Return n copies of the front;
	 * 
	 * frontTimes("Chocolate", 2) → "ChoCho" frontTimes("Chocolate", 3) →
	 * "ChoChoCho" frontTimes("Abc", 3) → "AbcAbcAbc"
	 */
	public String frontTimes(String str, int n) {
		String outPut = "";
		if (str.length() <= 3) {
			for (int i = 0; i < n; i++) {
				outPut += str;
			}
		} else {
			for (int i = 0; i < n; i++) {
				outPut += str.substring(0, 3);
			}
		}
		return outPut;
	}

	/*
	 * Count the number of "xx" in the given string. We'll say that overlapping
	 * is allowed, so "xxx" contains 2 "xx".
	 * 
	 * countXX("abcxx") → 1 countXX("xxx") → 2 countXX("xxxx") → 3
	 */
	int countXX(String str) {
		String prevChar = "";
		String lastChar = "";
		int doubleXs = 0;
		for (int i = 0; i < str.length(); i++) {
			prevChar = lastChar;
			lastChar = str.charAt(i) + "";
			if (prevChar.equals("x") && lastChar.equals("x"))
				doubleXs++;
		}
		return doubleXs;
	}

	/*
	 * Given a string, return true if the first instance of "x" in the string is
	 * immediately followed by another "x".
	 * 
	 * doubleX("axxbb") → true doubleX("axaxax") → false doubleX("xxxxx") → true
	 */
	boolean doubleX(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'x' && str.length() > i + 1) {
				return str.charAt(i + 1) == 'x';
			}
		}
		return false;
	}

	/*
	 * Given a string, return a new string made of every other char starting
	 * with the first, so "Hello" yields "Hlo".
	 * 
	 * stringBits("Hello") → "Hlo" stringBits("Hi") → "H"
	 * stringBits("Heeololeo") → "Hello"
	 */
	public String stringBits(String str) {
		String newString = "";
		for (int i = 0; i < str.length(); i++) {
			if (i == 0) {
				newString += str.charAt(i);
				continue;
			}
			if (i % 2 == 0)
				newString += str.charAt(i);
		}
		return newString;
	}

	/*
	 * Given a non-empty string like "Code" return a string like "CCoCodCode".
	 * 
	 * stringSplosion("Code") → "CCoCodCode" stringSplosion("abc") → "aababc"
	 * stringSplosion("ab") → "aab"
	 */
	public String stringSplosion(String str) {
		String returnString = "";
		for (int i = 0; i < str.length(); i++) {
			returnString += str.substring(0, i);
		}
		return returnString + str;
	}

	/*
	 * Given a string, return the count of the number of times that a substring
	 * length 2 appears in the string and also as the last 2 chars of the
	 * string, so "hixxxhi" yields 1 (we won't count the end substring).
	 * 
	 * last2("hixxhi") → 1 last2("xaxxaxaxx") → 1 last2("axxxaaxx") → 2
	 */
	public int last2(String str) {
		String lastTwoCharacters = "";
		int occurences = 0;
		if (str.length() >= 2) {
			lastTwoCharacters = str.substring(str.length() - 2);
		} else {
			return 0;
		}
		// iterate through loop looking for lastTwoCharacters string
		String nextTwoCharacters = "";
		for (int i = 0; i < str.length() - 2; i++) {

			nextTwoCharacters = str.substring(i, i + 2);
			if (lastTwoCharacters.equals(nextTwoCharacters))
				occurences++;
		}
		return occurences;
	}

	/*
	 * Given an array of ints, return the number of 9's in the array.
	 * 
	 * arrayCount9({1, 2, 9}) → 1 arrayCount9({1, 9, 9}) → 2 arrayCount9({1, 9,
	 * 9, 3, 9}) → 3
	 */

	public int arrayCount9(int[] nums) {
		int numNines = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 9)
				numNines++;
		}
		return numNines;
	}

	/*
	 * Given an array of ints, return true if one of the first 4 elements in the
	 * array is a 9. The array length may be less than 4.
	 * 
	 * arrayFront9({1, 2, 9, 3, 4}) → true arrayFront9({1, 2, 3, 4, 9}) → false
	 * arrayFront9({1, 2, 3, 4, 5}) → false
	 */

	public boolean arrayFront9(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (i <= 3 && nums[i] == 9)
				return true;
		}
		return false;
	}

	/*
	 * Given an array of ints, return true if .. 1, 2, 3, .. appears in the
	 * array somewhere.
	 * 
	 * array123({1, 1, 2, 3, 1}) → true array123({1, 1, 2, 4, 1}) → false
	 * array123({1, 1, 2, 1, 2, 3}) → true
	 */

	public boolean array123(int[] nums) {
		for (int i = 0; i + 2 < nums.length; i++)
			if (nums[i] == 1 && nums[i + 1] == 2 && nums[i + 2] == 3)
				return true;
		return false;
	}

	/*
	 * Given 2 strings, a and b, return the number of the positions where they
	 * contain the same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3,
	 * since the "xx", "aa", and "az" substrings appear in the same place in
	 * both strings.
	 * 
	 * stringMatch("xxcaazz", "xxbaaz") → 3 stringMatch("abc", "abc") → 2
	 * stringMatch("abc", "axc") → 0
	 */

	public static int stringMatch(String a, String b) {
		int occurences = 0;
		for (int i = 0; (i < a.length() - 1 && i < b.length() - 1); i++) {
			if (b.substring(i, i + 2).equals(a.substring(i, i + 2)))
				occurences++;
		}
		return occurences;
	}

	/*
	 * Given a string, return a version where all the "x" have been removed.
	 * Except an "x" at the very start or end should not be removed.
	 * 
	 * stringX("xxHxix") → "xHix" stringX("abxxxcd") → "abcd"
	 * stringX("xabxxxcdx") → "xabcdx"
	 */

	public static String stringX(String str) {
		String newString = "";
		for (int i = 0; i < str.length(); i++) {
			if ((i == 0 || i == str.length() - 1))
				continue;
			if (str.charAt(i) != 'x')
				newString += str.charAt(i - 1) + "";
		}
		return newString;
	}

	/*
	 * Given a string, return a string made of the chars at indexes 0,1, 4,5,
	 * 8,9 ... so "kittens" yields "kien".
	 * 
	 * altPairs("kitten") → "kien" altPairs("Chocolate") → "Chole"
	 * altPairs("CodingHorror") → "Congrr"
	 */

	public static String altPairs(String str) {
		int end = 0;
		String result = "";
		for (int i = 0; i < str.length(); i += 4) {
			if (end > str.length()) {
				end = str.length();
			}
			result = result + result.substring(i, end);
		}
		return result;

	}

	/*
	 * Suppose the string "yak" is unlucky. Given a string, return a version
	 * where all the "yak" are removed, but the "a" can be any char. The "yak"
	 * strings will not overlap.
	 * 
	 * stringYak("yakpak") → "pak" stringYak("pakyak") → "pak"
	 * stringYak("yak123ya") → "123ya"
	 */

	public String stringYak(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if (i + 2 < str.length() && str.charAt(i) == 'y'
					&& str.charAt(i + 2) == 'k') {
				i = i + 2;
			} else {
				result = result + str.charAt(i);
			}
		}
		return result;
	}

	/*
	 * Given a string, if one or both of the first 2 chars is 'x', return the
	 * string without those 'x' chars, and otherwise return the string
	 * unchanged. This is a little harder than it looks.
	 * 
	 * withoutX2("xHi") → "Hi" withoutX2("Hxi") → "Hi" withoutX2("Hi") → "Hi"
	 */

	public String withoutX2(String str) {
		return str.replaceFirst("^xx? | ^(.)x", "$1");
	}

	/*
	 * When squirrels get together for a party, they like to have cigars. A
	 * squirrel party is successful when the number of cigars is between 40 and
	 * 60, inclusive. Unless it is the weekend, in which case there is no upper
	 * bound on the number of cigars. Return true if the party with the given
	 * values is successful, or false otherwise.
	 * 
	 * cigarParty(30, false) → false cigarParty(50, false) → true cigarParty(70,
	 * true) → true
	 */

	public boolean cigarParty(int cigars, boolean isWeekend) {
		if ((40 < cigars) && (cigars < 60) || isWeekend)
			return true;
		return false;
	}

	/*
	 * You are driving a little too fast, and a police officer stops you. Write
	 * code to compute the result, encoded as an int value: 0=no ticket, 1=small
	 * ticket, 2=big ticket. If speed is 60 or less, the result is 0. If speed
	 * is between 61 and 80 inclusive, the result is 1. If speed is 81 or more,
	 * the result is 2. Unless it is your birthday -- on that day, your speed
	 * can be 5 higher in all cases.
	 * 
	 * caughtSpeeding(60, false) → 0 caughtSpeeding(65, false) → 1
	 * caughtSpeeding(65, true) → 0
	 */

	public int caughtSpeeding(int speed, boolean isBirthday) {
		int bottomRange;
		int topRange;
		if (isBirthday) {
			bottomRange = 65;
			topRange = 85;
		} else {
			bottomRange = 60;
			topRange = 80;
		}

		if (speed <= bottomRange) {
			return 0;
		} else if (speed > bottomRange && speed <= topRange) {
			return 1;
		} else if (speed > topRange) {
			return 2;
		}
		return 0;
	}

	/*
	 * Given three ints, a b c, return true if b is greater than a, and c is
	 * greater than b. However, with the exception that if "bOk" is true, b does
	 * not need to be greater than a.
	 * 
	 * inOrder(1, 2, 4, false) → true inOrder(1, 2, 1, false) → false inOrder(1,
	 * 1, 2, true) → true
	 */

	public boolean inOrder(int a, int b, int c, boolean bOk) {
		if (bOk) {
			return (c > b);
		} else {
			return (b > a && c > b);
		}
	}

	/*
	 * Given three ints, a b c, return true if they are in strict increasing
	 * order, such as 2 5 11, or 5 6 7, but not 6 5 7 or 5 5 7. However, with
	 * the exception that if "equalOk" is true, equality is allowed, such as 5 5
	 * 7 or 5 5 5.
	 * 
	 * inOrderEqual(2, 5, 11, false) → true inOrderEqual(5, 7, 6, false) → false
	 * inOrderEqual(5, 5, 7, true) → true
	 */

	public boolean inOrderEqual(int a, int b, int c, boolean equalOk) {
		if (equalOk) {
			return (a <= b && b <= c);
		} else {
			return (a < b && b < c);
		}
	}

	/*
	 * The number 6 is a truly great number. Given two int values, a and b,
	 * return true if either one is 6. Or if their sum or difference is 6. Note:
	 * the function Math.abs(num) computes the absolute value of a number.
	 * 
	 * love6(6, 4) → true love6(4, 5) → false love6(1, 5) → true
	 */

	public boolean love6(int a, int b) {
		if (a == 6 || b == 6) {
			return true; // true if either one is six
		} else if (a + b == 6) {
			return true;
		} else if (Math.abs(a - b) == 6) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Given two int values, return whichever value is larger. However if the
	 * two values have the same remainder when divided by 5, then the return the
	 * smaller value. However, in all cases, if the two values are the same,
	 * return 0. Note: the % "mod" operator computes the remainder, e.g. 7 % 5
	 * is 2.
	 * 
	 * maxMod5(2, 3) → 3 maxMod5(6, 2) → 6 maxMod5(3, 2) → 3
	 */

	public int maxMod5(int a, int b) {
		if (a == b) {
			return 0;
		} else if (a % 5 == b % 5) {
			if (a < b) {
				return a;
			} else {
				return b;
			}
		} else {
			if (a > b) {
				return a;
			} else {
				return b;
			}
		}
	}

	/*
	 * Given three ints, a b c, return true if it is possible to add two of the
	 * ints to get the third.
	 * 
	 * twoAsOne(1, 2, 3) → true twoAsOne(3, 1, 2) → true twoAsOne(3, 2, 2) →
	 * false
	 */

	public boolean twoAsOne(int a, int b, int c) {
		if (a + b == c || a + c == b || b + c == a) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Given a number n, return true if n is in the range 1..10, inclusive.
	 * Unless "outsideMode" is true, in which case return true if the number is
	 * less or equal to 1, or greater or equal to 10.
	 * 
	 * in1To10(5, false) → true in1To10(11, false) → false in1To10(11, true) →
	 * true
	 */

	public boolean in1To10(int n, boolean outsideMode) {
		if (outsideMode) {
			if (n <= 1 || n >= 10) {
				return true;
			} else {
				return false;
			}
		} else {
			if (n >= 1 && n <= 10) {
				return true;
			} else {
				return false;
			}
		}
	}

	/*
	 * You have a red lottery ticket showing ints a, b, and c, each of which is
	 * 0, 1, or 2. If they are all the value 2, the result is 10. Otherwise if
	 * they are all the same, the result is 5. Otherwise so long as both b and c
	 * are different from a, the result is 1. Otherwise the result is 0.
	 * 
	 * redTicket(2, 2, 2) → 10 redTicket(2, 2, 1) → 0 redTicket(0, 0, 0) → 5
	 */

	public int redTicket(int a, int b, int c) {
		if (a == 2 && b == 2 && c == 2) {
			return 10;
		} else if (a == b && b == c) {
			return 5;
		} else if (a != b && a != c) {
			return 1;
		} else {
			return 0;
		}
	}

	/*
	 * Given three ints, a b c, return true if two or more of them have the same
	 * rightmost digit. The ints are non-negative. Note: the % "mod" operator
	 * computes the remainder, e.g. 17 % 10 is 7.
	 * 
	 * lastDigit(23, 19, 13) → true lastDigit(23, 19, 12) → false lastDigit(23,
	 * 19, 3) → true
	 */

	public boolean lastDigit(int a, int b, int c) {
		if (a % 10 == b % 10 || a % 10 == c % 10 || b % 10 == c % 10) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * We are having a party with amounts of tea and candy. Return the int
	 * outcome of the party encoded as 0=bad, 1=good, or 2=great. A party is
	 * good (1) if both tea and candy are at least 5. (2) However, if either tea
	 * or candy is at least double the amount of the other one, the party is
	 * great (0) However, in all cases, if either tea or candy is less than 5,
	 * the party is always bad (0).
	 * 
	 * teaParty(6, 8) → 1 teaParty(3, 8) → 0 teaParty(20, 6) → 2
	 */

	public int teaParty(int tea, int candy) {
		if (tea < 5 || candy < 5)
			return 0;
		if (tea * 2 <= candy || candy * 2 <= tea) {
			return 2;
		} else if (tea >= 5 && candy >= 5) {
			return 1;
		} else {
			return 0;
		}
	}

	/*
	 * Given 2 ints, a and b, return their sum. However, "teen" values in the
	 * range 13..19 inclusive, are extra lucky. So if either value is a teen,
	 * just return 19.
	 * 
	 * teenSum(3, 4) → 7 teenSum(10, 13) → 19 teenSum(13, 2) → 19
	 */

	public int teenSum(int a, int b) {
		if ((a >= 13 && a <= 19) || (b >= 13 && b <= 19)) {
			return 19;
		} else {
			return a + b;
		}
	}

	/*
	 * The squirrels in Palo Alto spend most of the day playing. In particular,
	 * they play if the temperature is between 60 and 90 (inclusive). Unless it
	 * is summer, then the upper limit is 100 instead of 90. Given an int
	 * temperature and a boolean isSummer, return true if the squirrels play and
	 * false otherwise.
	 * 
	 * squirrelPlay(70, false) → true squirrelPlay(95, false) → false
	 * squirrelPlay(95, true) → true
	 */

	public boolean squirrelPlay(int temp, boolean isSummer) {
		int upperBound = 90;
		if (isSummer)
			upperBound = 100;
		return (temp <= upperBound && temp >= 60);
	}

	/*
	 * Given 2 non-negative ints, a and b, return their sum, so long as the sum
	 * has the same number of digits as a. If the sum has more digits than a,
	 * just return a without b. (Note: one way to compute the number of digits
	 * of a non-negative int n is to convert it to a string with
	 * String.valueOf(n) and then check the length of the string.)
	 * 
	 * sumLimit(2, 3) → 5 sumLimit(8, 3) → 8 sumLimit(8, 1) → 9
	 */

	public int sumLimit(int a, int b) {
		int aLength = String.valueOf(a).length();
		int sumLength = String.valueOf(a + b).length();
		if (aLength == sumLength) {
			return a + b;
		} else {
			return a;
		}
	}

	/*
	 * Return true if the given non-negative number is 1 or 2 more than a
	 * multiple of 20. See also: Introduction to Mod
	 * 
	 * more20(20) → false more20(21) → true more20(22) → true
	 */

	public boolean more20(int n) {
		return (n % 20 <= 2 && n % 20 != 0);
	}

	/*
	 * We'll say a number is special if it is a multiple of 11 or if it is one
	 * more than a multiple of 11. Return true if the given non-negative number
	 * is special. Use the % "mod" operator -- see Introduction to Mod
	 * 
	 * specialEleven(22) → true specialEleven(23) → true specialEleven(24) →
	 * false
	 */

	public boolean specialEleven(int n) {
		return (n % 11 == 0 || n % 11 == 1);
	}

	/*
	 * Given a string str, if the string starts with "f" return "Fizz". If the
	 * string ends with "b" return "Buzz". If both the "f" and "b" conditions
	 * are true, return "FizzBuzz". In all other cases, return the string
	 * unchanged. (See also: FizzBuzz Code)
	 * 
	 * fizzString("fig") → "Fizz" fizzString("dib") → "Buzz" fizzString("fib") →
	 * "FizzBuzz"
	 */

	public String fizzString(String str) {
		boolean fizz = false, buzz = false;
		if (str.charAt(0) == 'f')
			fizz = true;
		if (str.charAt(str.length() - 1) == 'b')
			buzz = true;
		if (fizz && buzz) {
			return "FizzBuzz";
		} else {
			if (fizz && !buzz) {
				return "Fizz";
			}
			if (buzz && !fizz) {
				return "Buzz";
			}
			return str;
		}
	}

	/*
	 * Return true if the given non-negative number is 1 or 2 less than a
	 * multiple of 20. So for example 38 and 39 return true, but 40 returns
	 * false. See also: Introduction to Mod
	 * 
	 * less20(18) → true less20(19) → true less20(20) → false
	 */

	public boolean less20(int n) {
		return (n % 20 == 18 || n % 20 == 19);
	}

	/*
	 * Given 2 ints, a and b, return their sum. However, sums in the range
	 * 10..19 inclusive, are forbidden, so in that case just return 20.
	 * 
	 * sortaSum(3, 4) → 7 sortaSum(9, 4) → 20 sortaSum(10, 11) → 21
	 */

	public int sortaSum(int a, int b) {
		if (a + b >= 10 && a + b <= 19)
			return 20;
		return a + b;
	}

	/*
	 * You have a green lottery ticket, with ints a, b, and c on it. If the
	 * numbers are all different from each other, the result is 0. If all of the
	 * numbers are the same, the result is 20. If two of the numbers are the
	 * same, the result is 10.
	 * 
	 * greenTicket(1, 2, 3) → 0 greenTicket(2, 2, 2) → 20 greenTicket(1, 1, 2) →
	 * 10
	 */

	public int greenTicket(int a, int b, int c) {
		if ((a == b) && (b == c)) {
			return 20;
		} else if (((a == b) && (b != c)) || ((b == c) && (a != c))
				|| ((a == c) && (b != c))) {
			return 10;
		} else {
			return 0;
		}
	}

	/*
	 * Given a string and an int n, return a string made of the first and last n
	 * chars from the string. The string length will be at least n.
	 * 
	 * nTwice("Hello", 2) → "Helo" nTwice("Chocolate", 3) → "Choate"
	 * nTwice("Chocolate", 1) → "Ce"
	 */

	public String nTwice(String str, int n) {
		return str.substring(0, n)
				+ str.substring(str.length() - n, str.length());
	}

	/*
	 * Given a string, return true if "bad" appears starting at index 0 or 1 in
	 * the string, such as with "badxxx" or "xbadxx" but not "xxbadxx". The
	 * string may be any length, including 0. Note: use .equals() to compare 2
	 * strings.
	 * 
	 * hasBad("badxx") → true hasBad("xbadxx") → true hasBad("xxbadxx") → false
	 */

	public static boolean hasBad(String str) {
		if (str.length() == 3) {
			if (str.equals("bad"))
				return true; // first or second character begins the word "bad"
		} else if (str.length() > 3) {
			if (str.substring(0, 3).equals("bad")
					|| str.substring(1, 4).equals("bad"))
				return true; // first or second character begins the word "bad"
		}
		return false;
	}

	/*
	 * Given a string, return a "rotated right 2" version where the last 2 chars
	 * are moved to the start. The string length will be at least 2.
	 * 
	 * right2("Hello") → "loHel" right2("java") → "vaja" right2("Hi") → "Hi"
	 */

	public String right2(String str) {
		if (str.length() > 2)
			return str.substring(str.length() - 2, str.length())
					+ str.substring(0, str.length() - 2);
		else
			return str;
	}

	/*
	 * Given a string, return the string made of its first two chars, so the
	 * String "Hello" yields "He". If the string is shorter than length 2,
	 * return whatever there is, so "X" yields "X", and the empty string ""
	 * yields the empty string "". Note that str.length() returns the length of
	 * a string.
	 * 
	 * firstTwo("Hello") → "He" firstTwo("abcdefg") → "ab" firstTwo("ab") → "ab"
	 */

	public String firstTwo(String str) {
		if (str.length() >= 2) {
			return str.substring(0, 2);
		} else {
			return str;
		}
	}

	/*
	 * Given a string of even length, return a string made of the middle two
	 * chars, so the string "string" yields "ri". The string length will be at
	 * least 2.
	 * 
	 * middleTwo("string") → "ri" middleTwo("code") → "od" middleTwo("Practice")
	 * → "ct"
	 */

	public String middleTwo(String str) {
		return str.substring((str.length() / 2) - 1, (str.length() / 2) + 1);
	}

	/*
	 * Given a string, if the string begins with "red" or "blue" return that
	 * color string, otherwise return the empty string.
	 * 
	 * seeColor("redxx") → "red" seeColor("xxred") → "" seeColor("blueTimes") →
	 * "blue"
	 */
	public String seeColor(String str) {
		if (str.startsWith("red")) {
			return "red";
		} else if (str.startsWith("blue")) {
			return "blue";
		} else {
			return "";
		}
	}

	/*
	 * Given a string, return a "rotated left 2" version where the first 2 chars
	 * are moved to the end. The string length will be at least 2.
	 * 
	 * left2("Hello") → "lloHe" left2("java") → "vaja" left2("Hi") → "Hi"
	 */

	public String left2(String str) {
		return str.substring(2, str.length()) + str.charAt(0) + str.charAt(1);
	}

	/*
	 * Given an "out" string length 4, such as "<<>>", and a word, return a new
	 * string where the word is in the middle of the out string, e.g.
	 * "<<word>>". Note: use str.substring(i, j) to extract the String starting
	 * at index i and going up to but not including index j.
	 * 
	 * makeOutWord("<<>>", "Yay") → "<<Yay>>" makeOutWord("<<>>", "WooHoo") →
	 * "<<WooHoo>>" makeOutWord("[[]]", "word") → "[[word]]"
	 */

	public String makeOutWord(String out, String word) {
		return out.substring(0, out.length() / 2) + word
				+ out.substring(out.length() / 2, out.length());
	}

	/*
	 * Given a string and a second "word" string, we'll say that the word
	 * matches the string if it appears at the front of the string, except its
	 * first char does not need to match exactly. On a match, return the front
	 * of the string, or otherwise return the empty string. So, so with the
	 * string "hippo" the word "hi" returns "hi" and "xip" returns "hip". The
	 * word will be at least length 1.
	 * 
	 * startWord("hippo", "hi") → "hi" startWord("hippo", "xip") → "hip"
	 * startWord("hippo", "i") → "h"
	 */

	public String startWord(String str, String word) {
		String noFirstChar = str.substring(1);
		if (str.startsWith(noFirstChar)) {
			return str.substring(0, word.length());
		} else {
			return "";
		}
	}

	/*
	 * Given a string of odd length, return the string length 3 from its middle,
	 * so "Candy" yields "and". The string length will be at least 3.
	 * 
	 * middleThree("Candy") → "and" middleThree("and") → "and"
	 * middleThree("solving") → "lvi"
	 */
	public String middleThree(String str) {
		int beginIndex, endIndex;
		beginIndex = ((str.length() - 1) / 2) - 1;
		endIndex = ((str.length() + 1) / 2) + 1;
		return str.substring(beginIndex, endIndex);
	}

	/*
	 * Given a string, return a new string made of 3 copies of the first 2 chars
	 * of the original string. The string may be any length. If there are fewer
	 * than 2 chars, use whatever is there.
	 * 
	 * extraFront("Hello") → "HeHeHe" extraFront("ab") → "ababab"
	 * extraFront("H") → "HHH"
	 */
	public String extraFront(String str) {
		if (str.length() >= 2) {
			return str.substring(0, 2) + str.substring(0, 2)
					+ str.substring(0, 2);
		} else if (str.length() <= 2) {
			return str + str + str;
		} else {
			return str;
		}
	}

	/*
	 * Given a string of any length, return a new string where the last 2 chars,
	 * if present, are swapped, so "coding" yields "codign".
	 * 
	 * lastTwo("coding") → "codign" lastTwo("cat") → "cta" lastTwo("ab") → "ba"
	 */
	public String lastTwo(String str) {
		if (str.length() > 2) {
			return str.substring(0, str.length() - 2)
					+ str.charAt(str.length() - 1)
					+ str.charAt(str.length() - 2);
		} else if (str.length() == 2) {
			return "" + str.charAt(str.length() - 1)
					+ str.charAt(str.length() - 2);
		} else {
			return str;
		}

	}

	/*
	 * Given a string, return a string length 1 from its front, unless front is
	 * false, in which case return a string length 1 from its back. The string
	 * will be non-empty.
	 * 
	 * theEnd("Hello", true) → "H" theEnd("Hello", false) → "o" theEnd("oh",
	 * true) → "o"
	 */
	public String theEnd(String str, boolean front) {
		if (!front)
			return "" + str.charAt(str.length() - 1);
		return str.charAt(0) + "";
	}

	/*
	 * Given a string, if a length 2 substring appears at both its beginning and
	 * end, return a string without the substring at the beginning, so "HelloHe"
	 * yields "lloHe". The substring may overlap with itself, so "Hi" yields "".
	 * Otherwise, return the original string unchanged.
	 * 
	 * without2("HelloHe") → "lloHe" without2("HelloHi") → "HelloHi"
	 * without2("Hi") → ""
	 */

	public String without2(String str) {
		int len = str.length();
		if (len == 2)
			return "";
		if (len < 2)
			return str;
		else {
			if (str.substring(0, 2).equals(str.substring(len - 2, len)))
				return str.substring(2, len);
			else
				return str;
		}
	}

	/*
	 * The web is built with HTML strings like "<i>Yay</i>" which draws Yay as
	 * italic text. In this example, the "i" tag makes <i> and </i> which
	 * surround the word "Yay". Given tag and word strings, create the HTML
	 * string with tags around the word, e.g. "<i>Yay</i>".
	 * 
	 * makeTags("i", "Yay") → "<i>Yay</i>" makeTags("i", "Hello") →
	 * "<i>Hello</i>" makeTags("cite", "Yay") → "<cite>Yay</cite>"
	 */
	public String makeTags(String tag, String word) {
		return "<" + tag + ">" + word + "</" + tag + ">";
	}

	/*
	 * Given 2 strings, a and b, return a new string made of the first char of a
	 * and the last char of b, so "yo" and "java" yields "ya". If either string
	 * is length 0, use '@' for its missing char.
	 * 
	 * lastChars("last", "chars") → "ls" lastChars("yo", "java") → "ya"
	 * lastChars("hi", "") → "h@"
	 */
	public String lastChars(String a, String b) {
		String firstChar, lastChar;
		if (a.length() == 0) {
			firstChar = "@";
		} else {
			firstChar = "" + a.charAt(0);
		}
		if (b.length() == 0) {
			lastChar = "@";
		} else {
			lastChar = "" + b.charAt(b.length() - 1);
		}
		return firstChar + lastChar;
	}

	/*
	 * Given a string, return true if it ends in "ly".
	 * 
	 * endsLy("oddly") → true endsLy("y") → false endsLy("oddy") → false
	 */

	public boolean endsLy(String str) {
		if (str.endsWith("ly"))
			return true;
		return false;
	}

	/*
	 * Given a string, return a version without the first 2 chars. Except keep
	 * the first char if it is 'a' and keep the second char if it is 'b'. The
	 * string may be any length. Harder than it looks.
	 * 
	 * deFront("Hello") → "llo" deFront("java") → "va" deFront("away") → "aay"
	 */

	public String deFront(String str) {
		if (str.length() >= 2) {
			if (str.charAt(0) == 'a' && str.charAt(1) == 'b') {
				return str;
			} else if (str.charAt(0) != 'a' && str.charAt(1) == 'b') {
				return str.substring(1);
			} else if (str.charAt(0) == 'a' && str.charAt(1) != 'b') {
				return str.charAt(0) + str.substring(2);
			} else {
				return str.substring(2);
			}
		} else {
			return str;
		}
	}

	/*
	 * Given a string and an index, return a string length 2 starting at the
	 * given index. If the index is too big or too small to define a string
	 * length 2, use the first 2 chars. The string length will be at least 2.
	 * 
	 * twoChar("java", 0) → "ja" twoChar("java", 2) → "va" twoChar("java", 3) →
	 * "ja"
	 */
	public String twoChar(String str, int index) {
		if (index < 0)
			return "" + str.charAt(0) + str.charAt(1);
		if (str.length() <= 2) {
			return str;
		} else if (index + 2 < str.length() + 1) {
			return str.substring(index, index + 2);
		} else
			return "" + str.charAt(0) + str.charAt(1);

	}

	/*
	 * Given two strings, append them together (known as "concatenation") and
	 * return the result. However, if the strings are different lengths, omit
	 * chars from the longer string so it is the same length as the shorter
	 * string. So "Hello" and "Hi" yield "loHi". The strings may be any length.
	 * 
	 * minCat("Hello", "Hi") → "loHi" minCat("Hello", "java") → "ellojava"
	 * minCat("java", "Hello") → "javaello"
	 */
	public String minCat(String a, String b) {
		if (a.length() < b.length()) { // string a is longer than b
			String newB = b.substring(b.length() - a.length(), b.length());
			return a + newB;
		} else if (b.length() < a.length()) { // string a is longer than b
			String newA = a.substring(a.length() - b.length(), a.length());
			return newA + b;
		}
		return a + b;
	}

	/*
	 * Given 2 strings, a and b, return a string of the form short+long+short,
	 * with the shorter string on the outside and the longer string on the
	 * inside. The strings will not be the same length, but they may be empty
	 * (length 0).
	 * 
	 * comboString("Hello", "hi") → "hiHellohi" comboString("hi", "Hello") →
	 * "hiHellohi" comboString("aaa", "b") → "baaab"
	 */

	public String comboString(String a, String b) {
		if (a.length() > b.length()) {
			return b + a + b;
		} else {
			return a + b + a;
		}
	}

	/*
	 * Given a string, return a string length 2 made of its first 2 chars. If
	 * the string length is less than 2, use '@' for the missing chars.
	 * 
	 * atFirst("hello") → "he" atFirst("hi") → "hi" atFirst("h") → "h@"
	 */
	public String atFirst(String str) {
		if (str.length() == 0)
			return "@@";
		if (str.length() == 1) {
			return str + "@";
		} else {
			return str.substring(0, 2);
		}
	}

	/*
	 * Given a string, return true if the first 2 chars in the string also
	 * appear at the end of the string, such as with "edited".
	 * 
	 * frontAgain("edited") → true frontAgain("edit") → false frontAgain("ed") →
	 * true
	 */
	public boolean frontAgain(String str) {
		if (str.length() >= 2) {
			if (str.substring(0, 2).equals(
					str.substring(str.length() - 2, str.length())))
				return true;
		}
		return false;
	}

	/*
	 * Given a string, return a new string made of 3 copies of the last 2 chars
	 * of the original string. The string length will be at least 2.
	 * 
	 * extraEnd("Hello") → "lololo" extraEnd("ab") → "ababab" extraEnd("Hi") →
	 * "HiHiHi"
	 */
	public String extraEnd(String str) {
		return str.substring(str.length() - 2, str.length())
				+ str.substring(str.length() - 2, str.length())
				+ str.substring(str.length() - 2, str.length());
	}

	/*
	 * Given a string, if the first or last chars are 'x', return the string
	 * without those 'x' chars, and otherwise return the string unchanged.
	 * 
	 * withoutX("xHix") → "Hi" withoutX("xHi") → "Hi" withoutX("Hxix") → "Hxi"
	 */
	public String withoutX(String str) {
		String withoutX = "";
		if (str.startsWith("x")) {
			withoutX = str.substring(1, str.length());
		} else {
			withoutX = str;
		}
		if (withoutX.endsWith("x"))
			withoutX = withoutX.substring(0, withoutX.length() - 1);
		return withoutX;
	}

	/*
	 * Given 2 strings, return their concatenation, except omit the first char
	 * of each. The strings will be at least length 1.
	 * 
	 * nonStart("Hello", "There") → "ellohere" nonStart("java", "code") →
	 * "avaode" nonStart("shotl", "java") → "hotlava"
	 */
	public String nonStart(String a, String b) {
		return a.substring(1) + b.substring(1);
	}

	/*
	 * Given a string, return a version without the first and last char, so
	 * "Hello" yields "ell". The string length will be at least 2.
	 * 
	 * withoutEnd("Hello") → "ell" withoutEnd("java") → "av"
	 * withoutEnd("coding") → "odin"
	 */
	public String withoutEnd(String str) {
		return str.substring(1, str.length() - 1);
	}

	/*
	 * Given two strings, append them together (known as "concatenation") and
	 * return the result. However, if the concatenation creates a double-char,
	 * then omit one of the chars, so "abc" and "cat" yields "abcat".
	 * 
	 * conCat("abc", "cat") → "abcat" conCat("dog", "cat") → "dogcat"
	 * conCat("abc", "") → "abc"
	 */
	public String conCat(String a, String b) {
		if (a.length() == 0 || b.length() == 0)
			return a + b;
		if (a.charAt(a.length() - 1) == b.charAt(0)) {
			return a + b.substring(1);
		} else {
			return a + b;
		}
	}

	/*
	 * Given a string of even length, return the first half. So the string
	 * "WooHoo" yields "Woo".
	 * 
	 * firstHalf("WooHoo") → "Woo" firstHalf("HelloThere") → "Hello"
	 * firstHalf("abcdef") → "abc"
	 */
	public String firstHalf(String str) {
		return str.substring(str.length() / 2);
	}

	/*
	 * Given an array of ints, we'll say that a triple is a value appearing 3
	 * times in a row in the array. Return true if the array does not contain
	 * any triples.
	 * 
	 * noTriples([1, 1, 2, 2, 1]) → true noTriples([1, 1, 2, 2, 2, 1]) → false
	 * noTriples([1, 1, 1, 2, 2, 2, 1]) → false
	 */
	public boolean noTriples(int[] nums) {
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2])
				return false;
		}
		return true;
	}

	/*
	 * iven an array of ints, return the number of times that two 6's are next
	 * to each other in the array. Also count instances where the second "6" is
	 * actually a 7.
	 * 
	 * array667([6, 6, 2]) → 1 array667([6, 6, 2, 6]) → 1 array667([6, 7, 2, 6])
	 * → 1
	 */
	public int array667(int[] nums) {
		int secondSixOrSeven = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 6 && nums[i + 1] == 6)
				secondSixOrSeven++;
			if (nums[i] == 6 && nums[i + 1] == 7)
				secondSixOrSeven++;
		}
		return secondSixOrSeven;
	}

	/*
	 * Given an array of ints, return true if it contains a 2, 7, 1 pattern -- a
	 * value, followed by the value plus 5, followed by the value minus 1.
	 * Additionally the 271 counts even if the "1" differs by 2 or less from the
	 * correct value.
	 * 
	 * has271([1, 2, 7, 1]) → true has271([1, 2, 8, 1]) → false has271([2, 7,
	 * 1]) → true
	 */
	
	public boolean has271(int[] nums) {
		  // Iterate < length-2, so can use i+1 and i+2 in the loop.
		  // Return true immediately when seeing 271.
		  for (int i=0; i < (nums.length-2); i++) {
		    int val = nums[i];
		    if (nums[i+1] == (val + 5) &&
		      Math.abs(nums[i+2] - (val-1)) <= 2)  return true;
		  }
		  
		  // If we get here ... none found.
		  return false;
	}

}
