package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biTree.BiTree;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BiTree2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5375101550288729723L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private BiTree tree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BiTree2 frame = new BiTree2();
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
	public BiTree2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5148\u6839\u5E8F\u5217\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 10, 90, 34);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u4E2D\u6839\u5E8F\u5217\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(10, 54, 90, 34);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_1.setBounds(91, 10, 563, 34);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(91, 54, 563, 34);
		contentPane.add(textField_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("华文楷体", Font.PLAIN, 20));
		textArea.setBounds(10, 142, 644, 61);
		contentPane.add(textArea);
		
		JButton button_1 = new JButton("\u786E\u8BA4\u8F93\u5165");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str1 = textField_1.getText().trim();
				String str2 = textField_2.getText().trim();
				if(str1 != null && str1 != "" && str2 != null && str2 != "") {
					tree = new BiTree(str1,str2,0,0,str1.length());
					if(tree.getRoot() == null) {
						textArea.setText("输入错误，请重新输入");
					}else {
						textArea.setText("树建立成功");
					}
				}
				if(tree.getRoot() == null){
					textArea.setText("请输入内容");
				}
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		button_1.setBounds(10, 98, 307, 34);
		contentPane.add(button_1);
		
		JButton button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.setBounds(347, 98, 307, 34);
		contentPane.add(button);
		
		JButton button_2 = new JButton("\u5148\u6839(\u9012\u5F52)");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tree.getRoot() != null) {
					tree.setReNone();
					String re = tree.preRootTraverse(tree.getRoot());
					textArea.setText(re);
				}
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 18));
		button_2.setBounds(10, 213, 152, 34);
		contentPane.add(button_2);
		
		JButton button_5 = new JButton("\u5C42\u6B21\u904D\u5386");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tree.getRoot() != null) {
					String re = tree.levelTraverse();
					textArea.setText(re);
				}
			}
		});
		button_5.setFont(new Font("宋体", Font.PLAIN, 18));
		button_5.setBounds(347, 257, 307, 34);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("\u5148\u6839(\u975E\u9012\u5F52)");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tree.getRoot() != null) {
					String re = tree.preRootTraverse();
					textArea.setText(re);
				}
			}
		});
		button_6.setFont(new Font("宋体", Font.PLAIN, 18));
		button_6.setBounds(165, 213, 152, 34);
		contentPane.add(button_6);
		
		JButton button_3 = new JButton("\u4E2D\u6839(\u9012\u5F52)");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tree.getRoot() != null) {
					tree.setReNone();
					String re = tree.inRootTraverse(tree.getRoot());
					textArea.setText(re);
				}
			}
		});
		button_3.setFont(new Font("宋体", Font.PLAIN, 18));
		button_3.setBounds(347, 213, 152, 34);
		contentPane.add(button_3);
		
		JButton button_7 = new JButton("\u4E2D\u6839(\u975E\u9012\u5F52)");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tree.getRoot() != null) {
					String re = tree.inRootTraverse();
					textArea.setText(re);
				}
			}
		});
		button_7.setFont(new Font("宋体", Font.PLAIN, 18));
		button_7.setBounds(502, 213, 152, 34);
		contentPane.add(button_7);
		
		JButton button_4 = new JButton("\u540E\u6839(\u9012\u5F52)");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tree.getRoot() != null) {
					tree.setReNone();
					String re = tree.postRootTraverse(tree.getRoot());
					textArea.setText(re);
				}
			}
		});
		button_4.setFont(new Font("宋体", Font.PLAIN, 18));
		button_4.setBounds(10, 257, 152, 34);
		contentPane.add(button_4);
		
		JButton button_8 = new JButton("\u540E\u6839(\u975E\u9012\u5F52)");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tree.getRoot() != null) {
					String re = tree.postRootTraverse();
					textArea.setText(re);
				}
			}
		});
		button_8.setFont(new Font("宋体", Font.PLAIN, 18));
		button_8.setBounds(165, 257, 152, 34);
		contentPane.add(button_8);
	}
}
