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

INSERT INTO stadiums (id, name, city, year_of_construction, capacity, photo_url, info)
VALUES
    (1, 'Santiago Bernabeu', 'Madrid', 1947, 81044, '/images/santiago-bernabeu.jpg', 'The Santiago Bernabéu Stadium (Spanish: Estadio Santiago Bernabéu) is a football stadium in Madrid, Spain. '
                                                                                     'With a current seating capacity of 81,044, it has been the home stadium of Real Madrid since its completion in 1947.'),
    (2, 'Spotify Camp Nou Barcelona', 'Barcelona', 1957, 99354, '/images/campNou.jpg', 'Since 1957, Camp Nou has been the FC Barcelona stadium and has paralleled the city’s football team in going from strength to strength.'),
    (3, 'Civitas Metropolitano', 'Madrid', 2017, 68456, '/images/wanda.jpg', 'Inaugurated in September 2017, the stadium is located in the north-east of the city, near Adolfo-Suarez Madrid Barajas Airport. In 2019 it hosted the Champions League Final between Liverpool and Tottenham Hotspur.'),
    (4, 'Benito Villamarín', 'Sevilla', 1929, 59378, '/images/benito.jpg', 'Benito Villamarín Stadium, apart from being the venue for Real Betis Balompié home fixtures, is the centre of all the Green-and-White activities. In constant evolution, the stadium has all the nowadays facilities.'),
    (5, 'San Mamés', 'Bilbao', 2013, 53289, '/images/sanMames.jpg', 'Estadio San Mamés replaced Athlétic’s old stadium with the same name, which had served the club for almost 100 years, but did not offer the facilities of modern-day stadiums.'),
    (6, 'Mestalla', 'Valencia', 1923, 48600, '/images/mestalla.jpg', 'Mestalla was ranked above other Spanish grounds such as the Camp Nou, Santiago Bernabéu and Vicente Calderón, as well as other legendary grounds like the Parc des Princes, Anfield, Allianz Arena, Old Trafford, and the Giuseppe Meazza.'),
    (7, 'Ramón Sánchez-Pizjuán', 'Sevilla', 1958, 43883, '/images/ramonSanchez.jpg', 'Christened on the 7th of September 1958 in a friendly against Real Jaén, its construction responded to the new demands of football, providing the commodities and capacities that the ancient ground of Nervión could not satisfy.'),
    (8, 'Reale Arena', 'San Sebastian', 1993, 39313, '/images/reale.jpg', 'Reale Arena is our home. Opened in 1993, the stadium, which replaced our beloved Atotxa, today hosts the first team''s home fixtures. Boasting a capacity of 32,000, the arena is soon set to undergo a makeover which will bring it in line with future plans.'),
    (9, 'Abanca Balaídos', 'Vigo', 1928, 29000, '/images/balaidos.jpg', 'Estadio Municipal de Balaídos opened in 1928 after a three-year construction period. The first match was played between Celta and Real Union on the 30th of December of that year (7-0).'),
    (10, 'El Sadar', 'Pamplona', 1967, 23576, '/images/sadar.jpg', 'Estadio El Sadar, previously also known as Estadio Reyno de Navarra, replaced Osasuna’s old Campo de San Juan. El Sadar opened on 2 September 1967 with a three-team tournament involving Osasuna, Real Zaragoza, and Portuguese side Vitoria de Setúbal.');

INSERT INTO players (id, name, last_name, date_of_birth, place_of_birth, position, photo_url, flag_url, weight, height,
                     goals, assists, shots, matches_played, minutes, starts, substitutions, fouls, penalties,
                     yellow_cards, red_cards, double_yellow_cards, team_name, team_logo_url, dorsal)
