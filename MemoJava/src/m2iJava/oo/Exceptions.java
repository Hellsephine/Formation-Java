package m2iJava.oo;

public class Exceptions {

	
	public void MethodWithException() throws Exception 
	{
		// throw <instance d'Exception>
		throw new Exception();
	}
	
	public void MethodWhoRethrows() throws Exception
	{
		MethodWithException();
	}
	
	public void MethodWhoCatches()
	{
		try
		{
			MethodWithException();
		}
		catch (IllegalArgumentException e2)
		{
			// Prétraitement d'exception
			
			// On peut rethrow une exception
			throw e2;
		}
		catch (Exception e)
		{
			// Gérer proprement le cas particulier
		}
		finally
		{
			// Code toujours exécuté
		}
	}
	
	public void MethodWithRuntimeException(int n)
	{
		if (n < 0)
			throw new IllegalArgumentException("n must be positive.");
	}
}
