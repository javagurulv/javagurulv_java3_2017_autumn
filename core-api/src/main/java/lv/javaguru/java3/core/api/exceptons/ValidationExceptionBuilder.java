package lv.javaguru.java3.core.api.exceptons;

import java.util.ArrayList;
import java.util.List;

public class ValidationExceptionBuilder {

    private ResponseStatus status;
    private String message;
    private List<ValidationError> errors = new ArrayList<>();

    private ValidationExceptionBuilder() { }

    public static ValidationExceptionBuilder createValidationException() {
        return new ValidationExceptionBuilder();
    }

    public static ValidationExceptionBuilder createValidationException(ResponseStatus status) {
        return new ValidationExceptionBuilder().with(status);
    }

    public ValidationException build() {
        ValidationError[] errorsArr = errors.stream().toArray(ValidationError[]::new);
        return new ValidationException(status, message, errorsArr);
    }

    public ValidationExceptionBuilder with(ResponseStatus status) {
        this.status = status;
        return this;
    }

    public ValidationExceptionBuilder withMessage(String message) {
        this.message = message;
        return this;
    }

    public ValidationExceptionBuilder with(ValidationError error) {
        this.errors.add(error);
        return this;
    }

    public ValidationExceptionBuilder with(ValidationErrorBuilder errorBuilder) {
        this.errors.add(errorBuilder.build());
        return this;
    }

    public ValidationExceptionBuilder with(List<ValidationError> errors) {
        this.errors.addAll(errors);
        return this;
    }

}
