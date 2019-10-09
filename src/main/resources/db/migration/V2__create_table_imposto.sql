create table imposto
(
  id           serial primary key       not null,
  tipo         varchar,
  valor        decimal                  not null,
  vencimento   date                     not null,
  empresa_cnpj varchar                  not null,
  created_at   timestamp with time zone not null,
  updated_at   timestamp with time zone,

  constraint fk_empresa_cnpj foreign key (empresa_cnpj) references empresa (cnpj) on delete cascade on update cascade
)
