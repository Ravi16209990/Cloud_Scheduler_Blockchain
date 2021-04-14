import org.mapdb.DBMaker;
import utils.Constants;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Main {

    //In blockchain,each block holds the signature(hashing) of the previous block. Digital signature of next block is based on
    //the digital signatureof current block and the current signature is based on previous signature. Hence if we change anything,
    // all complete chain will be changed

    //Note again if anyone changes anything at previous block, the digital signature of current block will change and so on

    public static void main(String[] args) {
        DBMaker.Maker dbConnection = DBMaker.fileDB(Constants.DB_MAKER_PATH).fileMmapEnable().fileLockDisable();
        dbConnection = dbConnection.transactionEnable();

        //Client Socket:
        Socket s = new Socket();
        try {
            s.connect( new InetSocketAddress(Constants.SERVER_IP_ADDRESS, Constants.PORT),100000);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
