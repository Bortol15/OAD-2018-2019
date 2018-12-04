package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;

public class TestFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
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
	public TestFrame() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(13,1));
        for (int i = 0; i < 13; i++) {
    		JPanel comment = new JPanel();
    		comment.add(new JLabel("comment"+i+"................."));
    		comment.add(new JLabel("... stars"));
    		comment.setLayout(new BoxLayout(comment, BoxLayout.Y_AXIS));
    		comment.setBounds(5, 5, 30, 30);
    		panel.add(comment);
    		comment.setBorder(new CompoundBorder(
    			    BorderFactory.createLineBorder(Color.black),
    			    BorderFactory.createEmptyBorder(20, 20, 20, 20)));
        }
        
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(50, 90, 400, 300);
        
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(800, 600));
        contentPane.add(scrollPane);
        setContentPane(contentPane);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
	}
}
