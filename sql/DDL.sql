CREATE TABLE chat_record(
   id INTEGER primary key,
  from_user varchar(96),
   to_user varchar(96),
   msg varchar(1096),
   create_time timestamp not null default (datetime('now','localtime'))
);
