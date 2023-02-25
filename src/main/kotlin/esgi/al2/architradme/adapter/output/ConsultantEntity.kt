package esgi.al2.architradme.adapter.output

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "T_CONSULTANT")
class ConsultantEntity {
    @Id
    var id: String? = null

    constructor()
    constructor(id: String?) {
        this.id = id
    }

}