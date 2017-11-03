package lv.javaguru.java3.core.exceptons;

import java.util.List;

public class ValidationError extends ApplicationException {

    private List<Error> errors;

    public ValidationError(ResponseStatus resultStatus) {
        super(resultStatus);
    }

    public ValidationError(ResponseStatus resultStatus,
                           List<Error> errors) {
        super(resultStatus);
        this.errors = errors;
    }

    public List<Error> getErrors() {
        return errors;
    }
}
