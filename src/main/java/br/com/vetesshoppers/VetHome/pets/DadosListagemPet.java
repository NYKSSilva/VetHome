package br.com.vetesshoppers.VetHome.pets;


public record DadosListagemPet(
        String nome,
        String especie,
        String raca
) {
    public  DadosListagemPet(Pet pet){
        this(pet.getNome(), pet.getEspecie(), pet.getRaca());
    }
}
