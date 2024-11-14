import java.io.File;

public class Main {
    public static void printDir(File dir){
        if(!dir.isDirectory()) return;
        System.out.println("---" + dir.getPath() + "---");
        File[] files = dir.listFiles();
        if(files == null) return;
        for(File file : files){
            if (file.isDirectory())
                printDir(file);
            System.out.print(file.getName());
            System.out.println(" "+file.length() + "bytes");
        }
    }
    public static void main(String[] args) {
    File dir = new File("/Users/it/IdeaProjects");
    printDir(dir);
    }
}