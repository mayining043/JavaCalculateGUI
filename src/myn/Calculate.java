package myn;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
/**
 * java计算器
 * @author mayin
 *
 */
public class Calculate extends JFrame {
	private String front = "", behind = ""; // 记录加减乘除运算符之前,之后输入的内容
	private String op; // 记录运算符
	private String re;// 存储运算结果的字符串格式
	private boolean flag = false; // 记录是否按下了运算符
	private boolean flag1 = false;// 判断是否输入了点运算符
	private double result;// 存储运算结果
	private boolean flag2 = false;// 判断是否输入了数字
	private boolean flag3 = false;// 判断是否按下了等号运算符
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
	JButton btnCancel = new JButton("←");
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
 * 渲染画面
 * @throws Exception
 */
	private void init() throws Exception {
		//加载div
		contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);
		txtResult.setForeground(SystemColor.activeCaption);
		//加载输出区域
		txtResult.setEnabled(false);
		txtResult.setFont(new Font("方正静蕾简体加粗版", Font.BOLD, 40));
		txtResult.setEditable(false);
		txtResult.setHorizontalAlignment(SwingConstants.RIGHT);
		txtResult.setBounds(new Rectangle(33, 96, 620, 63));
		btnNull.setForeground(SystemColor.windowBorder);
		//加载按钮
		btnNull.setBounds(new Rectangle(541, 174, 112, 72));
		btnNull.setFont(new Font("海派腔调禅大黑简2.0", Font.BOLD, 28));
		btnFour.setForeground(SystemColor.windowBorder);
		btnFour.setBounds(new Rectangle(33, 269, 112, 72));
		btnFour.setFont(new Font("海派腔调禅大黑简2.0", Font.BOLD, 40));
		btnFive.setForeground(SystemColor.windowBorder);
		btnFive.setBounds(new Rectangle(160, 269, 112, 72));
		btnFive.setFont(new Font("海派腔调禅大黑简2.0", Font.BOLD, 40));
		btnSix.setForeground(SystemColor.windowBorder);
		btnSix.setBounds(new Rectangle(287, 269, 112, 72));
		btnSix.setFont(new Font("海派腔调禅大黑简2.0", Font.BOLD, 40));
		btnDecrease.setForeground(SystemColor.windowBorder);
		btnDecrease.setBounds(new Rectangle(414, 269, 112, 72));
		btnDecrease.setFont(new Font("海派腔调禅大黑简2.0", Font.BOLD, 40));
		btnBegin.setForeground(SystemColor.windowBorder);
		btnBegin.setBounds(new Rectangle(541, 269, 112, 72));
		btnBegin.setFont(new Font("海派腔调禅大黑简2.0", Font.BOLD, 40));
		btnBegin.addActionListener(new Calculate_btnBegin_actionAdapter(this));
		btnOne.setForeground(SystemColor.windowBorder);
		btnOne.setBounds(new Rectangle(33, 356, 112, 72));
		btnOne.setFont(new Font("海派腔调禅大黑简2.0", Font.BOLD, 40));
		btnTwo.setForeground(SystemColor.windowBorder);
		btnTwo.setBounds(new Rectangle(160, 356, 112, 72));
		btnTwo.setFont(new Font("海派腔调禅大黑简2.0", Font.BOLD, 40));
		btnThree.setForeground(SystemColor.windowBorder);
		btnThree.setBounds(new Rectangle(287, 356, 112, 72));
		btnThree.setFont(new Font("海派腔调禅大黑简2.0", Font.BOLD, 40));
		btnMultiply.setForeground(SystemColor.windowBorder);
		btnMultiply.setBounds(new Rectangle(414, 356, 112, 72));
		btnMultiply.setFont(new Font("海派腔调禅大黑简2.0", Font.BOLD, 40));
		btnCancel.setForeground(SystemColor.windowBorder);
		btnCancel.setBounds(new Rectangle(541, 356, 112, 72));
		btnCancel.setFont(new Font("海派腔调禅大黑简2.0", Font.BOLD, 40));
		btnCancel.addActionListener(new Calculate_btnCancel_actionAdapter(this));
		btnZero.setForeground(SystemColor.windowBorder);
		btnZero.setBounds(new Rectangle(33, 443, 112, 72));
		btnZero.setFont(new Font("海派腔调禅大黑简2.0", Font.BOLD, 40));
		// 加载数字0-9的监听事件
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
		btnMinus.setFont(new Font("海派腔调禅大黑简2.0", Font.BOLD, 33));
		btnMinus.addActionListener(new Calculate_btnMinus_actionAdapter(this));
		btnPoint.setForeground(SystemColor.windowBorder);
		btnPoint.setBounds(new Rectangle(287, 443, 112, 72));
		btnPoint.setFont(new Font("海派腔调禅大黑简2.0", Font.BOLD, 40));
		btnPoint.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPoint.addActionListener(new Calculate_btnPoint_actionAdapter(this));
		btnDivide.setForeground(SystemColor.windowBorder);
		btnDivide.setBounds(new Rectangle(414, 443, 112, 72));
		btnDivide.setFont(new Font("海派腔调禅大黑简2.0", Font.BOLD, 40));
		btnEqual.setForeground(SystemColor.windowBorder);
		btnEqual.setBounds(new Rectangle(541, 443, 112, 72));
		btnEqual.setFont(new Font("海派腔调禅大黑简2.0", Font.BOLD, 40));
		btnEqual.addActionListener(new Calculate_btnEqual_actionAdapter(this));
		btnIncrease.setForeground(SystemColor.windowBorder);
		btnIncrease.setBounds(new Rectangle(414, 174, 112, 72));
		btnIncrease.setFont(new Font("海派腔调禅大黑简2.0", Font.BOLD, 40));

