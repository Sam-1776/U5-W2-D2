package samuelesimeone.esercizio.services;


import org.springframework.stereotype.Service;
import samuelesimeone.esercizio.entities.Autore;
import samuelesimeone.esercizio.entities.BlogPost;
import samuelesimeone.esercizio.exceptions.NotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class AutoriService {

    Random rdm = new Random();
    List<Autore> autores = new ArrayList<>();

    public List<Autore> getAll(){
        return this.autores;
    }

    public Autore save(Autore autore){
        autore.setId(rdm.nextLong(1, 100000));
        autore.setAvatar("https://ui-avatars.com/api/?name=" + autore.getNome() + "+" + autore.getCognome());
        autore.setDataDiNascita(generateData());
        autores.add(autore);
        return autore;
    }

    public Autore findById(long id){
        Autore found = null;
        for (Autore Autore : this.autores) {
            if (Autore.getId() == id) {
                found = Autore;
            }
        }
        if (found == null) {
            throw new NotFoundException(id);
        }else {
            return found;
        }
    }

    public Autore update(long id, Autore autoreUp){
        autoreUp.setAvatar("https://ui-avatars.com/api/?name=" + autoreUp.getNome() + "+" + autoreUp.getCognome());
        autoreUp.setDataDiNascita(generateData());
        Autore found = findById(id);
        found.setNome(autoreUp.getNome());
        found.setCognome(autoreUp.getCognome());
        found.setEmail(autoreUp.getEmail());
        found.setDataDiNascita(autoreUp.getDataDiNascita());
        found.setAvatar(autoreUp.getAvatar());
        return found;
    }

    public void delete(long id){
        Iterator<Autore> autoreIterator = this.autores.iterator();
        while (autoreIterator.hasNext()){
            Autore current = autoreIterator.next();
            if (current.getId() == id) {
                autoreIterator.remove();
            }
        }
    }

    public LocalDate generateData (){

        int year = rdm.nextInt(1990,2006);
        int month = rdm.nextInt(12) + 1;
        int maxDay = LocalDate.of(year, month, 1).lengthOfMonth();
        int day = rdm.nextInt(maxDay) + 1;

        LocalDate randomDate = LocalDate.of(year, month, day);

        return randomDate;
    }
}
