-- Este script añade datos de ejemplo a las tablas para facilitar el desarrollo y pruebas.

-- Base de datos arso-espacios
USE `arso-espacios`;
SET NAMES utf8mb4;

INSERT INTO espacioFisico (id, nombre, propietario, capacidad, direccion, longitud, latitud, descripcion, estado) VALUES
('f9b9b9a3-e45a-4da4-9b14-6ab01f311f9e', 'Parc Technologic de Barcelona', 'Ayuntamiento de Barcelona', 30, 'Carrer de la Innovació 7, Barcelona', 2.1712, 41.5933, 'Sala para reuniones y eventos en el Parc Technologic de Barcelona', 'ACTIVO'),
('4c1d80ec-f460-4072-b1b6-9c1cf87f994c', 'Madrid Convention Centre', 'Madrid Eventos S.L.', 50, 'Av. de la Capital de España 1, Madrid', -3.7038, 40.4168, 'Espacio ideal para conferencias y congresos en Madrid', 'ACTIVO'),
('20936e74-2a30-4ddd-a583-9fc2c8d0aaf2', 'Espacio Coworking Sevilla', 'Coworking Sevilla', 20, 'Calle Trajano 18, Sevilla', -5.9831, 37.3886, 'Pequeña sala para encuentros de trabajo y networking', 'CERRADO_TEMPORALMENTE'),
('bc0d03b3-f649-45b2-936a-00faeb16ebf8', 'Centro de Negocios Valencia', 'Centro de Negocios Valencia', 40, 'Avenida de las Cortes Valencianas 23, Valencia', -0.3780, 39.4699, 'Espacio para eventos sociales y reuniones corporativas', 'ACTIVO'),
('e3e1e374-b7c7-4b37-a8ad-1e1e393ebd33', 'Bilbao Business Center', 'Bilbao Business Center', 25, 'Calle de María Díaz de Haro 4, Bilbao', -2.9321, 43.2630, 'Sala para eventos pequeños, ideal para presentaciones y reuniones', 'ACTIVO'),
('d36f893d-93a3-4530-aabb-b430fb137f86', 'La Nave Madrid', 'La Nave S.L.', 100, 'Calle Cifuentes 4, Madrid', -3.7273, 40.4196, 'Gran espacio para congresos, exposiciones y workshops', 'ACTIVO'),
('dc27e436-6db3-4c96-9d56-973d53f9db14', 'Barcelona Activa', 'Barcelona Activa', 60, 'Carrer de la Llacuna 162, Barcelona', 2.1881, 41.3970, 'Espacio de coworking y sala para eventos de gran tamaño', 'ACTIVO'),
('274f7bbe-6938-4c72-9dca-b136a5fda4bb', 'Parque Tecnológico de Andalucía', 'Parque Tecnológico de Andalucía', 80, 'Parque Tecnológico de Andalucía, Málaga', -4.5441, 36.6571, 'Espacio moderno con vistas a la montaña, ideal para eventos tecnológicos', 'ACTIVO'),
('885f413a-6989-41c8-a8e5-ac29483be85c', 'Business Center Valencia', 'Business Center Valencia', 35, 'Avenida de la Malvarrosa 8, Valencia', -0.3485, 39.4797, 'Espacio elegante para presentaciones y reuniones de negocio', 'ACTIVO'),
('df028ece-5a37-4306-9ed7-5cc46ee682a3', 'WorkSpace Madrid', 'WorkSpace Madrid', 50, 'Calle de San Bernardo 23, Madrid', -3.7056, 40.4280, 'Sala ideal para workshops y eventos pequeños en Madrid', 'ACTIVO'),
('520aede2-7eb2-4e80-9658-5aeebe5949bd', 'Centro de Innovación Barcelona', 'Centro de Innovación Barcelona', 70, 'Carrer de Pau Claris 56, Barcelona', 2.1697, 41.3906, 'Centro de innovación con infraestructura para eventos colaborativos', 'ACTIVO'),
('68c45691-fa16-43fc-96b0-a428802bc99f', 'El Cubo Zaragoza', 'El Cubo Zaragoza', 25, 'Calle María Zambrano 9, Zaragoza', -0.8965, 41.6496, 'Espacio flexible para reuniones y eventos pequeños', 'ACTIVO'),
('ab6ae75a-4b6d-4677-ab8c-84b626b917ff', 'Espacio Coworking A Coruña', 'Espacio Coworking A Coruña', 40, 'Avenida de la Universidad 16, A Coruña', -8.3973, 43.3667, 'Espacio ideal para trabajar de manera colaborativa', 'ACTIVO'),
('1087ea37-3e37-4503-81af-48b99309ec2f', 'Foro de Negocios Sevilla', 'Foro de Negocios Sevilla', 50, 'Avenida de la República Argentina 12, Sevilla', -5.9882, 37.3935, 'Espacio profesional para congresos y charlas empresariales', 'ACTIVO'),
('2043c4bd-8ff6-4a01-8d60-dc354eb7a480', 'Red de Espacios Coworking Madrid', 'Red de Espacios Coworking Madrid', 45, 'Calle de Vallehermoso 73, Madrid', -3.7128, 40.4395, 'Red de espacios colaborativos para empresas emergentes', 'ACTIVO'),
('6bb5a3b1-5374-4e7b-974f-e127edaececc', 'Espacio Empresarial Málaga', 'Espacio Empresarial Málaga', 60, 'Calle Larios 16, Málaga', -4.4213, 36.7213, 'Centro de negocios ideal para networking y exposiciones', 'ACTIVO'),
('6d1e6cd1-5231-4bbd-9367-4537cb98b56a', 'Barcelona Tech Hub', 'Barcelona Tech Hub', 70, 'Carrer de Pau Claris 166, Barcelona', 2.1737, 41.3947, 'Espacio dedicado a eventos de tecnología e innovación', 'ACTIVO'),
('a70c80c3-e839-493b-a000-be89723e0dc1', 'Madrid Business Plaza', 'Madrid Business Plaza', 100, 'Calle de Gran Vía 34, Madrid', -3.7055, 40.4192, 'Gran espacio para conferencias y presentaciones en el centro de Madrid', 'ACTIVO'),
('369ce218-5d35-4acd-9b14-faacc41bfecc', 'La Central de Coworking Valencia', 'La Central Coworking Valencia', 30, 'Carrer de l`Albufera 31, Valencia', -0.3904, 39.4593, 'Espacio moderno de coworking ideal para reuniones de pequeñas empresas', 'ACTIVO'),
('20689c0d-b75f-4c9f-b7fa-db9f00d313dd', 'Centro de Negocios La Plana', 'Centro de Negocios La Plana', 50, 'Carrer de la Plana 9, Castellón', -0.0567, 39.9897, 'Espacio para reuniones de empresas y conferencias', 'ACTIVO'),
('8dc1ec1a-343f-412e-b595-8391b8af1f05', 'Espacio de Innovación Burgos', 'Espacio de Innovación Burgos', 30, 'Calle de Vitoria 34, Burgos', -3.7130, 42.3402, 'Espacio dedicado a la innovación tecnológica en Burgos', 'ACTIVO'),
('087321ed-b8c5-4eac-95ff-68f302946183', 'Espacio Colaborativo Madrid', 'Espacio Colaborativo Madrid', 40, 'Calle de Alcalá 25, Madrid', -3.6756, 40.4214, 'Centro de coworking para empresas emergentes en Madrid', 'ACTIVO'),
('fd244de4-7822-43f6-a96c-0609641d4f9f', 'Hub de Innovación Valencia', 'Hub de Innovación Valencia', 55, 'Carrer de la Ciutat de l`Horta 20, Valencia', -0.3843, 39.4742, 'Espacio para empresas innovadoras y startups en Valencia', 'ACTIVO'),
('0e7d1fa6-de9e-4b99-9b6a-69a556ee36fc', 'Espacio de Innovación Málaga', 'Innovación Málaga', 70, 'Calle del Comedias 10, Málaga', -4.4203, 36.7175, 'Espacio ideal para conferencias y seminarios de innovación tecnológica', 'ACTIVO'),
('55290f04-c2bf-4b92-87f0-53df4abd553f', 'Centro de Emprendedores Sevilla', 'Centro de Emprendedores Sevilla', 50, 'Avenida de la Palmera 41, Sevilla', -5.9783, 37.3785, 'Espacio para emprendedores y nuevas ideas en Sevilla', 'ACTIVO'),
('455a6e53-d8e9-4085-bd0d-49a0e6620740', 'Barcelona Tech Lab', 'Barcelona Tech Lab', 60, 'Carrer de Provença 211, Barcelona', 2.1560, 41.3987, 'Laboratorio para la experimentación con nuevas tecnologías en Barcelona', 'ACTIVO'),
('8465a32f-0a7c-49c6-918e-911e6010d04b', 'Parque Científico de Madrid', 'Parque Científico de Madrid', 80, 'Calle del Cardenal Herrera Oria 20, Madrid', -3.7259, 40.5146, 'Centro de investigación y desarrollo con múltiples opciones para eventos', 'ACTIVO'),
('ffed9986-2958-4348-b3ab-7360598a060a', 'BizBarcelona', 'BizBarcelona', 90, 'Carrer de Pau Claris 132, Barcelona', 2.1673, 41.3925, 'Espacio para emprendedores, startups y eventos de innovación', 'ACTIVO'),
('4801040f-8df2-4a09-acb9-cc59bff0887c', 'Espacio de Networking Valencia', 'Networking Valencia', 40, 'Carrer de València 10, Valencia', -0.3803, 39.4749, 'Espacio para eventos de networking y formación profesional', 'ACTIVO'),
('8efc625d-9507-4405-97a3-ee79495522d7', 'Centro de Convenciones Zaragoza', 'Centro de Convenciones Zaragoza', 100, 'Carrer de Magisterio 34, Zaragoza', -0.8833, 41.6524, 'Gran centro de convenciones para eventos empresariales en Zaragoza', 'ACTIVO'),

