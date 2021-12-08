import {useEffect, useState} from "react";
import Forms from "./Forms";
import Tabla from "./Tabla";


//const urlGet = 'http://localhost:18080/listDuenos'
const urlGet = 'http://localhost:38080/listaMascotas'
const urlPostAdd = 'http://localhost:38080/tipo/add'
const urlPut = 'http://localhost:38080/tipo/update'
const urlDel = 'http://localhost:38080/tipo/delete'


const Tipo = () => {
    const [datos, setData] = useState([])
    const [edit,setEdit] = useState(null)


    const addTipo = (dat) => {

        const peticion = {
            method: 'POST',
            body: JSON.stringify(dat),
            headers: {
                "Content-type": "application/json"
            }
        }
        post(peticion)
    }

    const updateTipo = (dat) => {
        const peticion = {
            method: 'PUT',
            body: JSON.stringify(dat),
            headers: {
                "Content-type": "application/json"
            }
        }
        put(peticion)
    }

    const deleteTipo = (dat) => {
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
    }, [datos]);

    const post = async (peticion)  => {
        const dato = await fetch(urlPostAdd,peticion)
        get()
    }

    const get = async ()  => {
        const dato = await fetch(urlGet)
        const tipos =   await dato.json()
        setData(tipos)
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
            <Forms addTipo={addTipo} updateTipo={updateTipo} edit={edit} setEdit={setEdit} setData={setData} ></Forms>

            <Tabla datos={datos}   setd={setEdit} del={deleteTipo}  ></Tabla>

        </div>
    )
}

export default Tipo;