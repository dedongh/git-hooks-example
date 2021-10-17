interface MailRepositoryInterface {
    fun sendMail(mailObject: MailObject): MailObject
    fun readMail(mailObject: MailObject): MailObject
    fun receiveMail(mailObject: MailObject): MailObject
    fun setMailType(mailType: MailType, mailObject: MailObject): MailObject
    fun setMailStatus(mailStatus: MailStatus, mailObject: MailObject): MailObject
}