('1e22a0c0-1a6e-4e0a-9c84-d6c0fcae0e11', 'Sala Multiusos A', 'admin', 50, 'Calle Sol 123, Madrid', -3.7038, 40.4168, 'Espacio amplio para talleres o charlas.', 'ACTIVO'),
('3g44c2e2-3c8g-5g2c-9g06-f8e2hecg2g33', 'Sala de reuniones norte', 'admin', 15, 'Calle Norte 77, Sevilla', -5.9845, 37.3891, 'Ideal para reuniones pequeñas o tutorías.', 'ACTIVO'),
('5i66e4g4-5e0i-7i4e-1i28-h0g4jgeg4i55', 'Sala de Informática', 'admin', 25, 'Calle Tecnología 5, Valencia', -0.3763, 39.4699, 'Sala con ordenadores y acceso a internet.', 'ACTIVO'),
('7k88g6i6-7g2k-9k6g-3k40-j2i6ligi6k77', 'Sala de Exposiciones', 'admin', 60, 'Calle Museo 14, Málaga', -4.4214, 36.7213, 'Espacio para muestras, exposiciones o ferias.', 'ACTIVO'),

('6j77f5h5-6f1j-8j5f-2j39-i1h5khfh5j66', 'Auditorio Principal', 'admin', 200, 'Av. de las Artes 9, Zaragoza', -0.8877, 41.6488, 'Auditorio equipado con sonido y proyección.', 'CERRADO_TEMPORALMENTE'),
('4h55d3f3-4d9h-6h3d-0h17-g9f3ifdh3h44', 'Patio Central', 'admin', 100, 'Plaza Mayor 1, Salamanca', -5.6639, 40.9688, 'Espacio abierto para actividades recreativas.', 'CERRADO_TEMPORALMENTE'),
('2f33b1d1-2b7f-4f1b-8f95-e7d1gdbf1f22', 'Aula 204', 'admin', 30, 'Av. Universidad 45, Barcelona', 2.1734, 41.3851, 'Aula equipada con proyector y pizarra.', 'CERRADO_TEMPORALMENTE'),

