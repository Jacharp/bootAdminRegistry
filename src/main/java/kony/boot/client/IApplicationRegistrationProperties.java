package kony.boot.client;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

public interface IApplicationRegistrationProperties
{
	// Admin property

	/**
	 * The admin servers url to register at
	 */
	@NotEmpty
	@URL 
	String getAdminUrl();
	
	
	/**
	 * @return Application name
	 */
	@NotEmpty
	String getAppplicationName();
	
	@NotEmpty
	@URL
	String getManagementUrl();
	
	@NotEmpty
	@URL
	String getServiceUrl();
	
	/**
	 * HealthUrl : Full url to know if application is UP
	 */
	@NotEmpty
	@URL
	String getHealthUrl();
	
	
	/**
	 * true if to remove the application from admin on application shutdown
	 * @return
	 */
	boolean autoDeregister();
	

	/**
	 * Refresh period in millisecond : Application must refresh itself to admin
	 * If the application is already register then nothing is do else it will be registered
	 */
	@Min(1)
	long getRegistrationInterval();

}
