package esgi.al2.architradme.adapter.output

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface ConsultantEntityRepository : CrudRepository<ConsultantEntity, String> {
    @Query(
        "SELECT e FROM ConsultantEntity e JOIN e.skills s WHERE " +
        "(s = :skill OR :skill = NULL) AND " +
        "(e.adr <= :maxADR OR :maxADR = NULL) AND " +
        "(e.adr >= :minADR OR :minADR = NULL)"
    )
    fun search(
        @Param("skill") skill: String?,
        @Param("maxADR") maxADR: Double?,
        @Param("minADR") minADR: Double?,
    ): List<ConsultantEntity>
}