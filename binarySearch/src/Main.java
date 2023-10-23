import java.util.Arrays;

public class Main {
      public static void main(String[] args) {
            int[] array = new int[] {10,9,8,7,6,5,4,3,2,1};
            //We can use Binary search only in sorted arrays
            doSort(array);
            int elementToFind = 3;
            //int indexRecursion = binarySearchRecursive(array, 0, array.length - 1, elementToFind);
            int indexIterable = binarySearchIterable(array, elementToFind);
            System.out.println("arr : " + Arrays.toString(array));
            //System.out.println("Index number (recursion search) "+ elementToFind +" is " + indexRecursion );
            System.out.println("Index number (iterable search) "+ elementToFind +" is " + indexIterable );

      }
      //find index of elements by recursion
      public static int binarySearchRecursive(int[] arr, int startIndex, int endIndex, int elementToFind) {
            //Exit from recursion
            if (endIndex >= startIndex) {
                  //find middle index
                  int middleIndex = startIndex + (endIndex - startIndex) / 2;

                  //check middle value to equality with element to find
                  if (arr[middleIndex] == elementToFind) {
                        return middleIndex;
                  }

                  //do recursive
                  if(arr[middleIndex] > elementToFind) {
                        return binarySearchRecursive(arr, startIndex, middleIndex -1,elementToFind);
                  } else {
                        return binarySearchRecursive(arr,middleIndex +1,endIndex,elementToFind);
                  }
            }
            return - 1;
      }

      //find index of elements by iteration
      public static int binarySearchIterable(int[] arr, int elementToFind) {
            int startIndex = 0;
            int endIndex = arr.length - 1;
            int middleIndex;
            while (startIndex <= endIndex) {
                  middleIndex = startIndex + (endIndex - startIndex) / 2;
                  System.out.println("startIndex: " + startIndex + ", endIndex: " + endIndex + ", middleIndex: " + middleIndex);

                  if (arr[middleIndex] == elementToFind) {
                        System.out.println("found " + elementToFind + " at " + middleIndex);
                        return middleIndex;
                  }

                  if (arr[middleIndex] > elementToFind) {
                        endIndex = middleIndex - 1;
                  } else {
                        startIndex = middleIndex + 1;
                  }
            }
            return -1;
      }

      private static void doSort(int[] arr) {
            for (int i = 0; i < arr.length-1; i++){
                  for (int j = i+1; j < arr.length; j++){
                        if (arr[ i] > arr[ j]) {
                              int t = arr[ i];
                              arr[ i] = arr[ j];
                              arr[ j] = t;
                        }
                  }
            }
      }
}
