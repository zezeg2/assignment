create table post
(
    id         int auto_increment
        primary key,
    title      text        null,
    content    text        null,
    created_at timestamp   null,
    updated_at timestamp   null,
    is_notice  tinyint(1)  null,
    user_id    int         null,
    constraint post_user_id_fk
        foreign key (user_id) references user (id)
);

create table user
(
    id       int auto_increment
        primary key,
    username varchar(255) null,
    password varchar(255) null,
    is_admin tinyint(1)   null
);

insert into user (username, password, is_admin) VALUES
('admin', 'admin', true),
('user', 'user', false);

CREATE PROCEDURE loopInsert1()
BEGIN
    DECLARE i INT DEFAULT 1;

    WHILE i <= 300 DO
            INSERT INTO post (title, content, created_at, updated_at, is_notice, user_id)
            VALUES (concat('제목',i), concat('내용',i), now(), now(), true, 1);
            SET i = i + 1;
    END WHILE;
END;

CREATE PROCEDURE loopInsert2()
BEGIN
    DECLARE i INT DEFAULT 1;

    WHILE i <= 300 DO
            INSERT INTO post (title, content, created_at, updated_at, is_notice, user_id)
            VALUES (concat('제목',i), concat('내용',i), now(), now(), false, 2);
            SET i = i + 1;
        END WHILE;
END;

CALL loopInsert1;
CALL loopInsert2;

drop table post,user