('8l99h7j7-8h3l-0h7h-4h51-k3j7mjhj7l88', 'Sala de Música', 'admin', 40, 'Calle Melodía 22, Bilbao', -2.9349, 43.2630, 'Sala equipada para ensayos y conciertos.', 'ACTIVO'),
('9m00i8k8-9i4m-1i8i-5i62-l4k8nkik8m99', 'Laboratorio de Ciencias', 'admin', 16, 'Av. Ciencia 33, Granada', -3.5986, 37.1882, 'Laboratorio para prácticas científicas.', 'ACTIVO'),
('a1n11j9j-a1j5-2j9j-6j73-m5l9oljl9n00', 'Sala de Arte', 'admin', 60, 'Calle Creatividad 44, Alicante', -0.4907, 38.3452, 'Espacio para talleres artísticos.', 'ACTIVO'),
('b2o22k0k-b2k6-3k0k-7k84-n6m0pmkm0o11', 'Sala de Conferencias B', 'admin', 50, 'Calle Sabiduría 55, Murcia', -1.1307, 37.9922, 'Sala equipada para conferencias y charlas.', 'ACTIVO');

INSERT INTO puntoInteres (id, nombre, descripcion, distancia, url) VALUES
('40304e72-c7b0-443a-868d-f1cf0ff42f96', 'Museo de Ciencia CosmoCaixa', 'Museo interactivo de ciencia, ideal para todos los públicos', 450.0, 'https://cosmocaixa.es'),
('bc2ad777-25c1-4c11-8868-4f38f99eb1a3', 'Parque de la Creueta del Coll', 'Zona verde con estanque y esculturas modernas', 320.0, 'https://ajuntament.barcelona.cat'),
('6e828579-a1c9-45dc-a7e2-7ffef198215d', 'Palacio de Cibeles', 'Centro cultural y edificio emblemático en Madrid', 600.0, 'https://www.cibelescentrocentrocultura.es'),
('4d991518-0775-4448-b643-97c66e6b6868', 'Jardines del Descubrimiento', 'Espacio ajardinado con monumentos históricos', 250.0, 'https://esmadrid.com'),
('d722829e-a1e3-42aa-afef-1939f788938d', 'Mercado de la Calle Feria', 'Mercado tradicional con productos locales y tapas', 400.0, 'https://visitasevilla.es'),
('d1f6741b-ea42-4bde-ba9a-baad4c375e53', 'Ciudad de las Artes y las Ciencias', 'Complejo arquitectónico y cultural de vanguardia', 750.0, 'https://cac.es'),
('59f7c533-677f-4c53-a8ee-56a006e8d459', 'Museo Guggenheim Bilbao', 'Museo de arte moderno y contemporáneo', 650.0, 'https://guggenheim-bilbao.eus'),
('385464d7-b87b-4aca-95d9-4b068d41df13', 'Matadero Madrid', 'Centro de creación contemporánea y cultura urbana', 850.0, 'https://www.mataderomadrid.org'),
('7c9f9d67-203a-4de7-a2e4-3382f1102c02', 'Playa de la Mar Bella', 'Playa urbana conocida por su ambiente relajado', 800.0, 'https://barcelona.cat'),
('ae6ea75f-beb8-41b8-bb67-e8776f5b98cd', 'Jardín Botánico-Histórico La Concepción', 'Espacio natural con especies tropicales', 900.0, 'https://laconcepcion.malaga.eu'),
('d1cbd05c-ffd5-4e4e-9ed8-8b716cb88b4f', 'Playa de la Malvarrosa', 'Famosa playa urbana con paseo marítimo', 300.0, 'https://visitvalencia.com'),
('7c3aff76-2c26-442b-82e3-37a13f75f336', 'Museo Nacional de Ciencias Naturales', 'Museo sobre biodiversidad y evolución', 750.0, 'https://mncn.csic.es'),
('b40f399d-66bc-459a-aae5-94bc5713c0e2', 'Casa Batlló', 'Obra icónica de Gaudí en pleno Passeig de Gràcia', 450.0, 'https://casabatllo.es'),
('21a0fdcd-9114-4ad9-9b11-8c0b0664ee2e', 'Palacio de la Aljafería', 'Castillo islámico convertido en sede parlamentaria', 800.0, 'https://cortesaragon.es'),
('8ce2750a-7006-4d68-8989-cf3438e2e435', 'Domus – Casa del Hombre', 'Museo interactivo sobre el cuerpo humano', 600.0, 'https://museoscoruna.gal'),
('0693a998-8f1f-413c-aa05-1b935c872268', 'Parque de los Príncipes', 'Amplio parque urbano con zonas de descanso y estanques', 300.0, 'https://visitasevilla.es'),
('4198d8d7-86ab-49a8-a9fd-b097bc0dd5df', 'Teatro del Barrio', 'Espacio cultural alternativo en Lavapiés', 500.0, 'https://teatrodelbarrio.com'),
('08847369-70ed-44a9-bbf9-a3c755b31b75', 'Museo Carmen Thyssen', 'Museo dedicado a pintura andaluza del siglo XIX', 350.0, 'https://carmenthyssenmalaga.org'),
('8f4729ad-a8f3-41a2-8fc9-9eae5d95625b', 'Fundación Antoni Tàpies', 'Museo de arte moderno en un edificio modernista', 250.0, 'https://fundaciotapies.org'),
('8df26753-9b5d-4448-89dc-5a9c7a911a1a', 'Templo de Debod', 'Templo egipcio en pleno centro de Madrid', 650.0, 'https://esmadrid.com');

