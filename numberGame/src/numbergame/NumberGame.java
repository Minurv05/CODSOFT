package numbergame;

import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class NumberGame extends JFrame implements ActionListener {

    Random r = new Random();
    int min = 1;
    int max = 100;
    int guessNum = r.nextInt(max - min + 1) + min;
    JLabel l1, l2, l3, l4;
    JTextField t1;
    JButton submit, restart, clear,hint;
    int guessedNum;
    int attempt = 0;
    int attempt2=0;
    int maxAttempt = 5;
    int score = 0;
    int difference;

    NumberGame() {
        l1 = new JLabel("Try to guess the num between 1 to 100! (You have  max. 5 attempt)");
        t1 = new JTextField(20);
        l2 = new JLabel();
        l3 = new JLabel();
        l4 = new JLabel();
        submit = new JButton("Submit");
        restart = new JButton("Restart");
        clear = new JButton("clear");
        hint = new JButton("Hint");
        restart.addActionListener(this);
        submit.addActionListener(this);
        clear.addActionListener(this);
        hint.addActionListener(this);
        
        l1.setBounds(100, 50, 400, 50);
        add(l1);
        t1.setBounds(150, 100, 300, 50);
        add(t1);
        hint.setBounds(500,100,100,50);
        add(hint);
        l2.setBounds(150, 150, 200, 50);
        add(l2);
        submit.setBounds(150, 200, 100, 50);
        add(submit);
        restart.setBounds(250, 200, 100, 50);
        add(restart);
        clear.setBounds(350, 200, 100, 50);
        add(clear);
        l3.setBounds(150, 250, 200, 50);
        add(l3);
        l4.setBounds(150, 300, 300, 50);
        add(l4);

        setLayout(null);
        setSize(700, 500);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {
            if (attempt < maxAttempt) {
                guessedNum = Integer.parseInt(t1.getText());
                attempt++;

                if (guessNum == guessedNum) {
                    
                    l2.setText("Actual Number: " + guessNum);
                    
                    score++;
                    attempt2++;
                    
                    JOptionPane.showMessageDialog(this,"CONGRATULATIONS!!!! YOU WON* "+ "\nYOUR SCORE IS: " + score + "\n Number of attempt: " + attempt2, "info", JOptionPane.INFORMATION_MESSAGE);

                } else {

                    l3.setText("You guessed " + guessedNum + " a wrong number.");
                    l4.setText(" Attempt: " + attempt);
                    difference = Math.abs(guessNum - guessedNum);
                    if (difference <= 5) {
                        l2.setText("Very Close! You're almost there.");
                    } else if (difference <= 10) {
                        l2.setText("Close! Try adjusting your guess.");
                    } else {
                        l2.setText("Not close, try a different range.");
                    }

                }

                if (attempt == maxAttempt) {
                    l3.setText("GAME OVER, Restart the GAME!");
                    l2.setText("Actual Number: " + guessNum);
                    l4.setText("Total number of attempts : "+attempt2);
                    submit.setEnabled(false);
                }

            }

        } else if (e.getSource() == restart) {
            r = new Random();
            guessNum = r.nextInt(max - min + 1) + min;
            attempt = 0;
            attempt2++;
            t1.setText("");
            l2.setText("");
            l3.setText("");
            l4.setText("");
            submit.setEnabled(true);

        } else if(e.getSource()== hint){
            if(guessNum >=1 && guessNum<=10){
                l2.setText("Try a number between 1-10!");
            }else if(guessNum >=11 && guessNum<=20){
                l2.setText("Try a number between 11-20!");
            }else if(guessNum >=21 && guessNum<=30){
                l2.setText("Try a number between 21-30!");
            }else if(guessNum >=31 && guessNum<=40){
                l2.setText("Try a number between 31-40!");
            }else if(guessNum >=41 && guessNum<=50){
                l2.setText("Try a number between 41-50!");
            }else if(guessNum >=51 && guessNum<=60){
                l2.setText("Try a number between 51-60!");
            }else if(guessNum >=61 && guessNum<=70){
                l2.setText("Try a number between 61-70!");
            }else if(guessNum >=71 && guessNum<=80){
                l2.setText("Try a number between 71-80!");
            }else if(guessNum >=81 && guessNum<=90){
                l2.setText("Try a number between 81-90!");
            }else{
                 l2.setText("Try a number between 91-100!");
            }
            
        }else {

            t1.requestFocus();
            l2.setText("");
            l3.setText("");
            l4.setText("");

        }

    }

    public static void main(String[] args) {
        NumberGame obj = new NumberGame();
        obj.setTitle("NUMBER GAME");

    }

}
