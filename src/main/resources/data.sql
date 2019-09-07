insert into funcao(nome) values('ADMINISTRADOR');
insert into funcao(nome) values('USUARIO_COMUM');

insert into papel(descricao,funcao_id) values('Lider de equipe',1);
insert into papel(descricao,funcao_id) values('Analista de negócio',1);
insert into papel(descricao,funcao_id) values('Consultor',1);
insert into papel(descricao,funcao_id) values('Atendimento ao público',2);
insert into papel(descricao,funcao_id) values('Técnico de suporte TI',2);

insert into usuario(nome,cpf,data_nascimento,genero,funcao_id) values('Roberto Carlos','20292656084','1975-09-02','MASCULINO',1);
insert into usuario(nome,cpf,data_nascimento,genero,funcao_id) values('Paulinho da Viola','22893527051','1988-02-25','MASCULINO',2);
insert into usuario(nome,cpf,data_nascimento,genero,funcao_id) values('Maria Betânea','23446009060','1990-05-12','FEMININO',2);
insert into usuario(nome,cpf,data_nascimento,genero,funcao_id) values('Paulinho Moscka','87333825060','1976-07-18','MASCULINO',2);
