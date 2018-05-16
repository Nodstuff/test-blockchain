import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class StringUtilTest {

    val testString = "6dd79f2770a0bb38073b814a5ff000647b37be5abbde71ec9176c6ce0cb32a27"

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testStringHash(){
        assertTrue(StringUtil.applySha256("TestString").isNotEmpty())
        assertTrue(StringUtil.applySha256("TestString") == testString)
        print(StringUtil.applySha256("TestString"))
    }
}