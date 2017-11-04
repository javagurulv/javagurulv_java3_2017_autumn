package lv.javaguru.java3.core.exceptons;

public class ValidationErrorBuilder {

    private String field;
    private String errorCode;
    private String description;

    private ValidationErrorBuilder() {}

    public static ValidationErrorBuilder createValidationError() {
        return new ValidationErrorBuilder();
    }

    public ValidationError build() {
        ValidationError error = new ValidationError();
        error.setField(field);
        error.setErrorCode(errorCode);
        error.setDescription(description);
        return error;
    }

    public ValidationErrorBuilder withField(String field) {
        this.field = field;
        return this;
    }

    public ValidationErrorBuilder withErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public ValidationErrorBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

}
