import java.awt.*;
import java.util.Scanner;
import java.util.Vector;

public class GraphicEditor {
    private Scanner scanner = new Scanner(System.in);
    private Vector<Shape> v = new Vector<>();

    private void insert(){
        System.out.print("선(1), 사각형(2), 원(3)>>");
        int type = scanner.nextInt();
        Shape shape = null;
        switch(type){
            case 1:
                shape = new Line();
                break;
            case 2:
                shape = new Rect();
                break;
            case 3:
                shape = new Circle();
                break;
            default:
                System.out.println("잘못된 입력!!");
                return;
        }
        v.add(shape); //v는 0부터 추가
    }

    private void delete(){
        System.out.print("삭제할 도형 위치>>");
        int index = scanner.nextInt();
        try{
            v.remove(index);
        }catch(Exception e){
            System.out.println("잘못된 위치입니다.");
        }
    }
    private void view(){
        for (Shape s : v){
            s.draw();
        }
    }

    public void run(){
        while (true){
            System.out.print("삽입(1), 삭제(2), 모두보기(3), 종료(4)");
            int select = scanner.nextInt();
            switch(select){
                case 1:
                    insert();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    view();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("잘못된 메뉴 선택!!");
            }
        }
    }
}
