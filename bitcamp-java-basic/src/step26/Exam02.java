package step26;

public class Exam02 {
    public static void main(String[] args) {
        int numary[] = {1,0,0,0,0};
        int i, j;
        for (j = 0; j < 5; j++) {
            for (i = 0; i < 5; i++) {
                numary[j] += numary[i];
            }
        }
        for (j = 0; j < 5; ++j) {
            System.out.printf("%d\n", numary[j]);
        }
    }
}
