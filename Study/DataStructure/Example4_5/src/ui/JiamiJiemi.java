package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import function.TextFileEncrytion;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class JiamiJiemi extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5933578725110499607L;
	private JPanel contentPane;
	private JTextField textField_origin;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JiamiJiemi frame = new JiamiJiemi();
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
	public JiamiJiemi() {
		setTitle("\u52A0\u5BC6\u89E3\u5BC6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 247);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u9009\u62E9\u8981\u52A0\u5BC6\u6216\u89E3\u5BC6\u7684\u6587\u4EF6");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel.setBounds(14, 13, 150, 26);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u76EE\u6807\u6587\u4EF6\u7684\u8DEF\u5F84");
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		label.setBounds(14, 52, 150, 26);
		contentPane.add(label);
		
		textField_origin = new JTextField();
		textField_origin.setEditable(false);
		textField_origin.setFont(new Font("宋体", Font.PLAIN, 12));
		textField_origin.setBounds(162, 14, 291, 24);
		contentPane.add(textField_origin);
		textField_origin.setColumns(10);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("宋体", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(162, 52, 291, 24);
		contentPane.add(textField);
		
		JButton button_1 = new JButton("\u6D4F\u89C8");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc = new JFileChooser();
				jfc.setCurrentDirectory(new File("d://"));
				jfc.setFileSelectionMode(0);
				int state = jfc.showOpenDialog(null);
	            if (state == 1) {  
	                return;
	            } else {  
	                File f = jfc.getSelectedFile();  
	                textField_origin.setText(f.getAbsolutePath());  
	            }
			}
		});
		button_1.setBounds(457, 13, 113, 27);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u6D4F\u89C8");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.setCurrentDirectory(new File("d://"));
				jfc.setFileSelectionMode(1);
				int state = jfc.showOpenDialog(null);
	            if (state == 1) {  
	                return;
	            } else {  
	                File f = jfc.getSelectedFile();  
	                textField.setText(f.getAbsolutePath());  
	            }
			}
		});
		button_2.setBounds(457, 49, 113, 27);
		contentPane.add(button_2);
		
		JLabel label_1 = new JLabel("\u76EE\u6807\u6587\u4EF6\u540D");
		label_1.setFont(new Font("宋体", Font.PLAIN, 12));
		label_1.setBounds(145, 91, 66, 26);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(213, 91, 99, 24);
		contentPane.add(textField_1);		
		
		JLabel lblint = new JLabel("\u79D8\u94A5(int)");
		lblint.setFont(new Font("宋体", Font.PLAIN, 12));
		lblint.setBounds(14, 91, 60, 26);
		contentPane.add(lblint);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(76, 91, 66, 24);
		contentPane.add(textField_2);
		
		JLabel lbltxt = new JLabel(".txt");
		lbltxt.setFont(new Font("宋体", Font.PLAIN, 12));
		lbltxt.setBounds(316, 89, 42, 26);
		contentPane.add(lbltxt);
		
		JRadioButton radiobutton = new JRadioButton("\u52A0\u5BC6");
		radiobutton.setFont(new Font("宋体", Font.PLAIN, 12));
		radiobutton.setBounds(348, 91, 53, 27);
		contentPane.add(radiobutton);
		
		JRadioButton radiobutton_1 = new JRadioButton("\u89E3\u5BC6");
		radiobutton_1.setFont(new Font("宋体", Font.PLAIN, 12));
		radiobutton_1.setBounds(400, 91, 53, 27);
		contentPane.add(radiobutton_1);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radiobutton);
		group.add(radiobutton_1);
		radiobutton.setSelected(true);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(14, 122, 556, 69);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("\u52A0\u5BC6/\u89E3\u5BC6");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str1 = textField_origin.getText().trim();
				String str2 = textField.getText().trim();
				String str3 = textField_1.getText().trim();
				String str4 = textField_2.getText().trim();
				if(str1 != null && str1 != "" && str2 != null && str2 != "" && str3 != null && str3 != ""  && str4.matches("[0-9]+")) {
					TextFileEncrytion textFileEncrytion = new TextFileEncrytion();
					int key = Integer.parseInt(str4);
					if(radiobutton.isSelected()) {
						try {
							textFileEncrytion.encryptFile(str1, str2+str3+".txt", key);
							textArea.setText("加密成功！");
						} catch (IOException e1) {
							textArea.setText("运行出错，请重试！"+'\n'+e1);
						}
					}else{
						try {
							textFileEncrytion.decryptFile(str1, str2+str3+".txt", key);
							textArea.setText("解密成功！");
						} catch (IOException e1) {
							textArea.setText("运行出错，请重试！"+'\n'+e1);
						}
					}
				}else {
					textArea.setText("输入出错，请重新输入！");
				}
			}
		});
		btnNewButton.setBounds(457, 89, 113, 27);
		contentPane.add(btnNewButton);
	}
}
