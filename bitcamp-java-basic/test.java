package step23.ex1;

public class test {
    
    public static int[] divide(int[] arr, int divisor) {
        int count = 0;
        int[] ret = new int[100];
        for(int i = 0; i < arr.length; i++) {
            if((arr[i] % divisor) == 0) {
                ret[count++] = arr[i];
            }
        }
        return ret;
    }
    
    public static void main(String[] args) {
        int[] array = {1, 5, 8, 10};
        int[] result = divide(array, 5);
        for(int i = 0; i < result.length; i++) {
            if(result[i] > 0) {
                System.out.print(result[i] + " ");
            }
        }
    }
}
