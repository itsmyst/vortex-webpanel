package net.vortex.webpanel.repository

import net.vortex.webpanel.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long>{

    fun findByEmail(email: String): Iterable<User>
}