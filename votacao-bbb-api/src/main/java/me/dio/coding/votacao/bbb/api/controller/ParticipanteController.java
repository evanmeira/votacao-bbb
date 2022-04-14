package me.dio.coding.votacao.bbb.api.controller;

import lombok.AllArgsConstructor;
import me.dio.coding.votacao.bbb.api.model.ParticipanteModel;
import me.dio.coding.votacao.bbb.api.repository.ParticipanteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/participantes")
@AllArgsConstructor //LOMBOK: Dessa forma não precisa criar o constrututor com a injeção de dep. do repository
public class ParticipanteController {

    final private ParticipanteRepository participanteRepository;

    @PostMapping("/salvar")
    public ResponseEntity<ParticipanteModel> salvar(@RequestBody ParticipanteModel participante){
        ParticipanteModel participanteResult = participanteRepository.save(participante);
        return ResponseEntity.ok(participanteResult);
    }

    @GetMapping("/consultar")
    public ResponseEntity<ParticipanteModel> consultar(@RequestParam String id){
        Optional<ParticipanteModel> participanteOpt = participanteRepository.findById(id);
        if(participanteOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(participanteOpt.get());
    }
}
