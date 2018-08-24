package me.afal.jaxb.dir;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;

import me.afal.jaxb.bank.BankLoader;
import me.afal.jaxb.spring.annotation.Log;

public class DirectoryScanner {

    private BankLoader bankLoader;

    @Log
    private Logger LOG;

    public void scan() {
        Path dirPath = Paths.get( str );
    }
}
