package com.estudos.rabbitmqestoquepreco.conections;

import constantes.RabbitMQConstantes;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConnection {
    public RabbitMQConnection(AmqpAdmin amqp){
        this.amqp = amqp;
    }
    private AmqpAdmin amqp;
    private static final String NOME_EXCHANGE = "amq.direct";
    private Queue fila(String nomefila){
        return new Queue(nomefila, true,false, false);
    }
    private DirectExchange trocaDireta() {
        return new DirectExchange(NOME_EXCHANGE);
    }
    private Binding relacionamento(Queue fila, DirectExchange troca) {
       return new Binding(fila.getName(), Binding.DestinationType.QUEUE, troca.getName(), fila.getName(), null);
    }
    @PostConstruct
    private void adiciona(){
       Queue filaEstoque =  this.fila(RabbitMQConstantes.FILA_ESTOQUE);
       Queue filaPreco=  this.fila(RabbitMQConstantes.FILA_PRECO);
       DirectExchange troca = this.trocaDireta();
       Binding ligacao = this.relacionamento(filaEstoque, troca);
        Binding ligacao2 = this.relacionamento(filaPreco, troca);
        this.amqp.declareQueue(filaEstoque);
        this.amqp.declareQueue(filaPreco);
        this.amqp.declareExchange(troca);
        this.amqp.declareBinding(ligacao);
        this.amqp.declareBinding(ligacao2);
    }
}
