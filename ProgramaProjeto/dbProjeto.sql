create database projeto;
use projeto;

create table funcionarios(
	funcionario_id int primary key auto_increment,
    Nome_funcionario varchar(255) not null,
    Login varchar(255) not null,
    Senha varchar(30) not null,
    Especialidade varchar(255) not null
);

create table agendamentos(
	agendamento_id int primary key auto_increment,
    horario varchar(255) not null,
    funcionario_id int,
    paciente_id int,
    foreign key(funcionario_id) references funcionarios(funcionario_id),
    foreign key(paciente_id) references pacientes(paciente_id)
);
drop table agendamentos;
create table pacientes(
	paciente_id int primary key auto_increment,
    Nome_paciente varchar(255) not null,
    Idade int not null,
    cpf int(11) not null
);

select * from pacientes;

SELECT agendamento_id, horario, pacientes.nome_paciente,funcionarios.nome_funcionario, agendamentos.funcionario_id FROM agendamentos INNER JOIN funcionarios ON agendamentos.funcionario_id=funcionarios.funcionario_id INNER JOIN pacientes on agendamentos.paciente_id=pacientes.paciente_id;

UPDATE agendamentos SET horario='8:15' WHERE agendamento_id=1;

