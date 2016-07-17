DROP TABLE game IF EXISTS;
DROP TABLE player IF EXISTS;

CREATE TABLE player(
       id INTEGER IDENTITY PRIMARY KEY,
       name VARCHAR(30) NOT NULL
);

CREATE TABLE game(
       id INTEGER IDENTITY PRIMARY KEY,
       playerid INTEGER NOT NULL REFERENCES player(id),
       score INTEGER NOT NULL,
       playedAt TIMESTAMP DEFAULT NOW
);

INSERT INTO player(name) VALUES('Bernd');
INSERT INTO player(name) VALUES('Ulf');

INSERT INTO game(playerid, score) VALUES(1, 9000);
