/**
 * 
 */
package string;

/**
 * @author weiyan.xiang
 * @date 30 Jan 2018
 */
public class ReverseString {

    public static String reverse(String input) {
        int i = 0, j = input.length() - 1;
        char[] inputArray = input.toCharArray();
        char temp;
        while (i < j) {
            temp = inputArray[i];
            inputArray[i] = inputArray[j];
            inputArray[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(inputArray);
    }

    public static void main(String[] args) {
        System.out.println("hello 123 <->" + reverse("hello 123"));
    }
}
