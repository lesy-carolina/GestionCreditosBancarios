insert into estado_notificaciones(estado) values ('PENDIENTE');
insert into estado_notificaciones(estado) values ('ENVIADA');
insert into estado_notificaciones(estado) values ('FALLIDA');

insert into tipo_notificaciones(nombre) values ('EMAIL');
insert into tipo_notificaciones(nombre) values ('SMS');

insert into notificaciones(cliente_id, tipo_notificacion_id, estado_notificacion_id, asunto, mensaje, fecha_envio) values (1, 1, 2, 'Solicito un prestamo', 'prueba de solicitud de prestamo', '2023-02-10 10:00:00');
insert into notificaciones(cliente_id, tipo_notificacion_id, estado_notificacion_id, asunto, mensaje, fecha_envio) values (2, 2, 2, 'Solicito un prestamo', 'prueba de solicitud de prestamo', '2023-04-15 14:30:00');
insert into notificaciones(cliente_id, tipo_notificacion_id, estado_notificacion_id, asunto, mensaje, fecha_envio) values (3, 1, 1, 'Solicito un prestamo', 'prueba de solicitud de prestamo', '2023-04-05 09:15:00');
