
class UpdateMailType {
    fun mailType(type: MailType, mailObject: MailObject): MailObject {
        mailObject.type = type
        return  mailObject
    }
}