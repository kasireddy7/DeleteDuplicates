
/**
 *This class have three methods and all are for removing the duplicates.
 *removeDuplicatesUsingList:
 * Positives:
 *  1)This method is more efficient as there’s not much of looping and conditions. 
 *  2)It will give the same order what ever the input array.
 * Negatives: 
 *	
 *removeDuplicatesUsingSet:
 * Positives:
 *  1)This method also efficient too
 *  2)Easy for developer to code as well as java takes care of removing all duplicates in a really efficient way.
 * Negatives:
 *  1)Order not guarantee 
 *
 *removeDuplicatesWithSortAndComparing:
 * Positives: It will the unique values array
 * Negatives: 
 * 1)It will sort the values
 * 2)Performance issue as there are more loops involved to remove duplicates one by one. 
 * 
 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author rreddy
 */

public class DeleteDuplicates {
	public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1,
			18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
			19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DeleteDuplicates deDup = new DeleteDuplicates();
		// uniqueArrayUsingList will have unique values with out changing the
		// input order.
		Integer[] uniqueArrayUsingList = deDup.removeDuplicatesUsingList();
		System.out.println("Result::Same order using TEST List::::::::::" + Arrays.toString(uniqueArrayUsingList));
		// uniqueArrayUsingSet will have unique values but order not guarantee
		Integer[] uniqueArrayUsingSet = deDup.removeDuplicatesUsingSet();
		System.out.println("Result::Order not guarantee using Set::" + Arrays.toString(uniqueArrayUsingSet));
		int[] uniqueArrayUsingSortAndCompare = deDup.removeDuplicatesWithSortAndComparing();
		System.out.println("Result::Sorting Order usning comparing:" + Arrays.toString(uniqueArrayUsingSortAndCompare));
	}

	/**
	 * This method will remove the duplicates and return the array of integers
	 * in the same order.
	 * 
	 * @return integer array.
	 */
	public Integer[] removeDuplicatesUsingList() {
		List<Integer> list = new ArrayList<Integer>();
		for (int index = 0; index < randomIntegers.length; index++) {
			if (!list.contains(randomIntegers[index])) {
				list.add(randomIntegers[index]);
			}
		}
		return list.toArray(new Integer[0]);
	}

	/**
	 * This method will remove the duplicates and return the array of integers.
	 * 
	 * @return integer array.
	 */
	public Integer[] removeDuplicatesUsingSet() {
		return new HashSet<Integer>(Arrays.asList(intToInteger(randomIntegers))).toArray(new Integer[0]);
	}

	/**
	 * This method will sort the given input integers and compare with first
	 * with next so on and remove the duplicates and return the array of
	 * integers in the sorting order.
	 * 
	 * @return int array
	 */

	public int[] removeDuplicatesWithSortAndComparing() {
		int[] randomIntArray = randomIntegers;
		Arrays.sort(randomIntArray);
		int j = 0;
		int i = 1;
		// return if the array length is less than 2
		if (randomIntArray.length < 2) {
			return randomIntArray;
		}
		while (i < randomIntArray.length) {
			if (randomIntArray[i] == randomIntArray[j]) {
				i++;
			} else {
				randomIntArray[++j] = randomIntArray[i++];
			}
		}
		int[] uniqueIntArray = new int[j + 1];
		for (int k = 0; k < uniqueIntArray.length; k++) {
			uniqueIntArray[k] = randomIntArray[k];
		}
		return uniqueIntArray;
	}

	/**
	 * This method will take int array and return the integer array. Convert
	 * int[] to Integer[]
	 * 
	 * @param intArray
	 * @return integer array
	 */

	private Integer[] intToInteger(int[] intArray) {
		Integer[] integerArray = new Integer[intArray.length];
		for (int i = 0; i < intArray.length; i++) {
			integerArray[i] = Integer.valueOf(intArray[i]);
		}
		return integerArray;
	}
}
