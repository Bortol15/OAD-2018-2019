package Views;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


import Controllers.HotelController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import Models.Category;
import Models.TREC;
import ViewModels.CategorySlider;
import ViewModels.HotelViewModel;

import java.awt.Font;



public class RateHotel extends JFrame {

	private JPanel contentPane;
	private JTextField txt_NightsSpend;
	private JButton btn_submit;
	private JLabel lbl_comment;
	private JLabel lblNewLabel;
	
	public RateHotel(HotelViewModel model) {
		if(model == null)
			return;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, model.CategorySliders.size()*20 + 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel(model.HotelName);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(12, 12, 251, 25);
		contentPane.add(lblNewLabel);

		for(CategorySlider catSlider : model.CategorySliders)
		{
			contentPane.add(catSlider.Name);
			contentPane.add(catSlider.Slider);
			contentPane.add(catSlider.Value);
		}
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 60 + model.CategorySliders.size()*20, 316, 292);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNights = new JLabel("Nights Spend:");
		lblNights.setBounds(0, 30, 98, 15);
		panel.add(lblNights);
		
		txt_NightsSpend = new JTextField();
		txt_NightsSpend.setBounds(116, 28, 37, 19);
		panel.add(txt_NightsSpend);
		txt_NightsSpend.setColumns(10);
		
		lbl_comment = new JLabel("Comment:");
		lbl_comment.setBounds(0, 57, 114, 15);
		panel.add(lbl_comment);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 84, 300, 170);
		panel.add(scrollPane);
		JTextArea comment = new JTextArea();
		comment.setLineWrap(true);
		scrollPane.setViewportView(comment);
		
		btn_submit = new JButton("Submit");
		btn_submit.setBounds(0, 267, 114, 25);
		panel.add(btn_submit);
		btn_submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.evaluation.setComment(comment.getText());
				int nights_spend = txt_NightsSpend.getText().isEmpty() ? 0 : Integer.parseInt(txt_NightsSpend.getText());
				model.evaluation.setNightsSpend(nights_spend);
				model.evaluation.setCustomerName(TREC.getInstance().getCurrentLoggedInUser().getFirstname());
				for(CategorySlider cat : model.CategorySliders)
					model.evaluation.getActivities().add(new Category(cat.Name.getText(), cat.Slider.getValue()));
				HotelController.submitEvaluation(model);
				RateHotel.this.dispose();
			}
		});
	}
}
