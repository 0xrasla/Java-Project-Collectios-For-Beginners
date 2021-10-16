public class App {
    public static void main(String[] args) throws Exception {
        // sort
        int[] arr1 = { 20, 40, 10, 30, 50, -20 };
        sortAnArray(arr1);
        // sum of array
        int[] arr2 = { 20, 40, 10, 30, 50, -20 };
        getSumofArray(arr2);
        // print grid
        printGrid(10);
    }

    // an funvtion to sort an array
    static void sortAnArray(int a[]) {
        int temp = 0;
        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }

    // an funvtion get sum of an array
    static void getSumofArray(int a[]) {
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }

        System.out.println(sum);
    }

    // print a basic grid
    static void printGrid(int n) {
        int[][] a = new int[10][10];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%2d ", a[i][j]);
            }
            System.out.println();
        }

    }

}
