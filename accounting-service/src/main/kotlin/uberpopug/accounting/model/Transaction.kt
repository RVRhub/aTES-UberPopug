package uberpopug.accounting.model

import org.hibernate.annotations.CreationTimestamp
import java.math.BigDecimal
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Temporal
import javax.persistence.TemporalType
import javax.persistence.Version


@Entity
class Transaction(
    var accountPublicId: String,
    var description: String,
    var type: Type,
    var credit: BigDecimal? = BigDecimal(0),
    var debit: BigDecimal? = BigDecimal(0)
) {

    @Id
    @GeneratedValue
    var id: Long? = null

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private val createDate: Date? = null

    @Version
    private val version: Long? = null

    enum class Type {
        REPLENISHMENT, RESERVE, PAYMENT
    }
}
