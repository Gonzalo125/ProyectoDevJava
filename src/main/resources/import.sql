


INSERT INTO `cliente` ( apellido, nombre, email, telefono) VALUES ( 'Pérez', 'Juan', 'jperez@hotmail.com', '999-678-234');
# GO
INSERT INTO `cliente` ( apellido, nombre, email, telefono) VALUES ('Raymondi', 'Walter', 'wraymondi@gmail.com', '678-5678');
# GO
INSERT INTO `cliente` (apellido, nombre, email, telefono) VALUES ( 'Rios', 'Karla', 'karla@yahoo.es', '456-6756');
# GO
INSERT INTO `cliente` ( apellido, nombre, email, telefono) VALUES ('Alcántara', 'Ana', 'aalcantara@yahoo.es', '980-456-554');


INSERT INTO `users` (username, password, enabled) VALUES ('gonzalo','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',1);
INSERT INTO `users` (username, password, enabled) VALUES ('admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1);

INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_USER');

INSERT INTO `impuesto` (tipo, valor) VALUES ('municipal',0.10);
INSERT INTO `impuesto` (tipo, valor) VALUES ('condado',0.05);
INSERT INTO `impuesto` (tipo, valor) VALUES ('estatal',0.08);
INSERT INTO `impuesto` (tipo, valor) VALUES ('federal',0.02);

INSERT INTO `categoria` (nombre_cat) VALUES ('galletas');
INSERT INTO `categoria` (nombre_cat) VALUES ('caramelos');
INSERT INTO `categoria` (nombre_cat) VALUES ('tartas');
INSERT INTO `categoria` (nombre_cat) VALUES ('postres');
INSERT INTO `categoria` (nombre_cat) VALUES ('bebidas');

INSERT INTO `producto` (nomb_product, precio, status, categoria_id) VALUES ('oreo',0.5,'activo',1);
INSERT INTO `producto` (nomb_product, precio, status, categoria_id) VALUES ('picolini',0.01,'inactivo',2);
INSERT INTO `producto` (nomb_product, precio, status, categoria_id) VALUES ('pai de manzana',0.5,'activo',3);
INSERT INTO `producto` (nomb_product, precio, status, categoria_id) VALUES ('leche azada',0.5,'activo',4);
INSERT INTO `producto` (nomb_product, precio, status, categoria_id) VALUES ('gaseosa',0.3,'activo',5);

INSERT INTO `item_list_art` (producto_id, cantidad) VALUES (1,10);
INSERT INTO `item_list_art` (producto_id, cantidad) VALUES (2,70);
INSERT INTO `item_list_art` (producto_id, cantidad) VALUES (3,28);
INSERT INTO `item_list_art` (producto_id, cantidad) VALUES (4,40);
INSERT INTO `item_list_art` (producto_id, cantidad) VALUES (5,25);

INSERT INTO `pedido` (estado, fecha,cliente_id,impuesto_id,itemlist_id) VALUES ('active',NOW(),1,1,1);

INSERT INTO `orden` (fecha, pedido_id) VALUES (NOW(),1);