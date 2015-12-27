package kony.boot.client.internal;

import kony.boot.client.IApplicationRegistrationProperties;

import org.junit.Test;

public class ApplicationRegistrationPropertiesValidationTest
{

	@Test
	public void should_not_throw_exception_if_all_is_valid()
	{
		// Given 
		IApplicationRegistrationProperties applicationRegistrationProperties = new IApplicationRegistrationProperties()
		{
			@Override
			public String getServiceUrl()
			{
				return "http:localhost:8080";
			}
			
			@Override
			public long getRegistrationInterval()
			{
				return 0;
			}
			
			@Override
			public String getManagementUrl()
			{
				return "http:localhost:8080";
			}
			
			@Override
			public String getHealthUrl()
			{
				return "http:localhost:8080/health";
			}
			
			@Override
			public String getAppplicationName()
			{
				return "Application Test";
			}
			
			@Override
			public String getAdminUrl()
			{
				return "http:localhost:8080";
			}
			
			@Override
			public boolean autoDeregister()
			{
				return false;
			}
		};
		
		//When
		ApplicationRegistrationPropertiesValidation.validate(applicationRegistrationProperties);
		
		//Then no execption must be throw
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void should_throw_exception_if_admin_url_is_empty()
	{
		// Given 
				IApplicationRegistrationProperties applicationRegistrationProperties = new IApplicationRegistrationProperties()
				{
					@Override
					public String getServiceUrl()
					{
						return "http:localhost:8080";
					}
					
					@Override
					public long getRegistrationInterval()
					{
						return 0;
					}
					
					@Override
					public String getManagementUrl()
					{
						return "http:localhost:8080";
					}
					
					@Override
					public String getHealthUrl()
					{
						return "http:localhost:8080/health";
					}
					
					@Override
					public String getAppplicationName()
					{
						return "Application Test";
					}
					
					@Override
					public String getAdminUrl()
					{
						return null;
					}
					
					@Override
					public boolean autoDeregister()
					{
						return false;
					}
				};
				
				//When
				ApplicationRegistrationPropertiesValidation.validate(applicationRegistrationProperties);
				
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void should_throw_exception_when_servie_url_is_not_a_valid_url()
	{
		// Given 
				IApplicationRegistrationProperties applicationRegistrationProperties = new IApplicationRegistrationProperties()
				{
					@Override
					public String getServiceUrl()
					{
						return "dummy url";
					}
					
					@Override
					public long getRegistrationInterval()
					{
						return 0;
					}
					
					@Override
					public String getManagementUrl()
					{
						return "http:localhost:8080";
					}
					
					@Override
					public String getHealthUrl()
					{
						return "http:localhost:8080/health";
					}
					
					@Override
					public String getAppplicationName()
					{
						return "Application Test";
					}
					
					@Override
					public String getAdminUrl()
					{
						return "http:localhost:8080";
					}
					
					@Override
					public boolean autoDeregister()
					{
						return false;
					}
				};
				
				//When
				ApplicationRegistrationPropertiesValidation.validate(applicationRegistrationProperties);
				
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void should_throw_exception_when_refresh_interval_is_negative()
	{
		// Given 
				IApplicationRegistrationProperties applicationRegistrationProperties = new IApplicationRegistrationProperties()
				{
					@Override
					public String getServiceUrl()
					{
						return "http:localhost:8080";
					}
					
					@Override
					public long getRegistrationInterval()
					{
						return -6;
					}
					
					@Override
					public String getManagementUrl()
					{
						return "http:localhost:8080";
					}
					
					@Override
					public String getHealthUrl()
					{
						return "http:localhost:8080/health";
					}
					
					@Override
					public String getAppplicationName()
					{
						return "Application Test";
					}
					
					@Override
					public String getAdminUrl()
					{
						return "http:localhost:8080";
					}
					
					@Override
					public boolean autoDeregister()
					{
						return false;
					}
				};
				
				//When
				ApplicationRegistrationPropertiesValidation.validate(applicationRegistrationProperties);
				
	}
}
