package me.dio.coding.votacao.bbb.api.repository;

import me.dio.coding.votacao.bbb.api.model.ParametroModel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repositório da parametrização da votação
 */
public interface ParametroRepository extends MongoRepository<ParametroModel, String> {
}
