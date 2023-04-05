package model.user;

public class IncreaseCreditRequest extends Request{
    private final Customer customer;
    private double additionalCredit;

    public IncreaseCreditRequest(Customer customer, double additionalCredit){
        super(RequestType.CREDIT_INCREASE_REQUEST);
        this.customer=customer;
        this.additionalCredit=additionalCredit;
    }

    public double getAdditionalCredit() {
        return additionalCredit;
    }

    public void setAdditionalCredit(double additionalCredit) {
        this.additionalCredit = additionalCredit;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "user name: " + customer.getUserName() + "additional credit: " + additionalCredit + super.toString();
    }
}
