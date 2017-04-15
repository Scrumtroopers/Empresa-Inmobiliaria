-- -------------------------------------------------------------------------
-- PostgreSQL SQL create tables
-- exported at Thu Apr 13 23:10:06 BOT 2017 with easyDesigner
-- -------------------------------------------------------------------------

-- -------------------------------------------------------------------------
-- Table: Almacen
-- -------------------------------------------------------------------------
CREATE TABLE "Almacen" (
  "idAlmacen" bigserial NOT NULL,
  "nombre" VARCHAR NOT NULL,
  PRIMARY KEY ("idAlmacen")
);

-- -------------------------------------------------------------------------
-- Table: Producto
-- -------------------------------------------------------------------------
CREATE TABLE "Producto" (
  "idProducto" bigserial NOT NULL,
  "TipoDeProducto_idTipo" INTEGER NOT NULL,
  "nombre" VARCHAR NOT NULL,
  PRIMARY KEY ("idProducto")
);

-- -------------------------------------------------------------------------
-- Table: Cliente
-- -------------------------------------------------------------------------
CREATE TABLE "Cliente" (
  "idCliente" bigserial NOT NULL,
  "nombre" VARCHAR NULL,
  PRIMARY KEY ("idCliente")
);

-- -------------------------------------------------------------------------
-- Table: Garantia
-- -------------------------------------------------------------------------
CREATE TABLE "Garantia" (
  "idGarantia" bigserial NOT NULL,
  "Producto_idProducto" INTEGER NOT NULL,
  "fechaInicio" DATE NOT NULL,
  "fechaLimite" DATE NOT NULL,
  PRIMARY KEY ("idGarantia", "Producto_idProducto")
);

-- -------------------------------------------------------------------------
-- Table: TipoDeProducto
-- -------------------------------------------------------------------------
CREATE TABLE "TipoDeProducto" (
  "idTipo" bigserial NOT NULL,
  "tipo" VARCHAR NOT NULL,
  PRIMARY KEY ("idTipo")
);

-- -------------------------------------------------------------------------
-- Table: Telefono
-- -------------------------------------------------------------------------
CREATE TABLE "Telefono" (
  "idTelefono" bigserial NOT NULL,
  "Cliente_idCliente" INTEGER NOT NULL,
  "numero" INTEGER NOT NULL,
  PRIMARY KEY ("idTelefono", "Cliente_idCliente")
);

-- -------------------------------------------------------------------------
-- Table: Pedido
-- -------------------------------------------------------------------------
CREATE TABLE "Pedido" (
  "Cliente_idCliente" INTEGER NOT NULL,
  "Producto_idProducto" INTEGER NOT NULL,
  "direccion" VARCHAR NOT NULL,
  PRIMARY KEY ("Cliente_idCliente", "Producto_idProducto")
);

-- -------------------------------------------------------------------------
-- Table: Inventario
-- -------------------------------------------------------------------------
CREATE TABLE "Inventario" (
  "Almacen_idAlmacen" INTEGER NOT NULL,
  "Producto_idProducto" INTEGER NOT NULL,
  "cantidad" INTEGER NOT NULL,
  PRIMARY KEY ("Almacen_idAlmacen", "Producto_idProducto")
);

-- -------------------------------------------------------------------------
-- Table: Empleado
-- -------------------------------------------------------------------------
CREATE TABLE "Empleado" (
  "idEmpleado" bigserial NOT NULL,
  "Cargo_idCargo" INTEGER NOT NULL,
  "nombre" VARCHAR NOT NULL,
  PRIMARY KEY ("idEmpleado")
);

-- -------------------------------------------------------------------------
-- Table: Venta
-- -------------------------------------------------------------------------
CREATE TABLE "Venta" (
  "idVenta" bigserial NOT NULL,
  "Producto_idProducto" INTEGER NOT NULL,
  "Cliente_idCliente" INTEGER NOT NULL,
  "Empleado_idEmpleado" INTEGER NOT NULL,
  "total" FLOAT NOT NULL,
  "fecha" DATE NOT NULL,
  PRIMARY KEY ("idVenta")
);

-- -------------------------------------------------------------------------
-- Table: Cargo
-- -------------------------------------------------------------------------
CREATE TABLE "Cargo" (
  "idCargo" bigserial NOT NULL,
  "cargo" VARCHAR NOT NULL,
  PRIMARY KEY ("idCargo")
);

-- -------------------------------------------------------------------------
-- Relations for table: Producto
-- -------------------------------------------------------------------------
ALTER TABLE "Producto" ADD FOREIGN KEY ("TipoDeProducto_idTipo") 
    REFERENCES "TipoDeProducto" ("idTipo")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: Garantia
-- -------------------------------------------------------------------------
ALTER TABLE "Garantia" ADD FOREIGN KEY ("Producto_idProducto") 
    REFERENCES "Producto" ("idProducto")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: Telefono
-- -------------------------------------------------------------------------
ALTER TABLE "Telefono" ADD FOREIGN KEY ("Cliente_idCliente") 
    REFERENCES "Cliente" ("idCliente")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: Pedido
-- -------------------------------------------------------------------------
ALTER TABLE "Pedido" ADD FOREIGN KEY ("Cliente_idCliente") 
    REFERENCES "Cliente" ("idCliente")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "Pedido" ADD FOREIGN KEY ("Producto_idProducto") 
    REFERENCES "Producto" ("idProducto")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: Inventario
-- -------------------------------------------------------------------------
ALTER TABLE "Inventario" ADD FOREIGN KEY ("Almacen_idAlmacen") 
    REFERENCES "Almacen" ("idAlmacen")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "Inventario" ADD FOREIGN KEY ("Producto_idProducto") 
    REFERENCES "Producto" ("idProducto")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: Empleado
-- -------------------------------------------------------------------------
ALTER TABLE "Empleado" ADD FOREIGN KEY ("Cargo_idCargo") 
    REFERENCES "Cargo" ("idCargo")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: Venta
-- -------------------------------------------------------------------------
ALTER TABLE "Venta" ADD FOREIGN KEY ("Empleado_idEmpleado") 
    REFERENCES "Empleado" ("idEmpleado")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "Venta" ADD FOREIGN KEY ("Cliente_idCliente") 
    REFERENCES "Cliente" ("idCliente")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "Venta" ADD FOREIGN KEY ("Producto_idProducto") 
    REFERENCES "Producto" ("idProducto")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

