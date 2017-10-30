package ui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import utils.MyOrderedList;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class OrderedListOperator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5312573903285959772L;
	private JPanel contentPane;
	private JTextField input;
	private JTextField get_textfield;
	private JTextField remove_textfield;
	private JTextField indexOf_textfield;
	private JTextField insert_position;
	private JTextField insert_data;
	private JButton clear;
	private JButton isEmpty;
	private JButton length;
	private JButton get;
	private JButton insert;
	private JButton remove;
	private JButton display;
	private JButton indexOf;
	private MyOrderedList<Integer> myList1 = new MyOrderedList<>(1);
	private MyOrderedList<Double> myList2 = new MyOrderedList<>(1);
	private MyOrderedList<String> myList3 = new MyOrderedList<>(1);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderedListOperator frame = new OrderedListOperator();
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
	public OrderedListOperator() {
		setTitle("OrderedList Operator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u9009\u62E9\u4E00\u4E2A\u7C7B\u578B\uFF0C\u5728\u6587\u672C\u6846\u4E2D\u8F93\u5165\u6570\u636E\uFF0C\u9017\u53F7\u9694\u5F00\uFF0C\u6216\u8005\u4E0D\u8F93\u5165\uFF0C\u521B\u5EFA\u4E00\u4E2A\u7A7A\u8868");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(14, 13, 691, 43);
		contentPane.add(lblNewLabel);
		
		JRadioButton radioButton1 = new JRadioButton("int");
		radioButton1.setFont(new Font("宋体", Font.PLAIN, 19));
		radioButton1.setBounds(14, 50, 59, 27);
		contentPane.add(radioButton1);
		
		JRadioButton radioButton2 = new JRadioButton("double");
		radioButton2.setFont(new Font("宋体", Font.PLAIN, 19));
		radioButton2.setBounds(70, 50, 89, 27);
		contentPane.add(radioButton2);
		
		JRadioButton radioButton3 = new JRadioButton("string");
		radioButton3.setFont(new Font("宋体", Font.PLAIN, 19));
		radioButton3.setBounds(158, 50, 89, 27);
		contentPane.add(radioButton3);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radioButton1);
		group.add(radioButton2);
		group.add(radioButton3);
		radioButton1.setSelected(true);
		
		input = new JTextField();
		input.setFont(new Font("宋体", Font.PLAIN, 20));
		input.setBounds(14, 79, 691, 43);
		contentPane.add(input);
		input.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 265, 691, 210);
		contentPane.add(scrollPane);
		
		JTextPane output_log = new JTextPane();
		output_log.setFont(new Font("宋体", Font.PLAIN, 20));
		output_log.setEditable(false);
		StyledDocument d=output_log.getStyledDocument();  
        SimpleAttributeSet attr = new SimpleAttributeSet();  
        StyleConstants.setForeground(attr, Color.red);
		scrollPane.setViewportView(output_log);
		
		get_textfield = new JTextField();
		get_textfield.setBounds(94, 206, 80, 43);
		contentPane.add(get_textfield);
		get_textfield.setColumns(10);
		
		remove_textfield = new JTextField();
		remove_textfield.setColumns(10);
		remove_textfield.setBounds(268, 206, 80, 43);
		contentPane.add(remove_textfield);
		
		indexOf_textfield = new JTextField();
		indexOf_textfield.setColumns(10);
		indexOf_textfield.setBounds(450, 206, 81, 43);
		contentPane.add(indexOf_textfield);
		
		insert_position = new JTextField();
		insert_position.setColumns(10);
		insert_position.setBounds(545, 206, 40, 43);
		contentPane.add(insert_position);
		
		insert_data = new JTextField();
		insert_data.setColumns(10);
		insert_data.setBounds(665, 206, 40, 43);
		contentPane.add(insert_data);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		JButton create = new JButton("\u521B\u5EFA\u987A\u5E8F\u8868");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				if(input.getText().equals("")) {
					if(radioButton1.isSelected()) {
						myList1 = new MyOrderedList<Integer>(10);
						StyleConstants.setForeground(attr, Color.black);
						try {
							d.insertString(d.getLength(),df.format(new Date())+"  空的整型顺序表创建成功！\n",attr);
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
						StyleConstants.setForeground(attr, Color.red);
					}else if(radioButton2.isSelected()){
						myList2 = new MyOrderedList<Double>(10);
						StyleConstants.setForeground(attr, Color.black);
						try {
							d.insertString(d.getLength(),df.format(new Date())+"  空的浮点型顺序表创建成功！\n",attr);
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
						StyleConstants.setForeground(attr, Color.red);
					}else if(radioButton3.isSelected()) {
						myList3  = new MyOrderedList<String>(10);
						StyleConstants.setForeground(attr, Color.black);
						try {
							d.insertString(d.getLength(),df.format(new Date())+"  空的字符型顺序表创建成功！\n",attr);
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
						StyleConstants.setForeground(attr, Color.red);
					}
				}else {
					if(radioButton1.isSelected()) {
						String[] values = input.getText().split(",|，");
						for (int i = 0; i < values.length; i++) {
							if(!values[i].matches("^(0|[1-9][0-9]*|-[1-9][0-9]*)$")){
								flag = false;
							}
						}
						if(flag == false) {
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  输入有误，请检查数据是否为整数型，并用逗号隔开？\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
						}else {
							Integer[] result = new Integer[values.length];
							for (int j = 0; j < result.length; j++) {
								result[j] = Integer.parseInt(values[j]);
							}
							myList1 = new MyOrderedList<Integer>(result);
							StyleConstants.setForeground(attr, Color.black);
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  整型顺序表创建成功！\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
							StyleConstants.setForeground(attr, Color.red);
						}
					}else if(radioButton2.isSelected()) {
						String[] values = input.getText().split(",|，");
						for (int i = 0; i < values.length; i++) {
							if(!values[i].matches("[0-9]+(.[0-9]+)?|-[0-9]+(.[0-9]+)?")){
								flag = false;
							}
						}
						if(flag == false) {
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  输入有误，请检查数据是否为浮点型，并用逗号隔开？\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
						}else {
							Double[] result = new Double[values.length];
							for (int j = 0; j < result.length; j++) {
								result[j] = Double.parseDouble(values[j]);
							}
							myList2 = new MyOrderedList<Double>(result);
							StyleConstants.setForeground(attr, Color.black);
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  浮点型顺序表创建成功！\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
							StyleConstants.setForeground(attr, Color.red);
						}
					}else if(radioButton3.isSelected()) {
						String[] values = input.getText().split(",|，");
						myList3  = new MyOrderedList<String>(values);
						StyleConstants.setForeground(attr, Color.black);
						try {
							d.insertString(d.getLength(),df.format(new Date())+"  字符型顺序表创建成功！\n",attr);
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
						StyleConstants.setForeground(attr, Color.red);
					}
				}
		
				if(flag) {
					clear.setEnabled(true);
					isEmpty.setEnabled(true);
					length.setEnabled(true);
					get.setEnabled(true);
					insert.setEnabled(true);
					remove.setEnabled(true);
					indexOf.setEnabled(true);
					display.setEnabled(true);
					radioButton1.setEnabled(false);
					radioButton2.setEnabled(false);
					radioButton3.setEnabled(false);
					create.setEnabled(false);
				}
			}
		});
		create.setFont(new Font("宋体", Font.PLAIN, 20));
		create.setBounds(14, 121, 691, 43);
		contentPane.add(create);
		
		clear = new JButton("\u6E05\u7A7A");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(myList1.getCurLen() != 0 || myList2.getCurLen() != 0 || myList3.getCurLen() != 0) {
					myList1.clear();
					myList2.clear();
					myList3.clear();
					StyleConstants.setForeground(attr, Color.black);
					try {
						d.insertString(d.getLength(),df.format(new Date())+"  顺序表清空成功！\n",attr);
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
					StyleConstants.setForeground(attr, Color.red);
				}else {
					try {
						d.insertString(d.getLength(),df.format(new Date())+"  顺序表已经为空，无需再清！\n",attr);
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}				
			}
		});
		clear.setEnabled(false);
		clear.setFont(new Font("宋体", Font.PLAIN, 20));
		clear.setBounds(14, 164, 160, 43);
		contentPane.add(clear);
		
		display = new JButton("\u8F93\u51FA");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(myList1.isEmpty() && myList2.isEmpty() && myList3.isEmpty()) {
					StyleConstants.setForeground(attr, Color.black);
					try {
						d.insertString(d.getLength(),df.format(new Date())+"  顺序表为空！\n",attr);
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
					StyleConstants.setForeground(attr, Color.red);
				}else {
					StyleConstants.setForeground(attr, Color.black);
					try {
						d.insertString(d.getLength(),df.format(new Date())+"  顺序表："+ myList1.display() + myList2.display() + myList3.display() +"\n",attr);
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
					StyleConstants.setForeground(attr, Color.red);
				}
			}
		});
		display.setEnabled(false);
		display.setFont(new Font("宋体", Font.PLAIN, 20));
		display.setBounds(545, 164, 160, 43);
		contentPane.add(display);
		
		length = new JButton("\u957F\u5EA6");
		length.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StyleConstants.setForeground(attr, Color.black);
					try {
						d.insertString(d.getLength(),df.format(new Date())+"  顺序表的长度为：" + (myList1.length()+myList2.length()+myList3.length())  + "！\n",attr);
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
					StyleConstants.setForeground(attr, Color.red);
			}
		});
		length.setEnabled(false);
		length.setFont(new Font("宋体", Font.PLAIN, 20));
		length.setBounds(371, 164, 160, 43);
		contentPane.add(length);
		
		isEmpty = new JButton("\u5224\u7A7A");
		isEmpty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(myList1.isEmpty() && myList2.isEmpty() && myList3.isEmpty()) {
					StyleConstants.setForeground(attr, Color.black);
					try {
						d.insertString(d.getLength(),df.format(new Date())+"  顺序表为空！\n",attr);
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
					StyleConstants.setForeground(attr, Color.red);
				}else {
					StyleConstants.setForeground(attr, Color.black);
					try {
						d.insertString(d.getLength(),df.format(new Date())+"  顺序表不为空！\n",attr);
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
					StyleConstants.setForeground(attr, Color.red);
				}
			}
		});
		isEmpty.setEnabled(false);
		isEmpty.setFont(new Font("宋体", Font.PLAIN, 20));
		isEmpty.setBounds(188, 164, 160, 43);
		contentPane.add(isEmpty);
		
		get = new JButton("<html>  取值<br />(位置)</html>");
		get.setEnabled(false);
		get.setFont(new Font("宋体", Font.PLAIN, 15));
		get.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = get_textfield.getText();
				if(str.matches("[1-9]+[0-9]*")) {
					int position = Integer.parseInt(str);
					String value = "";
					if(myList1.get(position) != null) {
						value += myList1.get(position);
					}
					if(myList2.get(position) != null) {
						value += myList2.get(position);
					}
					if(myList3.get(position) != null) {
						value += myList3.get(position);
					}
					if(value == "") {
						try {
							d.insertString(d.getLength(),df.format(new Date())+"  位置输入越界，请检查！\n",attr);
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
					}else {		
						StyleConstants.setForeground(attr, Color.black);
						try {
							d.insertString(d.getLength(),df.format(new Date())+"  顺序表的第"+position+"位的值为："+value+"（位置从0开始）\n",attr);
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
						StyleConstants.setForeground(attr, Color.red);
					}
				}else {
					try {
						d.insertString(d.getLength(),df.format(new Date())+"  位置输入不合法，请重新输入！\n",attr);
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		get.setBounds(14, 206, 80, 43);
		contentPane.add(get);
		
		remove = new JButton("<html>  删除<br />(位置)</html>");
		remove.setEnabled(false);
		remove.setFont(new Font("宋体", Font.PLAIN, 15));
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = remove_textfield.getText();
				if(str.matches("[1-9]+[0-9]*")) {
					int position = Integer.parseInt(str);
					if(radioButton1.isSelected()) {
						int flag = myList1.remove(position);
						if(flag == -1) {
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  位置输入越界，请检查！\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
						}else if(flag == 0) {
							StyleConstants.setForeground(attr, Color.black);
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  删除第"+position+"号位置成功！\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
							StyleConstants.setForeground(attr, Color.red);
						}else {
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  删除第"+position+"号位置成功！由于空闲空间太大，已经自动缩小一半空间！\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
						}
					}else if(radioButton2.isSelected()) {
						int flag = myList2.remove(position);
						if(flag == -1) {
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  位置输入越界，请检查！\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
						}else if(flag == 0) {
							StyleConstants.setForeground(attr, Color.black);
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  删除第"+position+"号位置成功！\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
							StyleConstants.setForeground(attr, Color.red);
						}else {
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  删除第"+position+"号位置成功！由于空闲空间太大，已经自动缩小一半空间！\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
						}
					}else{
						int flag = myList3.remove(position);
						if(flag == -1) {
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  位置输入越界，请检查！\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
						}else if(flag == 0) {
							StyleConstants.setForeground(attr, Color.black);
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  删除第"+position+"号位置成功！\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
							StyleConstants.setForeground(attr, Color.red);
						}else {
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  删除第"+position+"号位置成功！由于空闲空间太大，已经自动缩小一半空间！\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
						}
					}
				}else {
					try {
						d.insertString(d.getLength(),df.format(new Date())+"  位置输入不合法，请重新输入！\n",attr);
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		remove.setBounds(188, 206, 80, 43);
		contentPane.add(remove);
		
		indexOf = new JButton("<html>  查找<br />(数据)</html>");
		indexOf.setEnabled(false);
		indexOf.setFont(new Font("宋体", Font.PLAIN, 15));
		indexOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton1.isSelected()) {
					int flag = myList1.indexOf(indexOf_textfield.getText());
					if(flag == -1) {
						try {
							d.insertString(d.getLength(),df.format(new Date())+"  没有找到元素"+indexOf_textfield.getText()+"\n",attr);
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
					}else {
						StyleConstants.setForeground(attr, Color.black);
						try {
							d.insertString(d.getLength(),df.format(new Date())+"  找到元素"+indexOf_textfield.getText()+"位置为："+flag+"！\n",attr);
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
						StyleConstants.setForeground(attr, Color.red);
					}
				}else if(radioButton2.isSelected()) {
					int flag = myList2.indexOf(indexOf_textfield.getText());
					if(flag == -1) {
						try {
							d.insertString(d.getLength(),df.format(new Date())+"  没有找到元素"+indexOf_textfield.getText()+"\n",attr);
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
					}else {
						StyleConstants.setForeground(attr, Color.black);
						try {
							d.insertString(d.getLength(),df.format(new Date())+"  找到元素"+indexOf_textfield.getText()+"位置为："+flag+"！\n",attr);
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
						StyleConstants.setForeground(attr, Color.red);
					}
				}else if(radioButton3.isSelected()) {
					int flag = myList3.indexOf(indexOf_textfield.getText());
					if(flag == -1) {
						try {
							d.insertString(d.getLength(),df.format(new Date())+"  没有找到元素"+indexOf_textfield.getText()+"\n",attr);
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
					}else {
						StyleConstants.setForeground(attr, Color.black);
						try {
							d.insertString(d.getLength(),df.format(new Date())+"  找到元素"+indexOf_textfield.getText()+"位置为："+flag+"！\n",attr);
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
						StyleConstants.setForeground(attr, Color.red);
					}
				}
			}
		});
		indexOf.setBounds(371, 206, 80, 43);
		contentPane.add(indexOf);
		
		insert = new JButton("<html>  (位置)<br />插入<br />(数据)</html>");
		insert.setEnabled(false);
		insert.setFont(new Font("宋体", Font.PLAIN, 10));
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton1.isSelected()) {
					String position = insert_position.getText();
					String data = insert_data.getText();
					if(position.matches("[1-9]+[0-9]*") && data.matches("^(0|[1-9][0-9]*|-[1-9][0-9]*)$")) {
						Integer dat = Integer.parseInt(data);
						int posi = Integer.parseInt(position);
						int flag = myList1.insert(posi, dat);
						if(flag == -1) {
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  位置输入越界，请检查！\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
						}else if(flag == 1) {
							StyleConstants.setForeground(attr, Color.black);
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  添加元素"+data+"成功！\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
							StyleConstants.setForeground(attr, Color.red);
						}else {
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  添加元素"+data+"成功！由于空闲空间太小，已经自动扩大一半空间！\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
						}
					}else {
						try {
							d.insertString(d.getLength(),df.format(new Date())+"  输入不合法，请重新输入！\n",attr);
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
					}
				}else if(radioButton2.isSelected()) {
					String position = insert_position.getText();
					String data = insert_data.getText();
					if(position.matches("[1-9]+[0-9]*") && data.matches("[0-9]+(.[0-9]+)?|-[0-9]+(.[0-9]+)?")) {
						Double dat = Double.parseDouble(data);
						int posi = Integer.parseInt(position);
						int flag = myList2.insert(posi, dat);
						if(flag == -1) {
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  位置输入越界，请检查！\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
						}else if(flag == 1) {
							StyleConstants.setForeground(attr, Color.black);
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  添加元素"+data+"成功！\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
							StyleConstants.setForeground(attr, Color.red);
						}else {
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  添加元素"+data+"成功！由于空闲空间太小，已经自动扩大一半空间！\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
						}
					}else {
						try {
							d.insertString(d.getLength(),df.format(new Date())+"  输入不合法，请重新输入！\n",attr);
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
					}
				}else if(radioButton3.isSelected()) {
					String position = insert_position.getText();
					String data = insert_data.getText();
					if(position.matches("[1-9]+[0-9]*")) {
						int posi = Integer.parseInt(position);
						int flag = myList3.insert(posi, data);
						if(flag == -1) {
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  位置输入越界，请检查！\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
						}else if(flag == 1) {
							StyleConstants.setForeground(attr, Color.black);
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  添加元素"+data+"成功！\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
							StyleConstants.setForeground(attr, Color.red);
						}else {
							try {
								d.insertString(d.getLength(),df.format(new Date())+"  添加元素"+data+"成功！由于空闲空间太小，已经自动扩大一半空间！\n",attr);
							} catch (BadLocationException e1) {
								e1.printStackTrace();
							}
						}
					}else {
						try {
							d.insertString(d.getLength(),df.format(new Date())+"  输入不合法，请重新输入！\n",attr);
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		insert.setBounds(585, 206, 80, 43);
		contentPane.add(insert);
	}
}
