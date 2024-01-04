package mfs.app;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.Box;
import java.awt.Insets;
import javax.swing.border.CompoundBorder;

import mfs.sql.SQLEngine;
import mfs.sql.SQLRetriever;
import mfs.sql.SQLUpdater;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.LayoutStyle.ComponentPlacement;

public class MFSRegister extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField passwordField;
	private JPasswordField confPassword;
	SQLEngine engine = new SQLEngine();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MFSRegister frame = new MFSRegister();
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
	public MFSRegister() {
		setSize(new Dimension(445, 621));
		setResizable(false);
		setPreferredSize(new Dimension(445, 720));
		setForeground(new Color(255, 99, 71));
		setBackground(new Color(255, 99, 71));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(620, 100, 446, 621);
		contentPane = new JPanel();
//		FlowLayout flowLayout_1 = (FlowLayout) contentPane.getLayout();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(0, 0, 51));
		headerPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		JPanel loginPanel = new JPanel() {
			   protected void paintComponent(Graphics g) {
			      Paint p = new GradientPaint(0.0f, 0.0f, new Color(250, 0, 246, 255),
			       getWidth(), getHeight(), new Color(250, 237, 0, 255), true);
			      Graphics2D g2d = (Graphics2D)g;
			      g2d.setPaint(p);
			      g2d.fillRect(0, 0, getWidth(), getHeight());
			   }
			};
		
		Box usernameHorizontalBox = Box.createHorizontalBox();
		usernameHorizontalBox.setPreferredSize(new Dimension(250, 20));
		usernameHorizontalBox.setMaximumSize(new Dimension(250, 20));
		
		Box buttonsHorizontalBox = Box.createHorizontalBox();
		buttonsHorizontalBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		Box passwordHorizontalBox = Box.createHorizontalBox();
		passwordHorizontalBox.setMaximumSize(new Dimension(250, 20));
		
		JLabel passwordLabel = new JLabel("Password:   ");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		passwordHorizontalBox.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setColumns(10);
		passwordHorizontalBox.add(passwordField);
		
		JButton loginButton = new JButton("Register");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!passwordField.getText().equals(confPassword.getText())) {
					JOptionPane.showMessageDialog(null, "Password not matched!", "Error", JOptionPane.ERROR_MESSAGE);
					passwordField.setText("");
					confPassword.setText("");
				} else if(passwordField.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Password Field Cannot Be Empty!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					try {
						if(engine.verifyUser(usernameField.getText())) {
							JOptionPane.showMessageDialog(null, "User Already Existed!", "Error", JOptionPane.ERROR_MESSAGE);
						} else {
							engine.addUser(usernameField.getText(), passwordField.getText());
							JOptionPane.showMessageDialog(null, "Account Successfully Created!", "Welcome!", JOptionPane.INFORMATION_MESSAGE);
							if(JOptionPane.OK_OPTION==0) {
								dispose();
							}
						}
						
					} catch (IOException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		loginButton.setMargin(new Insets(20, 14, 2, 14));
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(new Color(0, 0, 51));
		loginButton.setBorder(new CompoundBorder());
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		loginButton.setMinimumSize(new Dimension(60, 23));
		loginButton.setPreferredSize(new Dimension(150, 50));
		loginButton.setMaximumSize(new Dimension(500, 50));
		buttonsHorizontalBox.add(loginButton);
		
		JLabel usernameLabel = new JLabel("Username:  ");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		usernameHorizontalBox.add(usernameLabel);
		
		usernameField = new JTextField();
		usernameField.setMinimumSize(new Dimension(5, 20));
		usernameField.setFont(new Font("Verdana", Font.PLAIN, 14));
		usernameHorizontalBox.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		GroupLayout gl_headerPanel = new GroupLayout(headerPanel);
		gl_headerPanel.setHorizontalGroup(
			gl_headerPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.TRAILING, gl_headerPanel.createSequentialGroup()
					.addGap(177)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(173))
		);
		gl_headerPanel.setVerticalGroup(
			gl_headerPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.TRAILING, gl_headerPanel.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
		);
		headerPanel.setLayout(gl_headerPanel);
		
		JLabel lblNewLabel_1 = new JLabel("Sign In with an Existing Account");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblNewLabel_2 = new JLabel("or");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		Box passwordHorizontalBox_1 = Box.createHorizontalBox();
		passwordHorizontalBox_1.setMaximumSize(new Dimension(250, 20));
		
		JLabel passwordLabel_1 = new JLabel("Confirm Password:   ");
		passwordLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		passwordHorizontalBox_1.add(passwordLabel_1);
		
		confPassword = new JPasswordField();
		confPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		confPassword.setColumns(10);
		passwordHorizontalBox_1.add(confPassword);
		GroupLayout gl_loginPanel = new GroupLayout(loginPanel);
		gl_loginPanel.setHorizontalGroup(
			gl_loginPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addGap(202)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(202, Short.MAX_VALUE))
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addGap(99)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
					.addGap(100))
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_loginPanel.createSequentialGroup()
							.addComponent(passwordHorizontalBox_1, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_loginPanel.createSequentialGroup()
							.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(buttonsHorizontalBox, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
								.addComponent(usernameHorizontalBox, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
								.addComponent(passwordHorizontalBox, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))
							.addGap(17))))
		);
		gl_loginPanel.setVerticalGroup(
			gl_loginPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addGap(89)
					.addComponent(usernameHorizontalBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(passwordHorizontalBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(passwordHorizontalBox_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addComponent(buttonsHorizontalBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(lblNewLabel_2)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addContainerGap(135, Short.MAX_VALUE))
		);
		loginPanel.setLayout(gl_loginPanel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE)
				.addComponent(loginPanel, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(83)
					.addComponent(loginPanel, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);

	}
}
