
CREATE USER TESTING IDENTIFIED BY TESTING;
grant all privileges to TESTING;

CREATE USER TESTING_2 IDENTIFIED BY TESTING_2;
grant all privileges to TESTING_2;

ALTER USER system IDENTIFIED BY system;
grant all privileges on TESTING.usuario to TESTING_2; --from system user.
grant all privileges on TESTING.PERFIL to TESTING_2; --from system user.


DROP TABLE TESTING.usuario CASCADE CONSTRAINTS;
DROP TABLE TESTING.usuario_mayor CASCADE CONSTRAINTS;
DROP TABLE TESTING.perfil CASCADE CONSTRAINTS;
DROP TABLE TESTING.rol CASCADE CONSTRAINTS;
DROP TABLE TESTING.perfil_rol CASCADE CONSTRAINTS;
DROP TABLE TESTING.menu CASCADE CONSTRAINTS;
DROP TABLE TESTING.rol_menu CASCADE CONSTRAINTS;
DROP TABLE TESTING.usuario_perfil CASCADE CONSTRAINTS;
DROP TABLE TESTING.usuario_mayor_perfil CASCADE CONSTRAINTS;


CREATE TABLE TESTING.usuario
( 
  id NUMBER(9),
  name VARCHAR2(200),
  password VARCHAR2(200)
);
CREATE TABLE TESTING.usuario_mayor
(
  id NUMBER(9),
  profesion VARCHAR2(200),
  userId NUMBER(9)
);
CREATE TABLE TESTING.perfil
(
  id NUMBER(9),
  nombre VARCHAR2(200)
);
CREATE TABLE TESTING.rol
(
  id NUMBER(9),
  nombre VARCHAR2(200)
);
CREATE TABLE TESTING.perfil_rol
(
  perfilId NUMBER(9),
  rolId NUMBER(9)
);
CREATE TABLE TESTING.usuario_perfil
(
  usuarioId NUMBER(9),
  perfilId NUMBER(9)
);
CREATE TABLE TESTING.usuario_mayor_perfil
(
  usuarioMayorId NUMBER(9),
  perfilId NUMBER(9)
);
CREATE TABLE TESTING.menu
(
  id NUMBER(9),
  nombre VARCHAR2(200),
  padreId NUMBER(9)
);
CREATE TABLE TESTING.rol_menu
(
  rolId NUMBER(9),
  menuId NUMBER(9)
);

ALTER TABLE TESTING.usuario MODIFY (id NOT NULL);
ALTER TABLE TESTING.usuario_mayor MODIFY (id NOT NULL);
ALTER TABLE TESTING.usuario_mayor MODIFY (userId NOT NULL);
ALTER TABLE TESTING.perfil MODIFY (id NOT NULL);
ALTER TABLE TESTING.rol MODIFY (id NOT NULL);
ALTER TABLE TESTING.perfil_rol MODIFY (perfilId NOT NULL);
ALTER TABLE TESTING.perfil_rol MODIFY (rolId NOT NULL);
ALTER TABLE TESTING.usuario_perfil MODIFY (usuarioId NOT NULL);
ALTER TABLE TESTING.usuario_perfil MODIFY (perfilId NOT NULL);
ALTER TABLE TESTING.usuario_mayor_perfil MODIFY (usuarioMayorId NOT NULL);
ALTER TABLE TESTING.usuario_mayor_perfil MODIFY (perfilId NOT NULL);
ALTER TABLE TESTING.menu MODIFY (id NOT NULL);
ALTER TABLE TESTING.rol_menu MODIFY (rolId NOT NULL);
ALTER TABLE TESTING.rol_menu MODIFY (menuId NOT NULL);

