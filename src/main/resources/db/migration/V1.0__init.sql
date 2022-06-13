create table schedule_user
(
    id           bigint auto_increment primary key,
    name         varchar(255) default null,
    address      varchar(255) default null,
    phone_number varchar(255) default null,
    role         varchar(255) default null
);

create table schedule_schedule
(
    id         bigint auto_increment primary key,
    title      varchar(255) default null,
    contents   varchar(255) default null,
    location   varchar(255) default null,
    start_date varchar(255) default null,
    end_date   varchar(255) default null,
    owner      bigint       default null
);

create table schedule_attendees
(
    schedule_id bigint not null,
    attendees   bigint default null,
    constraint schedule_schedule_fk1
        foreign key (schedule_id)
            references schedule_schedule (id)
            on delete cascade
            on update cascade
);
