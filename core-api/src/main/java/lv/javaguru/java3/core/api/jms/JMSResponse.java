package lv.javaguru.java3.core.api.jms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.javaguru.java3.core.api.common.ResponseStatus;

public class JMSResponse {

    @JsonProperty("command_id")
    private String commandId;

    @JsonProperty("correlation_id")
    private String correlationId;

    @JsonProperty("response_status")
    private ResponseStatus responseStatus;

    @JsonProperty("payload")
    private String payload;


    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public boolean isSuccess() {
        return ResponseStatus.SUCCESS.equals(responseStatus);
    }

}
