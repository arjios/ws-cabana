INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLA_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ATTENDANT');
INSERT INTO tb_role (authority) VALUES ('ROLE_STAFF');


INSERT INTO tb_user (first_name, last_name, email, password, role_id) VALUES ('Jose', 'Patrocinio', 'jp@gmail.com', '123456', 1);
INSERT INTO tb_user (first_name, last_name, email, password, role_id) VALUES ('Antonio', 'Castro Alves', 'aca@gmail.com', '123456', 2);
INSERT INTO tb_user (first_name, last_name, email, password, role_id) VALUES ('João', 'Maria', 'jm@gmail.com', '123456', 3);
INSERT INTO tb_user (first_name, last_name, email, password, role_id) VALUES ('Roberval', 'Taylor', 'rt@gmail.com', '123456', 1);
INSERT INTO tb_user (first_name, last_name, email, password, role_id) VALUES ('Manuel', 'Pereira', 'mp@gmail.com', '123456', 2);
INSERT INTO tb_user (first_name, last_name, email, password, role_id) VALUES ('Ana', 'Maria Siqueira', 'ams@gmail.com', '123456', 3);
INSERT INTO tb_user (first_name, last_name, email, password, role_id) VALUES ('Pedro', 'Peixoto', 'pp@gmail.com', '123456', 3);


INSERT INTO tb_category (name, url_image, created_at, updated_at) VALUES ('Entradas', '../../assets/images/jpg/bolinhodefeijoada.jpg', NOW(), null);
INSERT INTO tb_category (name, url_image, created_at, updated_at) VALUES ('Porções', '../../assets/images/jpg/porções.jpg', NOW(), null);
INSERT INTO tb_category (name, url_image, created_at, updated_at) VALUES ('Cones', '../../assets/images/jpg/cones.jpg', NOW(), null);
INSERT INTO tb_category (name, url_image, created_at, updated_at) VALUES ('Executivo', '../../assets/images/jpg/executivo.jpg', NOW(), null);
INSERT INTO tb_category (name, url_image, created_at, updated_at) VALUES ('Acompanhamentos', '../../assets/images/jpg/infantis.jpg', NOW(), null);
INSERT INTO tb_category (name, url_image, created_at, updated_at) VALUES ('Especiais', '../../assets/images/jpg/especiais.jpg', NOW(), null);
INSERT INTO tb_category (name, url_image, created_at, updated_at) VALUES ('Sobremesas', '../../assets/images/jpg/sobremesas.jpg', NOW(), null);
INSERT INTO tb_category (name, url_image, created_at, updated_at) VALUES ('Bebidas', '../../assets/images/jpg/bebidas.jpg', NOW(), null);
INSERT INTO tb_category (name, url_image, created_at, updated_at) VALUES ('Coqueteis', '../../assets/images/jpg/coqueteis.jpg', NOW(), null);
INSERT INTO tb_category (name, url_image, created_at, updated_at) VALUES ('Cervejas', '../../assets/images/jpg/cervejas.jpg', NOW(), null);
INSERT INTO tb_category (name, url_image, created_at, updated_at) VALUES ('Vinhos', '../../assets/images/jpg/vinhos.jpg', NOW(), null);

INSERT INTO tb_product (number, name, description, url_image, date, price, category_id) VALUES (106, 'Torresmo de Barriguinha 250g', 'Torresmo de Barriguinha 250g com Molho Barbecue', '../../assets/images/jpg/products/torresmo.jpg', NOW(), 34.90, 1);
