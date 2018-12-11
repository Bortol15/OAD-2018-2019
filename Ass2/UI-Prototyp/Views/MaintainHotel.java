package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import Controllers.HotelController;
import Models.Category;
import Models.Evaluation;
import Models.Hotel;

public class MaintainHotel extends JFrame {

	private JPanel contentPane;

	public MaintainHotel(Hotel hotel) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setPreferredSize(new Dimension(500, 660));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Name = new JLabel(hotel.getName());
		lbl_Name.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl_Name.setBounds(12, 12, 234, 25);
		contentPane.add(lbl_Name);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDestination.setBounds(12, 45, 130, 15);
		contentPane.add(lblDestination);
		
		JTextField txt_Destination = new JTextField(hotel.getDestination());
		txt_Destination.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_Destination.setBounds(120, 45, 150, 20);
		contentPane.add(txt_Destination);
		
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCountry.setBounds(12, 66, 86, 15);
		contentPane.add(lblCountry);
		
		JTextField txt_Country = new JTextField(hotel.getCountry());
		txt_Country.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_Country.setBounds(120, 66, 150, 20);
		contentPane.add(txt_Country);
		
		JLabel lblAdddress = new JLabel("Address:");
		lblAdddress.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAdddress.setBounds(12, 87, 86, 15);
		contentPane.add(lblAdddress);
		
		JTextField txt_Address = new JTextField(hotel.getAddress());
		txt_Address.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_Address.setBounds(120, 87, 350, 20);
		contentPane.add(txt_Address);
		
		JLabel lblStars = new JLabel("Stars:");
		lblStars.setFont(new Font("Dialog", Font.BOLD, 14));
		lblStars.setBounds(12, 108, 86, 15);
		contentPane.add(lblStars);
		
		JTextField txt_Stars = new JTextField(Integer.toString(hotel.getStars()));
		txt_Stars.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_Stars.setBounds(120, 108, 150, 20);
		contentPane.add(txt_Stars);
		
		
		JLabel lblActivities = new JLabel("Activities:");
		lblActivities.setFont(new Font("Dialog", Font.BOLD, 16));
		contentPane.add(lblActivities);
		JPanel activity_header = new JPanel();
		activity_header.setBounds(12, 150, 400, 35);
		activity_header.setLayout(new FlowLayout(FlowLayout.LEFT));
		JComboBox<String> cbx_activities = new JComboBox<String>();
		cbx_activities.setBounds(12, 51, 403, 24);
		
		cbx_activities.addItem(" ");
		cbx_activities.addItem("Sauna");
		cbx_activities.addItem("Climbing");
		cbx_activities.addItem("Surfing");
		JButton add_activity = new JButton("Add Activity");
		add_activity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotelController.addActivity(cbx_activities.getSelectedItem().toString());
				MaintainHotel.this.dispose();
			}
		});
		activity_header.add(lblActivities);
		activity_header.add(Box.createRigidArea(new Dimension(50,0)));
		activity_header.add(cbx_activities);
		activity_header.add(add_activity);
		contentPane.add(activity_header);
		
		JPanel panel_activities = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_activities.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_activities.setLayout(new GridLayout(4,4));
		panel_activities.setAlignmentX(LEFT_ALIGNMENT);
		panel_activities.setBounds(12, 190, 500, 100);
		
		for(int i = 0; i < hotel.getActivities().size(); i++)
		{
			JPanel activity = new JPanel();
			activity.setLayout(new FlowLayout(FlowLayout.LEADING));
			
			Category temp_activity = hotel.getActivities().get(i);
			JLabel temp_label = new JLabel(temp_activity.Name + ": " + temp_activity.Value);
			JButton delete_activity = new JButton("X");
			delete_activity.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					HotelController.deleteActivity(temp_activity);
					MaintainHotel.this.dispose();
				}
			});
			delete_activity.setFont(new Font("X", Font.BOLD, 8));
			delete_activity.setPreferredSize(new Dimension(15,15));
			delete_activity.setMargin(new Insets(1,1,1,1));
			
			activity.add(temp_label);
			activity.add(delete_activity);
			panel_activities.add(activity);
		}
		contentPane.add(panel_activities);
				
		
		JLabel lblComments = new JLabel("Comments:");
		lblComments.setFont(new Font("Dialog", Font.BOLD, 16));
		lblComments.setBounds(12, 310, 234, 15);
		contentPane.add(lblComments);
		
        JPanel comment_pane = new JPanel();
        int nr = hotel.getEvaluations().size();
        comment_pane.setLayout(new GridLayout(hotel.getEvaluations().size(),1));
        
        for (int i = 0; i < hotel.getEvaluations().size(); i++)
        {
    		Evaluation currentEval = hotel.getEvaluations().get(i);
    		JPanel evaluation = new JPanel();
    		evaluation.setLayout(new BoxLayout(evaluation, BoxLayout.Y_AXIS));
    		evaluation.setAlignmentX(LEFT_ALIGNMENT);
    		
    		JPanel firstLine_pane = new JPanel();
    		firstLine_pane.setAlignmentX(Component.LEFT_ALIGNMENT);
    		evaluation.add(firstLine_pane);
    		firstLine_pane.setLayout(new BoxLayout(firstLine_pane, BoxLayout.X_AXIS));
    		  		
    		JPanel rest_pane = new JPanel();
    		rest_pane.setAlignmentX(Component.LEFT_ALIGNMENT);
    		evaluation.add(rest_pane);
    		rest_pane.setLayout(new BoxLayout(rest_pane, BoxLayout.Y_AXIS));
    		
  		
    		firstLine_pane.add(new JLabel("<html>Name: " + currentEval.getCustomerName() +
   								  "&emsp;&emsp;Nights: "+ currentEval.getNightsSpend() + "</html>"));
    		JLabel deleteEval = new JLabel("Delete Evaluation");
    		deleteEval.addMouseListener(new MouseAdapter() {
    			@Override
    			public void mouseClicked(MouseEvent e) {
    				HotelController.deleteEvaluation(currentEval);
    				MaintainHotel.this.dispose();
    			}
    		});
    		deleteEval.setForeground(Color.red);
    		firstLine_pane.add(deleteEval);

    		rest_pane.add(Box.createRigidArea(new Dimension(0, 15)));
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
    		rest_pane.add(new JLabel(rating));
    		rest_pane.add(Box.createRigidArea(new Dimension(0, 15)));
    		rest_pane.add(new JLabel("<html><u>Comment:</u> " + currentEval.getComment()+"</html>"));
    		rest_pane.add(Box.createRigidArea(new Dimension(0, 15)));
    		DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    		String date = df.format(currentEval.getDate());
    		rest_pane.add(new JLabel("<html><i>"+date+"</i></html>"));
    		rest_pane.setLayout(new BoxLayout(rest_pane, BoxLayout.Y_AXIS));
    		rest_pane.setBounds(5, 5, 30, 30);

    		evaluation.setBorder(new CompoundBorder(
    			    BorderFactory.createLineBorder(Color.black),
    			    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    		comment_pane.add(evaluation);

    		
        }
        
        JScrollPane scrollPane = new JScrollPane(comment_pane);
        scrollPane.setBounds(12, 340, 400, 300);
        
        contentPane.add(scrollPane);
        pack();
        setVisible(true);
		
	}
	public MaintainHotel() {
		

		}
}
