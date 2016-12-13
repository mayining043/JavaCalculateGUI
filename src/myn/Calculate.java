package myn;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
/**
 * java������
 * @author mayin
 *
 */
public class Calculate extends JFrame {
	private String front = "", behind = ""; // ��¼�Ӽ��˳������֮ǰ,֮�����������
	private String op; // ��¼�����
	private String re;// �洢���������ַ�����ʽ
	private boolean flag = false; // ��¼�Ƿ����������
	private boolean flag1 = false;// �ж��Ƿ������˵������
	private double result;// �洢������
	private boolean flag2 = false;// �ж��Ƿ�����������
	private boolean flag3 = false;// �ж��Ƿ����˵Ⱥ������
	JPanel contentPane;
	JTextField txtResult = new JTextField("0");
	JButton btnNull = new JButton("sqrt");
	JButton btnFour = new JButton("4");
	JButton btnFive = new JButton("5");
	JButton btnSix = new JButton("6");
	JButton btnDecrease = new JButton("-");
	JButton btnBegin = new JButton("C");
	JButton btnOne = new JButton("1");
	JButton btnTwo = new JButton("2");
	JButton btnThree = new JButton("3");
	JButton btnMultiply = new JButton("*");
	JButton btnCancel = new JButton("��");
	JButton btnZero = new JButton("0");
	JButton btnMinus = new JButton("+/-");
	JButton btnPoint = new JButton(".");
	JButton btnDivide = new JButton("/");
	JButton btnEqual = new JButton("=");
	JButton btnIncrease = new JButton("+");
	JButton btnSeven = new JButton("7");
	JButton btnEight = new JButton("8");
	JButton btnNine = new JButton("9");

	
	public static void main(String[] args) {
		Calculate fc = new Calculate();
		fc.setSize(700,600);
		fc.setLocation(200, 150);
		fc.setResizable(false);
		fc.setVisible(true);
	 }
    

	
	public Calculate() {
		getContentPane().setForeground(new Color(105, 105, 105));
		getContentPane().setBackground(SystemColor.windowBorder);
		setTitle("\u8BA1\u7B97\u5668calc");
		try {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			init();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
/**
 * ��Ⱦ����
 * @throws Exception
 */
	private void init() throws Exception {
		//����div
		contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);
		txtResult.setForeground(SystemColor.activeCaption);
		//�����������
		txtResult.setEnabled(false);
		txtResult.setFont(new Font("�������ټ���Ӵְ�", Font.BOLD, 40));
		txtResult.setEditable(false);
		txtResult.setHorizontalAlignment(SwingConstants.RIGHT);
		txtResult.setBounds(new Rectangle(33, 96, 620, 63));
		btnNull.setForeground(SystemColor.windowBorder);
		//���ذ�ť
		btnNull.setBounds(new Rectangle(541, 174, 112, 72));
		btnNull.setFont(new Font("����ǻ������ڼ�2.0", Font.BOLD, 28));
		btnFour.setForeground(SystemColor.windowBorder);
		btnFour.setBounds(new Rectangle(33, 269, 112, 72));
		btnFour.setFont(new Font("����ǻ������ڼ�2.0", Font.BOLD, 40));
		btnFive.setForeground(SystemColor.windowBorder);
		btnFive.setBounds(new Rectangle(160, 269, 112, 72));
		btnFive.setFont(new Font("����ǻ������ڼ�2.0", Font.BOLD, 40));
		btnSix.setForeground(SystemColor.windowBorder);
		btnSix.setBounds(new Rectangle(287, 269, 112, 72));
		btnSix.setFont(new Font("����ǻ������ڼ�2.0", Font.BOLD, 40));
		btnDecrease.setForeground(SystemColor.windowBorder);
		btnDecrease.setBounds(new Rectangle(414, 269, 112, 72));
		btnDecrease.setFont(new Font("����ǻ������ڼ�2.0", Font.BOLD, 40));
		btnBegin.setForeground(SystemColor.windowBorder);
		btnBegin.setBounds(new Rectangle(541, 269, 112, 72));
		btnBegin.setFont(new Font("����ǻ������ڼ�2.0", Font.BOLD, 40));
		btnBegin.addActionListener(new Calculate_btnBegin_actionAdapter(this));
		btnOne.setForeground(SystemColor.windowBorder);
		btnOne.setBounds(new Rectangle(33, 356, 112, 72));
		btnOne.setFont(new Font("����ǻ������ڼ�2.0", Font.BOLD, 40));
		btnTwo.setForeground(SystemColor.windowBorder);
		btnTwo.setBounds(new Rectangle(160, 356, 112, 72));
		btnTwo.setFont(new Font("����ǻ������ڼ�2.0", Font.BOLD, 40));
		btnThree.setForeground(SystemColor.windowBorder);
		btnThree.setBounds(new Rectangle(287, 356, 112, 72));
		btnThree.setFont(new Font("����ǻ������ڼ�2.0", Font.BOLD, 40));
		btnMultiply.setForeground(SystemColor.windowBorder);
		btnMultiply.setBounds(new Rectangle(414, 356, 112, 72));
		btnMultiply.setFont(new Font("����ǻ������ڼ�2.0", Font.BOLD, 40));
		btnCancel.setForeground(SystemColor.windowBorder);
		btnCancel.setBounds(new Rectangle(541, 356, 112, 72));
		btnCancel.setFont(new Font("����ǻ������ڼ�2.0", Font.BOLD, 40));
		btnCancel.addActionListener(new Calculate_btnCancel_actionAdapter(this));
		btnZero.setForeground(SystemColor.windowBorder);
		btnZero.setBounds(new Rectangle(33, 443, 112, 72));
		btnZero.setFont(new Font("����ǻ������ڼ�2.0", Font.BOLD, 40));
		// ��������0-9�ļ����¼�
		btnZero.addActionListener(new Calculate_btnZero_actionAdapter(this));
		btnOne.addActionListener(new Calculate_btnZero_actionAdapter(this));
		btnTwo.addActionListener(new Calculate_btnZero_actionAdapter(this));
		btnThree.addActionListener(new Calculate_btnZero_actionAdapter(this));
		btnFour.addActionListener(new Calculate_btnZero_actionAdapter(this));
		btnFive.addActionListener(new Calculate_btnZero_actionAdapter(this));
		btnSix.addActionListener(new Calculate_btnZero_actionAdapter(this));
		btnSeven.setForeground(SystemColor.windowBorder);
		btnSeven.addActionListener(new Calculate_btnZero_actionAdapter(this));
		btnEight.setForeground(SystemColor.windowBorder);
		btnEight.addActionListener(new Calculate_btnZero_actionAdapter(this));
		btnNine.setForeground(SystemColor.windowBorder);
		btnNine.addActionListener(new Calculate_btnZero_actionAdapter(this));
		btnMinus.setForeground(SystemColor.windowBorder);
		btnMinus.setBounds(new Rectangle(160, 443, 112, 72));
		btnMinus.setFont(new Font("����ǻ������ڼ�2.0", Font.BOLD, 33));
		btnMinus.addActionListener(new Calculate_btnMinus_actionAdapter(this));
		btnPoint.setForeground(SystemColor.windowBorder);
		btnPoint.setBounds(new Rectangle(287, 443, 112, 72));
		btnPoint.setFont(new Font("����ǻ������ڼ�2.0", Font.BOLD, 40));
		btnPoint.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPoint.addActionListener(new Calculate_btnPoint_actionAdapter(this));
		btnDivide.setForeground(SystemColor.windowBorder);
		btnDivide.setBounds(new Rectangle(414, 443, 112, 72));
		btnDivide.setFont(new Font("����ǻ������ڼ�2.0", Font.BOLD, 40));
		btnEqual.setForeground(SystemColor.windowBorder);
		btnEqual.setBounds(new Rectangle(541, 443, 112, 72));
		btnEqual.setFont(new Font("����ǻ������ڼ�2.0", Font.BOLD, 40));
		btnEqual.addActionListener(new Calculate_btnEqual_actionAdapter(this));
		btnIncrease.setForeground(SystemColor.windowBorder);
		btnIncrease.setBounds(new Rectangle(414, 174, 112, 72));
		btnIncrease.setFont(new Font("����ǻ������ڼ�2.0", Font.BOLD, 40));

		// ���ؼӼ��˳�������ļ����¼�
		btnIncrease.addActionListener(new Calculate_btnIncrease_actionAdapter(	this));
		btnDecrease.addActionListener(new Calculate_btnIncrease_actionAdapter(this));
		btnMultiply.addActionListener(new Calculate_btnIncrease_actionAdapter(this));
		btnDivide.addActionListener(new Calculate_btnIncrease_actionAdapter(	this));
		btnSeven.setBounds(new Rectangle(33, 174, 112, 72));
		btnSeven.setFont(new Font("����ǻ������ڼ�2.0", Font.BOLD, 40));
		btnEight.setBounds(new Rectangle(160, 174, 112, 72));
		btnEight.setFont(new Font("����ǻ������ڼ�2.0", Font.BOLD, 40));
		btnNine.setBounds(new Rectangle(287, 174, 112, 72));
		btnNine.setFont(new Font("����ǻ������ڼ�2.0", Font.BOLD, 40));
		//��Ⱦ���
		contentPane.add(btnFive);
		contentPane.add(btnSix);
		contentPane.add(btnDecrease);
		contentPane.add(btnBegin);
		contentPane.add(btnOne);
		contentPane.add(btnTwo);
		contentPane.add(btnThree);
		contentPane.add(btnMultiply);
		contentPane.add(btnCancel);
		contentPane.add(btnMinus);
		contentPane.add(btnPoint);
		contentPane.add(btnDivide);
		contentPane.add(btnEqual);
		contentPane.add(btnEight);
		contentPane.add(btnNine);
		contentPane.add(btnFour);
		contentPane.add(btnSeven);
		contentPane.add(btnIncrease);
		contentPane.add(btnNull);
		contentPane.add(txtResult);
		contentPane.add(btnZero);
		
		JLabel lblNewLabel = new JLabel("\u8BA1\u7B97\u5668(By mayining)");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("�������ټ���Ӵְ�", Font.BOLD, 50));
		lblNewLabel.setBounds(97, 25, 551, 56);
		getContentPane().add(lblNewLabel);
	}
/**
 * �߼��㷨
 * @param e
 */
	public void btnZero_actionPerformed(ActionEvent e) {
		if (flag) { // ����ոհ����������
			txtResult.setText("");
			if (flag1) {// �ж�֮ǰ�Ƿ������˵������
				txtResult.setText("0." + e.getActionCommand());
				flag1 = false;
			} else {
				txtResult.setText(e.getActionCommand());
			}
			flag2 = true;
		} else {
			int num = txtResult.getText().indexOf(".");
			if (num < 0 && !txtResult.getText().equals("0")) {
				txtResult.setText(txtResult.getText() + e.getActionCommand());
			} else if (num < 0 && txtResult.getText().equals("0")) {
				txtResult.setText(e.getActionCommand());
			} else if (num >= 0 && txtResult.getText().equals("0")) {
				txtResult.setText("0." + e.getActionCommand());
			} else if (num >= 0 && !txtResult.getText().equals("0")) {
				txtResult.setText(txtResult.getText() + e.getActionCommand());
			}
		}
		flag = false;
		flag3 = false;
	}
	public void btnIncrease_actionPerformed(ActionEvent e) {
		if (flag3) {
			txtResult.setText(txtResult.getText());
			op = e.getActionCommand(); // �õ��ոհ��µ������
			front = txtResult.getText(); // ��¼�Ӽ��˳������֮ǰ���������
		} else if (flag2) {
			ActionEvent ee = new ActionEvent("qq", 1, "pp");
			btnEqual_actionPerformed(ee);
			op = e.getActionCommand(); // �õ��ոհ��µ������
			front = re;
			flag2 = false;
		} else {
			front = txtResult.getText(); // ��¼�Ӽ��˳������֮ǰ���������
			op = e.getActionCommand(); // �õ��ոհ��µ������
		}
		flag3 = false;
		flag = true; // ��¼�Ѿ������˼Ӽ��˳������������һ��
	}
	public void btnEqual_actionPerformed(ActionEvent e) {
		if (!flag3)// δ�����µ��������
			behind = txtResult.getText();
		else
			front = re;
		try {
			double a1 = Double.parseDouble(front);
			double b1 = Double.parseDouble(behind);
			if (op == "+") {
				result = a1 + b1;
			} else if (op == "-") {
				result = a1 - b1;
			} else if (op == "*") {
				result = a1 * b1;
			} else {
				result = a1 / b1;
			}
			Double r = new Double(result);
			re = Double.toString(result);
			txtResult.setText(re);
		} catch (ArithmeticException ce) {
			txtResult.setText("��������Ϊ��");
		} catch (Exception ee) {
		}
		if (!flag3)
			flag3 = true;
	}
	public void btnPoint_actionPerformed(ActionEvent e) {
		int num = txtResult.getText().indexOf(".");
		if (num < 0 && !flag)
			txtResult.setText(txtResult.getText() + e.getActionCommand());
		if (flag)
			flag1 = true;
	}
	public void btnBegin_actionPerformed(ActionEvent e) {// ����������¼�����
		flag = false;
		flag1 = false;
		flag2 = false;
		flag3 = false;
		front = "";
		behind = "";
		re = "";
		txtResult.setText("0");
	}
	public void btnMinus_actionPerformed(ActionEvent e) {// ȡ��������¼�����
		if (txtResult.getText().equals("0")) {// ����ı�������Ϊ0
			txtResult.setText(txtResult.getText());
		} else if (txtResult.getText().indexOf("-") >= 0) {// ���ı����к��и���
			String a = txtResult.getText().replaceAll("-", "");
			txtResult.setText(a);
		} else if (flag) {
			txtResult.setText("0");
		} else {
			txtResult.setText("-" + txtResult.getText());
		}
	}
	public void btnCancel_actionPerformed(ActionEvent e) {// �˸��¼�������
		String str = txtResult.getText();
		if (str.length() == 1) {// ���ı�����ֻʣ�����һ���ַ�,���ı���������Ϊ0
			txtResult.setText("0");
		}
		if (str.length() > 1) {
			str = str.substring(0, str.length() - 1);
			txtResult.setText(str);
		}
	}
}
/**
 * ������
 * @author mayin
 *
 */
    class Calculate_btnCancel_actionAdapter implements ActionListener {
	private Calculate adaptee;
	Calculate_btnCancel_actionAdapter(Calculate adaptee) {
		this.adaptee = adaptee;
	    }
	public void actionPerformed(ActionEvent e) {
		adaptee.btnCancel_actionPerformed(e);
	    }
    }

    class Calculate_btnMinus_actionAdapter implements ActionListener {
	private Calculate adaptee;
	Calculate_btnMinus_actionAdapter(Calculate adaptee) {
		this.adaptee = adaptee;
	    }
	public void actionPerformed(ActionEvent e) {
		adaptee.btnMinus_actionPerformed(e);
	    }
    }

    class Calculate_btnBegin_actionAdapter implements ActionListener {
	private Calculate adaptee;
	Calculate_btnBegin_actionAdapter(Calculate adaptee) {
		this.adaptee = adaptee;
	    }
	public void actionPerformed(ActionEvent e) {
		adaptee.btnBegin_actionPerformed(e);
	    }
    }

    class Calculate_btnPoint_actionAdapter implements ActionListener {
	private Calculate adaptee;
	Calculate_btnPoint_actionAdapter(Calculate adaptee) {
		this.adaptee = adaptee;
	    }
	public void actionPerformed(ActionEvent e) {
		adaptee.btnPoint_actionPerformed(e);
	    }
    }

    class Calculate_btnEqual_actionAdapter implements ActionListener {
	private Calculate adaptee;
	Calculate_btnEqual_actionAdapter(Calculate adaptee) {
		this.adaptee = adaptee;
	    }
	public void actionPerformed(ActionEvent e) {
		adaptee.btnEqual_actionPerformed(e);
	    }
    }

    class Calculate_btnIncrease_actionAdapter implements ActionListener {
	private Calculate adaptee;
	Calculate_btnIncrease_actionAdapter(Calculate adaptee) {
		this.adaptee = adaptee;
	    }
	public void actionPerformed(ActionEvent e) {
		adaptee.btnIncrease_actionPerformed(e);
	    }
    }

    class Calculate_btnZero_actionAdapter implements ActionListener {
	private Calculate adaptee;
	Calculate_btnZero_actionAdapter(Calculate adaptee) {
		this.adaptee = adaptee;
	    }
	public void actionPerformed(ActionEvent e) {
		adaptee.btnZero_actionPerformed(e);
	    }
    }