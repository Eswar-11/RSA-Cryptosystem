package rough;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class RSATest extends RSAGenerator {
  public static void main(String[] args) throws Exception{
	  RSAGenerator rsa_gen = new RSAGenerator(1024);
	  Scanner sc=new Scanner(System.in);
	  JFrame f = new JFrame("Encryption");
	  
	  JFrame f1 = new JFrame("Decryption");

		JLabel l1, l2, l3,l11,l22,l33;

		JTextField t1, t2, t3,t4,t11,t22,t33,t44;

		JButton b1, b2, b3,b11,b33;

		l1 = new JLabel("Enter the message");

		l1.setBounds(270, 50, 300, 50);
		
		l1.setFont(new Font("TimesNewRoman", Font.BOLD, 15));
		
		l11 = new JLabel("Enter Cipher text");

		l11.setBounds(270, 50, 300, 50);
		
		l11.setFont(new Font("TimesNewRoman", Font.BOLD, 15));

		l2 = new JLabel("Encrypted message");

		l2.setBounds(270, 200, 300, 50);
		
		l2.setFont(new Font("TimesNewRoman", Font.BOLD, 15));
		
		l22 = new JLabel("Enter private keys(d,n)");

		l22.setBounds(270, 150, 300, 50);
		
		l22.setFont(new Font("TimesNewRoman", Font.BOLD, 15));
		
		l3 = new JLabel("Private keys(d,n)");

		l3.setBounds(270, 300, 300, 50);
		
		l3.setFont(new Font("TimesNewRoman", Font.BOLD, 15));
		
		l33 = new JLabel("Plain text");

		l33.setBounds(290, 300, 300, 50);
		
		l33.setFont(new Font("TimesNewRoman", Font.BOLD, 15));

		t1 = new JTextField();

		t1.setBounds(150, 100, 350, 30);
		
		t11 = new JTextField();

		t11.setBounds(150, 100, 350, 30);

		t2 = new JTextField();

		t2.setBounds(150, 250, 350, 30);
		
		t22 = new JTextField();

		t22.setBounds(30, 200, 300, 30);
		
		t44 = new JTextField();

		t44.setBounds(340, 200, 300, 30);
		
		t3 = new JTextField();

		t3.setBounds(30, 350, 300, 30);
		 
		t4 = new JTextField();

		t4.setBounds(340, 350, 300, 30);
		
		t33 = new JTextField();

		t33.setBounds(150, 350, 350, 30);

		b1 = new JButton("Encrypt");

		b1.setBounds(250, 150, 150, 30);
		
		b11 = new JButton("Decrypt");

		b11.setBounds(250, 260, 150, 30);

		b3 = new JButton("close");

		b3.setBounds(270, 400, 100, 30);
		
		b33 = new JButton("close");

		b33.setBounds(270, 400, 100, 30);

		b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)

			{
			String d = t1.getText();
			String encrypted = rsa_gen.encrypt(d).toString();
			t2.setText(encrypted);
			t3.setText(rsa_gen.toString1());t4.setText(rsa_gen.toString2());
			t11.setText(encrypted);
			}

			});
		b11.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
			String mn = t11.getText(); String md = t22.getText(); String nn = t44.getText();
			BigInteger dd= new BigInteger(md); BigInteger n= new BigInteger(nn);
			BigInteger decrypt = rsa_gen.decrypt(new BigInteger(mn), dd,n);
			String decrypted = "";
			for(byte b: decrypt.toByteArray()){
			     decrypted += (char) b;
			}
            t33.setText(decrypted);
			}

			});
		b3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)

		{

		f.dispose();

		}

		});
		b33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)

			{

			f1.dispose();

			}

			});

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.add(l1);

		f.add(t1);

		f.add(l2);

		f.add(t2);
		
		f.add(l3);
		
		f.add(t3);
		
		f.add(t4);

		f.add(b1);

		f.add(b3);

		f.setLayout(null);

		f.setSize(750, 550);

		f.setVisible(true);
		
		f1.add(l11);

		f1.add(t11);

		f1.add(l22);

		f1.add(t22);
		
		f1.add(t44);
		
		f1.add(l33);
		
		f1.add(t33);

		f1.add(b11);

		f1.add(b33);

		f1.setLayout(null);

		f1.setSize(750, 550);

		f1.setVisible(true);

		}

	}
