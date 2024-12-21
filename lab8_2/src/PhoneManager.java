import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneManager {
    private File file = new File("/Users/it/IdeaProjects/phone.rtf");
    private HashMap<String,String> phoneMap = new HashMap<String, String>();
    public PhoneManager(String filename){
        file = new File(filename);
    }
    public PhoneManager(){}

    private void readPhoneFile(){
        try{
            Scanner fscanner = new Scanner(new FileReader(file));
            while(fscanner.hasNext()){
                String name = fscanner.next(); //공백, 탭, 줄바꿈까지 읽음
                String num = fscanner.next();
                phoneMap.put(name, num);
            }
            fscanner.close();
        }catch(IOException e){
            System.out.println(file.getPath() + "열기 실패");
            return ;
        }
        System.out.println("총 " + phoneMap.size() + " 개 번호 읽음.");
    }
    private void search(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("이름 >> ");
            String name = scanner.next();
            if (name.equals("exit")) break;
            String num = phoneMap.get(name);
            if (num == null){
                System.out.println(name + "은 없습니다.");
            } else{
                System.out.println(name + "의 전화번호는 " + num + "입니다.");
            }

        }
    }
    public void run(){
        readPhoneFile();
        search();
    }
}
