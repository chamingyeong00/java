import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
    public MyFrame(){
        super("두번째 GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        JLabel la = new JLabel("배치관리자 테스트");
        la.setSize(150, 25);
        la.setLocation(130, 50);
        c.add(la);

        for(int i=1; i<=9; i++){
            JButton btn = new JButton(i+"");
            btn.setLocation(i*15, i*15);
            btn.setSize(50, 20);
            c.add(btn);
        }

        setSize(300, 300);
        setVisible(true);
    }
    public static void main(String[] args){
        new MyFrame();
    }
}
