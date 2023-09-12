create schema `manage-student`;

use `manage-student`;

create table `manage-student`.student_subject
(
    id_student int not null,
    id_subject int not null,
    point      int null,
    primary key (id_student, id_subject)
);

create table `manage-student`.student
(
    id         int auto_increment
        primary key,
	id_address int,
    first_name varchar(250) charset utf8mb3 null,
    last_name  varchar(250) charset utf8mb3 null
);

create index student_id_index
    on `manage-student`.student (id);

create index student_subject_id_student_index
    on `manage-student`.student_subject (id_student);

create index student_subject_id_subject_index
    on `manage-student`.student_subject (id_subject);

create table `manage-student`.subject
(
    id   int auto_increment
        primary key,
    name int null,
    constraint subject_student_subject_id_subject_fk
        foreign key (id) references `manage-student`.student_subject (id_subject)
);

create index subject_id_index
    on `manage-student`.subject (id);
    
create table `manage-student`.Address
(id int auto_increment,
	name varchar(250) null,
	city varchar(50) null,
	district varchar(50) null,
	constraint Adress_pk
		primary key (id)
);
alter table student
	add constraint student_adress_id_fk
		foreign key (id_address) references Address (id);
        
