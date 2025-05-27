DROP TABLE `tree`;

CREATE TABLE `tree`
(
    `id`             INTEGER PRIMARY KEY AUTO_INCREMENT,
    `unique_species` VARCHAR(255) UNIQUE NOT NULL,
    `type`           enum ('DECIDUOUS','EVERGREEN'),
    `colour`         VARCHAR(255)
)