package application;

import java.time.LocalDate;

class DisabledRange {

    final LocalDate initialDate;
    final LocalDate endDate;

    public DisabledRange(LocalDate initialDate, LocalDate endDate){
        this.initialDate = initialDate;
        this.endDate = endDate;
    }

    public LocalDate getInitialDate() 
    { 
    	return initialDate; 
    }
    
    public LocalDate getEndDate() 
    {
    	return endDate;
    }

}