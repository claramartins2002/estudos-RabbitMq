package com.estudos.rabbitmqconsumidorEstoque.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import constantes.RabbitMQConstantes;
import dto.EstoqueDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EstoqueConsumer {

    @RabbitListener(queues = RabbitMQConstantes.FILA_ESTOQUE)
    private void consumidor(String mensagem) throws JsonProcessingException, InterruptedException {
        EstoqueDTO estoqueDto = new ObjectMapper().readValue(mensagem, EstoqueDTO.class);

        System.out.println(estoqueDto.codigoproduto);
        System.out.println(estoqueDto.quantidade);
        System.out.println("------------------------------------");

    }
}
