package framework.model;

public class DefaultCompany extends DefaultCustomer implements Company{
    private final String numberOfEmployees;

    public DefaultCompany(String name, String street, String city, String state, String zip, String email, String numberOfEmployees) {
        super(name, street, city, state, zip, email);
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }
}
