package txn

import java.security.PrivateKey
import java.security.PublicKey

class Transaction(val sender: PublicKey, val recipient: PublicKey, val value: Float, val inputs: List<TransactionInput>) {

    lateinit var transactionId: String
    lateinit var signature: ByteArray

    val outputs: ArrayList<TransactionOutput> = ArrayList()

    private fun calculateHash(): String {
        sequence++
        return StringUtil.applySha256(
                StringUtil.getStringFromKey(sender) +
                        StringUtil.getStringFromKey(recipient) +
                        value.toString() +
                        sequence
        )
    }

    fun generateSignature(privateKey: PrivateKey) {
        val data = StringUtil.getStringFromKey(sender) +
                StringUtil.getStringFromKey(recipient) +
                value.toString()

        signature = StringUtil.applyEcdsaSig(privateKey, data)
    }

    fun verifySignature(): Boolean {
        val data = StringUtil.getStringFromKey(sender) +
                StringUtil.getStringFromKey(recipient) +
                value.toString()

        return StringUtil.verifyEcdsaSig(sender, data, signature)
    }


    companion object {
        private var sequence: Int = 0
    }
}