/*
  SC-403 Práctica 01 - Catálogo de suculentas
  Al ejecutarlo como root deja lista la base practica, el usuario
  que usa la aplicación, la tabla suculenta y cinco registros de prueba.
  Se puede correr varias veces porque primero borra lo que exista.
*/
drop database if exists practica;
drop user if exists usuario_practica;

-- Base de datos de la práctica
CREATE database practica
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_unicode_ci;

-- Usuario con el que se conecta Spring Boot (solo puede leer y modificar datos)
create user 'usuario_practica'@'%' identified by 'la_Clave';
grant select, insert, update, delete on practica.* to 'usuario_practica'@'%';
flush privileges;

use practica;

-- Cada fila es una suculenta del catálogo; ruta_imagen guarda el enlace a la foto en la nube
create table suculenta (
  id_suculenta INT NOT NULL AUTO_INCREMENT,
  nombre_comun VARCHAR(50) NOT NULL,
  nombre_cientifico VARCHAR(80) NOT NULL,
  familia VARCHAR(50),
  color_principal VARCHAR(30),
  altura_cm DECIMAL(6,2),
  precio_estimado DECIMAL(12,2),
  nivel_riego VARCHAR(20),
  ruta_imagen VARCHAR(1024),
  PRIMARY KEY (id_suculenta))
  ENGINE = InnoDB;

-- Cinco suculentas reales para probar el listado desde el inicio
INSERT INTO suculenta (nombre_comun, nombre_cientifico, familia, color_principal, altura_cm, precio_estimado, nivel_riego, ruta_imagen) VALUES
('Rosa de alabastro', 'Echeveria elegans',       'Crassulaceae',  'Verde azulado', 10, 3500, 'Bajo',  'https://cdn11.bigcommerce.com/s-x68mczjd0x/images/stencil/1280x1280/products/914/6611/Echeveria_elegans_1g__62365.1677712224.jpg?c=2'),
('Árbol de jade',     'Crassula ovata',          'Crassulaceae',  'Verde',         60, 5000, 'Bajo',  'https://tse3.mm.bing.net/th/id/OIP.qfIDVEd13EVNo9XwJYg8wwHaFj?r=0&rs=1&pid=ImgDetMain&o=7&rm=3'),
('Cola de burro',     'Sedum morganianum',       'Crassulaceae',  'Verde claro',   30, 4500, 'Medio', 'https://tse1.mm.bing.net/th/id/OIP.TZ8oEJkRQvc8tZ1xBvC8VgHaE8?r=0&rs=1&pid=ImgDetMain&o=7&rm=3'),
('Planta cebra',      'Haworthiopsis attenuata', 'Asphodelaceae', 'Verde oscuro',  15, 3000, 'Bajo',  'https://tse3.mm.bing.net/th/id/OIP.dl2j5w4Kp5DVvkscDDlT6AHaE8?r=0&rs=1&pid=ImgDetMain&o=7&rm=3'),
('Sábila',            'Aloe vera',               'Asphodelaceae', 'Verde',         50, 2500, 'Medio', 'https://tse1.explicit.bing.net/th/id/OIP.ct-0xMTroc59YASL06IBDwHaE7?r=0&rs=1&pid=ImgDetMain&o=7&rm=3');