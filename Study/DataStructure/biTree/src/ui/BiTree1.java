package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biTree.BiTree;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class BiTree1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8759659472056956831L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BiTree1 frame = new BiTree1();
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
	public BiTree1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BiTree1.class.getResource("/ui/testTree.PNG")));
		lblNewLabel.setBounds(14, 13, 307, 255);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("华文楷体", Font.PLAIN, 28));
		textArea.setBounds(335, 65, 223, 203);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("\u5C42\u6B21\u904D\u5386");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BiTree biTree = new BiTree();
				BiTree testTree = biTree.createTestTree1();
				textArea.setText(testTree.levelTraverse());
			}
		});
		btnNewButton.setBounds(335, 13, 223, 51);
		contentPane.add(btnNewButton);
	}
}
