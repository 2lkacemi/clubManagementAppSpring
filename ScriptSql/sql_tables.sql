-- ------------------------------------------------------------------------------
-- - Reconstruction de la base de données                                     ---
-- ------------------------------------------------------------------------------

DROP DATABASE IF EXISTS sms_codesi;
CREATE DATABASE sms_codesi;
USE sms_codesi;

-- -----------------------------------------------------------------------------
-- - Construction de la table des utilisateurs                                  ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_user (
    idUser         INT          		PRIMARY KEY AUTO_INCREMENT,
    firstName         VARCHAR(20)      NOT NULL,
    lastName			 VARCHAR(20)		NOT NULL,
    joinDate          DATETIME     		NOT NULL DEFAULT CURRENT_TIMESTAMP,
    email             VARCHAR(50)  		NOT NULL,
    phoneNum          VARCHAR(20)  		NOT NULL,
    gender            ENUM('M','F')		NOT NULL,
    promo				 VARCHAR(20)      NOT NULL, 
    passwordUser	 VARCHAR(50)		NOT NULL
);

INSERT INTO T_user () 
VALUES ( 245, 'anas', 'elka',  NOW(), 'anas.elk@gmail.com', '0690457173', 'M','2023', '123456');

SELECT * FROM T_user;
		
TRUNCATE TABLE t_member;	

insert into t_member (member_email, first_name, gender, last_name, member_type, member_password, promo, member_tel) 
VALUES ("anas@esi.com", "elka", "m", "elkace", "admin", "13456", "2023", "069045111");
-- ---------------------------------------------------------------------------------------------
-- - Construction de la table des menbres qui sont des admins et des managers des cellules  ----
-- ---------------------------------------------------------------------------------------------

ALTER TABLE t_member
ADD member_type ENUM('memberDto', 'admin', 'superAdmin');
-- --------------------------------------------------------------------------- --
-- - Construction de la table cellule                                     - --
-- --------------------------------------------------------------------------- --

CREATE TABLE t_cell (
    cell_id           int          NOT NULL REFERENCES t_member(cell_id),
    cell_name          VARCHAR(50) NOT NULL,
    cell_description	 VARCHAR(250)
);



-- ------------------------------------------------------------------------------
-- - Reconstruction de la base de données                                     ---
-- ------------------------------------------------------------------------------

DROP DATABASE IF EXISTS sms_codesi;
CREATE DATABASE sms_codesi;
USE sms_codesi;

-- -----------------------------------------------------------------------------
-- - Construction de la table des utilisateurs                                  ---
-- -----------------------------------------------------------------------------
CREATE TABLE `t_member` (
	`member_id` INT(10) NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`last_name` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`joinDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`member_email` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`member_tel` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`gender` ENUM('M','F') NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`promo` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`member_password` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`cell_id` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	
	PRIMARY KEY (`member_id`) USING BTREE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
AUTO_INCREMENT=4
;
