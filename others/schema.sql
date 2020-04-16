create table persistent_logins 
(username varchar(64) not null,
series varchar(64) primary key, 
token varchar(64) not null, 
last_used timestamp not null
) ENGINE=InnoDB DEFAULT charset=UTF-8;

CREATE TABLE medicine_role_user(
    id int(11) PRIMARY KEY auto_increment COMMENT '主键',
    login_name varchar(32) NOT NULL COMMENT '登录名',
    `password` VARCHAR(32) NOT NULL COMMENT '密码',
    `status` int(4) not null DEFAULT 0 COMMENT '状态：0-正常；1-关闭',
    create_time BIGINT not null DEFAULT (UNIX_TIMESTAMP()*1000) COMMENT '创建时间',
    update_time BIGINT not null DEFAULT (UNIX_TIMESTAMP()*1000) COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT charset=utf8 COMMENT '账号表';

CREATE TABLE medicine_role(
    id INT(11) PRIMARY KEY auto_increment COMMENT '角色id',
    role_name VARCHAR(16) not null COMMENT '角色',
    description VARCHAR(32) default null COMMENT '角色描述',
    `status` int(4) not null DEFAULT 0 COMMENT '状态：0-正常；1-关闭',
    parent_id INT(11) COMMENT '上级角色id',
    create_time BIGINT not null DEFAULT (UNIX_TIMESTAMP()*1000) COMMENT '创建时间',
    update_time BIGINT not null DEFAULT (UNIX_TIMESTAMP()*1000) COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT charset=utf8 COMMENT '角色表';

CREATE TABLE medicine_role_source(
    id INT(11) PRIMARY KEY auto_increment COMMENT '资源id',
    source_name VARCHAR(32) not null COMMENT '资源名称',
    url VARCHAR(256) DEFAULT null COMMENT '资源地址',
    source_value VARCHAR(256) DEFAULT null COMMENT '资源值',
    `status` int(4) not null DEFAULT 0 COMMENT '状态：0-正常；1-关闭',
    parent_id INT(11) COMMENT '上级角色id',
    create_time BIGINT not null DEFAULT (UNIX_TIMESTAMP()*1000) COMMENT '创建时间',
    update_time BIGINT not null DEFAULT (UNIX_TIMESTAMP()*1000) COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT charset=utf8 COMMENT '角色资源表';

CREATE TABLE medicine_role_user_relation(
    id INT(11) PRIMARY KEY auto_increment COMMENT '主键',
    user_id INT(11) not null COMMENT '账户id',
    role_id INT(11) not null COMMENT '角色id'
) ENGINE=InnoDB DEFAULT charset=utf8 COMMENT '账户角色关系表';

CREATE TABLE medicine_role_source_relation(
    id INT(11) PRIMARY KEY auto_increment COMMENT '主键',
    role_id INT(11) not null COMMENT '角色id',
    source_id INT(11) not null COMMENT '资源id'
) ENGINE=InnoDB DEFAULT charset=utf8 COMMENT '角色资源关系表';