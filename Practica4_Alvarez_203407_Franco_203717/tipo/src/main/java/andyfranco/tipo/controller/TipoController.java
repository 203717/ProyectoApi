package andyfranco.tipo.controller;


import andyfranco.tipo.model.Mascota;
import andyfranco.tipo.model.Tipo;
import andyfranco.tipo.model.TipoMascota;
import andyfranco.tipo.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TipoController {

    @Autowired
    TipoRepository tipoRepository;

    @Autowired
    RestTemplate restTemplate;

        @CrossOrigin
        @GetMapping(value = "/listTipo")
        public List<Tipo> getListaTipos() {
        return tipoRepository.findAll();
    }


        @CrossOrigin
        @PostMapping(value = "/{tipoId}")
        public Tipo getTipo(@PathVariable("tipoId") int tipoId) {
            return tipoRepository.findByTipoid(tipoId);
        }


        @CrossOrigin
        @PostMapping(value = "/tipo/add")
        public Tipo addTipo(@RequestBody Tipo tipo) {
            return tipoRepository.save(tipo);
        }

        @CrossOrigin
        @GetMapping(value = "/listaMascotas")
        public List<TipoMascota> getListTipoMascota(){


            TipoMascota[] listT = restTemplate.getForObject(
                    "http://localhost:38080/listTipo",
                    TipoMascota[].class);

            Mascota[] m =  restTemplate.getForObject(
                    "http://localhost:28080/listMascota",
                    Mascota[].class);

            for (int i =0;i<listT.length;i++){
                for (int j = 0;j<m.length;j++){

                    if(m[j]!=null){
                        if (listT[i].getTipoid() == m[j].getTipo()){
                            Mascota aux = null;

                            if(listT[i].getMascota() == null){
                               aux = m[j];
                            }
                            listT[i].setMascota(aux);
                            m[j]=null;
                        }
                    }

                }
            }
            List<TipoMascota> d = Arrays.asList(listT);
            return d;
        }

        @CrossOrigin
        @PutMapping (value = "/tipo/update")
        public Tipo updateTipo(@RequestBody Tipo tipo) {
            Tipo ti = tipoRepository.findByTipoid(tipo.getTipoid());
            if (ti != null) {
                ti.setTipo(tipo.getTipo());
                ti.setCaracteristica(tipo.getCaracteristica());
                return tipoRepository.save(ti);
            }
            return null;
        }

    @CrossOrigin
    @DeleteMapping(value = "/tipo/delete")
    public Boolean deleteDueno(@RequestBody Tipo tipo){
        Tipo t = tipoRepository.findByTipoid(tipo.getTipoid());

        if(t!=null){
            tipoRepository.delete(t);
            return true;
        }
        return null;
        }
    }

