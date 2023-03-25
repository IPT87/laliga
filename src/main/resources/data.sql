INSERT INTO roles (id, role)
values
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO users (id, username, email, password, is_subscribed)
VALUES
    (1, 'Ivo', 'ivo@example.com', '$2a$10$YelHxdnNur5Wc3MKWuYA6OQGGTARcX1ub9z7F0Ty/5Tlm/80loZhi', true);


INSERT INTO users_roles (user_entity_id, roles_id)
VALUES
    (1, 1),
    (1, 2);

INSERT INTO stadiums (id, name, city, year_of_construction, capacity, photo_url)
VALUES
    (1, 'Santiago Bernabeu', 'Madrid', 1947, 81044, '/images/santiago-bernabeu.jpg'),
    (2, 'Spotify Camp Nou Barcelona', 'Barcelona', 1957, 99354, '/images/campNou.jpg'),
    (3, 'Civitas Metropolitano', 'Madrid', 2017, 68456, '/images/wanda.jpg'),
    (4, 'Benito Villamarín', 'Sevilla', 1929, 59378, '/images/benito.jpg'),
    (5, 'San Mamés', 'Bilbao', 2013, 53289, '/images/sanMames.jpg'),
    (6, 'Mestalla', 'Valencia', 1923, 48600, '/images/mestalla.jpg'),
    (7, 'Ramón Sánchez-Pizjuán', 'Sevilla', 1958, 43883, '/images/ramonSanchez.jpg'),
    (8, 'Reale Arena', 'San Sebastian', 1993, 39313, '/images/reale.jpg'),
    (9, 'Abanca Balaídos', 'Vigo', 1928, 29000, '/images/balaidos.jpg'),
    (10, 'El Sadar', 'Pamplona', 1967, 23576, '/images/sadar.jpg');
