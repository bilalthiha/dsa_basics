public class MergeSort{
	
    public static void main(String args[])
    {   	
    	// merge sort = recursively divide array in 2, sort, re-combine
    	// run-time complexity = O(n Log n)
    	// space complexity    = O(n)
    	
        int[] array = {8, 2, 5, 3, 4, 7, 6, 1};
        
        mergeSort(array);
        
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+ " ");
        }
        
    }

	private static void mergeSort(int[] array) {
        int aLen = array.length;
        int mid = (int)aLen/2;
        int[] lArr = new int[mid];
        int[] rArr = new int[aLen-mid];
        int l = 0;
        int r = 0;

        if(aLen <= 1) return; //base case

        //1. Break down array into two arrays, left and right
        for(int i = 0; i < aLen; i++){
            if(i < mid){
                lArr[l] = array[i];
                l++;
            }
            else{
                rArr[r] = array[i];
                r++;
            }
        }

        //2. create recursive mergeSort calls
        mergeSort(lArr);
        mergeSort(rArr);
        //3. Merge sub arrays after base case is hit
        merge(lArr, rArr, array);		
	}
	
	private static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int lALen = leftArray.length;
        int rALen = rightArray.length;
        int arrLen = array.length;
        int lIdx = 0;
        int rIdx = 0;
        int aIdx = 0;

        //If sizes are mistmatching, 
        if(arrLen != lALen + rALen){
            return;
        }

        //Perform the merge using two array indices
        while(aIdx < arrLen){
            if(lIdx == lALen && rIdx < rALen){
                array[aIdx] = rightArray[rIdx];
                rIdx++;
            }
            else if(rIdx == rALen && lIdx < lALen){
                array[aIdx] = leftArray[lIdx];
                lIdx++;
            }
            else if(leftArray[lIdx] < rightArray[rIdx]){
                array[aIdx] = leftArray[lIdx];
                lIdx++;
            }
            else{
                array[aIdx] = rightArray[rIdx];
                rIdx++;
            }

            aIdx++;
        }		
    }
}
