insert into estado_prestamos(nombre) values ('PENDIENTE');
insert into estado_prestamos(nombre) values ('APROBADO');
insert into estado_prestamos(nombre) values ('RECHAZADO');
insert into estado_prestamos(nombre) values ('CANCELADO');
insert into estado_prestamos(nombre) values ('FINALIZADO');
insert into estado_prestamos(nombre) values ('EN ESPERA');
insert into estado_prestamos(nombre) values ('EN PROCESO');
insert into estado_prestamos(nombre) values ('SUSPENDIDO');
insert into estado_prestamos(nombre) values ('REPROGRAMADO');
insert into estado_prestamos(nombre) values ('PAGADO');


insert into prestamos(cliente_id, cuenta_id, monto, plazo_meses, tasa_interes, estado_prestamo_id, fecha_desembolso) values (1, 1, 10000.00, 12, 5.5, 2, '2023-01-15');
insert into prestamos(cliente_id, cuenta_id, monto, plazo_meses, tasa_interes, estado_prestamo_id, fecha_desembolso) values (2, 2, 5000.00, 6, 4.5, 1, '2023-02-20');
insert into prestamos(cliente_id, cuenta_id, monto, plazo_meses, tasa_interes, estado_prestamo_id, fecha_desembolso) values (3, 3, 15000.00, 24, 6.0, 3, '2023-03-10');
insert into prestamos(cliente_id, cuenta_id, monto, plazo_meses, tasa_interes, estado_prestamo_id, fecha_desembolso) values (4, 4, 20000.00, 36, 7.0, 2, '2023-04-05');
insert into prestamos(cliente_id, cuenta_id, monto, plazo_meses, tasa_interes, estado_prestamo_id, fecha_desembolso) values (5, 5, 8000.00, 18, 5.0, 4, '2023-05-12');
