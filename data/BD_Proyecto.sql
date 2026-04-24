DROP DATABASE IF EXISTS bsPPVA;
CREATE DATABASE IF NOT EXISTS bdPPVA;
USE bdPPVA;

-- CREACIÓN DE TABLAS Y RESTRICCIONES
-- =====================================================================================
-- 1. CASO: EXPANSIÓN (Jerarquía Usuarios)
-- Eliminamos el padre "Usuario". Los hijos heredan todo.
-- =====================================================================
-- Tabla cliente (no tiene FK pq en su lado de la tabla no hay N)
CREATE TABLE cliente (
    dni VARCHAR(9) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(150) NOT NULL,
    direccion VARCHAR(200),
    telefono VARCHAR(20),
    email VARCHAR(150) NOT NULL UNIQUE KEY, -- Clave alternativa
    fechaNacimiento DATE,
    pass VARCHAR(255) NOT NULL,
    imagen VARCHAR(255),
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    credito INT NOT NULL DEFAULT 0, 
    penalizado BOOLEAN NOT NULL DEFAULT FALSE
);
-- Tabla administrador (no tiene FK pq en su lado de la tabla no hay N)
CREATE TABLE administrador (
    dni VARCHAR(9) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(150) NOT NULL,
    direccion VARCHAR(200),
    telefono VARCHAR(20),
    email VARCHAR(150) NOT NULL UNIQUE KEY, -- Clave alternativa
    fechaNacimiento DATE,
    pass VARCHAR(255) NOT NULL,
    imagen VARCHAR(255),
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    fechaNombramiento DATE,
    fechaCese DATE CHECK (fechaCese IS NULL OR fechaCese >= fechaNombramiento)
);
-- =====================================================================
-- 2. GESTIÓN DE CRÉDITO Y ESTADOS (Tablas Maestras)
-- =====================================================================
-- Tabla tipoMovimientoCredito (no tiene FK pq en su lado de la tabla no hay N)
CREATE TABLE tipoMovimientoCredito (
    tipo ENUM ('RecargaDinero', 'AportaRecurso','AjusteAdmin','Penalización') PRIMARY KEY
);
-- Tabla movimientoCredito (tiene 3 FK una hacia cliente, otra hacia administrador y otra hacia tipoMovimientoCredito)
CREATE TABLE movimientoCredito (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    puntos INT NOT NULL DEFAULT 0 CHECK (puntos >= 0), -- Así nos aseguramos que un cliente no quede en "nº rojos"
    motivo VARCHAR(200),
    dniCliente VARCHAR(9) NOT NULL,
    dniAdministrador VARCHAR(9) NOT NULL,
    tipoMovimiento ENUM ('RecargaDinero', 'AportaRecurso','AjusteAdmin','Penalización') NOT NULL, 
    FOREIGN KEY (dniCliente) REFERENCES cliente(dni),
    FOREIGN KEY (dniAdministrador) REFERENCES administrador(dni)
    -- FOREIGN KEY (tipoMovimiento) REFERENCES tipoMovimientoCredito(tipo)
);

