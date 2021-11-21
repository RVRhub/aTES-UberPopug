package uberpopug.accounting.model

import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Version

@Entity
class Task(
    @Column(unique = true, nullable = false)
    val publicId: String?,
    var title: String? = null,
    var description: String? = null,
    var status: String,
    var accountPublicId: String?,
    var assignmentCost: BigDecimal?,
    var cost: BigDecimal?
) {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Version
    private val version: Long? = null

    enum class Status {
        CREATED, ASSIGNED, COMPLETED
    }
}
