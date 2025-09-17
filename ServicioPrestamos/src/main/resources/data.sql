insert into estado_prestamos(nombre) values ('PENDIENTE');
insert into estado_prestamos(nombre) values ('APROBADO');
insert into estado_prestamos(nombre) values ('RECHAZADO');
insert into estado_prestamos(nombre) values ('CANCELADO');
insert into estado_prestamos(nombre) values ('FINALIZADO');


insert into prestamos(cliente_id, cuenta_id, monto, plazo_meses, tasa_interes, estado_prestamo_id, fecha_desembolso) values (1, 1, 10000.00, 12, 5.5, 2, '2023-01-15');
insert into prestamos(cliente_id, cuenta_id, monto, plazo_meses, tasa_interes, estado_prestamo_id, fecha_desembolso) values (2, 2, 5000.00, 6, 4.5, 1, '2023-02-20');
insert into prestamos(cliente_id, cuenta_id, monto, plazo_meses, tasa_interes, estado_prestamo_id, fecha_desembolso) values (3, 3, 15000.00, 24, 6.0, 3, '2023-03-10');
insert into prestamos(cliente_id, cuenta_id, monto, plazo_meses, tasa_interes, estado_prestamo_id, fecha_desembolso) values (4, 4, 20000.00, 36, 7.0, 2, '2023-04-05');
insert into prestamos(cliente_id, cuenta_id, monto, plazo_meses, tasa_interes, estado_prestamo_id, fecha_desembolso) values (5, 5, 8000.00, 18, 5.0, 4, '2023-05-12');

insert into estado_cuotas(nombre) values ('PENDIENTE');
insert into estado_cuotas(nombre) values ('PAGADA');
insert into estado_cuotas(nombre) values ('ATRASADA');
insert into estado_cuotas(nombre) values ('CANCELADA');

-- Préstamo 1: 10000 / 12 meses ≈ 833.33
insert into cuotas(prestamo_id, numero, fecha_vencimiento, monto, estado_cuota_id) values (1, 1, '2023-02-15', 833.33, 2);
insert into cuotas(prestamo_id, numero, fecha_vencimiento, monto, estado_cuota_id) values (1, 2, '2023-03-15', 833.33, 2);
insert into cuotas(prestamo_id, numero, fecha_vencimiento, monto, estado_cuota_id) values (1, 3, '2023-04-15', 833.33, 1);

-- Préstamo 2: 5000 / 6 meses ≈ 833.33
insert into cuotas(prestamo_id, numero, fecha_vencimiento, monto, estado_cuota_id) values (2, 1, '2023-03-20', 833.33, 2);
insert into cuotas(prestamo_id, numero, fecha_vencimiento, monto, estado_cuota_id) values (2, 2, '2023-04-20', 833.33, 1);

-- Préstamo 3: 15000 / 24 meses ≈ 625
insert into cuotas(prestamo_id, numero, fecha_vencimiento, monto, estado_cuota_id) values (3, 1, '2023-04-10', 625, 1);
insert into cuotas(prestamo_id, numero, fecha_vencimiento, monto, estado_cuota_id) values (3, 2, '2023-05-10', 625, 1);

-- Préstamo 4: 20000 / 36 meses ≈ 555.56
insert into cuotas(prestamo_id, numero, fecha_vencimiento, monto, estado_cuota_id) values (4, 1, '2023-05-05', 555.56, 1);
insert into cuotas(prestamo_id, numero, fecha_vencimiento, monto, estado_cuota_id) values (4, 2, '2023-06-05', 555.56, 1);

-- Préstamo 5: 8000 / 18 meses ≈ 444.44
insert into cuotas(prestamo_id, numero, fecha_vencimiento, monto, estado_cuota_id) values (5, 1, '2023-06-12', 444.44, 1);
insert into cuotas(prestamo_id, numero, fecha_vencimiento, monto, estado_cuota_id) values (5, 2, '2023-07-12', 444.44, 1);
