package Views;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import Models.Category;
import Models.Evaluation;
import Models.Hotel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ShowHotel extends JFrame {

	private JPanel contentPane;

	public ShowHotel(Hotel hotel) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setPreferredSize(new Dimension(600, 600));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Name = new JLabel(hotel.getName());
		lbl_Name.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl_Name.setBounds(12, 12, 234, 15);
		contentPane.add(lbl_Name);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDestination.setBounds(12, 45, 130, 15);
		contentPane.add(lblDestination);
		
		JLabel lbl_Destination = new JLabel(hotel.getDestination());
		lbl_Destination.setFont(new Font("Dialog", Font.BOLD, 14));
		lbl_Destination.setBounds(120, 45, 150, 15);
		contentPane.add(lbl_Destination);
		
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCountry.setBounds(12, 66, 86, 15);
		contentPane.add(lblCountry);
		
		JLabel lbl_Country = new JLabel(hotel.getCountry());
		lbl_Country.setFont(new Font("Dialog", Font.BOLD, 14));
		lbl_Country.setBounds(120, 66, 150, 15);
		contentPane.add(lbl_Country);
		
		JLabel lblActivities = new JLabel("Activities:");
		lblActivities.setFont(new Font("Dialog", Font.ITALIC, 14));
		lblActivities.setBounds(12, 129, 101, 15);
		contentPane.add(lblActivities);
		
		JPanel panel_activities = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_activities.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_activities.setLayout(new GridLayout(5,4));
		panel_activities.setBounds(12, 147, 500, 100);
		contentPane.add(panel_activities);
		JPanel container = new JPanel();
		JScrollPane scrPane = new JScrollPane(container);
		getContentPane().add(scrPane);
		
		for(int i = 0; i < hotel.Activities.size(); i++)
		{
			JPanel activity = new JPanel();
			activity.setBorder(BorderFactory.createEmptyBorder(5, 1, 5, 5));
			
			Category temp_activity = hotel.Activities.get(i);
			JLabel temp_label = new JLabel(temp_activity.Name + ": " + temp_activity.Value);
			activity.add(temp_label);
			panel_activities.add(temp_label);
		}
		
		JButton btnRate = new JButton("Rate Hotel");
		btnRate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new RateHotel().setVisible(true);
				ShowHotel.this.dispose();
			}
		});
		btnRate.setBounds(290, 250, 120, 25);
		contentPane.add(btnRate);
		
		JLabel lblComments = new JLabel("Comments:");
		lblComments.setFont(new Font("Dialog", Font.BOLD, 16));
		lblComments.setBounds(12, 250, 234, 15);
		contentPane.add(lblComments);
		
        JPanel comment_pane = new JPanel();
        comment_pane.setLayout(new GridLayout(hotel.getEvaluations().size(),1));
        
        for (int i = 0; i < hotel.getEvaluations().size(); i++)
        {
    		JPanel evaluation = new JPanel();
    		Evaluation currentEval = hotel.getEvaluations().get(i);
    		evaluation.add(new JLabel("<html><u>Name:</u> " + currentEval.getCustomerName() +
    								  "&emsp;&emsp;<u>Nights:</u> "+ currentEval.getNightsSpend() + "</html>"));
    		evaluation.add(Box.createRigidArea(new Dimension(0, 15)));
    		String rating = "<html><u>Rating:</u> </br>";
    		int k = 0;
    		for(int j = 0; j < currentEval.getActivities().size(); j++)
    		{	
    			Category currentActivity = currentEval.getActivities().get(j);
    			
    			rating += currentActivity.Name + " " + currentActivity.Value;
    			if(j < currentEval.getActivities().size()-1)
    				rating += ", ";
    			k++;
    			if(k == 3)
    			{
    				rating += "<br/>";
    				k = 0;
    			}
    			
    		}
    		rating += "</html>";
    		evaluation.add(new JLabel(rating));
    		evaluation.add(Box.createRigidArea(new Dimension(0, 15)));
    		evaluation.add(new JLabel("<html><u>Comment:</u> " + currentEval.getComment()+"</html>"));
    		evaluation.add(Box.createRigidArea(new Dimension(0, 15)));
    		DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    		String date = df.format(currentEval.getDate());
    		evaluation.add(new JLabel("<html><i>"+date+"</i></html>"));
    		evaluation.setLayout(new BoxLayout(evaluation, BoxLayout.Y_AXIS));
    		evaluation.setBounds(5, 5, 30, 30);
    		comment_pane.add(evaluation);
    		evaluation.setBorder(new CompoundBorder(
    			    BorderFactory.createLineBorder(Color.black),
    			    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        }
        
        JScrollPane scrollPane = new JScrollPane(comment_pane);
        scrollPane.setBounds(12, 280, 400, 300);
        
        contentPane.add(scrollPane);
        pack();
        setVisible(true);
		

	}
	public ShowHotel() {}
}
