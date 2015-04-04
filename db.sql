DROP DATABASE IF EXISTS `cm`;
CREATE DATABASE `cm`;
USE `cm`;

CREATE TABLE `users`(
	id INT AUTO_INCREMENT NOT NULL,
	username VARCHAR(30) NOT NULL,
	password VARCHAR(25) NOT NULL,
	email VARCHAR(30) NOT NULL,

	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `singers`(
	singer_id INT AUTO_INCREMENT NOT NULL,
	singer_name VARCHAR(30) NOT NULL,
	singer_comment TEXT,

	PRIMARY KEY (singer_id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `albums`(
	album_id INT AUTO_INCREMENT NOT NULL,
	album_name VARCHAR(30) NOT NULL,
	album_comment TEXT,
	singer_id INT,

	PRIMARY KEY (album_id),
	CONSTRAINT `albums_singers_singer_id_fk` FOREIGN KEY (`singer_id`) REFERENCES `singers` (`singer_id`) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `songs`(
	song_id INT AUTO_INCREMENT NOT NULL,
	song_title VARCHAR(30) NOT NULL,
	song_year CHAR(4),
	song_comment VARCHAR(255),
	song_url VARCHAR(255),

	duration SMALLINT DEFAULT 0,
	emotion TINYINT DEFAULT 0,

	singer_id INT DEFAULT 1,
	album_id INT DEFAULT 1,

	PRIMARY KEY (song_id),
	CONSTRAINT `songs_singers_singer_id_fk` FOREIGN KEY (`singer_id`) REFERENCES `singers` (`singer_id`) ON DELETE CASCADE,
	CONSTRAINT `songs_albums_album_id_fk` FOREIGN KEY (`album_id`) REFERENCES `albums` (`album_id`) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE `users_songs`(
	user_id INT NOT NULL,
	song_id INT NOT NULL,
	
	PRIMARY KEY (user_id, song_id),
	CONSTRAINT `us_users_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
	CONSTRAINT `us_songs_song_id_fk` FOREIGN KEY (`song_id`) REFERENCES `songs` (`song_id`) ON DELETE CASCADE
)ENGINE=InnoDB;

INSERT INTO singers VALUES (NULL, "UNKNOWN", "UNKNOWN"); /* 未知歌手 */
INSERT INTO albums  VALUES (NULL, "UNKNOWN", "UNKNOWN", 1); /* 未知专辑 */
