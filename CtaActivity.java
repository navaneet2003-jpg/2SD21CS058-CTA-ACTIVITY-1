package sdmcet.cse.oops;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

class Grade extends JFrame implements ActionListener {
	JFrame f;
	JButton b;
	Container contentPane;
	JPanel p;
	JLabel l, l1, l2, l3, l4, l5, l7, l8, l9, l10, l11;
	JTextField t1, t2, t3, t4, t5;

	Grade(String title) {
		super(title);

		b = new JButton("             CALCULATE            ");
		b.addActionListener(this);
		b.setBackground(Color.PINK);

		l = new JLabel("                          Grade Calculator ");
		l.setForeground(Color.BLACK);
		l1 = new JLabel("Enter IA1 Marks:");
		l1.setForeground(Color.BLUE);
		l2 = new JLabel("Enter IA2 Marks:");
		l2.setForeground(Color.BLUE);
		l3 = new JLabel("Enter IA3 Marks:");
		l3.setForeground(Color.BLUE);
		l4 = new JLabel("Enter CTA Marks:");
		l4.setForeground(Color.BLUE);
		l5 = new JLabel("Enter SEE Marks:");
		l5.setForeground(Color.BLUE);
		l7 = new JLabel();
		l7.setForeground(Color.BLACK);
		l8 = new JLabel();
		l8.setForeground(Color.BLACK);

		t1 = new JTextField(15);
		t2 = new JTextField(15);
		t3 = new JTextField(15);
		t4 = new JTextField(15);
		t5 = new JTextField(15);
		p = new JPanel();

		p.add(l);

		p.add(l1);
		p.add(t1);
		p.add(l2);
		p.add(t2);
		p.add(l3);
		p.add(t3);
		p.add(l4);
		p.add(t4);
		p.add(l5);
		p.add(t5);
		add(p);
		p.add(l7);
		p.add(l8);
		p.add(b);

		contentPane = this.getContentPane(); // Instantiate content pane
		contentPane.add(p, BorderLayout.CENTER);
		contentPane.add(l, BorderLayout.NORTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b) {

			int ia1, ia2, ia3, cta, r;
			double see;

			if (t1.getText().isEmpty() || t1.getText().equalsIgnoreCase("ab")) {
				ia1 = 0;
			} else
				ia1 = Integer.parseInt(t1.getText());

			if (t2.getText().isEmpty() || t2.getText().equalsIgnoreCase("ab")) {
				ia2 = 0;
			} else
				ia2 = Integer.parseInt(t2.getText());
			if (t3.getText().isEmpty() || t3.getText().equalsIgnoreCase("ab")) {
				ia3 = 0;
			} else
				ia3 = Integer.parseInt(t3.getText());

			if (t4.getText().isEmpty()) {
				cta = 0;
			} else
				cta = Integer.parseInt(t4.getText());

			if (t5.getText().isEmpty() || t5.getText().equalsIgnoreCase("ab")) {
				see = 0;
			} else
				see = Double.parseDouble(t5.getText());

			try {
				if (ia1 < 0 || ia1 > 20 || ia2 < 0 || ia2 > 20 || ia3 < 0 || ia3 > 20) {
					throw new ArithmeticException();
				}
			} catch (ArithmeticException ae) {
				JOptionPane.showMessageDialog(f, l9, "IA Marks entered should be in range 0-20",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				if (cta < 0 || cta > 10) {
					throw new ArithmeticException();
				}
			} catch (ArithmeticException ae) {
				JOptionPane.showMessageDialog(f, l10, "error: CTA range should be in 0-10", JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				if (see < 0 || see > 100) {
					throw new ArithmeticException();
				}
			} catch (ArithmeticException ae) {
				JOptionPane.showMessageDialog(f, l11, "error: SEE range should be in 0-100", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (see < 38) {
				JOptionPane.showMessageDialog(this, "STUDENT HAS FAILED IN SEE AND OBTAINED GRADE IS F", "message",
						JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}

			see = Math.ceil(see / 2);

			if (ia2 >= ia1 && ia3 >= ia1) {
				r = ia2 + ia3 + cta;
			} else if (ia1 >= ia2 && ia3 >= ia2) {
				r = ia1 + ia3 + cta;
			} else {
				r = ia1 + ia2 + cta;
			}

			if (r < 20) {
				JOptionPane.showMessageDialog(this, "Student is Detained from taking SEE", "message",
						JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
				;

			}

			r += see;

			String g;

			if (r <= 100 && r >= 90)
				g = "S";

			else if (r < 90 && r >= 80)
				g = "A";

			else if (r < 80 && r >= 70)
				g = "B";

			else if (r < 70 && r >= 60)
				g = "C";

			else if (r < 60 && r >= 50)
				g = "D";
			else if (r < 50 && r >= 40)
				g = "E";
			else
				g = "F";

			l7.setText("Total Marks: " + r + "                ");

			l8.setText("Grade: " + g);

		}
	}

}

public class CtaActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new Grade("Student Grading System");

		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setBounds(200, 200, 350, 400);
		f.setResizable(false);
		f.setVisible(true);
	}

}
