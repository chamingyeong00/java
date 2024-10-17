import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("연산 입력>>");
        double num1 = scanner.nextDouble(); //token으로 구별
        String op = scanner.next();
        double num2 = scanner.nextDouble();
        double res = 0;
        //switch
        /*switch (op)
        {
            case "add":
                res = num1 + num2;
                break;
            case "minus":
                res = num1 - num2;
                break;
            case "division":
                if (num2 == 0) {
                    System.out.print("0으로 나눌 수 없습니다.");
                    return;
                }
                res = num1 / num2;
                break;
            default:
                System.out.print("사칙연산이 아닙니다");
                break;

        }*/
        //if
        if (op.equals("add"))
            res = num1 + num2;
        else if (op.equals("minus"))
            res = num1 - num2;
        else if (op.equals("multiplication"))
            res = num1 * num2;
        else if(op.equals("division")) {
            if (num2 == 0) { //실수값은 == 사용가능
                System.out.print("0으로 나눌 수 없습니다.");
                return;
            }
            res = num1 / num2;
        }
        else {
            System.out.print("사칙연산이 아닙니다");
            return;
        }

        System.out.print(num1 + " "+ op + " " + num2 + "의 계산 결과는 " + res);
    }
}

