INSERT INTO tipo_transacciones (nombre) VALUES ('DEPÓSITO');
INSERT INTO tipo_transacciones (nombre) VALUES ('RETIRO');
INSERT INTO tipo_transacciones (nombre) VALUES ('TRANSFERENCIA');
INSERT INTO tipo_transacciones (nombre) VALUES ('PAGO DE SERVICIO');


INSERT INTO transacciones (cuenta_id, tipo_transaccion_id, monto, fecha, referencia)
VALUES (1001, 1, 1500.75, '2025-09-12', 'Depósito en efectivo');

INSERT INTO transacciones (cuenta_id, tipo_transaccion_id, monto, fecha, referencia)
VALUES (1002, 2, 500.00, '2025-09-12', 'Retiro por cajero');

INSERT INTO transacciones (cuenta_id, tipo_transaccion_id, monto, fecha, referencia)
VALUES (1001, 3, 300.50, '2025-09-11', 'Transferencia a cuenta 1003');

INSERT INTO transacciones (cuenta_id, tipo_transaccion_id, monto, fecha, referencia)
VALUES (1003, 4, 120.00, '2025-09-10', 'Pago de luz');