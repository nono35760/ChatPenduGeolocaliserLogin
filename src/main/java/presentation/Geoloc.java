package presentation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/geoloc")
public class Geoloc {

	/**
	 * R�cup�re les champs Login et Passwords du formLogin et controle
	 * identification
	 * 
	 * @param login
	 * @param password
	 * @return YES or NO
	 */
	@GET
	@Path("/geolocJson.html")
	public Response appelLogin(@QueryParam("login") String login, @QueryParam("password") String password) {

		System.out.println("GeolocJsonappel");

		Map<String, String> loginHM = new HashMap<String, String>();
		loginHM.put("riri", "azerty1");
		loginHM.put("fifi", "azerty2");
		loginHM.put("loulou", "azerty3");

		if (loginHM.containsKey(login) && password.equals(loginHM.get(login))) {
			return Response.status(200).entity("YES").build();
		} else {
			return Response.status(200).entity("NO").build();
		}

	}

	// ancienne fonction pour obtenir un mot � partir d'un array simpliste
	// @GET
	// @Path("/geolocWord.html")
	// public Response appelWord() {
	//
	// System.out.println("appelWord");
	//
	// List<String> listWords = new ArrayList<String>();
	//
	// listWords.add("Banana");
	// listWords.add("Tocard");
	// listWords.add("Schtroumpfette");
	// listWords.add("Camembert");
	// listWords.add("Armoire normande");
	// listWords.add("Cirage");
	// listWords.add("Singleton");
	// listWords.add("Ecole");
	//
	// int sizeArray = listWords.size();
	//
	// Random rand = new Random();
	// int randomNum = rand.nextInt(sizeArray);
	//
	// String randomWord = listWords.get(randomNum);
	//
	// // for()
	//
	// Map<String, Integer> hmWord = new HashMap<String, Integer>();
	//
	// for (int i = 0; i < randomWord.length(); i++) {
	// randomWord.charAt(i);
	// // hmWord.put(charAt(i), i));
	//
	// }
	//
	// return Response.status(200).entity("Le mot est : " + randomWord).build();
	//
	// }

	@GET
	@Path("/geolocWord2.html")
	public Response appelWord2(@Context ServletContext ctx) throws IOException {// @Context
																				// ServletContext
																				// ctx

		 System.out.println("appelWord2");
		
		 String line = null;
		 System.out.println(ctx.getContextPath());
		 BufferedReader br = null;
		
		 try {
		
		
		 br = new BufferedReader(new FileReader(ctx.getRealPath("/") +"dico3.txt"));
		 
		// br = new BufferedReader(new FileReader("C:/Users/guillaume.poe11/Downloads/rest1/rest1/src/main/resources/dico3.txt"));
		 
		
		 // getRealPath("/") signifie racine
		 //br = new BufferedReader(new FileReader(ctx.getRealPath("/") +
		// "dico.txt"));
		
		 //pour chercher le fichier dans un autre dossier que webapp
		 //br = new BufferedReader(new
		// FileReader(this.getClass().getResource("/").toString()));
		
		 line = br.readLine();
		
		 Random rand = new Random();
		 int randomNum = rand.nextInt(26800);
		 int i = 0;
		 // recup des lignes jusqu'� la ligne qui nous intéresse
		 while (line != null && i != randomNum) {
		 line = br.readLine();
		 i++;
		
		 }
		 br.close();
		
		 } catch (FileNotFoundException e) {
		 // TODO Auto-generated catch block
		 System.out.println("fichier non trouvé");
		 e.printStackTrace();
		 }

		 /////SI besoin d'un traitement de charset
//		String line = null;
//		File fileDir = new File("C:/Users/guillaume.poe11/workspace/ChatPenduGeoloc3/src/main/webapp/dico3.txt");
//		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));
///		line = in.readLine();
//
//		Random rand = new Random();
//		int randomNum = rand.nextInt(8);
//		int i = 0;
//		// recup des lignes jusqu'� la ligne qui nous intéresse
//		while (line != null && i != randomNum) {
//			line = in.readLine();
//			i++;
///		}
//		in.close();
///		System.out.println(line);
		return Response.status(200).entity(line).build();

	}

}
