package br.com.vetesshoppers.VetHome.pets;


import java.time.LocalDate;

public record DadosListagemPet(
        Long id,
        String nome,
        String especie,
        String sexo,
        Double peso,
        LocalDate dataNasc,
        String raca
) {
    public DadosListagemPet(Pet pet) {
        this(pet.getId(), pet.getNome(), pet.getEspecie(), pet.getSexo(),
                pet.getPeso(), pet.getData_nasc(), pet.getRaca());
    }
}
