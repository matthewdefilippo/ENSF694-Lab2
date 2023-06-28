
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

	public static void main(String[] args) {
		int[] array = {1, 6, 3, 5, 2};
		int[] sortedArray = {1, 4, 5, 6, 8, 9, 21};
		System.out.println(linearSearch(array, 6));
		System.out.println(binarySearchIterative(sortedArray, 6));
		System.out.println(binarySearchRecursive(sortedArray, 0, sortedArray.length-1, 6));
		System.out.println(interpolationSearchIterative(sortedArray, 50));

	}

}
