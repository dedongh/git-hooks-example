
class MailRepository: MailRepositoryInterface {
    val mailStatus = UpdateMailStatus()
    val mailType = UpdateMailType()
    val mailHelper = MailHelper()
    override fun sendMail(mailObject: MailObject): MailObject {
        return mailHelper.sendMail(mailObject)
    }

    override fun readMail(mailObject: MailObject): MailObject {
        mailObject.status = MailStatus.READ
        return mailObject
    }

    override fun receiveMail(mailObject: MailObject): MailObject {
        return mailHelper.receiveMail(mailObject)
    }

    override fun setMailType(_mailType: MailType, mailObject: MailObject): MailObject {
        return mailType.mailType(_mailType, mailObject)
    }

    override fun setMailStatus(_mailStatus: MailStatus, mailObject: MailObject): MailObject {
        return mailStatus.mailStatus(_mailStatus, mailObject)
    }
}