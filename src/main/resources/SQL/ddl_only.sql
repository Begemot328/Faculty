drop all objects;
drop schema if exists faculty;
create schema if not exists faculty;
use faculty;

create table faculty.subject
(
    id   bigint primary key auto_increment,
    name varchar(40) not null unique
);

create table faculty.book
(
    id   bigint primary key auto_increment,
    title varchar(150) not null,
    author varchar(40) not null,
    subject_id bigint not null,
    foreign key (subject_id) references subject (id) ON DELETE CASCADE ON UPDATE CASCADE

);

create table faculty.team
(
    id         bigint primary key auto_increment,
    name       varchar(100) not null unique,
    subject_id bigint        not null,
    foreign key (subject_id) references subject (id) ON DELETE CASCADE ON UPDATE CASCADE
);

create table faculty.student
(
    id         bigint primary key auto_increment,
    first_name varchar(40) not null,
    last_name  varchar(40) not null
);

create table faculty.student_team
(
    student_id bigint,
    team_id   bigint,
    primary key (student_id, team_id),
    foreign key (student_id) references student (id) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key (team_id) references team (id) ON DELETE CASCADE ON UPDATE CASCADE
);