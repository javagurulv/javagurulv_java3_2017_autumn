package lv.javaguru.java3.integrations.rest.dto;

import lv.javaguru.java3.core.exceptons.ValidationError;

import java.util.List;

public class ExceptionDTO {

    private String description;
    private List<ValidationError> errors;

    public ExceptionDTO() { }

    public ExceptionDTO(String description, List<ValidationError> errors) {
        this.description = description;
        this.errors = errors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }

    public void setErrors(List<ValidationError> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ExceptionDTO{" +
                "description='" + description + '\'' +
                ", errors=" + errors +
                '}';
    }
}