INSERT INTO espacioFisico_puntoInteres (idEspacioFisico, idPuntosInteres) VALUES
('f9b9b9a3-e45a-4da4-9b14-6ab01f311f9e', '40304e72-c7b0-443a-868d-f1cf0ff42f96'), -- Parc Technologic de Barcelona - CosmoCaixa
('dc27e436-6db3-4c96-9d56-973d53f9db14', 'bc2ad777-25c1-4c11-8868-4f38f99eb1a3'), -- Barcelona Activa - Parque Creueta del Coll
('4c1d80ec-f460-4072-b1b6-9c1cf87f994c', '6e828579-a1c9-45dc-a7e2-7ffef198215d'), -- Madrid Convention Centre - Palacio de Cibeles
('4c1d80ec-f460-4072-b1b6-9c1cf87f994c', '4d991518-0775-4448-b643-97c66e6b6868'), -- Madrid Convention Centre - Jardines del Descubrimiento
('20936e74-2a30-4ddd-a583-9fc2c8d0aaf2', 'd722829e-a1e3-42aa-afef-1939f788938d'), -- Coworking Sevilla - Mercado de la Calle Feria
('bc0d03b3-f649-45b2-936a-00faeb16ebf8', 'd1cbd05c-ffd5-4e4e-9ed8-8b716cb88b4f'), -- Centro Negocios Valencia - Playa Malvarrosa
('e3e1e374-b7c7-4b37-a8ad-1e1e393ebd33', '59f7c533-677f-4c53-a8ee-56a006e8d459'), -- Bilbao Business Center - Guggenheim
('d36f893d-93a3-4530-aabb-b430fb137f86', '385464d7-b87b-4aca-95d9-4b068d41df13'), -- La Nave Madrid - Matadero Madrid
('dc27e436-6db3-4c96-9d56-973d53f9db14', '7c9f9d67-203a-4de7-a2e4-3382f1102c02'), -- Barcelona Activa - Playa Mar Bella
('274f7bbe-6938-4c72-9dca-b136a5fda4bb', 'ae6ea75f-beb8-41b8-bb67-e8776f5b98cd'), -- Parque Tecnológico Andalucía - Jardín Botánico Málaga
('df028ece-5a37-4306-9ed7-5cc46ee682a3', '7c3aff76-2c26-442b-82e3-37a13f75f336'), -- WorkSpace Madrid - Museo Ciencias Naturales
('520aede2-7eb2-4e80-9658-5aeebe5949bd', 'b40f399d-66bc-459a-aae5-94bc5713c0e2'), -- Centro Innovación Barcelona - Casa Batlló
('68c45691-fa16-43fc-96b0-a428802bc99f', '21a0fdcd-9114-4ad9-9b11-8c0b0664ee2e'), -- El Cubo Zaragoza - Palacio de la Aljafería
('ab6ae75a-4b6d-4677-ab8c-84b626b917ff', '8ce2750a-7006-4d68-8989-cf3438e2e435'), -- Coworking A Coruña - Domus
('1087ea37-3e37-4503-81af-48b99309ec2f', '0693a998-8f1f-413c-aa05-1b935c872268'), -- Foro Negocios Sevilla - Parque Príncipes
('2043c4bd-8ff6-4a01-8d60-dc354eb7a480', '4198d8d7-86ab-49a8-a9fd-b097bc0dd5df'), -- Red Coworking Madrid - Teatro del Barrio
('6bb5a3b1-5374-4e7b-974f-e127edaececc', '08847369-70ed-44a9-bbf9-a3c755b31b75'), -- Espacio Empresarial Málaga - Museo Carmen Thyssen
('6d1e6cd1-5231-4bbd-9367-4537cb98b56a', '8f4729ad-a8f3-41a2-8fc9-9eae5d95625b'), -- Barcelona Tech Hub - Fundación Tàpies
('a70c80c3-e839-493b-a000-be89723e0dc1', '8df26753-9b5d-4448-89dc-5a9c7a911a1a'); -- Madrid Business Plaza - Templo de Debod


