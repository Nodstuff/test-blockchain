import java.util.*

class Block(val data: String, val previousHash: String, val timestamp: Long = Date().time){
    val hash: String

    init {
        hash = calculateHash()
    }

    private fun calculateHash() : String {
        return StringUtil.applySha256(previousHash + timestamp.toString() + data)
    }

}