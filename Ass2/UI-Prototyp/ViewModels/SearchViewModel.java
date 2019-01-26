package ViewModels;

public class SearchViewModel {

	public Object[][] data;
	public String searchstring;
	
	public SearchViewModel(Object[][] data, String searchstring)
	{
		this.data = data;
		this.searchstring = searchstring;
	}
}
