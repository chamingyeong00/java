import java.util.Scanner;

class Dictionary{
    private static String [] kor = {"a", "b", "c", "d", "e"};
    private static String [] eng = {"love", "baby", "money", "future", "hope"};
    public static String kor2Eng(String word){
        for (int i = 0; i < kor.length; i++)
        {
            if (kor[i].equals(word))
                return (eng[i]);
        }
        return ("저의 사전에 없습니다.");
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("한영 단어 검색 프로그램입니다.");
        while (true) {
            System.out.print("한글 단어?");
            String korword = scanner.next();
            if (korword.equals("stop"))
                break;
            else {
                String res = Dictionary.kor2Eng(korword);
                System.out.println(korword + "는 " + res);
            }
        }
    }
}
