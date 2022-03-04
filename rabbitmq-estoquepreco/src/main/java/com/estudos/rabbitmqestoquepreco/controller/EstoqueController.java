package com.estudos.rabbitmqestoquepreco.controller;


import com.estudos.rabbitmqestoquepreco.service.RabbitMQService;
import constantes.RabbitMQConstantes;
import dto.EstoqueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/estoque")
public class EstoqueController {
    @Autowired
    private RabbitMQService service;

    @PutMapping
    private ResponseEntity alteraEstoque(@RequestBody EstoqueDTO estoqueDto){
        System.out.println(estoqueDto.codigoproduto);
        service.enviaMensagem(RabbitMQConstantes.FILA_ESTOQUE, estoqueDto);
        return new ResponseEntity(HttpStatus.OK);
    }

}
