package lv.javaguru.java3.core.handlers;

import lv.javaguru.java3.core.api.DomainCommand;
import lv.javaguru.java3.core.api.DomainCommandResult;

public interface DomainCommandHandler<C extends DomainCommand, R extends DomainCommandResult> {

    R execute(C command);

    Class getCommandType();

}
