-- Datos iniciales para la tabla de cuentas bancarias
-- Tipos de cuenta: AHORROS, CORRIENTE, PLAZO_FIJO, EMPRESARIAL
insert into tipo_cuentas (nombre) values ('AHORROS');
insert into tipo_cuentas (nombre) values ('CORRIENTE');
insert into tipo_cuentas (nombre) values ('PLAZO_FIJO');
insert into tipo_cuentas (nombre) values ('EMPRESARIAL');
-- Estados de cuenta: ACTIVA, INACTIVA, BLOQUEADA, PENDIENTE_VERIFICACION
insert into estado_cuentas (nombre) values ('ACTIVA');
insert into estado_cuentas (nombre) values ('INACTIVA');
insert into estado_cuentas (nombre) values ('BLOQUEADA');
insert into estado_cuentas (nombre) values ('PENDIENTE_VERIFICACION');
-- Cuentas de ejemplo
-- Cuenta de ahorros activa
-- Cuenta de ahorros activa
INSERT INTO cuentas (cliente_id, tipo_cuenta_id, estado_cuenta_id, saldo)
VALUES (1, 1, 1, 1500.75);

-- Cuenta de ahorros activa
INSERT INTO cuentas (cliente_id, tipo_cuenta_id, estado_cuenta_id, saldo)
VALUES (2, 1, 1, 5000.00);

-- Cuenta corriente bloqueada
INSERT INTO cuentas (cliente_id, tipo_cuenta_id, estado_cuenta_id, saldo)
VALUES (3, 2, 3, 1200.00);

-- Cuenta a plazo fijo pendiente de verificación
INSERT INTO cuentas (cliente_id, tipo_cuenta_id, estado_cuenta_id, saldo)
VALUES (4, 3, 4, 10000.00);

-- Cuenta empresarial inactiva
INSERT INTO cuentas (cliente_id, tipo_cuenta_id, estado_cuenta_id, saldo)
VALUES (5, 4, 2, 25000.50);