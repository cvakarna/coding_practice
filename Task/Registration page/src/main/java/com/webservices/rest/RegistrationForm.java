package com.webservices.rest;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.dao.UserDAO;
import com.dao.Impl.UserDAOImpl;
import com.models.Sequence;
import com.models.UUIDGenrator;
import com.models.User;
import com.services.UserService;

@Path("/for")
public class RegistrationForm {

	UserService service;;
	
	public RegistrationForm() {
		service=new UserService();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserById() throws JsonGenerationException, JsonMappingException, IOException{
		
		service.getUser();
		return null;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/generateID")
	public String getUsername() throws JsonGenerationException,
			JsonMappingException, IOException {
	
		String regNumber = "123456";
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(regNumber);

		return jsonInString;
	}

	@POST
	@Path("userDetail")
	@Consumes(MediaType.APPLICATION_JSON)
	public void insert(String msg,@Context HttpServletResponse response) throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		
		User user = null;
	
		try {
	
			user = mapper.readValue(msg, User.class);
	
		} catch (JsonParseException e) {

			e.printStackTrace();
	
		} catch (JsonMappingException e) {
	
			e.printStackTrace();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(user.getEducationDetails());
		UserDAO dao = new UserDAOImpl();
		boolean val = dao.insert(user);
		
		response.sendRedirect("./for/");
		
	}

	@GET
	@Path("generateUUID")
	@Produces(MediaType.APPLICATION_JSON)
	public String generateUUID() {

		UUIDGenrator uuid = new UUIDGenrator();
		uuid.setUuid(new Sequence().nextValue());

		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;

		try {
			jsonInString = mapper.writeValueAsString(uuid);

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return jsonInString;
	}
}