		// 加载加减乘除运算符的监听事件
		btnIncrease.addActionListener(new Calculate_btnIncrease_actionAdapter(	this));
		btnDecrease.addActionListener(new Calculate_btnIncrease_actionAdapter(this));
		btnMultiply.addActionListener(new Calculate_btnIncrease_actionAdapter(this));
		btnDivide.addActionListener(new Calculate_btnIncrease_actionAdapter(	this));
		btnSeven.setBounds(new Rectangle(33, 174, 112, 72));
		btnSeven.setFont(new Font("海派腔调禅大黑简2.0", Font.BOLD, 40));
		btnEight.setBounds(new Rectangle(160, 174, 112, 72));
		btnEight.setFont(new Font("海派腔调禅大黑简2.0", Font.BOLD, 40));
		btnNine.setBounds(new Rectangle(287, 174, 112, 72));
		btnNine.setFont(new Font("海派腔调禅大黑简2.0", Font.BOLD, 40));
		//渲染组件
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
		lblNewLabel.setFont(new Font("方正静蕾简体加粗版", Font.BOLD, 50));
		lblNewLabel.setBounds(97, 25, 551, 56);
		getContentPane().add(lblNewLabel);
	}
/**
 * 逻辑算法
 * @param e
 */
	public void btnZero_actionPerformed(ActionEvent e) {
		if (flag) { // 如果刚刚按下了运算符
			txtResult.setText("");
			if (flag1) {// 判断之前是否输入了点运算符
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
			op = e.getActionCommand(); // 得到刚刚按下的运算符
			front = txtResult.getText(); // 记录加减乘除运算符之前输入的内容
		} else if (flag2) {
			ActionEvent ee = new ActionEvent("qq", 1, "pp");
			btnEqual_actionPerformed(ee);
			op = e.getActionCommand(); // 得到刚刚按下的运算符
			front = re;
			flag2 = false;
		} else {
			front = txtResult.getText(); // 记录加减乘除运算符之前输入的内容
			op = e.getActionCommand(); // 得到刚刚按下的运算符
		}
		flag3 = false;
		flag = true; // 记录已经按下了加减乘除运算符的其中一个
	}
	public void btnEqual_actionPerformed(ActionEvent e) {
		if (!flag3)// 未曾按下等于运算符
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
			txtResult.setText("除数不能为零");
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
	public void btnBegin_actionPerformed(ActionEvent e) {// 清零运算符事件处理
		flag = false;
		flag1 = false;
		flag2 = false;
		flag3 = false;
		front = "";
		behind = "";
		re = "";
		txtResult.setText("0");
	}
	public void btnMinus_actionPerformed(ActionEvent e) {// 取反运算符事件处理
		if (txtResult.getText().equals("0")) {// 如果文本框内容为0
			txtResult.setText(txtResult.getText());
		} else if (txtResult.getText().indexOf("-") >= 0) {// 若文本框中含有负号
			String a = txtResult.getText().replaceAll("-", "");
			txtResult.setText(a);
		} else if (flag) {
			txtResult.setText("0");
		} else {
			txtResult.setText("-" + txtResult.getText());
		}
	}
	public void btnCancel_actionPerformed(ActionEvent e) {// 退格事件处理方法
		String str = txtResult.getText();
		if (str.length() == 1) {// 如文本框中只剩下最后一个字符,将文本框内容置为0
			txtResult.setText("0");
		}
		if (str.length() > 1) {
			str = str.substring(0, str.length() - 1);
			txtResult.setText(str);
		}
	}
}
/**
 * 处理类
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