package com.estudos.rabbitmqestoquepreco.controller;


import com.estudos.rabbitmqestoquepreco.service.RabbitMQService;
import constantes.RabbitMQConstantes;
import dto.precoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/preco")
public class PrecoController {
    @Autowired
    private RabbitMQService service;
    @PutMapping
    private ResponseEntity alteraPreco(@RequestBody precoDTO precoDto){
        service.enviaMensagem(RabbitMQConstantes.FILA_PRECO, precoDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
