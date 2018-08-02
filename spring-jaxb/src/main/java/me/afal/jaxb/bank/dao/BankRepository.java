package me.afal.jaxb.bank.dao;

import org.springframework.data.repository.CrudRepository;

import me.afal.jaxb.bank.model.Bank;

public interface BankRepository extends CrudRepository<Bank, Long> {}
