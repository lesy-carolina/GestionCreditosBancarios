-- Datos iniciales para la tabla de cuentas bancarias
-- Tipos de cuenta: AHORROS, CORRIENTE, PLAZO_FIJO, EMPRESARIAL
-- Estados de cuenta: ACTIVA, INACTIVA, BLOQUEADA, PENDIENTE_VERIFICACION
INSERT INTO cuentas (id_cliente, tipo_cuenta, estado_cuenta, saldo)
VALUES (1, 'AHORROS', 'ACTIVA', 1500.75);
-- Cuenta de ahorros activa
INSERT INTO cuentas (id_cliente, tipo_cuenta, estado_cuenta, saldo)
VALUES (2, 'AHORROS', 'ACTIVA', 5000.00);

-- Cuenta corriente bloqueada
INSERT INTO cuentas (id_cliente, tipo_cuenta, estado_cuenta, saldo)
VALUES (3, 'CORRIENTE', 'BLOQUEADA', 1200.00);

-- Cuenta a plazo fijo pendiente de verificación
INSERT INTO cuentas (id_cliente, tipo_cuenta, estado_cuenta, saldo)
VALUES (4, 'PLAZO_FIJO', 'PENDIENTE_VERIFICACION', 10000.00);

-- Cuenta empresarial inactiva
INSERT INTO cuentas (id_cliente, tipo_cuenta, estado_cuenta, saldo)
VALUES (5, 'EMPRESARIAL', 'INACTIVA', 25000.50);