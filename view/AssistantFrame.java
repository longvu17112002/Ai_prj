package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class AssistantFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea outPanel;
	JButton recordBtn;
	Font pixelFontBold,pixelFontRegular;
	public AssistantFrame() throws IOException {
		init();
	}

	public void init() throws IOException {

		setBounds(100, 100, 650, 576);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setBackground(Color.white);
		panel.setBorder(null);

		JLabel titleLabel = new JLabel("ASSISTANT");
		titleLabel.setFont(new Font("Showcard Gothic", Font.BOLD, 30));
		panel.add(titleLabel);

		JPanel funcPanel = new JPanel();
		funcPanel.setBackground(Color.white);
		getContentPane().add(funcPanel, BorderLayout.SOUTH);

		recordBtn = new JButton("");
		recordBtn.setIcon(new ImageIcon(AssistantFrame.class.getResource("/icon/voice-recognition.png")));
		recordBtn.setActionCommand("record");
		recordBtn.setForeground(Color.LIGHT_GRAY);
		recordBtn.setBorder(null);
		recordBtn.setFocusable(false);
			
		funcPanel.add(recordBtn);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		outPanel = new JTextArea();
		outPanel.setFont(new Font("Sitka Text", Font.PLAIN, 23));
		outPanel.setBackground(Color.white);
		outPanel.setBorder(null);
		scrollPane.setViewportView(outPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public JTextArea getOutPanel() {
		return outPanel;
	}

	public JButton getRecordBtn() {
		return recordBtn;
	}
}
