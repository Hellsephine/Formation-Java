package m2iJava.oo;

import java.util.function.Consumer;

public class ExampleAsyncTheoric {

	private Consumer<String> response;
	
	public void GetFromServer(String url, Consumer<String> response)
	{
		this.response = response;
		
		// Call server
	}
	
	public void Check() // appelé régulièrement par le framework
	{
		// Regarder si le serveur a répondu
		
		if (true) // le serveur a répondu
			response.accept("réponse serveur");
		
		// Sinon on rend la main
	}
}
