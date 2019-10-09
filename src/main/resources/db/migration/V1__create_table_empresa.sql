create table empresa
(

  cnpj         varchar primary key      not null,
  razao_social varchar,
  created_at   timestamp with time zone not null,
  updated_at   timestamp with time zone

)
