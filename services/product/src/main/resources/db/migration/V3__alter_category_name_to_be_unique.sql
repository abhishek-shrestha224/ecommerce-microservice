alter table category
  add constraint unique_category_name unique (name);

alter table category
  alter column name set not null;