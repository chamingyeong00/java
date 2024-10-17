import java.util.Scanner;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final byte POWER = 0b1; //가독성이 더 좋음
        final byte DOOR = 0b10;
        final byte LAMP = 0b100;
        final byte TEMP = 0b1000;

        System.out.print("냉장고 상태 입력>>");
        String str = scanner.next();
        byte status = Byte.parseByte(str, 2); //parseByte?

        if ((status & POWER) != 0)
            System.out.print("전원 켜져 있음. ");
        else
            System.out.print("전원 꺼져 있음. ");

        if ((status & DOOR) != 0)
            System.out.print("문 열러 있음. ");
        else
            System.out.print("문 닫혀 있음. ");

        if ((status & LAMP) != 0)
            System.out.print("전구 정상 작동. ");
        else
            System.out.print("전구 손상. ");

        if ((status & TEMP) != 0)
            System.out.print("냉장고 온도 3도 미만. ");
        else
            System.out.print("냉장고 온도 3도 이상. ");

        /*if ((status & 0b00000001) != 0)
            System.out.print("전원 켜져 있음. ");
        else
            System.out.print("전원 꺼져 있음. ");

        if ((status & 0b00000010) != 0)
            System.out.print("문 열러 있음. ");
        else
            System.out.print("문 닫혀 있음. ");

        if ((status & 0b00000100) != 0)
            System.out.print("전구 정상 작동. ");
        else
            System.out.print("전구 손상. ");

        if ((status & 0b00001000) != 0)
            System.out.print("냉장고 온도 3도 미만. ");
        else
            System.out.print("냉장고 온도 3도 이상. ");*/

    }
}