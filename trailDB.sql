DROP database trail_app;
CREATE database IF NOT EXISTS trail_app;
USE trail_app;

CREATE table IF NOT EXISTS trails (
id int not null auto_increment,
name varchar(30) not null,
trailhead_gps varchar(20),
mt_county varchar(20),
miles double,
primary key(id)
);