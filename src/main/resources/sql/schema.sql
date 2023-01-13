create table exercice
(
    id          bigint not null,
    description varchar(255),
    difficuly   varchar(255),
    name        varchar(255),
    primary key (id)
);

create table muscle
(
    id        bigint not null,
    body_part varchar(255),
    image     varchar(255),
    name      varchar(255),
    primary key (id)
);

create table relation_exercice_muscle
(
    muscle_id                 bigint not null,
    exercice_id               bigint not null,
    pourcentage_participation double,
    primary key (muscle_id, exercice_id)
);
alter table relation_exercice_muscle
    add constraint FKarax669dvn0brb2enag3l46qk
        foreign key (exercice_id)
            references exercice;

alter table relation_exercice_muscle
    add constraint FKcards2tybryj8tq9n365jt6xx
        foreign key (muscle_id)
            references muscle;

create table user
(
    id             bigint       not null,
    age            varchar(255),
    email          varchar(255),
    gender         varchar(255),
    initial_exp_id varchar(255),
    lastname       varchar(255),
    lvl            varchar(255),
    name           varchar(255),
    password       varchar(255),
    premium        varchar(255),
    taille         varchar(255),
    user_code      varchar(255) not null,
    primary key (id)
);
