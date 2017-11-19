package lv.javaguru.java3.core;

import com.google.common.collect.Lists;
import lv.javaguru.java3.core.api.common.ResponseStatus;
import lv.javaguru.java3.core.api.exceptons.ValidationError;
import lv.javaguru.java3.core.api.exceptons.ValidationException;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.List;
import java.util.stream.Collectors;

public class ValidationExceptionMatches extends TypeSafeMatcher<ValidationException> {

    private ResponseStatus status;
    private List<ValidationError> errors;

    public static ValidationExceptionMatches validationException(ResponseStatus status,
                                                                 ValidationError error) {
        return new ValidationExceptionMatches(status, Lists.newArrayList(error));
    }

    public ValidationExceptionMatches(ResponseStatus status,
                                      List<ValidationError> errors) {
        this.status = status;
        this.errors = errors;
    }

    @Override
    protected boolean matchesSafely(ValidationException exception) {
        return status == exception.getResultStatus()
                && exception.getValidationErrors().size() == errors.size()
                && exception.getValidationErrors().containsAll(errors);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("expects status: " + status);
        description.appendText("expects errors following errors: ");
        description.appendValue(
                errors.stream()
                        .map(ValidationError::toString)
                        .collect(Collectors.joining(", "))
        );
    }
}
