DROP TABLE IF EXISTS movies;

CREATE TABLE users (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  occupation VARCHAR(255) NOT NULL UNIQUE,
  PRIMARY KEY(id)
);

INSERT INTO users (name, occupation) VALUES ("田中", "医者");
INSERT INTO users (name, occupation) VALUES ("小松", "小学校教諭");
INSERT INTO users (name, occupation) VALUES ("佐藤", "SE");
INSERT INTO users (name, occupation) VALUES ("木村", "農家");
INSERT INTO users (name, occupation) VALUES ("平野", "ダンサー");
INSERT INTO users (name, occupation) VALUES ("高橋", "歌手");
INSERT INTO users (name, occupation) VALUES ("久保", "YouTuber");
