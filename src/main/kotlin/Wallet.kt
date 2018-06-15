import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.PublicKey
import java.security.SecureRandom
import java.security.spec.ECGenParameterSpec

class Wallet {

    lateinit var publicKey: PublicKey
    lateinit var privateKey: PrivateKey

    init {
        generateKeyPair()
    }

    fun generateKeyPair() {
        val keyGen = KeyPairGenerator.getInstance("ECDSA", "BC")
        val random = SecureRandom.getInstance("SHA1PRNG")
        val ecSpec = ECGenParameterSpec("prime192v1")

        // Initialize the key generator and generate a keypair
        keyGen.initialize(ecSpec, random)

        val keyPair = keyGen.genKeyPair()

        privateKey = keyPair.private
        publicKey = keyPair.public

        println("Public Key $publicKey")
        println("Private Key $privateKey")
    }
}