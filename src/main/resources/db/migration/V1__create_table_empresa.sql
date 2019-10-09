create table empresa
(

  cnpj         varchar primary key      not null,
  razao_social varchar,
  created_at   timestamp with time zone not null,
  updated_at   timestamp with time zone

);

INSERT INTO empresa (cnpj, razao_social, created_at)
VALUES ('20182807000108', 'Contabilizei Tecnologia', current_timestamp);