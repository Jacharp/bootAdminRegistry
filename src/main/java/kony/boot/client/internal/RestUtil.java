package kony.boot.client.internal;

import java.util.Collections;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

class RestUtil
{

	private RestUtil()
	{
	}
	
	static HttpHeaders createJsonHttpHeaders()
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		return HttpHeaders.readOnlyHttpHeaders(headers);
	}
	
	// Default resttemplate with no authentification
	static RestTemplate createRestTemplate()
	{
		RestTemplate template = new RestTemplate();
		template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		return template;
	}
}
