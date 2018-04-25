import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class RestClient {

	public static void main(String[] args) throws IOException {
	
//		URL url = new URL("http://localhost:8080/mywebapp/customer/100029");
//		
//		InputStream is = url.openStream();
//		
//		InputStreamReader isr = new InputStreamReader(is);
//		BufferedReader br = new BufferedReader(isr);
//		
//		System.out.println(br.readLine());
		
		 RestTemplate template = new RestTemplate();
		 template.setErrorHandler(new CustomExceptionHandler(template));
		 
		 HttpHeaders headers = new HttpHeaders();
		 List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		 acceptableMediaTypes.add(MediaType.IMAGE_JPEG);
		 acceptableMediaTypes.add(MediaType.APPLICATION_XML);
		 headers.setAccept(acceptableMediaTypes);
		 
		 HttpEntity requestEntity = new HttpEntity(headers);
		 
		 HttpEntity<CustomerCollectionRepresentation> response = template.exchange("http://localhost:8080/mywebapp/customers",
				                              HttpMethod.GET, requestEntity, CustomerCollectionRepresentation.class);
		 
		 CustomerCollectionRepresentation result = response.getBody();
		 System.out.println(result);
		 }
}
