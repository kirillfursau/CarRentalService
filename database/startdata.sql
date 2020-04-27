create schema car_rental_service;
USE car_rental_service;

create table customer
(
    id            bigint      not null,
    first_name    varchar(25) not null,
    second_name   varchar(25) not null,
    date_of_birth date        not null,
    sex           int         not null comment '0 — undefined
1 — male
2 — female',
    phone_number  int         not null,
    country       varchar(30) not null,
    city          varchar(30) not null,
    street        varchar(30) not null,
    building      varchar(5)  not null,
    apartment     varchar(3)  null,
    passport_id   varchar(25) not null,
    constraint customer_pk
        primary key (id)
);


create table passport
(
    passport_id          varchar(25) not null,
    date_of_issue        date        not null,
    expiry_date          date        not null,
    place_of_birthday    varchar(30) not null,
    country_of_residence varchar(30) not null
);

create unique index passport_passport_id_uindex
    on passport (passport_id);

alter table customer
    add constraint customer_fk
        foreign key (passport_id) references passport (passport_id);

create table car_class
(
    class             varchar(15) not null,
    transmission_type boolean     null comment 'true - automatic
false - manual',
    air_conditioning  boolean     null,
    constraint car_class_pk
        primary key (class)

);
create table car
(
    id                    bigint      not null,
    registered_car_number varchar(7)  not null,
    body_number           varchar(15) not null,
    engine_type           varchar(10) not null,
    year_of_issue         date        not null,
    brand                 varchar(10) not null,
    model                 varchar(15) not null,
    mileage               int         not null,
    price_auto            int         not null,
    rental_day_price      int         not null,
    car_class             varchar(15) not null,
    constraint car_pk
        primary key (id)

);
alter table car
    add constraint car_class_fk
        foreign key (car_class) references car_class (class);

create unique index car_body_number_uindex
    on car (body_number);

create unique index car_registered_car_number_uindex
    on car (registered_car_number);

create table rental_information
(
    id            bigint not null,
    date_of_issue date   not null,
    rental_time   int    not null,
    return_date   date   not null,
    car_id        bigint not null,
    customer_id   bigint not null,
    rental_price  int    not null,
    constraint rental_information_pk
        primary key (id)
);
alter table rental_information
    add constraint rental_information_customer_fk
        foreign key (customer_id) references customer (id);
alter table rental_information
    add constraint rental_information_car_fk
        foreign key (car_id) references car (id);

create table `pick-up_location`
(
    id       bigint         not null,
    country  varchar(30) not null,
    city     varchar(30) not null,
    street   varchar(30) not null,
    building varchar(5)  not null,
    constraint `pick-up_location_pk`
        primary key (id)
);

create table `car_pick-up_location`
(
    id                 bigint not null,
    car                bigint not null,
    `pick-up_location` bigint    not null,
    constraint `car_pick-up_location_pk`
        primary key (id)
);
alter table `car_pick-up_location`
    add constraint `car_pick-up_location_car_fk`
        foreign key (car) references car (id);
alter table `car_pick-up_location`
    add constraint `car_pick-up_location_location_fk`
        foreign key (`pick-up_location`) references `pick-up_location` (id);





