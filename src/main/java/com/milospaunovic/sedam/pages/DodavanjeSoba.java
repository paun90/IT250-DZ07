
package com.milospaunovic.sedam.pages;

import com.milospaunovic.sedam.entities.Soba;
import com.milospaunovic.sedam.services.SobaDao;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;


public class DodavanjeSoba {
    
    @Property
    private Soba soba;
    
    @Property
    private Soba onesoba;
    
    @Inject
    private SobaDao sobaDao;
    
    @Property
    private ArrayList<Soba> listaSoba;
    
    void onActivate(){
        if (listaSoba == null){
            listaSoba = new ArrayList<Soba>();
        }
        listaSoba = (ArrayList<Soba>) sobaDao.getListaSvihSoba();
    }
    
    @CommitAfter
    Object onSuccess(){
        sobaDao.dodajSobu(soba);
        return this;
    }
    
    @CommitAfter
    Object onActionFromDelete(int id) {
        sobaDao.obrisiSobu(id);
        return this;
    }
    
}
