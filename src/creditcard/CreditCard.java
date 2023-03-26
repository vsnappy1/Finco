package creditcard;


import creditcard.database.InMemoryDatabase;
import creditcard.factory.CreditCardFrameFactory;
import creditcard.model.CreditCardAccount;
import creditcard.model.CreditCardTableConfigurer;
import framework.Finco;
import framework.database.Database;
import framework.factory.FrameFactory;

public class CreditCard extends Finco {
    public CreditCard() {
        super(CreditCard.class);
    }

    public static void main(String[] args){
        new CreditCard();
    }

    @Override
    public void onLoad() {
        Database<CreditCardAccount> database = new InMemoryDatabase();
        FrameFactory<CreditCardAccount> frameFactory = new CreditCardFrameFactory(database);
        frameFactory.getMainFrame(new CreditCardTableConfigurer()).show();
    }
}
