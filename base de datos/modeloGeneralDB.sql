-- -------------------------------------------------------------------------
-- PostgreSQL SQL create tables
-- exported at Wed Apr 12 21:25:10 BOT 2017 with easyDesigner
-- -------------------------------------------------------------------------

-- -------------------------------------------------------------------------
-- Table: producto
-- -------------------------------------------------------------------------
CREATE TABLE "producto" (
  "ide_producto" bigserial NOT NULL,
  "tipo_producto_ide_tipo_producto" INTEGER NOT NULL,
  "nombre_producto" VARCHAR NOT NULL,
  PRIMARY KEY ("ide_producto")
);

-- -------------------------------------------------------------------------
-- Table: tipo_producto
-- -------------------------------------------------------------------------
CREATE TABLE "tipo_producto" (
  "ide_tipo_producto" bigserial NOT NULL,
  "tipo_producto" VARCHAR NOT NULL,
  PRIMARY KEY ("ide_tipo_producto")
);

-- -------------------------------------------------------------------------
-- Table: empleado
-- -------------------------------------------------------------------------
CREATE TABLE "empleado" (
  "ide_empleado" bigserial NOT NULL,
  "cargo_ide_cargo" INTEGER NOT NULL,
  "empleado_ide_empleado" INTEGER NOT NULL,
  "nombre_empleado" VARCHAR NOT NULL,
  PRIMARY KEY ("ide_empleado")
);

-- -------------------------------------------------------------------------
-- Table: revision
-- -------------------------------------------------------------------------
CREATE TABLE "revision" (
  "producto_ide_producto" INTEGER NOT NULL,
  "empleado_ide_empleado" INTEGER NOT NULL,
  "fecha" DATE NOT NULL,
  PRIMARY KEY ("producto_ide_producto")
);

-- -------------------------------------------------------------------------
-- Table: venta
-- -------------------------------------------------------------------------
CREATE TABLE "venta" (
  "ide_venta" bigserial NOT NULL,
  "cliente_ide_cliente" INTEGER NOT NULL,
  "producto_ide_producto" INTEGER NOT NULL,
  "modo_de_pago_ide_pago" INTEGER NOT NULL,
  "fecha" DATE NOT NULL,
  "hora" TIME NOT NULL,
  PRIMARY KEY ("ide_venta", "cliente_ide_cliente", "producto_ide_producto")
);

-- -------------------------------------------------------------------------
-- Table: modo_de_pago
-- -------------------------------------------------------------------------
CREATE TABLE "modo_de_pago" (
  "ide_pago" bigserial NOT NULL,
  "tipo_de_pago" VARCHAR NOT NULL,
  PRIMARY KEY ("ide_pago")
);

-- -------------------------------------------------------------------------
-- Table: cliente
-- -------------------------------------------------------------------------
CREATE TABLE "cliente" (
  "ide_cliente" bigserial NOT NULL,
  "nombreC" VARCHAR NOT NULL,
  PRIMARY KEY ("ide_cliente")
);

-- -------------------------------------------------------------------------
-- Table: cargo
-- -------------------------------------------------------------------------
CREATE TABLE "cargo" (
  "ide_cargo" bigserial NOT NULL,
  "tipo_de_cargo" VARCHAR NOT NULL,
  PRIMARY KEY ("ide_cargo")
);

-- -------------------------------------------------------------------------
-- Table: detalle_precio
-- -------------------------------------------------------------------------
CREATE TABLE "detalle_precio" (
  "ide_detalle" bigserial NOT NULL,
  "producto_ide_producto" INTEGER NOT NULL,
  "precio" INTEGER NOT NULL,
  PRIMARY KEY ("ide_detalle")
);

-- -------------------------------------------------------------------------
-- Table: oferta
-- -------------------------------------------------------------------------
CREATE TABLE "oferta" (
  "ide_oferta" bigserial NOT NULL,
  "tipo_oferta_ide_tipo_oferta" INTEGER NOT NULL,
  PRIMARY KEY ("ide_oferta")
);

-- -------------------------------------------------------------------------
-- Table: detalle_oferta
-- -------------------------------------------------------------------------
CREATE TABLE "detalle_oferta" (
  "producto_ide_producto" INTEGER NOT NULL,
  "oferta_ide_oferta" INTEGER NOT NULL,
  "fecha _inicio" DATE NOT NULL,
  "fecha_final" DATE NOT NULL,
  PRIMARY KEY ("producto_ide_producto", "oferta_ide_oferta")
);

-- -------------------------------------------------------------------------
-- Table: tipo_oferta
-- -------------------------------------------------------------------------
CREATE TABLE "tipo_oferta" (
  "ide_tipo_oferta" bigserial NOT NULL,
  "tipo_de_oferta" VARCHAR NOT NULL,
  PRIMARY KEY ("ide_tipo_oferta")
);

