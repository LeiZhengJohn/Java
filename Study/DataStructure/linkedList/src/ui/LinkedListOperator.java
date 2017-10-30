package ui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import utils.MyLinkedList;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class LinkedListOperator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2313207834360098966L;
	private JPanel contentPane;
	private JTextField polyA;
	private JLabel lblb;
	private JTextField polyB;
	MyLinkedList listA = new MyLinkedList();
	MyLinkedList listB = new MyLinkedList();
	JButton calculate = new JButton();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LinkedListOperator frame = new LinkedListOperator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LinkedListOperator() {
		setTitle("\u591A\u9879\u5F0F\u52A0\u6CD5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u6309\u4EE5\u4E0B\u683C\u5F0F\u8F93\u5165\u6570\u636E\uFF1A\u7CFB\u6570\uFF0C\u6307\u6570#\u7CFB\u6570\uFF0C\u6307\u6570#...");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel.setBounds(14, 13, 615, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u591A\u9879\u5F0FA\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(14, 51, 142, 39);
		contentPane.add(lblNewLabel_1);
		
		polyA = new JTextField();
		polyA.setFont(new Font("宋体", Font.PLAIN, 25));
		polyA.setBounds(14, 90, 615, 39);
		contentPane.add(polyA);
		polyA.setColumns(10);
		
		lblb = new JLabel("\u591A\u9879\u5F0FB\uFF1A");
		lblb.setFont(new Font("宋体", Font.PLAIN, 25));
		lblb.setBounds(14, 142, 142, 39);
		contentPane.add(lblb);
		
		polyB = new JTextField();
		polyB.setFont(new Font("宋体", Font.PLAIN, 25));
		polyB.setColumns(10);
		polyB.setBounds(14, 181, 615, 39);
		contentPane.add(polyB);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 285, 615, 224);
		contentPane.add(scrollPane);
		
		JTextPane output_log = new JTextPane();
		output_log.setFont(new Font("宋体", Font.PLAIN, 20));
		output_log.setEditable(false);
		StyledDocument d=output_log.getStyledDocument();  
        SimpleAttributeSet attr = new SimpleAttributeSet();  
        StyleConstants.setForeground(attr, Color.red);
		scrollPane.setViewportView(output_log);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		JButton config = new JButton("\u786E\u8BA4\u8F93\u5165");
		config.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a = polyA.getText();
				String b = polyB.getText();
				String[] argsA = a.split("#");
				String[] argsB = b.split("#");
				boolean flag = true;
				for (int i = 0; i < argsA.length; i++) {
					if(!argsA[i].matches("([0-9]+(.[0-9]+)?|-[0-9]+(.[0-9]+)?)(,|，)(0|[1-9][0-9]*|-[1-9][0-9]*)")) {
						flag = false;
					}
				}
				for (int i = 0; i < argsB.length; i++) {
					if(!argsB[i].matches("([0-9]+(.[0-9]+)?|-[0-9]+(.[0-9]+)?)(,|，)(0|[1-9][0-9]*|-[1-9][0-9]*)")) {
						flag = false;
					}
				}
				if(flag) {
					listA.create(argsA);
					listB.create(argsB);
					listA.simplify();
					listB.simplify();
					listA.sort();
					listB.sort();
					StyleConstants.setForeground(attr, Color.black);
					try {
						d.insertString(d.getLength(),df.format(new Date())+"  多项式A，B创建成功！\n",attr);
						d.insertString(d.getLength(),"  LA = "+listA.display()+"\n",attr);
						d.insertString(d.getLength(),"  LB = "+listB.display()+"\n",attr);
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
					StyleConstants.setForeground(attr, Color.red);
					calculate.setEnabled(true);
					
				}else {
					try {
						d.insertString(d.getLength(),df.format(new Date())+"  输入格式有误，请检查数据是否为浮点型和整数型，并用逗号隔开？\n",attr);
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		config.setFont(new Font("宋体", Font.PLAIN, 25));
		config.setBounds(14, 233, 315, 39);
		contentPane.add(config);
		
	    calculate = new JButton("\u8BA1\u7B97");
		calculate.setEnabled(false);
		calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyLinkedList listC = new MyLinkedList();
				listC = MyLinkedList.compile(listA, listB);
				listC.simplify();
				listC.sort();
				StyleConstants.setForeground(attr, Color.black);
				try {
					d.insertString(d.getLength(),df.format(new Date())+"  多项式A，B相加成功！\n",attr);
					d.insertString(d.getLength(),"  LC = "+listC.display()+"\n",attr);
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				StyleConstants.setForeground(attr, Color.red);
			}
		});
		calculate.setFont(new Font("宋体", Font.PLAIN, 25));
		calculate.setBounds(329, 233, 300, 39);
		contentPane.add(calculate);
	}
}
