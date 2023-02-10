package playground

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertEquals

class AppTest {
    @Test fun properGreeting() {
        val greeter = Greeter()
        val greeting = greeter.greet()

        assertNotNull(greeting)
        assertEquals(greeting, "Satma0745 is Back!")
    }
}
