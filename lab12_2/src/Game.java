import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JFrame {
    public static void main(String[] args) {
        new Game();
    }
    class GamePanel extends JPanel {
        private JLabel baseLabel = new JLabel();
        private JLabel bulletLabel = new JLabel();
        private JLabel targetLabel;
        private TargetThread targetThread = null;

        public GamePanel() {
            setLayout(null);
            baseLabel.setSize(40,40);
            baseLabel.setOpaque(true); //불투명(Opaque): 컴포넌트가 완전히 불투명하여 아래에 있는 컴포넌트를 가린다
            baseLabel.setBackground(Color.BLACK);

            ImageIcon img = new ImageIcon("resources/images/target.png");
            targetLabel = new JLabel(img);
            targetLabel.setSize( img.getIconWidth(), img.getIconHeight());

            bulletLabel.setSize(10,10);
            bulletLabel.setOpaque(true);
            bulletLabel.setBackground(Color.RED);

            add(baseLabel);
            add(targetLabel);
            add(bulletLabel);
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    baseLabel.setFocusable(true);
                    baseLabel.requestFocus();
                }
            });
        }
        public void startGame() {
            baseLabel.setLocation( this.getWidth()/2 - baseLabel.getWidth()/2,
                    this.getHeight() - baseLabel.getHeight()
            );
            targetLabel.setLocation(0,0);

            targetThread = new TargetThread(targetLabel);
            targetThread.start();

            baseLabel.setFocusable(true);
            baseLabel.requestFocus();
            bulletLabel.setLocation(this.getWidth()/2 - bulletLabel.getWidth()/2,
                    this.getHeight() - baseLabel.getHeight() - bulletLabel.getHeight());

            baseLabel.addKeyListener(new KeyAdapter() {
                BulletThread bulletThread = null;
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyChar() =='\n') {
                        if(bulletThread ==null||!bulletThread.isAlive()) {
                            bulletThread=new BulletThread(bulletLabel,targetLabel,targetThread);
                            bulletThread.start();
                        }
                    }
                }
            });
        }

    }
    public Game() {
        super("사격게임");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GamePanel p = new GamePanel();
        setContentPane( p );
        setSize(300,300);
        setVisible(true);
        setResizable(false);
        p.startGame();
    }

    class TargetThread extends Thread{
        private JComponent target;
        public TargetThread(JComponent target) {
            this.target = target;
            target.setLocation(0,0);
            target.getParent().repaint();
        }

        @Override
        public void run() {
            while(true) {
                int x = target.getX() + 5;
                int y = target.getY();
                if(x > target.getParent().getWidth())
                    target.setLocation(0,0);
                else
                    target.setLocation(x,y);
                target.getParent().repaint();
                try {
                    sleep(20);
                } catch (InterruptedException e) {
                    // 명중한 경우
                    target.setLocation(0,0);
                    target.getParent().repaint();
                    try {
                        sleep(500);
                    } catch (InterruptedException ex) {
                    }

                }
            }
        }
    }

    class BulletThread extends Thread {
        private JComponent bullet, target;
        private Thread targetThread;

        public BulletThread(JComponent bullet, JComponent target, Thread targetThread) {
            this.bullet = bullet;
            this.target = target;
            this.targetThread = targetThread;
        }

        @Override
        public void run() {
            while (true) {
                if( hit() ) {
                    targetThread.interrupt();
                    bullet.setLocation(bullet.getParent().getWidth()/2 - bullet.getWidth()/2,
                            bullet.getParent().getHeight() - 40 - bullet.getHeight());
                    //baselabel
                    return;
                }

                int x = bullet.getX();
                int y = bullet.getY() -5; //위로 이동
                if(y < 0) {
                    bullet.setLocation(bullet.getParent().getWidth()/2 - bullet.getWidth()/2,
                            bullet.getParent().getHeight() - 40 - bullet.getHeight());
                    bullet.getParent().repaint();
                    return;
                } else {
                    bullet.setLocation(x,y);
                    bullet.getParent().repaint();
                }
                try {
                    sleep(10);
                } catch (InterruptedException e) {

                }
            }
        }
        private boolean targetContains(int x, int y) {
            int targetX = target.getX();
            int targetY = target.getY();
            int targetW = target.getWidth();
            int targetH = target.getHeight();
            if( (targetX <= x) && (targetX+targetW -1 >= x)
                    && (targetY <= y) && (targetY+targetH -1 >= y)
            )
                return true;
            else
                return false;
        }
        private boolean hit() {
            int x = bullet.getX();
            int y = bullet.getY();
            int w = bullet.getWidth();
            int h = bullet.getHeight();
            if( targetContains(x,y) || targetContains(x+w-1, y)
                    || targetContains( x+w-1, y+h-1) || targetContains( x, y+h-1)
            )
                return true;
            else
                return false;
        }
    }
}