-- Base de datos arso-eventos
USE `arso-eventos`;
SET NAMES utf8mb4;

INSERT INTO espacioFisico (id, cancelado, capacidad) VALUES
('f9b9b9a3-e45a-4da4-9b14-6ab01f311f9e', false, 30),
('4c1d80ec-f460-4072-b1b6-9c1cf87f994c', false, 50),
('20936e74-2a30-4ddd-a583-9fc2c8d0aaf2', true, 20),
('bc0d03b3-f649-45b2-936a-00faeb16ebf8', false, 40),
('e3e1e374-b7c7-4b37-a8ad-1e1e393ebd33', false, 100),
('dc27e436-6db3-4c96-9d56-973d53f9db14', false, 60),
('274f7bbe-6938-4c72-9dca-b136a5fda4bb', false, 80),
('885f413a-6989-41c8-a8e5-ac29483be85c', false, 35),
('df028ece-5a37-4306-9ed7-5cc46ee682a3', false, 50),
('520aede2-7eb2-4e80-9658-5aeebe5949bd', false, 70),
('68c45691-fa16-43fc-96b0-a428802bc99f', false, 25),
('ab6ae75a-4b6d-4677-ab8c-84b626b917ff', false, 40),
('1087ea37-3e37-4503-81af-48b99309ec2f', false, 50),
('2043c4bd-8ff6-4a01-8d60-dc354eb7a480', false, 45),
('6bb5a3b1-5374-4e7b-974f-e127edaececc', false, 60),
('6d1e6cd1-5231-4bbd-9367-4537cb98b56a', false, 70),
('a70c80c3-e839-493b-a000-be89723e0dc1', false, 100),
('369ce218-5d35-4acd-9b14-faacc41bfecc', false, 30),
('20689c0d-b75f-4c9f-b7fa-db9f00d313dd', false, 50),
('8dc1ec1a-343f-412e-b595-8391b8af1f05', false, 30),
('087321ed-b8c5-4eac-95ff-68f302946183', false, 40),
('fd244de4-7822-43f6-a96c-0609641d4f9f', false, 55),
('0e7d1fa6-de9e-4b99-9b6a-69a556ee36fc', false, 70),
('55290f04-c2bf-4b92-87f0-53df4abd553f', false, 50),
('455a6e53-d8e9-4085-bd0d-49a0e6620740', false, 60),
('8465a32f-0a7c-49c6-918e-911e6010d04b', false, 80),
('ffed9986-2958-4348-b3ab-7360598a060a', false, 90),
('4801040f-8df2-4a09-acb9-cc59bff0887c', false, 40),
('8efc625d-9507-4405-97a3-ee79495522d7', false, 100),

('1e22a0c0-1a6e-4e0a-9c84-d6c0fcae0e11', false, 50),
('3g44c2e2-3c8g-5g2c-9g06-f8e2hecg2g33', false, 15),
('5i66e4g4-5e0i-7i4e-1i28-h0g4jgeg4i55', false, 25),
('7k88g6i6-7g2k-9k6g-3k40-j2i6ligi6k77', false, 60),

('2f33b1d1-2b7f-4f1b-8f95-e7d1gdbf1f22', true, 30),
('4h55d3f3-4d9h-6h3d-0h17-g9f3ifdh3h44', true, 100),
('6j77f5h5-6f1j-8j5f-2j39-i1h5khfh5j66', true, 200),

('8l99h7j7-8h3l-0h7h-4h51-k3j7mjhj7l88', false, 40),
('9m00i8k8-9i4m-1i8i-5i62-l4k8nkik8m99', false, 16),
('a1n11j9j-a1j5-2j9j-6j73-m5l9oljl9n00', false, 60),
('b2o22k0k-b2k6-3k0k-7k84-n6m0pmkm0o11', false, 50);

