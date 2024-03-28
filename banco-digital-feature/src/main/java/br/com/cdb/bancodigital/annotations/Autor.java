package br.com.cdb.bancodigital.annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Autor {
    String nome();
    
}
