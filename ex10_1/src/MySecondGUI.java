import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
new MySecondGUI implemts ActionListener
 */

public class MySecondGUI extends JFrame {
    private JLabel la = new JLabel("Hello");

    public MySecondGUI(){
        super("이벤트 처리 예제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        c.add(btn);
        btn.addActionListener( //사용자가 클릭 동작을 완료했을 때
                new ActionListener(){ //익명 클래스
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton)e.getSource();
                if(btn.getText().equals("Action")) {
                    btn.setText("액션");
                    //MySecondGUI.this.setTitle("액션이지롱.");
                    setTitle("액션이지롱.");
                }
                else {
                    btn.setText("Action");
                    MySecondGUI.this.setTitle("Action...");
                }
            }
        }
        );

        c.setLayout(null);
        la.setSize(50, 20);
        la.setLocation(30, 30);
        c.add(la);
        c.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                la.setLocation(x, y);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        setSize(300, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MySecondGUI();
    }
}