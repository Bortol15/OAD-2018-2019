package Views;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Controllers.HotelController;
import ViewModels.SearchViewModel;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Search extends JFrame {

	private JPanel contentPane;
	private JTable tbl_search_results;


	public Search(SearchViewModel model) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Results for \"" + model.searchstring + "\"");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(30, 12, 250, 15);
		contentPane.add(lblNewLabel);
		
		if(model.data == null)
			return;
		
		String[] columnNames = {"Hotel", "Destination", "Country", "id"};
		
		tbl_search_results = new JTable(model.data,columnNames);
		tbl_search_results.removeColumn(tbl_search_results.getColumnModel().getColumn(3));
		tbl_search_results.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if(arg0.getValueIsAdjusting()) // otherwise showHotel() is called twice!
				{
					int id = Integer.parseInt(tbl_search_results.getModel().getValueAt(tbl_search_results.getSelectedRow(), 3).toString());
					HotelController.showHotel(id);
				}
				else
				{
					tbl_search_results.clearSelection();
				}
			}
		});
		JScrollPane jsp = new JScrollPane(tbl_search_results);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		jsp.setBounds(30, 39, 450, 301);
		contentPane.add(jsp);
		
		jsp.setViewportView(tbl_search_results);

	}
	public Search() {}
}
