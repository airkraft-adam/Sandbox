CREATE SCHEMA `db_example` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
CREATE USER 'springuser'@'%' IDENTIFIED BY 'ThePassword';

GRANT ALL PRIVILEGES ON db_example.* TO 'springuser'@'%';

FLUSH PRIVILEGES;
