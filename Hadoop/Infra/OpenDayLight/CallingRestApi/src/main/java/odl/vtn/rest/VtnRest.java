package odl.vtn.rest;

public interface VtnRest {
	
	public void get(String requestResource) ;
	public void post(String vtnName, String requestResource) ;
	public void put(String requestBody, String requestURI);
	public void delete(String requestURI);
	
}
