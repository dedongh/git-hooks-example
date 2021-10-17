import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

class MailRepositoryTest {

    private var mail: MailObject? = null
    private lateinit var repository: MailRepository

    @Before
    fun setUp() {
        mail = MailObject("QERFYF1235", "ASDG134234", "Incoming Mail",
            "Mail received from Hosny", MailType.INCOMING, MailStatus.UNREAD)
        repository = MailRepository()
    }

    @Test
    fun `test if mail status changed to read`() {

        repository.readMail(mail!!)

        assertEquals(mail?.status, MailStatus.READ)
    }

    @Test
    fun `test if user can receive mail`() {

        val receivedMail = repository.receiveMail(mail!!)

        assertEquals(mail, receivedMail)
    }

    @Test
    fun `test if user can archive mail`() {
        var archivedMail = repository.setMailStatus(MailStatus.ARCHIVED, mail!!)
        assertEquals(archivedMail.status, MailStatus.ARCHIVED)
        assertNotEquals(archivedMail.status, MailStatus.UNREAD)
    }

    @Test
    fun `test if user can delete mail`() {
        var deleteMail = repository.setMailStatus(MailStatus.DELETED, mail!!)
        assertEquals(deleteMail.status, MailStatus.DELETED)
        assertNotEquals(deleteMail.status, MailStatus.UNREAD)
    }

    @Test
    fun `test if user can unread mail`() {
        var unreadMail = repository.setMailStatus(MailStatus.UNREAD, mail!!)
        assertEquals(unreadMail.status, MailStatus.UNREAD)
        assertNotEquals(unreadMail.status, MailStatus.READ)
    }

}