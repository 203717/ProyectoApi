import {useEffect, useState} from "react";
import Forms from "./Forms";
import Tabla from "./Tabla";


const cit = [
    {
        citaId:1,
        hora: "10:10",
        servicio: "vacunacion",
        fecha: "10/20/2020",
        mascotaId:1
    },
    {
        citaId:2,
        hora: "20:10",
        servicio: "desparasitación",
        fecha: "90/20/2090",
        mascotaId:3
    },
    {
        citaId:3,
        hora: "09:10",
        servicio: "vacunacion",
        fecha: "11/10/2050",
        mascotaId:4
    },
    {
        citaId:4,
        hora: "05:10",
        servicio: "corte de pelo",
        fecha: "10/20/2020",
        mascotaId:2
    }
];


const Cita = () => {
    const [datos, setData] = useState(cit)
    const [edit,setEdit] = useState(null)

    const addCita = (dat) => {
        dat.citaId = Date.now();
        console.log(dat)
        setData([...datos,dat]);
    }

    const updateCita = (dat) => {
     let aux = datos.map(item => item.citaId === dat.citaId ? dat : item)
      setData(aux)
    }

    const deleteCita = (datId) => {
        let aux = datos.filter(item => item.citaId !== datId)
        setData(aux)
    }

    return(
        <div>
            <Forms addCita={addCita} updateCita={updateCita}   edit={edit}   setEdit={setEdit} setData={setData} ></Forms>
            <Tabla datos={datos}   setd={setEdit} del={deleteCita}  ></Tabla>
        </div>
    )
}

export default Cita;