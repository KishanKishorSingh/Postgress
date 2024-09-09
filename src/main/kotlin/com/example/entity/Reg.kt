package com.example.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter


@Entity
@Table(name = "reg")
@Getter
@Setter
class Reg(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long,

    @Column(name = "name", nullable = false, length = 100)
    var name: String,

    @Column(name = "email", nullable = false, unique = true)
    var email: String,

    @Column(name = "mobile", nullable = false, unique = true, length = 10)
    var mobile: String,

    @Column(name = "address", nullable = false)
    var address: String
)
