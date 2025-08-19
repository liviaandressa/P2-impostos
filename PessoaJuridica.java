public class PessoaJuridica extends Contribuinte {
    private int funcionarios;

    public PessoaJuridica(String nome, double renda, int funcionarios) {
        super(nome, renda);
        this.funcionarios = funcionarios;
    }

    public int getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(int funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public double calculaImposto() {
        double aliquota = funcionarios > 10 ? 0.14 : 0.16;
        return getRenda() * aliquota;
    }
}
