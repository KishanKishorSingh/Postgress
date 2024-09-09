package com.example.repository;

import com.example.entity.Reg
import org.springframework.data.jpa.repository.JpaRepository

interface RegRepository : JpaRepository<Reg, Long> {
}