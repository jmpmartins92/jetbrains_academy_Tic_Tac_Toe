import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringIn = scanner.nextLine();
        List<String> stringList = new ArrayList<>(Arrays.asList(stringIn.split(" ")));
        int n = scanner.nextInt();
        Collections.rotate(stringList, n);
        String[] rotatedOut = new String[stringList.size()];
        for (int i = 0; i < stringList.size(); i++) {
            rotatedOut[i] = stringList.get(i) + " ";
            System.out.print(rotatedOut[i]);
        }
    }
}