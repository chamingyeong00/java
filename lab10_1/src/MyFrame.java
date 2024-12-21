import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.EventObject;

public class MyFrame extends JFrame{
    public MyFrame(){
        setTitle("Left 키로 문자열 이동");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel jLabel = new JLabel("Love Java");
        c.add(jLabel);
        jLabel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    JLabel jLabel1 = (JLabel) e.getSource();
                    String text = jLabel1.getText();
                    String first = text.substring(0, 1);
                    String remain = text.substring(1);
                    jLabel1.setText(remain + first);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    JLabel jLabel1 = (JLabel) e.getSource();
                    String text = jLabel1.getText();
                    String last = text.substring(text.length() - 1);
                    String remain = text.substring(0, text.length() - 1);
                    jLabel1.setText(last + remain);
                }
            }
        });
        setSize(300, 100);
        setVisible(true);
        jLabel.setFocusable(true); //포커스를 받을 수 있는지 여부 설정
        jLabel.requestFocus(); //해당 컴포넌트에 포커스를 강제로 설정
    }
    public static void main(String[] args) {
        new MyFrame();
    }
}

