package lv.javaguru.java3.common.dtos;

import java.util.List;

public class ExceptionDTO {

    private String description;
    private List<ValidationErrorDTO> errors;

    public ExceptionDTO() { }

    public ExceptionDTO(String description, List<ValidationErrorDTO> errors) {
        this.description = description;
        this.errors = errors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ValidationErrorDTO> getErrors() {
        return errors;
    }

    public void setErrors(List<ValidationErrorDTO> errors) {
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
