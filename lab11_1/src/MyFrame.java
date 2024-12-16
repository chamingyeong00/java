import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    private int[]  units = {50000, 10000, 1000, 500, 100, 50, 10, 1};
    private String[] nameOfUnits = {"오만원", "만원", "천원", "오백원", "백원",
            "오십원", "십원", "일원"};
    private JTextField source;
    private JTextField[] outputTFs = new JTextField[8];
    
    public MyFrame(){
        super("돈 환전기");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        JPanel inputPanel = new JPanel(new GridLayout(1, 3));
        inputPanel.add(new JLabel("금액"));
        source = new JTextField();
        inputPanel.add(source);
        JButton btn = new JButton("계산");
        inputPanel.add(btn);

        JPanel outputPanel = new JPanel(new GridLayout(8, 2));
        for (int i=0; i<units.length; i++){
            outputPanel.add(new JLabel(nameOfUnits[i]));
            outputTFs[i] = new JTextField();
            outputTFs[i].setHorizontalAlignment(JTextField.CENTER);
            outputPanel.add(outputTFs[i]);
        }

        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(outputPanel, BorderLayout.CENTER);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String value = source.getText();
                try{
                    int money = Integer.parseInt(value);
                    int res;
                    for (int i = 0 ; i<units.length; i++){
                        res = money/units[i];
                        outputTFs[i].setText(res+"");//res 정수를 문자열로 변환하려고 "" 추가
                        money = money % units[i];
                    }
                }catch(NumberFormatException ex){
                }
                source.setText(""); //금액 텍스트 초기화
            }
        });
        //람다 {} 함수 바디
        /*btn.addActionListener(e -> {
                String value = source.getText();
                try{
                    int money = Integer.parseInt(value);
                    int res;
                    for (int i = 0 ; i<units.length; i++){
                        res = money/units[i];
                        outputTFs[i].setText(res+"");
                        money = money % units[i];
                    }
                }catch(NumberFormatException ex){

                }
                source.setText("");
            }
        });*/

        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }

}