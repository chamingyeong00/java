import java.util.Scanner;

interface Stack{
    int length();
    int capacity();
    String pop();
    boolean push(String val);
}

class StringStack implements Stack{
    public String [] stack;
    private int top;

    public StringStack(int capacity){
        stack = new String[capacity];
        top = -1;
    }

    public int length(){
        return (top + 1);
    }

    public int capacity(){
        return stack.length;
    }

    public String pop(){
        if (top == -1) {
            //System.out.println("스택이 비어있어 팝 불가!");
            return null;
        }
        return stack[top--];
    }

    public boolean push(String val){
        if (top == stack.length - 1) {
            return false;
        }
        stack[++top] = val;
        return true;
    }
}

class StackApp extends StringStack{
    Scanner scanner = new Scanner(System.in);
    public StackApp(int size){

        super(size);

    }
    public void run(){
        while(true)
        {
            System.out.print("문자열 입력 >> ");
            String str = scanner.next();
            if (str.equals("stop"))
                break;
            if (push(str) == false)
            {
                System.out.println("스택이 꽉 차서 푸시 불가!");
            }
        }
        System.out.print("스택에 저장된 모든 문자열 팝 : ");
        for(int i=0; i<stack.length; i++)
        {
            System.out.print(pop() + " ");

        }
        scanner.close();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("총 스택 저장 공간의 크기 입력 >> ");
        int size = scanner.nextInt();
        StackApp stackapp = new StackApp(size);
        stackapp.run();
    }
}