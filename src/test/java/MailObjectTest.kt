import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class MailObjectTest {
    private var mail: MailObject? = null

    @After
    fun tearDown() {
        mail = null
    }

    @Before
    fun setUp() {
        mail = MailObject("QERFYF1235","ASDG134234","Incoming Mail",
            "Mail received from Hosny", MailType.INCOMING, MailStatus.UNREAD)
    }

    @Test
    fun `test mail object`(){
        assertEquals(mail?.receiver, "ASDG134234")
        assertEquals(mail?.sender, "QERFYF1235")
        assertEquals(mail?.title, "Incoming Mail")
        assertEquals(mail?.content, "Mail received from Hosny")
        assertEquals(mail?.type, MailType.INCOMING)
        assertEquals(mail?.status, MailStatus.UNREAD)
    }
}