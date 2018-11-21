package beans;

public class CartaoDePonto {
    private Integer horaEntrada, horaSaida;

    public CartaoDePonto() {
        horaEntrada = 0;
        horaSaida = 0;
    }

    public CartaoDePonto(Integer horaEntrada, Integer horaSaida) {
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    public void setHoraEntrada(Integer horaEntrada) {
        if(horaEntrada >= 0 && horaEntrada <= 23) {
            this.horaEntrada = horaEntrada;
        }
    }

    public void setHoraSaida(Integer horaSaida) {
        this.horaSaida = horaSaida;
    }
    public Integer getHoraSaida() {
        return this.horaSaida;
    }

    public Integer getHoraEntrada(){
        return this.horaEntrada;
    }


    public Double getSalario(Double salarioBase) {
        int horas = getHoraSaida() - getHoraEntrada();
        if(horas > 8) {
            return (8 * salarioBase) + ((horas - 8) * (salarioBase * 1.5));
        }
        return (horas * salarioBase);
    }

}
