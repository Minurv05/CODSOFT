
package atminterface;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class UserAccount {

    int accBalance = 0;
}

public class AtmInterface extends JFrame implements ActionListener {

    JButton Withdrawbtn, Depositbtn, Checkbalbtn, withdrawb, depositb, checkbalanceb, back;
    JLabel l0, l1, l2, l3;
    JTextField t1, t2;
    UserAccount a = new UserAccount();
    JPanel info;

    AtmInterface() {
        l0 = new JLabel();
        l1 = new JLabel();
        l2 = new JLabel();
        l3 = new JLabel();

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        info = new JPanel();
        info.setLayout(null);
        back = new JButton("Back");
        Withdrawbtn = new JButton("WITHDRAW");
        Depositbtn = new JButton("DEPOSIT");
        Checkbalbtn = new JButton("CHECK BALANCE");
        withdrawb = new JButton("Withdraw");
        depositb = new JButton("Deposit");
        checkbalanceb = new JButton("Check");
        add(l0);
        l0.setBounds(100, 50, 300, 50);
        add(Depositbtn);
        Depositbtn.setBounds(100, 100, 300, 70);
        add(Withdrawbtn);
        Withdrawbtn.setBounds(100, 200, 300, 70);
        add(Checkbalbtn);
        Checkbalbtn.setBounds(100, 300, 300, 70);
        add(info);

        back.addActionListener(this);
        Withdrawbtn.addActionListener(this);
        Depositbtn.addActionListener(this);
        Checkbalbtn.addActionListener(this);
        withdrawb.addActionListener(this);
        depositb.addActionListener(this);
        checkbalanceb.addActionListener(this);

        info.setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        setSize(500, 500);
        l0.setText("SELECT WHAT YOU WAN TO DO: ");
        setBackground(Color.gray);
        info.setBounds(100, 100, 300, 300);
        info.setVisible(false);
        l0.setVisible(true);
        setTitle("ATM INTERFACE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l0.setFont(new Font("", Font.BOLD, 15));
    }

    void deposit() {

        Depositbtn.setVisible(false);
        Withdrawbtn.setVisible(false);
        Checkbalbtn.setVisible(false);
        info.setVisible(true);
        info.removeAll();
        l0.setText("DEPOSIT: ");
        add(l0);
        l0.setBounds(100, 50, 300, 50);
        l1.setText("Enter your deposit amount: ");
        info.add(l1);
        l1.setBounds(50, 10, 200, 50);
        info.add(t1);
        t1.setBounds(50, 60, 200, 50);
        info.add(depositb);
        depositb.setBounds(50, 110, 200, 50);
        info.add(back);
        back.setBounds(50, 210, 200, 50);
        info.revalidate();
        info.repaint();
    }

    void withdraw() {

        Depositbtn.setVisible(false);
        Withdrawbtn.setVisible(false);
        Checkbalbtn.setVisible(false);
        info.setVisible(true);
        info.removeAll();
        l0.setText("WITHDRAW: ");
        add(l0);
        l0.setBounds(100, 50, 300, 50);
        l1.setText("Enter your withdrawal amount: ");
        info.add(l1);
        l1.setBounds(50, 10, 200, 50);
        info.add(t2);
        t2.setBounds(50, 60, 200, 50);
        info.add(withdrawb);
        withdrawb.setBounds(50, 110, 200, 50);
        info.add(back);
        back.setBounds(50, 210, 200, 50);
        info.revalidate();
        info.repaint();
    }

    void checkBalance() {

        Depositbtn.setVisible(false);
        Withdrawbtn.setVisible(false);
        Checkbalbtn.setVisible(false);
        info.setVisible(true);
        info.removeAll();
        l1.setText("Your balanced amount: ");
        l0.setText("CURRENT BALANCE AMOUNT: ");
        add(l0);
        l0.setBounds(100, 50, 300, 50);
        info.add(l1);
        l1.setBounds(50, 10, 200, 50);
        info.add(l2);
        l2.setBounds(50, 110, 200, 50);
        info.add(checkbalanceb);
        checkbalanceb.setBounds(50, 60, 200, 50);
        info.add(back);
        back.setBounds(50, 210, 200, 50);
        info.revalidate();
        info.repaint();

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Withdrawbtn) {
            withdraw();
        } else if (e.getSource() == Depositbtn) {
            deposit();
        } else if (e.getSource() == Checkbalbtn) {
            checkBalance();
        } else if (e.getSource() == withdrawb) {
            int withdraw = Integer.parseInt(t2.getText());

            if (withdraw > a.accBalance) {
                JOptionPane.showMessageDialog(this, "Insufficient balance!!! Your account has " + a.accBalance + " rupee(s).");
            } else {
                a.accBalance -= withdraw;
                info.add(l3);
                l3.setBounds(50, 160, 200, 50);
                l3.setText("Your withdrawn amount is: " + withdraw);
                JOptionPane.showMessageDialog(this, "Your account has " + a.accBalance + " rupee(s).");
                info.revalidate();
                info.repaint();
            }

        } else if (e.getSource() == depositb) {
            int deposit = Integer.parseInt(t1.getText());
            a.accBalance += deposit;
            info.add(l3);
            l3.setBounds(50, 160, 200, 50);
            l3.setText("Your deposited amount is: " + deposit);
            JOptionPane.showMessageDialog(this, "Your account has " + a.accBalance + " rupee(s).");
            info.revalidate();
            info.repaint();
        } else if (e.getSource() == back) {
            Withdrawbtn.setVisible(true);
            Depositbtn.setVisible(true);
            Checkbalbtn.setVisible(true);
            l0.setText("SELECT WHAT YOU WAN TO DO: ");
            l0.setVisible(true);
            info.setVisible(false);

        } else {
            int bal = a.accBalance;
            l2.setFont(new Font("", Font.BOLD, 25));
            l2.setText(String.valueOf("Amount: " + bal));

        }

    }

    public static void main(String[] args) {
        new AtmInterface();

    }
}
