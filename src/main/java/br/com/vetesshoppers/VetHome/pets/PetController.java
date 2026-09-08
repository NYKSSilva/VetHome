package br.com.vetesshoppers.VetHome.pets;


import br.com.vetesshoppers.VetHome.repositories.PetRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente/pet")
public class PetController {

    @Autowired
    private PetRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarPet(@RequestBody DadosCadastroPet dados) {

        repository.save(new Pet(dados));
    }

    @GetMapping
    public Page<DadosListagemPet> listarPet( @PageableDefault(size=6, sort= {"nome"}) Pageable paginacao){
        return repository.findAllByIdClienteAndAtivo(paginacao)
                .map(DadosListagemPet::new);
    }

    @PutMapping
    @Transactional
    public void atualizarPet(@RequestBody @Valid DadosAtualizarPet dados) {
        var pet = repository.getReferenceById(dados.id());
        pet.atualizarPet(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirPet(@PathVariable  Long id){
        var cliente = repository.getReferenceById(id);
        cliente.excluirPet();
    }



}
