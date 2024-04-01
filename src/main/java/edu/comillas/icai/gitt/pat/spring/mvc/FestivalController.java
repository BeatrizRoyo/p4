package edu.comillas.icai.gitt.pat.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController


@RequestMapping("/api/festivales")
public class FestivalController {

    private final FestivalRepository festivalRepository;

    @Autowired
    public FestivalController(FestivalRepository festivalRepository) {
        this.festivalRepository = festivalRepository;
    }

    // Obtener todos los festivales
    @GetMapping
    public List<Festival> getAllFestivales() {
        return festivalRepository.findAll();
    }

    // Obtener un festival por ID
    @GetMapping("/{id}")
    public ResponseEntity<Festival> getFestivalById(@PathVariable Long id) {
        Festival festival = festivalRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Festival no encontrado con el id: " + id));
        return ResponseEntity.ok(festival);
    }



    // Crear un nuevo festival
    @PostMapping
    public ResponseEntity<Festival> createFestival(@RequestBody Festival festival) {
        Festival savedFestival = festivalRepository.save(festival);
        return new ResponseEntity<>(savedFestival, HttpStatus.CREATED);
    }


    // Actualizar un festival existente
    @PutMapping("/{id}")
    public ResponseEntity<Festival> updateFestival(@PathVariable Long id, @RequestBody Festival festivalDetails) {
        Optional<Festival> festivalOptional = festivalRepository.findById(id);
        if (festivalOptional.isPresent()) {
            Festival existingFestival = festivalOptional.get();
            existingFestival.setNombre(festivalDetails.getNombre());
            existingFestival.setCiudad(festivalDetails.getCiudad());
            existingFestival.setRangoEdad(festivalDetails.getRangoEdad());
            existingFestival.setFecha(festivalDetails.getFecha());
            existingFestival.setDuracion(festivalDetails.getDuracion());
            existingFestival.setTipoMusica(festivalDetails.getTipoMusica());
            Festival updatedFestival = festivalRepository.save(existingFestival);
            return ResponseEntity.ok(updatedFestival);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    // Eliminar un festival
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFestival(@PathVariable Long id) {
        if (!festivalRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        festivalRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
