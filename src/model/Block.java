package model;

import java.util.List;

public class Block {
    private String currentBlockHash;
    private String previousBlockHash;
    private long timestamp;
    private String merkleRootTreeHash;
    private List<Node> transactions;
    private int blockSize;

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public String getCurrentBlockHash() {
        return currentBlockHash;
    }

    public void setCurrentBlockHash(String currentBlockHash) {
        this.currentBlockHash = currentBlockHash;
    }

    public String getPreviousBlockHash() {
        return previousBlockHash;
    }

    public void setPreviousBlockHash(String previousBlockHash) {
        this.previousBlockHash = previousBlockHash;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMerkleRootTreeHash() {
        return merkleRootTreeHash;
    }

    public void setMerkleRootTreeHash(String merkleRootTreeHash) {
        this.merkleRootTreeHash = merkleRootTreeHash;
    }

    public List<Node> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Node> transactions) {
        this.transactions = transactions;
    }
}
