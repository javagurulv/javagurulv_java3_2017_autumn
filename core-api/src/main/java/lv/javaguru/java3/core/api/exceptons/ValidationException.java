package lv.javaguru.java3.core.api.exceptons;

import lv.javaguru.java3.core.api.common.ResponseStatus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidationException extends ApplicationException {

    private List<ValidationError> validationErrors;

    public ValidationException(ResponseStatus resultStatus) {
        super(resultStatus);
    }

    public ValidationException(ResponseStatus resultStatus,
                               ValidationError ... validationErrors) {
        super(resultStatus);
        this.validationErrors = Arrays.stream(validationErrors).collect(Collectors.toList());
    }

    public ValidationException(ResponseStatus resultStatus,
                               String message,
                               ValidationError ... validationErrors) {
        super(resultStatus, message);
        this.validationErrors = Arrays.stream(validationErrors).collect(Collectors.toList());
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    @Override
    public String toString() {
        return "ValidationException{" +
                "validationErrors=" + validationErrors +
                '}';
    }
}
