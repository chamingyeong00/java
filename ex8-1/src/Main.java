import java.io.*;

public class Main {
    public static void main(String[] args) {
        //FileReader fin = null; //텍스트
        FileInputStream fin = null; //바이트
        FileWriter fout = null;
        File inputFile = new File("/Users/it/IdeaProjects/test.rtf");
        File outputFile = new File ("/Users/it/IdeaProjects/test1.rtf\");

        try {
            //fin = new FileReader("/Users/it/IdeaProjects/test.rtf"); //텍스트
            //fin = new FileInputStream("/Users/it/IdeaProjects/test.rtf"); //바이트 단위
            //fout = new FileWriter("/Users/it/IdeaProjects/test1.rtf");
            fin = new FileInputStream(inputFile);
            fout = new FileWriter(outputFile);

            InputStreamReader in = new InputStreamReader(fin, "MS949");
            int c;
            while((c=in.read()) != -1){
                System.out.println(c + ":0x"+Integer.toHexString(c)+":"+(char)c);
                String str = c + ":0x"+Integer.toHexString(c)+":"+(char)c + "\n";
                fout.write(str, 0, str.length());
            }
            fin.close();
        } catch (FileNotFoundException e){
            System.out.println("파일이 없음");
        } catch (IOException e){
            System.out.println("파일 읽기중 실패");
        }
    }
}