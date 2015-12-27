package kony.boot.client.internal;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import kony.boot.client.IApplicationRegistrationProperties;

public class ApplicationRegistrationPropertiesValidation
{

	private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	public static void validate(IApplicationRegistrationProperties applicationRegistrationProperties)
	{
		Set<ConstraintViolation<IApplicationRegistrationProperties>> violations;
		violations = validator.validate(applicationRegistrationProperties);
		if (violations.size() > 0)
		{
			throw new IllegalArgumentException(violations.toString());
		}

	}
}
