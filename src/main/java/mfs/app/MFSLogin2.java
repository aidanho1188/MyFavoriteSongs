package mfs.app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MFSLogin2 extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField pwdPassword;
	private int mouseX, mouseY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MFSLogin2 frame = new MFSLogin2();
					frame.setVisible(true);
					frame.pack();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MFSLogin2() {
		setMinimumSize(new Dimension(670, 450));
		setPreferredSize(new Dimension(1280, 720));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 567);
		setUndecorated(true);

		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getX() + e.getX() - mouseX, getY() + e.getY() - mouseY);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});

		setContentPane(contentPane);

		JPanel freespacePanel = new JPanel() {
			protected void paintComponent(Graphics g) {
				Paint p = new GradientPaint(0.0f, 0.0f, new Color(250, 0, 246, 255), getWidth(), getHeight(),
						new Color(250, 237, 0, 255), true);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setPaint(p);
				g2d.fillRect(0, 0, getWidth(), getHeight());
			}
		};

		JPanel LoginPanel = new JPanel();
		LoginPanel.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.5f));

		Box usernameHorizontalBox = Box.createHorizontalBox();

		usernameField = new JTextField();
		usernameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (usernameField.getText().equals("Username")) {
					usernameField.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (usernameField.getText().isBlank()) {
					usernameField.setText("Username");
				}
			}
		});

		usernameField.setText("Username");
		usernameField.setSize(new Dimension(0, 14));
		usernameField.setFont(new Font("Verdana", Font.PLAIN, 14));
		usernameHorizontalBox.add(usernameField);
		usernameField.setColumns(10);

		Box passwordHorizontalBox = Box.createHorizontalBox();

		pwdPassword = new JPasswordField();
		pwdPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (pwdPassword.getText().equals("Password")) {
					pwdPassword.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (pwdPassword.getText().isBlank()) {
					pwdPassword.setText("Password");
				}
			}
		});
		pwdPassword.setText("Password");
		pwdPassword.setSize(new Dimension(0, 14));
		pwdPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwdPassword.setColumns(10);
		passwordHorizontalBox.add(pwdPassword);

		Box loginButtonHorizontalBox = Box.createHorizontalBox();

		JLabel LoginLabel = new JLabel("LOGIN");
		LoginLabel.setBackground(new Color(0, 0, 128));
		LoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LoginLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		LoginLabel.setForeground(new Color(0, 0, 0));

		Box commandsHorizontalBox = Box.createHorizontalBox();

		JLabel minimizeLabel_1 = new JLabel("\u2015");
		minimizeLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(ICONIFIED);
			}
		});
		minimizeLabel_1.setVerticalTextPosition(SwingConstants.TOP);
		minimizeLabel_1.setVerticalAlignment(SwingConstants.TOP);
		minimizeLabel_1.setSize(new Dimension(10, 20));
		minimizeLabel_1.setPreferredSize(new Dimension(10, 20));
		minimizeLabel_1.setMaximumSize(new Dimension(10, 20));
		minimizeLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		minimizeLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		minimizeLabel_1.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		minimizeLabel_1.setForeground(new Color(0, 0, 0));
		commandsHorizontalBox.add(minimizeLabel_1);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(15, 0));
		rigidArea_1.setMaximumSize(new Dimension(20, 0));
		rigidArea_1.setPreferredSize(new Dimension(20, 0));
		commandsHorizontalBox.add(rigidArea_1);

		JLabel MaximizeLabel_2 = new JLabel("\u2610");
		MaximizeLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (getExtendedState() == MAXIMIZED_BOTH) {
					setExtendedState(NORMAL);
				} else {
					setExtendedState(MAXIMIZED_BOTH);
				}

			}
		});
		MaximizeLabel_2.setBounds(new Rectangle(2, 2, 2, 2));
		MaximizeLabel_2.setSize(new Dimension(10, 20));
		MaximizeLabel_2.setPreferredSize(new Dimension(10, 20));
		MaximizeLabel_2.setMaximumSize(new Dimension(10, 20));
		MaximizeLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		MaximizeLabel_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		MaximizeLabel_2.setForeground(new Color(0, 0, 0));
		MaximizeLabel_2.setFont(new Font("Symbol", Font.BOLD, 16));
		commandsHorizontalBox.add(MaximizeLabel_2);

		Component rigidArea_1_1 = Box.createRigidArea(new Dimension(15, 0));
		rigidArea_1_1.setPreferredSize(new Dimension(20, 0));
		rigidArea_1_1.setMaximumSize(new Dimension(20, 0));
		commandsHorizontalBox.add(rigidArea_1_1);

		JLabel closeLabel_3 = new JLabel("X");
		closeLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(ABORT);
			}
		});
		closeLabel_3.setForeground(new Color(0, 0, 0));
		closeLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		commandsHorizontalBox.add(closeLabel_3);

		Box buttonsHorizontalBox = Box.createHorizontalBox();

		JButton guestButton = new JButton("Continue as Guest");
		guestButton.setForeground(new Color(0, 0, 0));
		guestButton.setBackground(new Color(255, 160, 122));
		guestButton.setBorder(new CompoundBorder());
		guestButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		guestButton.setPreferredSize(new Dimension(180, 50));
		guestButton.setMaximumSize(new Dimension(180, 50));
		buttonsHorizontalBox.add(guestButton);

		// add spaces between sign in as guest or login buttons
		Component rigidArea = Box.createRigidArea(new Dimension(15, 0));
		buttonsHorizontalBox.add(rigidArea);

		JButton registerButton = new JButton("Register");
		registerButton.setForeground(new Color(0, 0, 0));
		registerButton.setBackground(new Color(255, 160, 122));
		registerButton.setBorder(new CompoundBorder());
		registerButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		registerButton.setMaximumSize(new Dimension(150, 50));
		registerButton.setPreferredSize(new Dimension(150, 50));
		buttonsHorizontalBox.add(registerButton);
		GroupLayout gl_LoginPanel = new GroupLayout(LoginPanel);
		gl_LoginPanel.setHorizontalGroup(gl_LoginPanel.createParallelGroup(Alignment.TRAILING).addGroup(gl_LoginPanel
				.createSequentialGroup()
				.addGroup(gl_LoginPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_LoginPanel
						.createSequentialGroup().addContainerGap()
						.addGroup(gl_LoginPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(passwordHorizontalBox, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 307,
										Short.MAX_VALUE)
								.addComponent(usernameHorizontalBox, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
								.addComponent(loginButtonHorizontalBox, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
								.addComponent(buttonsHorizontalBox, 0, 0, Short.MAX_VALUE)))
						.addGroup(gl_LoginPanel.createSequentialGroup().addGap(135).addComponent(LoginLabel)))
				.addContainerGap(19, Short.MAX_VALUE))
				.addGroup(gl_LoginPanel.createSequentialGroup().addContainerGap(257, Short.MAX_VALUE).addComponent(
						commandsHorizontalBox, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)));
		gl_LoginPanel.setVerticalGroup(gl_LoginPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_LoginPanel
				.createSequentialGroup()
				.addComponent(commandsHorizontalBox, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
				.addGap(150).addComponent(LoginLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
				.addGap(40)
				.addComponent(usernameHorizontalBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
				.addGap(25)
				.addComponent(passwordHorizontalBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
				.addGap(25)
				.addComponent(loginButtonHorizontalBox, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
				.addGap(27)
				.addComponent(buttonsHorizontalBox, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(25, Short.MAX_VALUE)));

		JButton loginButton_1 = new JButton("Login");
		loginButton_1.setPreferredSize(new Dimension(300, 50));
		loginButton_1.setMinimumSize(new Dimension(60, 23));
		loginButton_1.setMaximumSize(new Dimension(350, 50));
		loginButton_1.setForeground(new Color(0, 0, 0));
		loginButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		loginButton_1.setBorder(new CompoundBorder());
		loginButton_1.setBackground(new Color(255, 0, 0));
		loginButtonHorizontalBox.add(loginButton_1);
		LoginPanel.setLayout(gl_LoginPanel);
		GroupLayout gl_freespacePanel = new GroupLayout(freespacePanel);
		gl_freespacePanel.setHorizontalGroup(gl_freespacePanel.createParallelGroup(Alignment.TRAILING).addGroup(
				gl_freespacePanel.createSequentialGroup().addContainerGap(550, Short.MAX_VALUE).addComponent(LoginPanel,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));
		gl_freespacePanel.setVerticalGroup(gl_freespacePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_freespacePanel.createSequentialGroup()
						.addComponent(LoginPanel, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE).addGap(0)));
		freespacePanel.setLayout(gl_freespacePanel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(freespacePanel, GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(freespacePanel, GroupLayout.PREFERRED_SIZE, 567, Short.MAX_VALUE));
		contentPane.setLayout(gl_contentPane);

	}
}
