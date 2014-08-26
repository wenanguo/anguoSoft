/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2014/8/8 17:03:59                            */
/*==============================================================*/


drop table if exists crm_customer;

drop table if exists crm_customer_type;

drop table if exists crm_employees_shop;

drop table if exists crm_message_info;

drop table if exists crm_message_send;

/*==============================================================*/
/* Table: crm_customer                                          */
/*==============================================================*/
create table crm_customer
(
   id                   int not null auto_increment comment '编号.',
   name                 varchar(100) comment '姓名.',
   phone                varchar(100) comment '电话.',
   sex                  int comment '性别.',
   email                varchar(100) comment '邮箱地址.',
   memo                 varchar(500) comment '备注.',
   employees_type_id    int comment '所属类型.',
   shop_id              int comment '所属店铺.',
   is_blacklist         int comment '是否黑名单.',
   blacklist_memo       varchar(500) comment '黑名单备注.',
   state                int comment '状态.',
   operate_user_id      int comment '创建人.',
   operate_dt           datetime comment '创建时间.',
   primary key (id)
);

alter table crm_customer comment '客户表';

/*==============================================================*/
/* Table: crm_customer_type                                     */
/*==============================================================*/
create table crm_customer_type
(
   id                   int not null auto_increment comment '编号.',
   shop_id              int comment '所属店铺.',
   name                 varchar(100) comment '名称.',
   level                int comment '星级.',
   memo                 varchar(500) comment '描述.',
   state                int comment '状态.',
   operate_user_id      int comment '创建人.',
   operate_dt           datetime comment '创建时间.',
   primary key (id)
);

alter table crm_customer_type comment '客户类型表';

/*==============================================================*/
/* Table: crm_employees_shop                                    */
/*==============================================================*/
create table crm_employees_shop
(
   id                   int not null auto_increment comment '编号.',
   emp_id               int comment '员工编号.',
   shop_id              int comment '店铺编号.',
   state                int comment '状态.',
   operate_user_id      int comment '创建人.',
   operate_dt           datetime comment '创建时间.',
   primary key (id)
);

alter table crm_employees_shop comment '员工店铺对应表';

/*==============================================================*/
/* Table: crm_message_info                                      */
/*==============================================================*/
create table crm_message_info
(
   id                   int not null auto_increment comment '编号.',
   title                varchar(100) comment '标题.',
   message_type         int comment '类型.',
   emergency_degree     int comment '紧急度.',
   content              longtext comment '内容.',
   state                int comment '状态.',
   operate_user_id      int comment '创建人.',
   operate_dt           datetime comment '创建时间.',
   primary key (id)
);

alter table crm_message_info comment '信息表';

/*==============================================================*/
/* Table: crm_message_send                                      */
/*==============================================================*/
create table crm_message_send
(
   id                   int not null auto_increment comment '编号.',
   receiver_id          int comment '收件人编号.',
   message_info_id      int comment '信息编号.',
   is_read              int comment '阅读状态.',
   state                int comment '状态.',
   operate_user_id      int comment '创建人.',
   operate_dt           datetime comment '创建时间.',
   primary key (id)
);

alter table crm_message_send comment '信息发送表';

