package beans;

import java.util.ArrayList;
import java.util.List;

public class Taxas {

    List<Double> taxa;

    public Taxas() {
        taxa = new ArrayList<Double>();
    }

    public void addTaxa(Double valorTaxa) {
        taxa.add(valorTaxa);
    }

    public Double calcTaxas() {
        Double sum = 0.0;
        for(Double t : taxa) {
            sum += t;
        }
        return sum;
    }

}
