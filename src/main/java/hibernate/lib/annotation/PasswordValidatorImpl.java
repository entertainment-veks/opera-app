package hibernate.lib.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordValidatorImpl
        implements ConstraintValidator<PasswordValidator, Object> {

    private String field;
    private String fieldMatch;

    public void initialize(PasswordValidator constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(Object password,
                           ConstraintValidatorContext context) {

        Object fieldValue = new BeanWrapperImpl(password)
                .getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(password)
                .getPropertyValue(fieldMatch);

        if (fieldValue != null) {
            return fieldValue.equals(fieldMatchValue);
        } else {
            return fieldMatchValue == null;
        }
    }
}