INSERT INTO ocupacion (id, fechaInicio, fechaFin, idEspacioFisico) VALUES
('d01e354f-07e4-4177-a517-e5f438df118a', '2025-06-01 09:00:00', '2025-06-01 12:00:00', 'f9b9b9a3-e45a-4da4-9b14-6ab01f311f9e'),
('f07406ea-3e49-48a3-b2b1-d0e28d0d421b', '2025-06-01 10:00:00', '2025-06-01 13:00:00', '4c1d80ec-f460-4072-b1b6-9c1cf87f994c'),
('dbdfc5f2-df43-45fd-9a8b-3c58b8d8be63', '2025-06-02 15:00:00', '2025-06-02 18:00:00', 'bc0d03b3-f649-45b2-936a-00faeb16ebf8'),
('8f98c4d4-e10d-42c0-8f7e-bcf51dbdc4f9', '2025-06-03 09:00:00', '2025-06-03 12:00:00', 'e3e1e374-b7c7-4b37-a8ad-1e1e393ebd33'),
('2c2f68f2-5db4-4b09-9b58-2e3b8f7298d1', '2025-06-03 10:00:00', '2025-06-03 13:00:00', 'dc27e436-6db3-4c96-9d56-973d53f9db14'),
('d2c9e912-ff1f-48d0-a1f5-3a93da195b6f', '2025-06-04 09:00:00', '2025-06-04 11:00:00', '274f7bbe-6938-4c72-9dca-b136a5fda4bb'),
('ba0aaf9d-bbfe-4576-bdc0-b6ae1e1bc961', '2025-06-04 09:00:00', '2025-06-04 12:00:00', '885f413a-6989-41c8-a8e5-ac29483be85c'),
('e6b570b0-cb69-4d67-a62f-2d2a2a4532d3', '2025-06-04 11:00:00', '2025-06-04 14:00:00', 'df028ece-5a37-4306-9ed7-5cc46ee682a3'),
('c56fa0e2-d362-452f-b1c9-4197b1b8fa83', '2025-06-04 14:00:00', '2025-06-04 17:00:00', '520aede2-7eb2-4e80-9658-5aeebe5949bd'),
('a0b62d92-b300-4c7a-8fe7-ec156eff42b3', '2025-06-05 09:00:00', '2025-06-05 12:00:00', '68c45691-fa16-43fc-96b0-a428802bc99f'),
('d4b2a9b8-1db0-46d1-9319-05d21a86cf6f', '2025-06-05 10:00:00', '2025-06-05 13:00:00', 'ab6ae75a-4b6d-4677-ab8c-84b626b917ff'),
('f0c39d62-97b1-4c51-93a5-cb8941f4b1b3', '2025-06-06 14:00:00', '2025-06-06 17:00:00', '1087ea37-3e37-4503-81af-48b99309ec2f'),
('0bce3907-e61b-47f6-b348-29f945bdb1d7', '2025-06-06 09:00:00', '2025-06-06 12:00:00', '2043c4bd-8ff6-4a01-8d60-dc354eb7a480'),
('9b93b27b-d6b8-46d2-bf3c-0f062ed1dbab', '2025-06-07 10:00:00', '2025-06-07 13:00:00', '6bb5a3b1-5374-4e7b-974f-e127edaececc'),
('0a49a663-0a0c-47db-9388-7fd5a5c9c9db', '2025-06-07 11:00:00', '2025-06-07 14:00:00', '6d1e6cd1-5231-4bbd-9367-4537cb98b56a'),
('a9e4288f-617e-4eb5-bf9e-b54d7b67444f', '2025-07-01 09:00:00', '2025-07-01 12:00:00', 'a70c80c3-e839-493b-a000-be89723e0dc1'),
('fbff6d7a-02fe-4733-9d9d-111fe5a7acdb', '2025-07-01 14:00:00', '2025-07-01 17:00:00', '369ce218-5d35-4acd-9b14-faacc41bfecc'),
('54e8098a-c33e-4404-82cc-f5a6e441f69a', '2025-07-02 09:00:00', '2025-07-02 12:00:00', '20689c0d-b75f-4c9f-b7fa-db9f00d313dd'),
('ce2ed453-6047-48ec-96ea-8b22edb96f42', '2025-07-02 10:00:00', '2025-07-02 13:00:00', '8dc1ec1a-343f-412e-b595-8391b8af1f05'),
('3abed347-22f3-4b8a-9287-b69402e9dfb7', '2025-07-03 14:00:00', '2025-07-03 17:00:00', '087321ed-b8c5-4eac-95ff-68f302946183'),
('a2b39e5e-9715-4cf0-a7a3-4c5152b9f1f9', '2025-07-04 09:00:00', '2025-07-04 12:00:00', 'fd244de4-7822-43f6-a96c-0609641d4f9f'),
('eb28138f-d7d1-4ea9-a38f-bd4e68f72b3f', '2025-07-04 11:00:00', '2025-07-04 14:00:00', '0e7d1fa6-de9e-4b99-9b6a-69a556ee36fc'),
('b10cd078-47cc-44a9-b672-e8392ffb6982', '2025-08-03 14:00:00', '2025-08-03 18:00:00', '20936e74-2a30-4ddd-a583-9fc2c8d0aaf2'),

('occ1-0000-aaaa-bbbb-000000000001', '2025-08-01 10:00:00', '2025-08-01 14:00:00', '1e22a0c0-1a6e-4e0a-9c84-d6c0fcae0e11'),
('occ3-0000-cccc-dddd-000000000003', '2025-08-05 13:00:00', '2025-08-05 16:00:00', '3g44c2e2-3c8g-5g2c-9g06-f8e2hecg2g33'),
('occ5-0000-eeee-ffff-000000000005', '2025-08-09 15:00:00', '2025-08-09 18:00:00', '5i66e4g4-5e0i-7i4e-1i28-h0g4jgeg4i55'),
('occ7-0000-gggg-hhhh-000000000007', '2025-08-13 14:00:00', '2025-08-13 17:00:00', '7k88g6i6-7g2k-9k6g-3k40-j2i6ligi6k77');

