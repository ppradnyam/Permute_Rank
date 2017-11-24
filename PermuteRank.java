import java.util.*;


class PermuteRank {
	static ArrayList records = new ArrayList();
	static ArrayList<String> inputs = new ArrayList();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int testCases = sc.nextInt();
		sc.nextLine();
		long product = 1;
		int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		for(int i = 0; i < testCases; i++) {
			String input = sc.nextLine();
			inputs.add(input);
			
			//System.out.println("index of "+input+": "+getIndex(input));
		}
		do {  // Must start at lowest permutation
			records.add(filterString(Arrays.toString(array)));
		} while (nextPermutation(array));
		
		for(String str : inputs) {
			product = product * getIndex(str);
		}
		product = product % 23456;
		System.out.println(product);
	}
	
	static long getIndex(String key) {
		return (records.indexOf(key) + 1);
	}
	
	static boolean nextPermutation(int[] array) {
    // Find longest non-increasing suffix
    int i = array.length - 1;
    while (i > 0 && array[i - 1] >= array[i])
        i--;
    // Now i is the head index of the suffix
    
    // Are we at the last permutation already?
    if (i <= 0)
        return false;
    
    // Let array[i - 1] be the pivot
    // Find rightmost element that exceeds the pivot
    int j = array.length - 1;
    while (array[j] <= array[i - 1])
        j--;
    // Now the value array[j] will become the new pivot
    // Assertion: j >= i
    
    // Swap the pivot with j
    int temp = array[i - 1];
    array[i - 1] = array[j];
    array[j] = temp;
    
    // Reverse the suffix
    j = array.length - 1;
    while (i < j) {
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++;
        j--;
    }
    
    // Successfully computed the next permutation
    return true;
}
	static String filterString(String str) {
		return str.replace("[", "").replace("]", "").replace(" ", "").replace(",", "");
	}
}
