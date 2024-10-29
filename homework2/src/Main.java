import java.util.Scanner;

class Average{
    double sum=0;
    int array[] = new int[10];
    int cnt=0;

    public void put(int n){
        if (cnt >= 10){
            return ;
        }
        this.array[cnt] = n;
        cnt++;
    }

    public double getAvg(){
        for(int i=0; i<array.length; i++){
            sum+=array[i];
        }
        return sum/cnt;
    }

    public void showAll(){
        System.out.println("***** 저장된 데이터 모두 출력 *****");
        for(int i=0; i<cnt; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Average avg = new Average();
        avg.put(10);
        avg.put(15);
        avg.put(100);
        avg.showAll();
        System.out.print("평균은 "+avg.getAvg());
    }
}