import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.Key;
import java.util.EventObject;
import java.util.Map;

public class MyFrame extends JFrame{
    private int score = 0 ;
    private JLabel scoreLabel;

    public MyFrame(){
        super("클릭 연습 용 응용프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        scoreLabel = new JLabel("점수:0");
        scoreLabel.setSize(80, 20);
        scoreLabel.setLocation(10, 10);
        c.add(scoreLabel);

        JLabel target = new JLabel("C");
        target.setSize(20, 20);
        target.setLocation(100, 100);;
        c.add(target);

        target.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JLabel jLabel = (JLabel) e.getSource();
                Container c = jLabel.getParent();
                int xBound = c.getWidth() - jLabel.getWidth();
                int yBound = c.getHeight() - jLabel.getHeight();
                int x = (int)(Math.random() * xBound);
                int y = (int)(Math.random() * yBound);
                jLabel.setLocation(x, y);
                score += 10;
                scoreLabel.setText("점수:" + score);
            }
        });
        setSize(300, 300);;
        setVisible(true);
    }
    public static void main(String[] args) {
        new MyFrame();
    }
}