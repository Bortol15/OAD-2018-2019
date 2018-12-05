package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
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
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(13,1));
//        for (int i = 0; i < 13; i++) {
//    		JPanel comment = new JPanel();
//    		comment.add(new JLabel("comment"+i+"................."));
//    		comment.add(new JLabel("... stars"));
//    		comment.setLayout(new BoxLayout(comment, BoxLayout.Y_AXIS));
//    		comment.setBounds(5, 5, 30, 30);
//    		panel.add(comment);
//    		comment.setBorder(new CompoundBorder(
//    			    BorderFactory.createLineBorder(Color.black),
//    			    BorderFactory.createEmptyBorder(20, 20, 20, 20)));
//        }
//        
//        JScrollPane scrollPane = new JScrollPane(panel);
//        scrollPane.setBounds(50, 90, 400, 300);
//        
//        JPanel contentPane = new JPanel(null);
//        contentPane.setPreferredSize(new Dimension(800, 600));
//        contentPane.add(scrollPane);
//        setContentPane(contentPane);
//        pack();
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setVisible(true);

//        JPanel contentPane = new JPanel();
//        contentPane.setLayout(new GridLayout(1, 2, 2, 2));
//
//        JTextArea tArea2 = new JTextArea();
//        tArea2.setLineWrap(true);
//        tArea2.setText("I got a long long line of text in my JTextArea\nI got a long long line of text in my JTextArea\nI got a long long line of text in my JTextArea\n"
//        		+ "I got a long long line of text in my JTextArea\nI got a long long line of text in my JTextArea\nI got a long long line of text in my JTextArea"
//        		+ "I got a long long line of text in my JTextArea\nI got a long long line of text in my JTextArea\nI got a long long line of text in my JTextArea"
//        		+ "I got a long long line of text in my JTextArea\nI got a long long line of text in my JTextArea\nI got a long long line of text in my JTextArea"
//        		+ "I got a long long line of text in my JTextArea\nI got a long long line of text in my JTextArea\nI got a long long line of text in my JTextArea"
//        		+ "I got a long long line of text in my JTextArea\nI got a long long line of text in my JTextArea\nI got a long long line of text in my JTextArea"
//        		+ "I got a long long line of text in my JTextArea\nI got a long long line of text in my JTextArea\nI got a long long line of text in my JTextArea"
//        		+ "I got a long long line of text in my JTextArea\nI got a long long line of text in my JTextArea\nI got a long long line of text in my JTextArea"
//        		+ "I got a long long line of text in my JTextArea\nI got a long long line of text in my JTextArea\nI got a long long line of text in my JTextArea");
//
//        JScrollPane scroller2 = new JScrollPane();
//        scroller2.setViewportView(tArea2);
//
//        contentPane.add(scroller2);
//
//        setContentPane(contentPane);
//        setSize(400, 400);
//        setLocationByPlatform(true);
//        setVisible(true);
		
//		JTextArea textArea = new JTextArea(
//                "This is an editable JTextArea. " +
//                "A text area is a \"plain\" text component, " +
//                "which means that although it can display text " +
//                "in any font, all of the text is in the same font."
//        );
////        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
////        textArea.setLineWrap(true);	
////        textArea.setWrapStyleWord(true);
//        JScrollPane areaScrollPane = new JScrollPane(textArea);
//        areaScrollPane.setVerticalScrollBarPolicy(
//                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
////        areaScrollPane.setPreferredSize(new Dimension(200, 200));
////        areaScrollPane.setBorder(
////            BorderFactory.createCompoundBorder(
////                BorderFactory.createCompoundBorder(
////                                BorderFactory.createTitledBorder("Plain Text"),
////                                BorderFactory.createEmptyBorder(5,5,5,5)),
////                areaScrollPane.getBorder()));
//        getContentPane().add(areaScrollPane);
////        getContentPane().setLayout(null);
//      setSize(400, 400);
//      setLocationByPlatform(true);
//      setVisible(true);
		
//		JTextArea ta = new JTextArea();
//		ta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//		ta.setSize(100, 200);
//		JScrollPane sp = new JScrollPane(ta); 
//		getContentPane().add(sp);
//		getContentPane().setLayout(new BoxLayout(target, axis));
//		setSize(400, 400);
//		setLocationByPlatform(true);
//		setVisible(true);
		
//        JPanel comment_pane = new JPanel();
//        comment_pane.setLayout(new GridLayout(2,2));
//        
//        JScrollPane scrollPane = new JScrollPane(comment_pane);
//        scrollPane.setBounds(12, 280, 400, 300);
//        
//        getContentPane().add(scrollPane);
//        
//		setSize(400, 400);
//		setLocationByPlatform(true);
//		setVisible(true);
		
		setBounds(100, 100, 432, 244);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 39, 230, 128);
		getContentPane().add(scrollPane);
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
	}
}
