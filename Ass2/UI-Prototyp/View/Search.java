package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import Controller.HotelController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Search extends JFrame {

	private JPanel contentPane;
	private JTable tbl_search_results;


	public Search() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 665, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Suchergebnisse");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 12, 165, 15);
		contentPane.add(lblNewLabel);
		
		String[] columnNames = {"Hotel",
                "Reiseziel",
                "Land"
                };
		
		Object[][] data = {
				{"Schlossberg Hotel","Graz","Österreich"},
				{"Hotel Alpina","Breil-Brigels","Schweiz"},
				{"Hôtel Lavaux","Genfer-See","Schweiz"},
				{"Apartment Sole di Pola","Pula","Kroatien"},
			    {"Palacio Ca Sa Galesa","Palma de Mallorca","Spanien"},
			};
		
		tbl_search_results = new JTable(data,columnNames);
		tbl_search_results.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotelController.showHotel();
			}
		});
		JScrollPane scrollPane = new JScrollPane(tbl_search_results);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setBounds(12, 39, 450, 301);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(tbl_search_results);

		/* Rechtsbündig */
		/*DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tbl_search_results.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
		tbl_search_results.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        tbl_search_results.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);*/


	}
}
