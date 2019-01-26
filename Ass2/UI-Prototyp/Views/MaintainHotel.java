package Views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

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
import Models.Destination;
import Models.Evaluation;
import Models.Hotel;
import Models.HotelActivity;
import Models.User;
import ViewModels.MaintainHotelModel;

import java.awt.BorderLayout;

public class MaintainHotel extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> cbx_activities = new JComboBox<String>();
	private JComboBox<Destination> cbx_Destinations = new JComboBox<Destination>();
	private JTextField txt_Country;

	public MaintainHotel(MaintainHotelModel model) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setPreferredSize(new Dimension(500, 660));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField txt_name = new JTextField(model.hotel.getName());
		txt_name.setFont(new Font("Dialog", Font.BOLD, 18));
		txt_name.setBounds(12, 12, 258, 25);
		contentPane.add(txt_name);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDestination.setBounds(12, 45, 130, 15);
		contentPane.add(lblDestination);
		

		cbx_Destinations.setBounds(120, 45, 150, 20);
		contentPane.add(cbx_Destinations);
		for(Destination dest : model.destinations.values())
			cbx_Destinations.addItem(dest);
		
		cbx_Destinations.setSelectedItem(model.destinations.get(model.hotel.getDestination().getId()));
		
		cbx_Destinations.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Destination dest = (Destination) arg0.getItem();
				txt_Country.setText(dest.getCountry());
			}
		});
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCountry.setBounds(12, 66, 86, 15);
		contentPane.add(lblCountry);
		
		txt_Country = new JTextField(model.hotel.getDestination().getCountry());
		txt_Country.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_Country.setBounds(120, 66, 150, 20);
		txt_Country.setEditable(false);
		contentPane.add(txt_Country);
		
		JLabel lblAdddress = new JLabel("Address:");
		lblAdddress.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAdddress.setBounds(12, 87, 86, 15);
		contentPane.add(lblAdddress);
		
		JTextField txt_Address = new JTextField(model.hotel.getAddress());
		txt_Address.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_Address.setBounds(120, 87, 342, 20);
		contentPane.add(txt_Address);
		
		JLabel lblStars = new JLabel("Stars:");
		lblStars.setFont(new Font("Dialog", Font.BOLD, 14));
		lblStars.setBounds(12, 108, 86, 15);
		contentPane.add(lblStars);
		
		JTextField txt_Stars = new JTextField(Integer.toString(model.hotel.getStars()));
		txt_Stars.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_Stars.setBounds(120, 108, 150, 20);
		contentPane.add(txt_Stars);
		
		JButton btnSubmit = new JButton("Save Changes");
		btnSubmit.setBounds(330, 12, 132, 25);
		contentPane.add(btnSubmit);
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.hotel.setDestination((Destination)cbx_Destinations.getSelectedItem());
				model.hotel.setName(txt_name.getText());
				model.hotel.setStars(Integer.parseInt(txt_Stars.getText()));
				model.hotel.setAddress(txt_Address.getText());
				HotelController.saveHotelData(model.hotel);
				MaintainHotel.this.dispose();
			}
		});
		
		JTextField txt_activity = new JTextField();
		txt_activity.setPreferredSize(new Dimension(80, 25));
		txt_activity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cbx_activities.setSelectedIndex(0);
			}
		});		

		JLabel lblActivities = new JLabel("Activities:");
		lblActivities.setFont(new Font("Dialog", Font.BOLD, 16));
		contentPane.add(lblActivities);
		JPanel activity_header = new JPanel();
		activity_header.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		activity_header.setBounds(12, 150, 450, 35);
		activity_header.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		cbx_activities.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				txt_activity.setText("");
			}
		});
		cbx_activities.setBounds(12, 51, 403, 24);
		cbx_activities.addItem(" ");
		for(String key : model.activities_suggestions)
			cbx_activities.addItem(key);
		JButton add_activity = new JButton("Add");
		add_activity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotelController.addActivity(cbx_activities.getSelectedItem().toString(), txt_activity.getText(), model.hotel);
				MaintainHotel.this.dispose();
			}
		});
		activity_header.add(lblActivities);
		activity_header.add(Box.createRigidArea(new Dimension(30,0)));
		activity_header.add(cbx_activities);
		activity_header.add(txt_activity);
		activity_header.add(add_activity);
		activity_header.setBorder(BorderFactory.createEmptyBorder());
		contentPane.add(activity_header);
		
		JPanel panel_activities = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_activities.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_activities.setLayout(new GridLayout(4,4));
		panel_activities.setAlignmentX(LEFT_ALIGNMENT);
		panel_activities.setBounds(12, 190, 500, 100);
		
		for(Map.Entry<String, Integer> entry : model.hotel.getActivities().entrySet())
		{
			JPanel activity = new JPanel();
			activity.setLayout(new FlowLayout(FlowLayout.LEADING));
			
			JLabel temp_label = new JLabel(entry.getKey());
			JButton delete_activity = new JButton("X");
			delete_activity.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					HotelController.deleteActivity(entry.getKey(), model.hotel);
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
        comment_pane.setLayout(new GridLayout(model.hotel.getEvaluations().size(),1));
        
        for (int i = 0; i < model.hotel.getEvaluations().size(); i++)
        {
    		Evaluation currentEval = model.hotel.getEvaluations().get(i);
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
    		User user = currentEval.getUser();
    		String customername = user.getFirstname() == null || user.getLastName() == null ? user.getEMail().toString()
			  : user.getFirstname() + " " + user.getLastName();
    		firstLine_pane.add(new JLabel("<html>Name: " + customername +
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
    			
    			rating += currentActivity.getName() + " " + currentActivity.getValue();
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
    		String date = currentEval.getDate();
    		rest_pane.add(new JLabel("<html><i>"+date+"</i></html>"));
    		rest_pane.setLayout(new BoxLayout(rest_pane, BoxLayout.Y_AXIS));
    		rest_pane.setBounds(5, 5, 30, 30);

    		evaluation.setBorder(new CompoundBorder(
    			    BorderFactory.createLineBorder(Color.black),
    			    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    		comment_pane.add(evaluation);

    		
        }
        
        JScrollPane scrollPane = new JScrollPane(comment_pane);
        scrollPane.setBounds(12, 340, 450, 300);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        contentPane.add(scrollPane);
        pack();
        setVisible(true);
		
	}
	public MaintainHotel() {}
}
