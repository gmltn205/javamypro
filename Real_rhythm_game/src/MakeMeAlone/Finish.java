package MakeMeAlone;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Finish {
    public static void showPopup(int score) {
        JFrame frame = new JFrame("게임 종료");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        if(score> 100000) {
        	JLabel label = new JLabel("당신 좀 치는군요? 당신의 점수는 : " + score);
        	panel.add(label);
        }else if(score <=100000 && score >50000) {
        	JLabel label = new JLabel("적당히 좀 하시네요~ 당신의 점수는 : " + score);
        	panel.add(label);
        }else if(score <= 50000) {
        	JLabel label = new JLabel("혹시 게임 켜놓고 숨만 쉬셨나요? 당신의 점수는: " + score);
        	panel.add(label);
}
        
        
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
