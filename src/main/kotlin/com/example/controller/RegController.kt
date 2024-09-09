package com.example.controller

import com.example.entity.Reg
import com.example.repository.RegRepository
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/postgres")
class RegController(private val regRepository: RegRepository) {
    @PostMapping
    fun  createReg(@RequestBody reg:Reg):ResponseEntity<Reg>{
       return ResponseEntity.ok(regRepository.save(reg))
    }
    @GetMapping("/get")
    fun getAll():ResponseEntity<List<Reg>>{
        return ResponseEntity.ok(regRepository.findAll())
    }
    @PutMapping("/update")
    fun update(@RequestParam id:Long, @RequestBody reg: Reg):ResponseEntity<Any>{
        return if (regRepository.existsById(id)){

            val existingReg = regRepository.findById(id).get()

            existingReg.let {
               it.mobile=reg.mobile
                it.name=reg.name
                it.address=reg.address
               ResponseEntity.ok(regRepository.save(it))
           }
            }else{
            ResponseEntity("not found", HttpStatus.UNAUTHORIZED)
        }
    }
    @DeleteMapping("/delete")
    fun deleteById(@RequestParam id:Long):ResponseEntity<Any>{
        return if (regRepository.existsById(id)){
            regRepository.deleteById(id)
            ResponseEntity.ok("Deleted Successfully")
        }else{
            ResponseEntity("not found", HttpStatus.UNAUTHORIZED)
        }
    }

}