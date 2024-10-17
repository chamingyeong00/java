import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수를 입력하시오>>");
        int n = scanner.nextInt();
        if (n<=0){
            System.out.println("0보다 커야합니다");
            return;
        }
        for (int i=n; i>0; i--) {
            for (int j=0; j<i; j++)
                System.out.print('*');
            System.out.println();
        }
    }
}