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


INSERT INTO tb_category (name, created_at, updated_at) VALUES ('Entradas', NOW(), null);
INSERT INTO tb_category (name, created_at, updated_at) VALUES ('Porções', NOW(), null);
INSERT INTO tb_category (name, created_at, updated_at) VALUES ('Petiscos', NOW(), null);
INSERT INTO tb_category (name, created_at, updated_at) VALUES ('Especiais', NOW(), null);
INSERT INTO tb_category (name, created_at, updated_at) VALUES ('Acompanhamentos', NOW(), null);
INSERT INTO tb_category (name, created_at, updated_at) VALUES ('Sobremesas', NOW(), null);
INSERT INTO tb_category (name, created_at, updated_at) VALUES ('Bebidas', NOW(), null);
INSERT INTO tb_category (name, created_at, updated_at) VALUES ('Cervejas', NOW(), null);
INSERT INTO tb_category (name, created_at, updated_at) VALUES ('Coqueteis', NOW(), null);
INSERT INTO tb_category (name, created_at, updated_at) VALUES ('Vinhos', NOW(), null);


