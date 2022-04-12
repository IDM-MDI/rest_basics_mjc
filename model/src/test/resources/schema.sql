DROP DATABASE IF EXISTS Gift_Certificates_Test;

CREATE DATABASE IF NOT EXISTS Gift_Certificates_Test;

USE Gift_Certificates_Test;

-- -----------------------------------------------------
-- Table Gift_Certificates_Test.tags
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tags
(
    id       BIGINT UNSIGNED AUTO_INCREMENT,
    name VARCHAR(42) NOT NULL,
    deleted          TINYINT        NULL,
    PRIMARY KEY (id)
    );

-- -----------------------------------------------------
-- Table Gift_Certificates_Test.gift_certificates
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS gift_certificates
(
    id               BIGINT UNSIGNED AUTO_INCREMENT,
    name             VARCHAR(42)            NOT NULL,
    description      TEXT(300),
    price            DECIMAL(8, 2) UNSIGNED NOT NULL,
    duration         SMALLINT UNSIGNED      NOT NULL,
    create_date      DATE            NOT NULL,
    last_update_date DATE            NOT NULL,
    deleted          TINYINT        NULL,
    PRIMARY KEY (id)
    );

-- -----------------------------------------------------
-- Table Gift_Certificates_Test.gift_certificates_tags
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS gift_tags
(
    id                  BIGINT UNSIGNED AUTO_INCREMENT,
    gift_id BIGINT UNSIGNED,
    tag_id              BIGINT UNSIGNED,
    deleted          TINYINT        NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (gift_certificate_id) REFERENCES Gift_certificates (id),
    FOREIGN KEY (tag_id) REFERENCES Tags (id)
    );