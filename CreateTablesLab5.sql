DROP TABLE GAME;
DROP TABLE PLAYER;
DROP TABLE PLAYERANDGAME;
--1
CREATE TABLE GAME(
    game_id int Generated Always as Identity,
    game_title varchar(30),
    CONSTRAINT PK_Game PRIMARY KEY (game_id)
);
--2
CREATE TABLE PLAYER(
    player_id int Generated Always as Identity,
    first_name varchar(20),
    last_name varchar(20),
    address varchar(20),
    postal_code varchar(20),
    province varchar(15),
    phone_number varchar(20),    
    CONSTRAINT PK_Player PRIMARY KEY (player_id)
);
--3
CREATE TABLE PlayerAndGame(
    player_game_id int Generated Always as Identity,
    player_id int,
    game_id int,
    playing_date date,
    score int,    
    CONSTRAINT PK_player_game PRIMARY KEY (player_game_id),
    CONSTRAINT FK_Game FOREIGN KEY (game_id)
    REFERENCES GAME(game_id),    
    CONSTRAINT FK_Player FOREIGN KEY (player_id)
    REFERENCES player(player_id)
); 
/*
--Select queries
select * from player;
select * from game;
select * from PlayerAndGame;

select pg.player_game_id, p.first_name,p.last_name, p.address,p.postal_code,p.province,p.phone_number,
g.game_title, pg.playing_date, pg.score
from playerandgame pg join player p on pg.player_id = p.player_id
join game g on pg.game_id= g.game_id;
*/

COMMIT;