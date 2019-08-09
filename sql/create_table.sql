-- 类型表
create table type(
  id smallint not null ,
  name varchar(60) not null ,
  en varchar(60) not null ,
  sort smallint default(0),
  pid smallint default(0),
  status boolean default(1)
);

create index type_name on type(name);