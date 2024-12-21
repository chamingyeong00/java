import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LocationManager {
    private Scanner scanner = new Scanner(System.in);
    private HashMap<String, Location> citys = new HashMap<>();

    private void input(){
        System.out.println("도시명, 위도, 경도를 입력하세요");
        for (int i =0; i < 4; i++){
            System.out.print(">>");
            String inputText = scanner.nextLine();
            StringTokenizer st =new StringTokenizer(inputText, ", ");
            String city = st.nextToken().trim();
            double latitude = Double.parseDouble(st.nextToken().trim());
            double longitude = Double.parseDouble(st.nextToken().trim());

            citys.put(city, new Location(city, latitude, longitude));
        }
    }

    private void printAll(){
        var keys = citys.keySet();
        var it = keys.iterator(); //키 값만 순회
        System.out.println("---------------------");
        while(it.hasNext()){
            System.out.println(citys.get(it.next()));
        }
        System.out.println("-------------------");
    }

    private void search(){
        while(true){
            System.out.print("검색할 도시 이름 >> ");
            String city = scanner.nextLine();
            if(city.equals("exit"))
                break;
            Location loc = citys.get(city);
            if (loc == null) {
                System.out.println(city + "는 정보가 없는 도시");
            }else{
                System.out.println(loc);
            }
        }
    }

    public void run(){
        input();
        printAll();
        search();
        //인풋 1번, print 2번, 검색 3번으로 구현해볼 것
    }


}
