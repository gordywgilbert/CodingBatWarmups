public class Array2 {
	public static void main(String args[]) {

	}

	/*
	 * Return the number of even ints in the given array. Note: the % "mod"
	 * operator computes the remainder, e.g. 5 % 2 is 1.
	 * 
	 * countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1,
	 * 3, 5]) → 0
	 */
	public int countEvens(int[] nums) {
		int totalEvenNumbers = 0;
		for (int i = 0; i < nums.length; i++) {
			// if the number is divisible by two then it is even and
			// totalEvenNumbers gets incremented
			if (nums[i] % 2 == 0)
				totalEvenNumbers++;
		}
		return totalEvenNumbers;
	}

	/*
	 * Given an array length 1 or more of ints, return the difference between
	 * the largest and smallest values in the array. Note: the built-in
	 * Math.min(v1, v2) and Math.max(v1, v2) methods return the smaller or
	 * larger of two values.
	 * 
	 * bigDiff([10, 3, 5, 6]) → 7 bigDiff([7, 2, 10, 9]) → 8 bigDiff([2, 10, 7,
	 * 2]) → 8
	 */

	public int bigDiff(int[] nums) {
		int smallest = 0, largest = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				smallest = nums[i];
				largest = nums[i];
			}
			smallest = Math.min(nums[i], smallest);
			largest = Math.max(nums[i], largest);
		}
		return Math.abs(largest - smallest);
	}

	/*
	 * Return the "centered" average of an array of ints, which we'll say is the
	 * mean average of the values, except ignoring the largest and smallest
	 * values in the array. If there are multiple copies of the smallest value,
	 * ignore just one copy, and likewise for the largest value. Use int
	 * division to produce the final average. You may assume that the array is
	 * length 3 or more.
	 * 
	 * centeredAverage([1, 2, 3, 4, 100]) → 3 centeredAverage([1, 1, 5, 5, 10,
	 * 8, 7]) → 5 centeredAverage([-10, -4, -2, -4, -2, 0]) → -3
	 */

	public int centeredAverage(int[] nums) {
		int totalOfCenter = 0; // initialize totalOfCenter
		int largest = 0, smallest = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				smallest = nums[i];
				largest = nums[i];
			}
			totalOfCenter += nums[i]; // add the item at num[i] to totalOfCenter
			smallest = Math.min(nums[i], smallest);
			largest = Math.max(nums[i], largest);
		}

		// return the average of totalOfCenter / (the arrays length - 2)
		totalOfCenter = totalOfCenter - largest - smallest;
		return totalOfCenter / (nums.length - 2);
	}

	/*
	 * Return the sum of the numbers in the array, returning 0 for an empty
	 * array. Except the number 13 is very unlucky, so it does not count and
	 * numbers that come immediately after a 13 also do not count.
	 * 
	 * sum13([1, 2, 2, 1]) → 6 sum13([1, 1]) → 2 sum13([1, 2, 2, 1, 13]) → 6
	 */
	public int sum13(int[] nums) {
		int total = 0; // total initialized to 0
		for (int i = 0; i < nums.length; i++) { // for every item in the nums
												// array
			if (nums[i] == 13 && i + 1 <= nums.length) {
				i++;
				continue;
			} else {
				total += nums[i]; // add number to current total
			}
		}
		return total; // return the total
	}

	/*
	 * Return the sum of the numbers in the array, except ignore sections of
	 * numbers starting with a 6 and extending to the next 7 (every 6 will be
	 * followed by at least one 7). Return 0 for no numbers.
	 * 
	 * sum67([1, 2, 2]) → 5 sum67([1, 2, 2, 6, 99, 99, 7]) → 5 sum67([1, 1, 6,
	 * 7, 2]) → 4
	 */
	public int sum67(int[] nums) {
		int totalSum = 0;
		boolean betweenSixAndSeven = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 6) {
				betweenSixAndSeven = true;
				continue;
			}
			if (betweenSixAndSeven && nums[i] != 7) {
				continue;
			} else if (betweenSixAndSeven && nums[i] == 7) {
				betweenSixAndSeven = false;
				continue;
			}
			if (!betweenSixAndSeven)
				totalSum += nums[i];
		}
		return totalSum;
	}

	/*
	 * Given an array of ints, return true if the array contains a 2 next to a 2
	 * somewhere.
	 * 
	 * has22([1, 2, 2]) → true has22([1, 2, 1, 2]) → false has22([2, 1, 2]) →
	 * false
	 */
	public boolean has22(int[] nums) {
		boolean firstTwo = false, twoTwos = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 2 && !firstTwo) {
				firstTwo = true;
				continue;
			}
			if (nums[i] == 2 && firstTwo && i >= 1 && nums[i - 1] == 2)
				return true;
		}
		return twoTwos;
	}

	/*
	 * Given an array of ints, return true if the array contains no 1's and no
	 * 3's.
	 * 
	 * lucky13([0, 2, 4]) → true lucky13([1, 2, 3]) → false lucky13([1, 2, 4]) →
	 * false
	 */
	public boolean lucky13(int[] nums) {
		boolean lucky = true;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1 || nums[i] == 3)
				return false;
		}
		return lucky;
	}

	/*
	 * Given an array of ints, return true if the sum of all the 2's in the
	 * array is exactly 8.
	 * 
	 * sum28([2, 3, 2, 2, 4, 2]) → true sum28([2, 3, 2, 2, 4, 2, 2]) → false
	 * sum28([1, 2, 3, 4]) → false
	 */
	public boolean sum28(int[] nums) {
		int numTwos = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 2)
				numTwos++;
		}
		return numTwos == 4 ? true : false;
	}

	/*
	 * Given an array of ints, return true if the number of 1's is greater than
	 * the number of 4's
	 * 
	 * more14([1, 4, 1]) → true more14([1, 4, 1, 4]) → false more14([1, 1]) →
	 * true
	 */
	public boolean more14(int[] nums) {
		int numOnes = 0, numFours = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1)
				numOnes++;
			if (nums[i] == 4)
				numFours++;
		}
		return numOnes > numFours ? true : false;
	}

	/*
	 * Given a number n, create and return a new int array of length n,
	 * containing the numbers 0, 1, 2, ... n-1. The given n may be 0, in which
	 * case just return a length 0 array. You do not need a separate
	 * if-statement for the length-0 case; the for-loop should naturally execute
	 * 0 times in that case, so it just works. The syntax to make a new int
	 * array is: new int[desired_length] (See also: FizzBuzz Code)
	 * 
	 * fizzArray(4) → [0, 1, 2, 3] fizzArray(1) → [0] fizzArray(10) → [0, 1, 2,
	 * 3, 4, 5, 6, 7, 8, 9]
	 */

	public int[] fizzArray(int n) {
		int newArray[] = new int[Math.max(n, 0)];
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = i;
		}
		return newArray;
	}

	/*
	 * Given an array of ints, return true if every element is a 1 or a 4.
	 * 
	 * only14([1, 4, 1, 4]) → true only14([1, 4, 2, 4]) → false only14([1, 1]) →
	 * true
	 */

	public boolean only14(int[] nums) {
		for (int number : nums) {
			if (number != 1 && number != 4) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Given a number n, create and return a new string array of length n,
	 * containing the strings "0", "1" "2" .. through n-1. N may be 0, in which
	 * case just return a length 0 array. Note: String.valueOf(xxx) will make
	 * the String form of most types. The syntax to make a new string array is:
	 * new String[desired_length]
	 */

	public String[] fizzArray2(int n) {
		if (n == 0)
			return new String[0]; // if n == 0 return empty string
		String fizzArray[] = new String[n];
		for (int i = 0; i < n; i++) {
			fizzArray[i] = String.valueOf(i); // otherwise iterate through
												// through the loop n times and
												// add n to position n in the
												// array
		}
		return fizzArray;
	}

	/*
	 * Given an array of ints, return true if it contains no 1's or it contains
	 * no 4's.
	 * 
	 * no14([1, 2, 3]) → true no14([1, 2, 3, 4]) → false no14([2, 3, 4]) → true
	 */

	public boolean no14(int[] nums) {
		boolean has1 = false, has4 = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1)
				has1 = true;
			if (nums[i] == 4)
				has4 = true;
		}
		return ((!has1) || (!has4));
	}

	/*
	 * Given an array of ints, return true if the array contains a 2 next to a 2
	 * or a 4 next to a 4, but not both.
	 * 
	 * either24([1, 2, 2]) → true either24([4, 4, 1]) → true either24([4, 4, 1,
	 * 2, 2]) → false
	 */
	public boolean either24(int[] nums) {
		boolean two2s = false, two4s = false;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 2 && nums[i + 1] == 2)
				two2s = true;
			if (nums[i] == 4 && nums[i + 1] == 4)
				two4s = true;
		}
		return (two2s != two4s);
	}

	/*
	 * Given arrays nums1 and nums2 of the same length, for every element in
	 * nums1, consider the corresponding element in nums2 (at the same index).
	 * Return the count of the number of times that the two elements differ by 2
	 * or less, but are not equal.
	 * 
	 * matchUp([1, 2, 3], [2, 3, 10]) → 2 matchUp([1, 2, 3], [2, 3, 5]) → 3
	 * matchUp([1, 2, 3], [2, 3, 3]) → 2
	 */

	public int matchUp(int[] nums1, int[] nums2) {
		int lessThanTwo = 0;
		for (int i = 0; i < nums1.length; i++) {
			if (nums1[i] != nums2[i] && Math.abs(nums1[i] - nums2[i]) <= 2)
				lessThanTwo++;
		}
		return lessThanTwo;
	}

	/*
	 * Given an array of ints, return true if the array contains two 7's next to
	 * each other, or there are two 7's separated by one element, such as with
	 * {7, 1, 7}.
	 * 
	 * has77([1, 7, 7]) → true has77([1, 7, 1, 7]) → true has77([1, 7, 1, 1, 7])
	 * → false
	 */

	public boolean has77(int[] nums) {
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] == 7 && nums[i - 1] == 7)
				return true;
			if (nums[i] == 7 && nums[i + 1] == 7)
				return true;
			if (nums[i - 1] == 7 && nums[i + 1] == 7)
				return true;
		}
		return false;
	}

	/*
	 * Given an array of ints, return true if there is a 1 in the array with a 2
	 * somewhere later in the array.
	 * 
	 * has12([1, 3, 2]) → true has12([3, 1, 2]) → true has12([3, 1, 4, 5, 2]) →
	 * true
	 */

	public boolean has12(int[] nums) {
		boolean previous1 = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				previous1 = true;
			}
			if (nums[i] == 2 && previous1)
				return true;
		}
		return false;
	}

	/*
	 * Given an array of ints, return true if the array contains either 3 even
	 * or 3 odd values all next to each other.
	 * 
	 * modThree([2, 1, 3, 5]) → true modThree([2, 1, 2, 5]) → false modThree([2,
	 * 4, 2, 5]) → true
	 */
	public boolean modThree(int[] nums) {
		int evens = 0, odds = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				evens++;
			} else {
				evens = 0;
			}
			if (evens == 3 && odds == 0)
				return true;
			if (nums[i] % 2 == 1) {
				odds++;
			} else {
				odds = 0;
			}
			if (odds == 3 && evens == 0)
				return true;
		}
		return false;
	}

	/*
	 * Given an array of ints, return true if the value 3 appears in the array
	 * exactly 3 times, and no 3's are next to each other.
	 * 
	 * haveThree([3, 1, 3, 1, 3]) → true haveThree([3, 1, 3, 3]) → false
	 * haveThree([3, 4, 3, 3, 4]) → false
	 */

	public boolean haveThree(int[] nums) {
		int threeCount = 0; boolean prevWasThree = false;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 3) {	// current value is three
				if(prevWasThree) {
					return false;	// last value was 3 and current is 3, return false
				} else {
					threeCount++;
					prevWasThree = true;
				}				
			} else {
				prevWasThree = false;	// reset the flag since the last value wasn't 3
			}
		}
		return threeCount == 3;
	}

}
