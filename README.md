# PetCare System

## Status do Projeto
Em desenvolvimento

## Descrição
O **PetCare System** é um sistema desktop desenvolvido para pequenas clínicas veterinárias e pet shops. Ele substitui as anotações em papel por um sistema informatizado que organiza o cadastro de clientes, pets e o agendamento de consultas, trazendo mais agilidade para a rotina do estabelecimento.

## Objetivo do Software
Facilitar a gestão diária de uma clínica veterinária, permitindo que recepcionistas e veterinários cadastrem clientes e seus animais, além de agendar consultas de forma simples, rápida e organizada, com os dados armazenados de forma segura em banco de dados.

## Tecnologias Utilizadas
- **Java** — linguagem de programação
- **Java Swing** — construção da interface gráfica desktop
- **NetBeans IDE** — ambiente de desenvolvimento
- **MySQL** — banco de dados
- **JDBC (MySQL Connector/J)** — conexão entre a aplicação Java e o banco de dados
- **Git / GitHub** — versionamento e hospedagem do código

## Funcionalidades do Sistema
- **RF01 – Cadastro de Clientes:** cadastro de clientes com nome, CPF e telefone.
- **RF02 – Cadastro de Pets:** cadastro de animais vinculados a um cliente (dono).
- **RF03 – Agendamento de Consultas:** agendamento de consultas informando cliente, pet, data e valor.

## Regras de Negócio
- **RN01:** todo pet precisa estar associado a um cliente (dono).
- **RN02:** não é possível agendar consulta para uma data que já passou.
- **RN03:** o valor da consulta deve ser maior que zero.

## Time de Desenvolvedores
- Leonardo — Desenvolvedor

---
Projeto Integrador — Curso Técnico em Desenvolvimento de Sistemas (Senac)
