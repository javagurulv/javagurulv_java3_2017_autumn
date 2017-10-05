package lv.javaguru.java3.core.services;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.commands.DomainCommandResult;

public interface CommandExecutor {

    <T extends DomainCommandResult> T execute(DomainCommand<T> domainCommand);

}
