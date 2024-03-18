-- EVENTOS
DROP TABLE IF EXISTS `eventos`;

CREATE TABLE `eventos` (
  `id_evento` int(11) NOT NULL AUTO_INCREMENT,
   `nombre` varchar(45) NOT NULL,
  `descripcion_corta` varchar(60) NOT NULL,
  `descripcion_extendida` varchar(200) NOT NULL,
  `foto` varchar(100) NOT NULL,
  `fecha` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `precio` float(10) NOT NULL,
  `musica` varchar(25) NOT NULL,
  `normas` varchar(150) NOT NULL,
  `id_sala` int(11) NOT NULL,
  PRIMARY KEY (`id_evento`),
  FOREIGN KEY (`id_sala`) REFERENCES `sala`(`id_sala`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `sala`;

CREATE TABLE `sala` (
  `id_sala` int(11) NOT NULL AUTO_INCREMENT,
   `nombre` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `tipo_recinto` varchar(20) NOT NULL,
  `aforo` int(10) NOT NULL,
  PRIMARY KEY (`id_sala`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT INTO sala (nombre, ciudad, direccion, tipo_recinto, aforo) VALUES
('Pacha Barcelona', 'Barcelona', 'Passeig Marítim', 'Discoteca', 1000),
('Joy Eslava', 'Madrid', 'Calle Arenal', 'Discoteca', 800),
('Opium Barcelona', 'Barcelona', 'Passeig Marítim', 'Discoteca', 1500),
('Fabrik', 'Madrid', 'Avenida de la Industria', 'Discoteca', 5000),
('Sala Apolo', 'Barcelona', 'Carrer Nou de la Rambla', 'Discoteca', 900),
('Amnesia Ibiza', 'Ibiza', 'Carretera de Ibiza a San Antonio', 'Discoteca', 5000),
('Kapital', 'Madrid', 'Calle de Atocha', 'Discoteca', 3000),
('Privilege Ibiza', 'Ibiza', 'Carrer de les Alzines', 'Discoteca', 10000),
('Razzmatazz', 'Barcelona', 'Carrer dels Almogàvers', 'Discoteca', 3000),
('Sala But', 'Madrid', 'Calle Barceló', 'Discoteca', 1000);

INSERT INTO eventos (nombre, descripcion_corta, descripcion_extendida, foto, fecha, hora, precio, musica, normas, id_sala) VALUES
('Fiesta ElectroShock', '¡No te pierdas la mejor fiesta de música electrónica!', 'Únete a nosotros en una noche llena de ritmos electrónicos y emociones intensas.', 'electroshock.jpg', '2024-04-15', '22:00', 20.00, 'Electrónica', 'Prohibido el acceso a menores de 18 años.', 1),
('Noche de Reggaeton', '¡Ven a bailar los mejores éxitos de reggaeton toda la noche!', 'Una noche llena de perreo intenso y buen ambiente.', 'reggaeton.jpg', '2024-04-20', '23:00', 15.00, 'Reggaeton', 'Prohibida la entrada con bebidas de fuera.', 2),
('Fiesta House Vibes', 'Disfruta de los mejores beats house en nuestra sala.', 'Una experiencia única llena de ritmos envolventes y buen rollo.', 'housevibes.jpg', '2024-04-22', '22:30', 18.00, 'House', 'Se ruega respetar el dress code.', 3),
('Noche de Techno Underground', '¡Sumérgete en el mundo del techno underground más genuino!', 'Una velada única llena de sonidos oscuros y atmósfera underground.', 'techno.jpg', '2024-04-25', '23:00', 15.00, 'Techno', 'No se permite el acceso con drogas o sustancias ilegales.', 4),
('Salsa Night', '¡Ven a bailar salsa hasta el amanecer!', 'Una noche llena de ritmos latinos y sabor caribeño.', 'salsa.jpg', '2024-04-30', '22:00', 12.00, 'Salsa', 'Abierto a todos los públicos.', 5),
('Fiesta Flamenco Fusion', '¡Disfruta de la fusión de flamenco con otros ritmos!', 'Una noche mágica llena de pasión y energía flamenca.', 'flamenco.jpg', '2024-05-05', '21:30', 20.00, 'Flamenco', 'Se ruega evitar el uso de flash durante el espectáculo.', 6),
('Noche de Hip-Hop', '¡Ven a disfrutar de los mejores éxitos del hip-hop!', 'Una noche llena de ritmos urbanos y buena vibra.', 'hiphop.jpg', '2024-05-10', '23:00', 15.00, 'Hip-Hop', 'Prohibido el acceso con armas u objetos punzantes.', 7),
('Rock Night', '¡Disfruta de los clásicos del rock en nuestra sala!', 'Una noche llena de energía y buen rollo al ritmo del mejor rock.', 'rock.jpg', '2024-05-15', '22:00', 18.00, 'Rock', 'Prohibido fumar en la pista de baile.', 8),
('Noche de Bachata', '¡Ven a bailar bachata con nosotros!', 'Una noche llena de romanticismo y buen ambiente.', 'bachata.jpg', '2024-05-20', '23:00', 12.00, 'Bachata', 'Abierto a todos los públicos.', 9),
('Fiesta Indie Rock', '¡Disfruta del indie rock en nuestra sala!', 'Una noche llena de buen rollo y música alternativa.', 'indierock.jpg', '2024-05-25', '22:30', 18.00, 'Indie Rock', 'Se ruega mantener el orden y respetar a los demás asistentes.', 10);

INSERT INTO eventos (nombre, descripcion_corta, descripcion_extendida, foto, fecha, hora, precio, musica, normas, id_sala) VALUES
('Fiesta de Verano', '¡Celebra el verano con nosotros!', 'Una noche llena de música, diversión y buen ambiente para dar la bienvenida al verano.', 'fiesta_verano.jpg', '2024-07-01', '22:00', 15.00, 'Pop', 'Prohibido el acceso a menores de 18 años.', 1),
('Noche de Flamenco', '¡Disfruta de una noche flamenca!', 'Una velada llena de pasión y energía flamenca con los mejores artistas en vivo.', 'flamenco_noche.jpg', '2024-07-10', '21:00', 20.00, 'Flamenco', 'Se ruega evitar el uso de flash durante el espectáculo.', 3),
('Concierto de Rock Alternativo', '¡Ven a disfrutar del mejor rock alternativo!', 'Una noche llena de energía y buena música con bandas de rock alternativo locales.', 'rock_alternativo.jpg', '2024-07-15', '20:30', 18.00, 'Rock Alternativo', 'Prohibido fumar en la sala.', 2),
('Noche de Jazz en Vivo', '¡Déjate llevar por los ritmos del jazz!', 'Una noche llena de improvisación y buen jazz con artistas de renombre.', 'jazz_noche.jpg', '2024-07-20', '21:30', 25.00, 'Jazz', 'Se ruega mantener silencio durante las actuaciones.', 4),
('Fiesta Latina', '¡Baila al ritmo de la música latina!', 'Una noche llena de salsa, bachata y reggaeton para disfrutar al máximo.', 'fiesta_latina.jpg', '2024-07-25', '23:00', 12.00, 'Música Latina', 'Abierto a todos los públicos.', 5),
('Noche de Electrónica Underground', '¡Explora los sonidos más vanguardistas de la electrónica!', 'Una noche llena de música electrónica experimental y atmósfera underground.', 'electronica_underground.jpg', '2024-08-05', '23:30', 18.00, 'Electrónica Experimental', 'Prohibido el acceso con drogas o sustancias ilegales.', 6),
('Concierto de Pop-Rock Nacional', '¡Disfruta de los éxitos del pop-rock español!', 'Una noche llena de música en directo con las mejores bandas del panorama nacional.', 'pop_rock_nacional.jpg', '2024-08-10', '20:00', 20.00, 'Pop-Rock Español', 'Se ruega respetar el espacio de los demás asistentes.', 7),
('Noche de Hip-Hop Old School', '¡Viaja en el tiempo con los clásicos del hip-hop!', 'Una noche llena de nostalgia y buen rollo con los mejores temas del hip-hop old school.', 'hiphop_oldschool.jpg', '2024-08-15', '22:00', 15.00, 'Hip-Hop Old School', 'Prohibido el acceso con armas u objetos punzantes.', 8),
('Fiesta Indie Electrónico', '¡Descubre la fusión entre el indie y la electrónica!', 'Una noche llena de ritmos electrónicos con toques alternativos y mucha diversión.', 'indie_electronico.jpg', '2024-08-20', '22:30', 18.00, 'Indie Electrónico', 'Se ruega mantener el orden y respetar a los demás asistentes.', 9),
('Noche de Metal', '¡Sumérgete en el mundo del metal!', 'Una noche llena de distorsión y energía con las mejores bandas de metal del momento.', 'metal_noche.jpg', '2024-08-25', '21:00', 15.00, 'Metal', 'Se recomienda usar tapones para los oídos.', 10);

-- OLD VALUES FOR SALA AND EVENTOS 

INSERT INTO `sala` (`nombre`, `ciudad`, `direccion`, `tipo_recinto`, `aforo`) VALUES
('Palacio Real', 'Barcelona', 'Plaza de España 1', 'Palacio', 300),
('Jardín Encantado', 'Girona', 'Calle Mayor 12', 'Jardín', 200),
('Salón Dorado', 'Tarragona', 'Avenida del Puerto 5', 'Salón', 500),
('Mansión Misteriosa', 'Lleida', 'Calle de los Álamos 8', 'Mansión', 150),
('Bosque Encantado', 'Figueres', 'Paseo de los Tilos 20', 'Bosque', 100);

INSERT INTO `eventos` (`nombre`, `descripcion_corta`, `descripcion_extendida`, `foto`, `fecha`, `hora`, `precio`, `normas`, `id_sala`) VALUES
('Baile Real', 'Una noche de elegancia y opulencia', 'Adéntrate en un cuento de hadas en el Palacio Real con bailes, cena de gala y entretenimiento real.', 'baile_real.jpg', '2024-04-20', '19:00', 100.0, 'Se requiere vestimenta formal. Se recomiendan máscaras y trajes medievales.', 1),
('Concierto de Primavera', 'Disfruta de una velada musical', 'Únete a nosotros en el Jardín Encantado para un concierto inolvidable con artistas locales y música en vivo.', 'concierto_primavera.jpg', '2024-05-15', '20:00', 50.0, 'Trae tu propia manta y cesta de picnic. Todos los asistentes son bienvenidos.', 2),
('Gala de Caridad', 'Una noche de generosidad y solidaridad', 'Ayúdanos a recaudar fondos para causas benéficas en la Salón Dorado con una elegante gala, subastas y entretenimiento de alto nivel.', 'gala_caridad.jpg', '2024-06-30', '19:30', 150.0, 'Se requiere vestimenta de etiqueta. Se aceptan donaciones adicionales en el evento.', 3),
('Fiesta de Halloween', 'Una noche de sustos y diversión', 'Ven a la Mansión Misteriosa para una fiesta de Halloween llena de disfraces, juegos espeluznantes y sorpresas escalofriantes.', 'fiesta_halloween.jpg', '2024-10-31', '21:00', 30.0, 'Trae tu mejor disfraz y prepárate para algunos sustos. Solo para mayores de 18 años.', 4),
('Festival de las Hadas', 'Un encuentro mágico en la naturaleza', 'Únete a nosotros en el Bosque Encantado para un festival lleno de música, arte y actividades inspiradas en las criaturas mágicas.', 'festival_hadas.jpg', '2024-08-25', '16:00', 40.0, 'Viste tus mejores alas y ven a volar con nosotros. Apto para todas las edades.', 5),
('Noche de Gala', 'Una velada elegante llena de glamour y música en vivo', 'Disfruta de una noche inolvidable en el Palacio Real con música en vivo, cena de lujo y baile hasta el amanecer.', 'gala.jpg', '2024-04-20', '20:00', 80.0, 'Se requiere vestimenta formal. Los niños menores de 12 años no están permitidos.', 1),
('Concierto Acústico', 'Un concierto íntimo con artistas locales', 'Ven al Jardín Encantado y disfruta de una experiencia musical única bajo las estrellas con nuestros talentosos músicos locales.', 'concierto_acustico.jpg', '2024-05-15', '19:30', 40.0, 'Trae tu propia manta y disfruta de una noche de música relajante al aire libre.', 2),
('Feria de Artesanía', 'Descubre la creatividad de los artesanos locales', 'Explora una variedad de productos artesanales únicos en la Feria de Artesanía en el Salón Dorado. Desde joyería hasta cerámica, ¡tenemos de todo!', 'feria_artesania.jpg', '2024-06-30', '11:00', 20.0, 'Entrada gratuita para todos. Ven a apoyar a los talentosos artesanos de nuestra comunidad.', 3),
('Noche de Comedia', 'Una noche llena de risas y diversión', 'Únete a nosotros en la Mansión Misteriosa para una noche de comedia con los mejores comediantes locales e internacionales. ¡Prepárate para reír hasta llorar!', 'comedia.jpg', '2024-07-10', '21:00', 30.0, 'La entrada es solo para mayores de 18 años. Se requiere registro previo.', 4),
('Festival de Cine al Aire Libre', 'Una experiencia cinematográfica bajo las estrellas', 'Disfruta de una selección de películas clásicas y contemporáneas en el Bosque Encantado. Trae tu manta y únete a nosotros para una noche de cine inolvidable.', 'cine.jpg', '2024-08-25', '20:30', 25.0, 'Entrada general: 25€. Se pueden comprar entradas en línea o en el lugar del evento.', 5),
('Tarde de Té y Música', 'Una tarde relajante con té y música en vivo', 'Únete a nosotros en el Palacio Real para una tarde de té y música clásica. Relájate y disfruta de la música mientras saboreas una variedad de deliciosos pasteles y bocadillos.', 'te.jpg', '2024-09-15', '16:00', 35.0, 'Se requiere reserva anticipada. Plazas limitadas disponibles.', 1),
('Exposición de Arte Contemporáneo', 'Descubre las últimas tendencias en arte contemporáneo', 'Explora una emocionante exhibición de obras de arte contemporáneo en el Jardín Encantado. Desde pintura hasta escultura, ¡te sorprenderás con nuestra colección!', 'arte.jpg', '2024-10-20', '12:00', 15.0, 'Entrada gratuita para todos. Ven a disfrutar de una tarde de arte inspirador.', 2),
('Noche de Flamenco', 'Una noche de pasión y energía española', 'Ven al Salón Dorado y déjate llevar por la pasión del flamenco con una noche llena de baile, música y emoción. ¡No te pierdas este espectáculo inolvidable!', 'flamenco.jpg', '2024-11-05', '22:00', 50.0, 'Se recomienda reservar con anticipación debido a la alta demanda. ¡Prepárate para bailar toda la noche!', 3),
('Fiesta de Navidad', 'Celebra la temporada festiva con alegría y diversión', 'Únete a nosotros en la Mansión Misteriosa para una fiesta de Navidad llena de música festiva, deliciosos aperitivos y regalos sorpresa. ¡Vístete con tu suéter navideño más feo y únete a la diversión!', 'navidad.jpg', '2024-12-20', '19:00', 40.0, 'Entrada gratuita para todos. Ven a celebrar la magia de la Navidad con nosotros.', 4),
('Noche de Blues', 'Una velada íntima con el ritmo del blues', 'Disfruta de una noche de música relajante y alma con los mejores artistas de blues en el Bosque Encantado. Trae tus amigos y únete a nosotros para una noche inolvidable.', 'blues.jpg', '2025-01-15', '20:00', 30.0, 'Entrada general: 30€. Se pueden comprar entradas en línea o en el lugar del evento.', 5),
('Desfile de Moda', 'Un desfile de moda de alta costura', 'Asiste al Palacio Real y disfruta de un deslumbrante desfile de moda con diseñadores de renombre internacional. Sé testigo de las últimas tendencias en moda.', 'desfile_moda.jpg', '2024-05-30', '18:00', 75.0, 'Entrada solo con invitación. Se requiere vestimenta elegante.', 1),
('Exposición de Fotografía', 'Una exposición de imágenes cautivadoras', 'Visita el Jardín Encantado para disfrutar de una exposición de fotografía que muestra imágenes impresionantes de paisajes, retratos y momentos cautivadores.', 'exposicion_fotografia.jpg', '2024-06-10', '11:00', 20.0, 'Entrada gratuita para todos. ¡Ven a inspirarte con estas increíbles fotografías!', 2),
('Noche de Magia', 'Una noche llena de ilusión y asombro', 'Únete a nosotros en el Salón Dorado para una noche mágica llena de trucos sorprendentes, ilusiones increíbles y risas incontrolables. ¡Prepárate para ser cautivado!', 'magia.jpg', '2024-07-20', '20:00', 35.0, 'Recomendado para todas las edades. ¡Ven y experimenta la magia!', 3),
('Feria Gastronómica', 'Una experiencia culinaria para los amantes de la comida', 'Explora una variedad de deliciosos platos y sabores en la Feria Gastronómica en la Mansión Misteriosa. Desde tapas españolas hasta platos internacionales, ¡no te pierdas esta fiesta para el paladar!', 'feria_gastronomica.jpg', '2024-08-05', '12:30', 45.0, 'Entrada general: 45€. Se incluyen muestras de comida y bebida.', 4),
('Conferencia de Ciencia y Tecnología', 'Un evento educativo para mentes curiosas', 'Participa en la Conferencia de Ciencia y Tecnología en el Bosque Encantado, donde expertos en el campo compartirán las últimas innovaciones y descubrimientos. ¡Aprende y sorpréndete!', 'conferencia_ciencia.jpg', '2024-09-15', '10:00', 30.0, 'Abierto a todos los interesados en la ciencia y la tecnología. Se recomienda registrarse con anticipación.', 5),
('Noche de Ópera', 'Una velada llena de drama y pasión', 'Disfruta de una noche de ópera en el Palacio Real con interpretaciones emocionantes de arias clásicas y actuaciones impresionantes. ¡Déjate llevar por la música y el drama!', 'opera.jpg', '2024-10-10', '19:30', 60.0, 'Se requiere vestimenta elegante. ¡Ven y disfruta de una noche de ópera inolvidable!', 1),
('Torneo de Ajedrez', 'Una competición emocionante para los aficionados al ajedrez', 'Participa en el Torneo de Ajedrez en el Jardín Encantado y demuestra tu habilidad en el tablero. ¡Compite contra otros jugadores y gana premios emocionantes!', 'ajedrez.jpg', '2024-11-20', '15:00', 25.0, 'Abierto a jugadores de todos los niveles. Se requiere inscripción previa.', 2),
('Fiesta de Fin de Año', 'Celebra la llegada del nuevo año con estilo', 'Únete a nosotros en el Salón Dorado para una fiesta de Fin de Año llena de música, baile y brindis. ¡Da la bienvenida al nuevo año en un ambiente festivo y elegante!', 'fin_ano.jpg', '2024-12-31', '21:00', 100.0, 'Se requiere vestimenta de gala. Entrada con reserva anticipada.', 3),
('Festival de Teatro al Aire Libre', 'Una noche de drama bajo las estrellas', 'Disfruta de una selección de obras de teatro emocionantes y divertidas en el Bosque Encantado. Desde clásicos hasta producciones contemporáneas.', 'teatro.jpg', '2025-01-25', '18:30', 35.0, 'Entrada general: 35€. Se pueden comprar entradas en línea o en el lugar del evento.', 5),
('Taller de Arte para Niños', 'Una actividad creativa para los más pequeños', 'Trae a tus hijos al Jardín Encantado y únete a nuestro Taller de Arte, donde podrán explorar su creatividad y hacer obras de arte divertidas y coloridas. ¡Para toda la familia!', 'taller_arte.jpg', '2025-02-10', '14:00', 15.0, 'Edades recomendadas: 5-10 años. Se requiere inscripción previa.', 2);

INSERT INTO eventos (nombre, descripcion_corta, descripcion_extendida, foto, fecha, hora, precio, musica, normas, id_sala)
VALUES
('Fiesta de Verano', '¡Celebra el verano con nosotros!', 'Una noche llena de música, diversión y buen ambiente para dar la bienvenida al verano.', 'fiesta_verano.jpg', '2024-07-01', '22:00', 15.00, 'Pop', 'Prohibido el acceso a menores de 18 años.', 1),
('Noche de Flamenco', '¡Disfruta de una noche flamenca!', 'Una velada llena de pasión y energía flamenca con los mejores artistas en vivo.', 'flamenco_noche.jpg', '2024-07-10', '21:00', 20.00, 'Flamenco', 'Se ruega evitar el uso de flash durante el espectáculo.', 3),
('Concierto de Rock Alternativo', '¡Ven a disfrutar del mejor rock alternativo!', 'Una noche llena de energía y buena música con bandas de rock alternativo locales.', 'rock_alternativo.jpg', '2024-07-15', '20:30', 18.00, 'Rock Alternativo', 'Prohibido fumar en la sala.', 2),
('Noche de Jazz en Vivo', '¡Déjate llevar por los ritmos del jazz!', 'Una noche llena de improvisación y buen jazz con artistas de renombre.', 'jazz_noche.jpg', '2024-07-20', '21:30', 25.00, 'Jazz', 'Se ruega mantener silencio durante las actuaciones.', 4),
('Fiesta Latina', '¡Baila al ritmo de la música latina!', 'Una noche llena de salsa, bachata y reggaeton para disfrutar al máximo.', 'fiesta_latina.jpg', '2024-07-25', '23:00', 12.00, 'Música Latina', 'Abierto a todos los públicos.', 5),
('Noche de Electrónica Underground', '¡Explora los sonidos más vanguardistas de la electrónica!', 'Una noche llena de música electrónica experimental y atmósfera underground.', 'electronica_underground.jpg', '2024-08-05', '23:30', 18.00, 'Electrónica Experimental', 'Prohibido el acceso con drogas o sustancias ilegales.', 6),
('Concierto de Pop-Rock Nacional', '¡Disfruta de los éxitos del pop-rock español!', 'Una noche llena de música en directo con las mejores bandas del panorama nacional.', 'pop_rock_nacional.jpg', '2024-08-10', '20:00', 20.00, 'Pop-Rock Español', 'Se ruega respetar el espacio de los demás asistentes.', 7),
('Noche de Hip-Hop Old School', '¡Viaja en el tiempo con los clásicos del hip-hop!', 'Una noche llena de nostalgia y buen rollo con los mejores temas del hip-hop old school.', 'hiphop_oldschool.jpg', '2024-08-15', '22:00', 15.00, 'Hip-Hop Old School', 'Prohibido el acceso con armas u objetos punzantes.', 8),
('Fiesta Indie Electrónico', '¡Descubre la fusión entre el indie y la electrónica!', 'Una noche llena de ritmos electrónicos con toques alternativos y mucha diversión.', 'indie_electronico.jpg', '2024-08-20', '22:30', 18.00, 'Indie Electrónico', 'Se ruega mantener el orden y respetar a los demás asistentes.', 9),
('Noche de Metal', '¡Sumérgete en el mundo del metal!', 'Una noche llena de distorsión y energía con las mejores bandas de metal del momento.', 'metal_noche.jpg', '2024-08-25', '21:00', 15.00, 'Metal', 'Se recomienda usar tapones para los oídos.', 10);

-- USUARIOS
DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
   `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  `fecha_alta` varchar(15) NOT NULL,
  PRIMARY KEY (`id_usuario`) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT INTO `usuarios` (`nombre`, `apellido`, `email`, `contrasena`, `fecha_alta`) VALUES
('Arnau', 'González', 'arnau@example.com', 'contraseña123', '2023-01-01'),
('Mireia', 'Suero', 'mireia@example.com', 'contraseña123', '2023-01-02'),
('Andrés', 'Tercero', 'andres@example.com', 'contraseña123', '2023-01-03'),
('Adrián', 'Montes', 'adrian@example.com', 'contraseña123', '2023-01-04'),
('Antonio', 'Santos', 'antonio@example.com', 'contraseña123', '2023-01-05'),
('Carlos', 'Ruiz', 'carlos@example.com', 'contraseña123', '2023-01-06'),
('Laura', 'Martínez', 'laura@example.com', 'contraseña123', '2023-01-07'),
('María', 'López', 'maria@example.com', 'contraseña123', '2023-01-08'),
('David', 'García', 'david@example.com', 'contraseña123', '2023-01-09'),
('Elena', 'Fernández', 'elena@example.com', 'contraseña123', '2023-01-10'),
('Catalina', 'García', 'catalina@example.com', 'contraseña123', '2024-01-01'),
('Xavier', 'Martínez', 'xavier@example.com', 'contraseña123', '2024-01-02'),
('Clara', 'Sánchez', 'clara@example.com', 'contraseña123', '2024-01-03'),
('Marc', 'Vidal', 'marc@example.com', 'contraseña123', '2024-01-04'),
('Elena', 'Roca', 'elena@example.com', 'contraseña123', '2024-01-05'),
('David', 'López', 'david@example.com', 'contraseña123', '2024-01-06'),
('Anna', 'Gómez', 'anna@example.com', 'contraseña123', '2024-01-07'),
('Pol', 'Fernández', 'pol@example.com', 'contraseña123', '2024-01-08'),
('Laia', 'Martínez', 'laia@example.com', 'contraseña123', '2024-01-09'),
('Pau', 'Soler', 'pau@example.com', 'contraseña123', '2024-01-10');

-- COMPRA
DROP TABLE `compra`;
CREATE TABLE `compra` (
  `id_compra` int(11) NOT NULL AUTO_INCREMENT,
   `id_usuario` int(11) NOT NULL,
  `id_evento` int(11) NOT NULL,
  `nombre_usuario` varchar(45) NOT NULL,
   `nombre_evento` varchar(45) NOT NULL,
  `precio` float(10) NOT NULL,
  `cantidad` int(10) NOT NULL,
  PRIMARY KEY (`id_compra`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

