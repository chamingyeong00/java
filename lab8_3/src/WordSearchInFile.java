import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class WordSearchInFile {
    private File targetFile;
    private ArrayList<String> lines = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private void readFile(){
        System.out.print("파일명>>");
        String fileName = scanner.nextLine();
        targetFile = new File(fileName);
        try{
            Scanner fscanner = new Scanner(new FileReader(targetFile));
            while(fscanner.hasNext()){
                lines.add(fscanner.nextLine());
            }
            fscanner.close();
        } catch (FileNotFoundException e){
            System.out.println(targetFile.getPath() + "없음");
        }
        System.out.println(targetFile.getName() + " : " + lines.size());
    }

    private ArrayList<Integer> searchWord(String word){
        var idxs = new ArrayList<Integer>();
        int num=0;
        for(String line : lines){
            if (line.indexOf(word) != -1)
                idxs.add(num);
            num++;
        }
        return idxs;
    }
    private void printLines(ArrayList<Integer> idxs){
        for(int i : idxs){
            System.out.println((i+1) + ":" + lines.get(i));
        }
    }
    public void run(){
        readFile();
        while(true){
            System.out.print("검색할 단어 또는 문장>> ");
            String line = scanner.nextLine();
            if(line.equals("exit")) break;
            printLines(searchWord(line));
        }
    }

}
