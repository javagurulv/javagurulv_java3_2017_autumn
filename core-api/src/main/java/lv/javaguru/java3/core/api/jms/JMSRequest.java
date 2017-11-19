package lv.javaguru.java3.core.api.jms;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JMSRequest {

    @JsonProperty("command_id")
    private String commandId;

    @JsonProperty("correlation_id")
    private String correlationId;

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

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
