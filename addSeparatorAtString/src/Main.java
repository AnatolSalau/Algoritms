public class Main {
      public static void main(String[] args) {
            String[] str = {"One", "Two", "Three", "Four"};
            String s = addSeparator(str, "-");
            System.out.println(s);
      }

      static String addSeparator(String[] arr, String separator) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                  stringBuilder.append(arr[i]);
                  if (i == arr.length - 1) {
                        break;
                  }
                  stringBuilder.append(separator);
            }
            return stringBuilder.toString();
      }

}
