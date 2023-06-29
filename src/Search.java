import java.util.Arrays;

public class Search {
	
	static int linearSearch(int[] array, int key) {
		
		for(int i = 0; i < array.length; i++) {
			if (array[i] == key)
				return i; //key found and index returned
		}
		return -1; //key not found and -1 returned
	}
	
	static int binarySearchIterative(int[] array, int key) {
		int low = 0;
		int mid;
		int high = array.length - 1;
		
		while(low <= high) {
			
			mid = (low + high) / 2;
			
			if (key < array[mid]) {
				high = mid - 1;
			} else if (array[mid] < key){
		
				low = mid + 1;
			} else {
				return mid; // key found and index returned
			}
		}
		return -1; // key not found and -1 returned
	}
	
	static int binarySearchRecursive(int [] array, int low, int high, int key) {
		if (low <= high) {
			int mid = (low + high) / 2;
			if (key == array[mid]) {
				return mid; // key found and index returned
			} else if (key < array[mid]) {
				return binarySearchRecursive(array, low, mid-1, key);
			} else if (key > array[mid]) {
				return binarySearchRecursive(array, mid+1, high, key);
			}
		}
		return -1; // key not found and -1 returned
	}
	
	static int interpolationSearchIterative(int [] array, int key) {
		int low = 0;
		int high = array.length - 1;
		
		while(low <= high) {
			
			int pos = (key - array[low]) / (array[high] - array[low]);
			int mid = low + (high-low) * pos;
			
			if (key < array[mid]) {
				high = mid - 1;
			} else if (key > array[mid]){
				low = mid + 1;
			} else {
				return mid; // key found and index returned
			}
		}
		return -1; // key not found and -1 returned
	}
	
	static int interpolationSearchRecursive(int [] array, int low, int high, int key) {
		double pos = (double)(key - array[low]) / (double)(array[high] - array[low]);
		int mid = low + (int)((high-low) * pos);
		
		if (key > array[high] || key < array[low]) {
			return -1;
		}
		
		if (low <= high) {
			if (key == array[mid]) {
				return mid; // key found and index returned
			} else if (key < array[mid]) {
				return interpolationSearchRecursive(array, low, mid-1, key);
			} else if (key > array[mid]) {
				return interpolationSearchRecursive(array, mid+1, high, key);
			}
		}
		return -1; // key not found and -1 returned
	}

	public static void main(String[] args) {
		// Create an instance of InteractiveCLI.
		InteractiveCLI cli = new InteractiveCLI();
		
		// Prompt the user to enter how many elements are in the array.
		cli.prompt("Enter the number of elements in the array: ");
		
		// Store the number of elements in integer, n.
		int n = cli.getKeyboardInteger();
		
		// Create an array of size n to store the input elements.
		int[] array = new int[n];
		
		// Prompt the user to enter the individual elements.
		cli.prompt("Enter the elements in the array: ");
		for (int i = 0; i < n; i++) {
			array[i] = cli.getKeyboardInteger();
		}
		
		// Prompt the user to enter the search key and store it in a variable, key.
		cli.prompt("Enter the search key: ");
		int key = cli.getKeyboardInteger();
		
		// Use linear search to see if it is found.
		long startTime1 = System.nanoTime();
		int linearSearch = linearSearch(array, key);
		long endTime1   = System.nanoTime();
		long totalTime1 = endTime1 - startTime1;
		cli.display("The total running time for linear search was: " + totalTime1 );
		
		
		if (linearSearch > 0) {
			cli.display("Search key FOUND at index " + linearSearch + ".");
		} else {
			cli.display("Search key NOT FOUND.");
		}
		
		// Sort the array and display the sorted array.
		cli.display("Sorting the array...");
		Arrays.sort(array);
		cli.display("Sorted array: " + Arrays.toString(array));
		
		// Use interpolation search to see if the input key is found.
		long startTime2 = System.nanoTime();
		int interpolationSearch = interpolationSearchRecursive(array, 0, array.length-1, key);
		long endTime2   = System.nanoTime();
		long totalTime2 = endTime2 - startTime2;
		cli.display("The total running time for interpolation search was: " + totalTime2 );
		
		if (interpolationSearch > 0) {
			cli.display("Search key FOUND at index " + interpolationSearch + ".");
		} else {
			cli.display("Search key NOT FOUND.");
		}
		
		// Question 2 Response:
		
		// When we look for the value of 11 in the original dataset the linear search takes about 9800 nanoseconds while the interpolation 
		// search takes 12300 nanoseconds. This is because the value of 11 is fairly close to the beginning of the unsorted dataset so it is found 
		// rather quickly. If we rather look for the value of 19 (which is at the end of the unsorted dataset), we see that it takes longer to compute
		// using linear search because it has to run through each and every value.
		
		// Question 3 Response:
		
		// Linear search run time can be improved by performing the search on the sorted array instead of the unsorted array. The time is reduced to
		// about 1000 nanoseconds if this is done as shown below.
		
		long startTime3 = System.nanoTime();
		int linearSearchImproved = linearSearch(array, key);
		long endTime3   = System.nanoTime();
		long totalTime3 = endTime3 - startTime3;
		cli.display("The total running time for linear search was: " + totalTime3 );
		
		if (interpolationSearch > 0) {
			cli.display("Search key FOUND at index " + linearSearchImproved + ".");
		} else {
			cli.display("Search key NOT FOUND.");
		}
		
		// 
		

	}

}