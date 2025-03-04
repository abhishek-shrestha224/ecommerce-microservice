alter table product
  alter column quantity type integer using quantity::integer;