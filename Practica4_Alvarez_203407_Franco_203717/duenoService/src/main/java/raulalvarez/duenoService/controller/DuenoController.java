package raulalvarez.duenoService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import raulalvarez.duenoService.model.Dueno;
import raulalvarez.duenoService.model.DuenoMascota;
import raulalvarez.duenoService.model.Mascota;
import raulalvarez.duenoService.repository.DuenoRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class DuenoController {

    @Autowired
    DuenoRepository duenoRepository;

    @Autowired
    RestTemplate restTemplate;

    @CrossOrigin
    @GetMapping(value = "/listDuenos")
    public List<Dueno> getListaDuenos(){
        return duenoRepository.findAll();
    }

    @CrossOrigin
    @PostMapping(value = "/{duenoId}")
    public Dueno getDueno(@PathVariable("duenoId") int duenoId){

        return duenoRepository.findByDuenoId(duenoId);
    }

    @CrossOrigin
    @PostMapping(value = "/dueno/add")
    public Dueno addDueno(@RequestBody Dueno dueno){
        return duenoRepository.save(dueno);
    }


    @CrossOrigin
    @PutMapping(value = "/dueno/update")
    public Dueno updateDueno(@RequestBody Dueno dueno) {
        Dueno d = duenoRepository.findByDuenoId(dueno.getDuenoId());
        if (d != null) {
            d.setNombre(dueno.getNombre());
            d.setDireccion(dueno.getDireccion());
            d.setTelefono(dueno.getTelefono());
            return duenoRepository.save(d);
        }
        return null;
    }

    @CrossOrigin
    @DeleteMapping(value = "/dueno/delete")
    public Boolean deleteDueno(@RequestBody Dueno dueno){
        Dueno d = duenoRepository.findByDuenoId(dueno.getDuenoId());
        if(d!=null){
            duenoRepository.delete(d);
            return true;
        }
        return null;
    }

    @CrossOrigin
    @GetMapping(value = "/duenoMascota")
    public List<DuenoMascota> getListDuenosM(){

        DuenoMascota[] listD = restTemplate.getForObject(
            "http://localhost:18080/listDuenos",
                DuenoMascota[].class);

            Mascota[] m =  restTemplate.getForObject(
            "http://localhost:28080/listMascota",
                Mascota[].class);

        for (int i =0;i<listD.length;i++){
            for (int j = 0;j<m.length;j++){
                if(m[j]!=null){
                    if (listD[i].getDuenoId() == m[j].getDuenoId()){
                        ArrayList<Mascota> aux = new ArrayList<>();
                        if(listD[i].getMascotas()==null){
                            aux.add(m[j]);
                        }else {
                            aux = listD[i].getMascotas();
                            aux.add(m[j]);
                        }
                        listD[i].setMascotas(aux);
                        m[j]=null;
                    }
                }
                }
            if(i == (listD.length-1)){
                return Arrays.asList(listD);
            }
        }
        List<DuenoMascota> d = Arrays.asList(listD);

    return d;

    }

}