ALTER TABLE TESTING.usuario ADD CONSTRAINT usuario_pk PRIMARY KEY(id);
ALTER TABLE TESTING.usuario_mayor ADD CONSTRAINT usuario_mayor_pk PRIMARY KEY(id);
ALTER TABLE TESTING.usuario_mayor ADD CONSTRAINT usuario_mayor_fk1 FOREIGN KEY(userId)
REFERENCES TESTING.usuario(id);
ALTER TABLE TESTING.perfil ADD CONSTRAINT perfil_pk PRIMARY KEY(id);
ALTER TABLE TESTING.rol ADD CONSTRAINT rol_pk PRIMARY KEY(id);
ALTER TABLE TESTING.perfil_rol ADD CONSTRAINT perfil_rol_pk PRIMARY KEY(perfilId,rolId);
ALTER TABLE TESTING.perfil_rol ADD CONSTRAINT perfil_rol_fk1 FOREIGN KEY (perfilId)
REFERENCES TESTING.perfil(id);
ALTER TABLE TESTING.perfil_rol ADD CONSTRAINT perfil_rol_fk2 FOREIGN KEY (rolId)
REFERENCES TESTING.rol(id);
ALTER TABLE TESTING.usuario_perfil ADD CONSTRAINT usuario_perfil_pk PRIMARY KEY (usuarioId, perfilId);
ALTER TABLE TESTING.usuario_perfil ADD CONSTRAINT usuario_perfil_fk1 FOREIGN KEY (usuarioId)
REFERENCES TESTING.usuario (id);
ALTER TABLE TESTING.usuario_perfil ADD CONSTRAINT usuario_perfil_fk2 FOREIGN KEY (perfilId)
REFERENCES TESTING.perfil (id);
ALTER TABLE TESTING.usuario_mayor_perfil ADD CONSTRAINT usuario_mayor_perfil_pk PRIMARY KEY (usuarioMayorId, perfilId);
ALTER TABLE TESTING.usuario_mayor_perfil ADD CONSTRAINT usuario_mayor_perfil_fk1 FOREIGN KEY (usuarioMayorId)
REFERENCES TESTING.usuario_mayor (id);
ALTER TABLE TESTING.usuario_mayor_perfil ADD CONSTRAINT usuario_mayo_perfil_fk2 FOREIGN KEY (perfilId)
REFERENCES TESTING.perfil (id);
ALTER TABLE TESTING.menu ADD CONSTRAINT menu_pk PRIMARY KEY (id);
ALTER TABLE TESTING.menu ADD CONSTRAINT menu_fk1 FOREIGN KEY (padreId)
REFERENCES TESTING.menu (id);
ALTER TABLE TESTING.rol_menu ADD CONSTRAINT rol_menu_pk PRIMARY KEY (rolId, menuId);
ALTER TABLE TESTING.rol_menu ADD CONSTRAINT rol_menu_fk1 FOREIGN KEY (rolId)
REFERENCES TESTING.rol (id);
ALTER TABLE TESTING.rol_menu ADD CONSTRAINT rol_menu_fk2 FOREIGN KEY (menuId)
REFERENCES TESTING.menu (id);


DROP SEQUENCE TESTING.seq_usuario;
DROP SEQUENCE TESTING.seq_usuario_mayor;
DROP SEQUENCE TESTING.seq_perfil;
DROP SEQUENCE TESTING.seq_rol;
DROP SEQUENCE TESTING.seq_menu;


CREATE SEQUENCE  TESTING.seq_usuario
MINVALUE 1 MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE;

CREATE SEQUENCE  TESTING.seq_usuario_mayor
MINVALUE 1 MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE;

CREATE SEQUENCE  TESTING.seq_perfil
MINVALUE 1 MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE;

CREATE SEQUENCE  TESTING.seq_rol
MINVALUE 1 MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE;

CREATE SEQUENCE  TESTING.seq_menu
MINVALUE 1 MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE;

