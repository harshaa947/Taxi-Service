import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class checker
{
	public static void main (String args [])
	{
		BufferedReader br = null;
		TaxiService r = new TaxiService();

		try {
			String actionString;
			br = new BufferedReader(new FileReader(args[0]));

			while ((actionString = br.readLine()) != null) {
				try{
				r.performAction(actionString);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}
