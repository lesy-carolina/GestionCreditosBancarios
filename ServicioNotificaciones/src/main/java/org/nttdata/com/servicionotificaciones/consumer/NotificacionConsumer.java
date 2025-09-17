package org.nttdata.com.servicionotificaciones.consumer;

import lombok.RequiredArgsConstructor;
import org.nttdata.com.servicionotificaciones.consumer.dto.NotificacionRequestK;
import org.nttdata.com.servicionotificaciones.dto.NotificacionRequest;
import org.nttdata.com.servicionotificaciones.service.NotificacionService;
import org.nttdata.com.servicionotificaciones.service.MailManagerPersonalizado;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NotificacionConsumer {
    private final NotificacionService notificacionService;
    private final MailManagerPersonalizado mailManager;
    @KafkaListener(
        topics = "notificaciones",
        groupId = "grupo-notificaciones"
    )
    @Transactional
    public void consumirNotificacion(NotificacionRequestK mensaje) {
        System.out.println("Notificacion recibida: " + mensaje.toString());
        notificacionService.createNotificacion(NotificacionRequest.builder()
                        .clienteId(mensaje.cliente().id())
                        .estadoNotificacionId(mensaje.estadoNotificacionId())
                        .asunto(mensaje.asunto())
                        .mensaje(mensaje.mensaje())
                        .tipoNotificacionId(mensaje.tipoNotificacionId())
                        .fechaEnvio(mensaje.fechaEnvio())
                        .build());

  mailManager.sendMessage(
      mensaje.cliente().email(),
      mensaje.asunto(),
        MailManagerPersonalizado.HTML.formatted(
          mensaje.asunto(),
          mensaje.cliente().nombre(),
          mensaje.mensaje(),
          mensaje.cliente().nombre(),
          mensaje.cliente().dni(),
          mensaje.cliente().email(),
          mensaje.fechaEnvio().toString(),
          mensaje.estadoNotificacionId()
      )
  );
    }
}