-- -------------------------------------------------------------------------
-- Table: proveedor
-- -------------------------------------------------------------------------
CREATE TABLE "proveedor" (
  "producto_ide_producto" INTEGER NOT NULL,
  "empleado_ide_empleado" INTEGER NOT NULL,
  "ide_proveedor" INTEGER NOT NULL,
  "nombre_proveedor" VARCHAR NOT NULL,
  PRIMARY KEY ("producto_ide_producto", "empleado_ide_empleado", "ide_proveedor")
);

-- -------------------------------------------------------------------------
-- Table: Garantia
-- -------------------------------------------------------------------------
CREATE TABLE "Garantia" (
  "idGarantia" bigserial NOT NULL,
  "producto_ide_producto" INTEGER NOT NULL,
  "fecha" DATE NOT NULL,
  "fecha_expiracion" DATE NOT NULL,
  PRIMARY KEY ("idGarantia", "producto_ide_producto")
);

-- -------------------------------------------------------------------------
-- Table: telefono
-- -------------------------------------------------------------------------
CREATE TABLE "telefono" (
  "idTelefono" bigserial NOT NULL,
  "cliente_ide_cliente" INTEGER NOT NULL,
  "numero" INTEGER NULL,
  PRIMARY KEY ("idTelefono", "cliente_ide_cliente")
);

-- -------------------------------------------------------------------------
-- Table: Deposito
-- -------------------------------------------------------------------------
CREATE TABLE "Deposito" (
  "idDeposito" bigserial NOT NULL,
  "nombreDeposito" VARCHAR NOT NULL,
  PRIMARY KEY ("idDeposito")
);

-- -------------------------------------------------------------------------
-- Table: inventario
-- -------------------------------------------------------------------------
CREATE TABLE "inventario" (
  "Deposito_idDeposito" INTEGER NOT NULL,
  "producto_ide_producto" INTEGER NOT NULL,
  "cantidad" INTEGER NOT NULL,
  PRIMARY KEY ("Deposito_idDeposito", "producto_ide_producto")
);

-- -------------------------------------------------------------------------
-- Relations for table: empleado
-- -------------------------------------------------------------------------
ALTER TABLE "empleado" ADD FOREIGN KEY ("empleado_ide_empleado") 
    REFERENCES "empleado" ("ide_empleado")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "empleado" ADD FOREIGN KEY ("cargo_ide_cargo") 
    REFERENCES "cargo" ("ide_cargo")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: revision
-- -------------------------------------------------------------------------
ALTER TABLE "revision" ADD FOREIGN KEY ("producto_ide_producto") 
    REFERENCES "producto" ("ide_producto")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "revision" ADD FOREIGN KEY ("empleado_ide_empleado") 
    REFERENCES "empleado" ("ide_empleado")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: venta
-- -------------------------------------------------------------------------
ALTER TABLE "venta" ADD FOREIGN KEY ("producto_ide_producto") 
    REFERENCES "producto" ("ide_producto")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "venta" ADD FOREIGN KEY ("modo_de_pago_ide_pago") 
    REFERENCES "modo_de_pago" ("ide_pago")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "venta" ADD FOREIGN KEY ("cliente_ide_cliente") 
    REFERENCES "cliente" ("ide_cliente")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: detalle_precio
-- -------------------------------------------------------------------------
ALTER TABLE "detalle_precio" ADD FOREIGN KEY ("producto_ide_producto") 
    REFERENCES "producto" ("ide_producto")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: oferta
-- -------------------------------------------------------------------------
ALTER TABLE "oferta" ADD FOREIGN KEY ("tipo_oferta_ide_tipo_oferta") 
    REFERENCES "tipo_oferta" ("ide_tipo_oferta")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: detalle_oferta
-- -------------------------------------------------------------------------
ALTER TABLE "detalle_oferta" ADD FOREIGN KEY ("producto_ide_producto") 
    REFERENCES "producto" ("ide_producto")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "detalle_oferta" ADD FOREIGN KEY ("oferta_ide_oferta") 
    REFERENCES "oferta" ("ide_oferta")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: proveedor
-- -------------------------------------------------------------------------
ALTER TABLE "proveedor" ADD FOREIGN KEY ("producto_ide_producto") 
    REFERENCES "producto" ("ide_producto")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "proveedor" ADD FOREIGN KEY ("empleado_ide_empleado") 
    REFERENCES "empleado" ("ide_empleado")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: Garantia
-- -------------------------------------------------------------------------
ALTER TABLE "Garantia" ADD FOREIGN KEY ("producto_ide_producto") 
    REFERENCES "producto" ("ide_producto")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: telefono
-- -------------------------------------------------------------------------
ALTER TABLE "telefono" ADD FOREIGN KEY ("cliente_ide_cliente") 
    REFERENCES "cliente" ("ide_cliente")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: inventario
-- -------------------------------------------------------------------------
ALTER TABLE "inventario" ADD FOREIGN KEY ("Deposito_idDeposito") 
    REFERENCES "Deposito" ("idDeposito")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "inventario" ADD FOREIGN KEY ("producto_ide_producto") 
    REFERENCES "producto" ("ide_producto")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

