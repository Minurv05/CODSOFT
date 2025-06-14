package studentgradecalculator;

import java.util.*;
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class StudentGradeCalculator extends JFrame implements ActionListener {

    ArrayList<Integer> marks = new ArrayList<>();

    JLabel l0, l1, l2, l3, l4, l5, l6, tt, result;
    JTextField t1, t2, t3, t4, t5, t6;
    JButton generate, viewAnother;
    double Percent;
    int total = 0;

    String grade;

    String[] subject = {"English", "Maths", "Hindi", "Science", "Social Science", "Geography"};

    StudentGradeCalculator() {

        l1 = new JLabel("Enter marks of " + subject[0] + " : ");
        l2 = new JLabel("Enter marks of " + subject[1] + " : ");
        l3 = new JLabel("Enter marks of " + subject[2] + " : ");
        l4 = new JLabel("Enter marks of " + subject[3] + " : ");
        l5 = new JLabel("Enter marks of " + subject[4] + " : ");
        l6 = new JLabel("Enter marks of " + subject[5] + " : ");
        l0 = new JLabel("!!Generate your Grade!!");
        tt = new JLabel();
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);
        t5 = new JTextField(10);
        t6 = new JTextField(10);
        result = new JLabel();

        generate = new JButton("Submit");
        generate.addActionListener(this);
        viewAnother = new JButton("View Another Grade");
        viewAnother.addActionListener(this);
        add(l0);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l5);
        add(t5);
        add(l6);
        add(t6);
        add(generate);
        add(tt);
        add(result);
        add(viewAnother);
        l0.setBounds(230, 0, 300, 100);

        l1.setBounds(100, 100, 200, 50);
        t1.setBounds(100, 150, 200, 50);
        l2.setBounds(400, 100, 200, 50);
        t2.setBounds(400, 150, 200, 50);
        l3.setBounds(100, 200, 200, 50);
        t3.setBounds(100, 250, 200, 50);
        l4.setBounds(400, 200, 200, 50);
        t4.setBounds(400, 250, 200, 50);
        l5.setBounds(100, 300, 200, 50);
        t5.setBounds(100, 350, 200, 50);
        l6.setBounds(400, 300, 200, 50);
        t6.setBounds(400, 350, 200, 50);
        tt.setBounds(200, 450, 300, 50);
        tt.setFont(new Font("", Font.BOLD, 18));
        result.setBounds(200, 500, 300, 50);
        result.setFont(new Font("", Font.BOLD, 18));
        generate.setBounds(100, 600, 200, 50);
        generate.setFont(new Font("", Font.BOLD, 15));
        viewAnother.setBounds(400, 600, 200, 50);
        viewAnother.setFont(new Font("", Font.BOLD, 15));
        l0.setFont(new Font("Arial", Font.ITALIC, 25));

        setLayout(null);
        setVisible(true);
        setSize(700, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inputText();
    }

    void font() {
        JLabel[] l = {l1, l2, l3, l4, l5, l6};

        for (JLabel ls : l) {
            ls.setFont(new Font("Arial", Font.PLAIN, 15));
        }
    }

    void font2() {
        JTextField[] l2 = {t1, t2, t3, t4, t5, t6};

        for (JTextField ls2 : l2) {
            ls2.setFont(new Font("", Font.PLAIN, 18));
        }
    }

    void inputText() {
        JTextField[] tf = {t1, t2, t3, t4, t5, t6};

        for (JTextField t : tf) {
            t.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isDigit(c) || t.getText().length() >= 2) {
                        e.consume();
                    }
                }
            });
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == generate) {

            marks.clear();
            marks.add(Integer.parseInt(t1.getText()));
            marks.add(Integer.parseInt(t2.getText()));
            marks.add(Integer.parseInt(t3.getText()));
            marks.add(Integer.parseInt(t4.getText()));
            marks.add(Integer.parseInt(t5.getText()));
            marks.add(Integer.parseInt(t6.getText()));

            for (int i = 0; i < marks.size(); i++) {
                total += marks.get(i);

            }

            tt.setText("TOTAL MARKS: " + total);
            Percent = ((double) total / 600) * 100;

            result.setText(String.format("PERCENTAGE:  %.2f%%", Percent));

            if (Percent >= 80 && Percent < 100) {
                grade = "A";
                JOptionPane.showMessageDialog(this, "Your GRADE: " + grade + " grade.", "info", JOptionPane.INFORMATION_MESSAGE);
            } else if (Percent >= 65 && Percent < 79) {
                grade = "B";
                JOptionPane.showMessageDialog(this, "Your GRADE: " + grade + " grade.", "info", JOptionPane.INFORMATION_MESSAGE);
            } else if (Percent >= 55 && Percent < 64) {
                grade = "C";
                JOptionPane.showMessageDialog(this, "Your GRADE: " + grade + " grade.", "info", JOptionPane.INFORMATION_MESSAGE);
            } else if (Percent >= 50 && Percent < 54) {
                grade = "D";
                JOptionPane.showMessageDialog(this, "Your GRADE: " + grade + " grade.", "info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                grade = "E";
                JOptionPane.showMessageDialog(this, "Your GRADE: " + grade + " grade.", "info", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {

            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");

            marks.clear();
            total = 0;
            tt.setText("");
            result.setText("");

        }

    }

    public static void main(String[] args) {
        StudentGradeCalculator obj = new StudentGradeCalculator();
        obj.inputText();
        obj.font();
        obj.font2();
        obj.setTitle("Grade Calculator");

    }

}
