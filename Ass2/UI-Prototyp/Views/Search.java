package Views;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Controllers.HotelController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Search extends JFrame {

	private JPanel contentPane;
	private JTable tbl_search_results;


	public Search(Object[][] data) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 665, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Results");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 12, 165, 15);
		contentPane.add(lblNewLabel);
		
		if(data == null)
			return;
		
		String[] columnNames = {"Hotel", "Destination", "Country"};
		
		tbl_search_results = new JTable(data,columnNames);
		tbl_search_results.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		String whichHotel;
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if(arg0.getValueIsAdjusting()) // otherwise showHotel() is called twice!
				{
					whichHotel = tbl_search_results.getValueAt(tbl_search_results.getSelectedRow(), 0).toString();
					HotelController.showHotel(3);
				}
				else
				{
					tbl_search_results.clearSelection();
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(tbl_search_results);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setBounds(12, 39, 450, 301);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(tbl_search_results);

	}
	public Search() {}
}
