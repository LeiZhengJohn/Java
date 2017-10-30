package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import queue.PriorityQdata;
import queue.PriorityQueue;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CPUcontroler extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3195657950456767089L;
	private JPanel contentPane;
	private JTextField input_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CPUcontroler frame = new CPUcontroler();
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
	public CPUcontroler() {
		setTitle("\u8FDB\u7A0B\u7BA1\u7406\u5668");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u6309\u7167 \u8FDB\u7A0BID,\u4F18\u5148\u7EA7;\u7684\u683C\u5F0F\u8F93\u5165(\u4F18\u5148\u7EA7\u57280-40\u4E4B\u95F4)");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(14, 13, 460, 36);
		contentPane.add(lblNewLabel);
		
		input_textField = new JTextField();
		input_textField.setFont(new Font("宋体", Font.PLAIN, 18));
		input_textField.setBounds(14, 48, 446, 36);
		contentPane.add(input_textField);
		input_textField.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u8FDB\u7A0BID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane_1.setToolTipText("\u8FDB\u7A0BID");
		scrollPane_1.setBounds(14, 124, 222, 339);
		contentPane.add(scrollPane_1);
		
		JTextArea id_textarea = new JTextArea();
		id_textarea.setEditable(false);
		id_textarea.setFont(new Font("宋体", Font.PLAIN, 20));
		scrollPane_1.setViewportView(id_textarea);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setViewportBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u8FDB\u7A0B\u4F18\u5148\u7EA7", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane_2.setToolTipText("\u8FDB\u7A0B\u4F18\u5148\u7EA7");
		scrollPane_2.setBounds(238, 124, 222, 339);
		contentPane.add(scrollPane_2);
		
		JTextArea priority_textarea = new JTextArea();
		priority_textarea.setFont(new Font("宋体", Font.PLAIN, 20));
		priority_textarea.setEditable(false);
		scrollPane_2.setViewportView(priority_textarea);
		
		scrollPane_1.setVerticalScrollBar(scrollPane_2.getVerticalScrollBar());
		
		JButton config = new JButton("\u786E\u8BA4\u8F93\u5165");
		config.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean flag = true;
				PriorityQueue queue = new PriorityQueue();
				String str1 = "";
				String str2 = "";
				String input = input_textField.getText().trim();
				
				String data[] = input.split(";|；");
				for (int i = 0; i < data.length; i++) {
					if(!data[i].matches("([1-9]+[0-9]*)(,|，)([1-3][0-9]|[0-9]|40)")){
						flag = false;
					}
				}

				if(flag) {
					for (int j = 0; j < data.length; j++) {
						String datas[] = data[j].split(",|，");
						PriorityQdata pa = new PriorityQdata(Integer.parseInt(datas[0]), Integer.parseInt(datas[1]));
						queue.offer(pa);
					}
					while(!queue.isEmpty()) {
						PriorityQdata pn = queue.poll();
						str1 += (pn.pid + " \n");
						str2 += (pn.priority + " \n");
					}
					id_textarea.setText(str1);
					priority_textarea.setText(str2);
				}else {
					id_textarea.setText("输入有误，请检查是否\n是\"int,int;int,int;\"\n的形式！且优先级是\n否在0-40之间。");
					priority_textarea.setText("");
				}
				
			}
		});
		config.setFont(new Font("宋体", Font.PLAIN, 18));
		config.setBounds(14, 87, 446, 36);
		contentPane.add(config);
		
	}
}
