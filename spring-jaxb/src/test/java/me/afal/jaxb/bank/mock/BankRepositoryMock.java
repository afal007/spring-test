package me.afal.jaxb.bank.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import me.afal.jaxb.bank.dao.BankRepository;
import me.afal.jaxb.bank.model.Bank;

public class BankRepositoryMock implements BankRepository {

    private static Map<Long,Bank> storage = new HashMap<>();
    private static Long lastID = 1L;

    @Override
    public <S extends Bank> S save( S entity ) {
        storage.put( lastID++, entity );
        return entity ;
    }

    @Override
    public <S extends Bank> Iterable<S> saveAll( Iterable<S> entities ) {
        for ( S entity : entities ) {
            storage.put( lastID++, entity );
        }

        return entities;
    }

    @Override
    public Optional<Bank> findById( Long aLong ) {
        return Optional.ofNullable( storage.get(aLong) );
    }

    @Override
    public boolean existsById( Long aLong ) {
        return storage.containsKey( aLong );
}

    @Override
    public Iterable<Bank> findAll() {
        return storage.values();
    }

    @Override
    public Iterable<Bank> findAllById( Iterable<Long> longs ) {
        List<Bank> bankList = new ArrayList<>();
        for ( Long aLong : longs ) {
            bankList.add( storage.get( aLong ) );
        }

        return bankList;
    }

    @Override
    public long count() {
        return storage.size();
    }

    @Override
    public void deleteById( Long aLong ) {
        storage.remove( aLong );
    }

    @Override
    public void delete( Bank entity ) {
        for ( Map.Entry<Long, Bank> entry : storage.entrySet() ) {
            Long id   = entry.getKey();
            Bank bank = entry.getValue();

            if( bank.equals( entity ) ) {
                storage.remove( id );
                break;
    }   }   }

    @Override
    public void deleteAll( Iterable<? extends Bank> entities ) {
        entities.forEach( this::delete );
    }

    @Override
    public void deleteAll() {
        storage.clear();
    }

}
