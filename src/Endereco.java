public record Endereco(String cep, String logradouro, String bairro, String localidade, String uf) {

    @Override
    public String toString() {
        return "Endereco {" +
                "cep: " + cep + ", logradouro: " + logradouro + ", bairro: " + bairro +
                ", localidade: " + localidade + ", uf: " + uf + " }";
    }
}