INSERT INTO usuario(id, name)
VALUES (seq_usuario.nextVal, 'abregup');
INSERT INTO usuario(id, name)
VALUES (seq_usuario.nextVal, 'dolorierp');
INSERT INTO usuario_mayor(id, profesion, userId)
VALUES (seq_usuario_mayor.nextVal, 'ingsistemas', (SELECT id FROM usuario WHERE name = 'dolorierp'));
INSERT INTO perfil(id, nombre)
VALUES (seq_perfil.nextVal, 'desarrollador');
INSERT INTO perfil(id, nombre)
VALUES (seq_perfil.nextVal, 'analista');
INSERT INTO rol(id, nombre)
VALUES (seq_rol.nextVal, 'desarrollo');
INSERT INTO rol(id, nombre)
VALUES (seq_rol.nextVal, 'analisis');
INSERT INTO rol(id, nombre)
VALUES (seq_rol.nextVal, 'pruebas');
INSERT INTO perfil_rol(perfilId, rolId) 
VALUES ((SELECT id FROM perfil WHERE nombre = 'desarrollador'), (SELECT id FROM rol WHERE nombre = 'desarrollo'));
INSERT INTO perfil_rol(perfilId, rolId) 
VALUES ((SELECT id FROM perfil WHERE nombre = 'desarrollador'), (SELECT id FROM rol WHERE nombre = 'analisis'));
INSERT INTO perfil_rol(perfilId, rolId) 
VALUES ((SELECT id FROM perfil WHERE nombre = 'analista'), (SELECT id FROM rol WHERE nombre = 'analisis'));
INSERT INTO perfil_rol(perfilId, rolId) 
VALUES ((SELECT id FROM perfil WHERE nombre = 'analista'), (SELECT id FROM rol WHERE nombre = 'pruebas'));
INSERT INTO usuario_perfil(usuarioId, perfilId)
VALUES ((SELECT id FROM usuario WHERE name = 'abregup'), 
  (SELECT id FROM perfil WHERE nombre = 'analista'));
INSERT INTO usuario_mayor_perfil(usuarioMayorId, perfilId)
VALUES ((SELECT id FROM usuario_mayor WHERE profesion = 'ingsistemas'),
(SELECT id FROM perfil WHERE nombre = 'desarrollador'));

INSERT INTO menu(id, nombre, padreId)
VALUES (seq_menu.nextVal, 'item1', null);
INSERT INTO menu(id, nombre, padreId)
VALUES (seq_menu.nextVal, 'item2', null);
INSERT INTO menu(id, nombre, padreId)
VALUES (seq_menu.nextVal, 'item3', null);
INSERT INTO menu(id, nombre, padreId)
VALUES (seq_menu.nextVal, 'item1.1', (SELECT id FROM menu WHERE nombre = 'item1'));

INSERT INTO rol_menu(rolId, menuId)
VALUES ((SELECT id FROM rol WHERE nombre = 'desarrollo'), 
  (SELECT id FROM menu WHERE nombre = 'item1'));
INSERT INTO rol_menu(rolId, menuId)
VALUES ((SELECT id FROM rol WHERE nombre = 'analisis'), 
  (SELECT id FROM menu WHERE nombre = 'item2'));
INSERT INTO rol_menu(rolId, menuId)
VALUES ((SELECT id FROM rol WHERE nombre = 'desarrollo'), 
  (SELECT id FROM menu WHERE nombre = 'item3'));
INSERT INTO rol_menu(rolId, menuId)
VALUES ((SELECT id FROM rol WHERE nombre = 'analisis'), 
  (SELECT id FROM menu WHERE nombre = 'item3'));
commit;

--CREATE UNIQUE INDEX TESTING.usuario_pk ON TESTING.usuario (id);
--CREATE UNIQUE INDEX TESTING.usuario_mayor_pk ON TESTING.usuario_mayor (id);
--CREATE UNIQUE INDEX TESTING.perfil_pk ON TESTING.perfil (id);
--CREATE UNIQUE INDEX TESTING.rol_pk ON TESTING.rol (id);
--CREATE UNIQUE INDEX TESTING.perfil_rol_pk ON TESTING.perfil_rol (perfilId, rolId);
--CREATE UNIQUE INDEX TESTING.usuario_perfil_pk ON TESTING.usuario_perfil (usuarioId,perfilId);
--CREATE UNIQUE INDEX TESTING.usuario_mayor_perfil_pk ON TESTING.usuario_mayor_perfil (usuarioMayorId,perfilId)
--CREATE UNIQUE INDEX TESTING.menu_pk ON TESTING.menu (id);
--CREATE UNIQUE INDEX TESTING.rol_menu_pk ON TESTING.rol_menu (rolId, menuId);


--select INDEX_NAME, INDEX_TYPE, TABLE_NAME, UNIQUENESS
--from USER_INDEXES;

