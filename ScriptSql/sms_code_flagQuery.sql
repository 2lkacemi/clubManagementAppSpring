-- -----------------------------------------------------------------------------
-- - Construction de la table des utilisateurs                                  ---
-- -----------------------------------------------------------------------------
CREATE TABLE `t_member` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`last_name` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`joinDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`member_email` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`member_tel` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`gender` ENUM('M','F') NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`promo` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`member_password` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	PRIMARY KEY (`id`) USING BTREE
)


CREATE TABLE t_cell (
   `id` INT(10) NOT NULL AUTO_INCREMENT,
   `cell_name`        VARCHAR(50) NOT NULL,
   `cell_description`	 VARCHAR(250),
    PRIMARY KEY (`id`) USING BTREE
);
