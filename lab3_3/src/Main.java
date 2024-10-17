import java.lang.NumberFormatException;
public class Main {
    public static void main(String[] args) {
        int sum = 0;
        for(String s : args){
            try {
                int n = Integer.parseInt(s);
                sum += n;
            } catch(NumberFormatException e){
                System.out.println(s + "는 정수가 아닙니다.");
            }
        }
        /*for (int i=0; i<args.length; i++) {
            try{
                sum += Integer.parseInt(args[i]);
            }
            catch(NumberFormatException e)
            {
            }
        }*/
        System.out.println(sum);
    }
}