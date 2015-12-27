package kony.boot.client;

import java.util.Timer;
import java.util.TimerTask;

import kony.boot.client.internal.ApplicationRegister;
import kony.boot.client.internal.ApplicationRegistrationPropertiesValidation;

/**
 * ApplicationListener triggering registration after refresh/shutdown
 */
public class ApplicationResgisterListener
{
	private ApplicationRegister applicationRegister;

	private IApplicationRegistrationProperties registrationProperties;

	public ApplicationResgisterListener(IApplicationRegistrationProperties registrationProperties) {
		ApplicationRegistrationPropertiesValidation.validate(registrationProperties);
		this.applicationRegister = new ApplicationRegister(registrationProperties);
		this.registrationProperties = registrationProperties;
		addRegistrationListener();
		addUnregisrationListener();
	}
	
	/**
	 * TaskRegistrar that triggers the RegistratorTask every x seconds.
	 */
	private void addRegistrationListener()
	{
		Timer registrar = new Timer();
		TimerTask registratorTask = new TimerTask()
		{
			@Override
			public void run()
			{
				applicationRegister.register();
			}
		};
		registrar.schedule(registratorTask, 0, registrationProperties.getRegistrationInterval());
	}

	/**
	 * Add A thread that will derigister application on jvm shutdown is autoderigister property is set to true
	 */
	private void addUnregisrationListener()
	{
		if (registrationProperties.autoDeregister())
		{
			Runtime.getRuntime().addShutdownHook(new Thread(() -> applicationRegister.unregister()));
		}
	}
}
