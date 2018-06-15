import java.util.*

class Block(private val data: String, val previousHash: String, private val timestamp: Long = Date().time) {

    private var nonce: Int = 0

    var hash: String

    init {
        hash = calculateHash()
    }

    fun calculateHash(): String {
        return StringUtil.applySha256(previousHash + timestamp.toString() + nonce.toString() + data)
    }

    fun mineBlock(difficulty: Int) {

        while (hash.substring(0, difficulty) != hashTarget) {
            nonce++
            hash = calculateHash()
        }
        println("Block Mined!! $hash")
    }

    companion object {
        const val difficulty: Int = 5
        val hashTarget: String = "0".repeat(difficulty)
    }

}