INSERT INTO CATEGORY(id, name) VALUES (1, 'Eurogames');
INSERT INTO CATEGORY(id, name) VALUES (2, 'Ameritrash');
INSERT INTO CATEGORY(id, name) VALUES (3, 'Familiar');

INSERT INTO AUTHOR(id, name, nationality) VALUES (1, 'Alan R. Moon', 'US');
INSERT INTO AUTHOR(id, name, nationality) VALUES (2, 'Vital Lacerda', 'PT');
INSERT INTO AUTHOR(id, name, nationality) VALUES (3, 'Simone Luciani', 'IT');
INSERT INTO AUTHOR(id, name, nationality) VALUES (4, 'Perepau Llistosella', 'ES');
INSERT INTO AUTHOR(id, name, nationality) VALUES (5, 'Michael Kiesling', 'DE');
INSERT INTO AUTHOR(id, name, nationality) VALUES (6, 'Phil Walker-Harding', 'US');

INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (1, 'On Mars', '14', 1, 2);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (2, 'Aventureros al tren', '8', 3, 1);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (3, '1920: Wall Street', '12', 1, 4);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (4, 'Barrage', '14', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (5, 'Los viajes de Marco Polo', '12', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (6, 'Azul', '8', 3, 5);

INSERT INTO CLIENT(id, name) VALUES (1, 'Guillermo');
INSERT INTO CLIENT(id, name) VALUES (2, 'Sheila');
INSERT INTO CLIENT(id, name) VALUES (3, 'Pedro');
INSERT INTO CLIENT(id, name) VALUES (4, 'Federico');
INSERT INTO CLIENT(id, name) VALUES (5, 'Ester');

INSERT INTO LENDING(id, game_id, client_id, begin_date, end_date) VALUES (1, 1, 1, '2023-09-03', '2023-09-15');
INSERT INTO LENDING(id, game_id, client_id, begin_date, end_date) VALUES (2, 6, 3, '2023-10-11', '2023-10-13');
INSERT INTO LENDING(id, game_id, client_id, begin_date, end_date) VALUES (3, 2, 5, '2023-01-22', '2023-01-30');
INSERT INTO LENDING(id, game_id, client_id, begin_date, end_date) VALUES (4, 4, 2, '2023-03-13', '2023-03-18');
INSERT INTO LENDING(id, game_id, client_id, begin_date, end_date) VALUES (5, 3, 4, '2023-06-07', '2023-06-17');
INSERT INTO LENDING(id, game_id, client_id, begin_date, end_date) VALUES (6, 5, 1, '2023-09-17', '2023-09-20');