INSERT INTO evento (id, nombre, descripcion, organizador, plazas, cancelado, categoria, idOcupacion) VALUES
('a1b0c40d-9c2f-4c3a-b2f5-5fa67eeb3758', 'Conferencia sobre Inteligencia Artificial', 'Evento académico sobre avances en inteligencia artificial.', 'Universidad de Ciencia', 30, false, 'ACADEMICOS', 'd01e354f-07e4-4177-a517-e5f438df118a'),
('f5570b1f-4bfc-4f67-93e9-12140a0b7e12', 'Concierto de Rock en Vivo', 'Concierto de varias bandas de rock en vivo.', 'Música Unlimited', 50, false, 'CULTURALES', 'f07406ea-3e49-48a3-b2b1-d0e28d0d421b'),
('3de79bb2-1995-426e-8a7a-4307f1b84027', 'Futbol Amateur', 'Torneo de futbol para equipos locales.', 'Liga de Fútbol Local', 50, true, 'DEPORTES', null),
('b7c319d9-4102-4509-a7a7-d38f6b855aa6', 'Torneo de Tenis', 'Competencia de tenis entre profesionales.', 'Federación Nacional de Tenis', 40, false, 'DEPORTES', 'dbdfc5f2-df43-45fd-9a8b-3c58b8d8be63'),
('9d31509b-bd62-41c2-bb2f-084504b0177e', 'Seminario de Marketing Digital', 'Seminario de marketing digital para empresas.', 'Marketing Pro', 50, false, 'ACADEMICOS', '8f98c4d4-e10d-42c0-8f7e-bcf51dbdc4f9'),
('951dfd5b-6047-4f7e-bba9-3be6d03425ac', 'Festival de Cine Independiente', 'Muestra de cine independiente de diversos géneros.', 'CineFest', 30, false, 'CULTURALES', '2c2f68f2-5db4-4b09-9b58-2e3b8f7298d1'),
('d0d7f883-e7c0-4fe1-94e4-e9ca16776e7e', 'Maratón Benéfico', 'Maratón para recaudar fondos para la caridad.', 'Fundación de Ayuda', 100, false, 'DEPORTES', 'd2c9e912-ff1f-48d0-a1f5-3a93da195b6f'),
('fa21365f-8f89-4bfe-b91f-d00320f76e6e', 'Torneo de Ajedrez', 'Competencia abierta de ajedrez para aficionados y profesionales.', 'Club de Ajedrez', 35, false, 'DEPORTES', 'ba0aaf9d-bbfe-4576-bdc0-b6ae1e1bc961'),
('1f3a0a04-5a99-4744-9e7e-4351b8fcd210', 'Festival Gastronómico', 'Evento culinario con chefs internacionales.', 'Sabores del Mundo', 100, false, 'CULTURALES', 'e6b570b0-cb69-4d67-a62f-2d2a2a4532d3'),
('cb1d407b-18e0-4b62-9a64-cfcb1ffebdb2', 'Exposición de Arte Contemporáneo', 'Exposición de artistas contemporáneos internacionales.', 'Museo de Arte Contemporáneo', 45, false, 'CULTURALES', 'c56fa0e2-d362-452f-b1c9-4197b1b8fa83'),
('cf78a67b-e607-41a7-b9f0-c0fe64329c4a', 'Evento de Networking para Empresarios', 'Encuentro de empresarios y emprendedores para hacer networking.', 'Red de Empresarios', 25, false, 'ACADEMICOS', 'a0b62d92-b300-4c7a-8fe7-ec156eff42b3'),
('0174cc84-99d1-46ac-a2c4-278f16317c0e', 'Partido de Baloncesto', 'Partido amistoso de baloncesto entre equipos locales.', 'Asociación Deportiva Local', 70, false, 'DEPORTES', 'd4b2a9b8-1db0-46d1-9319-05d21a86cf6f'),
('1a337705-6d13-4672-bfbd-bf65a3e4e1ca', 'Feria de Tecnología', 'Exposición de los últimos avances tecnológicos.', 'Tech Expo', 60, false, 'ACADEMICOS', 'f0c39d62-97b1-4c51-93a5-cb8941f4b1b3'),
('b3479c34-808e-4674-957d-09a7204285e5', 'Competencia de Ciclismo', 'Competencia de ciclismo de ruta en las montañas.', 'Ciclismo Nacional', 100, false, 'DEPORTES', '0bce3907-e61b-47f6-b348-29f945bdb1d7'),
('a2d2ea4d-b1f9-4b91-86cc-e1448f16c4e4', 'Conferencia sobre Cambio Climático', 'Conferencia académica sobre los efectos del cambio climático.', 'Global Green', 60, false, 'ACADEMICOS', '9b93b27b-d6b8-46d2-bf3c-0f062ed1dbab'),
('6c8ea2cd-c85f-4ed0-a874-d4f01738c8fe', 'Exposición de Moda', 'Exposición de moda con diseñadores internacionales.', 'Fashion World', 60, false, 'CULTURALES', '0a49a663-0a0c-47db-9388-7fd5a5c9c9db'),
('c0d6c3de-9c3f-4d16-bdc1-d7c57438909e', 'Feria Internacional de Libros', 'Feria literaria con autores de todo el mundo.', 'Editorial Global', 80, false, 'CULTURALES', 'a9e4288f-617e-4eb5-bf9e-b54d7b67444f'),
('7d5cd836-e399-43b4-b924-c0241d0608ff', 'Festival de Jazz', 'Concierto y festival de jazz con bandas internacionales.', 'Jazz Fest', 100, false, 'CULTURALES', 'fbff6d7a-02fe-4733-9d9d-111fe5a7acdb'),
('742c5167-720d-4b3d-9296-5429e6fbb6b2', 'Partido de Fútbol', 'Partido de fútbol de la liga local.', 'Fútbol Club Local', 70, false, 'DEPORTES', '54e8098a-c33e-4404-82cc-f5a6e441f69a'),
('ec26c385-28cf-40f0-b8ea-c609c4b4dbfd', 'Caminata Solidaria', 'Evento de caminata para recaudar fondos para causas sociales.', 'Causas Solidarias', 100, false, 'DEPORTES', 'ce2ed453-6047-48ec-96ea-8b22edb96f42'),
('45f11c0e-5502-4d55-bfe9-0ac2d59d2803', 'Maratón Internacional', 'Maratón con corredores de todo el mundo.', 'Maratón Global', 100, false, 'DEPORTES', '3abed347-22f3-4b8a-9287-b69402e9dfb7'),
('3c64ff92-b4e3-4a3b-9e22-2a0e8d9a137b', 'Torneo de Rugby', 'Competencia de rugby entre equipos internacionales.', 'Federación Internacional de Rugby', 70, false, 'DEPORTES', 'a2b39e5e-9715-4cf0-a7a3-4c5152b9f1f9'),
('ba99b3e9-c24e-44cc-91c9-846d07c5bff5', 'Conferencia sobre Blockchain', 'Evento académico sobre tecnología blockchain y sus aplicaciones.', 'Crypto Academy', 100, false, 'ACADEMICOS', 'eb28138f-d7d1-4ea9-a38f-bd4e68f72b3f'),
('517e65ea-7c7e-40ad-b9b5-b34271e21388', 'Exposición de Arte Moderno', 'Exposición de arte moderno con artistas emergentes.', 'Galería Arte Moderno', 200, true, 'CULTURALES', null),
('a21a40c7-9f82-44f7-b2d3-e9abca7253f0', 'Concurso de Fotografía', 'Concurso de fotografía con premios para los mejores trabajos.', 'Fotografía Internacional', 50, true, 'CULTURALES', null),
('462feb5e-d0a2-459a-ae9e-b72289ed774f', 'Torneo de Videojuegos', 'Competencia de videojuegos en diversos géneros.', 'Gamers League', 50, true, 'ENTRETENIMIENTO', null),
('e2cdd4ac-d6f8-4e74-9b79-c5f7133027a3', 'Festival de Música Electrónica', 'Festival de música electrónica con DJ internacionales.', 'Electronic Beats', 90, true, 'ENTRETENIMIENTO', null),
('edabf476-c6a0-46fd-b5e6-322568fd1265', 'Gala de Beneficencia', 'Evento benéfico para recaudar fondos para organizaciones sin fines de lucro.', 'Charity Events', 40, true, 'OTROS', null),
('337d2145-e8d9-4012-83f2-50128907294d', 'Expo de Automóviles', 'Exposición de los últimos modelos de automóviles.', 'Auto Expo', 40, true, 'OTROS', null),

