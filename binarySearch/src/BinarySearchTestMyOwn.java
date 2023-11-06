import java.util.Arrays;

public class BinarySearchTestMyOwn {
      public static void main(String[] args) {
            int[] array = new int[] {10,9,8,7,6,5,4,3,2,1};
            System.out.println("Array before : " + Arrays.toString(array));
            //sort array
            doSort();
            System.out.println("Array after : " + Arrays.toString(array));
            int elementToFind = 7;

            int indexRecursion = binarySearchRecursive();
            System.out.println("Index number (recursion search) "+ elementToFind +" is " + indexRecursion );
      }

}
