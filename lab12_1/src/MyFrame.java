import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyFrame extends JFrame {
    class MyPanel extends JPanel implements Runnable{
        private int x = 100;
        private int y = 100;

        public MyPanel(){
            this.addMouseListener(new MouseAdapter() {
                private Thread th = null;
                public void mousePressed(MouseEvent e){
                    if (th == null){
                        th = new Thread(MyPanel.this);
                        th.start();
                    }
                }
            });
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.CYAN);
            //g.drawOval(x, y, 50, 50);
            g.fillOval(x, y, 50, 50);
        }

        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(500);//0.5초
                } catch (InterruptedException e) {
                    return;
                }
                x = (int)(Math.random()*this.getWidth());
                y = (int)(Math.random()*this.getHeight());
                repaint();
            }
        }
    }

    public MyFrame(){
        super("그래픽/스레드 테스트");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        Container c = getContentPane();
        c.add(new JLabel("테스트용!!"));
        c.add(new JButton("버튼!!!"));

        setSize(200, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}