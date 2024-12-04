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

        jLabel.setFont(new Font("TimesRoman",
                Font.BOLD | Font.ITALIC, 10));
        jLabel.setBackground(Color.MAGENTA);


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
                } else if(e.getKeyChar() == '+' || e.getKeyCode() == KeyEvent.VK_UP){
                    JLabel jLabel1 = (JLabel) e.getSource();
                    Font f = jLabel1.getFont();
                    int size = f.getSize();
                    jLabel1.setFont(new Font(f.getFontName(), f.getStyle(), size+5));
                } else if(e.getKeyChar() == '-' || e.getKeyCode() == KeyEvent.VK_DOWN){
                    JLabel jLabel1 = (JLabel) e.getSource();
                    Font f = jLabel1.getFont();
                    int size = f.getSize();
                    if (size -5 < 5)
                        return;
                    jLabel1.setFont(new Font(f.getFontName(), f.getStyle(), size-5));
                }
            }
        });
        setSize(300, 100);
        setVisible(true);
        jLabel.setFocusable(true);
        jLabel.requestFocus();
    }
    public static void main(String[] args) {
        new MyFrame();
    }
}

/*
    JLabel la = new JLabel("Love Java");
    la.setFont(new Font("Arial",Font.PLAIN, 10));
    Font f = la.getFont();
    int size = f.getSize();
    la.setFont(new Font("Arial", FOnt.PLAIN, size +5));
*/