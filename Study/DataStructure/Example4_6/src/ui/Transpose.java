package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sparseMatrix.SparseMatrix;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Transpose extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transpose frame = new Transpose();
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
	public Transpose() {
		setTitle("\u77E9\u9635\u8F6C\u7F6E");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u884C\u6570\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(14, 13, 65, 39);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_1.setBounds(61, 13, 44, 39);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(153, 13, 44, 39);
		contentPane.add(textField_2);
		
		JLabel label = new JLabel("\u5217\u6570\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(107, 13, 65, 39);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u975E\u96F6\u5143\u7D20\uFF1A(\u4EE5\u884C\u53F7,\u5217\u53F7,\u503C#\u884C\u53F7,\u5217\u53F7,\u503C...\u5F62\u5F0F\u8F93\u5165,\u884C\u5217\u53F7\u4ECE0\u5F00\u59CB)");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(199, 13, 655, 39);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		textField.setBounds(14, 65, 840, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 155, 840, 271);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("宋体", Font.PLAIN, 30));
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u8F93\u5165");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s_rows = textField_1.getText();
				String s_cols = textField_2.getText();
				String s_data = textField.getText();
				if(s_rows.matches("[1-9][0-9]*") && s_cols.matches("[1-9][0-9]*") && s_data.matches("([0-9]+,[0-9]+,[0-9]+)(#[0-9]+,[0-9]+,[0-9]+)*")) {
					int rows = Integer.parseInt(s_rows);
					int cols = Integer.parseInt(s_cols);
					String[] data = s_data.split("#");
					int[][] shuZu = SparseMatrix.parseToShuzu(rows, cols, data);
					SparseMatrix m1 = new SparseMatrix(shuZu);
					SparseMatrix m2 = m1.fastTranspose();
					int[][] result = m2.parseToShuzu(m2);
					String str = "";
					for (int i = 0; i < result.length; i++) {
						for (int j = 0; j < result[i].length; j++) {
							str += (result[i][j] + "   ");
						}
						str += "\r\n";
					}
					textArea.setText(str);
				}else {
					textArea.setText("输入有误，请重新输入！");
				}
			}
		});
		btnNewButton.setBounds(14, 115, 420, 27);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField.setText("");
			}
		});
		button.setBounds(434, 115, 420, 27);
		contentPane.add(button);
		
	}
}
