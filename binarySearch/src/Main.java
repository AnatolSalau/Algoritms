import java.util.Arrays;

public class Main {
      public static void main(String[] args) {
            int[] array = new int[] {10,9,8,7,6,5,4,3,2,1};
            //We can use Binary search only in sorted arrays
            doSort(array);
            int elementToFind = 5;
            int index = binarySearchRecursive(array, 0, array.length - 1, elementToFind);
            System.out.println("arr : " + Arrays.toString(array));
            System.out.println("Index number "+ elementToFind +" is " + index );

      }
      //find index of elements
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
