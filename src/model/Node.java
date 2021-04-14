package model;

public class Node {
    private String id;
    private String sender;
    private String recipient;
    private String signature;
    private String requestId;
    private String[] schedule;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String[] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[] schedule) {
        this.schedule = schedule;
    }

//    public static float getLeader(){
//        byte[] maxTrustFactorNode = null;
//        float maxTrustFactor = 0;
//
//        float BCt = 1/2*Node.
//    }

    public static float getBlockchainTrustFactor(int numberOfDayLimit){
        return 0.0F;
    }

    public static float getTrustFactor(byte[] validator, int numberOfDayLimit, boolean iDontKnow){
        return 0.0F;
    }
}
