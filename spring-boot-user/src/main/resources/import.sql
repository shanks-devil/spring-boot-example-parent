drop table if exists user_t;

CREATE TABLE user_t (user_id INT NOT NULL AUTO_INCREMENT, user_name VARCHAR(100) NULL, user_email VARCHAR(100), user_phone VARCHAR(100),PRIMARY KEY (user_id));