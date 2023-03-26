package framework;

import framework.database.Database;
import framework.database.DefaultDatabase;
import framework.factory.DefaultFrameFactory;
import framework.factory.FrameFactory;
import framework.model.DefaultAccount;
import framework.model.DefaultTableConfigurer;

public class Finco {
	
	public Finco(Class cls) {
		System.out.println("Starting "+cls.getName());
		onLoad();
	}

	public static void main(String[] args) {
		new Finco(Finco.class);
	}
	
	public void onLoad() {
		Database<DefaultAccount> database = new DefaultDatabase();
		FrameFactory<DefaultAccount> frameFactory = new DefaultFrameFactory<>(database);
		frameFactory.getMainFrame(new DefaultTableConfigurer()).show();
	}
}
