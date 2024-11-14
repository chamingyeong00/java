import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("c:\\windows\\sysstem.ini");//c:/windows/sysstem.ini 이렇게도 가능
        //System.out.println(file.getName() + "읽기!");
        System.out.println(file.getPath() + "읽기!");
        try{
            Scanner fScanner = new Scanner(new FileReader("c:\\windows\\sysstem.ini"));
            int lineNumber = 1;
            while(fScanner.hasNext()){
                String line = fScanner.nextLine();
                System.out.printf("%4d", lineNumber);
                lineNumber++;
                System.out.println(" : " + line);
            }
            fScanner.close();
        } catch(IOException e){
            System.out.println("파일 열기 실패");
        }
    }
}