package textbook.two.view;


import textbook.two.pojo.User;
import textbook.two.service.impl.UserServiceImpl;
import textbook.two.util.UtilService;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;


public class LoginFrame extends JFrame {

	private UserServiceImpl userService = UtilService.getUserService();
	private JPanel contentPane;
	private JTextField userName_txt;
	private JPasswordField passWord_txt;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					//设置该窗口可见
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
	public LoginFrame() {
		//setResizable(false)正是使窗口可以最小化和关闭，但是不能被任意改变大小
		setResizable(false);

		// 改变系统默认字体
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
		setTitle("管理员登录");
		//设置用户在此窗体上单击“关闭”按钮时默认执行的操作
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口所在的位置和宽、高
		setBounds(100, 100, 550, 419);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label = new JLabel("欢迎访问高校教材管理系统");
		//label.setIcon(new ImageIcon(this.getClass().getResource("/images/book6.jpg")));
		label.setFont(new Font("宋体", Font.BOLD, 24));

		JLabel lblNewLabel = new JLabel("用户名：");
		//lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/user1.png")));

		JLabel label_1 = new JLabel("密  码：");
		//label_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/password1.png")));

		userName_txt = new JTextField();
		userName_txt.setColumns(10);

		passWord_txt = new JPasswordField();

		JButton button = new JButton("登录");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 登录方法引用
				loginActionPerformed(e);
			}
		});
		//button.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/登录设置.png")));

		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 重置方法引用
				resetValueActionPerformed(e);
			}
		});
		//button_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/重置.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(108, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(button)
									.addGap(85)
									.addComponent(button_1))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel)
										.addGap(6)
										.addComponent(userName_txt))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(label_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(passWord_txt, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED, 39, GroupLayout.PREFERRED_SIZE))
						.addComponent(label, Alignment.TRAILING))
					.addGap(103))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(43)
					.addComponent(label)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addComponent(userName_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addComponent(label_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							.addComponent(passWord_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(68, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);

		//设置JFrame居中显示
		this.setLocationRelativeTo(null);
	}

	/**
	 * 登录事件处理
	 *
	 */
	private void loginActionPerformed(ActionEvent evt) {
		// 从界面获取用户名和密码
		String userName = this.userName_txt.getText();
		String passWord = new String(this.passWord_txt.getPassword());
		// 判断用户名和密码是否为空
		if (userName.length()==0) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;// 结束方法，不再继续执行
		}
		if (passWord.length()==0) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}

		// 进行数据库连接
		User user = new User(userName, passWord);

		try {

			/**
			 * 将从数据库中获取的用户信息保存在currentUser里面，
			 * 若为null，则表示从数据库里获取的信息和从用户登陆界面获取的信息不一致，
			 * 即登录失败
			 */

			User login = userService.login(user);
			if (login != null) {
				//JOptionPane.showMessageDialog(null, "登录成功！");
				//销毁"登录成功！"的窗口
				JOptionPane.showMessageDialog(null, "登入成功！");

			}else{
				JOptionPane.showMessageDialog(null, "用户名或密码错误！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{

		}

	}

	/**
	 * 重置事件处理
	 *
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		// 将用户名和密码都设置为空
		this.userName_txt.setText("");
		this.passWord_txt.setText("");
	}

}
