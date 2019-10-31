create table nota_fiscal
(
  id           serial primary key       not null,
  valor        decimal                  not null,
  data_emissao timestamp with time zone not null,
  status       varchar                  not null,
  empresa_cnpj varchar                  not null,
  created_at   timestamp with time zone not null,
  updated_at   timestamp with time zone,

  constraint fk_empresa_cnpj foreign key (empresa_cnpj) references empresa (cnpj) on delete cascade on update cascade
)
