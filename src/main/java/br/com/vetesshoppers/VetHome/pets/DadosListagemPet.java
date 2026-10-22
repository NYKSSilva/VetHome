package br.com.vetesshoppers.VetHome.pets;

import br.com.vetesshoppers.VetHome.pets.especie.Especie;

public record DadosListagemPet(
        String nome,
        Especie especie,
        String raca
) {
    public  DadosListagemPet(Pet pet){
        this(pet.getNome(), pet.getEspecie(), pet.getRaca());
    }
}
