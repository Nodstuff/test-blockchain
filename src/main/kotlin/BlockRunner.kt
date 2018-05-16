import com.google.gson.GsonBuilder

var chain: ArrayList<Block> = ArrayList()
val gson = GsonBuilder().setPrettyPrinting().create()

fun main(args: Array<String>) {

    val genesisBlock = Block("Hi, I'm the first block", "0")
    println("Hash for genesis block: " + genesisBlock.hash)
    chain.add(genesisBlock)

    val secondBlock = Block("Hi, I'm the second block", genesisBlock.hash)
    println("Hash for second block: " + secondBlock.hash)
    chain.add(secondBlock)

    val thirdBlock = Block("Hi, I'm the third block", secondBlock.hash)
    println("Hash for third block: " + thirdBlock.hash)
    chain.add(thirdBlock)

    println(gson.toJson(chain))

}