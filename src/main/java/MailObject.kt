data class MailObject(
    var sender: String? = null,
    var receiver: String? = null,
    var title: String? = null,
    var content: String? = null,
    var type: MailType? = null,
    var status: MailStatus? = null,
)
