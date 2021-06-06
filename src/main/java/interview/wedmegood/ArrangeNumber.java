package interview.wedmegood;

public class ArrangeNumber {

    public static void main(String[] args) {
        ArrangeNumber arrangeNumber = new ArrangeNumber();
        int[] ints = {23, 45, 0, 0, -98, 0, 100, 0};
        arrangeNumber.arrangeNumbers(ints);
        for (int num : ints) {
            System.out.print(num + ", ");
        }
    }

    public void arrangeNumbers(int[] arr) {

        int n = arr.length;
        int i = 0;
        int j = 0;

        while (i < n) {
            if (arr[i] == 0) {
                while (j < n && arr[j] == 0) {
                    j++;
                }
                if (j == n) break;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            i++;
            j = i;
        }
    }
}
