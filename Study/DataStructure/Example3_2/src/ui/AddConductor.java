package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import functions.Example3_2;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddConductor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5125371900856918173L;
	private JPanel contentPane;
	private JTextField textField_add1;
	private JTextField textField_add2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddConductor frame = new AddConductor();
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
	public AddConductor() {
		setTitle("\u5927\u6570\u52A0\u6CD5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_add1 = new JTextField();
		textField_add1.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_add1.setBounds(43, 13, 375, 37);
		contentPane.add(textField_add1);
		textField_add1.setColumns(10);
		
		textField_add2 = new JTextField();
		textField_add2.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_add2.setBounds(43, 63, 375, 37);
		contentPane.add(textField_add2);
		textField_add2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("+");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setBounds(14, 63, 20, 37);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("宋体", Font.PLAIN, 20));
		textArea.setBounds(43, 113, 375, 95);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("=");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str1 = textField_add1.getText().trim();
				String str2 = textField_add2.getText().trim();
				if(str1.matches("[0-9]+") && str2.matches("[0-9]+")) {
					Example3_2 e = new Example3_2();
					textArea.setText(e.add(str1, str2));
				}else {
					textArea.setText("请输入整型数据，且不要输入空格！");
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(0, 113, 44, 49);
		contentPane.add(btnNewButton);
	}
}
