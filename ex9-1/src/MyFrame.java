import javax.swing.*; //JFrame
import java.awt.*; //Container

public class MyFrame extends JFrame{
    public MyFrame(){
        setTitle("첫번째 GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setBackground(Color.CYAN);
        //c.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 80));
        c.setLayout(new BorderLayout());

        c.add(new JButton("OK"), BorderLayout.CENTER);
        c.add(new JButton("취소"), BorderLayout.NORTH);
        c.add(new JButton("무시1"), BorderLayout.SOUTH);
        c.add(new JButton("무시2"), BorderLayout.EAST);
        c.add(new JButton("무시3"), BorderLayout.WEST);
        
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args){
        new MyFrame();
        System.out.println("메인 종료");
    }
}
