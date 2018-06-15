import java.security.*
import java.util.*

class StringUtil {

    companion object {

        /**
         * Apply SHA256 hash algorithm to input data
         */
        fun applySha256(input: String): String {
            val digest: MessageDigest = MessageDigest.getInstance("SHA-256")

            val hash: ByteArray = digest.digest(input.toByteArray(Charsets.UTF_8))
            val hexString = StringBuffer()

            for (i in hash) {
                val hex = Integer.toHexString(0xff and i.toInt())
                if (hex.length == 1) hexString.append(0)
                hexString.append(hex)
            }
            return hexString.toString()
        }


        /**
         * Applies ECDSA signature and returns result as a ByteArray
         */
        fun applyEcdsaSig(privateKey: PrivateKey, input: String): ByteArray {
            val dsa = Signature.getInstance("ECDSA", "BC")
            dsa.initSign(privateKey)
            dsa.update(input.toByteArray())
            return dsa.sign()
        }

        /**
         * Verify an ECDSA signature and returns a Boolean
         */
        fun verifyEcdsaSig(publicKey: PublicKey, data: String, signature: ByteArray): Boolean {
            val ecdsaVerify = Signature.getInstance("ECDSA", "BC")
            ecdsaVerify.initVerify(publicKey)
            ecdsaVerify.update(data.toByteArray())
            return ecdsaVerify.verify(signature)
        }

        /**
         * Return string formatted key
         */
        fun getStringFromKey(key: Key): String {
            return Base64.getEncoder().encodeToString(key.encoded)
        }

    }

}
