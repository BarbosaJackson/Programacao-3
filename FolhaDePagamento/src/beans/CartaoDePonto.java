package beans;

public class CartaoDePonto {
    private Integer horaEntrada, horaSaida, week;

    public CartaoDePonto() {
        horaEntrada = 0;
        horaSaida = 0;
        week = 0;
    }

    public CartaoDePonto(Integer horaEntrada, Integer horaSaida, Integer week) {
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.week = week;
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

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Double getSalario(Double salarioBase) {
        int horas = getHoraSaida() - getHoraEntrada();
        if(horas > 8) {
            return (8 * salarioBase) + ((horas - 8) * (salarioBase * 1.5));
        }
        return (horas * salarioBase);
    }

}
