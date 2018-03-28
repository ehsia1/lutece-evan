
--
-- Structure for table enroll_project
--

DROP TABLE IF EXISTS enroll_project;
CREATE TABLE enroll_project (
id_project int(6) NOT NULL,
name varchar(50) default '' NOT NULL,
email varchar(50) default '' NOT NULL,
phone varchar(50) default '' NOT NULL,
PRIMARY KEY (id_project)
);
