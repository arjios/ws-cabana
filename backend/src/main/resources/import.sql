INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_STAFF');
INSERT INTO tb_role (authority) VALUES ('ROLE_SELLER');

INSERT INTO tb_user (first_name, last_name, email, password, role_id) VALUES ('Jose', 'Patrocinio', 'jp@gmail.com', '$2a$10$iq9iv6Big4nf6CnKPoBF7.xFqnBXd8swpDu6NUU3OFFZHP4AU/V4m', 1);
INSERT INTO tb_user (first_name, last_name, email, password, role_id) VALUES ('Antonio', 'Castro Alves', 'aca@gmail.com', '$2a$10$iq9iv6Big4nf6CnKPoBF7.xFqnBXd8swpDu6NUU3OFFZHP4AU/V4m', 2);
INSERT INTO tb_user (first_name, last_name, email, password, role_id) VALUES ('João', 'Maria', 'jm@gmail.com', '$2a$10$iq9iv6Big4nf6CnKPoBF7.xFqnBXd8swpDu6NUU3OFFZHP4AU/V4m', 3);
INSERT INTO tb_user (first_name, last_name, email, password, role_id) VALUES ('Roberval', 'Taylor', 'rt@gmail.com', '$2a$10$iq9iv6Big4nf6CnKPoBF7.xFqnBXd8swpDu6NUU3OFFZHP4AU/V4m', 1);
INSERT INTO tb_user (first_name, last_name, email, password, role_id) VALUES ('Manuel', 'Pereira', 'mp@gmail.com', 'eyJhbGciOiJIUzI1NiJ9.e30.Df3nAFzT7HUCgGGRU24OCCIIFnwUPBWakRLUQaAqu10', 2);
INSERT INTO tb_user (first_name, last_name, email, password, role_id) VALUES ('Ana', 'Maria Siqueira', 'ams@gmail.com', 'eyJhbGciOiJIUzI1NiJ9.e30.Df3nAFzT7HUCgGGRU24OCCIIFnwUPBWakRLUQaAqu10', 3);
INSERT INTO tb_user (first_name, last_name, email, password, role_id) VALUES ('Pedro', 'Peixoto', 'pp@gmail.com', 'eyJhbGciOiJIUzI1NiJ9.e30.Df3nAFzT7HUCgGGRU24OCCIIFnwUPBWakRLUQaAqu10', 4);

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

INSERT INTO tb_product (number, name, description, url_image, date, price, category_id) VALUES (106, 'TORRESMO DE BARRIGUINHA 250g', 'Torresmo de Barriguinha 250g com Molho Barbecue', '../../assets/images/jpg/products/torresmo.jpg', NOW(), 34.90, 1);
INSERT INTO tb_product (number, name, description, url_image, date, price, category_id) VALUES (102, 'BOLINHOS DE FEIJOADA', 'Bolinho de Feijoada 6 unidades', '../../assets/images/jpg/products/torresmo.jpg', NOW(), 34.90, 1);
INSERT INTO tb_product (number, name, description, url_image, date, price, category_id) VALUES (103, 'BOLINHOS DE BACALHAU', 'Bolinho de Bacalhau 4 unidades', '../../assets/images/jpg/products/torresmo.jpg', NOW(), 34.90, 1);
INSERT INTO tb_product (number, name, description, url_image, date, price, category_id) VALUES (104, 'BOLINHOS DE MOQUECA', 'Bolinho de Moqueca 6 unidades', '../../assets/images/jpg/products/torresmo.jpg', NOW(), 34.90, 1);
INSERT INTO tb_product (number, name, description, url_image, date, price, category_id) VALUES (105, 'BOLINHOS DE CARNE', 'Bolinho de Carne 6 unidades', '../../assets/images/jpg/products/torresmo.jpg', NOW(), 34.90, 1);
INSERT INTO tb_product (number, name, description, url_image, date, price, category_id) VALUES (113, 'BOLINHOS DE PEIXE', 'Bolinho de Peixe 6 unidades', '../../assets/images/jpg/products/torresmo.jpg', NOW(), 34.90, 1);
INSERT INTO tb_product (number, name, description, url_image, date, price, category_id) VALUES (111, 'MIX DE BOLINHOS', '2 de carne, 2 de feijoada, 2 de moqueca, 2 de peixe', '../../assets/images/jpg/products/torresmo.jpg', NOW(), 49.90, 1);
INSERT INTO tb_product (number, name, description, url_image, date, price, category_id) VALUES (112, 'PASTELZINHO CABANA', 'Pastelzinho Cabana 5 unidades  carne ou camarão', '../../assets/images/jpg/products/torresmo.jpg', NOW(), 34.90, 1);
INSERT INTO tb_product (number, name, description, url_image, date, price, category_id) VALUES (101, 'CASQUINHA DE SIRI 200G', 'Casquinha de siri 200g 1 unidade. Acompanha Farofa e Vinagrete', '../../assets/images/jpg/products/torresmo.jpg', NOW(), 34.90, 1);
INSERT INTO tb_product (number, name, description, url_image, date, price, category_id) VALUES (114, 'CASCATA DE CAMARÃO MÉDIO', 'Cascata de Camarão 6 unidades com molho tártaro', '../../assets/images/jpg/products/torresmo.jpg', NOW(), 49.90, 1);
INSERT INTO tb_product (number, name, description, url_image, date, price, category_id) VALUES (107, 'LINGUIÇA DE ROÇA (GROSSA) 250G', 'Linguiça da roça 250g com Queijo Coalho 100g', '../../assets/images/jpg/products/torresmo.jpg', NOW(), 44.90, 1);
