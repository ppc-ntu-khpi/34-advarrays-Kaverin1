import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int [][] matrix = new int[3][3];
        int x=0;

        for(int[] row:matrix)
            Arrays.fill(row,x);

        for(int[] row:matrix)
            System.out.println(Arrays.toString(row));
    }
}
