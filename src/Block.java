public class Block {

    private int previousHash;
    String[] transactions; //In real blockchains, the transactions will be own list of objects.

    private int blockHash;

    public Block(int previousHash, String[] transactions){
        this.previousHash = previousHash;
        this.transactions = transactions;
    }



}
