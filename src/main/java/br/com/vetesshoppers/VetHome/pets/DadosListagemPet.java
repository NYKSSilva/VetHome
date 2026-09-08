package br.com.vetesshoppers.VetHome.pets;


import br.com.vetesshoppers.VetHome.pets.convenio.Convenio;
import br.com.vetesshoppers.VetHome.pets.especie.Especie;

import java.time.LocalDateTime;

public record DadosListagemPet(
        String nome,
        Especie especie,
        String raca,
        Convenio convenio
) {
    public  DadosListagemPet(Pet pet){
        this(pet.getNome(), pet.getEspecie(), pet.getRaca(), pet.getConvenio());
    }
}
