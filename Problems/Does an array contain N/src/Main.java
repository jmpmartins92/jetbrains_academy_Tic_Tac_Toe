import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = scan.nextInt();
        }
        int num = scan.nextInt();
        for (int j = 0; j < length; j++) {
            if (nums[j] == num) {
                System.out.println(true);
                break;
            } else if (j == length - 1) {
                System.out.println(false);
            }
        }

    }
}