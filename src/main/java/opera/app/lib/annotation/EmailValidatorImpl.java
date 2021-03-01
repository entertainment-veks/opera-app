package opera.app.lib.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidatorImpl implements ConstraintValidator<EmailValidator, String> {
    private static final String REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]*.";

    @Override
    public boolean isValid(String email, ConstraintValidatorContext cxt) {
        return email != null && email.matches(REGEX);
    }
}
