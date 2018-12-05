package ViewModels;

import javax.swing.JLabel;
import javax.swing.JSlider;


public class CategorySlider {

	public JLabel Name;
	public JSlider Slider;
	public JLabel Value;
	
	public CategorySlider(JLabel name, JSlider slider, JLabel value)
	{
		Name = name;
		Slider = slider;
		Value = value;
	}
}
