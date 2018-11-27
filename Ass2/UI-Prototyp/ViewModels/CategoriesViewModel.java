package ViewModels;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JSlider;

public class CategoriesViewModel {

	public Map<String,JSlider> Sliders = new HashMap<String,JSlider>();
	public Map<String,JLabel> ValueLabels = new HashMap<String,JLabel>(); 
	public Map<String,JLabel> NameLabels = new HashMap<String,JLabel>(); 
}
