package janethmorales.mascotas.controller;

import janethmorales.mascotas.model.*;
import janethmorales.mascotas.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
public class MascotaController {

    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    RestTemplate restTemplate;

    //Se conecta a API
    @CrossOrigin
    @GetMapping(value = "/list")
    public List<Mascota> getlistaMascota(){
        Mascota [] mascotas = restTemplate.getForObject(
                "http://localhost:18080/listMascota", Mascota[].class);
        List<Mascota> lm = Arrays.asList(mascotas);
        return lm;
    }

    @CrossOrigin
    @GetMapping(value = "/listMascota")
    public List<Mascota> getListMascota(){
        return mascotaRepository.findAll();
    }


    @CrossOrigin
    @PostMapping(value = "/{mascotaId}")
    public Mascota getMascota(@PathVariable("mascotaId") int mascotaId){
        return mascotaRepository.findByMascotaId(mascotaId);
    }

    @CrossOrigin
    @PostMapping(value = "/mascota/tipo/{tipoId}")
    public Mascota getMascotTipo(@PathVariable("tipoId") int tipoId ){
        return mascotaRepository.findByTipoId(tipoId);
    }


    @CrossOrigin
    @PostMapping(value = "/mascota/add")
    public Mascota addMascota(@RequestBody Mascota mascota){
        return mascotaRepository.save(mascota);
    }


    @CrossOrigin
    @GetMapping(value = "/duenoMascota")
    public List<MascotaDueno> getListMascotaC(){

        MascotaDueno[] listM = restTemplate.getForObject(
                "http://localhost:28080/listMascota",
                MascotaDueno[].class);

        Dueno[] d =  restTemplate.getForObject(
                "http://localhost:18080/listDuenos",
                Dueno[].class);

        for (int i =0;i<listM.length;i++){
            for (int j = 0;j<d.length;j++){

                if(d[j]!=null){

                    if (listM[i].getDuenoId() == d[j].getDuenoId()){
                        Dueno aux = null;

                        if(listM[i].getDueno() == null){
                            aux = d[j];
                        }
                        listM[i].setDueno(aux);
                    }

                }
            }
        }

        List<MascotaDueno> m = Arrays.asList(listM);
        return m;
    }


    @CrossOrigin
    @PutMapping(value = "/mascota/update")
    public Mascota updateMedicamento(@RequestBody Mascota mascota){
        Mascota m = mascotaRepository.findByMascotaId(mascota.getMascotaId());
        if(m!=null){
           m.setNombre(mascota.getNombre());
           m.setRazon(mascota.getRazon());
           m.setFecha(mascota.getFecha());
           m.setDuenoId(mascota.getDuenoId());
           m.setTipo(mascota.getTipo());

            return mascotaRepository.save(m);
        }
        return null;
    }

    @CrossOrigin
    @DeleteMapping(value = "/mascota/delete")
    public Boolean deleteMedicamento(@RequestBody Mascota mascota){
        Mascota m = mascotaRepository.findByMascotaId(mascota.getMascotaId());
        if(m!=null){
            mascotaRepository.delete(m);
            return true;
        }
        return null;
    }


}
