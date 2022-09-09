--liquibase formatted sql

--changeset margekais:load-users
INSERT INTO `application_user`(`username`,`password_hash`,`enabled`) VALUES ('user1','$argon2id$v=19$m=4096,t=3,p=1$MWEyczNkNGY1ZzZoN2o4aw$NxVBNWtv7HM+iboEJVAfRMV0e/vCeWWuTplw4tLBicc', true);
INSERT INTO `application_user`(`username`,`password_hash`,`enabled`) VALUES ('user2','$argon2id$v=19$m=4096,t=3,p=1$NWc2aDdqOGsxYTJzM2Q0Zg$fO+9+V4HPQw+K0Kp/AeOgJAgoMYblR8u3koNnih1gUQ', true);
INSERT INTO `application_user`(`username`,`password_hash`,`enabled`) VALUES ('user3','$argon2id$v=19$m=4096,t=3,p=1$ajhrMWEyczNkNGY1ZzZoNw$4frIxlBwUM0U0jznFNKawCaVj5vNLqLmOJCUIi/3XPM', true);

--changeset margekais:load-countries
INSERT INTO `country`(`name`) VALUES ('Estonia');
INSERT INTO `country`(`name`) VALUES ('Latvia');
INSERT INTO `country`(`name`) VALUES ('Lithuania');
INSERT INTO `country`(`name`) VALUES ('Finland');
INSERT INTO `country`(`name`) VALUES ('Sweden');

--changeset margekais:load-clients
INSERT INTO `client`(`username`,`first_name`,`last_name`,`address`, `manager_id` , `country_id`) VALUES ('client_username1','Klient', 'Esimene', 'Pihla 3-22, Tartu', 1, 1);
INSERT INTO `client`(`username`,`first_name`,`last_name`,`address`, `manager_id` , `country_id`) VALUES ('client_username2','Klient', 'Teine', 'Pohla 15-33, Tallinn', 1, 1);
