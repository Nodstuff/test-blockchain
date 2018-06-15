import com.google.gson.Gson
import com.google.gson.GsonBuilder

var chain: ArrayList<Block> = ArrayList()
val gson: Gson = GsonBuilder().setPrettyPrinting().create()


fun main(args: Array<String>) {

    val genesisBlock = Block("Hi, I'm the first block", "0")
    chain.add(genesisBlock)
    chain[0].mineBlock(Block.difficulty)

    val secondBlock = Block("Hi, I'm the second block", genesisBlock.hash)
    chain.add(secondBlock)
    chain[1].mineBlock(Block.difficulty)

    val thirdBlock = Block("Hi, I'm the third block", secondBlock.hash)
    chain.add(thirdBlock)
    chain[2].mineBlock(Block.difficulty)

    val fourthBlock = Block("Hi, I'm the fourth block", thirdBlock.hash)
    chain.add(fourthBlock)
    chain[3].mineBlock(Block.difficulty)

    val fifthBlock = Block("Hi, I'm the fifth block", fourthBlock.hash)
    chain.add(fifthBlock)
    chain[4].mineBlock(Block.difficulty)

    val sixthBlock = Block("Hi, I'm the sixth block", fifthBlock.hash)
    chain.add(sixthBlock)
    chain[5].mineBlock(Block.difficulty)

    val seventhBlock = Block("Hi, I'm the seventh block", sixthBlock.hash)
    chain.add(seventhBlock)
    chain[6].mineBlock(Block.difficulty)

    val eighthBlock = Block("Hi, I'm the eighth block", seventhBlock.hash)
    chain.add(eighthBlock)
    chain[7].mineBlock(Block.difficulty)

    val ninthBlock = Block("Hi, I'm the ninth block", eighthBlock.hash)
    chain.add(ninthBlock)
    chain[8].mineBlock(Block.difficulty)

    println(gson.toJson(chain))

    println("Is the chain valid: " + BlockRunner.isChainValid())
}


class BlockRunner {

    companion object {

        private var currentBlock: Block? = null
        private var previousBlock: Block? = null

        fun isChainValid(): Boolean {

            for ((index, value) in chain.withIndex()) {

                currentBlock = value

                if (index > 0) {
                    previousBlock = chain[index - 1]
                } else {
                    continue
                }

                previousBlock?.let {

                    if (currentBlock?.hash != currentBlock?.calculateHash()) {
                        println("Current hashes not equal")
                        return false
                    }

                    if (it.hash != currentBlock?.previousHash) {
                        println("Previous hashes not equal")
                        return false
                    }

                    if (currentBlock?.hash?.substring(0, Block.difficulty) != Block.hashTarget) {
                        println("This block has not been mined")
                        return false
                    }
                }
            }

            return true
        }
    }
}