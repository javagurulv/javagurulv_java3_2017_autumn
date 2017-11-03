package lv.javaguru.java3.core.exceptons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Error {

    @JsonProperty("error_field")
    private String field;

    @JsonProperty("error_code")
    private String errorCode;

}
