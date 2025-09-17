package org.nttdata.com.servicioprestamos.producer;

import lombok.RequiredArgsConstructor;
import org.nttdata.com.servicioprestamos.producer.dto.NotificacionRequestK;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacionProducer {
    private final KafkaTemplate<String, NotificacionRequestK> kafkaTemplate;

    public void enviarNotificacion(NotificacionRequestK notificacionRequest) {
        kafkaTemplate.send("notificaciones", notificacionRequest);
    }
}
