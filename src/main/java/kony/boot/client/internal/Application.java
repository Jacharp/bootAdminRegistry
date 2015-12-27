package kony.boot.client.internal;

class Application
{
	private final String name;
	private final String managementUrl;
	private final String healthUrl;
	private final String serviceUrl;
	
	public Application(String name, String managementUrl, String healthUrl, String serviceUrl) {
	    this.name = name;
	    this.managementUrl = managementUrl;
	    this.healthUrl = healthUrl;
	    this.serviceUrl = serviceUrl;
    }

	public String getName()
	{
		return name;
	}

	public String getManagementUrl()
	{
		return managementUrl;
	}

	public String getHealthUrl()
	{
		return healthUrl;
	}

	public String getServiceUrl()
	{
		return serviceUrl;
	}

	@Override
    public int hashCode()
    {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((healthUrl == null) ? 0 : healthUrl.hashCode());
	    result = prime * result + ((managementUrl == null) ? 0 : managementUrl.hashCode());
	    result = prime * result + ((name == null) ? 0 : name.hashCode());
	    result = prime * result + ((serviceUrl == null) ? 0 : serviceUrl.hashCode());
	    return result;
    }

	@Override
    public boolean equals(Object obj)
    {
	    if (this == obj)
		    return true;
	    if (obj == null)
		    return false;
	    if (getClass() != obj.getClass())
		    return false;
	    Application other = (Application) obj;
	    if (healthUrl == null)
	    {
		    if (other.healthUrl != null)
			    return false;
	    }
	    else if (!healthUrl.equals(other.healthUrl))
		    return false;
	    if (managementUrl == null)
	    {
		    if (other.managementUrl != null)
			    return false;
	    }
	    else if (!managementUrl.equals(other.managementUrl))
		    return false;
	    if (name == null)
	    {
		    if (other.name != null)
			    return false;
	    }
	    else if (!name.equals(other.name))
		    return false;
	    if (serviceUrl == null)
	    {
		    if (other.serviceUrl != null)
			    return false;
	    }
	    else if (!serviceUrl.equals(other.serviceUrl))
		    return false;
	    return true;
    }

	@Override
    public String toString()
    {
	    return "Application [name=" + name + ", managementUrl=" + managementUrl + ", healthUrl=" + healthUrl
	            + ", serviceUrl=" + serviceUrl + "]";
    }
	
}
