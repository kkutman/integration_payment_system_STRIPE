package peaksoft.dto;

public class CreatePayment {
    private Integer amount;
    private String featureRequest;

    public CreatePayment(Integer amount, String featureRequest) {
        this.amount = amount;
        this.featureRequest = featureRequest;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getFeatureRequest() {
        return featureRequest;
    }

    public void setFeatureRequest(String featureRequest) {
        this.featureRequest = featureRequest;
    }
}
