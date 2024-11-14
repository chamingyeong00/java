import java.util.Scanner;

class Day
{
    private String work;

    public void set(String work){
        this.work = work;
    }
    public String get(){
        return work;
    }
    public void show(){
        if (work == null)
            System.out.println("없습니다.");
        else
            System.out.println(work + "입니다.");
    }
}

class MonthSchedule {
    public Day[] day;
    Scanner scanner = new Scanner(System.in);

    public MonthSchedule(int days)
    {
        day = new Day[days];
        for (int i = 0; i < days; i++)
        {
            day[i] = new Day();
        }
    }

    public void input(int d)
    {
        System.out.print("할일(빈칸없이입력)?");
        String str = scanner.next();
        day[d-1].set(str);
    }

    public void view(int d)
    {
        System.out.print(d + "일의 할 일은");
        day[d-1].show();
    }

    public void finish()
    {
        System.out.println("프로그램을 종료합니다.");
    }

    public void run()
    {
        System.out.println("이번달 스케쥴 관리 프로그램.");
        while(true) {
            System.out.print("할일(입력:1, 보기:2, 끝내기:3) >>");
            int num = scanner.nextInt();
            if (num == 1) {
                System.out.print("날짜(1~30)?");
                int d = scanner.nextInt();
                input(d);
            }
            else if (num == 2) {
                System.out.print("날짜(1~30)?");
                int d = scanner.nextInt();
                view(d);
            }
            else if (num == 3) {
                finish();
                break;
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MonthSchedule april = new MonthSchedule(30);
        april.run();
    }
}