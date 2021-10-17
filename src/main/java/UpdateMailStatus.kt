
class UpdateMailStatus {

    fun mailStatus(status: MailStatus, mailObject: MailObject): MailObject {
        mailObject.status = status
        return mailObject
    }
}