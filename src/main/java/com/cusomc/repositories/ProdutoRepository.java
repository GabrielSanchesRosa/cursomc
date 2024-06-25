package com.cusomc.repositories;

import com.cusomc.domain.Categoria;
import com.cusomc.domain.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {


//    @Query("Select Distinct obj From Produto obj " +
//           "Inner Join obj.categorias cat " +
//           "Where " +
//           "obj.nome Like %:nome% and " +
//           "cat in :categorias") //Adicionar @Param("nome") e @Param("categorias")
    @Transactional(readOnly = true)
    Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);
}
