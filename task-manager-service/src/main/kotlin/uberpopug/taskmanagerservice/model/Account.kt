package uberpopug.taskmanagerservice.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Account(val publicId: String?, val email: String?, var role: String? = null) {
    @Id
    @GeneratedValue
    var id: Long? = null
}