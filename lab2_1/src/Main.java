import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("여행지>>");
        String place = scanner.nextLine(); //띄어쓰기 Line 사용

        System.out.print("인원수>>");
        int person = scanner.nextInt();

        System.out.print("숙박일>>");
        int day = scanner.nextInt();

        System.out.print("1인당 항공료>>");
        int airplane = scanner.nextInt();

        System.out.print("1방 숙박비>>");
        int hotel = scanner.nextInt();

        int room = person / 2 + person % 2;
        //((long)person / 2)== 1) ?

        int cost = (room * hotel * day) + (person * airplane);
        System.out.print( person +"명의 " + place + " " + day + "박 " + (day + 1) + "일 여행에는 방이 " + room + "개 필요하며 경비는 " + cost + "원입니다.");
    }
}