-- =====================================================================
-- 3. CASO: MANTENER (Jerarquía Artículos)
-- Mantenemos el padre "Articulo" y vinculamos a los hijos.
-- =====================================================================
-- Tabla estadoArticulo (no tiene FK pq en su lado de la tabla no hay N)
CREATE TABLE estadoArticulo (
    tipo ENUM('Disponible', 'Reservado', 'EnUso', 'FueraServicio') PRIMARY KEY
);
-- Tabla artículo (tiene 1 FK hacia estadoArticulo)
CREATE TABLE articulo (
    codArt VARCHAR(30) PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL, -- No lo indica nuestro MEER, pero creo que es necesario
    descripcion TEXT,
    marca VARCHAR(100),
    imagen VARCHAR(255),
    creditosNecesarios INT DEFAULT 0,
    tipoEstado ENUM ('Disponible', 'Reservado','EnUso','FueraServicio') NOT NULL DEFAULT 'Disponible'
	-- FOREIGN KEY (tipoEstado) REFERENCES estadoArticulo(tipo)
);
-- Hija 1: ArticuloNoFungible (Mantiene relación con padre)
-- Tabla articuloNoFungible (tiene 1 FK hacia articulo, además de heredar los atributos de sus hijos tras COLAPSAR)
CREATE TABLE articuloNoFungible (
    codArt VARCHAR(30) PRIMARY KEY,
    estadoFisico VARCHAR(100),
    -- Atributo que se crea tras COLAPSAR para diferencias los subtipos.
    tipoArticuloNoFungible ENUM('herramientaManual', 'equipoElectricoMaquinaria', 'equipamientoComunitario') NOT NULL,
        /* atributos colapsados */
    tipo VARCHAR(50), -- Atributo específico de herramientaManual
    alto INT, -- medidas en cm, atributo específico de equipamientoComunitario
    ancho INT, -- medidas en cm, atributo específico de equipamientoComunitario
    potencia VARCHAR(50), -- Atributo específico de equipoElectricoMaquinaria
    energia VARCHAR(50), -- Atributo específico de equipoElectricoMaquinaria
    FOREIGN KEY (codArt) REFERENCES Articulo(codArt) ON DELETE CASCADE -- Si se elimina el artículo se borra esta información también.
);
-- Hija 2: ArticuloNoFungible (Mantiene relación con padre)
-- Tabla articuloFungible (tiene 1 FK hacia articulo, además de heredar los atributos de sus hijos tras COLAPSAR)
CREATE TABLE articuloFungible (
    codArt VARCHAR(30) PRIMARY KEY,
    cantidad INT DEFAULT 0,
    fechaCaducidad DATE,
    -- Atributo que se crea tras COLAPSAR para diferencias los subtipos.
    tipoArticuloFungible ENUM('materialConstruccion', 'productoLimpiezaJardineria') NOT NULL,
    /* atributos colapsados */
    forma VARCHAR (20), -- Atributo específico de materialConstruccion
    toxicidad BOOLEAN, -- Atributo específico de productoLimpiezaJardineria
    FOREIGN KEY (codArt) REFERENCES Articulo(codArt) ON DELETE CASCADE -- Si se elimina el artículo se borra esta información también.
);

-- =====================================================================
-- 4. GESTIÓN DE RESERVAS (Relación M:N)
-- =====================================================================
-- Tabla estadoReserva (no tiene FK pq en su lado de la tabla no hay N)
CREATE TABLE estadoReserva (
    tipo ENUM ('PendienteConfirmar', 'EsperandoRecogida', 'EnUso', 'Finalizada', 'Cancelada', 'Vencida') PRIMARY KEY
);

-- Tabla reserva 
CREATE TABLE reserva (
    numero VARCHAR(30) PRIMARY KEY,
    fecha DATE  NOT NULL,
    dniCliente VARCHAR(9) NOT NULL,
    tipoEstado ENUM ('PendienteConfirmar', 'EsperandoRecogida', 'EnUso', 'Finalizada', 'Cancelada', 'Vencida') NOT NULL DEFAULT 'PendienteConfirmar' , 
    -- FOREIGN KEY (tipoEstado) REFERENCES estadoReserva(tipo),
    FOREIGN KEY (dniCliente) REFERENCES cliente(dni)
);
-- Tabla resevaArticulo (es la tabla que se genera de la relación M:N)
CREATE TABLE reservaArticulo (
    numeroReserva VARCHAR(30),
    codArt VARCHAR(30),
    PRIMARY KEY (numeroReserva, codArt),
    FOREIGN KEY (numeroReserva) REFERENCES reserva(numero) ON DELETE CASCADE,
    FOREIGN KEY (codArt) REFERENCES articulo(codArt) ON DELETE CASCADE
);