VALUES (1, 'Robert', 'Lewandowski', '21-08-1988', 'Warszawa', 'Forward', '/images/players/lewandowski.jpg', '/images/countryFlags/polandFlag.png', 81, 185, 15, 5, 72, 22,
        1772, 21, 5, 26, 0, 0, 1, 1, 'FC Barcelona', '/images/clubLogos/fcBarcelona.png', 9),
 (2, 'Karim', 'Benzema', '19-12-1987', 'Lyon', 'Forward', '/images/players/benzema.jpg', '/images/countryFlags/franceFlag.png', 81, 185, 11, 3, 54, 16,
        1396, 16, 3, 9, 5, 1, 0, 0, 'Real Madrid', '/images/clubLogos/realMadrid.png', 9),
 (3, 'Alvaro', 'Morata', '23-10-1992', 'Madrid', 'Forward', '/images/players/alvaroMorata.jpg', '/images/countryFlags/spainFlag.png', 84, 190, 10, 2, 41, 26,
        1353, 16, 14, 29, 0, 3, 0, 0, 'Atletico de Madrid', '/images/clubLogos/atleticoMadrid.jpg', 19),
 (4, 'Gerard', 'Moreno', '07-04-1992', 'Barcelona', 'Forward', '/images/players/gerardMoreno.jpg', '/images/countryFlags/spainFlag.png', 77, 180, 6, 2, 27, 16,
        1072, 13, 6, 10, 1, 3, 0, 0, 'Villarreal FC', '/images/clubLogos/villarreal.jpg', 7),
 (5, 'Robin', 'Le Normand', '11-11-1996', 'Pabu', 'Defender', '/images/players/robinLeNormand.jpg', '/images/countryFlags/franceFlag.png', 80, 187, 3, 1, 5, 23,
        1894, 21, 1, 23, 0, 4, 0, 0, 'Real Sociedad', '/images/clubLogos/realSociedad.png', 24),
 (6, 'Enes', 'Unal', '10-05-1997', 'Bursa', 'Forward', '/images/players/enesUnal.jpg', '/images/countryFlags/turkeyFlag.png', 78, 187, 13, 3, 49, 26,
        2277, 26, 12, 39, 4, 4, 0, 0, 'Getafe FC', '/images/clubLogos/getafe.png', 10),
 (7, 'Luis', 'Hernandez', '14-04-1989', 'Madrid', 'Defender', '/images/players/luisHernandez.jpg', '/images/countryFlags/spainFlag.png', 75, 183, 4, 2, 4, 24,
        2159, 24, 0, 15, 0, 4, 1, 1, 'Cadiz CF', '/images/clubLogos/cadiz.png', 23),
 (8, 'Franco', 'Cervi', '26-05-1994', 'San Lorenzo', 'Forward', '/images/players/francoCervi.jpg', '/images/countryFlags/argentinaFlag.png', 67, 165, 5, 3, 12, 25,
        1421, 16, 11, 23, 0, 0, 1, 0, 'RC Celta de Vigo', '/images/clubLogos/celtaVigo.png', 11),
 (9, 'Luiz Felipe', 'Ramos Marchi', '22-03-1997', 'Colina', 'Defender', '/images/players/luisFelipeRamos.jpg', '/images/countryFlags/italiaFlag.png', 80, 187, 7, 9, 2, 14,
        1304, 13, 2, 7, 0, 1, 3, 0, 'Real Betis Balompie', '/images/clubLogos/betis.png', 19),
 (10, 'Toni', 'Kroos', '04-01-1990', 'Greifswald', 'Midfielder', '/images/players/toniKroos.jpg', '/images/countryFlags/germanyFlag.png', 76, 183, 4, 3, 16, 21,
        1508, 18, 10, 17, 0, 0, 1, 1, 'Real Madrid', '/images/clubLogos/realMadrid.png', 10);

INSERT INTO teams (id, year_of_foundation, president, name, official_web, photo_url, matches_played, matches_to_play,
                   wins, draws, loses, points)
VALUES (1, 1957, 'Florentino Perez', 'Real Madrid', 'www.real-madrid.com', '/images/clubLogos/realMadrid.png', 26, 12, 22, 2, 2, 71),
       (2, 1957, 'Joan Laporta Estruch', 'Barcelona', 'www.barcelona.com', '/images/clubLogos/fcBarcelona.png', 26, 12, 21, 7, 3, 68),
       (3, 1957, 'Enrique Cerezo', 'Atletico Madrid', 'www.atm-fc.com', '/images/clubLogos/atleticoMadrid.jpg', 25, 11, 20, 5, 3, 67),
       (4, 1957, 'Ángel Haro García', 'Betis', 'www.betis.com', '/images/clubLogos/betis.png', 26, 12, 20, 4, 4, 62),
       (5, 1957, 'Ángel Torres Sánchez', 'Getafe', 'www.getafe.com', '/images/clubLogos/getafe.png', 25, 11, 18, 8, 4, 60),
       (6, 1957, 'Fernando Roig Alfonso', 'Villarreal', 'www.villarreal.com', '/images/clubLogos/villarreal.jpg', 26, 12, 19, 4, 5, 55),
       (7, 1957, 'Jokin Aperribay', 'Real Sociedad', 'www.r-sociedad.com', '/images/clubLogos/realSociedad.png', 25, 11, 17, 2, 6, 55),
       (8, 1957, 'Carlos Mouriño', 'Celta Vigo', 'www.celta.com', '/images/clubLogos/celtaVigo.png', 26, 12, 15, 3, 7, 53),
       (9, 1957, 'Lay Hoon Chan', 'Valencia', 'www.valencia.com', '/images/clubLogos/valencia.png', 25, 11, 19, 5, 9, 52),
       (10, 1957, 'Manuel Vizcaino Fernández', 'Cadiz', 'www.cadiz.com', '/images/clubLogos/cadiz.png', 26, 12, 14, 6, 10, 48);
