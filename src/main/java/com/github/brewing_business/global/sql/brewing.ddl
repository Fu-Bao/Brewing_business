create table user
(
    idx             bigint auto_increment
        primary key,
    user_id         varchar(50)  not null,
    password        varchar(255) not null,
    role            varchar(30)  not null,
    username        varchar(255) null,
    refresh_token   varchar(225) null,
    company         varchar(225) null,
    business_number varchar(50)  null,
    agree_picu      tinyint(1)   null,
    agree_promotion tinyint(1)   null,
    created_at      datetime     null,
    deleted_at      datetime(6)  null
);

create table address
(
    idx          bigint auto_increment
        primary key,
    user_idx     bigint               not null,
    address_name varchar(30)          not null,
    receiver     varchar(30)          not null,
    phone_number varchar(30)          not null,
    address      varchar(225)         not null,
    is_default   tinyint(1) default 1 not null
);

create table product
(
    id          bigint auto_increment
        primary key,
    name        varchar(225) not null,
    description varchar(225) not null,
    price       int          not null,
    quantity    int          not null,
    category    varchar(50)  not null,
    region      varchar(50)  null,
    star_rating double       null
);

create table product_img
(
    id         bigint auto_increment
        primary key,
    img_path   varchar(225) charset utf8mb4 not null,
    product_id bigint                       not null
);