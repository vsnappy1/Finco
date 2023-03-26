package framework.factory;

import framework.model.TableConfigurer;
import framework.model.Account;
import framework.model.Frame;

public interface FrameFactory<T extends Account> {
	Frame getMainFrame(TableConfigurer<T> tableConfigurer);
	Frame getAddAccountFrame();
	Frame getDepositFrame(String accountNumber);
}
