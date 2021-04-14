package jsf.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

	private String emailPattern = ".+@.+\\..+";
	
	@Override
	public void validate(FacesContext context, UIComponent argcomponent, Object value) throws ValidatorException {
		Pattern pattern = Pattern.compile(emailPattern);
		Matcher matcher = pattern.matcher(value.toString());
		System.out.println("Value" + value);
		
		if(!matcher.matches()) {
			FacesMessage msg = new FacesMessage("Email est invalide");
			throw new ValidatorException(msg);
		}
	}
}
