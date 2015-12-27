package kony.boot.client.internal;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import kony.boot.client.IApplicationRegistrationProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class ApplicationRegister
{
	private RestTemplate restTemplate;
	private Logger logger = LoggerFactory.getLogger(ApplicationRegister.class);

	private final AtomicReference<String> registeredId = new AtomicReference<String>();
	
	private final static HttpHeaders HTTP_HEADERS = RestUtil.createJsonHttpHeaders();

	/**
	 * The admin rest-api path.
	 */
	private static final String appliRegisterPath = "api/applications";

	private String registerUrl;

	private IApplicationRegistrationProperties registrationProperties;

	public ApplicationRegister(IApplicationRegistrationProperties registrationProperties) {
		this.registrationProperties = registrationProperties;
		registerUrl = registrationProperties.getAdminUrl() + "/" + appliRegisterPath;
		this.restTemplate = RestUtil.createRestTemplate();
	}

	public boolean register()
	{
		Application self = null;
		try
		{
			self = createApplication();
			@SuppressWarnings("rawtypes")
			ResponseEntity<Map> response = restTemplate.postForEntity(registerUrl, new HttpEntity<Application>(self,
					HTTP_HEADERS), Map.class);

			if (response.getStatusCode().equals(HttpStatus.CREATED))
			{

				if (registeredId.compareAndSet(null, response.getBody().get("id").toString()))
				{
					logger.info("Application registered itself as {}", response.getBody());
				}
				else
				{
					logger.debug("Application refreshed itself as {}", response.getBody());
				}

				return true;
			}
			else
			{
				logger.warn("Application failed to registered itself as {}. Response: {}", self, response.toString());
			}
		} catch (Exception ex)
		{
			logger.warn("Failed to register application as {} at admin ({}): {}", self, registrationProperties.getAdminUrl(),
			        ex.getMessage());
		}

		return false;
	}

	private Application createApplication()
	{
		return new Application(registrationProperties.getAppplicationName(), registrationProperties.getManagementUrl(),
		        registrationProperties.getHealthUrl(), registrationProperties.getServiceUrl());
	}

	public void unregister()
	{
		String id = registeredId.get();
		if (id != null)
		{
			try
			{
				restTemplate.delete(registrationProperties.getAdminUrl() + "/" + id);
				registeredId.set(null);
				logger.info("Unregisterr application (id={}) at admin ({})", id,
				        registrationProperties.getAdminUrl());
			} catch (Exception ex)
			{
				logger.warn("Failed to unregister application (id={}) at admin ({}): {}", id,
				        registrationProperties.getAdminUrl(), ex.getMessage());
			}
		}
	}
}
