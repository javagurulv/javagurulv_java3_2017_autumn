package lv.javaguru.java3.core.exceptons;

public abstract class ApplicationException extends RuntimeException {

    private ResponseStatus resultStatus;


    public ApplicationException(ResponseStatus resultStatus) {
        this.resultStatus = resultStatus;
    }

    public ApplicationException(ResponseStatus resultStatus,
                                String message) {
        super(message);
        this.resultStatus = resultStatus;
    }

    public ResponseStatus getResultStatus() {
        return resultStatus;
    }

}