('a1e11111-aaaa-1aaa-1aaa-bbbbbbbb0001', 'Conferencia sobre IA', 'Charla sobre avances en inteligencia artificial', 'admin', 100, false, 'ACADEMICOS', 'occ1-0000-aaaa-bbbb-000000000001'),
('c3e33333-cccc-3ccc-3ccc-dddddddd0003', 'Festival de Cine Independiente', 'Proyección de cortos y largometrajes', 'admin', 80, false, 'ENTRETENIMIENTO', 'occ3-0000-cccc-dddd-000000000003'),
('e5e55555-eeee-5eee-5eee-ffffeeee0005', 'Charla de Desarrollo Web', 'Introducción a tecnologías modernas de desarrollo web', 'admin', 40, false,'ACADEMICO', 'occ5-0000-eeee-ffff-000000000005'),
('g7e77777-gggg-7ggg-7ggg-hhhhhhhh0007', 'Feria Cultural Internacional', 'Stands con comida, arte y costumbres del mundo', 'admin', 90, false, 'CULTURALES', 'occ7-0000-gggg-hhhh-000000000007'),

('h8e88888-hhhh-1hhh-5hhh-iiiiiiii0008', 'Taller de Ilustración Digital', 'Aprende a crear ilustraciones en tablet', 'admin', 30, true, 'CULTURALES', null),
('i9e99999-iiii-2iii-6iii-jjjjjjjj0009', 'Campeonato Relámpago de Ajedrez', 'Competencia rápida en formato eliminatorio', 'admin', 16, true, 'DEPORTES', null),
('j0e00000-jjjj-3jjj-7jjj-kkkkkkkk0010', 'Encuentro de Startups', 'Red de networking para emprendedores', 'admin', 60, true, 'ACADEMICOS', null),
('k1e11112-kkkk-4kkk-8kkk-llllllll0011', 'Maratón de Series', 'Jornada de binge-watching colaborativo', 'admin', 50, true, 'ENTRETENIMIENTO', null);
