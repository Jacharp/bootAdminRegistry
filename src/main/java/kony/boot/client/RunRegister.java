package kony.boot.client;



public class RunRegister
{
	public static void main(String[] args) throws InterruptedException
	{
		
		ApplicationResgisterListener applicationResgisterListener = new ApplicationResgisterListener(applicationRegistrationProperties);
		Thread.sleep(120000);
		

	}
	
	static IApplicationRegistrationProperties applicationRegistrationProperties = new IApplicationRegistrationProperties()
	{
		@Override
		public String getServiceUrl()
		{
			return "http://localhost:8090";
		}
		
		@Override
		public long getRegistrationInterval()
		{
			return 60000;
		}
		
		@Override
		public String getManagementUrl()
		{
			return "http://localhost:8090";
		}
		
		@Override
		public String getHealthUrl()
		{
			return "http://localhost:8090/health";
		}
		
		@Override
		public String getAppplicationName()
		{
			return "Application Test";
		}
		
		@Override
		public String getAdminUrl()
		{
			return "http://localhost:8080";
		}
		
		@Override
		public boolean autoDeregister()
		{
			return true;
		}
	};
	

}
