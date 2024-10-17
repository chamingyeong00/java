import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.ArrayIndexOutOfBoundsException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.print("10명 학생의 학번과 점수 입력");
        System.out.println();
        int array[][] = new int [10][2];

        for (int i=0; i<10; i++){
            System.out.print(i+1 + ">>");
            //for (int j=0; j<2; j++) {
            array[i][0] = scanner.nextInt();
            array[i][1] = scanner.nextInt();
            //}
        }
        int num;
        while(true) {
            System.out.print("학번으로 검색: 1, 점수로 검색: 2, 끝내려면 3>>");
            num = scanner.nextInt();
            if (num == 1) {
                while(true) {
                    int std_id, cnt = 0;
                    int id[] = new int [10];
                    System.out.print("학번>>");
                    try {
                        std_id = scanner.nextInt();
                        //System.out.println("std_id : "+ std_id);
                        for (int i = 0; i < 10; i++) {
                            //System.out.println("i : " + i);
                            if (array[i][0] == std_id) {
                                id[cnt] = std_id;
                                cnt++;
                            }
                        }
                        if (cnt == 0) {
                            System.out.println(std_id + "의 학생은 없습니다");
                            break;
                        }
                        else{
                            for (int i=0; i<cnt; i++)
                                System.out.println(array[std_id][1] + "점");
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("경고!! 정수를 입력하세요.");
                        scanner.next();
                        //continue;
                    }
                }
            } else if (num == 2) {
                while(true) {
                    int std_score, cnt = 0;

                    System.out.print("점수>>");
                    try {
                        std_score = scanner.nextInt();
                        int score[] = new int[10];
                        for (int k = 0; k < 10; k++) {
                            if (array[k][1] == std_score) {
                                score[cnt] = k;
                                cnt++;
                            }
                        }
                        if (cnt == 0) {
                            System.out.println("점수가" + std_score + "인 학생은 없습니다");
                            break;
                        }
                        else {
                            System.out.print("점수가 " + std_score + "인 학생은 ");
                            for (int i = 0; i < cnt; i++) {
                                System.out.print((score[i]+1) + " ");
                            }
                            System.out.println("입니다");
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("경고!! 정수를 입력하세요.");
                        scanner.next();
                    }
                }
            } else{
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}