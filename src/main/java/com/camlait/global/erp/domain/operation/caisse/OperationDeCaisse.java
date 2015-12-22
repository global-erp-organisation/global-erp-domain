package com.camlait.global.erp.domain.operation.caisse;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.camlait.global.erp.domain.config.GlobalAppConstants;
import com.camlait.global.erp.domain.operation.Operation;

@Entity
public class OperationDeCaisse extends Operation {

    @ManyToOne
    @JoinColumn(name = GlobalAppConstants.AUTO_ID_NOTATION,updatable=false,insertable=false)
    private JournalCaisse journal;

    public JournalCaisse getJournal() {
        return journal;
    }

    public void setJournal(JournalCaisse journal) {
        this.journal = journal;
    }

    public OperationDeCaisse() {

    }
}
