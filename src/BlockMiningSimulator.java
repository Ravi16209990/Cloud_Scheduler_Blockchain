import model.Node;

import static utils.Constants.NUMBER_OF_DAY_LIMIT;

public class BlockMiningSimulator {

    public byte[] getLeader(){

        byte[] maxTrustFactorNode = null;
        float maxTrustFactor = 0;

        float BCt = 1/2* Node.getBlockchainTrustFactor(NUMBER_OF_DAY_LIMIT);

        for (byte[] validator : list){

            float TF = Node.getTrustFactor(validator,NUMBER_OF_DAY_LIMIT, true);

            if (TF > maxTrustFactor && TF <= BCt){
                maxTrustFactor = TF;
                maxTrustFactorNode = validator;
            }
        }
        return maxTrustFactorNode;
    }
}
