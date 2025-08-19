public class PessoaFisica extends Contribuinte {
    private double gastosSaude;

    public PessoaFisica(String nome, double renda, double gastosSaude) {
        super(nome, renda);
        this.gastosSaude = gastosSaude;
    }

    public double getGastosSaude() {
        return gastosSaude;
    }

    public void setGastosSaude(double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    @Override
    public double calculaImposto() {
        double aliquota = getRenda() < 20000.0 ? 0.15 : 0.25;
        double deducao = gastosSaude > 0 ? gastosSaude * 0.5 : 0.0;
        return getRenda() * aliquota - deducao;
    }
}
