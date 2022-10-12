create
database Student;
use
Student;
create table class
(
    id   int not null auto_increment primary key,
    name varchar(255)
);
create table students
(
    id           int not null auto_increment primary key,
    name         varchar(255),
    birthday     date,
    address      varchar(255),
    phone        varchar(255),
    email        varchar(255),
    classroom_id int,
    foreign key (classroom_id) references class (id)
)
