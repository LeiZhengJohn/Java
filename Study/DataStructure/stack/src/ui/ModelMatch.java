package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import functions.StackAPP;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModelMatch extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7636489842533526950L;
	private JPanel contentPane;
	private JTextField input_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModelMatch frame = new ModelMatch();
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
	public ModelMatch() {
		setTitle("\u5206\u9694\u7B26\u5339\u914D");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u5728\u4E0B\u6846\u4E2D\u8F93\u5165\u5339\u914D\u5B57\u7B26\u4E32\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(14, 13, 618, 39);
		contentPane.add(lblNewLabel);
		
		input_textField = new JTextField();
		input_textField.setFont(new Font("宋体", Font.PLAIN, 20));
		input_textField.setBounds(14, 51, 583, 46);
		contentPane.add(input_textField);
		input_textField.setColumns(10);
		
		JTextArea output_textArea = new JTextArea();
		output_textArea.setFont(new Font("Monospaced", Font.PLAIN, 25));
		output_textArea.setBounds(14, 136, 583, 115);
		contentPane.add(output_textArea);
		
		JButton config_button = new JButton("\u786E\u8BA4\u8F93\u5165");
		config_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String input = input_textField.getText().trim();
				if("".equals(input)) {
					output_textArea.setText("请输入字符串！");
				}else {
					StackAPP stackAPP = new StackAPP();
					if(stackAPP.isLegal(input)) {
						output_textArea.setText("Java语句合法!");
					}else {
						output_textArea.setText("Java语句不合法！");
					}
				}
			}
		});
		config_button.setFont(new Font("宋体", Font.PLAIN, 20));
		config_button.setBounds(14, 96, 583, 39);
		contentPane.add(config_button);
	}
}
