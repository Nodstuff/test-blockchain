import java.security.MessageDigest

class StringUtil {

    companion object {

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

    }

}
