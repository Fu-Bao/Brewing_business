create table users
(
    idx             bigint auto_increment
        primary key,
    email           varchar(100) not null,
    password        varchar(255) not null,
    role            varchar(30)  not null,
    username        varchar(255) null,
    profile_img     varchar(225) null,
    description     varchar(225) null,
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
    idx            bigint auto_increment
        primary key,
    user_idx       bigint                       not null,
    receiver       varchar(30)                  not null,
    rec_phone      varchar(30)                  not null,
    address_name   varchar(30)                  not null,
    address        varchar(225)                 not null,
    address_detail varchar(100)                 null,
    zipcode        varchar(100) default '00000' not null,
    is_default     tinyint(1)                   not null
);


create table product
(
    idx         bigint auto_increment
        primary key,
    name        varchar(225) not null,
    description longtext     not null,
    price       int          not null,
    quantity    int          not null,
    category    varchar(50)  not null,
    region      varchar(50)  null,
    star_rating double       null
)
    charset = utf8mb4;



create table product_img
(
    idx         bigint auto_increment
        primary key,
    img_path    varchar(225) not null,
    product_idx bigint       null
);

create table review
(
    idx         bigint auto_increment
        primary key,
    product_idx bigint       null,
    title       varchar(225) null,
    content     varchar(225) null,
    star_rating double       null
);

create table review_img
(
    idx        bigint auto_increment
        primary key,
    review_idx bigint       null,
    img_path   varchar(225) null
);