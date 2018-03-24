package net.vortex.webpanel.entity

import javax.persistence.*

@Entity
data class User (
        @Column(name="ID") @Id @GeneratedValue(strategy=GenerationType.AUTO)
        val id: Int,
        @Column(name="EMAIL")
        val email: String,
        @Column(name="PASSWORD")
        val password: String,
        val premium: Boolean
)