import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyFrame extends JFrame {
    private JTextArea inputArea = new JTextArea(5, 10);
    private JSlider slider = new JSlider(0, 100, 0);

    public MyFrame(){
        super("실습3");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.add(new JScrollPane(inputArea), BorderLayout.CENTER);
        contentPane.add(slider, BorderLayout.SOUTH);

        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);

        inputArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int size = inputArea.getText().length();
                if (size >= 100) {
                    try {
                        inputArea.setText(inputArea.getText(0, 100));
                    } catch (BadLocationException ex) {
                        //문자열을 조작할 때 잘못된 위치에 접근하려고 하면 발생하는 예외
                    }
                    size = 100;
                }
                slider.setValue(size);
            }
        });

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (inputArea.getText().length() <= slider.getValue())
                    slider.setValue(inputArea.getText().length());
                else {
                    try {
                        inputArea.setText(inputArea.getText(0, slider.getValue()));
                    } catch (BadLocationException ex) {
                    }
                }
            }
        });
        setSize(300, 300);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MyFrame();
    }
}