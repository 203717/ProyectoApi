import {useEffect, useState} from "react";
import Forms from "./Forms";
import Tabla from "./Tabla";


//const urlGet = 'http://localhost:18080/listDuenos'
const urlGet = 'http://localhost:18080/duenoMascota'
const urlPostAdd = 'http://localhost:18080/dueno/add'
const urlPut = 'http://localhost:18080/dueno/update'
const urlDel = 'http://localhost:18080/dueno/delete'


const Dueños = () => {
    const [datos, setData] = useState([])
    const [edit,setEdit] = useState(null)


    const addDueno = (dat) => {

        const peticion = {
            method: 'POST',
            body: JSON.stringify(dat),
            headers: {
                "Content-type": "application/json"
            }
        }
        post(peticion)
    }

    const updateDueno = (dat) => {
        const peticion = {
            method: 'PUT',
            body: JSON.stringify(dat),
            headers: {
                "Content-type": "application/json"
            }
        }
        put(peticion)
    }

    const deleteDueno = (dat) => {
        const peticion = {
            method: 'DELETE',
            body: JSON.stringify(dat),
            headers: {
                "Content-type": "application/json"
            }
        }
        del(peticion)
    }


    useEffect(() => {
        get()
    }, []);

    const post = async (peticion)  => {
        const dato = await fetch(urlPostAdd,peticion)
        get()
    }

    const get = async ()  => {
        const dato = await fetch(urlGet)
        const duenos =   await dato.json()
        setData(duenos)
    }

    const put = async (peticion)  => {
        const dato = await fetch(urlPut,peticion)
        get()
    }

    const del = async (peticion)  => {
        const dato = await fetch(urlDel,peticion)
        get()
    }

    return(
        <div>
            <Forms addDueno={addDueno} updateDueno={updateDueno}   edit={edit}   setEdit={setEdit} setData={setData} ></Forms>

            <Tabla datos={datos}   setd={setEdit} del={deleteDueno}  ></Tabla>

        </div>
    )
}

export default Dueños;