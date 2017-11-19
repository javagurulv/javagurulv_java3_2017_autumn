package lv.javaguru.java3.core.api.exceptons;

import lv.javaguru.java3.core.api.common.ResponseStatus;

public class InternalServerException extends ApplicationException {

    public InternalServerException() {
        super(ResponseStatus.INTERNAL_SERVER_ERROR);
    }
}
